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
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * An implementation of an EMF Resource customized to handle data which is CSV
 * based.
 * 
 * CSV requires us to set which EMF ECore object is subject to the saving and
 * loading.
 * 
 * @author Christophe Bouhier
 * 
 */
public class CSVResourceImpl extends ResourceImpl implements Resource {
	
	public static final String OPTION_EXCEL_NORTH_EUROPE = "EXCEL_NORTH_EUROPE_PREFERENCE";
	public static final String OPTION_STANDARD = "STANDARD_PREFERENCE";
	public static final String OPTION_EXCEL = "EXCEL_PREFERENCE";
	public static final String OPTION_NO_COMMENT = "NO_COMMENT_PREFERENCE";
	
	
	EObject targetObject;

	public CSVResourceImpl(EObject targetObject) {
		super();
		this.targetObject = targetObject;
	}

	/**
	 * The target node will be set when loading the resource.
	 * 
	 * @param uri
	 */
	public CSVResourceImpl(URI uri) {
		super(uri);
	}

	String encoding;
	
	private CSVLoad csvLoad;
	/**
	 * @return the csvLoad
	 */
	public CSVLoad getCsvLoad() {
		return csvLoad;
	}

	/**
	 * @return the csvSave
	 */
	public CSVSave getCsvSave() {
		return csvSave;
	}

	private CSVSave csvSave;

	protected CSVLoad createCSVLoad() {

		return new CSVLoadImpl();
	}

	protected CSVSave createCSVSave() {

		return new CSVSaveImpl(targetObject);
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		csvSave = createCSVSave();

		if (options == null) {
			options = this.getDefaultSaveOptions();
		}
		csvSave.save(this, outputStream, options);
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		csvLoad = createCSVLoad();

		if (options == null) {
			options = this.getDefaultLoadOptions();
		}

		// TODO Resource handler???
		// ResourceHandler handler =
		// (ResourceHandler)options.get(OPTION_RESOURCE_HANDLER);
		//
		// if (handler != null)
		// {
		// handler.preLoad(this, inputStream, options);
		// }
		//
		csvLoad.load(this, inputStream, options);
		//
		// if (handler != null)
		// {
		// handler.postLoad(this, inputStream, options);
		// }

	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public Map<Object, Object> getDefaultLoadOptions() {
		if (defaultLoadOptions == null) {
			defaultLoadOptions = new HashMap<Object, Object>();
		}
		return defaultLoadOptions;
	}
	
	public Map<Object, Object> getDefaultSaveOptions()
	  {
	    if (defaultSaveOptions == null)
	    {
	      defaultSaveOptions = new HashMap<Object, Object>();
	    }
	    return defaultSaveOptions;
	  }


}