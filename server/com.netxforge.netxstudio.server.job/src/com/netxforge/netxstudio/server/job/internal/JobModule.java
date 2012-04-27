package com.netxforge.netxstudio.server.job.internal;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;

public class JobModule extends AbstractModule {

	// Bind our expression engine. 
	@Override
	protected void configure() {
//		this.bind(WorkFlowRunMonitor.class);
		this.bind(IRunMonitor.class).to(ServerWorkFlowRunMonitor.class);
	}

}
