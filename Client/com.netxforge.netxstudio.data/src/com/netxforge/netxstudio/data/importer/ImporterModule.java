package com.netxforge.netxstudio.data.importer;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ImporterModule extends AbstractModule {

	// Bind our expression engine.
	@Override
	protected void configure() {
		this.bind(XLSMetricValuesImporter.class);
		this.bind(CSVMetricValuesImporter.class);
		this.bind(RDBMSMetricValuesImporter.class);
		this.bind(ComponentLocator.class);
		this.bind(IImporterHelper.class).to(DefaultImporterHelper.class);
		this.bind(ResultProcessor.class).in(Singleton.class);
	}
}