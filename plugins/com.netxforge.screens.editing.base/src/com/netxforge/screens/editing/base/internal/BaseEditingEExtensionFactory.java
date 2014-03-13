package com.netxforge.screens.editing.base.internal;

import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.netxforge.base.di.AbstractGuiceAwareExecutableExtensionFactory;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class BaseEditingEExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return BaseEditingActivator.getDefault().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return BaseEditingActivator.getDefault().getInjector();
	}
	
}
