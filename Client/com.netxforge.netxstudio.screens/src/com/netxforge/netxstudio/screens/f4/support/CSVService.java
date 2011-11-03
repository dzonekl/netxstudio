package com.netxforge.netxstudio.screens.f4.support;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MetricsPackage;

public class CSVService {

	private static final String DEFAULT_DELIMITER = ",";

	private String[][] data = null;

	public static int ABORTED = 0;
	public static int OK = 1;

	private MappingCSV mapping;

	public int go(FileReader fr) throws Exception {
		return go(new NullProgressMonitor(), fr);
	}

	public int go(IProgressMonitor monitor, FileReader fr) throws Exception {
		final BufferedReader reader = new BufferedReader(fr);

		final String delimiter = mapping != null
				&& mapping
						.eIsSet(MetricsPackage.Literals.MAPPING_CSV__DELIMITER) ? mapping
				.getDelimiter() : DEFAULT_DELIMITER;

		// Pattern p = Pattern.compile("^" + QUOTED_OR_NOT + "?" + delimiter
		// + QUOTED_OR_NOT + delimiter + QUOTED_OR_NOT + "?");

		Pattern p = Pattern.compile("(\".*?\"|.*?)" + delimiter + "| (\".*?\"|.*?)$");

		final List<String[]> localData = new ArrayList<String[]>();
		String line;
		while ((line = reader.readLine()) != null) {

			// Split (by default) for encapsulated by quote char...
			// CB: http://work.netxforge.com/issues/159
			// See also: http://mindprod.com/jgloss/regex.html
			if (line.isEmpty())
				continue;
			ArrayList<String> matchingList = Lists.newArrayList();
			Matcher matcher = p.matcher(line);
			while (matcher.find()) {
				final int gc = matcher.groupCount();
				// group 0 is the whole pattern matched,
				// loops runs from from 0 to gc, not 0 to gc-1 as is
				// traditional.
				for (int i = 0; i <= gc; i++) {
					String match = matcher.group(i);
					System.out.println(i + " : " + match);
					if (i > 0 && (match != null)) { // Skip the outer group.
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
		return OK;
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

	public String[][] getRecords() {
		return data;
	}

	public MappingCSV getMapping() {
		return mapping;
	}

	public void setMapping(MappingCSV mapping) {
		this.mapping = mapping;
	}

}
