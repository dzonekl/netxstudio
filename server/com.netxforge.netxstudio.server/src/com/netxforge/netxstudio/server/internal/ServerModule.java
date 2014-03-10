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
package com.netxforge.netxstudio.server.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import org.eclipse.emf.cdo.spi.server.RepositoryUserManager;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.base.properties.IPropertiesProvider;
import com.netxforge.netxstudio.data.cdo.ICDOConnection;
import com.netxforge.netxstudio.server.CommitInfoHandler;
import com.netxforge.netxstudio.server.IServerUtils;
import com.netxforge.netxstudio.server.NetxForgeUserManager;
import com.netxforge.netxstudio.server.ServerIntegrity;
import com.netxforge.netxstudio.server.ServerProperties;
import com.netxforge.netxstudio.server.ServerUtils;
import com.netxforge.netxstudio.server.ServerUtils.ServerInitializer;
import com.netxforge.netxstudio.server.data.IServerDataProvider;
import com.netxforge.netxstudio.server.data.IServerNoCacheDataProvider;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.data.ServerCDOConnection;
import com.netxforge.netxstudio.server.data.ServerCDOData;
import com.netxforge.netxstudio.server.data.ServerCDODataProvider;
import com.netxforge.netxstudio.server.data.ServerNoCache;
import com.netxforge.netxstudio.server.data.ServerNoCacheCDOConnection;
import com.netxforge.netxstudio.server.data.ServerNoCacheCDOData;
import com.netxforge.netxstudio.server.data.ServerNoCacheCDODataProvider;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class ServerModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {

		// //////////////////////////////////////////////
		// INTERNAL SERVICES

		// Bind the server standard CDO Connection
		this.bind(ICDOConnection.class).annotatedWith(Server.class)
				.to(ServerCDOConnection.class);

		// Bind the server standard CDO Provider
		bind(ICDOData.class).annotatedWith(Server.class).to(
				ServerCDOData.class);

		// Bind the server no-caching CDO Connection
		this.bind(ICDOConnection.class).annotatedWith(ServerNoCache.class)
				.to(ServerNoCacheCDOConnection.class);

		// Bind the server standard CDO Provider
		bind(ICDOData.class).annotatedWith(ServerNoCache.class).to(
				ServerNoCacheCDOData.class);

		// Bind the server initializer
		this.bind(ServerInitializer.class);

		// Bind the server commit information handler.
		this.bind(CommitInfoHandler.class);

		// Bind the server Integrity module
		this.bind(ServerIntegrity.class);

		// Bind the IRepository User manager.
		this.bind(RepositoryUserManager.class).to(NetxForgeUserManager.class)
				.in(Scopes.SINGLETON);

		// ///////////////////////////////
		// EXPORT SERVICES

		bind(export(IServerDataProvider.class)).annotatedWith(Server.class).toProvider(
				service(ServerCDODataProvider.class).export());

		bind(export(IServerNoCacheDataProvider.class)).annotatedWith(
				ServerNoCache.class).toProvider(
				service(ServerNoCacheCDODataProvider.class).export());

		bind(export(IServerUtils.class)).toProvider(
				service(ServerUtils.class).export());

		bind(export(IPropertiesProvider.class)).toProvider(
				service(ServerProperties.class).export());

		// ///////////////////////////////
		// IMPORT SERVICES
		// (Copy to modules in other OSGI bundles to import the service).

		// {@link ServerModule}
		bind(IServerUtils.class).toProvider(
				service(IServerUtils.class).single());
		// {@link ServerModule}
		bind(IPropertiesProvider.class).toProvider(
				service(IPropertiesProvider.class).single());

	}
}
