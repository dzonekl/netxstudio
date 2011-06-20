package com.netxforge.netxstudio.server.job;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.server.ServerModule;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private static Activator INSTANCE;
	
	static BundleContext getContext() {
		return context;
	}

	public static Activator getInstance() {
		return INSTANCE;
	}
	
	private Injector injector;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		INSTANCE = this;

	}

	void createInjector() {
		injector = Guice.createInjector(ServerModule.getModule());
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		JobHandler.deActivate();
	}

	public Injector getInjector() {
		return injector;
	}

}
