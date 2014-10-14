/*******************************************************************************
 * Copyright (c) 14 okt. 2014 NetXForge.
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
package com.netxforge.oss2.mappings;

import java.util.List;

/**
 * Provides the {@link IMappingService} implementations as known in runtime.
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IMappingAggregator {

	/**
	 * 
	 * Get all the discovered mapping services...
	 * 
	 * @return
	 */
	public List<IMappingService> getMappingServices();

	/**
	 * Get the (first registered) {@link IMappingService} which support the given namespace.
	 * 
	 * @param namespace
	 * @return
	 */
	public IMappingService serviceForNamespace(String namespace);

}
