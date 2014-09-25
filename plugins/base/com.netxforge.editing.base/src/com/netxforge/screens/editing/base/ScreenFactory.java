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
package com.netxforge.screens.editing.base;

import static org.eclipse.core.runtime.ContributorFactoryOSGi.resolve;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.Bundle;

import com.google.common.collect.Maps;
import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Injector;

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
	private Injector injector;

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

		if (screenConstructor != null) {
			return instantiateByConstructor(screenConstructor, parent, style);
		} else {
			return null;
		}
	}

	public IScreen createByDeclaration(String screenName,
			String screenClassName, Composite parent, int style) {

		if (screenClassName != null) {
			return instantiateByDeclaration(screenClassName, parent, style);
		} else {
			return null;
		}
	}

	/**
	 * @param screenName
	 * @param screenClass
	 * @param screenConstructor
	 * @return
	 */
	public void registerScreen(String screenName, Class<?> screenClass) {

		if (screenClass == null) {

			// TODO, Logging function!
			System.out
					.println("trying to register a screen, while no type is provided, is "
							+ screenName
							+ " the wrong screen name for restore? ");
			return;
		}

		try {
			Constructor<?> screenConstructor = screenClass.getConstructor(
					Composite.class, int.class);
			put(screenName, screenConstructor);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	private void put(String screenName, Constructor<?> screenConstructor) {
		screenMap.put(screenName, screenConstructor);
	}

	private IScreen instantiateByConstructor(Constructor<?> screenConstructor,
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

	/**
	 * instantiate an {@link IScreen} matching a class name as declarared with
	 * extension:
	 * 
	 * <pre>
	 * com.netxforge.editing.iscreen
	 * </pre>
	 * 
	 * 
	 * @param screenClassName
	 * 
	 * @return
	 */
	private IScreen instantiateByDeclaration(String screenClassName,
			Composite parent, int style) {

		IScreen screen = null;

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry
				.getExtensionPoint("com.netxforge.editing.iscreen");
		if (point == null) {
			return screen;
		}
		IExtension[] extensions = point.getExtensions();

		ScreenFromExtention screenFromExtention = new ScreenFromExtention();
		screenFromExtention.setParent(parent);
		screenFromExtention.setStyle(style);
		screenFromExtention.setScreenName(screenClassName);
		for (int i = 0; i < extensions.length; i++) {
			screen = screenFromExtention.readExtension(extensions[i],
					screenClassName);
			if (screen != null) {
				break;
			}
		}
		return screen;

	}

	/**
	 * Read an {@link IScreen} from an IExtension.
	 */
	class ScreenFromExtention {

		private String screenName;

		public String getScreenName() {
			return screenName;
		}

		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}

		public Composite getParent() {
			return parent;
		}

		public void setParent(Composite parent) {
			this.parent = parent;
		}

		public int getStyle() {
			return style;
		}

		public void setStyle(int style) {
			this.style = style;
		}

		private Composite parent;
		private int style;

		public IScreen readExtension(IExtension iExtension,
				String targetScreenClassName) {

			IScreen screen = null;
			for (IConfigurationElement el : iExtension
					.getConfigurationElements()) {

				String screenClass = el.getAttribute("class");
				if (screenClass.equals(targetScreenClassName)) {
					try {
						IContributor contributor = el.getContributor();
						Bundle bundle = resolve(contributor);

						Class<?> loadClass = bundle
								.loadClass(targetScreenClassName);

						// Now we resolve the applicable constructor.
						registerScreen(getScreenName(), loadClass);

						// Create the IScreen.
						screen = create(getScreenName(), loadClass,
								getParent(), getStyle());

						// Inject the IScreen.
						((AbstractScreenImpl) screen).injectMembers(injector);

					} catch (ClassNotFoundException e) {
						// TODO Proper logging / Error handling.
						e.printStackTrace();
					} catch (ConfigurationException ce) {
						ce.printStackTrace();
					} finally {
						if (screen != null) {
							break;
						}
					}
				}
			}
			return screen;
		}
	}

	/**
	 * Set our global application injector.
	 */
	public void setInjector(Injector injector) {
		this.injector = injector;
	}

}
