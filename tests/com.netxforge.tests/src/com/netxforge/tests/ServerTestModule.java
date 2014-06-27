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
import com.netxforge.netxstudio.data.cdo.ICDOConnection;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentLocator;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IndexComponentLocator;
import com.netxforge.netxstudio.server.IServerUtils;
import com.netxforge.netxstudio.server.ServerUtils;
import com.netxforge.netxstudio.server.data.IServerDataProvider;
import com.netxforge.netxstudio.server.data.IServerNoCacheDataProvider;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.data.ServerCDOConnection;
import com.netxforge.netxstudio.server.data.ServerCDODataProvider;
import com.netxforge.netxstudio.server.data.ServerNoCache;
import com.netxforge.netxstudio.server.data.ServerNoCacheCDOConnection;
import com.netxforge.netxstudio.server.data.ServerNoCacheCDODataProvider;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class ServerTestModule extends AbstractModule {

	@Override
	protected void configure() {

		// Bind the server standard CDO Connection
		this.bind(ICDOConnection.class).annotatedWith(Server.class)
				.to(ServerCDOConnection.class);

		// Bind the server standard CDO Provider
		bind(IServerDataProvider.class).annotatedWith(Server.class).to(
				ServerCDODataProvider.class);

		// Bind the server no-caching CDO Connection
		this.bind(ICDOConnection.class).annotatedWith(ServerNoCache.class)
				.to(ServerNoCacheCDOConnection.class);

		// Bind the server standard CDO Provider
		bind(IServerNoCacheDataProvider.class).annotatedWith(
				ServerNoCache.class).to(ServerNoCacheCDODataProvider.class);

		bind(IServerUtils.class).to(ServerUtils.class);

		//		bind(IPropertiesProvider.class).to(ServerProperties.class);

		bind(IComponentMappingIndex.class).to(ComponentMappingIndex.class);
		bind(IComponentLocator.class).to(IndexComponentLocator.class);

	}
}
