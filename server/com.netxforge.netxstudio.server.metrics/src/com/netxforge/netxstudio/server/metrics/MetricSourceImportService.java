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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.importer.AbstractMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.CSVMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.RDBMSMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.XLSMetricValuesImporter;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.IDPProvider;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.netxstudio.server.metrics.internal.MetricsActivator;
import com.netxforge.netxstudio.server.service.NetxForgeService;

/**
 * Runs import for a metric source.
 * 
 * @author Martin Taal
 */
public class MetricSourceImportService implements NetxForgeService {

	@Inject
	static private IImporterHelper importerHelper;

	@Inject
	static private ModelUtils modelUtils;

	public static final String MS_PARAM = "metricSource";

	public Object run(Map<String, String> parameters) {
		final ServiceRunner runner = MetricsActivator.getInstance()
				.getInjector().getInstance(ServiceRunner.class);
		runner.setParameters(parameters);
		CDOID run = runner.run();
		return modelUtils.cdoLongIDAsString(run);
	}

	public static class ServiceRunner {

		@Inject
		@Server
		private IDPProvider dpProvider;

		private IDataProvider dataProvider;

		private AbstractMetricValuesImporter importer;

		private Map<String, String> parameters;

		private CDOID run() {
			final CDOID msId = modelUtils.cdoLongIDFromString(
					MetricsPackage.Literals.METRIC_SOURCE,
					parameters.get(MS_PARAM));

			if (MetricsActivator.DEBUG) {
				System.out.println("IMPORT SERVICE  Metric source ID=" + msId);
			}

			final MetricSource metricSource = (MetricSource) this
					.getDataProvider().getTransaction().getObject(msId);

			if (MetricsActivator.DEBUG) {
				System.out.println("IMPORT SERVICE  Metric source revision="
						+ metricSource.cdoRevision());
			}

			if (metricSource.getMetricMapping() instanceof MappingXLS) {
				importer = MetricsActivator.getInstance().getInjector()
						.getInstance(XLSMetricValuesImporter.class);
			} else if (metricSource.getMetricMapping() instanceof MappingCSV) {
				importer = MetricsActivator.getInstance().getInjector()
						.getInstance(CSVMetricValuesImporter.class);
			} else if (metricSource.getMetricMapping() instanceof MappingRDBMS) {
				importer = MetricsActivator.getInstance().getInjector()
						.getInstance(RDBMSMetricValuesImporter.class);
			} else {
				throw new IllegalArgumentException(
						"Mapping type not supported "
								+ metricSource.getMetricMapping());
			}
			importerHelper = MetricsActivator.getInstance().getInjector()
					.getInstance(IImporterHelper.class);

			importerHelper.setImporter(importer);
			importer.setImportHelper(importerHelper);
			importer.setMetricSourceWithId(msId);

			// dataProvider.closeSession();

			final IRunMonitor monitor = createMonitor();
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

		/* Test to get the metric source differently */
		@SuppressWarnings("unused")
		private MetricSource getMetricSource(CDOID msId) {
			CDOResource resource = this
					.getDataProvider()
					.getTransaction()
					.getResource(
							"/"
									+ MetricsPackage.Literals.METRIC_SOURCE
											.getName());
			// find our metric source.
			for (EObject eoObject : resource.getContents()) {
				CDOObject cdoObject = (CDOObject) eoObject;
				if (cdoObject.cdoID().compareTo(msId) == 0) {
					return (MetricSource) cdoObject;
				}
			}
			return null;
		}

		private ServerWorkFlowRunMonitor createMonitor() {
			final ServerWorkFlowRunMonitor runMonitor = MetricsActivator
					.getInstance().getInjector()
					.getInstance(ServerWorkFlowRunMonitor.class);

			// CB 22-11-2011 This is done earlier, or use another instance of
			// the sessions!
			// dataProvider.openSession();
			// dataProvider.getTransaction();
			final Resource res = this.getDataProvider().getResource(
					SchedulingPackage.Literals.WORK_FLOW_RUN);

			final WorkFlowRun wfRun = SchedulingFactory.eINSTANCE
					.createComponentWorkFlowRun();
			res.getContents().add(wfRun);

			this.getDataProvider().commitTransactionThenClose();
			this.getDataProvider().closeSession();
			runMonitor.setWorkFlowRunId(wfRun.cdoID());
			runMonitor.setStartRunning();
			return runMonitor;
		}

		public Map<String, String> getParameters() {
			return parameters;
		}

		public void setParameters(Map<String, String> parameters) {
			this.parameters = parameters;
		}

		public IDataProvider getDataProvider() {
			if (dataProvider == null) {
				dataProvider = dpProvider.get();
			}
			return dataProvider;
		}
	}

}
