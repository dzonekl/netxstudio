package com.netxforge.netxstudio.screens.editing.internal;

import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.netxforge.base.di.AbstractGuiceAwareExecutableExtensionFactory;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class EditingEExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return EditingActivator.getDefault().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return EditingActivator.getDefault().getInjector();
	}
	
}
