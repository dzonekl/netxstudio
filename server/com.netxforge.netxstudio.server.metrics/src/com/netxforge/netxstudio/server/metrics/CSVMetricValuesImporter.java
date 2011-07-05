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
package com.netxforge.netxstudio.server.metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.netxforge.netxstudio.metrics.MappingCSV;

/**
 * Imports metrics from CVS.
 * 
 * @author Martin Taal
 */
public class CSVMetricValuesImporter extends MetricValuesImporter {

	private String[][] data = null;
	
	@Override
	protected int processFile(File file) throws Exception {
		final FileReader reader = new FileReader(file);
		setData(reader);

		if (getTotalRows() < getMapping().getFirstDataRow()) {
			getFailedRecords().add(
					createMappingRecord(
							-1,
							-1,
							"There is no data in the sheet, first data row is "
									+ getMapping().getFirstDataRow()
									+ " but the sheet has only "
									+ getTotalRows() + " rows."));
			return 0;
		}

		final int totalRows = processRows();
		return totalRows;
	}

	private void setData(FileReader fileReader) throws Exception {
		final BufferedReader reader = new BufferedReader(fileReader);
		final String delimiter = ((MappingCSV)getMapping()).getDelimiter();
		final List<String[]> localData = new ArrayList<String[]>();
		String line;
		while ((line = reader.readLine()) != null) {
			final StringTokenizer tokenizer = new StringTokenizer(line, delimiter);
			final List<String> lineData = new ArrayList<String>();
			while (tokenizer.hasMoreElements()) {
				lineData.add(convert(tokenizer.nextToken()));
			}
			localData.add(lineData.toArray(new String[lineData.size()]));
		}
		data = localData.toArray(new String[localData.size()][]);
	}
	
	private String convert(String value) {
		if (value == null) {
			return value;
		}
		if (value.trim().length() == 0) {
			return null;
		}
		if (value.startsWith("\"") && value.endsWith("\"")) {
			return value.substring(1, value.length() - 1);
		}
		return value;
	}

	@Override
	protected String getFileExtension() {
		return ".csv";
	}

	@Override
	protected int getTotalRows() {
		return data.length;
	}

	@Override
	protected String getStringCellValue(int row, int column) {
		return data[row][column];
	}

	@Override
	protected double getNumericCellValue(int row, int column) {
		return Double.parseDouble(getStringCellValue(row, column));
	}
}
