/*******************************************************************************
 * Copyright (c) 30 okt. 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.reporting;

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
import com.netxforge.netxstudio.server.logic.reporting.ResourceReportingEngine;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * An emitter showing resources
 * 
 * @author Christophe
 */
public class RFSServiceResourceEmitter extends XLSXPOIEmitter {

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

	private DateTimeRange period;

	@Override
	public void writeHeader(DateTimeRange period) {

		this.period = period;

		createHeaderStructure();
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Service Resources");
		if (period != null) {
			super.periodCell.setCellValue(NonModelUtils.date(NonModelUtils
					.fromXMLDate(period.getBegin()))
					+ "-"
					+ NonModelUtils.date(NonModelUtils.fromXMLDate(period
							.getEnd())));
		}
	}

	@Override
	public void writeFinal() {

		Sheet sheet = getSheet();

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

	@Override
	public void writeContent(Service service, Node node, int rowIndex,
			int nodeTypeCount) {

		Sheet sheet = this.getSheet();

		// We skip reporting for this node, using a static check.
		// if (getModelUtils().ragShouldReport(
		// getModelUtils().ragCountResourcesForNode(service, node,
		// this.getPeriod()))) {
		if (reportingEngine == null) {
			// queryService.setDataProvider(this.getDataProvider());
			reportingEngine = new ResourceReportingEngine(period,
					this.getWorkBook());
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
						new ObjectContext<DateTimeRange>(period)

				});

		if (summary instanceof NodeTypeSummary) {
			markersForNode = ((NodeTypeSummary) summary).markers();
		}
	}

	@Override
	public void writeContent(Component component) {

		Sheet sheet = getSheet();

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

	public String getReportName() {
		return REPORT_PREFIX_SM_RESOURCE;
	}
}
