/*
 * generated by Xtext
 */
package org.eclipse.xtext.ui.codetemplates.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class CodetemplatesExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.eclipse.xtext.ui.codetemplates.ui.internal.CodetemplatesActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.eclipse.xtext.ui.codetemplates.ui.internal.CodetemplatesActivator.getInstance().getInjector("org.eclipse.xtext.ui.codetemplates.Codetemplates");
	}
	
}
