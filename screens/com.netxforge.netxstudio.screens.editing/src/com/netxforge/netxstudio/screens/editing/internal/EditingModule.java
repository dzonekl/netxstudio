/*******************************************************************************
 * Copyright (c) May 10, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.data.cdo.IClientCDODataProvider;
import com.netxforge.netxstudio.screens.editing.CDOEditingServiceProvider;
import com.netxforge.netxstudio.screens.editing.CDOScreenFormServiceProvider;
import com.netxforge.screens.editing.base.IEditingServiceProvider;
import com.netxforge.screens.editing.base.IScreenFactory;
import com.netxforge.screens.editing.base.IScreenFormServiceProvider;
import com.netxforge.screens.editing.base.ScreenFactory;
import com.netxforge.screens.editing.base.actions.clipboard.ClipboardService;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class EditingModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {

		// ///////////////////////////////
		// INTERNAL SERVICES

		// ///////////////////////////////
		// EXPORT SERVICES

		bind(export(IEditingServiceProvider.class)).toProvider(
				service(CDOEditingServiceProvider.class).export());

		bind(export(IScreenFormServiceProvider.class)).toProvider(
				service(CDOScreenFormServiceProvider.class).export());

		// ////////////////////////////////
		// INTERNAL SERVICES

		bind(IScreenFactory.class).to(ScreenFactory.class);

		bind(ClipboardService.class).in(Scopes.SINGLETON);
		
		bind(IEditingServiceProvider.class).toProvider(
				service(IEditingServiceProvider.class).single());
		
		// /////////////////////////////////////
		// IMPORTED SERVICES
		
		
		// {@link DataModule}
		bind(IClientCDODataProvider.class).toProvider(
				service(IClientCDODataProvider.class).single());

		// {@link DataModule}
		bind(ICDODataService.class).toProvider(
				service(ICDODataService.class).single());
	}
}
