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
package com.netxforge.netxstudio.server.metrics;

import org.osgi.framework.ServiceReference;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.importer.AbstractMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.CSVMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.RDBMSMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.importer.XLSMetricValuesImporterProvider;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.server.internal.ServerActivator;
import com.netxforge.netxstudio.server.job.JobHandler;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.metrics.internal.MetricsActivator;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class MetricSourceJobImplementation extends JobImplementation {

	public static final String ROOT_SYSTEM_PROPERTY = "metricSourceRoot";

	@Inject
	private IImporterHelper importerHelper;

	@Override
	public void run() {
		// read a new metricsource so that it is part of this
		// transaction/session
		final MetricSource metricSource = getMetricSource();
		if (metricSource == null) {
			// We need a populated list.
			return;
		}

		final AbstractMetricValuesImporter metricsImporter;
		if (metricSource.getMetricMapping() instanceof MappingXLS) {
			metricsImporter = MetricsActivator.getInstance().getInjector()
					.getInstance(XLSMetricValuesImporterProvider.class).get();
		} else if (metricSource.getMetricMapping() instanceof MappingCSV) {
			metricsImporter = MetricsActivator.getInstance().getInjector()
					.getInstance(CSVMetricValuesImporterProvider.class).get();
		} else if (metricSource.getMetricMapping() instanceof MappingRDBMS) {
			metricsImporter = MetricsActivator.getInstance().getInjector()
					.getInstance(RDBMSMetricValuesImporterProvider.class).get();
		} else {
			throw new IllegalArgumentException("Mapping type not supported: "
					+ metricSource.getMetricMapping());
		}

		importerHelper.setImporter(metricsImporter);
		
		if (importerHelper instanceof ServerImporterHelper) {
			ServerImporterHelper sih = (ServerImporterHelper) importerHelper;
			sih.setActivator(ServerActivator.getInstance());
			
			// Get the job service, so we can check the status of the scheduler.
			final ServiceReference<JobHandler> serviceReference = MetricsActivator
					.getContext().getServiceReference(JobHandler.class);
			if (serviceReference == null) {
				throw new IllegalStateException(
						"Can't locate job handler services, could be timing that the service has not been instantiated by CDO yet.");

			}
			final Object service = MetricsActivator.getContext().getService(
					serviceReference);
			
			if (!(service instanceof JobHandler)) {
				throw new IllegalStateException(
						"Can't locate job handler services, could be timing that the service has not been instantiated by CDO yet.");
			} else {
				sih.setJobHandler((JobHandler) service);

			}
		}

		metricsImporter.setImportHelper(importerHelper);
		metricsImporter.setMetricSourceWithId(metricSource.cdoID());
		metricsImporter.setJobMonitor(getRunMonitor());

		metricsImporter.process();
	}

	private MetricSource getMetricSource() {
		if (((MetricSourceJob) getJob()).getMetricSources().size() > 0) {
			MetricSource ms = ((MetricSourceJob) getJob()).getMetricSources()
					.get(0);
			// CB crash on cdo prefetch.
			// ms.cdoPrefetch(CDORevision.DEPTH_INFINITE);

			if (MetricsActivator.DEBUG) {
				MetricsActivator.TRACE.trace(
						MetricsActivator.TRACE_IMPORT_OPTION,
						" Preparing import for metric source="
								+ ms.cdoRevision());
			}
			return ms;
		} else {
			return null;
		}
	}

}
