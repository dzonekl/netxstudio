package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.base.context.IComputationContext;
import com.netxforge.base.context.ObjectContext;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.NodeTypeSummary;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

public class RFSServiceResourceReportingLogic extends OperatorReportingLogic {

	private static final int INFO_ROW = 6;
	private static final int INFO_COLUMN = 2;

	private static final int NODE_ROW = 9;
	private static final int NODE_COLUMN = 2;

	// private static final int RESOURCE_HEIGHT = 14;

	// FIXME, This should be outputed somehow aswell.
	private int nodesNotReported = 0;
	private int componentsNotReported = 0;

	private Map<NetXResource, List<Marker>> markersForNode;

	private ResourceReportingEngine reportingEngine;

	@Inject
	private MonitoringStateModel monitoringStateModel;

	@Override
	protected void writeHeader(Sheet sheet, DateTimeRange dtr) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Service Resources");
		if (dtr != null) {
			super.periodCell
					.setCellValue(NonModelUtils.date(NonModelUtils
							.fromXMLDate(dtr.getBegin()))
							+ "-"
							+ NonModelUtils.date(NonModelUtils.fromXMLDate(dtr
									.getEnd())));
		}
	}

	@Override
	public void writeFinal(Sheet sheet) {

		Row row = sheet.getRow(INFO_ROW);
		if (row == null) {
			row = sheet.createRow(INFO_ROW);
		}
		Cell nodeSkippedInfoCell = row.createCell(INFO_COLUMN);
		nodeSkippedInfoCell
				.setCellValue("Number of not-reported nodes (RAG Appropriate):"
						+ this.nodesNotReported);

		Row componentsRow = sheet.getRow(INFO_ROW + 1);
		if (componentsRow == null) {
			componentsRow = sheet.createRow(INFO_ROW + 1);
		}
		Cell componentsSkippedInfoCell = componentsRow.createCell(INFO_COLUMN);
		componentsSkippedInfoCell
				.setCellValue("Number of not-reported Components (RAG Appropriate):"
						+ this.componentsNotReported);

	}

	protected String calculateFileName() {
		String baseName = super.calculateFileName();
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_RESOURCE + "_" + baseName;
	}

	@Override
	protected void writeContent(Sheet sheet, Service service, Node node,
			int rowIndex, int nodeTypeCount) {

		// We skip reporting for this node, using a static check.
		// if (getModelUtils().ragShouldReport(
		// getModelUtils().ragCountResourcesForNode(service, node,
		// this.getPeriod()))) {
		if (reportingEngine == null) {
			reportingEngine = new ResourceReportingEngine(getPeriod(),
					getWorkBook());
		}

		// We skip reporting for this node, using a static check.
		// if (getModelUtils().ragShouldReport(
		// getModelUtils().ragCountResourcesForNode(service, node,
		// this.getPeriod()))) {

		int newRow = rowIndex == 0 ? NODE_ROW : sheet.getLastRowNum() + 1;

		Row nodeRow = reportingEngine.rowForIndex(sheet, newRow);

		Cell nodeCell = nodeRow.createCell(NODE_COLUMN);
		nodeCell.setCellValue(node.getNodeID());

		// Write the time stamps.
		reportingEngine.writeTS(sheet, ++newRow);

		// We need a
		IMonitoringSummary summary = monitoringStateModel.summary(
				new NullProgressMonitor(), node, new IComputationContext[] {
						new ObjectContext<RFSService>((RFSService) service),
						new ObjectContext<DateTimeRange>(this.getPeriod())

				});

		if (summary instanceof NodeTypeSummary) {
			markersForNode = ((NodeTypeSummary) summary).markers();
		}
	}

	@Override
	protected void writeContent(Sheet sheet, Component component) {

		if (component.getResourceRefs().size() > 0) {
			// reportingEngine.writeComponentLine(newRow, sheet, component);

			if (LogicActivator.DEBUG) {
				LogicActivator.TRACE.trace(
						LogicActivator.TRACE_REPORT_OPTION,
						"-- report component: "
								+ StudioUtils.printModelObject(component));
			}
			reportingEngine.writeFlat(sheet.getLastRowNum(), sheet, component,
					markersForNode);
		} else {
			this.componentsNotReported++;
		}
	}
}
