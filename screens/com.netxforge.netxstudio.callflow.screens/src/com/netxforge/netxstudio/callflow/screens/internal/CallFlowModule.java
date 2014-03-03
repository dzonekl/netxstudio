package com.netxforge.netxstudio.callflow.screens.internal;

import static org.ops4j.peaberry.Peaberry.service;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.netxforge.netxstudio.common.guice.IInjectorProxy;
import com.netxforge.netxstudio.screens.editing.IEditingServiceProvider;
import com.netxforge.netxstudio.screens.editing.IScreenFormServiceProvider;

public class CallFlowModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(IInjectorProxy.class).annotatedWith(Names.named("Screens"))
				.to(ScreensInjectorProxy.class);

		// {@link EditingModule}
		bind(IEditingServiceProvider.class).toProvider(
				service(IEditingServiceProvider.class).single());

		// {@link EditingModule}
		bind(IScreenFormServiceProvider.class).toProvider(
				service(IScreenFormServiceProvider.class).single());
	}

}
