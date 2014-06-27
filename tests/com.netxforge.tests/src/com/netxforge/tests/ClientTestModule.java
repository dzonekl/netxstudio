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
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.data.cdo.CDODataConnection;
import com.netxforge.netxstudio.data.cdo.CDODataService;
import com.netxforge.netxstudio.data.cdo.ClientCDODataProvider;
import com.netxforge.netxstudio.data.cdo.ICDOConnection;
import com.netxforge.netxstudio.data.cdo.IClientCDODataProvider;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentLocator;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IndexComponentLocator;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class ClientTestModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MonitoringStateModel.class);

		bind(ICDOConnection.class).to(CDODataConnection.class);
		bind(IClientCDODataProvider.class).to(ClientCDODataProvider.class);
		bind(ICDODataService.class).to(CDODataService.class);

		bind(IComponentMappingIndex.class).to(ComponentMappingIndex.class);
		bind(IComponentLocator.class).to(IndexComponentLocator.class);
	}

}
