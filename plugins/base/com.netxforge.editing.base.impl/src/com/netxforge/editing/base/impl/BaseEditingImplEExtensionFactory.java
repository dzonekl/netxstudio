package com.netxforge.editing.base.impl;

import org.eclipse.core.runtime.IExecutableExtensionFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.base.di.AbstractAdvancedExecutableExtensionFactory;
import com.netxforge.editing.base.impl.internal.BaseEditingImplActivator;

/**
 * Exported {@link IExecutableExtensionFactory}. Classes instantiated by this extension factory 
 * will be injected by {@link Guice}.
 *  
 */
public class BaseEditingImplEExtensionFactory extends AbstractAdvancedExecutableExtensionFactory {

	@Override
	protected Injector getInjector() {
		return BaseEditingImplActivator.getDefault().getInjector();
	}
	
}
