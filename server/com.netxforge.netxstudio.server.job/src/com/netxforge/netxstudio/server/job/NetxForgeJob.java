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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

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
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.ServerUtils;

/**
 * Represents a job, will update job results etc.
 * 
 * @author Martin Taal
 */
public class NetxForgeJob implements org.quartz.Job {

	public static final String JOB_PARAMETER = "job";

	private Job job;

	private CDOID wfRunId;
	
	@Inject
	@Server
	private IDataProvider dataProvider;

	public NetxForgeJob() {
		Activator.getInstance().getInjector().injectMembers(this);
	}

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		final JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		job = (Job) dataMap.get(JOB_PARAMETER);
		setStartRunning();
		final JobImplementation jobImplementation = 
				JobImplementation.REGISTRY.getFactory(job.getClass()).create();
		
		jobImplementation.setNetxForgeJob(this);
		try {
			jobImplementation.run();
			setFinished(jobImplementation, null);
		} catch (final Throwable t) {
			setFinished(jobImplementation, t);
		}
	}
	
	public void setFinished(JobImplementation jobImplementation, Throwable t) {
		dataProvider.openSession();
		final WorkFlowRun wfRun = (WorkFlowRun)dataProvider.getTransaction().getObject(wfRunId);
		String log = jobImplementation.getLog();
		if (t != null) {
			wfRun.setState(JobRunState.FINISHED_WITH_ERROR);
			final StringWriter sw = new StringWriter();
			final PrintWriter pw = new PrintWriter(sw);					
			t.printStackTrace(pw);
			if (log == null) {
				log = "";
			}
			wfRun.setLog(log + "\n" + t.getMessage() + "\n" + sw.toString());
		} else {
			wfRun.setState(jobImplementation.getJobRunState());
			wfRun.setLog(log);
			wfRun.setProgress(100);
		}
		wfRun.setEnded(ServerUtils.getInstance().toXmlDate(new Date()));
		dataProvider.commitTransaction();
		dataProvider.closeSession();
	}

	public void updateJobRun(int progress, String msg, String task) {
		dataProvider.openSession();
		dataProvider.getTransaction();
		final JobRunContainer container = getCreateJobRunContainer(dataProvider.getResource(
						SchedulingPackage.eINSTANCE.getJobRunContainer()));
		for (final WorkFlowRun wfRun : container.getWorkFlowRuns()) {
			if (wfRun.cdoID().equals(wfRunId)) {
				wfRun.setProgress(progress);
				wfRun.setProgressMessage(msg);
				wfRun.setProgressTask(task);
				break;
			}
		}
		
		dataProvider.commitTransaction();
		dataProvider.closeSession();
	}
	
	private void setStartRunning() {
		dataProvider.openSession();
		dataProvider.getTransaction();
		final JobRunContainer container = getCreateJobRunContainer(dataProvider.getResource(
						SchedulingPackage.eINSTANCE.getJobRunContainer()));
		
		final WorkFlowRun wfRun = SchedulingFactory.eINSTANCE.createWorkFlowRun();
		wfRun.setState(JobRunState.RUNNING);
		wfRun.setStarted(ServerUtils.getInstance().toXmlDate(new Date()));
		wfRun.setProgress(0);
		container.getWorkFlowRuns().add(wfRun);
		
		dataProvider.commitTransaction();
		dataProvider.closeSession();
		wfRunId = wfRun.cdoID();
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
		final Job localJob = (Job) dataProvider.getTransaction()
				.getObject(cdoId);
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
