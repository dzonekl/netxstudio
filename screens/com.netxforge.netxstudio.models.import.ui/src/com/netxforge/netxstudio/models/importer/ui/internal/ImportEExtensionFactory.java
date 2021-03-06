package com.netxforge.netxstudio.models.importer.ui.internal;

import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.netxforge.base.di.AbstractGuiceAwareExecutableExtensionFactory;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ImportEExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ImportUIActivator.getDefault().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ImportUIActivator.getDefault().getInjector();
	}
	
}
