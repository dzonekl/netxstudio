/*******************************************************************************
 * Copyright (c) 12 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.models.export.ui.internal;

import static org.ops4j.peaberry.Peaberry.service;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.data.cdo.IClientCDODataProvider;

public class IOModule extends AbstractModule {

	@Override
	protected void configure() {

		// ///////////////////////////////
		// IMPORT SERVICES
		// (Copy to modules in other OSGI bundles to import the service).
		// {@link DataModule}
		bind(IClientCDODataProvider.class).toProvider(
				service(IClientCDODataProvider.class).single());
		
	}

}
