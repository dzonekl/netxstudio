/*******************************************************************************
 * Copyright (c) 16 mei 2013 NetXForge.
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
package com.netxforge.netxstudio.data.importer;

public interface IMetricValueImporter {

	public static final String ROOT_SYSTEM_PROPERTY = "metricSourceRoot";
	public static final boolean RENAME_FILE_AT_PROCESS = true;
	public static final String NETXSTUDIO_MAX_MAPPING_STATS_QUANTITY = "netxstudio.max.mapping.stats.quantity";
	
	public static enum IMPORT_ERROR {
		ComponentNotMatched,
		ComponentMatchDuplicates,
		MetricNotFound, 
		GeneralError
	};
	
	// How
	// many
	// stats
	// to
	// keep
	// per
	// metric
	// source.
	public static final int NETXSTUDIO_MAX_MAPPING_STATS_QUANTITY_DEFAULT = 500; // How
																					// many
																					// stats
																					// to
																					// keep.

	public abstract void process();
	
	
	
}