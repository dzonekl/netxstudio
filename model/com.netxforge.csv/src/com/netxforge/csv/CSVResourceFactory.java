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


import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.jface.preference.IPreferenceStore;

import com.netxforge.csv.preference.PreferenceConstants;

/**
 * A custom implementation of a resource factory. This factory when registered
 * against some file extensions or protocol schemas will create a CSVResource
 * and assigns it default save a load options.
 * 
 * @author cbouhier
 */
public class CSVResourceFactory extends ResourceFactoryImpl{
	
	public CSVResourceFactory() {
		super();
	}

	// default load options.
	private static final Map<Object, Object> loadOptions = new HashMap<Object, Object>();

	// default save options.
	private static final Map<Object, Object> saveOptions = new HashMap<Object, Object>();

	static {

//		XMIResource resource = new XMIResourceImpl();

		// default load options.
//		loadOptions.putAll(resource.getDefaultLoadOptions());
//		loadOptions.put(XMIResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
//
//		// default save options.
//		saveOptions.putAll(resource.getDefaultSaveOptions());
//		saveOptions.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
//		saveOptions.put(XMIResource.OPTION_PROCESS_DANGLING_HREF,
//			XMIResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
//		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
//		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
//		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
//		saveOptions.put(XMIResource.OPTION_SKIP_ESCAPE_URI, Boolean.FALSE);
//		saveOptions.put(XMIResource.OPTION_ENCODING, EMFCoreConstants.XMI_ENCODING);
	}

	/**
	 * Get default load options.
	 */
	public static Map<Object, Object> getDefaultLoadOptions() {
		return loadOptions;
	}

	/**
	 * Get default save options.
	 */
	public static Map<Object, Object> getDefaultSaveOptions() {
		return saveOptions;
	}

	public Resource createResource(URI uri) {

		CSVResourceImpl resource = new CSVResourceImpl(uri);

		resource.getDefaultLoadOptions().putAll(loadOptions);
		resource.getDefaultSaveOptions().putAll(saveOptions);

//		if (!resource.getEncoding().equals(EMFCoreConstants.XMI_ENCODING))
//			resource.setEncoding(EMFCoreConstants.XMI_ENCODING);

		return resource;
	}
	
	
	protected void mapOptionsFromPreferences(){
		// Get the delimiter preference.
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		String delimiter = store
				.getString(PreferenceConstants.P_DELIMETER);
		
		if(PreferenceConstants.EXCEL_NORTH_EUROPE_PREFERENCE.equals(delimiter)){
			saveOptions.put(CSVResourceImpl.OPTION_EXCEL_NORTH_EUROPE, Boolean.TRUE);
		}
		
		
	}
	
	
	
	
}