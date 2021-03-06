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
import static org.ops4j.peaberry.Peaberry.osgiModule;

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

public class RuntimeActivator implements BundleActivator, DebugOptionsListener {

	private static RuntimeActivator INSTANCE;
	private BundleContext context;
	private Map<String, Injector> injectors = new HashMap<String, Injector>();

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxscript"; //$NON-NLS-1$

	// Tracing for netxscript.
	public static String TRACE_NETXSCRIPT_OPTION = "/trace.netxscript";
	public static String TRACE_NETXSCRIPT_SCOPING_OPTION = "/trace.netxscript.scoping";
	public static String TRACE_NETXSCRIPT_EXPRESSION_OPTION = "/trace.netxscript.expression";
	public static String TRACE_NETXSCRIPT_DESCRIPTION_OPTION = "/trace.netxscript.description";

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

//	@Inject
//	Export<IExpressionEngine> expressionEngineService;

	public void start(BundleContext context) throws Exception {
		INSTANCE = this;
		this.context = context;

		// We do Guice binding for the runtime module, within this plugin.
		// (xtext, normally provides all Guice binding in the UI plugin, but we
		// won't have
		// it on the server side).
		try {
			registerInjectorFor(context, "com.netxforge.Netxscript");
//			getInjector("com.netxforge.Netxscript").injectMembers(this);
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

	protected void registerInjectorFor(BundleContext ctx, String language)
			throws Exception {

		Module om = new ScriptImportModule();
		om = override(om).with(new ScriptExportModule());
		om = override(om).with(getRuntimeModule(language));

		injectors.put(language, createInjector(osgiModule(ctx), om));

	}

	protected Module getRuntimeModule(String grammar) {
		if ("com.netxforge.Netxscript".equals(grammar)) {
			return new com.netxforge.internal.NetxscriptRuntimeModule();
		}

		throw new IllegalArgumentException(grammar);
	}

}
