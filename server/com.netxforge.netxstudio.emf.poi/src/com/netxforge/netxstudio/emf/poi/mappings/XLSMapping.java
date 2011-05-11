package com.netxforge.netxstudio.emf.poi.mappings;

import java.text.SimpleDateFormat;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.operators.Node;


/**
 * This class is intended to be extended. 
 * 
 * This mapper is capable of interpreting metric values from an .xls binary file with the following characteristics.
 *  
 * The source data is stored in the first sheet of the excel. 
 * The source contains a header row, with an arbitrary number of columns. 
 * The source data rows start after the header row. 
 * The column headers must be defined by the extending class. 
 * The column types must be defined by the extending class. 
 * </p>
 * The mapping service recognizes value types and mapping types. 
 * The mapping types. 
 * </p>
 * Value types:
 * <ul> 
 * <li>{@link XMLGregorianCalendar}</li>
 * <li>{@link Metric}</li>
 * <li><code>null</code></li>
 * </ul>
 * 
 * </p>
 * Mapping types:
 * <ul> 
 * <li>{@link Node}</li>
 * <li>{@link Equipment}</li>
 * <li>{@link Function}</li>
 * <li>{@link EStructuralFeature}</li>
 * <li><code>null</code></li>
 * </ul>
 * </p>
 * Interpretation of types:</p> 
 * Value types are interpreted as follow: 
 * </p>
 * Timestamps texttual pattern are interpreted by the {@link SimpleDateFormat} pattern format.   
 * Metric values are interpreted as number values (Double). 
 * </p>
 * Mapping types are interpreted as follow:
 * If of type Node, Equipment or Function => Map as main node identifier. (NodeID, FunctionName, EquipmentName). 
 * If of type EStructuralFeature => Map as 
 * 
 * @author dzonekl
 *
 */
public abstract class XLSMapping {
		
	
	// TODO, we need some sort of signature to identify the data object (xls in this case) and get the right mapping. 
	// The signature object could be part of this mapping. 
	
	
	public class EMFDestDescriptor implements IEMFDestDescriptor {
		
		/* (non-Javadoc)
		 * @see com.netxforge.netxstudio.emf.poi.mappings.IEMFDestMapping#getType()
		 */
		@Override
		public Object getType() {
			return type;
		}
		/* (non-Javadoc)
		 * @see com.netxforge.netxstudio.emf.poi.mappings.IEMFDestMapping#setType(java.lang.Object)
		 */
		@Override
		public void setType(Object type) {
			this.type = type;
		}
		/* (non-Javadoc)
		 * @see com.netxforge.netxstudio.emf.poi.mappings.IEMFDestMapping#getFeatureID()
		 */
		@Override
		public int getFeatureID() {
			return featureID;
		}
		/* (non-Javadoc)
		 * @see com.netxforge.netxstudio.emf.poi.mappings.IEMFDestMapping#setFeatureID(int)
		 */
		@Override
		public void setFeatureID(int featureID) {
			this.featureID = featureID;
		}
		/* (non-Javadoc)
		 * @see com.netxforge.netxstudio.emf.poi.mappings.IEMFDestMapping#getPattern()
		 */
		@Override
		public String getPattern() {
			return pattern;
		}
		/* (non-Javadoc)
		 * @see com.netxforge.netxstudio.emf.poi.mappings.IEMFDestMapping#setPattern(java.lang.String)
		 */
		@Override
		public void setPattern(String pattern) {
			this.pattern = pattern;
		}
		
		
		Object type;
		int featureID;
		
		/** The pattern is used for interpretation of the identifier, if null it should be ignored.**/
		String pattern = null;
		
		public EMFDestDescriptor(Object type, int featureID, String pattern) {
			super();
			this.type = type;
			this.featureID = featureID;
			this.pattern = pattern;
		}
		
		@Override
		public String toString() {
			return "Type: " + type.toString() + " FeatureID: " + featureID + " Pattern: " + pattern;
		}
		
	}
	
	public interface IEMFDestDescriptor {

		public abstract Object getType();

		public abstract void setType(Object type);

		public abstract int getFeatureID();

		public abstract void setFeatureID(int featureID);
		
		/**
		 * 
		 * @return null or a pattern for interpretation of the Identifier.
		 */
		public abstract String getPattern();

		public abstract void setPattern(String pattern);

	}
	
	/**
	 * the index of the row in the excel which contains the headers. 
	 */
	int headerRow;
	
	int firstDataRow; 
		
	/** Our mapping works for a single sheet, which one is it? **/
	int sheetNumber;
	
	String TimeStamp_Pattern;
	
	String[]  dataHeaders;
	Object[] dataTypes;
	
	public String[] getDataHeaders() {
		return dataHeaders;
	}
	public void setDataHeaders(String... dataHeaders) {
		this.dataHeaders = dataHeaders;
	}
	
	public int getHeaderRow() {
		return headerRow;
	}
	public void setHeaderRow(int headerRow) {
		this.headerRow = headerRow;
	}
	public int getFirstDataRow() {
		return firstDataRow;
	}
	public void setFirstDataRow(int firstDataRow) {
		this.firstDataRow = firstDataRow;
	}
	public Object[] getDataTypes() {
		return dataTypes;
	}
	public void setDataTypes(Object... dataTypes) {
		this.dataTypes = dataTypes;
	}
	
	public int getSheetNumber() {
		return sheetNumber;
	}
	public void setSheetNumber(int sheetNumber) {
		this.sheetNumber = sheetNumber;
	}
	public String getTimeStamp_Pattern() {
		return TimeStamp_Pattern;
	}
	public void setTimeStamp_Pattern(String timeStamp_Pattern) {
		TimeStamp_Pattern = timeStamp_Pattern;
	}
	
}
