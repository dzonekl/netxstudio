/*******************************************************************************
 * Copyright (c) 17 dec. 2012 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.framework.console.CommandInterpreter;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.server.internal.ServerActivator;

/**
 * Holds the integrity summary of the server and actions to recover from a
 * disallowed status. The data is fetched in the background, and the summary is
 * stored.
 * 
 * 
 * <ul>
 * <li>The number of NetXResources with double entries</li>
 * <li></li>
 * <li></li>
 * </ul>
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class ServerIntegrity extends JobChangeAdapter {

	private static final ServerIntegrity self = new ServerIntegrity();

	public static final ServerIntegrity getInstance() {
		return self;
	}

	private final IntegrityJob loadingJob = new IntegrityJob();

	public ServerIntegrity() {
		ServerActivator.getInstance().getInjector().injectMembers(this);
		loadingJob.addJobChangeListener(this);
	}

	/**
	 * The Integrity Report.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class DataIntegrityReport {

		/**
		 * The last time the integrity was run. lives during Server uptime,
		 * cleared afterwards
		 */
		private Date lastRunDate;

		public DataIntegrityReport() {
			this.setLastRunDate(modelUtils.todayAndNow());
		}

		int netXResources;

		public int integrity_getNetXResources() {
			return netXResources;
		}

		public void setNetXResources(int netXResources) {
			this.netXResources = netXResources;
		}

		int values;

		public int integrity_getValues() {
			return values;
		}

		public void setValues(int values) {
			this.values = values;
		}

		private Map<NetXResource, List<Value>> duplicateValueMap = Maps
				.newHashMap();

		public Map<NetXResource, List<Value>> getDuplicateValueMap() {
			return duplicateValueMap;
		}

		/**
		 * @return
		 */
		public String integrity_getDuplicateValues() {
			StringBuffer sb = new StringBuffer();
			int sumDuplicates = 0;
			for (NetXResource res : duplicateValueMap.keySet()) {
				List<Value> list = duplicateValueMap.get(res);
				sumDuplicates += list.size();
				sb.append(" Resource("
						+ (res.getComponentRef() != null ? modelUtils
								.printModelObject(res.getComponentRef()) : "")
						+ "): " + res.getExpressionName() + " are: "
						+ list.size() + " duplicate timestamps\n");
			}
			sb.append(" total duplicates: " + sumDuplicates);
			return sb.toString();
		}

		String duration;

		public void setDuration(String timeDurationNano) {
			this.duration = timeDurationNano;
		}

		public String integrity_getDuration() {
			return duration;
		}

		public Date getLastRunDate() {
			return lastRunDate;
		}

		public void setLastRunDate(Date lastRunDate) {
			this.lastRunDate = lastRunDate;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Server integrity report for: "
					+ modelUtils.dateAndTime(this.getLastRunDate()) + "\n");

			for (Method m : this.getClass().getMethods()) {

				if (m.getName().startsWith("integrity_get")) {
					try {
						Object invoke = m.invoke(this, new Object[0]);
						sb.append("Param: "
								+ m.getName().substring(
										"integrity_get".length(),
										m.getName().length() - 1) + ", value:"
								+ invoke + "\n");
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
			return sb.toString();
		}
	}

	@Server
	@Inject
	private IDataProvider provider;

	@Inject
	private IQueryService queryService;

	@Inject
	private ModelUtils modelUtils;

	/** A result Processor which can deal with {@link CommandInterpreter} */
	private Object resultProcessor;

	private DataIntegrityReport lastProducedReport;

	// CommandInterpreter API.

	public static void reportIntegrity(CommandInterpreter interpreter) {
		self.setResultProcessor(interpreter);
		self.createIntegrityReport();
		interpreter
				.println("The report will take time to produce, it will report back here when done.");
	}

	public static void reportIntegrityProgress(CommandInterpreter interpreter) {

		if (self.loadingJob.getState() == Job.RUNNING) {
			DataIntegrityReport report = self.loadingJob.getReport();
			interpreter.println("Report production ongoing, results sofar:");
			interpreter.println(report);
		} else {
			interpreter.println("No report being produced right now");
		}
	}

	public static void reportIntegrityCancel(CommandInterpreter interpreter) {
		if (self.loadingJob.getState() == Job.RUNNING) {
			self.loadingJob.cancel();
			interpreter.println("Cancel requested");
		} else {
			interpreter.println("No report being produced right now");
		}
	}

	public static void restoreIntegrity(CommandInterpreter interpreter) {
		self.doRestoreIntegrity(interpreter);
	}

	private void setResultProcessor(Object interpreter) {
		this.resultProcessor = interpreter;

	}

	public void doRestoreIntegrity(CommandInterpreter interpreter) {
		if (lastProducedReport != null) {
			Map<NetXResource, List<Value>> duplicateValueMap = lastProducedReport
					.getDuplicateValueMap();
			// iterate and delete duplicate entries.

		}
	}

	public void createIntegrityReport() {

		DataIntegrityReport dataIntegrityReport = new DataIntegrityReport();
		populateReport(dataIntegrityReport);

	}

	private void populateReport(DataIntegrityReport dataIntegrityReport) {
		this.loadingJob.setReport(dataIntegrityReport);
		this.loadingJob.schedule(500);
	}

	public DataIntegrityReport getLastProducedReport() {
		return lastProducedReport;
	}

	/**
	 * Clears the last produced report.
	 */
	public void clearIntegrityReport() {
		this.lastProducedReport = null;
	}

	@Override
	public void done(IJobChangeEvent event) {
		super.done(event);
		if (event.getResult() == Status.OK_STATUS) {

			IntegrityJob job = (IntegrityJob) event.getJob();
			DataIntegrityReport report = job.getReport();
			this.lastProducedReport = report;

			// Can we adapt to the result processor?
			if (resultProcessor instanceof CommandInterpreter) {
				CommandInterpreter ci = (CommandInterpreter) resultProcessor;
				ci.println(report);
			}

		} else {
			// Loading failed do something.
			if (resultProcessor instanceof CommandInterpreter) {
				CommandInterpreter ci = (CommandInterpreter) resultProcessor;
				ci.println(" integrity report failed");
			}

		}

	}

	/**
	 * An Integrity analysis job.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class IntegrityJob extends Job {

		private DataIntegrityReport report = null;

		public IntegrityJob() {
			this("Check integrity");
		}

		public IntegrityJob(String name) {
			super(name);
			this.setSystem(true); // Make this a Systems job.
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			if (report == null) {
				return Status.CANCEL_STATUS;
			}
			return this.internalRun(monitor);
		}

		private IStatus internalRun(IProgressMonitor monitor) {

			CDOSession openSession = provider.openSession();

			CDOView openView = openSession.openView();

			CDOResourceNode folder = openView.getResourceNode("/Node_/");

			int sumResources = 0;
			int sumRanges = 0;
			int sumValues = 0;

			// determine the duration of the query.
			long totalTime = System.nanoTime();

			if (folder instanceof CDOResourceFolder) {
				for (CDOResourceNode n : ((CDOResourceFolder) folder)
						.getNodes()) {
					if (n instanceof CDOResource) {
						CDOResource resource = (CDOResource) n;
						// The CDO Resource will contain many NetXResource

						if (monitor.isCanceled()) {
							break;
						}

						for (int i = 0; i < resource.getContents().size(); i++) {
							EObject eo = resource.getContents().get(i);
							if (eo instanceof NetXResource) {
								NetXResource res = (NetXResource) eo;
								sumResources++;

								if (monitor.isCanceled()) {
									break;
								}

								for (MetricValueRange mvr : res
										.getMetricValueRanges()) {

									if (monitor.isCanceled()) {
										break;
									}

									sumRanges++;

									// determine the duration of the query.
									long startTime = System.nanoTime();

									// query the values for this NetXResource
									List<Value> sortedValues = queryService
											.getSortedValues(openView, mvr,
													IQueryService.QUERY_MYSQL);
									sumValues += sortedValues.size();

									// query the duplicate values for this
									// NetXResource
									List<Value> duplicates = queryService
											.getDuplicateValues(openView, mvr,
													IQueryService.QUERY_MYSQL);

									report.getDuplicateValueMap().put(res,
											duplicates);

									String timeDurationNano = modelUtils
											.timeDurationNano(startTime);

								}
							}
						}
					}
				}
			}

			report.setNetXResources(sumResources);
			report.setValues(sumValues);
			report.setDuration(modelUtils.timeDurationNano(totalTime));

			openView.close();
			provider.closeSession();

			return monitor.isCanceled() ? Status.CANCEL_STATUS
					: Status.OK_STATUS;
		}

		// private List<Value> findDuplicateTimeStamps(List<Value> sortedValues)
		// {
		// List<Value> duplicates = Lists.newArrayList();
		//
		// for (Value v : sortedValues) {
		// Iterable<Value> filter = Iterables.filter(
		// sortedValues,
		// modelUtils.new TimeStampPredicate(modelUtils
		// .fromXMLDate(v.getTimeStamp())));
		// for (Value dup : filter) {
		// duplicates.add(dup);
		// }
		// }
		// return duplicates;
		//
		// }

		public DataIntegrityReport getReport() {
			return report;
		}

		public void setReport(DataIntegrityReport report) {
			this.report = report;
		}
	}

}
