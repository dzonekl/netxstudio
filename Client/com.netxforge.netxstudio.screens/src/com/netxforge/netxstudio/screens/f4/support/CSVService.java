package com.netxforge.netxstudio.screens.f4.support;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public class CSVService {

	private String[][] data = null;

	public static int ABORTED = 0;
	public static int OK = 1;

	public int go(FileReader fr) throws Exception {
		return go(new NullProgressMonitor(), fr);
	}

	public int go(IProgressMonitor monitor, FileReader fr) throws Exception {
		final BufferedReader reader = new BufferedReader(fr);
		final String delimiter = ",";

		final List<String[]> localData = new ArrayList<String[]>();
		String line;
		while ((line = reader.readLine()) != null) {
			final StringTokenizer tokenizer = new StringTokenizer(line,
					delimiter);
			final List<String> lineData = new ArrayList<String>();
			while (tokenizer.hasMoreElements()) {
				lineData.add(convert(tokenizer.nextToken()));
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

	public String[][] getRecords(){
		return data;
	}
	
	
}
