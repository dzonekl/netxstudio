/*******************************************************************************
 * Copyright (c) Jun 14, 2011 NetXForge.
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
package com.netxforge.internal;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;

public class RuntimeActivator implements BundleActivator, DebugOptionsListener {

	private static RuntimeActivator INSTANCE;
	private BundleContext context;
	private Map<String, Injector> injectors = new HashMap<String, Injector>();

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxscript"; //$NON-NLS-1$

	// Tracing for netxscript.
	public static String TRACE_NETXSCRIPT_OPTION = "/trace.netxscript";
	public static String TRACE_NETXSCRIPT_SCOPING_OPTION = "/trace.netxscript.scoping";

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	public void start(BundleContext context) throws Exception {
		INSTANCE = this;
		this.context = context;

		// We do Guice binding for the runtime module, within this plugin.
		// (xtext, normally provides all Guice binding in the UI plugin, but we
		// won't have
		// it on the server side).
		try {
			registerInjectorFor("com.netxforge.Netxscript");
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}

		Dictionary<String, String> props = new Hashtable<String, String>(4);
		props.put(DebugOptions.LISTENER_SYMBOLICNAME, PLUGIN_ID);
		context.registerService(DebugOptionsListener.class.getName(), this,
				props);

	}

	public void stop(BundleContext context) throws Exception {

	}

	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", false);
		TRACE = options.newDebugTrace(PLUGIN_ID);
	}

	public static RuntimeActivator getInstance() {
		return INSTANCE;
	}

	public Bundle getBundle() {
		return context.getBundle();
	}

	public Injector getInjector(String languageName) {
		return injectors.get(languageName);
	}

	protected void registerInjectorFor(String language) throws Exception {

		Module om = getRuntimeModule(language);
		// om = override(om).with(getSharedStateModule());
		// om = override(om).with(getUiModule(language));
		om = override(om).with(this.getDataProviderModule());
		om = override(om).with(new CommonModule());
		// ... add next module here.
		injectors.put(language, createInjector(om));

	}

	protected Module getRuntimeModule(String grammar) {
		if ("com.netxforge.Netxscript".equals(grammar)) {
			return new com.netxforge.NetxscriptRuntimeModule();
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getDataProviderModule() {
		return new CDODataServiceModule();
	}

}
