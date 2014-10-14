/*******************************************************************************
 * Copyright (c) 30 sep. 2014 NetXForge.
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
 * Clients wishing to provide a Rest connector implementation, should implement
 * or use the convenience class {@link AbstractConnector}.
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IConnector {

	/**
	 * Connect to the REST service.
	 */
	public void connect();

	/**
	 * Set our {@link IEntityProcessr}.
	 * 
	 * @param processor
	 */
	@SuppressWarnings("rawtypes")
	public void setEntityProcessor(IEntityProcessr processor);

	/**
	 * Get our {@link IEntityProcessr}.
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public IEntityProcessr getEntityProcessor();

}
