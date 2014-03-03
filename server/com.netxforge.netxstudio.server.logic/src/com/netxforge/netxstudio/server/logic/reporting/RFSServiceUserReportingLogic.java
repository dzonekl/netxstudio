package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
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
	protected void writeHeader(Sheet sheet, DateTimeRange dtr) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Service User Profiles");
		if (dtr != null) {
			super.periodCell
					.setCellValue(NonModelUtils.date(NonModelUtils
							.fromXMLDate(dtr.getBegin()))
							+ "-"
							+ NonModelUtils.date(NonModelUtils.fromXMLDate(dtr
									.getEnd())));
		}
	}

	protected String calculateFileName() {
		String baseName = super.calculateFileName();
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_USER + "_" + baseName;
	}

	@Override
	protected void writeContent(Sheet sheet, Service service,
			ServiceUser serviceUser, int rowIndex, int columnIndex) {

		// Write the Service User
		int newRow = SERVICEUSER_ROW + (rowIndex * 3);

		Row ntRow = sheet.getRow(newRow);
		if (ntRow == null) {
			ntRow = sheet.createRow(newRow);
		}

		Cell serviceUserCell = ntRow.createCell(SERVICEUSER_COLUMN);
		serviceUserCell.setCellValue(serviceUser.getName());

		if (serviceUser
				.eIsSet(ServicesPackage.Literals.SERVICE_USER__SERVICE_PROFILE)) {
			int resourceIndex = newRow + 1;
			for (DerivedResource dr : serviceUser.getServiceProfile()
					.getProfileResources()) {
				Row resourceRow = sheet.createRow(resourceIndex++);
				Cell resourceCell = resourceRow
						.createCell(SERVICEUSER_COLUMN + 1);
				resourceCell.setCellValue(dr.getLongName());

				List<Value> range = StudioUtils.sortValuesByTimeStamp(dr
						.getValues());
				range = StudioUtils.valuesInsideRange(range, this.getPeriod());

				CreationHelper createHelper = this.getWorkBook()
						.getCreationHelper();
				CellStyle cellStyle = this.getWorkBook().createCellStyle();
				cellStyle.setDataFormat(createHelper.createDataFormat()
						.getFormat("m-d-yy h:mm"));

				Row tsRow = sheet.createRow(resourceIndex++);
				Row valueRow = sheet.createRow(resourceIndex++);

				// Write the values.
				int valueIndex = SERVICEUSER_COLUMN + 3;

				for (Value v : range) {

					Cell tsCell = tsRow.createCell(valueIndex);
					tsCell.setCellValue(NonModelUtils.fromXMLDate(v
							.getTimeStamp()));
					tsCell.setCellStyle(cellStyle);

					Cell valueCell = valueRow.createCell(valueIndex++);
					valueCell.setCellValue(v.getValue());

				}
			}
		}
	}

	protected void processServiceUser(Service service, Sheet sheet) {
		int rowIndex = 0;
		for (ServiceUser su : service.getServiceUserRefs()) {
			this.writeContent(sheet, service, su, rowIndex++, -1);
		}
	}
}
