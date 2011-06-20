package com.netxforge.netxstudio.screens.internal;

import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.netxforge.netxstudio.common.guice.AbstractGuiceAwareExecutableExtensionFactory;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ScreensEExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ScreensActivator.getDefault().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ScreensActivator.getDefault().getInjector();
	}
	
}
