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
package com.netxforge.netxmib.product.internal;

import java.util.Properties;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxmib.product.PropertiesUtil;
import com.netxforge.netxstudio.screens.app.IWorkbenchService;

import static org.ops4j.peaberry.Peaberry.osgiModule;

/**
 * The activator class controls the plug-in life cycle
 */
public class ProductActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxmib.product"; //$NON-NLS-1$

	// The shared instance
	private static ProductActivator plugin;

	/**
	 * The constructor
	 */
	public ProductActivator() {
	}

	private static final String propertiesFile = "netxstudio.properties";

	public static final String NETXSTUDIO_SERVER = "netxstudio.server";
	public static final String NETXSTUDIO_LASTUSER = "netxstudio.lastuser";
	public static final String NETXSTUDIO_WORKSPACE = "netxstudio.workspace";

	// public static String serverValue="";
	// public static String lastuserValue="";
	// public static String workspaceValue="";

	private final PropertiesUtil pu = new PropertiesUtil();

	private Properties properties;

	private ServiceRegistration<IWorkbenchService> workbenchService;

	private Injector injector;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// The EcorePlugin Activator tries to open the workspace, but the
		// workspace
		// is only set when the application inisitalized, if the plugin is
		// self-starting
		// this will thrown an exception that the data area is not set.

		// System.getProperties()
		// .setProperty(
		// "org.eclipse.emf.ecore.plugin.EcorePlugin.doNotLoadResourcesPlugin",
		// "false");

		// As we auto start this plugin, and EMF requires a workspace, in it'c
		// core
		// plugin.
		pu.readProperties(this.getBundle(), propertiesFile, getProperties());

		injector = Guice.createInjector(osgiModule(context),
				new ProductModule());

		// TODO, Export with Peaberry.

		final IWorkbenchService instance = injector
				.getInstance(IWorkbenchService.class);

		// Register our product workbench service to customize the application
		// at startup.
		workbenchService = context.registerService(IWorkbenchService.class,
				instance, null);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		pu.writeProperties(this.getBundle(), propertiesFile,
				this.getProperties());

		workbenchService.unregister();

		// FIXME, Platform already stopped, as Application has lower startlevel!
		// super.stop(context);

	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ProductActivator getDefault() {
		return plugin;
	}

	public Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
		}
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Injector getInjector() {
		return injector;
	}

}
