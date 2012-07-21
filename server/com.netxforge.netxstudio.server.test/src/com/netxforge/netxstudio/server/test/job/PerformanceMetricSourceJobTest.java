package com.netxforge.netxstudio.server.test.job;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.server.test.AbstractInjectedTestJUnit3;

public class PerformanceMetricSourceJobTest extends AbstractInjectedTestJUnit3 {

	private IDataService dataService;

	@SuppressWarnings("unused")
	private ModelUtils modelUtils;

	// Names of jobs to activate.
	String[] jobNames = new String[] { "T_systot-stp" };

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		dataService = super.getInjector().getInstance(IDataService.class);
		modelUtils = super.getInjector().getInstance(ModelUtils.class);
	}
	
	
	/**
	 * Activates the jobs, by changing the status, it immediately deactivates the job, so put a breakpoint. 
	 */
	@Test
	public void testPerformance() {
		for (String name : jobNames) {
			this.stateForJob(name, JobState.ACTIVE);
		}
		// wait until the job picks up. 
		for (String name : jobNames) {
			this.stateForJob(name, JobState.IN_ACTIVE);
		}
	}

	private void stateForJob(String jobName, JobState state) {
		final IDataProvider provider = dataService.getProvider();
		provider.openSession("admin", "admin");
		provider.getTransaction();
		
		// Get the job resource, find the job, activate it.
		CDOResource resource = (CDOResource) provider
				.getResource(SchedulingPackage.Literals.JOB);
		for (EObject eo : resource.getContents()) {
			if (eo instanceof Job && ((Job) eo).getName().equals(jobName)) {
				// found our job.
				Job j = (Job) eo;
				if (j.getJobState() != state) {
					j.setJobState(state);
				}
			}
		}

		provider.commitTransaction();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.test.dataprovider.AbstractDataProviderTest
	 * #tearDown()
	 */
	@Override
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
