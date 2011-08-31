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
package com.netxforge.netxstudio.server.metrics;

import java.util.Map;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.netxstudio.server.service.NetxForgeService;

/**
 * Runs import for a metric source.
 * 
 * @author Martin Taal
 */
public class MetricSourceImportService implements NetxForgeService {

	public static final String MS_PARAM = "metricSource";

	public Object run(Map<String, String> parameters) {
		final ServiceRunner runner = Activator.getInstance().getInjector()
				.getInstance(ServiceRunner.class);
		runner.setParameters(parameters);
		return ((AbstractCDOIDLong) runner.run()).getLongValue();
	}

	public static class ServiceRunner {
		@Inject
		@Server
		private IDataProvider dataProvider;

		private MetricValuesImporter importer;

		private Map<String, String> parameters;

		private CDOID run() {
			final CDOID msId = getCDOID(parameters.get(MS_PARAM),
					MetricsPackage.Literals.METRIC_SOURCE);
			final MetricSource metricSource = (MetricSource) dataProvider
					.getTransaction().getObject(msId);
			if (metricSource.getMetricMapping() instanceof MappingXLS) {
				importer = Activator.getInstance().getInjector()
						.getInstance(XLSMetricValuesImporter.class);
			} else if (metricSource.getMetricMapping() instanceof MappingCSV) {
				importer = Activator.getInstance().getInjector()
						.getInstance(CSVMetricValuesImporter.class);
			} else if (metricSource.getMetricMapping() instanceof MappingRDBMS) {
				importer = Activator.getInstance().getInjector()
						.getInstance(RDBMSMetricValuesImporter.class);
			} else {
				throw new IllegalArgumentException(
						"Mapping type not supported "
								+ metricSource.getMetricMapping());
			}
			importer.setMetricSourceWithId(msId);
			final ServerWorkFlowRunMonitor monitor = createMonitor();
			importer.setJobMonitor(monitor);
			// run in a separate thread
			new Thread() {
				@Override
				public void run() {
					// sleep to give the system
					// time to return
					try {
						sleep(100);
					} catch (final Exception e) {
						// do nothing, ignore
					}
					importer.process();
				};
			}.start();
			return monitor.getWorkFlowRunId();
		}

		private ServerWorkFlowRunMonitor createMonitor() {
			final ServerWorkFlowRunMonitor runMonitor = Activator.getInstance()
					.getInjector().getInstance(ServerWorkFlowRunMonitor.class);
			dataProvider.openSession();
			dataProvider.getTransaction();
			final Resource res = dataProvider
					.getResource(SchedulingPackage.Literals.WORK_FLOW_RUN);

			final WorkFlowRun wfRun = SchedulingFactory.eINSTANCE
					.createExpressionWorkFlowRun();
			res.getContents().add(wfRun);

			dataProvider.commitTransaction();
			dataProvider.closeSession();
			runMonitor.setWorkFlowRunId(wfRun.cdoID());
			runMonitor.setStartRunning();
			return runMonitor;
		}

		private CDOID getCDOID(String idString,
				org.eclipse.emf.ecore.EClass eClass) {
			return CDOIDUtil.createLongWithClassifier(new CDOClassifierRef(
					eClass), Long.parseLong(idString));
		}

		public Map<String, String> getParameters() {
			return parameters;
		}

		public void setParameters(Map<String, String> parameters) {
			this.parameters = parameters;
		}
	}

}
