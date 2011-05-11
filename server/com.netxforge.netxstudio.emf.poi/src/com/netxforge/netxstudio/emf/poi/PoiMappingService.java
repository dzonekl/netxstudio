package com.netxforge.netxstudio.emf.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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

import com.netxforge.netxstudio.emf.poi.mappings.XLSMapping;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.metrics.Metric;

/**
 * The POI emmitter writes EMF Objects to. TODO, Identifier needs to be
 * reflective. TODO, Add parsing time from current time in Statistics.
 * 
 * Check if the return map is adequat. This service is NOT threadsafe, an
 * ongoing process is not synchronized.
 * 
 */
public class PoiMappingService extends AbortableHSSFListener {

	public static int ABORTED = 0;
	public static int OK = 1;
	public static int MAPPING_ERROR = 2;
	public static int PARSING_ERROR = 2;

	public static final PoiMappingService INSTANCE = new PoiMappingService();
	private MappingStat currentStatistics = new MappingStat();

	public class MappingStat {

		public List<MappingTuple> getFailedRecordsList() {
			return failedRecordsList;
		}

		List<MappingTuple> failedRecordsList = new ArrayList<MappingTuple>();

		public class MappingTuple {

			public MappingTuple(int row, int column) {
				this.row = row;
				this.column = column;
			}

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

			int row;
			int column;

		}

		int totalRecords = -1;

		public int getTotalRecords() {
			return totalRecords;
		}

		public void addTotalRecord() {
			totalRecords += 1;
		}

		public int getFailedRecords() {
			return failedRecordsList.size();
		}

		public void addFailedRecord(int row, int column) {
			failedRecordsList.add(new MappingTuple(row, column));
		}

		void reset() {
			failedRecordsList.clear();
			totalRecords = -1;
		}

	}

	// TODO, remove not needed.
	// These are the currents, for the record processor.
	// These are rest.
	// private int currentRow = -1;

	// Used to flag if all columns in this row are OK sofar, if false we don't
	// process columns, and mark this row as a failure.
	private boolean currentRowProgress = false;

	// Current time stamp object.
	private Date currentTimeStamp = null;

	// Current POI record.
	private SSTRecord currentSStrec = null;

	// Tells us how to map.
	private XLSMapping currentMapping = null;

	private int currentMatchingHeaders = 0;

	private int currentReturnCode = -1;

	private List<Tuple> currentRecordMap = new ArrayList<Tuple>();
	private List<Tuple> currentRowIndentifiers = null;

	private IProgressMonitor currentMonitor = null;

	private void reset() {
		currentRowProgress = true;
		currentMatchingHeaders = 0;
		currentTimeStamp = null;
		currentSStrec = null;
		currentMapping = null;
		currentMonitor = null;
		currentReturnCode = -1;
		currentStatistics.reset();
		currentRecordMap.clear();
		currentRowIndentifiers = null;
	}

	public PoiMappingService() {
	}

	public MappingStat getStatistics() {
		return currentStatistics;
	}

	public List<Tuple> getRecords() {
		return currentRecordMap;
	}

	public int go(FileInputStream fin, XLSMapping mapping) throws IOException {
		return go(new NullProgressMonitor(), fin, mapping);
	}

	public int go(IProgressMonitor monitor, FileInputStream fin,
			XLSMapping mapping) throws IOException {
		reset();
		this.currentMonitor = monitor;
		this.currentMapping = mapping;
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
			if (rowrec.getRowNumber() == currentMapping.getHeaderRow()) {
				// We found our header, the cells should come soon!
			}

			// System.out.println("Row found" + rowrec.getRowNumber()
			// + ", first column at " + rowrec.getFirstCol()
			// + " last column at " + rowrec.getLastCol());
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

			// TODO, do a more gracefull check with a switch break to proceed,
			// or other strategy if this fails.
			assert row > 0 && column > 0 && value != null;

			if (column == 0) {
				currentMonitor.worked(1);
				currentRowIndentifiers = new ArrayList<Tuple>();
				currentRowProgress = true; // reset for the next row.
				currentStatistics.addTotalRecord();

			} else {
				// Did we have a failure on a previous column, if so skip this
				// column until the next row.
				if (!currentRowProgress) {
					this.currentStatistics.addFailedRecord(row, column);
					break;
				}
			}

			// The header row, can be used to validate against our expected
			// mapping.
			// TODO, make sure we deal with a string object.
			if (row == currentMapping.getHeaderRow()) {

				Object headerType = currentMapping.getDataTypes()[column];
				String expectedValue = currentMapping.getDataHeaders()[column];

				if (expectedValue.equals(value)) {
					currentMatchingHeaders += 1;
					// We have a header match. report the type:
					System.out.println("With type: "
							+ (headerType != null ? headerType.toString()
									: "No type"));
				}
			}

			// Process the actual data, we need the column.
			// Transform to our EMF Value object. Set the timestamp and the
			// value.
			// Note we either get a Double or Unicode String.
			if (row >= currentMapping.getFirstDataRow()) {

				// We are beyond our headers so let's evaluate if our headers
				// matched.
				// If not we fail.
				if (currentMapping.getDataHeaders().length != currentMatchingHeaders) {
					return MAPPING_ERROR;
				}

				// Match, parse and create a record based on our expected type
				// for this column.
				Object headerType = currentMapping.getDataTypes()[column];

				// Ignore null, headers.
				if (headerType == null) {
					break;
				}

				// Deal with the timestamp
				if (headerType == XMLGregorianCalendar.class) {
					if (value instanceof String) {
						// Try to parse the timestamp.
						// TODO, the timestamp pattern should be stored in the
						// mapping as well.
						// Example: 10/11/2010 11:00:00

						String PATTERN = "MM/dd/yyyy hh:mm:ss";

						SimpleDateFormat sf = new SimpleDateFormat(PATTERN);
						try {
							currentTimeStamp = sf.parse(value.toString());
							System.out.println(currentTimeStamp.toString());

						} catch (ParseException e) {
							// We can't process the date, so this is a failed
							// record, jump to the next row.
							currentStatistics.addFailedRecord(row, column);
							currentRowProgress = false; // Don't bother with
														// this row anymore.
						}
					}
					break; // Column done, next.
				}

				// Deal with identifiers.
				if (headerType instanceof XLSMapping.IEMFDestDescriptor) {
					XLSMapping.IEMFDestDescriptor idMapping = (XLSMapping.IEMFDestDescriptor) headerType;

					// Should be interpreted as String, not Number.
					if (value instanceof String) {
						// Add the next identifier.
						currentRowIndentifiers.add(new Tuple(idMapping,
								(String) value));
					}
					break; // Column done, next.
				}

				// Deal with values.
				if (headerType == Metric.class) {
					// Should be interpreted as String, not Number.
					if (value instanceof Double) {

						Value metricValue = GenericsFactory.eINSTANCE
								.createValue();

						GregorianCalendar calendar = new GregorianCalendar();
						// Use the timezone from the host. 
						calendar.setTimeZone(TimeZone.getDefault());
						calendar.setTime(currentTimeStamp);
						XMLGregorianCalendar xmlCalendar;
						try {
							xmlCalendar = DatatypeFactory.newInstance()
									.newXMLGregorianCalendar(calendar);
							metricValue.setTimeStamp(xmlCalendar);
							metricValue
									.setValue(((Double) value).doubleValue());

							currentRecordMap
									.add(new Tuple(currentRowIndentifiers,
											new Tuple(currentMapping
													.getDataHeaders()[column],
													metricValue)));

						} catch (DatatypeConfigurationException e) {
							// We can't process the date, so this is a failed
							// record, jump to the next row.
						}
					}
					break; // Column done, next.
				}

				// We have an undefined column.
				currentStatistics.addFailedRecord(row, column);
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
		return 0;
	}

}
