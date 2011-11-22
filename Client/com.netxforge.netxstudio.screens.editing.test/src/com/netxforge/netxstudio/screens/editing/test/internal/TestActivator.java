package com.netxforge.netxstudio.screens.editing.test.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class TestActivator implements BundleActivator {

	private static BundleContext context;
	private static TestActivator plugin;
	
		
	static BundleContext getContext() {
		return context;
	}
	
	public static TestActivator getDefault() {
		return plugin;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		TestActivator.context = bundleContext;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		TestActivator.context = null;
	}

}
