/*******************************************************************************
 * Copyright (c) 7 okt. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.oss2.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import files.FilesSession;

/**
 * Process a {@link FilesSession}.
 * 
 * TODO, Full of progres, monitor, tracing stuff... Factor out!
 * 
 * @author Christophe Bouhier
 */
public class Files implements IFiles {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.oss2.files.IFiles#process(files.FilesSession)
	 */
	@Override
	public void process(FilesSession session) {

		final List<File> result = new ArrayList<File>();

		try {

			// boolean noFiles = true;

			@SuppressWarnings("unused")
			boolean errorOccurred = false;

			final StringBuilder fileList = new StringBuilder();

			

			String filterPattern = session.getFilterPattern();

			if (filterPattern == null && session.getFileExtension() != null) {
				filterPattern = "[^\\s]+(\\.(?i)" + session.getFileExtension()
						+ ")$";
			} else {
				// We concat the file extension, to the pattern automaticly.
				filterPattern = filterPattern.concat("(\\.(?i)"
						+ session.getFileExtension() + ")$");

				Pattern.compile(filterPattern);
			}

			final File rootFile = new File(session.getFolderURL());
			
			//  TODO Process bundle files. 
//			FilesActivator.getSelf().
			
			
			
			
			// TODO TRACING
			// if (ImportActivator.DEBUG) {
			// ImportActivator.TRACE.trace(
			// ImportActivator.TRACE_IMPORT_OPTION,
			// "-- Looking for files with pattern" + filterPattern);
			// }

			// Start processing in the specified root directory, make sure it
			// exists.
			if (!rootFile.exists()) {

				// jobMonitor.appendToLog("Root directory/file ("
				// + rootFile.getAbsolutePath() + ") does not exist");

				errorOccurred = true;
			} else if (rootFile.isFile()) {
				try {

					result.add(rootFile);

					fileList.append(rootFile.getAbsolutePath());

					// DO NOT PROCESS NOW.
					// totalRows += doProcessFile(rootFile, mappingStatistic);
				} catch (final Throwable t) {
					errorOccurred = true;
					// jobMonitor.appendToLog("Error (" + t.getMessage()
					// + ") while processing file "
					// + rootFile.getAbsolutePath());
				}
			} else {
				// After each iteration, check if the scheduler is active, and
				// cancel otherwise.
				for (final File file : rootFile.listFiles()) {
					// if (cancelled()) {
					// we are cancelled, abort the next file.
					// if (ImportActivator.DEBUG) {
					// ImportActivator.TRACE
					// .trace(ImportActivator.TRACE_IMPORT_OPTION,
					// "Importer instructed to abort the import process");
					// }
					// break;
					// }

					// Track the file name and orignal path.
					final String fileName = file.getName();
					@SuppressWarnings("unused")
					final String originalPath = file.getAbsolutePath();

					// TODO TRACING.
					// if (ImportActivator.DEBUG) {
					// ImportActivator.TRACE.trace(
					// ImportActivator.TRACE_IMPORT_OPTION,
					// "-- Checking file=" + fileName);
					// }

					if (filterPattern == null
							|| fileName.matches(filterPattern)) {
						try {
							fileList.append((fileList.length() > 0 ? "\n" : "")
									+ fileName);
							
							result.add(file);
							// SKIP FILE PROCESSING.
							// totalRows += doProcessFile(file,
							// mappingStatistic);

						} catch (final Throwable t) {
							errorOccurred = true;
							// Processing failed, the file name will still be
							// named .process
							// Consider renaming it to .error
							// errorProcessFile(file, originalPath);
							// jobMonitor.appendToLog("Error (" + t.getMessage()
							// + ") while processing file "
							// + file.getAbsolutePath());
							// if (ImportActivator.DEBUG) {
							// ImportActivator.TRACE.trace(
							// ImportActivator.TRACE_IMPORT_OPTION,
							// " -- Error processing file", t);
							// }

						}
					}

				}
			}

			// if (noFiles) {
			// jobMonitor.appendToLog("No files found for processing");
			// if (ImportActivator.DEBUG) {
			// ImportActivator.TRACE.trace(
			// ImportActivator.TRACE_IMPORT_OPTION,
			// " -- No files found for processing");
			// }
			// }

			// jobMonitor.setTask("Processing metricsource "
			// + getMetricSource().getName());
			// jobMonitor.setMsg("Creating mappingstatistics");
			// jobMonitor.incrementProgress(1, true);

			// Moves the records from the subprocesses....

			String message = result.isEmpty() ? "No files processed" : fileList
					.toString();

			if (message.length() > 2000) {
				message = message.substring(0, 2000);
				// if (ImportActivator.DEBUG) {
				// ImportActivator.TRACE
				// .trace(ImportActivator.TRACE_IMPORT_OPTION,
				// "Message too long for processing, trunked on 2000 characters!");
				// }
			}

			// if (errorOccurred || getFailedRecords().size() > 0) {
			// jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, null);
			// } else {
			// jobMonitor.setFinished(JobRunState.FINISHED_SUCCESSFULLY, null);
			// }

			// if (ImportActivator.DEBUG) {
			// ImportActivator.TRACE.trace(
			// ImportActivator.TRACE_IMPORT_OPTION,
			// "Succesfull processing import for metric source"
			// + getMetricSource().getName());
			// }

		} catch (final Throwable t) {
			@SuppressWarnings("unused")
			String message = t.getMessage();
			if (t instanceof PatternSyntaxException) {
				message = "File filter pattern is not valid, abort";
			}

			// jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, t);

			// if (ImportActivator.DEBUG) {
			// ImportActivator.TRACE.trace(
			// ImportActivator.TRACE_IMPORT_OPTION,
			// "Error Processing metricsource "
			// + getMetricSource().getName(), t);
			// }
		} finally {
			// finalize with a mapping statistic.
			// Set the end time on the mapping stats.
			@SuppressWarnings("unused")
			long endTime = System.currentTimeMillis();
			// mappingStatistic.getMappingDuration().setEnd(
			// NonModelUtils.toXMLDate(new Date(endTime)));
			// mappingStatistic.setMessage(message);
			// mappingStatistic.setTotalRecords(totalRows);
			// getRunPeriodEstimate().write(mappingStatistic);

			session.setResult(result);

		}

		// if (ImportActivator.DEBUG) {
		// ImportActivator.TRACE.trace(ImportActivator.TRACE_IMPORT_OPTION,
		// "Mapping statistics");
		// ImportActivator.TRACE.trace(ImportActivator.TRACE_IMPORT_OPTION,
		// " -- from ="
		// + mappingStatistic.getMappingDuration().getBegin()
		// + " to "
		// + mappingStatistic.getMappingDuration().getEnd());
		// ImportActivator.TRACE.trace(ImportActivator.TRACE_IMPORT_OPTION,
		// " -- total records =" + totalRows);
		// ImportActivator.TRACE.trace(ImportActivator.TRACE_IMPORT_OPTION,
		// " -- Period Estimate from ="
		// + getRunPeriodEstimate().metricPeriodEstimateBegin
		// + " to "
		// + getRunPeriodEstimate().metricPeriodEstimateEnd);
		// ImportActivator.TRACE.trace(ImportActivator.TRACE_IMPORT_OPTION,
		// " -- Interval (estimate) =" + intervalEstimate);
		// }

		// commitTransactionAndClose();

	}

}
