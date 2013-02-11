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

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.data.importer.CSVMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.IComponentLocator;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.IndexComponentLocator;
import com.netxforge.netxstudio.data.importer.RDBMSMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.data.importer.XLSMetricValuesImporter;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;
import com.netxforge.netxstudio.server.metrics.MetricSourceImportService.ServiceRunner;
import com.netxforge.netxstudio.server.metrics.MetricSourceJobImplementation;
import com.netxforge.netxstudio.server.metrics.ServerImporterHelper;
import com.netxforge.netxstudio.server.metrics.ServerImporterHelper.LocalDataProviderProvider;

public class MetricsModule extends AbstractModule {

	// Bind our expression engine.
	@Override
	protected void configure() {
		
		this.bind(XLSMetricValuesImporter.class);
		this.bind(CSVMetricValuesImporter.class);
		this.bind(RDBMSMetricValuesImporter.class);

		this.bind(IComponentMappingIndex.class).to(ComponentMappingIndex.class).in(Singleton.class);
		this.bind(IComponentLocator.class).to(IndexComponentLocator.class).in(Singleton.class);
		this.bind(ResultProcessor.class).in(Singleton.class);
		
		this.bind(LocalDataProviderProvider.class);
		this.bind(MetricSourceJobImplementation.class);
		this.bind(ServiceRunner.class);
		// Should override the default helper. 
		this.bind(IImporterHelper.class).to(ServerImporterHelper.class);
	}
}