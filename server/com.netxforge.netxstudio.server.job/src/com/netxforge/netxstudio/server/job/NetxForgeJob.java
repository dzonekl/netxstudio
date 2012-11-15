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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.internal.JobActivator;

/**
 * Represents a Quartz job, will update job results etc.
 * 
 * @author Martin Taal
 */
public class NetxForgeJob implements org.quartz.Job {

	public static final String JOB_PARAMETER = "job";

	private static List<CDOID> runningJobs = new ArrayList<CDOID>();

	private static synchronized boolean isRunning(CDOID cdoId) {
		return runningJobs.contains(cdoId);
	}
	
	private static synchronized void addRunning(CDOID cdoId) {
		runningJobs.add(cdoId);
	}
	
	private static synchronized void removeRunning(CDOID cdoId) {
		runningJobs.remove(cdoId);
	}
	
	private Job job;

	private ServerWorkFlowRunMonitor runMonitor;

	@Inject
	@Server
	private IDataProvider dataProvider;

	public NetxForgeJob() {
		JobActivator.getInstance().getInjector().injectMembers(this);
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		final JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		job = (Job) dataMap.get(JOB_PARAMETER);

		// jobs are too close to eachother, going away
		if (isRunning(job.cdoID())) {
			return;
		}
		addRunning(job.cdoID());
		try {
			final JobImplementation jobImplementation = JobImplementation.REGISTRY
					.getFactory(job.getClass()).create();
			createWorkFlowMonitor(jobImplementation);
			jobImplementation.setRunMonitor(runMonitor);
			jobImplementation.setNetxForgeJob(this);
			try {
				jobImplementation.run();
				runMonitor
						.setFinished(jobImplementation.getJobRunState(), null);
				jobImplementation.finish();
			} catch (final Throwable t) {
				runMonitor.setFinished(jobImplementation.getJobRunState(), t);
			}
		} finally {
			removeRunning(job.cdoID());
		}
	}

	private void createWorkFlowMonitor(JobImplementation jobImplementation) {
		
		// use Guice provider pattern 
		runMonitor = JobActivator.getInstance().getInjector()
				.getInstance(ServerWorkFlowRunMonitor.class);
		dataProvider.openSession();
		dataProvider.getTransaction();
		final JobRunContainer container = getCreateJobRunContainer(dataProvider
				.getResource(SchedulingPackage.eINSTANCE.getJobRunContainer()));
		
		
		if(container.getWorkFlowRuns().size() > ServerWorkFlowRunMonitor.MAX_WORKFLOW_RUNS){
			
		}
		
		final WorkFlowRun wfRun = jobImplementation.createWorkFlowRunInstance();
		container.getWorkFlowRuns().add(wfRun);

		dataProvider.commitTransaction();
		dataProvider.closeSession();
		runMonitor.setWorkFlowRunId(wfRun.cdoID());
		runMonitor.setStartRunning();
	}

	private JobRunContainer getCreateJobRunContainer(Resource resource) {
		final CDOID cdoId = job.cdoID();
		for (final EObject eObject : resource.getContents()) {
			final JobRunContainer container = (JobRunContainer) eObject;
			final Job containerJob = container.getJob();
			final CDOID containerJobId = ((CDOObject) containerJob).cdoID();
			if (cdoId.equals(containerJobId)) {
				return container;
			}
		}
		// got here, create a new one
		final JobRunContainer container = SchedulingFactory.eINSTANCE
				.createJobRunContainer();

		// get the job to refer to...
		final Job localJob = (Job) dataProvider.getTransaction().getObject(
				cdoId);
		container.setJob(localJob);
		resource.getContents().add(container);
		return container;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
