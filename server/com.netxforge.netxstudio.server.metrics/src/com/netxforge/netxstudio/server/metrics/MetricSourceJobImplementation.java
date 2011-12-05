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

import org.eclipse.emf.cdo.common.revision.CDORevision;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.importer.AbstractMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.CSVMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.RDBMSMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.XLSMetricValuesImporter;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.metrics.internal.MetricsActivator;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
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
		if(metricSource == null){
			// We need a populated list. 
			return; 
		}else{
			// make sure we have the latest revision for this object 
			metricSource.cdoReload();
			System.out.println("Revision after reload = " + 	metricSource.cdoRevision());
		}
		
		
		final AbstractMetricValuesImporter metricsImporter;
		if (metricSource.getMetricMapping() instanceof MappingXLS) {
			metricsImporter = MetricsActivator.getInstance().getInjector().getInstance(XLSMetricValuesImporter.class);
		} else if (metricSource.getMetricMapping() instanceof MappingCSV) {
			metricsImporter = MetricsActivator.getInstance().getInjector().getInstance(CSVMetricValuesImporter.class);
		} else if (metricSource.getMetricMapping() instanceof MappingRDBMS) {
			metricsImporter = MetricsActivator.getInstance().getInjector().getInstance(RDBMSMetricValuesImporter.class);
		} else {
			throw new IllegalArgumentException("Mapping type not supported: " + metricSource.getMetricMapping());
		}
		
		importerHelper.setImporter(metricsImporter);
		metricsImporter.setImportHelper(importerHelper);
		metricsImporter.setMetricSourceWithId(metricSource.cdoID());
		metricsImporter.setJobMonitor(getRunMonitor());
		metricsImporter.process();
	}

	private MetricSource getMetricSource() {
		if( ((MetricSourceJob) getJob()).getMetricSources().size() > 0){
			MetricSource ms = ((MetricSourceJob) getJob()).getMetricSources().get(0);
			ms.cdoPrefetch(CDORevision.DEPTH_INFINITE);
			
			if(MetricsActivator.DEBUG){
				System.out.println("IMPORTER JOB metric source=" + ms.cdoRevision());
			}
			return ms;
		}else{
			return null;
		}
	}

}
