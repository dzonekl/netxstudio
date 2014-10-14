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
package com.netxforge.oss2.rest.internal;

import com.google.inject.AbstractModule;
import com.netxforge.oss2.rest.connectors.IConnector;
import com.netxforge.oss2.rest.connectors.JerseyConnector;

/**
 * Bindings for this bundle (only).
 * 
 * @author Christophe Bouhier
 * 
 */
public class RestModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(IConnector.class).to(JerseyConnector.class);
	}
}
