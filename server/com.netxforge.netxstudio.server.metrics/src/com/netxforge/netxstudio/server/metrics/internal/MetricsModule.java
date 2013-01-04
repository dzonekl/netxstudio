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