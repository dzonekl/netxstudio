package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

public class RFSServiceResourceReportingLogic extends OperatorReportingLogic {

	private static final int NODE_COLUMN = 2;
	private static final int NODE_ROW = 9;
	private static final int RESOURCE_HEIGHT = 14;

	// FIXME, This should be outputed somehow aswell.
	private int nodesNotReported = 0;

	@Override
	protected void writeHeader(HSSFSheet sheet, DateTimeRange dtr) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Service Resources");
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
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_RESOURCE + "_" + baseName;
	}

	@Override
	protected void writeContent(HSSFSheet sheet, NodeType nodeType) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service, Node node,
			int rowIndex, int nodeTypeCount) {

		// We skip reporting for this node, using a static check.
		if (getModelUtils().ragShouldReport(
				getModelUtils().ragCount(service, node, this.getPeriod()))) {

			int newRow = rowIndex == 0 ? NODE_ROW : sheet.getLastRowNum() + 1;

			HSSFRow nodeRow = sheet.getRow(newRow);
			if (nodeRow == null) {
				nodeRow = sheet.createRow(newRow);
			}

			HSSFCell nodeCell = nodeRow.createCell(NODE_COLUMN);
			nodeCell.setCellValue(node.getNodeID());

		} else {

			nodesNotReported++;
		}
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service,
			ServiceUser serviceUser, int rowIndex, int columnIndex) {

	}

	@Override
	protected void writeContent(HSSFSheet sheet, Component component) {

		int newRow = sheet.getLastRowNum() + 1;

		// Note: A Component without resources should not be needed to be
		// produced. e
		// Ask TMNL.

		HSSFRow componentRow = sheet.createRow(newRow);
		HSSFCell componentCell = componentRow.createCell(NODE_COLUMN + 1);

		if (component instanceof Function) {
			componentCell.setCellValue(component.getName());
		} else if (component instanceof Equipment) {
			componentCell.setCellValue(((Equipment) component)
					.getEquipmentCode());
		}

		int resourceIndex = newRow + 1;
		for (NetXResource resource : component.getResourceRefs()) {

			HSSFRow resourceRow = sheet.createRow(resourceIndex);
			resourceIndex += RESOURCE_HEIGHT;

			HSSFCell resourceCell = resourceRow.createCell(NODE_COLUMN + 2);
			resourceCell.setCellValue(resource.getLongName());

			{ // Writing hour reports.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_A_DAY);
				writeValues(resourceRow, mvr);
			}

			{ // Writing weekly values report.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_A_WEEK);
				writeValues(resourceRow, mvr);
			}
			{ // Writing monthly values report. (TODO, Should not be a fixed
				// value.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_A_MONTH);
				writeValues(resourceRow, mvr);
			}
		}
	}

	private void writeValues(HSSFRow resourceRow, MetricValueRange mvr) {

		List<Value> range = getModelUtils().sortByTimeStamp(
				mvr.getMetricValues());

		range = getModelUtils().filterValueInRange(range, this.getPeriod());

		// Write the values.
		int valueIndex = NODE_COLUMN + 3;

		for (Value v : range) {

			HSSFCell tsCell = resourceRow.createCell(valueIndex);
			tsCell.setCellValue(getModelUtils().fromXMLDate(v.getTimeStamp()));

			// TODO, Perhaps some formatting for a double.
			HSSFCell valueCell = resourceRow.createCell(valueIndex++);
			valueCell.setCellValue(v.getValue());

		}
	}
}
