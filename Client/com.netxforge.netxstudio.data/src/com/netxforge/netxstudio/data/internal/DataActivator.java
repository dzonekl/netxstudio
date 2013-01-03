package com.netxforge.netxstudio.data.internal;

import static com.google.inject.util.Modules.override;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;
import com.netxforge.netxstudio.data.importer.ImporterModule;

public class DataActivator implements BundleActivator, DebugOptionsListener {

	private static final String PLUGIN_ID = "com.netxforge.netxstudio.data";
	
	private static BundleContext context;
	private static Injector injector;
	
	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;
	
	// Tracing for DataProvider
	public static String TRACE_DATA_OPTION = "/trace.data";
	public static String TRACE_DATA_DETAILS_OPTION = "/trace.data.details";
	
	// Tracing for importing. 
	public static final String TRACE_IMPORT_OPTION = "/trace.import";
	public static final String TRACE_IMPORT_DETAILS_OPTION = "/trace.import.details";
	public static final String TRACE_IMPORT_LOCATOR_OPTION = "/trace.import.locator";
	public static final String TRACE_IMPORT_HELPER_OPTION = "/trace.import.helper";
	
	// Tracing for various types of result processing. 
	
	public static final String TRACE_RESULT_VALUE_OPTION = "/trace.result.value";
	public static final String TRACE_RESULT_EXPRESSION_OPTION = "/trace.result.expression";
	public static final String TRACE_RESULT_TOL_OPTION = "/trace.result.tolerance";
	
	// Tracing for our component index service. 
	public static final String TRACE_COMPONENT_INDEX_OPTION = "/trace.component.index";
	
	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", false);
		TRACE = options.newDebugTrace(PLUGIN_ID);
	}
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		DataActivator.context = bundleContext;
		Module om = new CDODataServiceModule();
		om = override(om).with(new CommonModule());
		om = override(om).with(new ImporterModule());
		injector = Guice.createInjector(om);
		
		Dictionary<String, String> props = new Hashtable<String,String>(4);
		props.put(DebugOptions.LISTENER_SYMBOLICNAME, PLUGIN_ID);
	 	context.registerService(DebugOptionsListener.class.getName(), this, props);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		DataActivator.context = null;
	}

	public static Injector getInjector() {
		return injector;
	}
	

}
