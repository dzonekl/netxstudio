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
package com.netxforge.screens.editing.base.internal;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.netxforge.screens.editing.base.IScreenFactory;
import com.netxforge.screens.editing.base.ScreenFactory;
import com.netxforge.screens.editing.base.actions.clipboard.ClipboardService;
import com.netxforge.screens.editing.base.tables.TableHelper;
import com.netxforge.screens.editing.base.util.ValidationService;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class BaseEditingModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {

		// ///////////////////////////////
		// INTERNAL SERVICES

		// Binding util.
		this.bind(TableHelper.class);
		this.bind(ValidationService.class);

		// ///////////////////////////////
		// EXPORT SERVICES
		
//		bind(export(IEditingServiceProvider.class)).toProvider(
//				service(EMFEditingServiceProvider.class).export());
//
//		bind(export(IScreenFormServiceProvider.class)).toProvider(
//				service(ScreenFormServiceProvider.class).export());
		
		// ////////////////////////////////
		// INTERNAL SERVICES

		bind(IScreenFactory.class).to(ScreenFactory.class);
		bind(ClipboardService.class).in(Scopes.SINGLETON);

//		bind(IEditingServiceProvider.class).toProvider(
//				service(IEditingServiceProvider.class).single());
		
		// /////////////////////////////////////
		// IMPORTED SERVICES
		
//		// {@link BaseModule}
//		bind(IDataProvider.class).toProvider(
//				service(IDataProvider.class).single());

		
		
	}
}
