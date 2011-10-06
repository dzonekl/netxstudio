package com.netxforge.netxstudio.server.logic;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.scheduling.NodeReporterJob;
import com.netxforge.netxstudio.scheduling.OperatorReporterJob;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.RFSServiceRetentionJob;
import com.netxforge.netxstudio.server.ServerModule;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.job.JobImplementation.JobImplementationFactory;
import com.netxforge.netxstudio.server.job.JobModule;
import com.netxforge.netxstudio.server.logic.monitoring.MonitoringService;
import com.netxforge.netxstudio.server.logic.monitoring.RFSServiceMonitoringJobImplementation;
import com.netxforge.netxstudio.server.logic.netxscript.NetxscriptServerModule;
import com.netxforge.netxstudio.server.logic.reporting.NodeReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.OperatorReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.ReportingService;
import com.netxforge.netxstudio.server.logic.retention.RetentionJobImplementation;
import com.netxforge.netxstudio.server.logic.retention.RetentionService;

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
		
		JobImplementation.REGISTRY.register(RFSServiceMonitoringJob.class, new JobImplementationFactory() {
			@Override
			public JobImplementation create() {
				return injector.getInstance(RFSServiceMonitoringJobImplementation.class);
			}
		});
		
		JobImplementation.REGISTRY.register(RFSServiceReporterJob.class, new JobImplementationFactory() {
			@Override
			public JobImplementation create() {
				return injector.getInstance(RFSServiceReportingJobImplementation.class);
			}
		});
		
		JobImplementation.REGISTRY.register(NodeReporterJob.class, new JobImplementationFactory() {
			@Override
			public JobImplementation create() {
				return injector.getInstance(NodeReportingJobImplementation.class);
			}
		});
		
		JobImplementation.REGISTRY.register(OperatorReporterJob.class, new JobImplementationFactory() {
			@Override
			public JobImplementation create() {
				return injector.getInstance(OperatorReportingJobImplementation.class);
			}
		});
		
		JobImplementation.REGISTRY.register(RFSServiceRetentionJob.class, new JobImplementationFactory() {
			@Override
			public JobImplementation create() {
				return injector.getInstance(RetentionJobImplementation.class);
			}
		});
		
		
		

		Module om = override(new NetxscriptServerModule()).with(ServerModule.getModule());
		om = override(om).with(new JobModule());
		om = override(om).with(new LogicModule());
		om = override(om).with(new CommonModule());
		injector = createInjector(om);

		bundleContext.registerService(MonitoringService.class, new MonitoringService(), new Hashtable<String, String>());
		bundleContext.registerService(RetentionService.class, new RetentionService(), new Hashtable<String, String>());
		bundleContext.registerService(ReportingService.class, new ReportingService(), new Hashtable<String, String>());
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
