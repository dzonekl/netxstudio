/*******************************************************************************
 * Copyright (c) 5 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.server.job.internal;

import static org.ops4j.peaberry.Peaberry.service;

import com.google.inject.AbstractModule;
import com.netxforge.base.properties.IPropertiesProvider;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.server.IServerUtils;
import com.netxforge.netxstudio.server.data.IServerDataProvider;
import com.netxforge.netxstudio.server.data.IServerNoCacheDataProvider;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.data.ServerNoCache;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;

/**
 * @author Christophe Bouhier
 */
public class JobModule extends AbstractModule {

	// Bind our expression engine.
	@Override
	protected void configure() {

		// //////////////////////////////////////////////
		// INTERNAL SERVICES
		bind(IRunMonitor.class).to(ServerWorkFlowRunMonitor.class);

		// ///////////////////////////////
		// EXPORT SERVICES

		// ///////////////////////////////
		// IMPORT SERVICES

		// {@link ServerModule}
		bind(IServerDataProvider.class).annotatedWith(Server.class).toProvider(
				service(IServerDataProvider.class).single());

		// {@link ServerModule}
		bind(IServerNoCacheDataProvider.class).annotatedWith(ServerNoCache.class)
				.toProvider(service(IServerNoCacheDataProvider.class).single());

		// {@link ServerModule}
		bind(IServerUtils.class).toProvider(
				service(IServerUtils.class).single());

		// {@link ServerModule}
		bind(IPropertiesProvider.class).toProvider(
				service(IPropertiesProvider.class).single());

	}

}
