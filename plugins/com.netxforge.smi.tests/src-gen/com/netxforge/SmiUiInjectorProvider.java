/*
* generated by Xtext
*/
package com.netxforge;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class SmiUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return com.netxforge.ui.internal.SmiActivator.getInstance().getInjector("com.netxforge.Smi");
	}
	
}