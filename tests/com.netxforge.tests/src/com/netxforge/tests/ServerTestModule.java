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
package com.netxforge.tests;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.properties.IPropertiesProvider;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.cdo.CDOQueryService;
import com.netxforge.netxstudio.data.cdo.ICDOConnection;
import com.netxforge.netxstudio.data.importer.IComponentLocator;
import com.netxforge.netxstudio.data.importer.IndexComponentLocator;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;
import com.netxforge.netxstudio.server.IServerUtils;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.ServerCDOConnection;
import com.netxforge.netxstudio.server.ServerCDODataProvider;
import com.netxforge.netxstudio.server.ServerNoCache;
import com.netxforge.netxstudio.server.ServerNoCacheCDOConnection;
import com.netxforge.netxstudio.server.ServerNoCacheCDODataProvider;
import com.netxforge.netxstudio.server.ServerProperties;
import com.netxforge.netxstudio.server.ServerUtils;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class ServerTestModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(ModelUtils.class);
		// Bind the server standard CDO Connection
		this.bind(ICDOConnection.class).annotatedWith(Server.class)
				.to(ServerCDOConnection.class);

		// Bind the server standard CDO Provider
		bind(IDataProvider.class).annotatedWith(Server.class).to(
				ServerCDODataProvider.class);

		// Bind the server no-caching CDO Connection
		this.bind(ICDOConnection.class).annotatedWith(ServerNoCache.class)
				.to(ServerNoCacheCDOConnection.class);

		// Bind the server standard CDO Provider
		bind(IDataProvider.class).annotatedWith(ServerNoCache.class).to(
				ServerNoCacheCDODataProvider.class);

		bind(IServerUtils.class).to(ServerUtils.class);

		bind(IQueryService.class).to(CDOQueryService.class);

		bind(IPropertiesProvider.class).to(ServerProperties.class);

		bind(IComponentMappingIndex.class).to(ComponentMappingIndex.class);
		bind(IComponentLocator.class).to(IndexComponentLocator.class);

	}
}
