/*******************************************************************************
 * Copyright (c) 5 mrt. 2013 NetXForge.
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
package com.netxforge.netxstudio.client.product.internal;

import static org.ops4j.peaberry.Peaberry.service;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.client.product.ProductWorkbenchAdvisor;
import com.netxforge.netxstudio.client.product.ProductWorkbenchService;
import com.netxforge.netxstudio.client.product.ProductWorkbenchWindowAdvisor;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.data.cdo.IClientCDODataProvider;
import com.netxforge.netxstudio.screens.activities.IActivityAndRoleService;
import com.netxforge.netxstudio.screens.app.IWorkbenchService;
import com.netxforge.netxstudio.screens.app.IWorkbenchWindowLifecycle;

/**
 * Module for this plugin.
 * 
 * @author Christophe Bouhier
 * 
 */
public class ProductModule extends AbstractModule {

	@Override
	protected void configure() {

		// /////////////////////////////////
		// INTERNAL SERVICES
		this.bind(ProductWorkbenchAdvisor.class);
		
		this.bind(IWorkbenchWindowLifecycle.class).to(ProductWorkbenchWindowAdvisor.class);

		// ////////////////////////////////
		// EXPORTED SERVICES
		// CB TODO, Currently rexported with OSGI Service. 
		this.bind(IWorkbenchService.class).to(ProductWorkbenchService.class);

		// ///////////////////////////////
		// IMPORT SERVICES
		// (Copy to modules in other OSGI bundles to import the service).

		// {@link CDODataServiceModule}
		bind(ICDODataService.class).toProvider(
				service(ICDODataService.class).single());
		

		// {@link CDODataServiceModule}
		bind(IClientCDODataProvider.class).toProvider(
				service(IClientCDODataProvider.class).single());

		// {@link ActivitiesModule}
		bind(IActivityAndRoleService.class).toProvider(
				service(IActivityAndRoleService.class).single());

	}

}
