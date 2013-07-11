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
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.test.job;

import java.util.Collections;
import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

/**
 * Test the job mechanism
 * 
 * @author Martin Taal
 */
public class MetricSourceJobTest extends AbstractInjectedTestJUnit4 {

	private static final String JOBNAME = "testJobReinitialization";
	private static final int MINUTE = 60000;

	private IDataService dataService;

	private ModelUtils modelUtils;

	@Before
	public void setUp() throws Exception {
		dataService = getClientInjector().getInstance(IDataService.class);
		modelUtils = getClientInjector().getInstance(ModelUtils.class);
	}

	@Test
	public void testRemoveJob() {
		final IDataProvider provider = dataService.getProvider();
		provider.openSession("admin", "admin");
		provider.getTransaction();
		final Resource resource = provider
				.getResource(SchedulingPackage.eINSTANCE.getJob());
		Job job = null;
		for (final EObject eObject : resource.getContents()) {
			job = (Job) eObject;
			if (job.getName().startsWith(JOBNAME)) {
				job.setDeleted(true);
			}
		}
		provider.commitTransactionThenClose();
	}

	@Test
	public void testUpdateJob() {
		final IDataProvider provider = dataService.getProvider();
		provider.openSession("admin", "admin");
		provider.getTransaction();
		final Resource resource = provider
				.getResource(SchedulingPackage.eINSTANCE.getJob());
		Job job = null;
		for (final EObject eObject : resource.getContents()) {
			job = (Job) eObject;
			if (job.getName().startsWith(JOBNAME)) {
				job.setName(JOBNAME + "test");
			}
		}
		provider.commitTransactionThenClose();
	}

	@Test
	public void testCreateJob() throws Exception {
		final IDataProvider provider = dataService.getProvider();
		provider.openSession("admin", "admin");
		provider.getTransaction();
		final Resource resource = provider
				.getResource(SchedulingPackage.eINSTANCE.getJob());

		final MetricSourceJob msJob = SchedulingFactory.eINSTANCE
				.createMetricSourceJob();
		msJob.setInterval(60);
		msJob.setJobState(JobState.ACTIVE);
		msJob.setName(JOBNAME);
		msJob.setStartTime(modelUtils.toXMLDate(new Date(System
				.currentTimeMillis() + 2 * MINUTE)));
		msJob.getMetricSources().add(createTestMetricSource(JOBNAME));
		resource.getContents().add(msJob);
		resource.save(Collections.emptyMap());
		provider.commitTransactionThenClose();
	}

	private MetricSource createTestMetricSource(String name) throws Exception {
		final Resource resource = dataService.getProvider().getResource(
				MetricsPackage.eINSTANCE.getMetricSource());
		final MetricSource metricSource = MetricsFactory.eINSTANCE
				.createMetricSource();
		metricSource.setName("" + System.currentTimeMillis());
		metricSource.setMetricLocation("");

		final MappingXLS mappingXLS = MetricsFactory.eINSTANCE
				.createMappingXLS();
		metricSource.setMetricMapping(mappingXLS);
		resource.getContents().add(metricSource);
		resource.save(Collections.emptyMap());
		return metricSource;
	}

}
