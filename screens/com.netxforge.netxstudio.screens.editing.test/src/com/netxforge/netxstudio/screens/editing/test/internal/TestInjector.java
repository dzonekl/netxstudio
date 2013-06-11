package com.netxforge.netxstudio.screens.editing.test.internal;

import static com.google.inject.util.Modules.override;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.internal.CommonModule;
import com.netxforge.netxstudio.screens.editing.CDOEditingService;
import com.netxforge.netxstudio.screens.editing.IEditingService;

public class TestInjector {

	private Injector injector;

	public Injector getInjector() {
		return injector;
	}
	
	public TestInjector() {
		// Bind our modules.
		Module om = new CommonModule();
		om = override(om).with(new EditingServiceModule());
		injector = Guice.createInjector(om);
	}
	
	class EditingServiceModule extends AbstractModule{
		@Override
		protected void configure() {
			this.bind(IEditingService.class).to(CDOEditingService.class);
		}
	}
	
}
