package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.ToleranceMarker;
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
	
	
	
	
	@Override
	public void writeFinal(HSSFSheet sheet) {
		
		HSSFRow row = sheet.getRow(INFO_ROW);
		if(row == null){
			row = sheet.createRow(INFO_ROW);
		}
		HSSFCell nodeSkippedInfoCell = row.createCell(INFO_COLUMN);
		nodeSkippedInfoCell.setCellValue("Number of not-reported nodes (RAG Appropriate):" + this.nodesNotReported);

		HSSFRow componentsRow = sheet.getRow(INFO_ROW + 1);
		if(componentsRow == null){
			componentsRow = sheet.createRow(INFO_ROW + 1);
		}
		HSSFCell componentsSkippedInfoCell = componentsRow.createCell(INFO_COLUMN);
		componentsSkippedInfoCell.setCellValue("Number of not-reported Components (RAG Appropriate):" + this.componentsNotReported);
		
	}


	protected String calculateFileName() {
		String baseName = super.calculateFileName();
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_RESOURCE + "_" + baseName;
	}


	@Override
	protected void writeContent(HSSFSheet sheet, Service service, Node node,
			int rowIndex, int nodeTypeCount) {

		// We skip reporting for this node, using a static check.
		if (getModelUtils().ragShouldReport(
				getModelUtils().ragCountResourcesForNode(service, node,
						this.getPeriod()))) {

			int newRow = rowIndex == 0 ? NODE_ROW : sheet.getLastRowNum() + 1;

			HSSFRow nodeRow = sheet.getRow(newRow);
			if (nodeRow == null) {
				nodeRow = sheet.createRow(newRow);
			}

			HSSFCell nodeCell = nodeRow.createCell(NODE_COLUMN);
			nodeCell.setCellValue(node.getNodeID());

			markersForNode = this.getModelUtils().markersForNode(service, node,
					this.getPeriod());

		} else {

			nodesNotReported++;
		}
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

			List<Marker> markersForResource = null;
			if (this.markersForNode.containsKey(resource)) {
				markersForResource = this.markersForNode.get(resource);
			}

			HSSFRow resourceRow = sheet.createRow(resourceIndex++);

			HSSFCell resourceCell = resourceRow.createCell(NODE_COLUMN + 2);
			resourceCell.setCellValue(resource.getLongName());

			{ // Writing day reports.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_AN_HOUR);
				if (mvr != null) {
					resourceIndex = writeRange(markersForResource, sheet,
							resourceIndex, ModelUtils.MINUTES_IN_AN_HOUR, mvr);
				}
			}

			{ // Writing day reports.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_A_DAY);
				if (mvr != null) {
					resourceIndex = writeRange(markersForResource, sheet,
							resourceIndex, ModelUtils.MINUTES_IN_A_DAY, mvr);
				}

			}

			{ // Writing weekly values report.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_A_WEEK);
				if (mvr != null) {
					resourceIndex = writeRange(markersForResource, sheet,
							resourceIndex, ModelUtils.MINUTES_IN_A_WEEK, mvr);
				}

			}
			{ // Writing monthly values report. (TODO, Should not be a fixed
				// value.
				MetricValueRange mvr = this.getModelUtils()
						.valueRangeForInterval(resource,
								ModelUtils.MINUTES_IN_A_MONTH);
				if (mvr != null) {
					resourceIndex = writeRange(markersForResource, sheet,
							resourceIndex, ModelUtils.MINUTES_IN_A_MONTH, mvr);
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
		List<Value> capRange = getModelUtils().sortByTimeStamp(
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
			tsCell.setCellValue(getModelUtils().fromXMLDate(v.getTimeStamp()));
			tsCell.setCellStyle(cellStyle);

			// TODO, Perhaps some formatting for a double.
			HSSFCell valueCell = valueRow.createCell(valueIndex++);
			valueCell.setCellValue(v.getValue());
		}
		return resourceIndex;
	}

	private int writeUtilization(HSSFSheet sheet, int resourceIndex,
			NetXResource resource) {
		List<Value> capRange = getModelUtils().sortByTimeStamp(
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
		percenCellStyle.setDataFormat(createHelper.createDataFormat()
				.getFormat("0.00%"));

		HSSFRow tsRow = sheet.createRow(resourceIndex++);
		HSSFRow valueRow = sheet.createRow(resourceIndex++);

		// Write the values.
		int valueIndex = NODE_COLUMN + 4;
		for (Value v : capRange) {
			HSSFCell tsCell = tsRow.createCell(valueIndex);
			tsCell.setCellValue(getModelUtils().fromXMLDate(v.getTimeStamp()));
			tsCell.setCellStyle(tsCellStyle);

			HSSFCell valueCell = valueRow.createCell(valueIndex++);
			valueCell.setCellValue(v.getValue());
			valueCell.setCellStyle(percenCellStyle);

		}
		return resourceIndex;
	}

	private int writeRange(List<Marker> markers, HSSFSheet sheet,
			int resourceIndex, int interval, MetricValueRange mvr) {

		// !Potentially long operation, as we sort of the whole rang.e
		List<Value> range = getModelUtils().sortByTimeStamp(
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

		// Styles for markers.

		HSSFCellStyle markerStyleRed = this.getWorkBook().createCellStyle();
		markerStyleRed.setFillForegroundColor(IndexedColors.RED.getIndex());

		HSSFCellStyle markerStyleAmber = this.getWorkBook().createCellStyle();
		markerStyleAmber
				.setFillForegroundColor(IndexedColors.ORANGE.getIndex());

		// Write the values.
		int valueIndex = NODE_COLUMN + 4;
		for (Value v : range) {
			HSSFCell tsCell = tsRow.createCell(valueIndex);
			tsCell.setCellValue(getModelUtils().fromXMLDate(v.getTimeStamp()));
			tsCell.setCellStyle(cellStyle);
			// TODO, Perhaps some formatting for a double.
			HSSFCell valueCell = valueRow.createCell(valueIndex++);
			valueCell.setCellValue(v.getValue());
			Marker m;
			if ((m = this.getModelUtils().markerForValue(markers, v)) != null) {
				if (m instanceof ToleranceMarker) {
					switch (((ToleranceMarker) m).getLevel().getValue()) {
					case LevelKind.RED_VALUE: {
						valueCell.setCellStyle(markerStyleRed);
					}
						break;
					case LevelKind.AMBER_VALUE: {
						valueCell.setCellStyle(markerStyleAmber);
					}
						break;
					}
				}
			}
		}
		return resourceIndex;
	}

}
