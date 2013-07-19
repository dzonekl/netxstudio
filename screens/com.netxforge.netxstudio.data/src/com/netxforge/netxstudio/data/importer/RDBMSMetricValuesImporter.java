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
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import oracle.jdbc.driver.OracleDriver;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.metrics.DatabaseTypeType;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.scheduling.JobRunState;

/**
 * Imports metrics from a RDBMS.
 * 
 * @author Martin Taal
 */
public class RDBMSMetricValuesImporter extends AbstractMetricValuesImporter {

	private String[][] data = null;

	private Date start;
	private Date end;

	public RDBMSMetricValuesImporter(IComponentLocator locator,
			ModelUtils modelUtils) {
		super(locator, modelUtils);
	}

	@Override
	public void process() {
		// TODO: Make configurable
		start = new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000);
		end = new Date();

		setData();

		// force that the same dataprovider is used
		// so that components retrieved by the networkElementLocator
		// participate in the same transaction
		getComponentLocator().setDataProvider(getDataProvider());

		final long startTime = System.currentTimeMillis();
		long endTime = startTime;
		final boolean errorOccurred = false;
		MappingStatistic mappingStatistic = null;
		try {
			getJobMonitor().setTask(
					"Processing metricsource " + getMetricSource().getName());

			// CB TODO, Remove later.
			// final String msLocation = getMetricSource().getMetricLocation();
			final boolean noData = data.length == 0;

			final int totalRows = getTotalRows();

			if (data.length > 0) {
				processRows();
			} else {
				getJobMonitor().appendToLog("No data found for processing");
			}

			getJobMonitor().setMsg("Creating mappingstatistics");
			getJobMonitor().incrementProgress(1, true);

			endTime = System.currentTimeMillis();
			mappingStatistic = createMappingStatistics(startTime, endTime,
					totalRows, null,
					getMappingIntervalEstimate(), getFailedRecords());
			if (noData) {
				mappingStatistic.setMessage("No data processed");
			} else {
				mappingStatistic.setMessage("Data processed from  "
						+ getMetricSource().getMetricLocation());
			}
			if (errorOccurred || getFailedRecords().size() > 0) {
				getJobMonitor().setFinished(JobRunState.FINISHED_WITH_ERROR,
						null);
			} else {
				getJobMonitor().setFinished(JobRunState.FINISHED_SUCCESSFULLY,
						null);
			}
		} catch (final Throwable t) {
			getJobMonitor().setFinished(JobRunState.FINISHED_WITH_ERROR, t);
			t.printStackTrace(System.err);
			mappingStatistic = createMappingStatistics(startTime, endTime, 0,
					t.getMessage(),
					getMappingIntervalEstimate(), getFailedRecords());
		}finally{
			getRunPeriodEstimate().write(mappingStatistic);
		}

		super.addAndTruncate(mappingStatistic, getMetricSource()
				.getStatistics());
		getDataProvider().commitTransactionThenClose();
	}

	@Override
	protected int processFile(File file) throws Exception {
		throw new UnsupportedOperationException();
	}

	private ResultSet executeQuery() {
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				final ResultSet rs = stmt.executeQuery(createQuery());
				return rs;
			} finally {
				// if (stmt != null)
				// stmt.close();
				// if (conn != null)
				// conn.close();
			}
		} catch (final SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	private String createQuery() {
		String qry = getMapping().getQuery();
		qry = substitute(qry, "startDate", start, getMapping().getDateFormat());
		qry = substitute(qry, "endDate", end, getMapping().getDateFormat());
		qry = substitute(qry, "startTime", start, getMapping().getTimeFormat());
		qry = substitute(qry, "endTime", end, getMapping().getTimeFormat());
		qry = substitute(qry, "startDateTime", start, getMapping()
				.getDateTimeFormat());
		qry = substitute(qry, "endDateTime", end, getMapping()
				.getDateTimeFormat());
		System.err.println(qry);
		return qry;
	}

	private String substitute(String qry, String name, Date value,
			String formatPattern) {
		if (formatPattern == null) {
			return qry;
		}
		final SimpleDateFormat format = new SimpleDateFormat(formatPattern);
		final String sub = format.format(value);
		return qry.replace("${" + name + "}", sub);
	}

	public Connection getConnection() {
		try {
			final Driver driver;

			if (getMapping().getDatabaseType() == DatabaseTypeType.ORACLE) {
				driver = OracleDriver.class.newInstance();
			} else if (getMapping().getDatabaseType() == DatabaseTypeType.POSTGRES) {
				driver = org.postgresql.Driver.class.newInstance();
			} else {
				throw new IllegalStateException("Database type "
						+ getMapping().getDatabaseType() + " not supported");
			}
			final Properties info = new Properties();
			info.put("user", getMapping().getUser());
			info.put("password", getMapping().getPassword());
			return driver.connect(getMetricSource().getMetricLocation(), info);
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private void setData() {
		try {
			final ResultSet rs = executeQuery();
			final List<String[]> localData = new ArrayList<String[]>();
			final ResultSetMetaData rsMetaData = rs.getMetaData();
			final int numberOfColumns = rsMetaData.getColumnCount();
			while (rs.next()) {
				final String[] rowData = new String[numberOfColumns];
				for (int i = 1; i <= numberOfColumns; i++) {
					final Object colValue = rs.getObject(i);
					if (rs.wasNull()) {
						rowData[i - 1] = null;
					} else {
						rowData[i - 1] = colValue.toString();
					}
				}
				localData.add(rowData);
			}
			data = localData.toArray(new String[localData.size()][]);
			rs.getStatement().close();
			// rs.getStatement().getConnection().close();
		} catch (final SQLException e) {
			throw new IllegalStateException(e);
		}

	}

	@Override
	protected String getFileExtension() {
		throw new UnsupportedOperationException();
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

	@Override
	protected MappingRDBMS getMapping() {
		return (MappingRDBMS) super.getMapping();
	}

	@Override
	protected Date getDateCellValue(int rowNum, int column) {
		// N/A for the RDBMS format.
		return null;
	}
}