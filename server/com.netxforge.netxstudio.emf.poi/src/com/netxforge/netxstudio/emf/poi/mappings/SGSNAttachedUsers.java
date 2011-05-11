package com.netxforge.netxstudio.emf.poi.mappings;

import javax.xml.datatype.XMLGregorianCalendar;

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;

/**
 * Sample instance of a mapping. 
 * TODO, make sure this is serializable. 
 * 
 * @author dzonekl
 *
 */
public class SGSNAttachedUsers extends XLSMapping {
	String[] headers = new String[] { "Start Time", "Period", "NE Name",
			"SGSN Function", "Gb mode max attached users(number)",
			"Iu mode max attached users(number)" };

	public SGSNAttachedUsers(){
		
		super.setHeaderRow(9);
		super.setFirstDataRow(10);
		super.setDataHeaders(headers);

		super.setDataTypes(new Object[]{XMLGregorianCalendar.class, null, 
				this.new EMFDestDescriptor(Node.class, OperatorsPackage.NODE__NODE_ID, null), null, Metric.class, Metric.class});
		
	}
}
