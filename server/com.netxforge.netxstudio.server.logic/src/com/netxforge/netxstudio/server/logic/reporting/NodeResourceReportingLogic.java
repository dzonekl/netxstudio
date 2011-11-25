package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

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

	@Override
	protected void writeHeader(HSSFSheet sheet, DateTimeRange dtr) {
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
	protected void writeContent(HSSFSheet sheet, NodeType nodeType) {
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Node node, int rowIndex,
			int nodeTypeCount) {

		// We skip reporting for this node, using a static check.
		// if (getModelUtils().ragShouldReport(
		// getModelUtils().ragCountResourcesForNode(service, node,
		// this.getPeriod()))) {

		int newRow = rowIndex == 0 ? NODE_ROW : sheet.getLastRowNum() + 1;

		HSSFRow nodeRow = sheet.getRow(newRow);
		if (nodeRow == null) {
			nodeRow = sheet.createRow(newRow);
		}

		HSSFCell nodeCell = nodeRow.createCell(NODE_COLUMN);
		nodeCell.setCellValue(node.getNodeID());

		// TODO, Convert this util for Node only, with no service????
		// markersForNode = this.getModelUtils().markersForNode(service, node,
		// this.getPeriod());

		// } else {
		//
		// nodesNotReported++;
		// }
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Component component) {

		int newRow = sheet.getLastRowNum() + 1;
		ResourceReportingEngine componentEngine = new ResourceReportingEngine(
				this.getModelUtils(), this.getPeriod(), this.getWorkBook());

		if (component.getResourceRefs().size() > 0) {
			componentEngine.writeComponentLine(newRow, sheet, component);
		} else {
			this.componentsNotReported++;
		}

		componentEngine.write(newRow, sheet, component, markersForNode);

	}

	@Override
	protected void processServiceUser(Service service, HSSFSheet sheet) {
	}

	@Override
	public void writeFinal(HSSFSheet sheet) {

		HSSFRow row = sheet.getRow(INFO_ROW);
		if (row == null) {
			row = sheet.createRow(INFO_ROW);
		}
		HSSFCell componentsSkippedInfoCell = row.createCell(INFO_COLUMN);
		componentsSkippedInfoCell
				.setCellValue("Number of not-reported Components (RAG Appropriate):"
						+ this.componentsNotReported);

	}

}
