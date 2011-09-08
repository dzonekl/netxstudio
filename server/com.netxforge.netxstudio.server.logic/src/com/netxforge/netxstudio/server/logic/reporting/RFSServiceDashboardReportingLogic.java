package com.netxforge.netxstudio.server.logic.reporting;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public class RFSServiceDashboardReportingLogic extends RFSServiceReportingLogic {

	@Override
	protected void createHeader(HSSFSheet sheet) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Dashboard Red/Amber/Green");
		super.periodCell.setCellValue(this.getModelUtils().date(
				this.getStartTime())
				+ "-" + this.getModelUtils().date(this.getEndTime()));
	}

	@Override
	protected void createContent(HSSFSheet sheet) {
		// TODO Auto-generated method stub

	}

	protected String calculateFileName() {
		String baseName = super.calculateFileName();
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_DASH + "_" + baseName;
	}

}
