package com.netxforge.netxstudio.server.logic;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.server.logic.expression.ExpressionEngine;
import com.netxforge.netxstudio.server.logic.expression.IExpressionEngine;

public class LogicModule extends AbstractModule {

	// Bind our expression engine. 
	@Override
	protected void configure() {
		this.bind(IExpressionEngine.class).to(ExpressionEngine.class);
		this.bind(RFSServiceCapacityLogic.class);
		this.bind(RFSServiceJobImplementation.class);
		this.bind(CapacityLogicEngine.class);
	}

}
