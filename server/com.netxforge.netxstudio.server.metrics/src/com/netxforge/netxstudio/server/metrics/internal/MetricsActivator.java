package com.netxforge.netxstudio.server.metrics.internal;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.server.ServerModule;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.job.JobImplementation.JobImplementationFactory;
import com.netxforge.netxstudio.server.job.JobModule;
import com.netxforge.netxstudio.server.metrics.MetricSourceImportService;
import com.netxforge.netxstudio.server.metrics.MetricSourceJobImplementation;

public class MetricsActivator implements BundleActivator {

	private static BundleContext context;
	private static MetricsActivator INSTANCE;

	static BundleContext getContext() {
		return context;
	}

	public static MetricsActivator getInstance() {
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
		INSTANCE = this;
		MetricsActivator.context = bundleContext;

		Module om = new MetricsModule();
//		om = Modules.override(om).with(new MetricsModule());
		om = Modules.override(om).with(ServerModule.getModule());
		om = Modules.override(om).with(new JobModule());
		injector = Guice.createInjector(om);

		bundleContext.registerService(MetricSourceImportService.class, new MetricSourceImportService(), new Hashtable<String, String>());

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
	public void stop(BundleContext bundleContext) throws Exception {
		MetricsActivator.context = null;
	}

	public Injector getInjector() {
		return injector;
	}
}
