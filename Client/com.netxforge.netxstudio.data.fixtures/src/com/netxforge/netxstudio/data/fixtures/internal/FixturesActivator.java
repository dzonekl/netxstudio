package com.netxforge.netxstudio.data.fixtures.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class FixturesActivator implements BundleActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.data.fixtures"; //$NON-NLS-1$

	// The shared instance
	private static FixturesActivator plugin;

	private Injector injector;
	
	/**
	 * The constructor
	 */
	public FixturesActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		plugin = this;
//		injector = Guice.createInjector(new FixturesModule());
	}

	public Injector getInjector() {
		return injector;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FixturesActivator getDefault() {
		return plugin;
	}
	
}
