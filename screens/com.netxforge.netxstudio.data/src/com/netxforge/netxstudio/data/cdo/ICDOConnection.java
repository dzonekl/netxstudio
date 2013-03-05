/*******************************************************************************
 * Copyright (c) May 12, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.cdo;

import org.eclipse.emf.cdo.net4j.CDONet4jSessionConfiguration;


/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public interface ICDOConnection {
	
	/**
	 * Initialize the data connection on the local host. 
	 */
	public void initialize();
	
	/**
	 * Initialize a data connection on the given server. 
	 * @param server
	 */
	public void initialize(String server);
	
	/**
	 * Get the CDO configuration
	 * @return
	 */
	public CDONet4jSessionConfiguration getConfig();
	
}