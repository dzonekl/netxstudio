package com.netxforge.netxstudio.server.metrics;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.job.JobImplementation.JobImplementationFactory;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		// register our new MetricSourceJob creator
		JobImplementation.REGISTRY.register(MetricSourceJob.class, new JobImplementationFactory() {
			@Override
			public JobImplementation create() {
				return new MetricSourceJobImplementation();
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

}
