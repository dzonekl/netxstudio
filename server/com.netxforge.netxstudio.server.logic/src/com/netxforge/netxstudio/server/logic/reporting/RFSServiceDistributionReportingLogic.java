package com.netxforge.netxstudio.server.logic.reporting;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

public class RFSServiceDistributionReportingLogic extends OperatorReportingLogic {

	@Override
	protected void writeHeader(HSSFSheet sheet, DateTimeRange dtr) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Service Distribution");
		if (dtr != null) {
			super.periodCell.setCellValue(this.getModelUtils().date(
					getModelUtils().fromXMLDate(dtr.getBegin()))
					+ "-"
					+ this.getModelUtils().date(
							getModelUtils().fromXMLDate(dtr.getEnd())));
		}
	}

	@Override
	protected void writeContent(HSSFSheet sheet, NodeType nodeType) {
		// TODO Auto-generated method stub
	}

	protected String calculateFileName() {
		String baseName = super.calculateFileName();
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_MATRIX + "_" + baseName;
	}



	@Override
	protected void writeContent(HSSFSheet sheet, Service service, Node node,
			int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service,
			ServiceUser serviceUser, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Component component) {
		// TODO Auto-generated method stub
		
	}

}
