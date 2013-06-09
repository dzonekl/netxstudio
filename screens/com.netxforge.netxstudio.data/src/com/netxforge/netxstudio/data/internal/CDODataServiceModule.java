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
package com.netxforge.netxstudio.data.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.google.inject.Singleton;
import com.netxforge.netxstudio.data.DataServiceModule;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.data.cdo.CDODataConnection;
import com.netxforge.netxstudio.data.cdo.CDODataService;
import com.netxforge.netxstudio.data.cdo.CDOQueryService;
import com.netxforge.netxstudio.data.cdo.CDOQueryUtil;
import com.netxforge.netxstudio.data.cdo.ClientCDODataProvider;
import com.netxforge.netxstudio.data.cdo.ICDOConnection;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class CDODataServiceModule extends DataServiceModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {

		// //////////////////////////////////////////////
		// INTERNAL SERVICES

		this.bind(CDOQueryUtil.class);
		this.bind(ServerRequest.class);

		// As a Singleton??
		this.bind(IDataProvider.class).to(ClientCDODataProvider.class)
				.in(Singleton.class);

		this.bind(ICDOConnection.class).to(CDODataConnection.class);
		
		this.bind(IQueryService.class).to(CDOQueryService.class);
		
		// ///////////////////////////////
		// EXPORT SERVICES

		bind(export(IQueryService.class)).toProvider(
				service(CDOQueryService.class).export());

		bind(export(IDataService.class)).toProvider(
				service(CDODataService.class).export());

		// ///////////////////////////////
		// IMPORT SERVICES
		// (Copy to modules in other OSGI bundles to import the service).

		// {@link CDODataServiceModule}
		bind(IDataService.class).toProvider(
				service(IDataService.class).single());

	}
}
