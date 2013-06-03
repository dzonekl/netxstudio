/*******************************************************************************
 * Copyright (c) 18 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.models.importer.ui.internal;

import static com.google.inject.util.Modules.override;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.cdo.NonStaticCDODataServiceModule;
import com.netxforge.netxstudio.screens.editing.EditingServiceModule;

/**
 * The activator class controls the plug-in life cycle
 */
public class ImportUIActivator extends AbstractUIPlugin implements
		DebugOptionsListener {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.models.import.ui"; //$NON-NLS-1$

	// The shared instance
	private static ImportUIActivator plugin;

	private Injector injector;

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	public static final String TRACE_IMPORT_OPTION = "/trace.manual.import.ui";

	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", true);
		TRACE = options.newDebugTrace(PLUGIN_ID);
	}

	public Injector getInjector() {
		return injector;
	}

	/**
	 * The constructor
	 */
	public ImportUIActivator() {
	}

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

		// Bind our modules.
		Module om = new CommonModule();
		om = override(om).with(new EditingServiceModule());
		om = override(om).with(NonStaticCDODataServiceModule.getModule());
		// om = override(om).with(new CDODataServiceModule());
		injector = Guice.createInjector(om);

		Dictionary<String, String> props = new Hashtable<String, String>(4);
		props.put(DebugOptions.LISTENER_SYMBOLICNAME, PLUGIN_ID);
		context.registerService(DebugOptionsListener.class.getName(), this,
				props);
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
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ImportUIActivator getDefault() {
		return plugin;
	}
}
