package com.netxforge.netxstudio.server.logic.reporting;

import org.apache.poi.ss.usermodel.Sheet;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NodeType;

public class RFSServiceDistributionReportingLogic extends OperatorReportingLogic {

	@Override
	protected void writeHeader(Sheet sheet, DateTimeRange dtr) {
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
	protected void writeContent(Sheet sheet, NodeType nodeType) {
	}

	protected String calculateFileName() {
		String baseName = super.calculateFileName();
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_MATRIX + "_" + baseName;
	}

}
