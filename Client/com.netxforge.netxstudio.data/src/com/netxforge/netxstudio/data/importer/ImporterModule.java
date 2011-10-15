package com.netxforge.netxstudio.data.importer;

import com.google.inject.AbstractModule;

public class ImporterModule extends AbstractModule {

	// Bind our expression engine.
	@Override
	protected void configure() {
		this.bind(XLSMetricValuesImporter.class);
		this.bind(CSVMetricValuesImporter.class);
		this.bind(RDBMSMetricValuesImporter.class);
		this.bind(NetworkElementLocator.class);
		this.bind(IImporterHelper.class).to(DefaultImporterHelper.class);
	}
}