package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CreationHelper;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
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
		return REPORT_PREFIX + "_" + REPORT_PREFIX_RM_RESOURCE + "_" + baseName;
	}

	@Override
	protected void writeContent(HSSFSheet sheet, NodeType nodeType) {
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Node node,
			int rowIndex, int nodeTypeCount) {

		// We skip reporting for this node, using a static check.
//		if (getModelUtils().ragShouldReport(
//				getModelUtils().ragCountResourcesForNode(service, node,
//						this.getPeriod()))) {

			int newRow = rowIndex == 0 ? NODE_ROW : sheet.getLastRowNum() + 1;

			HSSFRow nodeRow = sheet.getRow(newRow);
			if (nodeRow == null) {
				nodeRow = sheet.createRow(newRow);
			}

			HSSFCell nodeCell = nodeRow.createCell(NODE_COLUMN);
			nodeCell.setCellValue(node.getNodeID());
			
			
			// TODO, Convert this util for Node only, with no service???? 
//			markersForNode = this.getModelUtils().markersForNode(service, node, this.getPeriod());
			
//		} else {
//
//			nodesNotReported++;
//		}
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Component component) {

		int newRow = sheet.getLastRowNum() + 1;

		if (component.getResourceRefs().size() > 0) {

			HSSFRow componentRow = sheet.createRow(newRow);
			HSSFCell componentCell = componentRow.createCell(NODE_COLUMN + 1);

			if (component instanceof Function) {
				componentCell.setCellValue(component.getName());
			} else if (component instanceof Equipment) {
				componentCell.setCellValue(((Equipment) component)
						.getEquipmentCode());
			}
		} else {
			this.componentsNotReported++;
		}

		int resourceIndex = newRow + 1;
		for (NetXResource resource : component.getResourceRefs()) {
			
			HSSFRow resourceRow = sheet.createRow(resourceIndex++);

			HSSFCell resourceCell = resourceRow.createCell(NODE_COLUMN + 2);
			resourceCell.setCellValue(resource.getLongName());
			
			{ // Writing hour reports.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_AN_HOUR);
				if (mvr != null) {
					resourceIndex = writeRange(resource, sheet, resourceIndex,
							ModelUtils.MINUTES_IN_AN_HOUR, mvr);
				}
			}

			{ // Writing day reports.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_A_DAY);
				if (mvr != null) {
					resourceIndex = writeRange(resource, sheet, resourceIndex,
							ModelUtils.MINUTES_IN_A_DAY, mvr);
				}
			}

			{ // Writing weekly values report.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_A_WEEK);
				if (mvr != null) {
					resourceIndex = writeRange(resource, sheet, resourceIndex,
							ModelUtils.MINUTES_IN_A_WEEK, mvr);
				}

			}
			{ // Writing monthly values report. (TODO, Should not be a fixed
				// value.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_A_MONTH);
				if (mvr != null) {
					resourceIndex = writeRange(resource, sheet, resourceIndex,
							ModelUtils.MINUTES_IN_A_MONTH, mvr);
				}

			}
			
			{ // Write the capacity.
				// !Potentially long operation, as we sort of the whole rang.e
				resourceIndex = writeCapacity(sheet, resourceIndex, resource);
			}

			{ // Write the utilization.
				// !Potentially long operation, as we sort of the whole rang.e
				resourceIndex = writeUtilization(sheet, resourceIndex, resource);
			}

		}
	}

	private int writeCapacity(HSSFSheet sheet, int resourceIndex,
			NetXResource resource) {
		List<Value> capRange = getModelUtils().sortValuesByTimeStamp(
				resource.getCapacityValues());
		capRange = getModelUtils().filterValueInRange(capRange,
				this.getPeriod());

		HSSFRow capRow = sheet.createRow(resourceIndex++);
		HSSFCell capCell = capRow.createCell(NODE_COLUMN + 3);
		capCell.setCellValue("Capacity");

		CreationHelper createHelper = this.getWorkBook().getCreationHelper();
		HSSFCellStyle cellStyle = this.getWorkBook().createCellStyle();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
				"m-d-yy h:mm"));
		
		HSSFRow tsRow = sheet.createRow(resourceIndex++);
		HSSFRow valueRow = sheet.createRow(resourceIndex++);

		// Write the values.
		int valueIndex = NODE_COLUMN + 4;
		for (Value v : capRange) {
			
			sheet.setColumnWidth(valueIndex, 14 * 256);
			
			HSSFCell tsCell = tsRow.createCell(valueIndex);
			tsCell.setCellValue(getModelUtils().fromXMLDate(
					v.getTimeStamp()));
			tsCell.setCellStyle(cellStyle);

			// TODO, Perhaps some formatting for a double.
			HSSFCell valueCell = valueRow.createCell(valueIndex++);
			valueCell.setCellValue(v.getValue());
		}
		return resourceIndex;
	}
	
	private int writeUtilization(HSSFSheet sheet, int resourceIndex,
			NetXResource resource) {
		List<Value> capRange = getModelUtils().sortValuesByTimeStamp(
				resource.getUtilizationValues());
		capRange = getModelUtils().filterValueInRange(capRange,
				this.getPeriod());

		HSSFRow capRow = sheet.createRow(resourceIndex++);
		HSSFCell capCell = capRow.createCell(NODE_COLUMN + 3);
		capCell.setCellValue("Utilization");

		CreationHelper createHelper = this.getWorkBook().getCreationHelper();
		HSSFCellStyle tsCellStyle = this.getWorkBook().createCellStyle();
		tsCellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
				"m-d-yy h:mm"));
		
		HSSFCellStyle percenCellStyle = this.getWorkBook().createCellStyle();
		percenCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.00%"));
		
		HSSFRow tsRow = sheet.createRow(resourceIndex++);
		HSSFRow valueRow = sheet.createRow(resourceIndex++);

		// Write the values.
		int valueIndex = NODE_COLUMN + 4;
		for (Value v : capRange) {
			HSSFCell tsCell = tsRow.createCell(valueIndex);
			tsCell.setCellValue(getModelUtils().fromXMLDate(
					v.getTimeStamp()));
			tsCell.setCellStyle(tsCellStyle);

			HSSFCell valueCell = valueRow.createCell(valueIndex++);
			valueCell.setCellValue(v.getValue());
			valueCell.setCellStyle(percenCellStyle);
			
		}
		return resourceIndex;
	}
	

	private int writeRange(NetXResource resource, HSSFSheet sheet, int resourceIndex, int interval,
			MetricValueRange mvr) {

		// !Potentially long operation, as we sort of the whole rang.e
		List<Value> range = getModelUtils().sortValuesByTimeStamp(
				mvr.getMetricValues());
		range = getModelUtils().filterValueInRange(range, this.getPeriod());

		HSSFRow resourceRow = sheet.createRow(resourceIndex++);

		HSSFCell mvrCell = resourceRow.createCell(NODE_COLUMN + 3);
		mvrCell.setCellValue(this.getModelUtils().fromMinutes(interval));

		HSSFRow tsRow = sheet.createRow(resourceIndex++);
		HSSFRow valueRow = sheet.createRow(resourceIndex++);

		CreationHelper createHelper = this.getWorkBook().getCreationHelper();
		HSSFCellStyle cellStyle = this.getWorkBook().createCellStyle();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
				"m-d-yy h:mm"));

		// Write the values.
		int valueIndex = NODE_COLUMN + 4;
		for (Value v : range) {
			HSSFCell tsCell = tsRow.createCell(valueIndex);
			tsCell.setCellValue(getModelUtils().fromXMLDate(v.getTimeStamp()));
			tsCell.setCellStyle(cellStyle);
			// TODO, Perhaps some formatting for a double.
			HSSFCell valueCell = valueRow.createCell(valueIndex++);
			valueCell.setCellValue(v.getValue());
		}
		return resourceIndex;
	}

	@Override
	protected void processServiceUser(Service service, HSSFSheet sheet) {
	}
	
	@Override
	public void writeFinal(HSSFSheet sheet) {
		
		HSSFRow row = sheet.getRow(INFO_ROW);
		if(row == null){
			row = sheet.createRow(INFO_ROW);
		}
		HSSFCell componentsSkippedInfoCell = row.createCell(INFO_COLUMN);
		componentsSkippedInfoCell.setCellValue("Number of not-reported Components (RAG Appropriate):" + this.componentsNotReported);
		
	}
	
}
