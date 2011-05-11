package com.netxforge.netxstudio.emf.poi.mappings;


public class NullMapping extends XLSMapping {
	String[] headers = new String[]{"header1"};
	
	public NullMapping(){
		super.setHeaderRow(0);
		super.setFirstDataRow(1);
		super.setDataHeaders(headers);
		// From this where to find our information, the Node, the Metrics etc...
		// The Node.id can be used to map, Within the node, we look for the Metrics. 
		super.setDataTypes(new Object[]{String.class});
		
	}
}
