package com.netxforge.netxstudio.server.metrics.internal;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.data.importer.CSVMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.NetworkElementLocator;
import com.netxforge.netxstudio.data.importer.RDBMSMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.XLSMetricValuesImporter;
import com.netxforge.netxstudio.server.metrics.MetricSourceImportService.ServiceRunner;
import com.netxforge.netxstudio.server.metrics.MetricSourceJobImplementation;
import com.netxforge.netxstudio.server.metrics.ServerImporterHelper;
import com.netxforge.netxstudio.server.metrics.ServerImporterHelper.LocalDataProviderProvider;

public class MetricsModule extends AbstractModule {

	// Bind our expression engine.
	@Override
	protected void configure() {
		this.bind(LocalDataProviderProvider.class);
		this.bind(MetricSourceJobImplementation.class);
		this.bind(XLSMetricValuesImporter.class);
		this.bind(CSVMetricValuesImporter.class);
		this.bind(RDBMSMetricValuesImporter.class);
		this.bind(NetworkElementLocator.class);
		this.bind(ServiceRunner.class);
		this.bind(IImporterHelper.class).to(ServerImporterHelper.class);
	}
}