package com.netxforge.netxstudio.server.logic.reporting;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

public class RFSServiceDashboardReportingLogic extends OperatorReportingLogic {

	private static final int NODETYPE_ROW = 9;
	private static final int NODE_ROW = 11;
	private static final int NODE_COLUMN = 2;
	private static final int NODE_HEIGHT = 4;
	private static final int NODE_WIDTH = 4;

	@Override
	protected void writeHeader(HSSFSheet sheet, DateTimeRange dtr) {
		super.createHeaderStructure(sheet);
		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Dashboard Red/Amber/Green");
		
		if( dtr != null){
		super.periodCell.setCellValue(this.getModelUtils().date(
				getModelUtils().fromXMLDate(dtr.getBegin()))
				+ "-"
				+ this.getModelUtils().date(
						getModelUtils().fromXMLDate(dtr.getEnd())));
		}
	}
	
	
	/**
	 * Write each NodeType into a separate column, starting from the 
	 * <code>NODETYPE_ROW</code>
	 */
	@Override
	protected void writeContent(HSSFSheet sheet, NodeType nodeType) {

		HSSFRow ntRow = sheet.getRow(NODETYPE_ROW);
		if (ntRow == null) {
			ntRow = sheet.createRow(NODETYPE_ROW);
		}

		HSSFCell ntCell = null;

		if (ntRow.getLastCellNum() == -1) {
			// This is our first node type.
			ntCell = ntRow.createCell(NODE_COLUMN);
		} else {
			ntCell = ntRow.createCell(ntRow.getLastCellNum() + 3);
		}
		if (ntCell != null) {
			ntCell.setCellValue(nodeType.getName());
		}
	}
	
	/**
	 * Write each Node per NodeType column, starting 
	 */
	@Override
	protected void writeContent(HSSFSheet sheet, Service service, Node node, int row, int column) {

		// Write the NODE.ID box.
		int newRow = NODE_ROW + (row * NODE_HEIGHT);
		int nodeColumn = NODE_COLUMN + (column * NODE_WIDTH);

		sheet.setColumnWidth(nodeColumn, 10 * 256);

		CellStyle nodeStyle = this.getWorkBook().createCellStyle();
		nodeStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
		nodeStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
		nodeStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
		nodeStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
		nodeStyle.setAlignment(CellStyle.ALIGN_CENTER);
		nodeStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		{
			HSSFRow cellRow = sheet.getRow(newRow);
			if (cellRow == null) {
				cellRow = sheet.createRow(newRow);
			}
			HSSFCell c1 = cellRow.createCell(nodeColumn);
			c1.setCellValue(node.getNodeID());
			c1.setCellStyle(nodeStyle);
		}
		{
			HSSFRow cellRow = sheet.getRow(newRow + 1);
			if (cellRow == null) {
				cellRow = sheet.createRow(newRow + 1);
			}
			HSSFCell c1 = cellRow.createCell(nodeColumn);
			c1.setCellStyle(nodeStyle);
		}
		{
			HSSFRow cellRow = sheet.getRow(newRow + 2);
			if (cellRow == null) {
				cellRow = sheet.createRow(newRow + 2);
			}
			HSSFCell c1 = cellRow.createCell(nodeColumn);
			c1.setCellStyle(nodeStyle);
		}

		sheet.addMergedRegion(new CellRangeAddress(newRow, newRow + NODE_HEIGHT
				- 2, nodeColumn, nodeColumn));

		// In between column.
		sheet.setColumnWidth(nodeColumn + 1, 2 * 256);

		// Write the RAG

		CellStyle ragStyle = this.getWorkBook().createCellStyle();

		ragStyle.setBorderTop(CellStyle.BORDER_THIN);
		ragStyle.setBorderBottom(CellStyle.BORDER_THIN);
		ragStyle.setBorderLeft(CellStyle.BORDER_THIN);
		ragStyle.setBorderRight(CellStyle.BORDER_THIN);
		ragStyle.setAlignment(CellStyle.ALIGN_CENTER);
		ragStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		ragStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

		int ragColumn = nodeColumn + 2;
		sheet.setColumnWidth(ragColumn, 2 * 256);
		
		
		
		int[] rag = this.getModelUtils().ragCountResourcesForNode(service, node, this.getPeriod());

		{
			HSSFRow cellRow = sheet.getRow(newRow);
			if (cellRow == null) {
				cellRow = sheet.createRow(newRow);
			}
			HSSFCell c1 = cellRow.createCell(ragColumn);

			c1.setCellValue("R");

			CellStyle rStyle = this.getWorkBook().createCellStyle();
			rStyle.cloneStyleFrom(ragStyle);
			rStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			c1.setCellStyle(rStyle);

			if (rag != null) {
				c1.setCellValue(rag[0]);
			}
		}
		{
			HSSFRow cellRow = sheet.getRow(newRow + 1);
			if (cellRow == null) {
				cellRow = sheet.createRow(newRow + 1);
			}
			HSSFCell c1 = cellRow.createCell(ragColumn);

			c1.setCellValue("A");

			CellStyle aStyle = this.getWorkBook().createCellStyle();
			aStyle.cloneStyleFrom(ragStyle);
			aStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
			c1.setCellStyle(aStyle);

			if (rag != null) {
				c1.setCellValue(rag[1]);
			}
		}
		{
			HSSFRow cellRow = sheet.getRow(newRow + 2);
			if (cellRow == null) {
				cellRow = sheet.createRow(newRow + 2);
			}
			HSSFCell c1 = cellRow.createCell(ragColumn);
			c1.setCellValue("G");
			CellStyle gStyle = this.getWorkBook().createCellStyle();
			gStyle.cloneStyleFrom(ragStyle);
			gStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			c1.setCellStyle(gStyle);

			if (rag != null) {
				c1.setCellValue(rag[2]);
			}

		}

	}

	protected String calculateFileName() {
		String baseName = super.calculateFileName();
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_DASH + "_" + baseName;
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service,
			ServiceUser serviceUser, int rowIndex, int columnIndex) {
	}

}
