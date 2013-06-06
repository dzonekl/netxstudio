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
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.cdo.CDOQueryService;
import com.netxforge.netxstudio.data.importer.CSVMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.IComponentLocator;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.RDBMSMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.data.importer.XLSMetricValuesImporter;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.ServerNoCache;
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

		this.bind(LocalDataProviderProvider.class);
		this.bind(ServiceRunner.class);
		
		
		// TODO, Likely needs to be exported, as the Job factory will instantiate if from it's own injector (Job).  
		this.bind(MetricSourceJobImplementation.class);

		// Should override the default helper.
		this.bind(IImporterHelper.class).to(ServerImporterHelper.class);

		// ///////////////////////////////
		// IMPORT SERVICES
		bind(IQueryService.class).toProvider(
				service(CDOQueryService.class).single());

		// {@link ServerModule}
		bind(IDataProvider.class).annotatedWith(Server.class).toProvider(
				service(IDataProvider.class).single());

		// {@link ServerModule}
		bind(IDataProvider.class).annotatedWith(ServerNoCache.class)
				.toProvider(service(IDataProvider.class).single());

		// {@link ImporterModule}
		bind(XLSMetricValuesImporter.class).toProvider(
				service(XLSMetricValuesImporter.class).single());
		
		// {@link ImporterModule}
		bind(CSVMetricValuesImporter.class).toProvider(
				service(CSVMetricValuesImporter.class).single());
		
		// {@link ImporterModule}
		bind(RDBMSMetricValuesImporter.class).toProvider(
				service(RDBMSMetricValuesImporter.class).single());
		
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