/*******************************************************************************
 * Copyright (c) 18 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.models.importer;

import java.util.Map;

import org.eclipse.emf.cdo.common.id.CDOID;

import com.google.common.collect.Maps;
import com.netxforge.netxstudio.models.importer.internal.ImportActivator;

/**
 * If a reference needs an old ID it can find it here, minding a previous import
 * has stored it.
 * 
 * @author Christophe Bouhier
 * 
 */
public class OldIDLookupService {

	private static final OldIDLookupService self = new OldIDLookupService();
	
	
	/**
	 * Get the singleton. 
	 * @return
	 */
	public static OldIDLookupService getInstance() {
		return self;
	}

	/** Our lookup containing a reference to the new ID */
	private final Map<String, CDOID> lookup = Maps.newHashMap();

	public void reset() {
		lookup.clear();
	}

	/**
	 * Register a new ID for a previous export with an old ID. The new CDOID,
	 * needs to be live in the system.
	 * 
	 * @param oldOID
	 * @param newID
	 */
	public void register(String oldOID, CDOID newID) {
		if (lookup.containsKey(oldOID)) {
			// Attempt to register an existing ID.
			if (ImportActivator.DEBUG) {
				ImportActivator.TRACE.trace(
						ImportActivator.TRACE_IMPORT_OPTION, "");
			} else {
				lookup.put(oldOID, newID);
			}
		} else {

		}
	}
	

	public CDOID lookup(String oldID) {
		return lookup.get(oldID);
	}

}
