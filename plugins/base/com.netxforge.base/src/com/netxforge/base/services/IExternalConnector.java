/*******************************************************************************
 * Copyright (c) 29 sep. 2014 NetXForge.
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
package com.netxforge.base.services;

import java.net.URI;

/**
 * 
 * @author Christophe Bouhier
 *
 */
public interface IExternalConnector {
	
	
	/**
	 * If the {@link URI#getScheme()} is supported. 
	 * @param schema
	 * @return
	 */
	public boolean supportsSchema(String schema);
	
	/**
	 * Connect with the provided info. 
	 * @param info
	 */
	public Object connect(Object info);
	
	
	/**
	 * Provide an arbitrary object which can be populated and given back to the connector. 
	 * @return
	 */
	public Object connectorInfo();

}
