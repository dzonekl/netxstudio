/*******************************************************************************
 * Copyright (c) May 12, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.Attributes.objectClass;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.data.cdo.CDODataConnection;
import com.netxforge.netxstudio.data.cdo.CDODataService;
import com.netxforge.netxstudio.data.cdo.ClientCDOData;
import com.netxforge.netxstudio.data.cdo.ClientCDODataProvider;
import com.netxforge.netxstudio.data.cdo.ICDOConnection;
import com.netxforge.netxstudio.data.cdo.IClientCDODataProvider;
import com.netxforge.netxstudio.data.cdo.INonStaticCDODataProvider;
import com.netxforge.netxstudio.data.cdo.NonStaticCDODataProvider;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentLocator;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IndexComponentLocator;
import com.netxforge.netxstudio.data.services.ResultProcessor;
import com.netxforge.netxstudio.data.services.ValueProcessor;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class DataModule extends com.google.inject.AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {

		// //////////////////////////////////////////////
		// INTERNAL SERVICES

		this.bind(ICDOConnection.class).to(CDODataConnection.class);

		this.bind(ICDOData.class).to(ClientCDOData.class);

		// ///////////////////////////////
		// EXPORT SERVICES

		bind(export(IClientCDODataProvider.class)).toProvider(
				service(ClientCDODataProvider.class).export());

		bind(export(INonStaticCDODataProvider.class)).toProvider(
				service(NonStaticCDODataProvider.class).export());

		bind(export(ICDODataService.class)).toProvider(
				service(CDODataService.class).export());

		bind(export(ResultProcessor.class)).toProvider(
				service(new ResultProcessor()).attributes(
						objectClass(ResultProcessor.class)).export());

		bind(export(ValueProcessor.class)).toProvider(
				service(new ValueProcessor()).attributes(
						objectClass(ValueProcessor.class)).export());

		bind(export(IComponentMappingIndex.class)).toProvider(
				service(ComponentMappingIndex.class).export());

		bind(export(IComponentLocator.class)).toProvider(
				service(IndexComponentLocator.class).export());

		// ///////////////////////////////
		// IMPORT SERVICES
		// (Copy to modules in other OSGI bundles to import the service).

		// {@link DataModule}
		bind(ICDODataService.class).toProvider(
				service(ICDODataService.class).single());

		bind(IClientCDODataProvider.class).toProvider(
				service(IClientCDODataProvider.class).single());

	}
}
