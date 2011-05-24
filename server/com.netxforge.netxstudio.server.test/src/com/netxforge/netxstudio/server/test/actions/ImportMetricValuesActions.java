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
package com.netxforge.netxstudio.server.test.actions;

import java.util.Map;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Unit;
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
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.server.metrics.MetricValuesImporter;
import com.netxforge.netxstudio.server.service.NetxForgeService;

/**
 * Main entrance class for importing an example xls.
 * 
 * @author Martin Taal
 */
public class ImportMetricValuesActions implements NetxForgeService {

	public static final String METRIC_SOURCE_NAME_PARAM = "metricSourceName";
	public static final String METRIC_SOURCE_ID_PARAM = "metricSourceId";
	public static final String CREATE_TEST_DATA_COMMAND = "createTestData";
	public static final String IMPORT_METRIC_SOURCE_COMMAND = "importMetricSource";
	
	@Inject
	private IDataService dataService;

	private boolean sessionOpened = false;

	@Override
	public Object run(Map<String, String> parameters) {
		final String command = parameters.get(NetxForgeService.COMMAND_PARAM_NAME);
		if (command == null) {
			throw new IllegalStateException(NetxForgeService.COMMAND_PARAM_NAME + " parameter not specified");
		} else if (command.equals(CREATE_TEST_DATA_COMMAND)) {
			createTestData(parameters.get(METRIC_SOURCE_NAME_PARAM));
		} else if (command.equals(IMPORT_METRIC_SOURCE_COMMAND)) {
			if (parameters.get(METRIC_SOURCE_ID_PARAM) != null) {
				final MetricSource metricSource = getMetricSourceById(parameters
						.get(METRIC_SOURCE_ID_PARAM));
				if (metricSource == null) {
					throw new IllegalStateException("Metric source with id " + parameters
						.get(METRIC_SOURCE_ID_PARAM) + " not found");
				}
				importMetricSource(metricSource);
			} else if (parameters.get(METRIC_SOURCE_NAME_PARAM) != null) {
				importMetricSource(getMetricSource(parameters.get(METRIC_SOURCE_NAME_PARAM)));
			} else {
				throw new IllegalStateException("Missing " + METRIC_SOURCE_NAME_PARAM + " or " + METRIC_SOURCE_ID_PARAM + " parameters");
			}
		} else {
			throw new IllegalArgumentException("Command " + command
					+ " not supported here");
		}
		return NetxForgeService.DEFAULT_SUCCESS_RESULT;
	}

	private MetricSource getMetricSourceById(String metricSourceId) {
		final CDOID cdoID = CDOIDUtil
				.createLongWithClassifier(new CDOClassifierRef(
						MetricsPackage.eINSTANCE.getMetricSource()), Long
						.parseLong(metricSourceId));
		return (MetricSource) dataService.getProvider().getTransaction()
				.getObject(cdoID);
	}

	private void doOpenSession() {
		if (sessionOpened) {
			return;
		}
		sessionOpened = true;

		DataActivator.getInjector().injectMembers(this);

		dataService.getProvider().openSession("admin", "admin");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.nextstudio.server.test.actions.ImportMetricValuesService
	 * #createTestData()
	 */
	public void createTestData(String metricSourceName) {
		doOpenSession();
		try {
			getMetricSource(metricSourceName);
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.nextstudio.server.test.actions.ImportMetricValuesService
	 * #importMetricSource()
	 */
	public void importMetricSource(MetricSource metricSource) {
		try {
			doOpenSession();
			final MetricValuesImporter metricsImporter = new MetricValuesImporter();

			metricsImporter.setMetricSource(metricSource);
			metricsImporter.setInputStream(this.getClass().getResourceAsStream(
					"data/" + metricSource.getName() + ".xls"));
			metricsImporter.process();
			dataService.getProvider().commitTransaction();
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private MetricSource getMetricSource(String name) {
		try {
			doOpenSession();
			final CDOQuery qry = dataService.getProvider().getTransaction()
					.createQuery("hql", "from MetricSource");
			for (final MetricSource metricSource : qry
					.getResult(MetricSource.class)) {
				if (metricSource.getName().equals(name)) {
					return metricSource;
				}
			}

			// not found create one
			return createTestMetricSource(name);
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private MetricSource createTestMetricSource(String name)
			throws CommitException {
		final Resource resource = dataService.getProvider().getResource(
				MetricsPackage.eINSTANCE.getMetricSource().getClassifierID());

		// create the Metricsource
		final MetricSource metricSource = MetricsFactory.eINSTANCE
				.createMetricSource();
		metricSource.setName(name);
		metricSource
				.setMetricLocation("/com/netxforge/nextstudio/server/test/metrics/actions/"
						+ name + ".xls");

		final MappingXLS mappingXLS = MetricsFactory.eINSTANCE
				.createMappingXLS();
		metricSource.setMetricMapping(mappingXLS);

		setMSName1Mapping(metricSource, mappingXLS);

		final Network network = createNetwork(metricSource);
		resource.getContents().add(network);

		dataService.getProvider().commitTransaction();
		return metricSource;
	}

	private void setMSName1Mapping(MetricSource metricSource,
			MappingXLS mappingXLS) {
		mappingXLS.setFirstDataRow(11);
		mappingXLS.setHeaderRow(10);
		mappingXLS.setSheetNumber(0);

		mappingXLS.getMappingColumns().add(
				createValueColumn(metricSource, "Start Time", 0,
						ValueKindType.DATETIME));
		mappingXLS.getMappingColumns().add(
				createValueColumn(metricSource, "Period", 1,
						ValueKindType.PERIOD));
		mappingXLS.getMappingColumns().add(
				createValueColumn(metricSource,
						"Gb mode max attached users(number)", 4,
						ValueKindType.METRIC));
		mappingXLS.getMappingColumns().add(
				createValueColumn(metricSource,
						"Iu mode max attached users(number)", 5,
						ValueKindType.METRIC));
		mappingXLS.getMappingColumns().add(
				createIdentifierColumn(2, 10, ObjectKindType.NODE,
						OperatorsPackage.eINSTANCE.getNode_NodeID().getName()));
		mappingXLS.getMappingColumns().add(
				createIdentifierColumn(3, 10, ObjectKindType.FUNCTION,
						LibraryPackage.eINSTANCE.getFunction_FunctionName()
								.getName()));
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

	private MappingXLSColumn createValueColumn(MetricSource metricSource,
			String metricName, int columnNo, ValueKindType valueKindType) {
		final MappingXLSColumn column = MetricsFactory.eINSTANCE
				.createMappingXLSColumn();
		column.setColumn(columnNo);
		final ValueDataKind valueDataKind = MetricsFactory.eINSTANCE
				.createValueDataKind();
		valueDataKind.setValueKind(valueKindType);
		column.setDataType(valueDataKind);
		if (valueDataKind.getValueKind() == ValueKindType.METRIC) {
			valueDataKind.setMetricRef(getMetric(metricSource, metricName));
		}
		return column;
	}

	private Metric getMetric(MetricSource metricSource, String name) {
		final Resource resource = dataService.getProvider().getResource(
				MetricsPackage.eINSTANCE.getMetric().getClassifierID());
		for (final EObject eObject : resource.getContents()) {
			if (eObject instanceof Metric) {
				final Metric metric = (Metric) eObject;
				if (metric.getName() != null && metric.getName().equals(name)) {
					return metric;
				}
			}
		}

		// create one
		final Metric metric = MetricsFactory.eINSTANCE.createMetric();
		metric.setDescription("name");
		metric.setName(name);
		metric.setUnitRef(getUnit("#"));
		metricSource.getMetricRefs().add(metric);
		resource.getContents().add(metric);
		return metric;
	}

	private Unit getUnit(String unitCode) {
		final Resource resource = dataService.getProvider().getResource(
				LibraryPackage.eINSTANCE.getUnit().getClassifierID());
		for (final EObject eObject : resource.getContents()) {
			if (eObject instanceof Unit) {
				final Unit unit = (Unit) eObject;
				if (unit.getCode().equals(unitCode)) {
					return unit;
				}
			}
		}
		final Unit unit = LibraryFactory.eINSTANCE.createUnit();
		unit.setCode(unitCode);
		unit.setDescription(unitCode);
		unit.setName(unitCode);
		resource.getContents().add(unit);
		return unit;
	}

	private Network createNetwork(MetricSource metricSource) {
		final Network network = OperatorsFactory.eINSTANCE.createNetwork();
		network.setName("T-Mobile");
		network.getNodes().add(createNode(metricSource, "YPSGSN3"));
		network.getNodes().add(createNode(metricSource, "RTSGSN3"));
		network.getMetricSources().add(metricSource);
		return network;
	}

	private Node createNode(MetricSource metricSource, String id) {
		final NodeType nodeType = LibraryFactory.eINSTANCE.createNodeType();
		final Function function = LibraryFactory.eINSTANCE.createFunction();
		function.setDescription("RTSGSN3");
		function.setFunctionName("RTSGSN3");
		function.getFunctionMetricRefs().addAll(metricSource.getMetricRefs());
		nodeType.getFunctions().add(function);

		final Node node = OperatorsFactory.eINSTANCE.createNode();
		node.setNodeID("RTSGSN3");
		node.getNodeType().add(nodeType);
		node.setOriginalNodeTypeRef(nodeType);
		return node;
	}
}
