/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.job;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.properties.IPropertiesProvider;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.data.IServerDataProvider;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.job.internal.JobActivator;

/**
 * Represents a Quartz job, will update job results etc.
 * 
 * @author Martin Taal
 */
public class NetxForgeJob implements org.quartz.Job {

	public static final String JOB_PARAMETER = "job";

	public static final String NETXSTUDIO_MAX_JOBRUNS_QUANTITY = "netxstudio.max.jobruns.quantity"; // How
	// many
	// job
	// runs
	// to
	// keep.

	public static final int NETXSTUDIO_MAX_JOBRUNS_QUANTITY_DEFAULT = 20; // How
	// many
	// job
	// runs
	// to
	// keep.

	private static List<CDOID> runningJobs = new ArrayList<CDOID>();

	private Job job;

	@Inject
	@Server
	private IServerDataProvider dpProvider; 

	@Inject
	private IRunMonitor runMonitor;

	private IData dataProvider;

	@Inject
	private ModelUtils modelUtils;

	@Inject
	private IPropertiesProvider propsProvider;

	public NetxForgeJob() {
		JobActivator.getInstance().getInjector().injectMembers(this);

		// We could do late or lazy instantiation, as we open and close
		// sessions/transactions.
		// when creating a monitor and job container.
		dataProvider = dpProvider.get();
	}

	private static synchronized boolean isRunning(CDOID cdoId) {
		return runningJobs.contains(cdoId);
	}

	private static synchronized void addRunning(CDOID cdoId) {
		runningJobs.add(cdoId);
	}

	private static synchronized void removeRunning(CDOID cdoId) {
		runningJobs.remove(cdoId);
	}

	private int maxWorkFlowRunsInJobRunContainer = -1;

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		final JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		job = (Job) dataMap.get(JOB_PARAMETER);

		// jobs are too close to eachother, going away
		if (isRunning(job.cdoID())) {
			// removeRunning(job.cdoID());
			return;
		}
		addRunning(job.cdoID());

		// Job Catch.
		try {
			final JobImplementation jobImplementation = JobImplementation.REGISTRY
					.getFactory(job.getClass()).create();

			// NOTE: Jobs are responsible in finishing the run monitor!
			// TODO, Consider storing the result in the Job and underlying
			// logic,
			// and finishing the IRunMonitor here, as we also start it here
			// (When we create it).
			createWorkFlowMonitor(jobImplementation);

			jobImplementation.setRunMonitor(runMonitor);
			jobImplementation.setNetxForgeJob(this);

			// Process Catch.
			try {
				jobImplementation.run();
				jobImplementation.finish();
			} catch (final Throwable t) {
				JobActivator.TRACE.trace(JobActivator.TRACE_JOBS_OPTION,
						"Error in process: " + job.getClass(), t);
			}
		} catch (Exception e) {
			JobActivator.TRACE.trace(JobActivator.TRACE_JOBS_OPTION,
					"Error instantiating job: " + job.getClass(), e);
		} finally {
			removeRunning(job.cdoID());
		}
	}

	private void createWorkFlowMonitor(JobImplementation jobImplementation) {

		dataProvider.openSession();
		dataProvider.getTransaction();
		final JobRunContainer container = getOrCreateJobRunContainer(dataProvider
				.getResource(SchedulingPackage.eINSTANCE.getJobRunContainer()));

		final WorkFlowRun wfRun = jobImplementation.createWorkFlowRunInstance();
		addAndTruncate(container, container.getWorkFlowRuns(), wfRun);

		dataProvider.commitTransactionThenClose();
		dataProvider.closeSession();

		// Tigh the ID of the Workflow run with the Run Monitor. The monitor
		// will update this object.
		runMonitor.setWorkFlowRunId(wfRun.cdoID());
		runMonitor.setStartRunning();
	}

	/**
	 * @param container
	 * @param resource
	 * @param logEntry
	 */
	public void addAndTruncate(JobRunContainer container,
			final EList<WorkFlowRun> contents, WorkFlowRun wfRun) {

		// Lazy init maxStats var.
		if (maxWorkFlowRunsInJobRunContainer == -1) {
			boolean storeMaxRuns = false;

			String property = propsProvider.get().getProperty(
					NETXSTUDIO_MAX_JOBRUNS_QUANTITY);

			if (property == null) {
				maxWorkFlowRunsInJobRunContainer = new Integer(
						NETXSTUDIO_MAX_JOBRUNS_QUANTITY_DEFAULT);
				storeMaxRuns = true;
			} else {
				if (JobActivator.DEBUG) {
					JobActivator.TRACE.trace(JobActivator.TRACE_JOBS_OPTION,
							"found property: "
									+ NETXSTUDIO_MAX_JOBRUNS_QUANTITY);
				}
				try {
					maxWorkFlowRunsInJobRunContainer = new Integer(property);
				} catch (NumberFormatException nfe) {

					if (JobActivator.DEBUG) {
						JobActivator.TRACE.trace(
								JobActivator.TRACE_JOBS_OPTION,
								"Error reading property", nfe);
					}

					maxWorkFlowRunsInJobRunContainer = new Integer(
							NETXSTUDIO_MAX_JOBRUNS_QUANTITY_DEFAULT);
					storeMaxRuns = true;
				}
			}

			if (storeMaxRuns) {
				// Should be saved when the Activator stops!
				propsProvider.get().setProperty(
						NETXSTUDIO_MAX_JOBRUNS_QUANTITY,
						new Integer(maxWorkFlowRunsInJobRunContainer)
								.toString());
			}
		}

		contents.add(0, wfRun);

		// truncate the list, if exceeding max. size.
		if (contents.size() > maxWorkFlowRunsInJobRunContainer) {

			List<WorkFlowRun> subList = Lists.newArrayList(contents.subList(0,
					maxWorkFlowRunsInJobRunContainer));

			if (CDOUtil.isStaleObject(container)) {
				System.out.println();
			}

			for (int i = 0; i < contents.size(); i++) {
				try {
					WorkFlowRun workFlowRun = contents.get(i);
					if (CDOUtil.isStaleObject(workFlowRun)) {
						CDOUtil.cleanStaleReference(
								container,
								SchedulingPackage.Literals.JOB_RUN_CONTAINER__WORK_FLOW_RUNS,
								i);
					}
				} catch (ObjectNotFoundException excteption) {
					CDOUtil.cleanStaleReference(
							container,
							SchedulingPackage.Literals.JOB_RUN_CONTAINER__WORK_FLOW_RUNS,
							i);
				}
			}

			boolean retainAll = contents.retainAll(subList);

			if (retainAll) {
				if (JobActivator.DEBUG) {
					JobActivator.TRACE.trace(JobActivator.TRACE_JOBS_OPTION,
							"truncing workflow runs to max "
									+ maxWorkFlowRunsInJobRunContainer);
				}
			}
		}
	}

	private JobRunContainer getOrCreateJobRunContainer(Resource resource) {
		final CDOID cdoId = job.cdoID();

		JobRunContainer container = modelUtils
				.jobContainerForJob(job, resource);
		if (container == null) {
			container = SchedulingFactory.eINSTANCE.createJobRunContainer();
			// get the job to refer to...(Set it with our own transaction).
			final Job localJob = (Job) dataProvider.getTransaction().getObject(
					cdoId);
			container.setJob(localJob);
			resource.getContents().add(container);
		}
		return container;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
