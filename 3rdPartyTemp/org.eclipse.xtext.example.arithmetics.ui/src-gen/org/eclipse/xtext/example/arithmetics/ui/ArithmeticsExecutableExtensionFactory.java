/*
 * generated by Xtext
 */
package org.eclipse.xtext.example.arithmetics.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ArithmeticsExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.eclipse.xtext.example.arithmetics.ui.internal.ArithmeticsActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.eclipse.xtext.example.arithmetics.ui.internal.ArithmeticsActivator.getInstance().getInjector("org.eclipse.xtext.example.arithmetics.Arithmetics");
	}
	
}
