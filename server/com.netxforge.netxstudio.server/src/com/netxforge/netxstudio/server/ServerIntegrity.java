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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.server.data.Server;
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

		/** Count the quantity of {@link NetXResource} objects **/
		int netXResourceCount;

		public int integrity_getNetXResourceCount() {
			return netXResourceCount;
		}

		public void setNetXResourceCount(int netXResourceCount) {
			this.netXResourceCount = netXResourceCount;
		}

		/** Count the quantity of {@link Value} objects **/
		int valueCount;

		public int integrity_getValueCount() {
			return valueCount;
		}

		public void setValueCount(int values) {
			this.valueCount = values;
		}

		/** Count the quantity of {@link MetricValueRange} objects **/
		public int rangeCount;

		public int integrity_getRangeCount() {
			return rangeCount;
		}

		public void setRangeCount(int rangeCount) {
			this.rangeCount = rangeCount;
		}

		/**
		 * A {@link Map} of {@link NetXResource} objects holding {@link Value}
		 * objects with the same time stamps.
		 */
		private Map<MetricValueRange, List<Value>> duplicateValueMap = Maps
				.newHashMap();

		public Map<MetricValueRange, List<Value>> getDuplicateValueMap() {
			return duplicateValueMap;
		}

		/**
		 * @return
		 */
		public String integrity_getDuplicateValues() {
			StringBuffer sb = new StringBuffer();
			int sumDuplicates = 0;
			for (MetricValueRange mvr : duplicateValueMap.keySet()) {
				List<Value> list = duplicateValueMap.get(mvr);
				sumDuplicates += list.size();
				sb.append(" Value range has: " + list.size()
						+ " duplicate timestamps\n");
			}
			sb.append(sumDuplicates);
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
										m.getName().length()) + ": " + invoke
								+ "\n");
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
	private IData provider;

	@Inject
	private IQueryService queryService;

	@Inject
	private ModelUtils modelUtils;

	/** A result Processor which can deal with {@link CommandInterpreter} */
	private Object resultProcessor;

	private DataIntegrityReport lastProducedReport;

	// CommandInterpreter API.

	public static void reportIntegrityLast(CommandInterpreter interpreter) {
		if (self.getLastProducedReport() != null) {
			interpreter.println(self.getLastProducedReport());
		}
	}

	public static void reportIntegrity(CommandInterpreter interpreter) {
		reportIntegrity(interpreter, false);
	}

	public static void reportIntegrity(CommandInterpreter interpreter,
			boolean checkDuplicates) {

		if (self.loadingJob.getState() == Job.RUNNING) {
			// Bail..
			interpreter
					.println("Report already in production, specify the action 'cancel' to abort the production process");
			return;
		}

		self.setResultProcessor(interpreter);
		self.createIntegrityReport(checkDuplicates);
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

			// TODO, restore the integrity by:

			// 1. Delete duplicate entries.
			@SuppressWarnings("unused")
			Map<MetricValueRange, List<Value>> duplicateValueMap = lastProducedReport
					.getDuplicateValueMap();

		}
	}

	public void createIntegrityReport(boolean checkDuplicates) {

		DataIntegrityReport dataIntegrityReport = new DataIntegrityReport();
		populateReport(dataIntegrityReport, checkDuplicates);

	}

	private void populateReport(DataIntegrityReport dataIntegrityReport,
			boolean checkDuplicates) {
		this.loadingJob.setReport(dataIntegrityReport);
		this.loadingJob.setCheckDuplicates(checkDuplicates);
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
				ci.println(" integrity report cancelled or failed");
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

		/** Check potential duplicate {@link Value} objects */
		private boolean checkDuplicates = false;

		public IntegrityJob() {
			this("Check integrity");
		}

		public void setCheckDuplicates(boolean checkDuplicates) {
			this.checkDuplicates = checkDuplicates;

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

			List<MetricValueRange> valueRanges = Lists.newArrayList();

			// determine the duration of the query.
			long totalTime = System.nanoTime();

			// Two step process.
			// Step 1. Iterate through CDOResourceFolder -> CDResource ->
			// NetXResource -> MetricValueRange.
			// From MetricValueRange, query the Values and count.
			// Step 2. Iterate through MetricValueRange
			// From MetricValueRange, query duplicates and store in a Map.

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
								this.getReport().netXResourceCount++;

								if (monitor.isCanceled()) {
									break;
								}

								valueRanges.addAll(res.getMetricValueRanges());

								for (MetricValueRange mvr : res
										.getMetricValueRanges()) {

									if (monitor.isCanceled()) {
										break;
									}
									this.getReport().rangeCount++;

									// query the values for this NetXResource
									List<Value> sortedValues = queryService
											.mvrValues(openView, mvr,
													IQueryService.QUERY_MYSQL);
									this.getReport().valueCount += sortedValues
											.size();

									getReport().duration = modelUtils
											.timeDurationNanoFromStart(totalTime);

								}
							}
						}
					}
				}
			}

			if (checkDuplicates) {
				for (MetricValueRange mvr : valueRanges) {

					if (monitor.isCanceled()) {
						break;
					}

					getReport().duration = modelUtils
							.timeDurationNanoFromStart(totalTime);
					// query the duplicate values for this
					// NetXResource, store the values if there are duplicates.
					List<Value> duplicates = queryService.getDuplicateValues(
							openView, mvr, IQueryService.QUERY_MYSQL);

					if (!duplicates.isEmpty()) {
						getReport().getDuplicateValueMap().put(mvr, duplicates);
					}
				}
			}

			getReport().duration = modelUtils
					.timeDurationNanoFromStart(totalTime);

			openView.close();
			provider.closeSession();

			return monitor.isCanceled() ? Status.CANCEL_STATUS
					: Status.OK_STATUS;
		}

		/**
		 * Get the status of the current report.
		 * 
		 * @return
		 */
		public synchronized DataIntegrityReport getReport() {
			return report;
		}

		public void setReport(DataIntegrityReport report) {
			this.report = report;
		}
	}

}
