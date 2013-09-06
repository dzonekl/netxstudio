/*******************************************************************************
 * Copyright (c) 5 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.server.test.actions;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

/**
 * @author Christophe Bouhier
 */
public class TestMonitoring extends AbstractInjectedTestJUnit4 {

	private static final String METRICSOURCE_TEST_JOB = "metricsource_test_job";
	
	
	@Inject
	private IDataProvider dataProvider;
	
	@Inject
	private ModelUtils modelUtils;

	
	@Before
	public void before(){
		this.getClientInjector().injectMembers(this);
	}

	@Test
	public void testMetricSourceJob() {

		// Produce a Job from an existing metric source.
		MetricSourceJob job = SchedulingFactory.eINSTANCE
				.createMetricSourceJob();

		setJobParameters(job, METRICSOURCE_TEST_JOB);

		// TODO
		// job.getMetricSources().add(ms);

		JobRunContainer container = SchedulingFactory.eINSTANCE
				.createJobRunContainer();
		container.setJob(job);

		// persist the job and job container.
		dataProvider.openSession("admin", "admin");
		dataProvider.getTransaction();
		{
			Resource jobsResource = dataProvider
					.getResource(SchedulingPackage.Literals.JOB);
			jobsResource.getContents().add(job);
			Resource jobRunContainerResource = dataProvider
					.getResource(SchedulingPackage.Literals.JOB_RUN_CONTAINER);
			jobRunContainerResource.getContents().add(container);
		}
		// Commit our job and container, will initialize a new transaction.
		dataProvider.commitTransactionThenClose();

		// this.runJob(container);

		// Cleanup.
		{

			Resource jobsResource = dataProvider
					.getResource(SchedulingPackage.Literals.JOB);

			Job jobWithName = modelUtils.jobWithName(METRICSOURCE_TEST_JOB,
					jobsResource);

			Resource containerResource = dataProvider
					.getResource(SchedulingPackage.Literals.JOB_RUN_CONTAINER);

			JobRunContainer jobContainerForJob = modelUtils.jobContainerForJob(
					job, containerResource);

			jobsResource.getContents().remove(jobWithName);
			containerResource.getContents().remove(jobContainerForJob);

		}
		dataProvider.commitTransactionThenClose();
		dataProvider.closeSession();

	}

	/**
	 * @param job
	 */
	private void setJobParameters(MetricSourceJob job, String name) {
		job.setName(name);
		job.setInterval(ModelUtils.SECONDS_IN_A_MINUTE);
		job.setStartTime(modelUtils.toXMLDate(modelUtils.todayAndNow()));
		job.setJobState(JobState.ACTIVE);
	}

	@SuppressWarnings("unused")
	private void runJob(JobRunContainer jobRunContainer) {

		try {

			// Create the run monitor
			ServerWorkFlowRunMonitor runMonitor = this.getClientInjector()
					.getInstance(ServerWorkFlowRunMonitor.class);

			// Create the Job implementation depending on the job type.
			final JobImplementation jobImplementation = JobImplementation.REGISTRY
					.getFactory(jobRunContainer.getJob().getClass()).create();
			final WorkFlowRun wfRun = jobImplementation
					.createWorkFlowRunInstance();

			// Set the workflow run.
			runMonitor.setWorkFlowRunId(wfRun.cdoID());
			runMonitor.setStartRunning();

			jobImplementation.setRunMonitor(runMonitor);

			// We dont have a Quartz job instance here.
			// jobImplementation.setNetxForgeJob(this);
			try {
				jobImplementation.run();
				runMonitor
						.setFinished(jobImplementation.getJobRunState(), null);
				jobImplementation.finish();
			} catch (final Throwable t) {
				runMonitor.setFinished(jobImplementation.getJobRunState(), t);
			}
		} catch (Exception e) {
		} finally {
		}
	}

	/**
	 * A test which generates monitoring data.
	 * 
	 */
	@Test
	public void testReadData() {
		// Requires:
		// A

	}

	/**
	 * A test which generates monitoring data.
	 * 
	 */
	@Test
	public void testGenerateMonitoring() {

	}

}
