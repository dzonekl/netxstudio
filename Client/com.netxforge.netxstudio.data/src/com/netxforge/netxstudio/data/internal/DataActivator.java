package com.netxforge.netxstudio.data.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.data.DataModule;

public class DataActivator implements BundleActivator {

	private static BundleContext context;
	private static Injector injector;
	
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		DataActivator.context = bundleContext;
		injector = Guice.createInjector(new DataModule());
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		DataActivator.context = null;
	}

	public static Injector getInjector() {
		return injector;
	}
	

}
