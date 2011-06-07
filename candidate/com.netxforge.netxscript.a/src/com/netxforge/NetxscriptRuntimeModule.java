/*
 * generated by Xtext
 */
package com.netxforge;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.generic.GenericResourceDescriptionManager;

import com.google.inject.Binder;
import com.netxforge.interpreter.INativeFunctions;
import com.netxforge.interpreter.NativeFunctions;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class NetxscriptRuntimeModule extends com.netxforge.AbstractNetxscriptRuntimeModule {
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}
	
//	public Class<? extends IEncodingProvider> bindIEncodingProvider() {
//		return XMLEncodingProvider.class;
//	}
	
	public Class<? extends IResourceDescription.Manager> bindIResourceDescription$Manager() {
		return GenericResourceDescriptionManager.class;
	}
	
	
	public Class<? extends INativeFunctions> bindMathFunctions(){
		return NativeFunctions.class;
	}
	
}
