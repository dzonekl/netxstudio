package com.netxforge.netxstudio.server.metrics.internal;

import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.ImporterModule;
import com.netxforge.netxstudio.server.metrics.MetricSourceImportService.ServiceRunner;
import com.netxforge.netxstudio.server.metrics.MetricSourceJobImplementation;
import com.netxforge.netxstudio.server.metrics.ServerImporterHelper;
import com.netxforge.netxstudio.server.metrics.ServerImporterHelper.LocalDataProviderProvider;

public class MetricsModule extends ImporterModule {

	// Bind our expression engine.
	@Override
	protected void configure() {
		this.bind(LocalDataProviderProvider.class);
		this.bind(MetricSourceJobImplementation.class);
		this.bind(ServiceRunner.class);
		// Should override the default helper. 
		this.bind(IImporterHelper.class).to(ServerImporterHelper.class);
	}
}