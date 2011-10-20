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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.importer.NetworkElementLocator.IdentifierValue;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MappingRecord;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.scheduling.JobRunState;

/**
 * The main entry class for the Metrics importing.
 * 
 * @author Martin Taal
 */
public abstract class AbstractMetricValuesImporter implements IImporterHelper {

	public static final String ROOT_SYSTEM_PROPERTY = "metricSourceRoot";

	private MetricSource metricSource;

	private IRunMonitor jobMonitor;

	public void setImporter(AbstractMetricValuesImporter importer) {
		// Ignore, should not be called here.
	}

	// Note: Not injected, as we inject with a local provider.
	protected IDataProvider dataProvider;

	@Inject
	protected NetworkElementLocator networkElementLocator;

	@Inject
	private ModelUtils modelUtils;

	private List<MappingRecord> failedRecords = new ArrayList<MappingRecord>();

	private List<ImportWarning> warnings = new ArrayList<ImportWarning>();

	private Throwable throwable;

	private int intervalHint = 60;
	private Date timeStamp = null;

	private DateTimeRange mappingPeriodEstimate = GenericsFactory.eINSTANCE
			.createDateTimeRange();
	private int intervalEstimate = -1;

	private List<IdentifierValue> headerIdentifiers = new ArrayList<NetworkElementLocator.IdentifierValue>();

	/**
	 * The helper provides implementation of specialized methods depending on
	 * the environmnet (Client or Server).
	 * 
	 */
	private IImporterHelper helper;

	public void process() {

		initializeProviders(networkElementLocator);

		final long startTime = System.currentTimeMillis();
		long endTime = startTime;

		boolean errorOccurred = false;
		MappingStatistic mappingStatistic = null;
		try {
			jobMonitor.setTask("Processing metricsource "
					+ metricSource.getName());

			final String msLocation = metricSource.getMetricLocation();

			String rootUrl = System.getProperty(ROOT_SYSTEM_PROPERTY);
			// CB 27-09-2011 ROOT_SYSTEM_PROPERTY as fallback, on the server
			// setting.
			Resource settingsResource = this.getDataProvider().getResource(
					NetxstudioPackage.Literals.SERVER_SETTINGS);
			if (settingsResource != null
					&& settingsResource.getContents().size() == 1) {
				ServerSettings settings = (ServerSettings) settingsResource
						.getContents().get(0);
				rootUrl = settings.getImportPath();
			}

			// CB 27-09-2011,
			if (!rootUrl.endsWith(File.separator)
					&& !msLocation.startsWith(File.separator)) {
				rootUrl += File.separator;
			}

			final String fileOrDirectory = rootUrl + msLocation;
			int totalRows = 0;
			boolean noFiles = true;
			final StringBuilder fileList = new StringBuilder();
			final File rootFile = new File(fileOrDirectory);

			String filterPattern = metricSource.getFilterPattern();
			if (filterPattern == null && getFileExtension() != null) {
				// filterPattern = "([^\\s]+(\\.(?i)(" + getFileExtension() +
				// "))$)";
				filterPattern = ".*" + getFileExtension(); // TODO, narrow down
			} else {
				Pattern.compile(filterPattern);
			}

			if (!rootFile.exists()) {
				jobMonitor.appendToLog("Root directory/file ("
						+ rootFile.getAbsolutePath() + ") does not exist");
				noFiles = true;
				errorOccurred = true;
			} else if (rootFile.isFile()) {
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
			} else {
				for (final File file : rootFile.listFiles()) {
					final String fileName = file.getName();
					if (filterPattern == null
							|| fileName.matches(filterPattern)) {
						try {
							final int beforeFailedSize = getFailedRecords()
									.size();
							noFiles = false;
							fileList.append((fileList.length() > 0 ? "\n" : "")
									+ file.getAbsolutePath());

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
					totalRows, null, mappingPeriodEstimate,
					getMappingIntervalEstimate());
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
			String message = t.getMessage();
			if (t instanceof PatternSyntaxException) {
				message = "File filter pattern is not valid";
			}

			jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, t);
			t.printStackTrace(System.err);
			mappingStatistic = createMappingStatistics(startTime, endTime, 0,
					message, mappingPeriodEstimate,
					getMappingIntervalEstimate());

		}
		getMetricSource().getStatistics().add(mappingStatistic);
		getDataProvider().commitTransaction();
	}

	protected int getMappingIntervalEstimate() {
		return this.intervalEstimate;
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

	public void setImportHelper(IImporterHelper helper) {
		this.helper = helper;
	}

	protected abstract int processFile(File file) throws Exception;

	// create the mapping statistics on the basis of the errors and
	// warnings
	protected MappingStatistic createMappingStatistics(long startTime,
			long endTime, int totalRows, String message,
			DateTimeRange periodEstimate, int intervalEstimate) {
		final MappingStatistic statistic = MetricsFactory.eINSTANCE
				.createMappingStatistic();
		final DateTimeRange range = GenericsFactory.eINSTANCE
				.createDateTimeRange();
		range.setBegin(modelUtils.toXMLDate(new Date(startTime)));
		range.setEnd(modelUtils.toXMLDate(new Date(endTime)));

		statistic.setMappingDuration(range);
		statistic.setTotalRecords(totalRows);
		statistic.setMessage(message);
		statistic.setPeriodEstimate(periodEstimate);
		statistic.setIntervalEstimate(intervalEstimate);

		// now add the failed records
		statistic.getFailedRecords().addAll(getFailedRecords());

		return statistic;
	}

	protected abstract int getTotalRows();

	protected int processRows() {

		if (getMapping().getIntervalHint() > 0) {
			intervalHint = getMapping().getIntervalHint();
			intervalEstimate = intervalHint;
		}

		jobMonitor.setMsg("Processing header row");
		processHeaderRow();

		jobMonitor.setMsg("Processing rows");
		int totalRows = 0;
		jobMonitor.setTotalWork(getTotalRows() - getMapping().getFirstDataRow()
				+ 10);
		for (int rowNum = getMapping().getFirstDataRow(); rowNum < getTotalRows(); rowNum++) {
			jobMonitor.setMsg("Processing row " + rowNum);
			jobMonitor.incrementProgress(1, (rowNum % 10) == 0);
			try {
				totalRows++;

				// We need at least a node and a component.
				
				
				IdentifierValidator validator = new IdentifierValidator();
				
				final List<IdentifierValue> elementIdentifiers = getIdentifierValues(
						getMappingColumn(), rowNum);
				validator.validateIdentifiers(elementIdentifiers);
				
				if (!validator.hasNodeAndChild()) {
					if( validator.hasNode()){
						// Check for auto-create. 
//						throw new java.lang.IllegalStateException(
//								"At least one child of Node Identifier is required");
						
					}else{
						// here we need to bail, not even a Node?
						throw new java.lang.IllegalStateException(
								"Node Identifier is required");
					}
				}

				final Date rowTimeStamp = getTimeStampValue(getMappingColumn(),
						rowNum);

				final int intervalHintFromRow = getIntervalHint(rowNum);
				// give preference to the intervalhint from a row mapping.
				this.intervalEstimate = intervalHintFromRow;

				for (final MappingColumn column : getMappingColumn()) {
					if (isMetric(column)) {
						// Check that the metric ref is set, other wise bail.
						if (!getValueDataKind(column)
								.eIsSet(MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF)) {
							throw new java.lang.IllegalStateException(
									"Metric reference not set");
						}

						final Component networkElement = getNetworkElementLocator()
								.locateNetworkElement(
										getValueDataKind(column).getMetricRef(),
										elementIdentifiers);

						if (networkElement == null) {
							getFailedRecords().add(
									createNotFoundNetworkElementMappingRecord(
											getValueDataKind(column)
													.getMetricRef(), rowNum,
											getNetworkElementLocator()
													.getFailedIdentifiers()));
							continue;
						}

						final Double value = getNumericCellValue(rowNum,
								column.getColumn());
						
						addMetricValue(column, rowTimeStamp, networkElement,
								value, intervalHintFromRow);
						this.updatePeriodEstimate(rowTimeStamp);
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
	
	
	/**
	 * Validator for the mapping identifiers. 
	 */
	static class IdentifierValidator {

		int countNode = 0;
		int countComponent = 0;
		int countRelationship = 0;
		
		public void validateIdentifiers(
				List<IdentifierValue> elementIdentifiers) {

			
			for (IdentifierValue iv : elementIdentifiers) {
				switch (iv.getKind().getObjectKind().getValue()) {
				case ObjectKindType.EQUIPMENT_VALUE:
				case ObjectKindType.FUNCTION_VALUE: {
					countComponent++;
					break;
				}
				case ObjectKindType.NODE_VALUE: {
					countNode++;
					break;
				}
				case ObjectKindType.RELATIONSHIP_VALUE: {
					countRelationship++;
					break;
				}
				}
			}

		}
		
		public boolean hasNodeAndChild(){
			if (countNode > 0 && (countComponent > 0 || countRelationship > 0)) {
				return true;
			} else {
				return false;
			}
		} 
		
		public boolean hasNode(){
			return countNode > 0;
		} 
		
	}

	public DateTimeRange getMappingPeriodEstimate() {
		return mappingPeriodEstimate;
	}

	private void updatePeriodEstimate(Date timestamp) {

		// Assume chronological order of timestamps. Will fail otherwise.
		XMLGregorianCalendar xmlDate = modelUtils.toXMLDate(timestamp);
		if (!mappingPeriodEstimate
				.eIsSet(GenericsPackage.Literals.DATE_TIME_RANGE__BEGIN)) {
			mappingPeriodEstimate.setBegin(xmlDate);
		}
		mappingPeriodEstimate.setEnd(xmlDate);
	}

	@SuppressWarnings("unused")
	private String createNetworkElementLocatorLog(Metric metric,
			List<IdentifierValue> identifierValues) {
		final StringBuilder sb = new StringBuilder();
		sb.append("Could not locate networkElement for metric "
				+ metric.getName());
		sb.append("Using identifiers: ");
		for (final IdentifierValue idValue : identifierValues) {
			sb.append(" - " + idValue.getKind().getObjectKind().getName()
					+ ": " + idValue.getValue());
		}
		return sb.toString();
	}

	protected void processHeaderRow() {
		final int headerRow = getMapping().getHeaderRow();
		if (headerRow <= 0) {
			return;
		}

		headerIdentifiers = getIdentifierValues(getMapping()
				.getHeaderMappingColumns(), headerRow);
		timeStamp = getTimeStampValue(getMapping().getHeaderMappingColumns(),
				headerRow);
		this.updatePeriodEstimate(timeStamp);
	}

	private void addMetricValue(MappingColumn column, Date timeStamp,
			Component networkElement, Double dblValue, int periodHint) {
		final Resource emfNetxResource = getDataProvider().getResource(
				modelUtils.getResourcePath(networkElement));

		final ValueDataKind valueDataKind = getValueDataKind(column);
		final Metric metric = valueDataKind.getMetricRef();
		NetXResource foundNetXResource = null;
		EList<EObject> objects = emfNetxResource.getContents();
		for (final Object object : objects) {
			final NetXResource netXResource = (NetXResource) object;
			if (netXResource.getComponentRef().cdoID()
					.equals(networkElement.cdoID())
					&& netXResource.getMetricRef().cdoID() == metric.cdoID()) {
				foundNetXResource = netXResource;
				break;
			}
		}
		if (foundNetXResource == null) {
			foundNetXResource = LibraryFactory.eINSTANCE.createNetXResource();
			foundNetXResource.setComponentRef(networkElement);
			foundNetXResource.setMetricRef(metric);
			foundNetXResource.setShortName(metric.getName());
			foundNetXResource.setLongName(metric.getName());
			foundNetXResource.setExpressionName(toValidExpressionName(metric
					.getName()));
			foundNetXResource.setUnitRef(metric.getUnitRef());
			networkElement.getResourceRefs().add(foundNetXResource);
			emfNetxResource.getContents().add(foundNetXResource);
			addToNode(networkElement, networkElement, new ArrayList<Integer>(),
					foundNetXResource);
		}
		objects = emfNetxResource.getContents();

		final Value value = GenericsFactory.eINSTANCE.createValue();
		value.setTimeStamp(modelUtils.toXMLDate(timeStamp));
		value.setValue(dblValue);

		addToValueRange(foundNetXResource, periodHint,
				valueDataKind.getKindHint(), Collections.singletonList(value),
				null, null);
	}

	private void addToNode(EObject originalEObject, EObject eObject,
			List<Integer> path, NetXResource resource) {
		final EObject container = eObject.eContainer();
		if (container instanceof Node) {
			final NodeType nodeType = ((Node) container)
					.getOriginalNodeTypeRef();
			List<?> componentObjects;
			if (originalEObject instanceof Equipment) {
				componentObjects = nodeType.getEquipments();
			} else {
				componentObjects = nodeType.getFunctions();
			}
			Object currentObject = null;
			for (final Integer index : path) {
				currentObject = componentObjects.get(index);

				if (originalEObject instanceof Equipment) {
					componentObjects = ((Equipment) currentObject)
							.getEquipments();
				} else {
					componentObjects = ((Function) currentObject)
							.getFunctions();
				}
			}
			boolean found = false;
			for (final NetXResource netxResource : ((Component) currentObject)
					.getResourceRefs()) {
				if (netxResource.getMetricRef() == resource.getMetricRef()) {
					found = true;
					break;
				}
			}
			if (!found) {
				final NetXResource copiedNetXResource = EcoreUtil
						.copy(resource);
				final Resource emfNetxResource = getDataProvider().getResource(
						modelUtils.getResourcePath((EObject) currentObject));
				emfNetxResource.getContents().add(copiedNetXResource);
				((Component) currentObject).getResourceRefs().add(
						copiedNetXResource);
			}
		} else {
			final EStructuralFeature eFeature = eObject.eContainingFeature();
			final List<?> values = (List<?>) container.eGet(eFeature);
			path.add(0, values.indexOf(eObject));
			addToNode(originalEObject, container, path, resource);
		}

	}

	private String toValidExpressionName(String value) {
		final StringBuilder sb = new StringBuilder();
		for (final char c : value.toCharArray()) {
			boolean validChar = '0' <= c && c <= '9';
			validChar |= 'A' <= c && c <= 'Z';
			validChar |= 'a' <= c && c <= 'z';
			if (validChar) {
				sb.append(c);
			} else {
				sb.append("_");
			}
		}
		return sb.toString();
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

	protected MappingRecord createNotFoundNetworkElementMappingRecord(
			Metric metric, int rowNum, List<IdentifierValue> failedIdentifiers) {
		final StringBuilder sb = new StringBuilder();
		sb.append("Could not locate networkElement for metric "
				+ metric.getName());
		sb.append(". Failed on identifiers: ");
		for (final IdentifierValue idValue : failedIdentifiers) {
			sb.append(" - " + idValue.getKind().getObjectKind().getName()
					+ ": " + idValue.getValue());
		}
		final int failedColumn = failedIdentifiers.size() > 0 ? failedIdentifiers
				.get(0).getColumn() : -1;
		return createMappingRecord(rowNum, failedColumn, sb.toString());
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

	private Date getTimeStampValue(List<MappingColumn> mappingColumns,
			int rowNum) {
		if (timeStamp != null) {
			return timeStamp;
		}
		try {

			for (final MappingColumn column : mappingColumns) {
				if (column.getDataType() instanceof ValueDataKind
						&& ((ValueDataKind) column.getDataType())
								.getValueKind() == ValueKindType.DATETIME) {
					final ValueDataKind value = (ValueDataKind) column
							.getDataType();
					final SimpleDateFormat dateFormat;
					if (value.getFormat() != null) {
						dateFormat = new SimpleDateFormat(value.getFormat());
					} else {
						dateFormat = new SimpleDateFormat(
								ModelUtils.DEFAULT_DATE_TIME_PATTERN);
					}

					return dateFormat.parse(getStringCellValue(rowNum,
							column.getColumn()));
				}
			}

			String datePattern = null;
			String timePattern = null;
			String dateValue = null;
			String timeValue = null;
			for (final MappingColumn column : mappingColumns) {
				if (column.getDataType() instanceof ValueDataKind) {
					final ValueDataKind value = (ValueDataKind) column
							.getDataType();
					if (value.getValueKind() == ValueKindType.DATE) {
						datePattern = value.getFormat();
						dateValue = getStringCellValue(rowNum,
								column.getColumn());
					}
					if (value.getValueKind() == ValueKindType.TIME) {
						timePattern = value.getFormat();
						timeValue = getStringCellValue(rowNum,
								column.getColumn());
					}
				}
			}
			if (dateValue != null && timeValue != null) {
				String pattern = ModelUtils.DEFAULT_DATE_TIME_PATTERN;
				if (datePattern != null && timePattern != null) {
					pattern = datePattern + " " + timePattern;
				}
				final SimpleDateFormat dateFormat = new SimpleDateFormat(
						pattern);

				return dateFormat.parse(dateValue + " " + timeValue);
			}
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
		return new Date();
	}

	private int getIntervalHint(int rowNum) {
		for (final MappingColumn column : getMappingColumn()) {
			if (column.getDataType() instanceof ValueDataKind
					&& ((ValueDataKind) column.getDataType()).getValueKind() == ValueKindType.INTERVAL) {
				try {
					return new Double(getNumericCellValue(rowNum,
							column.getColumn())).intValue();
				} catch (final Exception e) {
					throw new IllegalStateException(e);
				}
			}
		}
		return intervalHint;
	}

	private EList<MappingColumn> getMappingColumn() {
		return getMapping().getDataMappingColumns();
	}

	/**
	 * 
	 * @param mappingColumns
	 * @param row
	 * @return
	 */
	private List<IdentifierValue> getIdentifierValues(
			List<MappingColumn> mappingColumns, int row) {
		final List<IdentifierValue> result = new ArrayList<NetworkElementLocator.IdentifierValue>(
				headerIdentifiers);
		for (final MappingColumn column : mappingColumns) {
			if (column.getDataType() instanceof IdentifierDataKind) {
				final IdentifierDataKind identifierDataKind = (IdentifierDataKind) column
						.getDataType();
				final IdentifierValue identifierValue = new IdentifierValue();
				identifierValue.setColumn(column.getColumn());
				identifierValue.setKind(identifierDataKind);
				identifierValue.setValue(getStringCellValue(row,
						column.getColumn()));
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

	public IRunMonitor getJobMonitor() {
		return jobMonitor;
	}

	public void setJobMonitor(IRunMonitor jobMonitor) {
		this.jobMonitor = jobMonitor;
	}

	public void setMetricSourceWithId(CDOID cdoID) {
		metricSource = (MetricSource) getDataProvider().getTransaction()
				.getObject(cdoID);
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	/**
	 * Delegate to the currently set helper.
	 */
	public void addToValueRange(NetXResource foundNetXResource, int periodHint,
			KindHintType kindHintType, List<Value> newValues, Date start,
			Date end) {
		if (helper != null) {
			this.helper.addToValueRange(foundNetXResource, periodHint,
					kindHintType, newValues, start, end);
		} else {
			throw new java.lang.IllegalStateException(
					"AbstractMetricValueImporter: Import helper should be set");
		}
	}

	/**
	 * Delegate to the currently set helper.
	 */
	public void initializeProviders(NetworkElementLocator networkElementLocator) {
		if (helper != null) {
			helper.initializeProviders(networkElementLocator);
		} else {
			throw new java.lang.IllegalStateException(
					"AbstractMetricValueImporter: Import helper should be set");
		}
	}

	/**
	 * Delegate to the currently set helper.
	 */
	public IDataProvider getDataProvider() {

		if (dataProvider == null) {
			if (helper != null) {
				return helper.getDataProvider();
			} else {
				throw new java.lang.IllegalStateException(
						"AbstractMetricValueImporter: Import helper should be set");
			}
		} else {
			return dataProvider;
		}
	}

}