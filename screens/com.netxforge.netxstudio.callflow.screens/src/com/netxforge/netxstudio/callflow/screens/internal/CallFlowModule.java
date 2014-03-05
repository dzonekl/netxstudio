/*******************************************************************************
 * Copyright (c) 3 mrt. 2014 NetXForge.
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
package com.netxforge.netxstudio.callflow.screens.internal;

import static org.ops4j.peaberry.Peaberry.service;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.netxforge.base.di.IInjectorProxy;
import com.netxforge.screens.editing.base.IEditingServiceProvider;
import com.netxforge.screens.editing.base.IScreenFormServiceProvider;

public class CallFlowModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(IInjectorProxy.class).annotatedWith(Names.named("Screens"))
				.to(ScreensInjectorProxy.class);

		// {@link EditingModule}
		bind(IEditingServiceProvider.class).toProvider(
				service(IEditingServiceProvider.class).single());

		// {@link EditingModule}
		bind(IScreenFormServiceProvider.class).toProvider(
				service(IScreenFormServiceProvider.class).single());
	}

}
