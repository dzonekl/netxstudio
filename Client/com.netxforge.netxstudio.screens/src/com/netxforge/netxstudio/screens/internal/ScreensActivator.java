/*******************************************************************************
 * Copyright (c) Oct 29, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.internal;

import static com.google.inject.util.Modules.override;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;
import com.netxforge.netxstudio.screens.editing.EditingServiceModule;

/**
 * The activator class controls the plug-in life cycle
 */
public class ScreensActivator extends AbstractUIPlugin implements
		DebugOptionsListener {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.screens"; //$NON-NLS-1$

	// The shared instance
	private static ScreensActivator plugin;

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	// Tracing options for monitoring logic
	public static String TRACE_SCREENS_OPTION = "/trace.screens";
	public static String TRACE_SCREENS_BINDING_OPTION = "/trace.screens.binding";

	private Injector injector;

	public Injector getInjector() {
		return injector;
	}

	/**
	 * The constructor
	 */
	public ScreensActivator() {
	}
	
	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", false);
		TRACE = options.newDebugTrace(PLUGIN_ID);
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
		Module om = new ScreensModule();
		om = override(om).with(new CommonModule());
		om = override(om).with(new CDODataServiceModule());
		om = override(om).with(new EditingServiceModule());
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
	public static ScreensActivator getDefault() {
		return plugin;
	}

	public static IPreferenceStore doGetPreferenceStore() {
		return getDefault().getPreferenceStore();
	}

	
}
