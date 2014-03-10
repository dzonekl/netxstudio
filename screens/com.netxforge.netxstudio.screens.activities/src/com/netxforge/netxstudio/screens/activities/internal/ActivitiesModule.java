/*******************************************************************************
 * Copyright (c) 9 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.activities.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.screens.activities.ActivityAndRoleService;
import com.netxforge.netxstudio.screens.activities.IActivityAndRoleService;

public class ActivitiesModule extends AbstractModule {

	@Override
	protected void configure() {
		// ///////////////////////////////
		// EXPORT SERVICES
		bind(export(IActivityAndRoleService.class)).toProvider(
				service(new ActivityAndRoleService()).export());
		
		// ////////////////////////////////
		// IMPORT SERVICES
		bind(ICDODataService.class).toProvider(service(ICDODataService.class).single());
		
	}
}
