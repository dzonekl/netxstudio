package com.netxforge.netxstudio.common.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.common.CommonModule;

public class CommonActivator implements BundleActivator {

	private static BundleContext context;
	private static CommonActivator INSTANCE;
	
	private Injector injector;
	
	public Injector getInjector() {
		return injector;
	}

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		INSTANCE = this;
		CommonActivator.context = bundleContext;
		injector = Guice.createInjector(new CommonModule());
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		CommonActivator.context = null;
	}
	
	public static CommonActivator getInstance(){
		return INSTANCE;
	}
	

}
