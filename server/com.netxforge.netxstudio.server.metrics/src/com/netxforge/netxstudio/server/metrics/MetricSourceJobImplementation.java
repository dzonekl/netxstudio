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

import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.server.job.JobImplementation;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 */
public class MetricSourceJobImplementation extends JobImplementation {

	public static final String ROOT_SYSTEM_PROPERTY = "metricSourceRoot";
	
	@Override
	public void run() {
		// read a new metricsource so that it is part of this
		// transaction/session
		final MetricSource metricSource = getMetricSource();
		final MetricValuesImporter metricsImporter;
		if (metricSource.getMetricMapping() instanceof MappingXLS) {
			metricsImporter = Activator.getInstance().getInjector().getInstance(XLSMetricValuesImporter.class);
		} else if (metricSource.getMetricMapping() instanceof MappingCSV) {
			metricsImporter = Activator.getInstance().getInjector().getInstance(CSVMetricValuesImporter.class);
		} else if (metricSource.getMetricMapping() instanceof MappingRDBMS) {
			metricsImporter = Activator.getInstance().getInjector().getInstance(RDBMSMetricValuesImporter.class);
		} else {
			throw new IllegalArgumentException("Mapping type not supported: " + metricSource.getMetricMapping());
		}
		
		metricsImporter.setMetricSourceWithId(metricSource.cdoID());
		metricsImporter.setJobMonitor(getRunMonitor());
		metricsImporter.process();
	}

	private MetricSource getMetricSource() {
		return ((MetricSourceJob) getJob()).getMetricSource();
	}

}
