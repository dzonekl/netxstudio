package com.netxforge.netxstudio.models.importer.ui.internal;

import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.netxforge.netxstudio.common.guice.AbstractGuiceAwareExecutableExtensionFactory;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ImportEExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ImportActivator.getDefault().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ImportActivator.getDefault().getInjector();
	}
	
}
