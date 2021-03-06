/*******************************************************************************
 * Copyright (c) 24 mei 2013 NetXForge.
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
package com.netxforge.netxstudio.server.metrics.internal;

import static org.ops4j.peaberry.Peaberry.osgiModule;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.job.JobImplementation.JobImplementationFactory;
import com.netxforge.netxstudio.server.metrics.MetricSourceImportService;
import com.netxforge.netxstudio.server.metrics.MetricSourceJobImplementation;

public class MetricsActivator implements BundleActivator, DebugOptionsListener {

	private static BundleContext context;
	private static MetricsActivator INSTANCE;

	private static final String PLUGIN_ID = "com.netxforge.netxstudio.server.metrics";

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	// public tracing options.
	public static final String TRACE_IMPORT_OPTION = "/trace.import";

	// Inherit the trace settings from the data bundle.
	// The option for the helper is duplicate, perhaps it should not exist in the DataActivator?
	private static final String PLUGIN_ID_IMPORT = "com.netxforge.netxstudio.data";
	public static boolean DEBUG_IMPORT = false;
	public static DebugTrace TRACE_IMPORT = null;
	public static final String TRACE_IMPORT_HELPER_OPTION = "/trace.import.helper";

	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", false);
		TRACE = options.newDebugTrace(PLUGIN_ID);

		DEBUG_IMPORT = options.getBooleanOption(PLUGIN_ID_IMPORT + "/debug",
				false);
		TRACE_IMPORT = options.newDebugTrace(PLUGIN_ID_IMPORT);
	}

	public static BundleContext getContext() {
		return context;
	}

	public static MetricsActivator getInstance() {
		return INSTANCE;
	}

	private Injector injector;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		INSTANCE = this;
		MetricsActivator.context = bundleContext;

		injector = Guice.createInjector(osgiModule(context),
				new MetricsModule());

		// register our import service.
		bundleContext.registerService(MetricSourceImportService.class,
				new MetricSourceImportService(),
				new Hashtable<String, String>());

		// register our new MetricSourceJob creator
		JobImplementation.REGISTRY.register(MetricSourceJob.class,
				new JobImplementationFactory() {
					@Override
					public JobImplementation create() {
						return injector
								.getInstance(MetricSourceJobImplementation.class);
					}
				});

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
		MetricsActivator.context = null;
	}

	public Injector getInjector() {
		return injector;
	}
}
