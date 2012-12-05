/*******************************************************************************
 * Copyright (c) 3 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.editing;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;

/**
 * Constructs an Injected IScreen, based on name.
 * 
 * @author Christophe Bouhier
 * 
 */
public class ScreenFactory implements IScreenFactory {
	/*
	 * A Map holding the screen constructors by name of the screen.
	 */
	private HashMap<String, Constructor<?>> screenMap = Maps.newHashMap();

	// Additional providers for other services passed on here, for the factory
	// create method.

	@Inject
	public ScreenFactory() {
	}

	public IScreen create(String screenName, Class<?> screenClass,
			Composite parent, int style) {

		Constructor<?> screenConstructor = screenMap.get(screenName);
		if (screenConstructor == null) {
			registerScreen(screenName, screenClass);
			screenConstructor = screenMap.get(screenName);
		}
		return getScreen(screenConstructor, parent, style);
	}

	/**
	 * @param screenName
	 * @param screenClass
	 * @param screenConstructor
	 * @return
	 */
	public void registerScreen(String screenName,
			Class<?> screenClass) {
		try {
			Constructor<?> screenConstructor = screenClass.getConstructor(Composite.class,
					int.class);
			put(screenName, screenConstructor);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}


	private void put(String screenName, Constructor<?> screenConstructor) {
		screenMap.put(screenName, screenConstructor);
	}

	private IScreen getScreen(Constructor<?> screenConstructor,
			Composite parent, int style) {
		IScreen target;
		try {
			target = (IScreen) screenConstructor.newInstance(parent, SWT.NONE);
			return target;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
