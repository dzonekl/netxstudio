/*******************************************************************************
 * Copyright (c) 5 mrt. 2013 NetXForge.
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
package com.netxforge.netxstudio.common.internal;

import static org.ops4j.peaberry.Peaberry.osgiModule;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.ops4j.peaberry.Export;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.netxforge.netxstudio.common.model.ComponentSummaryProvider;
import com.netxforge.netxstudio.common.model.IChartModel;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.NetxresourceSummaryProvider;
import com.netxforge.netxstudio.common.model.NodetypeSummaryProvider;
import com.netxforge.netxstudio.common.model.OperatorSummaryProvider;
import com.netxforge.netxstudio.common.model.RFSServiceSummaryProvider;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public class CommonActivator implements BundleActivator, DebugOptionsListener {

	private static final String PLUGIN_ID = "com.netxforge.netxstudio.common";

	private static BundleContext context;
	private static CommonActivator INSTANCE;

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	private Injector injector;

	public static String TRACE_COMMON_UTILS_OPTION = "/trace.common.utils";

	public static String TRACE_COMMON_PROPS_OPTION = "/trace.common.properties";

	// Monitoring.
	public static String TRACE_COMMON_MONITORING_OPTION = "/trace.common.monitoring";

	// Charts.
	public static String TRACE_COMMON_CHART_OPTION = "/trace.common.chart";
	
	public static String TRACE_COMMON_MONITORING_DETAILS_OPTION = "/trace.common.monitoring.details";

	public Injector getInjector() {
		return injector;
	}

	static BundleContext getContext() {
		return context;
	}

	@Inject
	Export<ModelUtils> modelUtils;

	@Inject
	Export<MonitoringStateModel> monitoringStateModel;

	@Inject
	Export<NetxresourceSummaryProvider> netXSummaryProvider;

	@Inject
	Export<ComponentSummaryProvider> compSummaryProvider;

	@Inject
	Export<NodetypeSummaryProvider> nodeTypeSummaryProvider;

	@Inject
	Export<RFSServiceSummaryProvider> rFSServiceSummaryProvider;

	@Inject
	Export<OperatorSummaryProvider> operatorSummaryProvider;

	@Inject
	Export<IChartModel> chartModel;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		INSTANCE = this;
		CommonActivator.context = bundleContext;

		injector = Guice.createInjector(osgiModule(bundleContext),
				new CommonModule());
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
		CommonActivator.context = null;
	}

	public static CommonActivator getInstance() {
		return INSTANCE;
	}

	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", false);
		TRACE = options.newDebugTrace(PLUGIN_ID);
	}
}
