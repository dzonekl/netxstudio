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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.common.util.EList;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MappingRecord;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.ServerUtils;
import com.netxforge.netxstudio.server.job.WorkFlowRunMonitor;
import com.netxforge.netxstudio.server.metrics.NetworkElementLocator.IdentifierValue;

/**
 * The main entry class for the Metrics importing.
 * 
 * @author Martin Taal
 */
public abstract class MetricValuesImporter {

	public static final String ROOT_SYSTEM_PROPERTY = "metricSourceRoot";

	private MetricSource metricSource;

	private WorkFlowRunMonitor jobMonitor;

	@Inject
	@Server
	private IDataProvider dataProvider;

	@Inject
	private NetworkElementLocator networkElementLocator;

	private List<MappingRecord> failedRecords = new ArrayList<MappingRecord>();

	private List<ImportWarning> warnings = new ArrayList<ImportWarning>();

	private static final String DATE_PATTERN = "MM/dd/yyyy hh:mm:ss";

	private final SimpleDateFormat dateFormat = new SimpleDateFormat(
			DATE_PATTERN);

	private Throwable throwable;

	private Long startPeriodTime;
	private Long endPeriodTime;
	
	public void process() {
		// force that the same dataprovider is used
		// so that components retrieved by the networkElementLocator
		// participate in the same transaction
		networkElementLocator.setDataProvider(dataProvider);

		final long startTime = System.currentTimeMillis();
		long endTime = startTime;
		boolean errorOccurred = false;
		MappingStatistic mappingStatistic = null;
		try {
			jobMonitor.setTask("Processing metricsource "
					+ metricSource.getName());

			final String msLocation = metricSource.getMetricLocation();
			String rootUrl = System.getProperty(ROOT_SYSTEM_PROPERTY);
			if (!rootUrl.endsWith("/") && !msLocation.startsWith("/")) {
				rootUrl += "/";
			}
			final String fileOrDirectory = rootUrl + msLocation;
			int totalRows = 0;
			boolean noFiles = true;
			final StringBuilder fileList = new StringBuilder();
			final File rootFile = new File(fileOrDirectory);
			if (!rootFile.exists()) {
				jobMonitor.appendToLog("Root directory/file ("
						+ rootFile.getAbsolutePath() + ") does not exist");
				noFiles = true;
				errorOccurred = true;
			} else if (rootFile.isFile()) {
				if (rootFile.getName().endsWith(getFileExtension())) {
					try {
						final int beforeFailedSize = getFailedRecords().size();
						noFiles = false;
						fileList.append(rootFile.getAbsolutePath());
						jobMonitor.setMsg("Processing file "
								+ rootFile.getAbsolutePath());
						jobMonitor.appendToLog("Processing file "
								+ rootFile.getAbsolutePath());
						totalRows += processFile(rootFile);
						moveFile(rootFile,
								getFailedRecords().size() > beforeFailedSize);
					} catch (final Throwable t) {
						errorOccurred = true;
						jobMonitor.appendToLog("Error (" + t.getMessage()
								+ ") while processing file "
								+ rootFile.getAbsolutePath());
					}
				}
			} else {
				for (final File file : rootFile.listFiles()) {
					if (file.getName().endsWith(getFileExtension())) {
						try {
							final int beforeFailedSize = getFailedRecords()
									.size();
							noFiles = false;
							fileList.append((fileList.length() > 0 ? "\n" : "") + file.getAbsolutePath());

							jobMonitor.setMsg("Processing file "
									+ file.getAbsolutePath());
							jobMonitor.appendToLog("Processing file "
									+ file.getAbsolutePath());
							totalRows += processFile(file);
							moveFile(
									file,
									getFailedRecords().size() > beforeFailedSize);
						} catch (final Throwable t) {
							errorOccurred = true;
							jobMonitor.appendToLog("Error (" + t.getMessage()
									+ ") while processing file "
									+ file.getAbsolutePath());
						}
					}
				}
			}

			if (noFiles) {
				jobMonitor.appendToLog("No files found for processing");
			}

			jobMonitor.setMsg("Creating mappingstatistics");
			jobMonitor.incrementProgress(1, true);

			endTime = System.currentTimeMillis();
			mappingStatistic = createMappingStatistics(startTime, endTime,
					totalRows, null);
			if (noFiles) {
				mappingStatistic.setMessage("No files processed");
			} else {
				mappingStatistic.setMessage(fileList.toString());
			}
			if (errorOccurred || getFailedRecords().size() > 0) {
				jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, null);
			} else {
				jobMonitor.setFinished(JobRunState.FINISHED_SUCCESSFULLY, null);
			}
		} catch (final Throwable t) {
			jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, t);
			t.printStackTrace(System.err);
			mappingStatistic = createMappingStatistics(startTime, endTime, 0,
					t.getMessage());
		}
		getMetricSource().getStatistics().add(mappingStatistic);
		dataProvider.commitTransaction();
	}
	
	protected abstract String getFileExtension();

	private void moveFile(File file, boolean error) {
		if (error) {
			file.renameTo(new File(file.getAbsolutePath()
					+ ".done_with_failures"));
		} else {
			file.renameTo(new File(file.getAbsolutePath() + ".done"));
		}
	}

	protected abstract int processFile(File file) throws Exception;

	// create the mapping statistics on the basis of the errors and
	// warnings
	private MappingStatistic createMappingStatistics(long startTime,
			long endTime, int totalRows, String message) {
		final MappingStatistic statistic = MetricsFactory.eINSTANCE
				.createMappingStatistic();
		final DateTimeRange range = GenericsFactory.eINSTANCE
				.createDateTimeRange();
		range.setBegin(ServerUtils.getInstance().toXmlDate(new Date(startTime)));
		range.setEnd(ServerUtils.getInstance().toXmlDate(new Date(endTime)));
		statistic.setMappingDuration(range);
		statistic.setTotalRecords(totalRows);
		statistic.setMessage(message);

		// now add the failed records
		statistic.getFailedRecords().addAll(getFailedRecords());

		return statistic;
	}

	protected abstract int getTotalRows();
	
	protected int processRows() {
		jobMonitor.setMsg("Processing header row");
		
		jobMonitor.setMsg("Processing rows");
		int totalRows = 0;
		jobMonitor.setTotalWork(getTotalRows()
				- getMapping().getFirstDataRow() + 10);
		for (int rowNum = getMapping().getFirstDataRow(); rowNum <= getTotalRows(); rowNum++) {
			jobMonitor.setMsg("Processing row " + rowNum);
			jobMonitor.incrementProgress(1, (rowNum % 10) == 0);
			try {
				totalRows++;
				final List<IdentifierValue> elementIdentifiers = getIdentifierValues(rowNum);
				final Date timeStamp = getTimeStampValue(rowNum);
				final int periodHint = getPeriodHint(rowNum);

				for (final MappingColumn column : getMappingColumn()) {
					if (isMetric(column)) {
						final Component networkElement = getNetworkElementLocator()
								.locateNetworkElement(
										getValueDataKind(column)
												.getMetricRef(),
										elementIdentifiers);
						if (networkElement == null) {
							getFailedRecords()
									.add(createMappingRecord(rowNum, -1,
											"Could not locate network element for this row."));
							continue;
						}

						final Double value = getNumericCellValue(rowNum, column.getColumn());
						addMetricValue(column, timeStamp, networkElement,
								value, periodHint);
					}
				}
			} catch (final Exception e) {
				e.printStackTrace(System.err);
				getFailedRecords().add(
						createMappingRecord(rowNum, -1, e.getMessage()));
			}
		}
		return totalRows;
	}

	protected void processHeaderRow() {
		final int headerRow = getMapping().getHeaderRow();
		if (headerRow <= 0) {
			return;
		}

		for (final MappingColumn column : getMapping().getHeaderMappingColumns()) {
			if (column.getDataType() instanceof ValueDataKind
					&& ((ValueDataKind) column.getDataType()).getValueKind() == ValueKindType.DATETIME) {
			}		
		}		
	}

	private void addMetricValue(MappingColumn column, Date timeStamp,
			Component networkElement, Double dblValue, int periodHint) {
		final ValueDataKind valueDataKind = getValueDataKind(column);
		final Metric metric = valueDataKind.getMetricRef();
		NetXResource foundNetXResource = null;
		for (final NetXResource netXResource : networkElement.getResources()) {
			if (netXResource.getMetricRef() == metric) {
				foundNetXResource = netXResource;
				break;
			}
		}
		if (foundNetXResource == null) {
			foundNetXResource = LibraryFactory.eINSTANCE.createNetXResource();
			foundNetXResource.setMetricRef(metric);
			foundNetXResource.setShortName(metric.getName());
			foundNetXResource.setLongName(metric.getName());
			foundNetXResource.setUnitRef(metric.getUnitRef());
			networkElement.getResources().add(foundNetXResource);
		}
		MetricValueRange foundMvr = null;
		for (final MetricValueRange mvr : foundNetXResource
				.getMetricValueRanges()) {
			if (mvr.getKindHint() == valueDataKind.getKindHint()
					&& mvr.getPeriodHint() == periodHint) {
				foundMvr = mvr;
				break;
			}
		}
		if (foundMvr == null) {
			foundMvr = MetricsFactory.eINSTANCE.createMetricValueRange();
			foundMvr.setKindHint(valueDataKind.getKindHint());
			foundMvr.setPeriodHint(periodHint);
			foundNetXResource.getMetricValueRanges().add(foundMvr);
		}
		
		final long timeInMillis = timeStamp.getTime();
		Value value = null;
		for (final Value lookValue : foundMvr.getMetricValues()) {
			if (isSameTime(periodHint, timeInMillis, lookValue.getTimeStamp())) {
				value = lookValue;
				break;
			}
		}
		
		if (value == null) {
			value = GenericsFactory.eINSTANCE.createValue();
		}
		value.setTimeStamp(ServerUtils.getInstance().toXmlDate(timeStamp));
		value.setValue(dblValue);
		foundMvr.getMetricValues().add(value);
	}

	private boolean isSameTime(int period, long time1, XMLGregorianCalendar time2) {
		long diff = time1 - time2.toGregorianCalendar().getTimeInMillis();
		if (diff < 0) {
			diff = diff * -1;
		}
		return diff < (period * 60 * 1000 - 1);
	}
	
	private ValueDataKind getValueDataKind(MappingColumn column) {
		return (ValueDataKind) column.getDataType();
	}

	private boolean isMetric(MappingColumn column) {
		if (!(column.getDataType() instanceof ValueDataKind)) {
			return false;
		}
		final ValueDataKind valueDataKind = getValueDataKind(column);
		return valueDataKind.getValueKind() == ValueKindType.METRIC;
	}

	protected MappingRecord createMappingRecord(int row, int column,
			String message) {
		final MappingRecord record = MetricsFactory.eINSTANCE
				.createMappingRecord();
		record.setColumn(column + "");
		record.setRow(row + "");
		record.setMessage(message);
		return record;
	}

	private Date getTimeStampValue(int rowNum) {
		for (final MappingColumn column : getMappingColumn()) {
			if (column.getDataType() instanceof ValueDataKind
					&& ((ValueDataKind) column.getDataType()).getValueKind() == ValueKindType.DATETIME) {
				try {
					return dateFormat.parse(getStringCellValue(rowNum, column.getColumn()));
				} catch (final Exception e) {
					throw new IllegalStateException(e);
				}
			}
		}
		return null;
	}

	private int getPeriodHint(int rowNum) {
		for (final MappingColumn column : getMappingColumn()) {
			if (column.getDataType() instanceof ValueDataKind
					&& ((ValueDataKind) column.getDataType()).getValueKind() == ValueKindType.PERIOD) {
				try {
					return new Double(getNumericCellValue(rowNum, column.getColumn())).intValue();
				} catch (final Exception e) {
					throw new IllegalStateException(e);
				}
			}
		}
		return -1;
	}

	private EList<MappingColumn> getMappingColumn() {
		return getMapping().getMappingColumns();
	}

	private List<IdentifierValue> getIdentifierValues(int row) {
		final List<IdentifierValue> result = new ArrayList<NetworkElementLocator.IdentifierValue>();
		for (final MappingColumn column : getMappingColumn()) {
			if (column.getDataType() instanceof IdentifierDataKind) {
				final IdentifierDataKind identifierDataKind = (IdentifierDataKind) column
						.getDataType();
				final IdentifierValue identifierValue = new IdentifierValue();
				identifierValue.setKind(identifierDataKind);
				identifierValue.setValue(getStringCellValue(row, column.getColumn()));
				result.add(identifierValue);
			}
		}
		return result;
	}
	
	protected abstract String getStringCellValue(int row, int column);
	
	protected abstract double getNumericCellValue(int row, int column);

	protected Mapping getMapping() {
		return metricSource.getMetricMapping();
	}

	public MetricSource getMetricSource() {
		return metricSource;
	}

	public void setMetricSource(MetricSource metricSource) {
		this.metricSource = metricSource;
	}

	public static class ImportError extends ImportWarning {
		private Throwable throwable;

		public Throwable getThrowable() {
			return throwable;
		}

		public void setThrowable(Throwable throwable) {
			this.throwable = throwable;
		}
	}

	public static class ImportWarning {
		private String message;
		private int row = -1;
		private int column = -1;

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getColumn() {
			return column;
		}

		public void setColumn(int column) {
			this.column = column;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	public List<ImportWarning> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<ImportWarning> warnings) {
		this.warnings = warnings;
	}

	public NetworkElementLocator getNetworkElementLocator() {
		return networkElementLocator;
	}

	public void setNetworkElementLocator(
			NetworkElementLocator networkElementLocator) {
		this.networkElementLocator = networkElementLocator;
	}

	public List<MappingRecord> getFailedRecords() {
		return failedRecords;
	}

	public void setFailedRecords(List<MappingRecord> failedRecords) {
		this.failedRecords = failedRecords;
	}

	public WorkFlowRunMonitor getJobMonitor() {
		return jobMonitor;
	}

	public void setJobMonitor(WorkFlowRunMonitor jobMonitor) {
		this.jobMonitor = jobMonitor;
	}

	public void setMetricSourceWithId(CDOID cdoID) {
		metricSource = (MetricSource) dataProvider.getTransaction().getObject(
				cdoID);
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

}
