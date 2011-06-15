package com.netxforge;

import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.netxforge.internal.RuntimeActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class NetxscriptExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return RuntimeActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return RuntimeActivator.getInstance().getInjector("com.netxforge.Netxscript");
	}
	
}
