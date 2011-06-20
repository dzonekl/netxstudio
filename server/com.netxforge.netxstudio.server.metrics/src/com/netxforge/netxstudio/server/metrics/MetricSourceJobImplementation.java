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

import java.io.InputStream;

import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.server.job.JobImplementation;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 */
public class MetricSourceJobImplementation extends JobImplementation {

	@Override
	public void run() {
		getDataProvider().openSession();
		getDataProvider().getTransaction();

		// read a new metricsource so that it is part of this
		// transaction/session
		final MetricSource metricSource = getMetricSource();

		final MetricValuesImporter metricsImporter = new MetricValuesImporter();

		metricsImporter.setMetricSource(metricSource);
		final String fileName = "data/" + metricSource.getName() + ".xls";
		final InputStream is = this.getClass().getResourceAsStream(
				fileName);
		if (is == null) {
			appendToLog("File " + fileName + " not present, not executing import");
			getDataProvider().commitTransaction();
			return;
		}
		metricsImporter.setInputStream(is);
		metricsImporter.process();
		getDataProvider().commitTransaction();
	}

	private MetricSource getMetricSource() {
		return ((MetricSourceJob) getJob()).getMetricSource();
	}

}
