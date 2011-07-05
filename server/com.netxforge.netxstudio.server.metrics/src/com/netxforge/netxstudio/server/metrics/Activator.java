package com.netxforge.netxstudio.server.metrics;

import java.util.Hashtable;

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
import com.netxforge.netxstudio.server.job.JobModule;
import com.netxforge.netxstudio.server.metrics.MetricSourceImportService.ServiceRunner;

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
	public void start(BundleContext bundleContext) throws Exception {
		INSTANCE = this;
		Activator.context = bundleContext;

		Module om = new MetricModule();
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
			this.bind(XLSMetricValuesImporter.class);
			this.bind(CSVMetricValuesImporter.class);
			this.bind(RDBMSMetricValuesImporter.class);
			this.bind(NetworkElementLocator.class);
			this.bind(ServiceRunner.class);
		}
	}
}
