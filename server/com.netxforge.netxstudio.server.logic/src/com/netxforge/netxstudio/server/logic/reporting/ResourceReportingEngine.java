package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.ToleranceMarker;

public class ResourceReportingEngine {

	private ModelUtils modelUtils;
	private DateTimeRange period;
	private HSSFWorkbook workBook;

	private static final int NODE_COLUMN = 2;

	public ResourceReportingEngine(ModelUtils modelUtils2, DateTimeRange period2,
			HSSFWorkbook workBook2) {
		this.modelUtils = modelUtils2;
		this.period = period2;
		this.workBook = workBook2;
	}

	
	public void writeComponentLine(int newRow, HSSFSheet sheet, Component component){
		HSSFRow componentRow = sheet.createRow(newRow);
		HSSFCell componentCell = componentRow.createCell(NODE_COLUMN + 1);
		
		// Build the presentation of a component. 
		StringBuilder builder = new StringBuilder();

		if (component instanceof Function) {
			builder.append(component.getName());

		} else if (component instanceof Equipment) {
			builder.append(((Equipment) component).getEquipmentCode());

			builder.append(component
					.eIsSet(LibraryPackage.Literals.COMPONENT__NAME) ? " name:" + component
					.getName() : "");
		}
		builder.append(component
				.eIsSet(LibraryPackage.Literals.COMPONENT__DESCRIPTION) ? " description:" + component
				.getDescription() : "");

		componentCell.setCellValue(builder.toString());
	}
	public void write(int newRow, HSSFSheet sheet, Component component,
			Map<NetXResource, List<Marker>> markersForNode) {
		int resourceIndex = newRow + 1;

		for (NetXResource resource : component.getResourceRefs()) {

			List<Marker> markersForResource = null;
			if (markersForNode != null && markersForNode.containsKey(resource)) {
				markersForResource = markersForNode.get(resource);
			}

			HSSFRow resourceRow = sheet.createRow(resourceIndex++);

			HSSFCell resourceCell = resourceRow.createCell(NODE_COLUMN + 2);
			resourceCell.setCellValue(resource.getLongName());

			for(MetricValueRange mvr : resource.getMetricValueRanges()){
				resourceIndex = writeRange(sheet, resourceIndex, resource,
						markersForResource, mvr.getIntervalHint());
			}
			

			// { // Writing day reports.
			// MetricValueRange mvr = this.getModelUtils()
			// .valueRangeForInterval(resource,
			// ModelUtils.MINUTES_IN_A_DAY);
			// if (mvr != null) {
			// resourceIndex = writeRange(markersForResource, sheet,
			// resourceIndex,
			// ModelUtils.MINUTES_IN_A_DAY, mvr);
			// }
			// }
			//
			// { // Writing weekly values report.
			// MetricValueRange mvr = this.getModelUtils()
			// .valueRangeForInterval(resource,
			// ModelUtils.MINUTES_IN_A_WEEK);
			// if (mvr != null) {
			// resourceIndex = writeRange(markersForResource, sheet,
			// resourceIndex,
			// ModelUtils.MINUTES_IN_A_WEEK, mvr);
			// }
			//
			// }
			// { // Writing monthly values report. (TODO, Should not be a fixed
			// // value.
			// MetricValueRange mvr = this.getModelUtils()
			// .valueRangeForInterval(resource,
			// ModelUtils.MINUTES_IN_A_MONTH);
			// if (mvr != null) {
			// resourceIndex = writeRange(markersForResource, sheet,
			// resourceIndex,
			// ModelUtils.MINUTES_IN_A_MONTH, mvr);
			// }
			//
			// }

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

	public int writeRange(HSSFSheet sheet, int resourceIndex,
			NetXResource resource, List<Marker> markersForResource, int interval) {
		MetricValueRange mvr = this.getModelUtils().valueRangeForInterval(
				resource, interval);
		if (mvr != null) {
			resourceIndex = writeRange(markersForResource, sheet,
					resourceIndex, interval, mvr);
		}
		return resourceIndex;
	}

	public int writeCapacity(HSSFSheet sheet, int resourceIndex,
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

	public int writeUtilization(HSSFSheet sheet, int resourceIndex,
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

	public int writeRange(List<Marker> markers, HSSFSheet sheet,
			int resourceIndex, int interval, MetricValueRange mvr) {

		// !Potentially long operation, as we sort of the whole rang.e
		List<Value> range = getModelUtils().sortByTimeStamp(
				mvr.getMetricValues());
		range = getModelUtils().filterValueInRange(range, this.getPeriod());

		HSSFRow resourceRow = sheet.createRow(resourceIndex++);

		HSSFCell mvrCell = resourceRow.createCell(NODE_COLUMN + 3);
		String fromMinutes = this.getModelUtils().fromMinutes(interval);
		mvrCell.setCellValue(fromMinutes);

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

			// Set the markers.
			if (markers != null) {
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

		}
		return resourceIndex;
	}

	// Getters and setters.

	public ModelUtils getModelUtils() {
		return modelUtils;
	}

	public void setModelUtils(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}

	public DateTimeRange getPeriod() {
		return period;
	}

	public void setPeriod(DateTimeRange period) {
		this.period = period;
	}

	public HSSFWorkbook getWorkBook() {
		return workBook;
	}

	public void setWorkBook(HSSFWorkbook workBook) {
		this.workBook = workBook;
	}

}
