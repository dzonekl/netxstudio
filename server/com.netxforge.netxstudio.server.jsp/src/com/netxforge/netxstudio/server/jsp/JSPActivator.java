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
package com.netxforge.netxstudio.server.jsp;

import static com.google.inject.Guice.createInjector;
import static org.ops4j.peaberry.Peaberry.osgiModule;
import static org.ops4j.peaberry.Peaberry.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.netxforge.netxstudio.server.data.IServerDataProvider;
import com.netxforge.netxstudio.server.data.Server;

public class JSPActivator implements BundleActivator {

	private Injector injector;

	private static JSPActivator INSTANCE;

	public static final String CONTEXT_PATH = "/remote";

	public static JSPActivator getInstance() {
		return INSTANCE;
	}

	public void start(BundleContext context) throws Exception {
		INSTANCE = this;

		injector = createInjector(osgiModule(context), new AbstractModule() {

			@Override
			protected void configure() {

				// {@link ServerModule}
				bind(IServerDataProvider.class).annotatedWith(Server.class).toProvider(
						service(IServerDataProvider.class).single());

			}

		});

		injector.injectMembers(INSTANCE);

	}

	public Injector getInjector() {
		return injector;
	}

	public void stop(BundleContext context) throws Exception {
	}
}
