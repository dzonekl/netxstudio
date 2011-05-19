/*******************************************************************************
 * Copyright (c) Apr 26, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.nextstudio.server.test.metrics;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MappingXLSColumn;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.nextstudio.server.metrics.MetricValuesImporter;
import com.netxforge.nextstudio.server.test.base.BaseTest;

/**
 * Tests the import of metrics for one xls type.
 * 
 * @author Martin Taal
 */
public class ImportMetricValuesTest extends BaseTest {
	private static final String MS_NAME_1 = "SGSN attached users (Gb_IuPS)(10192010 1611)";

	@Inject
	private IDataService dataService;

	public void testImportSGSNMetricSource() throws Exception {

		DataActivator.getInjector().injectMembers(this);

		dataService.getProvider().openSession("test", "test");

		final MetricSource metricSource = getMetricSource(MS_NAME_1);

		final MetricValuesImporter metricsImporter = new MetricValuesImporter();

		metricsImporter.setMetricSource(metricSource);
		metricsImporter.setInputStream(this.getClass().getResourceAsStream(
				"data/" + MS_NAME_1 + ".xls"));
		metricsImporter.process();
	}

	private MetricSource getMetricSource(String name) throws CommitException {
		final CDOTransaction transaction = dataService.getProvider()
				.getSession().openTransaction();

		{
			final CDOQuery qry = transaction.createQuery("hql",
					"from MetricSource");
			for (final MetricSource metricSource : qry
					.getResult(MetricSource.class)) {
				if (metricSource.getName().equals(name)) {
					return metricSource;
				}
			}

			transaction.commit();

			// not found create one
			return createTestMetricSource(name);
		}
	}

	private MetricSource createTestMetricSource(String name)
			throws CommitException {
		final CDOTransaction transaction = dataService.getProvider()
				.getSession().openTransaction();

		// get/create a resource
		final CDOResource resource = transaction.getOrCreateResource("/test1"); //$NON-NLS-1$

		// create the Metricsource
		final MetricSource metricSource = MetricsFactory.eINSTANCE
				.createMetricSource();
		metricSource.setName(name);
		metricSource
				.setMetricLocation("/com/netxforge/nextstudio/server/test/metrics/data/"
						+ name + ".xls");
		resource.getContents().add(metricSource);

		final MappingXLS mappingXLS = MetricsFactory.eINSTANCE
				.createMappingXLS();
		metricSource.setMetricMapping(mappingXLS);

		if (name.equals(MS_NAME_1)) {
			setMSName1Mapping(mappingXLS);
		}

		transaction.commit();
		return metricSource;
	}

	private void setMSName1Mapping(MappingXLS mappingXLS) {
		mappingXLS.setFirstDataRow(11);
		mappingXLS.setHeaderRow(10);
		mappingXLS.setSheetNumber(0);

		mappingXLS.getMappingColumns().add(
				createValueColumn("Start Time", 0, ValueKindType.DATETIME));
		mappingXLS.getMappingColumns().add(
				createValueColumn("Period", 1, ValueKindType.PERIOD));
		mappingXLS.getMappingColumns().add(
				createValueColumn("Gb mode max attached users(number)", 4,
						ValueKindType.METRIC));
		mappingXLS.getMappingColumns().add(
				createValueColumn("Iu mode max attached users(number)", 5,
						ValueKindType.METRIC));
		mappingXLS.getMappingColumns().add(
				createIdentifierColumn(2, 10, ObjectKindType.NODE, "name"));
		mappingXLS.getMappingColumns().add(
				createIdentifierColumn(3, 10, ObjectKindType.FUNCTION, "name"));
	}

	private MappingXLSColumn createIdentifierColumn(int columnNo,
			int headerRow, ObjectKindType objectKind, String objectProperty) {
		final MappingXLSColumn column = MetricsFactory.eINSTANCE
				.createMappingXLSColumn();
		column.setColumn(columnNo);
		final IdentifierDataKind kind = MetricsFactory.eINSTANCE
				.createIdentifierDataKind();
		kind.setObjectKind(objectKind);
		kind.setObjectProperty(objectProperty);
		column.setDataType(kind);
		return column;
	}

	private MappingXLSColumn createValueColumn(String metricName, int columnNo,
			ValueKindType valueKindType) {
		final MappingXLSColumn column = MetricsFactory.eINSTANCE
				.createMappingXLSColumn();
		column.setColumn(columnNo);
		final ValueDataKind valueDataKind = MetricsFactory.eINSTANCE
				.createValueDataKind();
		valueDataKind.setValueKind(valueKindType);
		column.setDataType(valueDataKind);
		if (valueDataKind.getValueKind() == ValueKindType.METRIC) {
			valueDataKind.setMetricRef(getMetric(metricName));
		}
		return column;
	}

	private Metric getMetric(String name) {
		final Resource resource = dataService.getProvider().getResource(
				MetricsPackage.eINSTANCE.getMetric().getClassifierID());
		for (final EObject eObject : resource.getContents()) {
			final Metric metric = (Metric) eObject;
			if (metric.getName() != null && metric.getName().equals(name)) {
				return metric;
			}
		}
		throw new IllegalStateException("Metric with name " + name
				+ " not found");
	}
	
	private void createNetworkElements(String nodeName, String functionName) {
	}
}
