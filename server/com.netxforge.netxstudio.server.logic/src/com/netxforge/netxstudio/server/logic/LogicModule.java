package com.netxforge.netxstudio.server.logic;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.server.logic.ResourceMonitoringService.ResourceMonitoringRunner;
import com.netxforge.netxstudio.server.logic.expression.ExpressionEngine;
import com.netxforge.netxstudio.server.logic.expression.IExpressionEngine;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceDashboardReportingLogic;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceDistributionReportingLogic;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceReportingJobImplementation;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceSummaryReportingLogic;
import com.netxforge.netxstudio.server.logic.reporting.RFSServiceUserReportingLogic;

public class LogicModule extends AbstractModule {

	// Bind our expression engine. 
	@Override
	protected void configure() {
		this.bind(IExpressionEngine.class).to(ExpressionEngine.class);
		
		this.bind(RFSServiceResourceMonitoringLogic.class);
		this.bind(RFSServiceResourceMonitoringJobImplementation.class);

		this.bind(RFSServiceSummaryReportingLogic.class);
		this.bind(RFSServiceDashboardReportingLogic.class);
		this.bind(RFSServiceDistributionReportingLogic.class);
		this.bind(RFSServiceUserReportingLogic.class);
		
		this.bind(RFSServiceReportingJobImplementation.class);
		
		this.bind(ResourceMonitoringEngine.class);
		this.bind(NodeResourceMonitoringLogic.class);
		this.bind(ResourceMonitoringRunner.class);
		this.bind(RetentionEngine.class);
		this.bind(RetentionLogic.class);
	}

}
