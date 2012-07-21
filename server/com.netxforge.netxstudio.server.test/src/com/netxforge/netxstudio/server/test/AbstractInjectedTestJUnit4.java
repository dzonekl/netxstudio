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
package com.netxforge.netxstudio.server.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.server.test.base.TestModule;

/**
 * Gives access to a Guice injector.
 */
public abstract class AbstractInjectedTestJUnit4 {

	private Injector injector;
	protected ModelUtils modelUtils;

	public AbstractInjectedTestJUnit4() {
		injector = createInjector();
		modelUtils = injector.getInstance(ModelUtils.class);
	}

	protected Injector createInjector() {
		return Guice.createInjector(TestModule.getModule());
	}

	public Injector getInjector() {
		if (injector == null)
			throw new IllegalStateException("No injector set.");
		return injector;
	}

}
