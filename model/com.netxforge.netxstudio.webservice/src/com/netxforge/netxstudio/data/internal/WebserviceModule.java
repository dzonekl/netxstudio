/*******************************************************************************
 * Copyright (c) 6 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.data.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.Attributes.objectClass;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.data.actions.ServerRequest;

public class WebserviceModule extends AbstractModule {

	// Bind our expression engine.
	@Override
	protected void configure() {

		// ////////////////////////////////
		// INTERNAL SERVICES

		// ///////////////////////////////
		// EXPORT SERVICES

		bind(export(ServerRequest.class)).toProvider(
				service(ServerRequest.class).attributes(
						objectClass(ServerRequest.class)).export());
		
		
		// ///////////////////////////////
		// IMPORT SERVICES
		
		// {@link DataModule}
		bind(ICDODataService.class).toProvider(
				service(ICDODataService.class).single());
	}
}