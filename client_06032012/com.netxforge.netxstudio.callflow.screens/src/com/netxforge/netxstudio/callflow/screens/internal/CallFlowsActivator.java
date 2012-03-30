package com.netxforge.netxstudio.callflow.screens.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.screens.common.internal.ScreensCommonActivator;

/**
 * The activator class controls the plug-in life cycle
 */
public class CallFlowsActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.client.callflow.screens"; //$NON-NLS-1$

	// The shared instance
	private static CallFlowsActivator plugin;

	private Injector callFlowsInjector;
	
	/**
	 * The constructor
	 */
	public CallFlowsActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		Module om = new ScreensModule();
		callFlowsInjector = ScreensCommonActivator.getDefault().getInjector().createChildInjector(om);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	public static CallFlowsActivator getDefault() {
		return plugin;
	}
	
	public Injector getInjector() {
		return callFlowsInjector;
	}

}
