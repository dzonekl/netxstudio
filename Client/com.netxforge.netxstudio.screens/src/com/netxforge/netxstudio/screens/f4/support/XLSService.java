/*******************************************************************************
 * Copyright (c) Jun 26, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.f4.support;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.eventusermodel.AbortableHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.eventusermodel.HSSFUserException;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Reads an .xls file and returns the records as a List of tuples.
 * 
 * Check if the return map is adequat. This service is NOT threadsafe, an
 * ongoing process is not synchronized.
 * 
 */
public class XLSService extends AbortableHSSFListener {

	public static int ABORTED = 0;
	public static int OK = 1;
	public static int MAPPING_ERROR = 2;
	public static int PARSING_ERROR = 2;

//	public static final XLSService INSTANCE = new XLSService();

	// Used to flag if all columns in this row are OK sofar, if false we don't
	// process columns, and mark this row as a failure.
	private boolean currentRowProgress = false;

	// Current POI record.
	private SSTRecord currentSStrec = null;
	private int currentReturnCode = -1;
	private Map<Integer, Tuple> currentRow;
	private List<Map<Integer, Tuple>> currentRecordMap = Lists.newArrayList();
	private IProgressMonitor currentMonitor = null;

	// Limit the number of rows we process.
	int processedRows = 0;

	private void reset() {
		currentRowProgress = true;
		currentSStrec = null;
		currentMonitor = null;
		currentReturnCode = -1;
		currentRecordMap.clear();
		// currentRowIndentifiers = null;
	}

	public XLSService() {
	}

	public List<Map<Integer, Tuple>> getRecords() {
		return currentRecordMap;
	}

	public int go(FileInputStream fin) throws IOException {
		return go(new NullProgressMonitor(), fin);
	}

	public int go(IProgressMonitor monitor, FileInputStream fin)
			throws IOException {
		reset();
		this.currentMonitor = monitor;
		monitor.subTask("POI Ongoing");

		// TODO, we would need to do a first evaluation of the workbook to get
		// an idea of the amount of work we can expect here.
		// For now increment worked, for each single row.

		// create a new file input stream with the input file specified
		// at the command line
		// create a new org.apache.poi.poifs.filesystem.Filesystem
		POIFSFileSystem poifs = new POIFSFileSystem(fin);
		// get the Workbook (excel part) stream in a InputStream
		InputStream din = poifs.createDocumentInputStream("Workbook");
		// construct out HSSFRequest object
		HSSFRequest req = new HSSFRequest();
		// lazy listen for ALL records with the listener shown above
		req.addListenerForAllRecords(this);
		// create our event factory
		HSSFEventFactory factory = new HSSFEventFactory();
		// process our events based on the document input stream
		try {
			factory.abortableProcessEvents(req, din);
		} catch (HSSFUserException e) {
			// We have an issue or cancel.
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			// once all the events are processed close our file input stream
			fin.close();
			// and our document input stream (don't want to leak these!)
			din.close();
		}
		// TODO, silent return, could also be an exception with information on
		// what went wrong.
		return currentReturnCode;
	}

	/**
	 * This method listens for incoming records and handles them as required.
	 * 
	 * @param record
	 *            The record that was found while reading.
	 */
	private int processRecordInternal(Record record) {

		if (currentMonitor.isCanceled()) {
			// we should interrupt the process here.
			return ABORTED;
		}

		// Produce a multiple kvp for the .xls

		switch (record.getSid()) {
		// the BOFRecord can represent either the beginning of a sheet or the
		// workbook
		case BOFRecord.sid:
			BOFRecord bof = (BOFRecord) record;
			if (bof.getType() == BOFRecord.TYPE_WORKBOOK) {
				System.out.println("Encountered workbook");
				// assigned to the class level member
			} else if (bof.getType() == BOFRecord.TYPE_WORKSHEET) {
				System.out.println("Encountered sheet reference");
			}
			break;
		case BoundSheetRecord.sid:
			BoundSheetRecord bsr = (BoundSheetRecord) record;
			System.out.println("New sheet named: " + bsr.getSheetname());
			break;

		// Row records come in batch (32) before the actual cell records.

		case RowRecord.sid:
			RowRecord rowrec = (RowRecord) record;
			// Look for our header row, when found we have to interpret the
			// values.
			System.out.println("Row found" + rowrec.getRowNumber()
					+ ", first column at " + rowrec.getFirstCol()
					+ " last column at " + rowrec.getLastCol());

//			if (!rowrec.isEmpty()) {
				this.currentRow = Maps.newHashMap();
				this.currentRecordMap.add(currentRow);

//			}
			// Should do a lazy create of the row.
			break;

		// SSTRecords store a array of unique strings used in Excel.
		case SSTRecord.sid:
			currentSStrec = (SSTRecord) record;
			// for (int k = 0; k < currentSStrec.getNumUniqueStrings(); k++) {
			// System.out.println("String table value " + k + " = "
			// + currentSStrec.getString(k));
			// }
			break;
		case NumberRecord.sid:
		case LabelSSTRecord.sid:
			int column = -1;
			int row = -1;
			Object value = null;

			if (record.getSid() == NumberRecord.sid) {
				NumberRecord numrec = (NumberRecord) record;
				value = numrec.getValue();
				column = numrec.getColumn();
				row = numrec.getRow();

				// DEBUG
				System.out.println("Number:Cell found with value " + value
						+ " at: [" + row + "," + column + "]");

			}
			if (record.getSid() == LabelSSTRecord.sid) {
				LabelSSTRecord lrec = (LabelSSTRecord) record;
				value = currentSStrec.getString(lrec.getSSTIndex()).toString();
				column = lrec.getColumn();
				row = lrec.getRow();

				// DEBUG
				System.out.println("String:Cell found with value " + value
						+ " at: [" + row + "," + column + "]");
			}

			
			if (value != null && row != -1 && column != -1) {
				Tuple t = new Tuple(column, value);
				currentRecordMap.get(row).put(column, t);
			} else {
				System.err.println("Incomplete cell encountered" + "v="
						+ value + " r=" + row + " c=" + column);
			}
			// TODO, do a more gracefull check with a switch break to proceed,
			// or other strategy if this fails.
			// assert row > 0 && column > 0 && value != null;

			if (column == 0) {
				currentMonitor.worked(1);
				currentRowProgress = true; // reset for the next row.
				processedRows++; // Update the number of processed rows.

			} else {
				// Did we have a failure on a previous column, if so skip this
				// column until the next row.
				if (!currentRowProgress) {
					break;
				}
				// We have an undefined column.
				this.currentRowProgress = false;

			}
		
			break;
		}
		return OK;
	}

	@Override
	public short abortableProcessRecord(Record rec) throws HSSFUserException {
		if ((currentReturnCode = processRecordInternal(rec)) != OK) {
			// We are aborted or a failure.
			throw new HSSFUserException();
		}

		if (currentMonitor.isCanceled()) {
			throw new HSSFUserException();
		}

		if (processedRows == 20) {
			throw new HSSFUserException();

		}
		return 0;
	}

}
