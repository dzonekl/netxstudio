package com.netxforge.netxstudio.server.metrics;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.server.ServerModule;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.job.JobImplementation.JobImplementationFactory;

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
		INSTANCE = this;
		Activator.context = bundleContext;

		injector = Guice.createInjector(ServerModule.getModule());
		
		// register our new MetricSourceJob creator
		JobImplementation.REGISTRY.register(MetricSourceJob.class, new JobImplementationFactory() {
			@Override
			public JobImplementation create() {
				final MetricSourceJobImplementation jobImplementation = new MetricSourceJobImplementation();
				injector.injectMembers(jobImplementation);
				return jobImplementation;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	public Injector getInjector() {
		return injector;
	}

}
