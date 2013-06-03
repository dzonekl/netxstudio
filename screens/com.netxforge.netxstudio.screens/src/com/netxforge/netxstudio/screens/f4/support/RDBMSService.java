package com.netxforge.netxstudio.screens.f4.support;

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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.netxforge.netxstudio.metrics.DatabaseTypeType;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MetricSource;

public class RDBMSService {

	private String[][] data = null;

	private Date start;
	private Date end;

	public static int ABORTED = 0;
	public static int OK = 1;
	private MappingRDBMS mapping;

	private MetricSource ms;

	private MappingRDBMS getMapping() {
		return mapping;
	}

	public int go(MetricSource ms, MappingRDBMS mapping) throws Exception {
		return go(new NullProgressMonitor(), ms, mapping);
	}

	public int go(IProgressMonitor monitor, MetricSource ms, MappingRDBMS mapping)
			throws Exception {
		this.mapping = mapping;
		this.ms = ms;
		// TODO: Make configurable
		start = new Date(System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000);
		end = new Date();

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

		return OK;
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

	private MetricSource getMetricSource() {
		return ms;
	}

	public String[][] getRecords() {
		return data;
	}

}
