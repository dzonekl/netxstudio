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

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MappingRecordXLS;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MappingXLSColumn;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.ServerModule;
import com.netxforge.netxstudio.server.ServerUtils;
import com.netxforge.netxstudio.server.metrics.NetworkElementLocator.IdentifierValue;

/**
 * The main entry class for the Metrics importing.
 * 
 * @author Martin Taal
 */
public class MetricValuesImporter {

	private MetricSource metricSource;
	
	@Inject
	@Server
	private IDataProvider dataProvider;
	private NetworkElementLocator networkElementLocator = new NetworkElementLocator();

	private List<MappingRecordXLS> failedRecords = new ArrayList<MappingRecordXLS>();

	private List<ImportWarning> warnings = new ArrayList<ImportWarning>();

	// object is node/function/equipment
	private Map<Metric, Map<Object, MetricValueRange>> metricValueRanges = new HashMap<Metric, Map<Object, MetricValueRange>>();

	private InputStream inputStream = null;

	private static final String DATE_PATTERN = "MM/dd/yyyy hh:mm:ss";

	private final SimpleDateFormat dateFormat = new SimpleDateFormat(
			DATE_PATTERN);

	public MetricValuesImporter() {
		ServerModule.getInjector().injectMembers(this);
	}

	public void process() {
		final long startTime = System.currentTimeMillis();
		long endTime = startTime;
		MappingStatistic mappingStatistic = null;
		try {
			final String location = metricSource.getMetricLocation();
			final InputStream is = (inputStream == null ? this.getClass()
					.getResourceAsStream(location) : inputStream);
			final HSSFWorkbook workBook = new HSSFWorkbook(is);
			final HSSFSheet sheet = workBook.getSheetAt(getMappingXLS()
					.getSheetNumber());

			final int totalRows = processRows(sheet);

			endTime = System.currentTimeMillis();
			mappingStatistic = createMappingStatistics(startTime, endTime,
					totalRows, null);
		} catch (final Exception e) {
			// TODO; improve logging
			e.printStackTrace(System.err);
			mappingStatistic = createMappingStatistics(startTime, endTime, 0,
					e.getMessage());
		}
		getMetricSource().getStatistics().add(mappingStatistic);
		storeMetricValues();
		dataProvider.commitTransaction();
	}

	private void storeMetricValues() {
		for (final Metric metric : metricValueRanges.keySet()) {
			final Map<Object, MetricValueRange> valueRangesByObject = metricValueRanges.get(metric);
			for (final Object object : valueRangesByObject.keySet()) {
				if (object instanceof Function) {
					final Function function = (Function)object;
					addToNetXResource(metric, valueRangesByObject.get(object), function.getFunctionResources());
				} else if (object instanceof Equipment) {
					final Equipment equipment = (Equipment)object;
					addToNetXResource(metric, valueRangesByObject.get(object), equipment.getEquipmentResources());
				}
			}
		}
	}
	
	private void addToNetXResource(Metric metric, MetricValueRange metricValueRange, EList<NetXResource> netXResources) {
		NetXResource addToNetXResource = null;
		for (final NetXResource netXResource: netXResources) {
			if (netXResource.getMetricRef() == metric) {
				addToNetXResource = netXResource;
			}
		}
		if (addToNetXResource == null) {
			addToNetXResource = LibraryFactory.eINSTANCE.createNetXResource();
			addToNetXResource.setMetricRef(metric);
			addToNetXResource.setShortName(metric.getName());
			addToNetXResource.setLongName(metric.getName());
			addToNetXResource.setUnitRef(metric.getUnitRef());
			netXResources.add(addToNetXResource);			
		}
		addToNetXResource.getMetricValueRanges().add(metricValueRange);
	}
	
	// create the mapping statistics on the basis of the errors and
	// warnings
	private MappingStatistic createMappingStatistics(long startTime,
			long endTime, int totalRows, String message) {
		final MappingStatistic statistic = MetricsFactory.eINSTANCE
				.createMappingStatistic();
		final DateTimeRange range = GenericsFactory.eINSTANCE
				.createDateTimeRange();
		range.setBegin(ServerUtils.getInstance().toXmlDate(
				new Date(startTime)));
		range.setEnd(ServerUtils.getInstance().toXmlDate(
				new Date(endTime)));
		statistic.setMappingDuration(range);
		statistic.setTotalRecords(totalRows);
		statistic.setMessage(message);

		// now add the failed records
		statistic.getFailedRecords().addAll(getFailedRecords());

		return statistic;
	}

	private int processRows(HSSFSheet sheet) {
		if (sheet.getLastRowNum() < getMappingXLS().getFirstDataRow()) {
			getFailedRecords().add(
					createMappingRecordXLS(
							-1,
							-1,
							"There is no data in the sheet, first data row is "
									+ getMappingXLS().getFirstDataRow()
									+ " but the sheet has only "
									+ sheet.getLastRowNum() + " rows."));
			return 0;
		}
		int totalRows = 0;
		for (int rowNum = getMappingXLS().getFirstDataRow(); rowNum <= sheet
				.getLastRowNum(); rowNum++) {
			System.err.println("Processing row " + rowNum);
			try {
				totalRows++;
				final List<IdentifierValue> elementIdentifiers = getIdentifierValues(
						sheet, rowNum);
				final Date timeStamp = getTimeStampValue(sheet, rowNum);
				final int periodHint = getPeriodHint(sheet, rowNum);
				
				for (final MappingXLSColumn xlsColumn : getMappingXLSColumn()) {
					if (isMetric(xlsColumn)) {
						final CDOObject networkElement = getNetworkElementLocator()
								.locateNetworkElement(
										getValueDataKind(xlsColumn)
												.getMetricRef(),
										elementIdentifiers);
						if (networkElement == null) {
							getFailedRecords()
									.add(createMappingRecordXLS(rowNum, -1,
											"Could not locate network element for this row."));
							continue;
						}

						final Double value = sheet.getRow(rowNum)
								.getCell(xlsColumn.getColumn())
								.getNumericCellValue();
						addMetricValue(xlsColumn, timeStamp, networkElement,
								value, periodHint);
					}
				}
			} catch (final Exception e) {
				e.printStackTrace(System.err);
				getFailedRecords().add(
						createMappingRecordXLS(rowNum, -1, e.getMessage()));
			}
		}
		return totalRows;
	}

	private void addMetricValue(MappingXLSColumn xlsColumn, Date timeStamp,
			Object networkElement, Double dblValue, int periodHint) {
		final ValueDataKind valueDataKind = getValueDataKind(xlsColumn);
		Map<Object, MetricValueRange> valueRanges = metricValueRanges
				.get(valueDataKind.getMetricRef());
		if (valueRanges == null) {
			valueRanges = new HashMap<Object, MetricValueRange>();
			metricValueRanges.put(valueDataKind.getMetricRef(), valueRanges);
		}
		MetricValueRange valueRange = valueRanges.get(networkElement);
		if (valueRange == null) {
			valueRange = MetricsFactory.eINSTANCE.createMetricValueRange();
			valueRange.setKindHint(valueDataKind.getKindHint());
			valueRange.setPeriodHint(periodHint);
			valueRanges.put(networkElement, valueRange);
		}
		final Value value = GenericsFactory.eINSTANCE.createValue();
		value.setTimeStamp(ServerUtils.getInstance()
				.toXmlDate(timeStamp));
		value.setValue(dblValue);
		valueRange.getMetricValues().add(value);
	}

	private ValueDataKind getValueDataKind(MappingXLSColumn column) {
		return (ValueDataKind) column.getDataType();
	}

	private boolean isMetric(MappingXLSColumn column) {
		if (!(column.getDataType() instanceof ValueDataKind)) {
			return false;
		}
		final ValueDataKind valueDataKind = getValueDataKind(column);
		return valueDataKind.getValueKind() == ValueKindType.METRIC;
	}

	private MappingRecordXLS createMappingRecordXLS(int row, int column,
			String message) {
		final MappingRecordXLS record = MetricsFactory.eINSTANCE
				.createMappingRecordXLS();
		record.setColumn(column);
		record.setRow(row);
		record.setMessage(message);
		return record;
	}

	private Date getTimeStampValue(HSSFSheet sheet, int rowNum) {
		for (final MappingXLSColumn xlsColumn : getMappingXLSColumn()) {
			if (xlsColumn.getDataType() instanceof ValueDataKind
					&& ((ValueDataKind) xlsColumn.getDataType()).getValueKind() == ValueKindType.DATETIME) {
				final Cell cell = sheet.getRow(rowNum).getCell(
						xlsColumn.getColumn());
				try {
					return dateFormat.parse(cell.getStringCellValue());
				} catch (final Exception e) {
					throw new IllegalStateException(e);
				}
			}
		}
		return null;
	}

	private int getPeriodHint(HSSFSheet sheet, int rowNum) {
		for (final MappingXLSColumn xlsColumn : getMappingXLSColumn()) {
			if (xlsColumn.getDataType() instanceof ValueDataKind
					&& ((ValueDataKind) xlsColumn.getDataType()).getValueKind() == ValueKindType.PERIOD) {
				final Cell cell = sheet.getRow(rowNum).getCell(
						xlsColumn.getColumn());
				try {
					return new Double(cell.getNumericCellValue()).intValue();
				} catch (final Exception e) {
					throw new IllegalStateException(e);
				}
			}
		}
		return -1;
	}

	private EList<MappingXLSColumn> getMappingXLSColumn() {
		return getMappingXLS().getMappingColumns();
	}

	private List<IdentifierValue> getIdentifierValues(HSSFSheet sheet, int row) {
		final List<IdentifierValue> result = new ArrayList<NetworkElementLocator.IdentifierValue>();
		for (final MappingXLSColumn xlsColumn : getMappingXLSColumn()) {
			if (xlsColumn.getDataType() instanceof IdentifierDataKind) {
				final IdentifierDataKind identifierDataKind = (IdentifierDataKind) xlsColumn
						.getDataType();
				final IdentifierValue identifierValue = new IdentifierValue();
				identifierValue.setKind(identifierDataKind);
				identifierValue.setValue(sheet.getRow(row)
						.getCell(xlsColumn.getColumn()).getStringCellValue());
				result.add(identifierValue);
			}
		}
		return result;
	}

	private MappingXLS getMappingXLS() {
		return (MappingXLS) metricSource.getMetricMapping();
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

	public List<MappingRecordXLS> getFailedRecords() {
		return failedRecords;
	}

	public void setFailedRecords(List<MappingRecordXLS> failedRecords) {
		this.failedRecords = failedRecords;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
