/*******************************************************************************
 * Copyright (c) 6 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.data.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.Attributes.objectClass;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.data.importer.CSVMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.importer.DefaultImporterHelper;
import com.netxforge.netxstudio.data.importer.ICSVMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.importer.IComponentLocator;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.IRDBMSMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.importer.IXLSMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.importer.IndexComponentLocator;
import com.netxforge.netxstudio.data.importer.RDBMSMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.data.importer.XLSMetricValuesImporterProvider;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;

public class ImporterModule extends AbstractModule {

	// Bind our expression engine.
	@Override
	protected void configure() {

		// ////////////////////////////////
		// INTERNAL SERVICES

		// ///////////////////////////////
		// EXPORT SERVICES

		bind(export(IXLSMetricValuesImporterProvider.class)).toProvider(
				service(XLSMetricValuesImporterProvider.class).export());

		bind(export(ICSVMetricValuesImporterProvider.class)).toProvider(
				service(CSVMetricValuesImporterProvider.class).export());

		bind(export(IRDBMSMetricValuesImporterProvider.class)).toProvider(
				service(RDBMSMetricValuesImporterProvider.class).export());

		bind(export(IComponentMappingIndex.class)).toProvider(
				service(ComponentMappingIndex.class).export());

		bind(export(IComponentLocator.class)).toProvider(
				service(IndexComponentLocator.class).export());

		// CB Consider not exposing the binding here, but in the client
		bind(export(IImporterHelper.class)).toProvider(
				service(DefaultImporterHelper.class).export());

		bind(export(ResultProcessor.class)).toProvider(
				service(new ResultProcessor()).attributes(
						objectClass(ResultProcessor.class)).export());
		// ///////////////////////////////
		// IMPORT SERVICES

		bind(IComponentLocator.class).toProvider(
				service(IComponentLocator.class).single());

	}
}