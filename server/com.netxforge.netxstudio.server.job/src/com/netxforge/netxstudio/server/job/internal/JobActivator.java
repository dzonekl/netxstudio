package com.netxforge.netxstudio.server.job.internal;

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
import com.netxforge.netxstudio.server.ServerModule;
import com.netxforge.netxstudio.server.job.JobHandler;
import com.netxforge.netxstudio.server.job.JobService;

public class JobActivator implements BundleActivator, DebugOptionsListener {

	private static BundleContext context;
	private static JobActivator INSTANCE;

	private static final String PLUGIN_ID = "com.netxforge.netxstudio.server.job";
	
	static BundleContext getContext() {
		return context;
	}

	public static JobActivator getInstance() {
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
		JobActivator.context = bundleContext;
		INSTANCE = this;
			
		// register our import service.
		bundleContext.registerService(JobService.class, new JobService(), new Hashtable<String, String>());
		
		Dictionary<String, String> props = new Hashtable<String,String>(4);
		props.put(DebugOptions.LISTENER_SYMBOLICNAME, PLUGIN_ID);
	 	context.registerService(DebugOptionsListener.class.getName(), this, props);
	}

	public void createInjector() {
		Module om = ServerModule.getModule();
		om = override(om).with(new JobModule());
		injector = Guice.createInjector(om);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		JobActivator.context = null;
		JobHandler.deActivate();
	}

	public Injector getInjector() {
		return injector;
	}

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", true);
		TRACE = options.newDebugTrace(PLUGIN_ID);
	}

}
