/*******************************************************************************
 * Copyright (c) 3 mrt. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.server.logic.reporting;

import org.apache.poi.ss.usermodel.Sheet;

import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NodeType;

public class RFSServiceDistributionReportingLogic extends
		OperatorReportingLogic {

	@Override
	protected void writeHeader(Sheet sheet, DateTimeRange dtr) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Service Distribution");
		if (dtr != null) {
			super.periodCell
					.setCellValue(NonModelUtils.date(NonModelUtils
							.fromXMLDate(dtr.getBegin()))
							+ "-"
							+ NonModelUtils.date(NonModelUtils.fromXMLDate(dtr
									.getEnd())));
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
