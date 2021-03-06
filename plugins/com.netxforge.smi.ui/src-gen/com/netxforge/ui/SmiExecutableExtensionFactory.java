/*
 * generated by Xtext
 */
package com.netxforge.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import com.netxforge.ui.internal.SmiActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class SmiExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return SmiActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return SmiActivator.getInstance().getInjector(SmiActivator.COM_NETXFORGE_SMI);
	}
	
}
