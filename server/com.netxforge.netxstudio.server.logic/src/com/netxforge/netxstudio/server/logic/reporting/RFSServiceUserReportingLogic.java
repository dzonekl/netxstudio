package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CreationHelper;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

public class RFSServiceUserReportingLogic extends OperatorReportingLogic {

	private static final int SERVICEUSER_COLUMN = 2;
	private static final int SERVICEUSER_ROW = 9;

	@Override
	protected void writeHeader(HSSFSheet sheet, DateTimeRange dtr) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Service User Profiles");
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
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_USER + "_" + baseName;
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service,
			ServiceUser serviceUser, int rowIndex, int columnIndex) {

		// Write the Service User
		int newRow = SERVICEUSER_ROW + (rowIndex * 3);

		HSSFRow ntRow = sheet.getRow(newRow);
		if (ntRow == null) {
			ntRow = sheet.createRow(newRow);
		}

		HSSFCell serviceUserCell = ntRow.createCell(SERVICEUSER_COLUMN);
		serviceUserCell.setCellValue(serviceUser.getName());

		if (serviceUser
				.eIsSet(ServicesPackage.Literals.SERVICE_USER__SERVICE_PROFILE)) {
			int resourceIndex = newRow + 1;
			for (DerivedResource dr : serviceUser.getServiceProfile()
					.getProfileResources()) {
				HSSFRow resourceRow = sheet.createRow(resourceIndex++);
				HSSFCell resourceCell = resourceRow
						.createCell(SERVICEUSER_COLUMN + 1);
				resourceCell.setCellValue(dr.getLongName());
				
				List<Value> range = getModelUtils().sortValuesByTimeStamp(
						dr.getValues());
				range = getModelUtils().filterValueInRange(range,
						this.getPeriod());

				CreationHelper createHelper = this.getWorkBook().getCreationHelper();
				HSSFCellStyle cellStyle = this.getWorkBook().createCellStyle();
				cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
						"m-d-yy h:mm"));
				
				HSSFRow tsRow = sheet.createRow(resourceIndex++);
				HSSFRow valueRow = sheet.createRow(resourceIndex++);
				
				// Write the values.
				int valueIndex = SERVICEUSER_COLUMN + 3;

				for (Value v : range) {

					HSSFCell tsCell = tsRow.createCell(valueIndex);
					tsCell.setCellValue(getModelUtils().fromXMLDate(
							v.getTimeStamp()));
					tsCell.setCellStyle(cellStyle);
					
					// TODO, Perhaps some formatting for a double.
					HSSFCell valueCell = valueRow.createCell(valueIndex++);
					valueCell.setCellValue(v.getValue());

				}
			}
		}
	}

	protected void processServiceUser(Service service, HSSFSheet sheet) {
		int rowIndex = 0;
		for (ServiceUser su : service.getServiceUserRefs()) {
			this.writeContent(sheet, service, su, rowIndex++, -1);
		}
	}
}
