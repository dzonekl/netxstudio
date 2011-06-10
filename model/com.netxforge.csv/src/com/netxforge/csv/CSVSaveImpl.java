/*******************************************************************************
 * Copyright (c) Jun 10, 2011 NetXForge.
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
package com.netxforge.csv;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import com.netxforge.csv.preference.PreferenceConstants;

/**
 * We serialize and de-serialize our model to / from a CSV template The target
 * is a Node object and it's associated Node resources. The CSVResource holds a
 * copy of the complete NetworkData so we need to look up the target node first.
 * 
 * FIXME, Not fully implemented yet. 
 * 
 */
public class CSVSaveImpl implements CSVSave {
	protected CSVResourceImpl resource;
	protected Map<?, ?> options;
	@SuppressWarnings("unused")
	private EObject targetNode;

	/**
	 * The target node, is the node for which to output the CSV.
	 * 
	 * @param targetNode
	 */
	public CSVSaveImpl(EObject targetNode) {
		this.targetNode = targetNode;
	}

	public void save(CSVResourceImpl resource, OutputStream outputStream,
			Map<?, ?> options) throws IOException {

		OutputStreamWriter osWriter = new OutputStreamWriter(outputStream);
		
		
		// TODO, expand on options. (NE should work for now). 
		// Note: This also applies to the Load implementation. 
		boolean useExcelNE = Boolean.TRUE.equals(options.get(CSVResourceImpl.OPTION_EXCEL_NORTH_EUROPE));
		
		
		CsvPreference pref = PreferenceConstants.getPreference(PreferenceConstants.STANDARD_PREFERENCE);
		
		if(useExcelNE){
			pref = PreferenceConstants.getPreference(PreferenceConstants.EXCEL_NORTH_EUROPE_PREFERENCE);
		}
		
		ICsvMapWriter writer = new CsvMapWriter(osWriter, pref);
		
		
//		NetworkplanPackage npPackage = NetworkplanPackage.eINSTANCE;
//		NetworkdataPackage ndPackage = NetworkdataPackage.eINSTANCE;

		
		/**
		 * A collection of text strings used as a CSV Header.
		 */
		Collection<String> header = new ArrayList<String>();
		
		/**
		 * A map of data fields representing the header,  
		 */
		final HashMap<String, ? super Object> data1 = new HashMap<String, Object>();


		String[] headerArray = new String[header.size()];
		writer.writeHeader(header.toArray(headerArray));

		// TODO, here our resource content which is a tree structure. 
		// we can't have an empty data structure so we fill it with null
		// strings;
		
		
		for (int i = 0; i < header.size(); i++) {
			data1.put(headerArray[i], "");
		}

		writer.write(data1, headerArray);
		writer.close();
	}

	protected void handleErrors() throws IOException {
		if (!resource.getErrors().isEmpty()) {
			Resource.Diagnostic error = resource.getErrors().get(0);
			if (error instanceof Exception) {
				throw new Resource.IOWrappedException((Exception) error);
			} else {
				throw new IOException(error.getMessage());
			}
		}
	}

}
