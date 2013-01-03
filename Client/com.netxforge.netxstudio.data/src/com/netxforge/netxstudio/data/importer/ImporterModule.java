package com.netxforge.netxstudio.data.importer;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;

public class ImporterModule extends AbstractModule {

	// Bind our expression engine.
	@Override
	protected void configure() {
		this.bind(XLSMetricValuesImporter.class);
		this.bind(CSVMetricValuesImporter.class);
		this.bind(RDBMSMetricValuesImporter.class);
		this.bind(IComponentLocator.class).to(BruteForceComponentLocator.class);
		this.bind(IImporterHelper.class).to(DefaultImporterHelper.class);
		this.bind(ResultProcessor.class).in(Singleton.class);
		this.bind(IComponentMappingIndex.class).to(ComponentMappingIndex.class);
	}
}