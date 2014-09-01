/*******************************************************************************
 * Copyright (c) 17 mrt. 2014 NetXForge.
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
package com.netxforge.editing.base.impl.internal;

import static org.ops4j.peaberry.Peaberry.osgiModule;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.ops4j.peaberry.Export;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.netxforge.screens.editing.base.IEditingServiceProvider;
import com.netxforge.screens.editing.base.IScreenFormServiceProvider;

public class BaseEditingImplActivator extends AbstractUIPlugin implements
		DebugOptionsListener {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.editing.base.impl"; //$NON-NLS-1$

	private static BundleContext context;

	private Injector injector;

	public static String TRACE_EDITING_OPTION = "/trace.editing";

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	private static BaseEditingImplActivator plugin;

	public Injector getInjector() {
		return injector;
	}

	public void optionsChanged(DebugOptions options) {
		// create an .options file!
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", false);
		TRACE = options.newDebugTrace(PLUGIN_ID);
	}

	static BundleContext getContext() {
		return context;
	}

	 @Inject
	 Export<IEditingServiceProvider> editingServiceProvider;

	 @Inject
	 Export<IScreenFormServiceProvider> screenFormServiceProvider;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		BaseEditingImplActivator.context = bundleContext;

		plugin = this;

		// Bind our modules.
		injector = Guice.createInjector(osgiModule(context),
				new BaseEditingImplModule());

		// Export through peaberry.
		 injector.injectMembers(this);

		Dictionary<String, String> props = new Hashtable<String, String>(4);
		props.put(DebugOptions.LISTENER_SYMBOLICNAME, PLUGIN_ID);
		context.registerService(DebugOptionsListener.class.getName(), this,
				props);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		BaseEditingImplActivator.context = null;
	}

	/**
	 * Return an instance of us, set when the OSGI module start.
	 * 
	 * @return
	 */
	public static BaseEditingImplActivator getDefault() {
		return plugin;
	}

}
