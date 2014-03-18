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
package com.netxforge.editing.base.impl.internal;

import com.google.inject.AbstractModule;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class BaseEditingImplModule extends AbstractModule {

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
		
//		bind(export(IEditingServiceProvider.class)).toProvider(
//				service(EMFEditingServiceProvider.class).export());
//
//		bind(export(IScreenFormServiceProvider.class)).toProvider(
//				service(ScreenFormServiceProvider.class).export());
		
		// ////////////////////////////////
		// INTERNAL SERVICES

//		bind(IEditingServiceProvider.class).toProvider(
//				service(IEditingServiceProvider.class).single());
		
		// /////////////////////////////////////
		// IMPORTED SERVICES
		
		// {@link BaseModule}
//		bind(IDataProvider.class).toProvider(
//				service(IDataProvider.class).single());

		
		
	}
}
