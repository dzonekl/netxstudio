/*******************************************************************************
 * Copyright (c) 1 okt. 2014 NetXForge.
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
package com.netxforge.oss2.rest.connectors;


/**
 * Process a response on an arbitrary response object.  
 * 
 * @author Christophe Bouhier
 *
 * @param <T>
 */
public interface IEntityProcessr<T> {
	
	
	/**
	 * 
	 * @param response
	 * @return
	 */
	public Object processResult(Object response);
	
	
	/**
	 * Get the result as an entity object. 
	 * 
	 * @return
	 */
	public Object getResult();
	
}
