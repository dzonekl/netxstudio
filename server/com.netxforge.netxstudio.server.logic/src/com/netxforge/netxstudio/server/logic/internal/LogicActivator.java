package com.netxforge.netxstudio.server.logic.internal;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.importer.ImporterModule;
import com.netxforge.netxstudio.scheduling.NodeReporterJob;
import com.netxforge.netxstudio.scheduling.NodeTypeReporterJob;
import com.netxforge.netxstudio.scheduling.OperatorReporterJob;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.RetentionJob;
import com.netxforge.netxstudio.server.ServerModule;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.job.JobImplementation.JobImplementationFactory;
import com.netxforge.netxstudio.server.job.internal.JobModule;
import com.netxforge.netxstudio.server.logic.monitoring.MonitoringService;
import com.netxforge.netxstudio.server.logic.monitoring.RFSServiceMonitoringJobImplementation;
import com.netxforge.netxstudio.server.logic.netxscript.NetxscriptServerModule;
import com.netxforge.netxstudio.server.logic.reporting.NodeReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.OperatorReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.ReportingService;
import com.netxforge.netxstudio.server.logic.retention.RetentionJobImplementation;
import com.netxforge.netxstudio.server.logic.retention.RetentionService;

public class LogicActivator implements BundleActivator, DebugOptionsListener {

	private static BundleContext context;
	private static final String PLUGIN_ID = "com.netxforge.netxstudio.server.logic";
	private static LogicActivator INSTANCE;

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;
	
	// Tracing options for monitoring logic
	public static String TRACE_LOGIC_OPTION = "/trace.logic";
	public static String TRACE_LOGIC_DETAILS_OPTION = "/trace.logic.details";
	
	// Tracing options for reporting logic. 
	public static String TRACE_REPORT_OPTION = "/trace.report";
	public static String TRACE_REPORT_DETAILS_OPTION = "/trace.report.details";
	
	// Tracing options for subscriber profile logic. 
	public static String TRACE_PROFILE_OPTION = "/trace.profile";
	public static String TRACE_PROFILE_DETAILS_OPTION = "/trace.profile.details";
	
	// Tracing options for value retention logic. 
	public static String TRACE_RETENTION_OPTION = "/trace.retention";
	public static String TRACE_RETENTION_DETAILS_OPTION = "/trace.retention.details";
	
	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", false);
		TRACE = options.newDebugTrace(PLUGIN_ID);
	}

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

		JobImplementation.REGISTRY.register(RFSServiceMonitoringJob.class,
				new JobImplementationFactory() {
					@Override
					public JobImplementation create() {
						return injector
								.getInstance(RFSServiceMonitoringJobImplementation.class);
					}
				});

		JobImplementation.REGISTRY.register(RFSServiceReporterJob.class,
				new JobImplementationFactory() {
					@Override
					public JobImplementation create() {
						return injector
								.getInstance(RFSServiceReportingJobImplementation.class);
					}
				});

		JobImplementation.REGISTRY.register(NodeReporterJob.class,
				new JobImplementationFactory() {
					@Override
					public JobImplementation create() {
						return injector
								.getInstance(NodeReportingJobImplementation.class);
					}
				});

		JobImplementation.REGISTRY.register(NodeTypeReporterJob.class,
				new JobImplementationFactory() {
					@Override
					public JobImplementation create() {
						return injector
								.getInstance(OperatorReportingJobImplementation.class);
					}
				});

		JobImplementation.REGISTRY.register(OperatorReporterJob.class,
				new JobImplementationFactory() {
					@Override
					public JobImplementation create() {
						return injector
								.getInstance(OperatorReportingJobImplementation.class);
					}
				});

		JobImplementation.REGISTRY.register(RetentionJob.class,
				new JobImplementationFactory() {
					@Override
					public JobImplementation create() {
						return injector
								.getInstance(RetentionJobImplementation.class);
					}
				});

		Module om = override(new NetxscriptServerModule()).with(
				ServerModule.getModule());
		om = override(om).with(new ImporterModule());
		om = override(om).with(new JobModule());
		om = override(om).with(new LogicModule());
		om = override(om).with(new CommonModule());
		injector = createInjector(om);

		bundleContext.registerService(MonitoringService.class,
				new MonitoringService(), new Hashtable<String, String>());
		bundleContext.registerService(RetentionService.class,
				new RetentionService(), new Hashtable<String, String>());
		bundleContext.registerService(ReportingService.class,
				new ReportingService(), new Hashtable<String, String>());
		
		Dictionary<String, String> props = new Hashtable<String,String>(4);
		props.put(DebugOptions.LISTENER_SYMBOLICNAME, PLUGIN_ID);
	 	context.registerService(DebugOptionsListener.class.getName(), this, props);
		
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
