package com.netxforge.netxstudio.client.product.internal;

import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.netxforge.base.di.AbstractGuiceAwareExecutableExtensionFactory;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ProductEExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ProductActivator.getDefault().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ProductActivator.getDefault().getInjector();
	}
	
}
