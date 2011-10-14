/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.importer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.netxforge.netxstudio.metrics.MappingXLS;

/**
 * Imports metrics from XLS.
 * 
 * @author Martin Taal
 */
public class XLSMetricValuesImporter extends AbstractMetricValuesImporter {

	private HSSFSheet currentSheet;
	
	@Override
	protected int processFile(File file) throws Exception {
		final InputStream is = new FileInputStream(file);
		final HSSFWorkbook workBook = new HSSFWorkbook(is);
		final HSSFSheet sheet = workBook.getSheetAt(((MappingXLS)getMapping())
				.getSheetNumber());
		currentSheet = sheet;

		if (sheet.getLastRowNum() < getMapping().getFirstDataRow()) {
			getFailedRecords().add(
					createMappingRecord(
							-1,
							-1,
							"There is no data in the sheet, first data row is "
									+ getMapping().getFirstDataRow()
									+ " but the sheet has only "
									+ sheet.getLastRowNum() + " rows."));
			return 0;
		}

		final int totalRows = processRows();
		currentSheet = null;
		return totalRows;
	}

	@Override
	protected int getTotalRows() {
		return currentSheet.getLastRowNum();
	}
	
	@Override
	protected String getFileExtension() {
		return "xls";
	}

	@Override
	protected String getStringCellValue(int row, int column) {
		return currentSheet.getRow(row)
		.getCell(column).getStringCellValue();
	}

	@Override
	protected double getNumericCellValue(int row, int column) {
		return currentSheet.getRow(row)
		.getCell(column).getNumericCellValue();
	}
}
