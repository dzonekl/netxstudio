/*******************************************************************************
 * Copyright (c) 13 jun. 2013 NetXForge.
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
package com.netxforge.ui.internal.override;

import static org.ops4j.peaberry.Peaberry.service;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.common.math.INativeFunctions2;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.cdo.IClientDataProvider;

public class ScriptUIImportModule extends AbstractModule {

	@Override
	protected void configure() {

		// ///////////////////////////////
		// IMPORT SERVICES

		bind(ModelUtils.class).toProvider(service(ModelUtils.class).single());
		
		// CommonModule
		bind(INativeFunctions2.class).toProvider(
				service(INativeFunctions2.class).single());
		
		bind(IClientDataProvider.class).toProvider(
				service(IClientDataProvider.class).single());

		bind(IQueryService.class).toProvider(
				service(IQueryService.class).single());

	}

}
