package com.netxforge.netxstudio.callflow.screens.internal;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.netxforge.netxstudio.common.guice.IInjectorProxy;

public class CallFlowModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(IInjectorProxy.class).annotatedWith(Names.named("Screens")).to(ScreensInjectorProxy.class);
	}

}
