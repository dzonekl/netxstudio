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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MetricsPackage;

/**
 * Imports metrics from CVS.
 * 
 * @author Martin Taal
 */
public class CSVMetricValuesImporter extends AbstractMetricValuesImporter {

	private String[][] data = null;
	private static final String DEFAULT_DELIMITER = ",";

	public CSVMetricValuesImporter(IComponentLocator locator,
			ModelUtils modelUtils) {
		super(locator, modelUtils);
	}
	
	@Override
	protected int processFile(File file) throws Exception {
		final FileReader reader = new FileReader(file);
		setData(reader);

		if (getTotalRows() < getMapping().getFirstDataRow()) {
			getFailedRecords()
					.add(createMappingRecord("There is no data in the sheet, first data row is "
							+ getMapping().getFirstDataRow()
							+ " but the sheet has only "
							+ getTotalRows()
							+ " rows."));
			return 0;
		}
		reader.close();
		final int totalRows = processRows();
		return totalRows;
	}

	private void setData(FileReader fileReader) throws Exception {

		final BufferedReader reader = new BufferedReader(fileReader);

		if (!(getMapping() instanceof MappingCSV)) {
			return;
		}

		MappingCSV mapping = (MappingCSV) this.getMapping();
		final String delimiter = mapping != null
				&& mapping
						.eIsSet(MetricsPackage.Literals.MAPPING_CSV__DELIMITER) ? mapping
				.getDelimiter() : DEFAULT_DELIMITER;

		// Regex, splits quoted fragements separated by delimiter.
		Pattern p = Pattern.compile("(\".*?\"|[^" + delimiter + "]++)");
		final List<String[]> localData = new ArrayList<String[]>();
		String line;
		while ((line = reader.readLine()) != null) {

			// Split (by default) for encapsulated by quote char...
			// CB: http://work.netxforge.com/issues/159
			// See also: http://mindprod.com/jgloss/regex.html
			ArrayList<String> matchingList = Lists.newArrayList();
			Matcher matcher = p.matcher(line);
			while (matcher.find()) {
				final int gc = matcher.groupCount();
				// group 0 is the whole pattern matched,
				// loops runs from from 0 to gc, not 0 to gc-1 as is
				// traditional.
				for (int i = 0; i <= gc; i++) {
					String match = matcher.group(i);
					if (i > 0) { // Skip the outer group.
						matchingList.add(match);
					}
				}
			}

			final List<String> lineData = new ArrayList<String>();

			for (String s : matchingList) {
				lineData.add(convert(s));
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
		// CB, this rule should check the size is at least two chars.
		if (value.length() >= 2 && value.startsWith("\"")
				&& value.endsWith("\"")) {
			return value.substring(1, value.length() - 1);
		}
		return value;
	}

	@Override
	protected String getFileExtension() {
		return "csv";
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
		String s = getStringCellValue(row, column);
		if (s != null && s.length() > 0) {
			try {
				return Double.parseDouble(s);
			} catch (NumberFormatException nfe) {
				// Not parsable
			}
		}
		throw new IllegalStateException(
				"Expecting a numeric value, but the position (" + row + ","
						+ column + ") is empty");
	}

	@Override
	protected Date getDateCellValue(int rowNum, int column) {
		// Not applicable for the CSV format.
		return null;
	}
}
