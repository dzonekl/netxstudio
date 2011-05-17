package com.netxforge.netxstudio.screens.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ScreensActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.screens"; //$NON-NLS-1$

	// The shared instance
	private static ScreensActivator plugin;

//	private static Injector injector;
	
	/**
	 * The constructor
	 */
	public ScreensActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
//		injector = Guice.createInjector(new ScreenFormServiceModule());
//		injector.getInstance(IScreenFormService.class);
		
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
	public static ScreensActivator getDefault() {
		return plugin;
	}
	
//	public static Injector getInjector() {
//		return injector;
//	}
	
}
