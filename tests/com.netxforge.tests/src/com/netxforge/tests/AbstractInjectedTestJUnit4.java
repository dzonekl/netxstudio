/*******************************************************************************
 * Copyright (c) May 16, 2012 NetXForge.
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
package com.netxforge.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Gives access to multiple Guice injectors. Dude can choose between a client or
 * server injector. See {@link ClientTestModule} for the client injector and
 * {@link ServerTestModule} for the server DI bindings.
 * 
 */
public abstract class AbstractInjectedTestJUnit4 {

	private Injector injector;
	private Injector serverInjector;

	protected Injector createInjector() {
		return Guice.createInjector(new ClientTestModule());
	}

	protected Injector createServerInjector() {
		return Guice.createInjector(new ServerTestModule());
	}

	public Injector getClientInjector() {
		if (injector == null) {
			injector = createInjector();
		}
		return injector;
	}

	public Injector getServerInjector() {
		if (serverInjector == null) {
			serverInjector = createServerInjector();
		}
		return serverInjector;
	}
}
