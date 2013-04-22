/*******************************************************************************
 * Copyright (c) Nov 2, 2012 NetXForge.
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
package com.netxforge.netxstudio.common.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.framework.Bundle;

import com.netxforge.netxstudio.common.internal.CommonActivator;

/**
 * @author Christophe Bouhier
 * 
 */
public class PropertiesUtil {

	public static final String NETXSTUDIO_PROPS_COMMENT = "The NetXStudio properties";

	/** This property can be used to specify an external addon model **/
	public static final String NETXSERVER_PROP_ADDON_MODEL_URI = "netxstudio.modeladdon";

	public void readProperties(Location location, String fileName, Properties p) {
		String filePath = location.getURL().getPath() + fileName;
		File file = new File(filePath);
		this.readProperties(file, p);
	}

	/**
	 * Read properties p from a Bundle b with a file name fileName.
	 * 
	 * @param b
	 * @param fileName
	 * @param p
	 */
	public void readProperties(Bundle b, String fileName, Properties p) {
		File f = b.getDataFile(fileName);
		readProperties(f, p);
	}

	public void readProperties(File f, Properties p) {

		try {
			if (f.exists()) {
				// Read properties file.
				p.load(new FileInputStream(f));

				if (CommonActivator.DEBUG) {
					CommonActivator.TRACE.trace(
							CommonActivator.TRACE_COMMON_PROPS_OPTION,
							p.toString());
				}
			} else {
				if (f.createNewFile()) {
					p.store(new FileOutputStream(f), NETXSTUDIO_PROPS_COMMENT);

					if (CommonActivator.DEBUG) {
						CommonActivator.TRACE.trace(
								CommonActivator.TRACE_COMMON_PROPS_OPTION,
								"created properties file");
					}
				}
			}
		} catch (FileNotFoundException fnfe) {
			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_PROPS_OPTION,
						"properties error", fnfe);
			}
		} catch (IOException e) {
			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_PROPS_OPTION,
						"properties error", e);
			}
		}
	}

	/**
	 * Write out the properties p to a file with name in the bundle b
	 * 
	 * @param b
	 * @param fileName
	 * @param p
	 */
	public void writeProperties(Bundle b, String fileName, Properties p) {
		File f = b.getDataFile(fileName);
		writeProperties(f, p);
	}

	/**
	 * Write the properties to a Location object.
	 * 
	 * @param location
	 * @param fileName
	 * @param p
	 */
	public void writeProperties(Location location, String fileName, Properties p) {
		String filePath = location.getURL().getPath() + fileName;
		File file = new File(filePath);
		writeProperties(file, p);
	}

	/**
	 * Write the properties to a file.
	 * 
	 * @param f
	 * @param p
	 */
	public void writeProperties(File f, Properties p) {

		try {
			p.store(new FileOutputStream(f), NETXSTUDIO_PROPS_COMMENT);
		} catch (IOException ioe) {
			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_PROPS_OPTION,
						"properties error", ioe);
			}
		}
	}

}
