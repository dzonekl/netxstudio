package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.Service;

public class NodeResourceReportingLogic extends NodeReportingLogic {

	private static final int NODE_COLUMN = 2;
	private static final int NODE_ROW = 9;

	private static final int INFO_ROW = 6;
	private static final int INFO_COLUMN = 2;

	// FIXME, This should be outputed somehow aswell.
	private int componentsNotReported = 0;
	private Map<NetXResource, List<Marker>> markersForNode;
	
	ResourceReportingEngine reportingEngine;
	
	@Override
	protected void writeHeader(Sheet sheet, DateTimeRange dtr) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Network Element Monitoring");
		super.titleCell.setCellValue("Resource");
		if (dtr != null) {
			super.periodCell.setCellValue(this.getModelUtils().date(
					getModelUtils().fromXMLDate(dtr.getBegin()))
					+ "-"
					+ this.getModelUtils().date(
							getModelUtils().fromXMLDate(dtr.getEnd())));
		}
	}

	protected String calculateFileName() {
		String baseName = super.calculateFileName();
		StringBuilder builder = new StringBuilder();
		builder.append(REPORT_PREFIX);
		builder.append("_" + REPORT_PREFIX_RM_RESOURCE);
		List<Node> nodes = this.getNodes();
		if (nodes.size() == 1) {
			// We insert the node ID, if we have a single NODE.
			Node node = nodes.get(0);
			builder.append("_" + node.getNodeID() + "_");
		}
		builder.append(baseName);
		return builder.toString();
	}

	@Override
	protected void writeContent(Sheet sheet, NodeType nodeType) {
	}

	@Override
	protected void writeContent(Sheet sheet, Node node, int rowIndex,
			int nodeTypeCount) {
		
		reportingEngine = new ResourceReportingEngine(
				this.getModelUtils(), this.getPeriod(), this.getWorkBook());

		
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

		// TODO, Convert this util for Node only, with no service????
		// markersForNode = this.getModelUtils().markersForNode(service, node,
		// this.getPeriod());

		// } else {
		//
		// nodesNotReported++;
		// }
	}
	
	
	/*
	 * We expect the component to have resources, otherwise it is not reported. 
	 * Also if the 
	 * 
	 * (non-Javadoc)
	 * @see com.netxforge.netxstudio.server.logic.reporting.BaseNodeReportingLogic#writeContent(org.apache.poi.hssf.usermodel.HSSFSheet, com.netxforge.netxstudio.library.Component)
	 */
	@Override
	protected void writeContent(Sheet sheet, Component component) {
		
		// write each component ina  new row. 
		if (component.getResourceRefs().size() > 0) {
//			reportingEngine.writeComponentLine(newRow, sheet, component);
			reportingEngine.writeFlat(sheet.getLastRowNum() , sheet, component, markersForNode);	
		} else {
			this.componentsNotReported++;
		}

		
	}

	@Override
	protected void processServiceUser(Service service, Sheet sheet) {
	}

	@Override
	public void writeFinal(Sheet sheet) {

		Row row = sheet.getRow(INFO_ROW);
		if (row == null) {
			row = sheet.createRow(INFO_ROW);
		}
		Cell componentsSkippedInfoCell = row.createCell(INFO_COLUMN);
		componentsSkippedInfoCell
				.setCellValue("Number of not-reported Components (RAG Appropriate):"
						+ this.componentsNotReported);

	}

}
