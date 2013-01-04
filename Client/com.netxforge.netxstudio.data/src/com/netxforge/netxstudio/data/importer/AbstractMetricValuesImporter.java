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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.BundleActivator;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.properties.IPropertiesProvider;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
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
 * The main entry class for the Metrics importing. Uses a delegation pattern so
 * this can be used on client and server.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public abstract class AbstractMetricValuesImporter implements IImporterHelper {

	public static final String ROOT_SYSTEM_PROPERTY = "metricSourceRoot";

	public static final boolean RENAME_FILE_AT_PROCESS = true;

	private MetricSource metricSource;

	private IRunMonitor jobMonitor;

	// Note: Not injected, as we inject with a local provider.
	protected IDataProvider dataProvider;

	@Inject
	protected IComponentLocator componentLocator;

	@Inject
	protected ModelUtils modelUtils;

	private List<MappingRecord> failedRecords = new ArrayList<MappingRecord>();

	private List<ImportWarning> warnings = new ArrayList<ImportWarning>();

	private Throwable throwable;

	private int intervalHint = 60;

	// Kept for each file.
	private DateTimeRange metricPeriodEstimate = GenericsFactory.eINSTANCE
			.createDateTimeRange();

	private int intervalEstimate = -1;

	private List<IComponentLocator.IdentifierDescriptor> headerIdentifiers = new ArrayList<IComponentLocator.IdentifierDescriptor>();

	/**
	 * The helper provides implementation of specialized methods depending on
	 * the environmnet (Client or Server).
	 * 
	 */
	private IImporterHelper helper;

	private CDOID cdoID;

	public static final String NETXSTUDIO_MAX_MAPPING_STATS_QUANTITY = "netxstudio.max.mapping.stats.quantity"; // How
																												// many
																												// stats
																												// to
																												// keep
																												// per
																												// metric
																												// source.
	public static final int NETXSTUDIO_MAX_MAPPING_STATS_QUANTITY_DEFAULT = 500; // How
																					// many
																					// stats
																					// to
																					// keep.

	/*
	 * Maximum number of stats per Metric Source.
	 */
	private int maxStats = -1;

	private TSProcessor tsProcessor;

	/** A cached header time stamp */
	private Date headerTimeStamp = null;

	public void process() {

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.traceEntry(DataActivator.TRACE_IMPORT_OPTION,
					"Start processing import");
		}

		initializeProviders(componentLocator);

		// Make sure our locator is ready.
		while (!componentLocator.isInitialized()) {
			System.out.println("waiting locator not ready...");
		}
		System.out.println("Locator ready...");

		final long startTime = System.currentTimeMillis();
		long endTime = startTime;
		boolean errorOccurred = false;
		int totalRows = 0;

		// The parent mapping statistic, later rewrite the end time, total rows
		// etc...
		final MappingStatistic mappingStatistic = createMappingStatistics(
				startTime, endTime, 0, null, metricPeriodEstimate,
				getMappingIntervalEstimate(), null);

		MetricSource src = getMetricSource();
		addAndTruncate(mappingStatistic, src.getStatistics());

		commitTransactionWithoutClosing();

		try {
			jobMonitor.setTask("Processing metricsource "
					+ getMetricSource().getName());

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"-- Processing metricsource "
								+ getMetricSource().getName());
			}

			final String msLocation = getMetricSource().getMetricLocation();

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

			// CB 27-09-2011, add a separator
			if (!rootUrl.endsWith(File.separator)
					&& !msLocation.startsWith(File.separator)) {
				rootUrl += File.separator;
			}

			final String fileOrDirectory = rootUrl + msLocation;

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"-- Calculated import directory for "
								+ getMetricSource().getName() + " ="
								+ fileOrDirectory);
			}

			boolean noFiles = true;
			final StringBuilder fileList = new StringBuilder();
			final File rootFile = new File(fileOrDirectory);

			String filterPattern = getMetricSource().getFilterPattern();
			if (filterPattern == null && getFileExtension() != null) {
				filterPattern = "[^\\s]+(\\.(?i)" + getFileExtension() + ")$";
			} else {
				// We concat the file extension, to the pattern automaticly.
				filterPattern = filterPattern.concat("(\\.(?i)"
						+ getFileExtension() + ")$");

				Pattern.compile(filterPattern);
			}

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"-- Looking for files with pattern" + filterPattern);
			}

			// Start processing in the specified root directory, make sure it
			// exists.
			if (!rootFile.exists()) {
				jobMonitor.appendToLog("Root directory/file ("
						+ rootFile.getAbsolutePath() + ") does not exist");
				noFiles = true;
				errorOccurred = true;
			} else if (rootFile.isFile()) {
				try {
					noFiles = false;
					fileList.append(rootFile.getAbsolutePath());
					totalRows += doProcessFile(rootFile, mappingStatistic);
				} catch (final Throwable t) {
					errorOccurred = true;
					jobMonitor.appendToLog("Error (" + t.getMessage()
							+ ") while processing file "
							+ rootFile.getAbsolutePath());
				}
			} else {
				// After each iteration, check if the scheduler is active, and
				// cancel otherwise.
				for (final File file : rootFile.listFiles()) {

					if (cancelled()) {
						// we are cancelled, abort the next file.
						if (DataActivator.DEBUG) {
							DataActivator.TRACE
									.trace(DataActivator.TRACE_IMPORT_OPTION,
											"Importer instructed to abort the import process");
						}
						break;
					}

					final String fileName = file.getName();

					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_IMPORT_OPTION,
								"-- Checking file=" + fileName);
					}
					if (filterPattern == null
							|| fileName.matches(filterPattern)) {
						try {
							fileList.append((fileList.length() > 0 ? "\n" : "")
									+ fileName);
							noFiles = false;
							totalRows += doProcessFile(file, mappingStatistic);

						} catch (final Throwable t) {
							errorOccurred = true;
							jobMonitor.appendToLog("Error (" + t.getMessage()
									+ ") while processing file "
									+ file.getAbsolutePath());
							if (DataActivator.DEBUG) {
								DataActivator.TRACE.trace(
										DataActivator.TRACE_IMPORT_OPTION,
										" -- Error processing file", t);
							}
						}
					}

				}
			}

			if (noFiles) {
				jobMonitor.appendToLog("No files found for processing");
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_OPTION,
							" -- No files found for processing");
				}
			}

			jobMonitor.setTask("Processing metricsource "
					+ getMetricSource().getName());
			jobMonitor.setMsg("Creating mappingstatistics");
			jobMonitor.incrementProgress(1, true);

			// Set the end time on the mapping stats.
			endTime = System.currentTimeMillis();
			mappingStatistic.getMappingDuration().setEnd(
					modelUtils.toXMLDate(new Date(endTime)));
			mappingStatistic.setPeriodEstimate(metricPeriodEstimate);
			mappingStatistic.setIntervalEstimate(intervalEstimate);
			mappingStatistic.setTotalRecords(totalRows);

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"Mapping statistics");
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						" -- from ="
								+ mappingStatistic.getMappingDuration()
										.getBegin()
								+ " to "
								+ mappingStatistic.getMappingDuration()
										.getEnd());
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						" -- total records =" + totalRows);
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_OPTION,
						" -- Period Estimate from ="
								+ metricPeriodEstimate.getBegin() + " to "
								+ metricPeriodEstimate.getEnd());
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						" -- Interval (estimate) =" + intervalEstimate);
			}

			// Moves the records from the subprocesses....
			// mappingStatistic.geecords().addAll(getFailedRecords());

			if (noFiles) {
				mappingStatistic.setMessage("No files processed");
			} else {
				String message = fileList.toString();
				if (message.length() > 2000) {
					mappingStatistic.setMessage(message.substring(0, 2000));
					if (DataActivator.DEBUG) {
						DataActivator.TRACE
								.trace(DataActivator.TRACE_IMPORT_OPTION,
										"Message too long for processing, trunked on 2000 characters!");
					}
				} else {
					mappingStatistic.setMessage(message);
				}
			}
			if (errorOccurred || getFailedRecords().size() > 0) {
				jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, null);
			} else {
				jobMonitor.setFinished(JobRunState.FINISHED_SUCCESSFULLY, null);
			}

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"Stop processing import for metric source"
								+ getMetricSource().getName());
			}

		} catch (final Throwable t) {
			String message = t.getMessage();
			if (t instanceof PatternSyntaxException) {
				message = "File filter pattern is not valid";
			}

			jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, t);

			// finalize with a mapping statistic.
			mappingStatistic.setMessage(message);
			mappingStatistic.setPeriodEstimate(metricPeriodEstimate);
			mappingStatistic.setTotalRecords(totalRows);
			// Moves the records to the parent.
			// mappingStatistic.getFailedRecords().addAll(getFailedRecords());

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"Error Processing metricsource "
								+ getMetricSource().getName(), t);
			}
		}

		commitTransactionAndClose();

	}

	public void setImporter(AbstractMetricValuesImporter importer) {
		// Ignore, should not be called here.
	}

	/**
	 * @param mappingStatistic
	 * @param statistics
	 */
	public void addAndTruncate(final MappingStatistic mappingStatistic,
			EList<MappingStatistic> statistics) {

		// Lazy init maxStats var.
		if (maxStats == -1) {
			boolean storeMaxStats = false;
			BundleActivator a = helper.getActivator();
			if (a instanceof IPropertiesProvider) {
				String property = ((IPropertiesProvider) a).getProperties()
						.getProperty(NETXSTUDIO_MAX_MAPPING_STATS_QUANTITY);
				if (property == null) {
					maxStats = new Integer(
							NETXSTUDIO_MAX_MAPPING_STATS_QUANTITY_DEFAULT);
					storeMaxStats = true;

				} else {
					try {
						maxStats = new Integer(property);
					} catch (NumberFormatException nfe) {

						if (DataActivator.DEBUG) {
							DataActivator.TRACE.trace(
									DataActivator.TRACE_IMPORT_OPTION,
									"Error reading property", nfe);
						}

						maxStats = new Integer(
								NETXSTUDIO_MAX_MAPPING_STATS_QUANTITY_DEFAULT);
						storeMaxStats = true;
					}
				}
			}

			if (storeMaxStats) {
				// Should be saved when the Activator stops!
				((IPropertiesProvider) a).getProperties().setProperty(
						NETXSTUDIO_MAX_MAPPING_STATS_QUANTITY,
						new Integer(maxStats).toString());
			}
		}

		statistics.add(0, mappingStatistic);

		// truncate the list, if exceeding max. size.
		if (statistics.size() > maxStats) {

			List<MappingStatistic> subList = Lists.newArrayList(statistics
					.subList(0, maxStats));
			boolean retainAll = statistics.retainAll(subList);

			if (retainAll) {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_OPTION,
							"truncing mapping statistics to max " + maxStats);
				}
			}
		}
	}

	/*
	 * Commits, but doesn't close the transaction nor the session.
	 */
	private void commitTransactionWithoutClosing() {
		// Commit in a throwable, otherwise the session woudn't be closed.
		try {
			CDOTransaction transaction = getDataProvider().getTransaction();
			transaction.setCommitComment(IDataProvider.SERVER_COMMIT_COMMENT);
			transaction.commit();
		} catch (final Throwable t) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_DETAILS_OPTION,
						"Commit failed", t);
			}
		}
	}

	private void commitTransactionAndClose() {
		try {
			getDataProvider().commitTransaction();
		} catch (final Throwable t) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_DETAILS_OPTION,
						"Commit failed", t);
			}
		} finally {
			getDataProvider().closeSession();
		}
	}

	private int doProcessFile(File file, MappingStatistic parentStatistic)
			throws Throwable {

		int rows = 0;

		final String fileName = file.getName();
		final String originalPath = file.getAbsolutePath();

		// Work with the renamed file, abort if rename fails.

		if (RENAME_FILE_AT_PROCESS) {
			file = preProcessFile(file);
			if (file == null) {
				return rows;
			}
		}

		this.getFailedRecords().clear();
		final int beforeFailedSize = getFailedRecords().size();

		final long startTime = System.currentTimeMillis();
		long endTime = startTime;

		// CB 13-01, changed to task, as msg, will be overwritten quickly.
		jobMonitor.setTask("Processing file " + fileName);
		jobMonitor.appendToLog("Processing file " + fileName);
		rows = processFile(file);

		int afterFailedSize = getFailedRecords().size();
		List<MappingRecord> fileFailedRecords = null;
		if (afterFailedSize > beforeFailedSize) {
			// http://work.netxforge.com/issues/324
			fileFailedRecords = this.getFailedRecords().subList(
					beforeFailedSize, afterFailedSize);
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"-- # of failed records for file=" + file.getName()
								+ " is =" + fileFailedRecords.size());
			}

		}

		endTime = System.currentTimeMillis();

		final MappingStatistic fileMappingStatistics = this
				.createMappingStatistics(startTime, endTime, rows, fileName,
						metricPeriodEstimate, intervalEstimate,
						fileFailedRecords);

		parentStatistic.getSubStatistics().add(fileMappingStatistics);

		// commit everything sofar in this transaction....
		commitTransactionWithoutClosing();

		postProcessFile(file, originalPath, afterFailedSize > beforeFailedSize);

		return rows;

	}

	protected int getMappingIntervalEstimate() {
		return this.intervalEstimate;
	}

	protected abstract String getFileExtension();

	/**
	 * A {@link File} being processed is renamed.
	 * 
	 * @param file
	 * @return The renamed File.
	 */
	private File preProcessFile(File file) {
		renameFile(file, new File(file.getAbsolutePath()
				+ ModelUtils.EXTENSION_PROCESS));
		File renamedFile = new File(file + ModelUtils.EXTENSION_PROCESS);
		if (renamedFile.exists()) {
			return renamedFile;
		} else {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"File: " + file.getAbsolutePath()
								+ " rename for processing failed, abort");
			}
		}
		return null;
	}

	/**
	 * A {@link File} being processed is post-renamed.
	 * 
	 * @param file
	 * @param error
	 */
	private void postProcessFile(File file, String originalPath, boolean error) {
		// Strip the process extension of the file.

		if (error) {
			renameFile(file, new File(originalPath
					+ ModelUtils.EXTENSION_DONE_WITH_FAILURES));
		} else {
			renameFile(file, new File(originalPath + ModelUtils.EXTENSION_DONE));
		}
	}

	/**
	 * Rename a file being processed.
	 * 
	 * @param file
	 * @param newFile
	 */
	private void renameFile(File file, File newFile) {
		boolean renameTo = file.renameTo(newFile);
		if (DataActivator.DEBUG) {
			if (renameTo) {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"-- rename successed for file=" + file.getName());
			} else {
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"-- rename failed for file= " + file.getName()
								+ ", the file is likely still open");
			}
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
			DateTimeRange periodEstimate, int intervalEstimate,
			List<MappingRecord> failedRecords) {

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

		// now add the failed records.
		if (failedRecords != null) {
			statistic.getFailedRecords().addAll(failedRecords);
		}

		return statistic;
	}

	protected abstract int getTotalRows();

	protected int processRows() {

		if (getMapping().getIntervalHint() > 0) {
			intervalHint = getMapping().getIntervalHint();
			intervalEstimate = intervalHint;
		}

		jobMonitor.setMsg("Processing header row");

		// Our TimeStamp processor.
		tsProcessor = new TSProcessor(this);
		processHeaderRow();

		tsProcessor.prepTimeStamp(getMapping().getDataMappingColumns());

		jobMonitor.setMsg("Processing rows");

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_IMPORT_DETAILS_OPTION,
					" processing rows, total rows=" + getTotalRows());
		}

		int totalRows = 0;
		int rowsToProcess = getTotalRows();
		jobMonitor.setTotalWork(rowsToProcess - getMapping().getFirstDataRow()
				+ 10);
		jobMonitor.setWorkDone(0); // reset the work done.

		// The last known timestamp.
		Date rowTimeStamp = null;

		for (int rowNum = getMapping().getFirstDataRow(); rowNum < rowsToProcess; rowNum++) {

			jobMonitor.setMsg("Processing row " + rowNum);
			jobMonitor.incrementProgress(1, (rowNum % 10) == 0);
			if (DataActivator.DEBUG) {
				BigDecimal percentil = new BigDecimal(rowNum).divide(
						new BigDecimal(rowsToProcess), 5, RoundingMode.HALF_UP);
				DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_OPTION,
						"-- new row=" + rowNum + " (" + rowsToProcess + ")"
								+ percentil.movePointRight(2) + "%");
			}

			int columnBeingProcessed = -1;
			try {

				// CB 180122012, why is this here, for a read and open a
				// transaction?
				// this.getMappingColumn();
				totalRows++;

				// We need at least a node and a component.
				IdentifierValidator validator = new IdentifierValidator();

				final List<IComponentLocator.IdentifierDescriptor> elementIdentifiers = getIdentifierValues(
						getMapping().getDataMappingColumns(), rowNum, false);

				validator.validateIdentifiers(elementIdentifiers);

				if (!validator.hasNodeAndChild()) {
					if (validator.hasNode()) {
						// Check for auto-create.
						// throw new java.lang.IllegalStateException(
						// "At least one child of Node Identifier is required");
					} else {
						// here we need to bail, not even a Node?
						throw new java.lang.IllegalStateException(
								"Network ELement Identifier is required");
					}
				}

				rowTimeStamp = tsProcessor.getTimeStampValue(rowNum, false);

				final int intervalHintFromRow = getIntervalHint(rowNum);
				// give preference to the intervalhint from a row mapping.
				this.intervalEstimate = intervalHintFromRow;

				// Locate our components which match the given descriptors.
				// There are multiple, later on get the correct one for the
				// metric reference.
				final List<Component> componentsForID = getComponentLocator()
						.locateComponents(getMapping().cdoView(),
								elementIdentifiers);

				Component locatedComponent = null;

				for (final MappingColumn column : getMapping()
						.getDataMappingColumns()) {

					columnBeingProcessed = column.getColumn();

					// Process a metric column.
					if (isMetric(column)) {
						// Check that the metric ref is set, other wise bail.
						if (!getValueDataKind(column)
								.eIsSet(MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF)) {
							throw new java.lang.IllegalStateException(
									"Metric reference not set");
						}

						Metric metricRef = getValueDataKind(column)
								.getMetricRef();

						if (locatedComponent != null) {
							if (!locatedComponent.getMetricRefs().contains(
									metricRef)) {
								Iterable<Component> componentsForMetric = modelUtils
										.componentsForMetric(componentsForID,
												metricRef);
								if (Iterables.size(componentsForMetric) == 1) {
									locatedComponent = componentsForMetric
											.iterator().next();
								}
							}
						} else {
							Iterable<Component> componentsForMetric = modelUtils
									.componentsForMetric(componentsForID,
											metricRef);
							if (Iterables.size(componentsForMetric) == 1) {
								locatedComponent = componentsForMetric
										.iterator().next();
							}
						}
						
						if (DataActivator.DEBUG) {
							DataActivator.TRACE
									.trace(DataActivator.TRACE_IMPORT_OPTION,
											"-- column="
													+ column.getColumn()
													+ " comp: "
													+ modelUtils
															.printModelObject(locatedComponent)
													+ " metric:"
													+ modelUtils
															.printModelObject(metricRef));
						}

						if (locatedComponent == null) {

							createNotFoundNetworkElementMappingRecord(
									getValueDataKind(column).getMetricRef(),
									rowNum, elementIdentifiers,
									getComponentLocator()
											.getFailedIdentifiers(),
									getFailedRecords());
							continue;
						}

						/*
						 * The last matching identifier, is needed for the
						 * resource name creation strategy.
						 */
						IComponentLocator.IdentifierDescriptor lastIdentifier = getComponentLocator()
								.getLastMatchingIdentifier();

						final Double value = getNumericCellValue(rowNum,
								column.getColumn());

						if (DataActivator.DEBUG) {
							DataActivator.TRACE.trace(
									DataActivator.TRACE_IMPORT_DETAILS_OPTION,
									"Storing value: " + value);
						}

						addMetricValue(column, rowTimeStamp, locatedComponent,
								value, intervalHintFromRow, lastIdentifier);

					}
				}
			} catch (final Exception e) {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_DETAILS_OPTION,
							"Error processing row=" + rowNum, e);
				}
				this.createExceptionMappingRecord(e, rowNum,
						columnBeingProcessed, this.getFailedRecords());

			} finally {

				// As last update the last row time stamp.
				if (rowTimeStamp != null) {
					this.updatePeriodEstimate(rowTimeStamp);
				}
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
				List<IComponentLocator.IdentifierDescriptor> elementIdentifiers) {

			for (IComponentLocator.IdentifierDescriptor iv : elementIdentifiers) {
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

		public boolean hasNodeAndChild() {
			if (countNode > 0 && (countComponent > 0 || countRelationship > 0)) {
				return true;
			} else {
				return false;
			}
		}

		public boolean hasNode() {
			return countNode > 0;
		}

	}

	public DateTimeRange getMappingPeriodEstimate() {
		return metricPeriodEstimate;
	}

	private void updatePeriodEstimate(Date timestamp) {

		// Assume chronological order of timestamps. Will fail otherwise.
		XMLGregorianCalendar xmlDate = modelUtils.toXMLDate(timestamp);
		if (!metricPeriodEstimate
				.eIsSet(GenericsPackage.Literals.DATE_TIME_RANGE__BEGIN)) {
			metricPeriodEstimate.setBegin(xmlDate);
		}
		metricPeriodEstimate.setEnd(xmlDate);
	}

	@SuppressWarnings("unused")
	private String createNetworkElementLocatorLog(Metric metric,
			List<IComponentLocator.IdentifierDescriptor> identifierValues) {
		final StringBuilder sb = new StringBuilder();
		sb.append("Could not locate networkElement for metric "
				+ metric.getName());
		sb.append("Using identifiers: ");
		for (final IComponentLocator.IdentifierDescriptor idValue : identifierValues) {
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
				.getHeaderMappingColumns(), headerRow, true);

		tsProcessor.prepTimeStamp(getMapping().getHeaderMappingColumns());
		headerTimeStamp = tsProcessor.getTimeStampValue(headerRow, true);

		this.updatePeriodEstimate(headerTimeStamp);
	}

	/**
	 * Lookup a Node and add the resource to it.
	 * 
	 * @param originalEObject
	 * @param eObject
	 * @param path
	 * @param resource
	 */
	public void addToNode(EObject originalEObject, EObject eObject,
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

				if (componentObjects.size() > index) {
					currentObject = componentObjects.get(index);

					if (originalEObject instanceof Equipment) {
						componentObjects = ((Equipment) currentObject)
								.getEquipments();
					} else {
						componentObjects = ((Function) currentObject)
								.getFunctions();
					}
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

				String cdoResourcePath = modelUtils
						.cdoCalculateResourcePathII((EObject) currentObject);

				if (cdoResourcePath != null) {
					final Resource emfNetxResource = getDataProvider()
							.getResource(cdoResourcePath);
					emfNetxResource.getContents().add(copiedNetXResource);
					((Component) currentObject).getResourceRefs().add(
							copiedNetXResource);
				} else {
					if (DataActivator.DEBUG) {
						DataActivator.TRACE
								.trace(DataActivator.TRACE_IMPORT_DETAILS_OPTION,
										"Invalid CDO Resource path, component name likely not set");
					}
					return;
				}
			}
		} else {
			final EStructuralFeature eFeature = eObject.eContainingFeature();
			final List<?> values = (List<?>) container.eGet(eFeature);
			path.add(0, values.indexOf(eObject));
			addToNode(originalEObject, container, path, resource);
		}

	}

	public String toValidExpressionName(String value) {
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

	public ValueDataKind getValueDataKind(MappingColumn column) {
		return (ValueDataKind) column.getDataType();
	}

	private boolean isMetric(MappingColumn column) {
		if (!(column.getDataType() instanceof ValueDataKind)) {
			return false;
		}
		final ValueDataKind valueDataKind = getValueDataKind(column);
		return valueDataKind.getValueKind() == ValueKindType.METRIC;
	}

	protected void createNotFoundNetworkElementMappingRecord(Metric metric,
			int rowNum,
			List<IComponentLocator.IdentifierDescriptor> allIdentifiers,
			List<IComponentLocator.IdentifierDescriptor> failedIdentifiers,
			List<MappingRecord> records) {
		final StringBuilder sb = new StringBuilder();
		sb.append("Could not locate identifier for metric " + metric.getName());

		sb.append(". For identifiers: ");
		for (final IComponentLocator.IdentifierDescriptor idValue : allIdentifiers) {
			sb.append(" - " + idValue.getKind().getObjectKind().getName()
					+ ": " + idValue.getValue());
		}

		sb.append(", Failed on : ");
		for (final IComponentLocator.IdentifierDescriptor idValue : failedIdentifiers) {
			sb.append(" - " + idValue.getKind().getObjectKind().getName()
					+ ": " + idValue.getValue());
		}
		final int failedColumn = failedIdentifiers.size() > 0 ? failedIdentifiers
				.get(0).getColumn() : -1;

		MappingRecord record;
		if ((record = this.hasMappingRecord(rowNum, failedColumn,
				sb.toString(), records)) != null) {
			long count = record.getCount() + 1;
			record.setCount(count);
		} else {
			record = createMappingRecord(rowNum, failedColumn, sb.toString());
			records.add(record);
		}
	}

	/*
	 * Exception mapping records.
	 */
	protected void createExceptionMappingRecord(Exception exception,
			int rowNum, int colNum, List<MappingRecord> records) {
		final StringBuilder sb = new StringBuilder();
		sb.append(exception.getMessage());
		MappingRecord record;
		if ((record = this.hasMappingRecord(rowNum, colNum, sb.toString(),
				records)) != null) {
			long count = record.getCount() + 1;
			record.setCount(count);
		} else {
			record = createMappingRecord(rowNum, colNum, sb.toString());
			records.add(record);
		}
	}

	protected MappingRecord createMappingRecord(int row, int column,
			String message) {
		final MappingRecord record = MetricsFactory.eINSTANCE
				.createMappingRecord();
		record.setColumn(column + "");
		// record.setRow(row + "");

		if (message.length() > 254) {
			message = message.substring(0, 254);
		}
		record.setMessage(message);

		return record;
	}

	protected MappingRecord hasMappingRecord(int rowNum, int column, String s,
			List<MappingRecord> records) {

		for (Iterator<MappingRecord> it = records.iterator(); it.hasNext();) {
			MappingRecord next = it.next();
			if (next.getColumn().trim().equals(new Integer(column).toString())
					&& next.getMessage().equals(s)) {
				// This is the same Failure record.
				return next;
			}
		}
		return null;
	}

	/**
	 * A Processor for TimeStamps. It maintains state of a {@link DateFormat}
	 * and the column(s) where time stamp values can be found.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class TSProcessor {

		private SimpleDateFormat tsParser = null;

		/**
		 * A Map of TS kind and corresponding column in the input for easy
		 * retrieval of the value in the processing phase
		 */
		private Map<ValueKindType, Integer> tsColumns = Maps.newHashMap();

		/** The current Importer */
		private AbstractMetricValuesImporter currentImporter;

		public TSProcessor(AbstractMetricValuesImporter currentImporter) {
			this.currentImporter = currentImporter;
		}

		/**
		 * Get a timestamp using the defined mapping columns.
		 */
		public Date getTimeStampValue(int rowNum, boolean reset) {

			if (!reset && headerTimeStamp != null) {
				return headerTimeStamp;
			}

			Date returnDate = new Date();

			try {
				// if we are Excel, get the timestamp directly without a date
				// formatter. , else process the
				// provided patterns. Note that the first occurence will return
				// the date. We don't not allow multiple DATE/TIME combinations
				// here.
				if (currentImporter instanceof XLSMetricValuesImporter) {

					for (ValueKindType vkt : tsColumns.keySet()) {

						switch (vkt.getValue()) {
						case ValueKindType.DATE_VALUE: {
							return getDateCellValue(rowNum,
									tsColumns.get(ValueKindType.DATE));
						}
						case ValueKindType.TIME_VALUE: {
							return getDateCellValue(rowNum,
									tsColumns.get(ValueKindType.TIME));
						}
						case ValueKindType.DATETIME_VALUE: {
							return getDateCellValue(rowNum,
									tsColumns.get(ValueKindType.DATETIME));
						}
						}
					}

				} else {

					String dateValue = null;
					String timeValue = null;
					String dateTimeValue = null;

					for (ValueKindType vkt : tsColumns.keySet()) {

						switch (vkt.getValue()) {
						case ValueKindType.DATE_VALUE: {
							dateValue = getStringCellValue(rowNum,
									tsColumns.get(ValueKindType.DATE));
						}
							break;
						case ValueKindType.TIME_VALUE: {
							timeValue = getStringCellValue(rowNum,
									tsColumns.get(ValueKindType.TIME));
						}
							break;
						case ValueKindType.DATETIME_VALUE: {
							dateTimeValue = getStringCellValue(rowNum,
									tsColumns.get(ValueKindType.DATETIME));
						}
							break;
						}
					}

					String value = null;

					if (dateTimeValue != null) {
						value = dateTimeValue;
					} else if (dateValue != null && timeValue != null) {
						value = dateValue + " " + timeValue;
					} else if (dateValue != null) {
						value = dateValue;
					} else if (timeValue != null) {
						value = timeValue;
					}

					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_IMPORT_DETAILS_OPTION,
								"Processed timestamp mappings, resolving ");
						DataActivator.TRACE.trace(
								DataActivator.TRACE_IMPORT_DETAILS_OPTION,
								"DATETIME=" + dateTimeValue == null ? "Not Set"
										: dateTimeValue);
						DataActivator.TRACE.trace(
								DataActivator.TRACE_IMPORT_DETAILS_OPTION,
								"TIME=" + timeValue == null ? "Not Set"
										: timeValue);
						DataActivator.TRACE.trace(
								DataActivator.TRACE_IMPORT_DETAILS_OPTION,
								"DATE=" + dateValue == null ? "Not Set"
										: dateValue);
					}

					returnDate = processTSMapping(tsParser, value);
				}
			} catch (ParseException pe) {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_OPTION,
							"Error parsing timestamp", pe);
				}
				throw new IllegalStateException(pe);
			} finally {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_DETAILS_OPTION,
							"TS is " + returnDate);
				}
			}
			return returnDate;
		}

		public void prepTimeStamp(List<MappingColumn> mappingColumns) {

			// Reset before re-processing columns.
			tsColumns.clear();
			tsParser = null;

			try {

				// Process either a date Time Pattern , date or time
				// pattern.
				// Note: Time and Date is also a valid combination.

				String datePattern = null;
				String timePattern = null;
				String dateTimePattern = null;

				for (final MappingColumn column : mappingColumns) {
					if (column.getDataType() instanceof ValueDataKind) {
						final ValueDataKind vdk = (ValueDataKind) column
								.getDataType();

						// Should only accept one single ValueDataKind if
						// DateTime,
						// break out if we find one.

						switch (vdk.getValueKind().getValue()) {
						case ValueKindType.DATE_VALUE: {
							tsColumns.put(ValueKindType.DATE,
									column.getColumn());
							datePattern = vdk.getFormat();
						}
							break;
						case ValueKindType.TIME_VALUE: {
							tsColumns.put(ValueKindType.TIME,
									column.getColumn());
							timePattern = vdk.getFormat();
						}
							break;
						case ValueKindType.DATETIME_VALUE: {
							tsColumns.put(ValueKindType.DATETIME,
									column.getColumn());
							dateTimePattern = vdk.getFormat();
						}
							break;

						}
					}
				}

				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_DETAILS_OPTION,
							"Processed timestamp mappings, resolving ");

					DataActivator.TRACE
							.trace(DataActivator.TRACE_IMPORT_DETAILS_OPTION,
									"DATETIME PATTERN=" + dateTimePattern == null ? "Not Set"
											: dateTimePattern);

					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_DETAILS_OPTION,
							"TIME PATTERN=" + timePattern == null ? "Not Set"
									: timePattern);

					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_DETAILS_OPTION,
							"DATE PATTERN=" + datePattern == null ? "Not Set"
									: datePattern);
				}

				tsParser = getTSParser(datePattern, timePattern,
						dateTimePattern);
			} finally {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_DETAILS_OPTION,
							"parser is " + tsParser + " columns: " + tsColumns);
				}
			}
		}

		/**
		 * 
		 * @param dateProcessor
		 * @param value
		 * @return
		 * @throws ParseException
		 */
		private Date processTSMapping(SimpleDateFormat dateProcessor,
				String value) throws ParseException {

			String pattern = null;

			if (pattern == null) {
				pattern = ModelUtils.DEFAULT_DATE_TIME_PATTERN;
			}

			return dateProcessor.parse(value);
		}

		/**
		 * Get a timestamp format/parser for the provided patterns.
		 * 
		 * @param datePattern
		 * @param timePattern
		 * @param dateTimePattern
		 * @param dateValue
		 * @param timeValue
		 * @param dateTimeValue
		 * @return
		 */
		private SimpleDateFormat getTSParser(String datePattern,
				String timePattern, String dateTimePattern) {

			String pattern = null;

			if (dateTimePattern != null) {
				pattern = dateTimePattern;
			} else if (datePattern != null && timePattern != null) {
				pattern = datePattern + " " + timePattern;
			} else if (datePattern != null) {
				pattern = datePattern;
			} else if (timePattern != null) {
				pattern = timePattern;
			}
			if (pattern == null) {
				pattern = ModelUtils.DEFAULT_DATE_TIME_PATTERN;
			}

			return new SimpleDateFormat(pattern);
		}
	}

	protected abstract Date getDateCellValue(int rowNum, int column);

	private int getIntervalHint(int rowNum) {
		for (final MappingColumn column : getMapping().getDataMappingColumns()) {
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

	/**
	 * 
	 * @param mappingColumns
	 * @param row
	 * @param reset
	 * @return
	 */
	private List<IComponentLocator.IdentifierDescriptor> getIdentifierValues(
			List<MappingColumn> mappingColumns, int row, boolean reset) {

		final List<IComponentLocator.IdentifierDescriptor> result = Lists
				.newArrayList();
		if (!reset) {
			result.addAll(headerIdentifiers);
		}

		for (final MappingColumn column : mappingColumns) {
			if (column.getDataType() instanceof IdentifierDataKind) {

				final IdentifierDataKind identifierDataKind = (IdentifierDataKind) column
						.getDataType();
				String dataValue = getStringCellValue(row, column.getColumn())
						.trim();

				// Apply the pattern to the value.

				if (identifierDataKind
						.eIsSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__PATTERN)) {
					String extractionPattern = identifierDataKind.getPattern();
					// PATTERN: if extractionPattern != null then use it to
					// extract the
					// to-compare value
					// from the componentValue or the dataValue, the dataValue
					// is read from
					// the excel
					if (extractionPattern != null
							&& extractionPattern.length() > 0) {
						try {
							Pattern pattern = Pattern
									.compile(extractionPattern);
							Matcher matcher = pattern.matcher(dataValue);
							String extract = null;
							if (matcher.find()) {
								int gc = matcher.groupCount();
								// Check for a single match, the pattern should
								// extract a
								// single value
								// which is not the 0 group, but the first one.
								if (gc == 1) {
									extract = matcher.group(1);
								}
							}
							if (extract != null) {
								dataValue = extract;
							}
						} catch (PatternSyntaxException pse) {
						}
					}
				}

				final IComponentLocator.IdentifierDescriptor identifierValue = IComponentLocator.IdentifierDescriptor
						.valueFor(identifierDataKind, dataValue,
								column.getColumn());
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
		if (metricSource == null) {
			metricSource = (MetricSource) getDataProvider().getTransaction()
					.getObject(cdoID);
		}
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

	public IComponentLocator getComponentLocator() {
		return componentLocator;
	}

	public void setComponentLocator(IComponentLocator networkElementLocator) {
		this.componentLocator = networkElementLocator;
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
		this.cdoID = cdoID;
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

	public void addMetricValue(MappingColumn column, Date timeStamp,
			Component networkElement, Double dblValue, int periodHint,
			IComponentLocator.IdentifierDescriptor lastIdentifier) {
		if (helper != null) {
			this.helper.addMetricValue(column, timeStamp, networkElement,
					dblValue, periodHint, lastIdentifier);
		} else {
			throw new java.lang.IllegalStateException(
					"AbstractMetricValueImporter: Import helper should be set");
		}
	}

	/**
	 * Delegate to the currently set helper.
	 */
	public void initializeProviders(IComponentLocator networkElementLocator) {
		if (helper != null) {
			helper.initializeProviders(networkElementLocator);
		} else {
			throw new java.lang.IllegalStateException(
					"AbstractMetricValueImporter: Import helper should be set");
		}
	}

	/**
	 * Delegate to the currently set helper, if no local provider exists.
	 */
	public IDataProvider getDataProvider() {

		if (dataProvider == null) {
			if (helper != null) {
				dataProvider = helper.getDataProvider();
			} else {
				throw new java.lang.IllegalStateException(
						"AbstractMetricValueImporter: Import helper should be set");
			}
		}
		return dataProvider;
	}

	/**
	 * Delegate to the import helper.
	 */
	public boolean cancelled() {
		if (helper != null) {
			return helper.cancelled();
		} else {
			throw new java.lang.IllegalStateException(
					"AbstractMetricValueImporter: Import helper should be set");
		}
	}

	public BundleActivator getActivator() {
		return helper.getActivator();
	}

	public void setActivator(BundleActivator p) {
		helper.setActivator(p);
	}

}
