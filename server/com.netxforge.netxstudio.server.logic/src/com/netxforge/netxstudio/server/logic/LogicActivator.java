package com.netxforge.netxstudio.server.logic;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.NetxscriptRuntimeModule;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.scheduling.RFSServiceJob;
import com.netxforge.netxstudio.server.ServerModule;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.job.JobImplementation.JobImplementationFactory;

public class LogicActivator implements BundleActivator {

	private static BundleContext context;

	private static LogicActivator INSTANCE;

	static BundleContext getContext() {
		return context;
	}

	public static LogicActivator getInstance() {
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
		LogicActivator.context = bundleContext;
		
		JobImplementation.REGISTRY.register(RFSServiceJob.class, new JobImplementationFactory() {
			@Override
			public JobImplementation create() {
				return injector.getInstance(RFSServiceJobImplementation.class);
			}
		});

		Module om = override(new NetxscriptRuntimeModule()).with(ServerModule.getModule());
		om = override(om).with(new LogicModule());
		om = override(om).with(new CommonModule());
		injector = createInjector(om);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		LogicActivator.context = null;
	}

	public Injector getInjector() {
		return injector;
	}
}
