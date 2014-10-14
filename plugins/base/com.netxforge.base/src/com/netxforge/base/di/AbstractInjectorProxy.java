/*******************************************************************************
 * Copyright (c) 7 okt. 2014 NetXForge.
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
package com.netxforge.base.di;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Christophe Bouhier
 */
public abstract class AbstractInjectorProxy implements IInjectorProxy {

	
	private Injector injector;

	public AbstractInjectorProxy() {
		injector = Guice.createInjector(getModule());
	}

	protected abstract Module getModule();
	
	/**
	 * Ignore the name for now...
	 */
	public Injector getInjector(String name) {
		return injector;
	}
	
	public Injector getInjector() {
		return injector;
	}

}
