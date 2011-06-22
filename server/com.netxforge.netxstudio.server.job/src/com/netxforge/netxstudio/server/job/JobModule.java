package com.netxforge.netxstudio.server.job;

import com.google.inject.AbstractModule;

public class JobModule extends AbstractModule {

	// Bind our expression engine. 
	@Override
	protected void configure() {
		this.bind(WorkFlowRunMonitor.class);
	}

}
