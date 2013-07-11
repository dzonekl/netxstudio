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
package com.netxforge.tests;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.cdo.CDODataConnection;
import com.netxforge.netxstudio.data.cdo.CDODataService;
import com.netxforge.netxstudio.data.cdo.CDOQueryService;
import com.netxforge.netxstudio.data.cdo.CDOQueryUtil;
import com.netxforge.netxstudio.data.cdo.ClientCDODataProvider;
import com.netxforge.netxstudio.data.cdo.ICDOConnection;
import com.netxforge.netxstudio.data.importer.IComponentLocator;
import com.netxforge.netxstudio.data.importer.IndexComponentLocator;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class TestModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ModelUtils.class);
		bind(MonitoringStateModel.class);

		bind(CDOQueryUtil.class);
		bind(ICDOConnection.class).to(CDODataConnection.class);
		bind(IQueryService.class).to(CDOQueryService.class);
		bind(IDataProvider.class).to(ClientCDODataProvider.class);
		bind(IDataService.class).to(CDODataService.class);

		bind(IComponentMappingIndex.class).to(ComponentMappingIndex.class);
		bind(IComponentLocator.class).to(IndexComponentLocator.class);
	}

}
