/*******************************************************************************
 * Copyright (c) 11 feb. 2013 NetXForge.
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
package com.netxforge.netxstudio.server.metrics.internal;

import static org.ops4j.peaberry.Peaberry.service;

import com.google.inject.AbstractModule;
import com.netxforge.base.properties.IPropertiesProvider;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.importer.ICSVMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.IRDBMSMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.importer.IXLSMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.index.IComponentLocator;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;
import com.netxforge.netxstudio.data.services.ResultProcessor;
import com.netxforge.netxstudio.server.data.IServerDataProvider;
import com.netxforge.netxstudio.server.data.IServerNoCacheDataProvider;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.data.ServerNoCache;
import com.netxforge.netxstudio.server.metrics.MetricSourceImportService.ServiceRunner;
import com.netxforge.netxstudio.server.metrics.MetricSourceJobImplementation;
import com.netxforge.netxstudio.server.metrics.ServerImporterHelper;
import com.netxforge.netxstudio.server.metrics.ServerImporterHelper.LocalDataProviderProvider;

public class MetricsModule extends AbstractModule {

	// Bind our expression engine.
	@Override
	protected void configure() {

		// //////////////////////////////////////////////
		// INTERNAL SERVICES

		// TODO Consider removing this, why do we need it?
		this.bind(LocalDataProviderProvider.class);
		this.bind(ServiceRunner.class);

		this.bind(MetricSourceJobImplementation.class);

		// Should override the default helper.
		this.bind(IImporterHelper.class).to(ServerImporterHelper.class);

		// ///////////////////////////////
		// IMPORT SERVICES

		// {@link CDODataServiceModule}
		bind(IQueryService.class).toProvider(
				service(IQueryService.class).single());

		// {@link ServerModule}
		bind(IServerDataProvider.class).annotatedWith(Server.class).toProvider(
				service(IServerDataProvider.class).single());

		// {@link ServerModule}
		bind(IServerNoCacheDataProvider.class).annotatedWith(ServerNoCache.class)
				.toProvider(service(IServerNoCacheDataProvider.class).single());

		// {@link ServerModule}
		bind(IPropertiesProvider.class).toProvider(
				service(IPropertiesProvider.class).single());

		// {@link ImporterModule}
		bind(IXLSMetricValuesImporterProvider.class).toProvider(
				service(IXLSMetricValuesImporterProvider.class).single());

		// {@link ImporterModule}
		bind(ICSVMetricValuesImporterProvider.class).toProvider(
				service(ICSVMetricValuesImporterProvider.class).single());

		// {@link ImporterModule}
		bind(IRDBMSMetricValuesImporterProvider.class).toProvider(
				service(IRDBMSMetricValuesImporterProvider.class).single());

		// {@link ImporterModule}
		bind(IComponentMappingIndex.class).toProvider(
				service(IComponentMappingIndex.class).single());

		// {@link ImporterModule}
		bind(IComponentLocator.class).toProvider(
				service(IComponentLocator.class).single());

		// {@link ImporterModule}
		bind(ResultProcessor.class).toProvider(
				service(ResultProcessor.class).single());

	}
}