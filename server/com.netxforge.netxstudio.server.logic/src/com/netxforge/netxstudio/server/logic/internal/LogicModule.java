package com.netxforge.netxstudio.server.logic.internal;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.server.logic.monitoring.MonitoringEngine;
import com.netxforge.netxstudio.server.logic.monitoring.MonitoringService.ResourceMonitoringRunner;
import com.netxforge.netxstudio.server.logic.monitoring.NodeMonitoringLogic;
import com.netxforge.netxstudio.server.logic.monitoring.RFSServiceMonitoringJobImplementation;
import com.netxforge.netxstudio.server.logic.monitoring.RFSServiceMonitoringLogic;
import com.netxforge.netxstudio.server.logic.profile.ProfileEngine;
import com.netxforge.netxstudio.server.logic.reporting.NodeReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.NodeResourceReportingLogic;
import com.netxforge.netxstudio.server.logic.reporting.OperatorReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceDashboardReportingLogic;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceDistributionReportingLogic;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceSummaryReportingLogic;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceUserReportingLogic;
import com.netxforge.netxstudio.server.logic.retention.RetentionEngine;
import com.netxforge.netxstudio.server.logic.retention.RetentionLogic;

public class LogicModule extends AbstractModule {

	// Bind our expression engine. 
	@Override
	protected void configure() {
//		this.bind(IExpressionEngine.class).to(ExpressionEngine.class);
		
		this.bind(RFSServiceMonitoringLogic.class);
		this.bind(RFSServiceMonitoringJobImplementation.class);
		
		this.bind(OperatorReportingJobImplementation.class);
		this.bind(RFSServiceSummaryReportingLogic.class);
		this.bind(RFSServiceDashboardReportingLogic.class);
		this.bind(RFSServiceDistributionReportingLogic.class);
		this.bind(RFSServiceUserReportingLogic.class);
		this.bind(NodeResourceReportingLogic.class);
		
		this.bind(RFSServiceReportingJobImplementation.class);
		this.bind(NodeReportingJobImplementation.class);
		
		this.bind(MonitoringEngine.class);
		this.bind(ProfileEngine.class);
		this.bind(NodeMonitoringLogic.class);
		this.bind(ResourceMonitoringRunner.class);
		this.bind(RetentionEngine.class);
		this.bind(RetentionLogic.class);
	}

}
