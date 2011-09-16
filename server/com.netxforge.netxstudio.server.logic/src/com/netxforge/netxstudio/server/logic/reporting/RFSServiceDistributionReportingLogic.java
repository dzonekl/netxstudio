package com.netxforge.netxstudio.server.logic.reporting;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;

public class RFSServiceDistributionReportingLogic extends RFSServiceReportingLogic {

	@Override
	protected void writeHeader(HSSFSheet sheet) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Service Distribution");
		super.periodCell.setCellValue(this.getModelUtils().date(
				this.getStartTime())
				+ "-" + this.getModelUtils().date(this.getEndTime()));
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
	protected void writeContent(HSSFSheet sheet, Node node, int index,
			int nodeTypeCount) {
		// TODO Auto-generated method stub
		
	}

}
