package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
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
	protected void writeContent(HSSFSheet sheet, NodeType nodeType) {
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service, Node node,
			int index, int nodeTypeCount) {
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
				HSSFRow resourceRow = sheet.createRow(resourceIndex);
				resourceIndex += 2;
				HSSFCell resourceCell = resourceRow
						.createCell(SERVICEUSER_COLUMN + 1);
				resourceCell.setCellValue(dr.getLongName());

				List<Value> range = getModelUtils().sortByTimeStampAndReverse(
						dr.getValues());

				range = getModelUtils().filterValueInRange(range,
						this.getTimeRange());

				// Write the values.
				int valueIndex = SERVICEUSER_COLUMN + 2;

				for (Value v : range) {

					HSSFCell tsCell = resourceRow.createCell(valueIndex);
					tsCell.setCellValue(getModelUtils().fromXMLDate(
							v.getTimeStamp()));

					// TODO, Perhaps some formatting for a double.
					HSSFCell valueCell = resourceRow.createCell(valueIndex++);
					valueCell.setCellValue(v.getValue());

				}
			}
		}
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Component component) {
	}

}
