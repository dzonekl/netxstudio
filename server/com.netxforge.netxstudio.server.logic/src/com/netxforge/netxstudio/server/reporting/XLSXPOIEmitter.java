/*******************************************************************************
 * Copyright (c) 29 okt. 2013 NetXForge.
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
package com.netxforge.netxstudio.server.reporting;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

/**
 * A base class for emitting to XLSX using the Apache POI library.
 * 
 * @author Christophe
 * 
 */
public abstract class XLSXPOIEmitter implements IReportEmitter {

	// also consider the platform registered extensions and content types to
	// associate an editor with our file type and potentially show the output.
	private static final String XLSX_EXTENSION = "xlsx";

	private static final int HEADER_CELL_SIZE = 10;

	/**
	 * The current work book.
	 */
	private Workbook workBook;

	/**
	 * The current sheet.
	 */
	private Sheet sheet;

	public String getExtension() {
		return XLSX_EXTENSION;
	}

	public void activate(ICDOData dataProvider) {

		// A new workbook
		setWorkBook(new XSSFWorkbook());
	}

	public void flush(OutputStream stream) {

		try {
			workBook.write(stream);
		} catch (IOException e) {
			// CB TODO.

		}
	}

	public void nextPage(String serviceName) {
		sheet = this.getWorkBook().createSheet(serviceName);

	}

	public void writeHeader(DateTimeRange dtr) {
	}

	public void writeContent(NodeType nodeType) {
	}

	public void writeContent(Service service, Node node, int rowIndex,
			int columnIndex) {
	}

	public void writeContent(Service service, ServiceUser serviceUser,
			int rowIndex, int columnIndex) {
	}

	public void writeContent(Component component) {
	}

	public void writeFinal() {
	}

	public Workbook getWorkBook() {
		return workBook;
	}

	private void setWorkBook(Workbook workBook) {
		this.workBook = workBook;
	}

	public Sheet getSheet() {
		return sheet;
	}

	// Formated Header cells, to be filled by clients.
	protected Cell typeCell;
	protected Cell titleCell;
	protected Cell periodCell;

	public void createHeaderStructure() {

		CellStyle baseStyle = this.getWorkBook().createCellStyle();
		baseStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
		baseStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
		baseStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
		baseStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
		baseStyle.setAlignment(CellStyle.ALIGN_LEFT);

		CellStyle typeStyle = this.getWorkBook().createCellStyle();
		typeStyle.cloneStyleFrom(baseStyle);

		Font typeFont = getWorkBook().createFont();
		typeFont.setFontHeightInPoints((short) 24);
		typeStyle.setFont(typeFont);

		Row typeRow = sheet.createRow(0);
		typeCell = typeRow.createCell(0);
		typeCell.setCellValue("<Service Type>");
		typeCell.setCellStyle(typeStyle);

		for (int i = 1; i < HEADER_CELL_SIZE; i++) {
			typeRow.createCell(i).setCellStyle(typeStyle);
		}

		CellStyle titleStyle = this.getWorkBook().createCellStyle();
		titleStyle.cloneStyleFrom(baseStyle);

		Font titleFont = getWorkBook().createFont();
		titleFont.setFontHeightInPoints((short) 16);
		titleStyle.setFont(titleFont);

		Row titleRow = sheet.createRow(1);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("<Report title>");
		titleCell.setCellStyle(titleStyle);

		for (int i = 1; i < HEADER_CELL_SIZE; i++) {
			titleRow.createCell(i).setCellStyle(titleStyle);
		}

		Row periodRow = sheet.createRow(2);
		periodCell = periodRow.createCell(0);
		periodCell.setCellValue("<Period>");
		periodCell.setCellStyle(titleStyle);

		for (int i = 1; i < HEADER_CELL_SIZE; i++) {
			periodRow.createCell(i).setCellStyle(typeStyle);
		}

		// Merge
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,
				HEADER_CELL_SIZE - 1));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0,
				HEADER_CELL_SIZE - 1));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0,
				HEADER_CELL_SIZE - 1));
	}
}
