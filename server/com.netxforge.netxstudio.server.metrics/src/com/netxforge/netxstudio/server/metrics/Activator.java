package com.netxforge.netxstudio.server.metrics;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
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
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		INSTANCE = this;
		Activator.context = bundleContext;

		Module om = new MetricModule();
		om = Modules.override(om).with(ServerModule.getModule());
		injector = Guice.createInjector(om);

		// register our new MetricSourceJob creator
		JobImplementation.REGISTRY.register(MetricSourceJob.class,
				new JobImplementationFactory() {
					@Override
					public JobImplementation create() {
						return injector
								.getInstance(MetricSourceJobImplementation.class);
					}
				});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	public Injector getInjector() {
		return injector;
	}

	public class MetricModule extends AbstractModule {

		// Bind our expression engine.
		@Override
		protected void configure() {
			this.bind(MetricSourceJobImplementation.class);
		}
	}
}
