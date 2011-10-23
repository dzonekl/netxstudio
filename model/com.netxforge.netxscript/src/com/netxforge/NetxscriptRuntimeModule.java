/*
 * generated by Xtext
 */
package com.netxforge;

import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import com.google.inject.Scopes;
import com.netxforge.interpreter.IInterpreter;
import com.netxforge.interpreter.IInterpreterContextFactory;
import com.netxforge.interpreter.INativeFunctions;
import com.netxforge.interpreter.IPrettyLog;
import com.netxforge.interpreter.InterpreterContextFactory;
import com.netxforge.interpreter.InterpreterTypeless;
import com.netxforge.interpreter.NativeFunctions;
import com.netxforge.interpreter.PrettyLog;
import com.netxforge.scoping.CDOResourceServiceProvider;
import com.netxforge.scoping.FixedSetCDOResourceDescriptions;
import com.netxforge.scoping.FixedSetCDOScopeProvider;
import com.netxforge.scoping.SimpleCDONameProvider;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class NetxscriptRuntimeModule extends
		com.netxforge.AbstractNetxscriptRuntimeModule {


	public Class<? extends IResourceServiceProvider> bindIResourceServiceProvider() {
		return CDOResourceServiceProvider.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SimpleCDONameProvider.class;
	}

	public Class<? extends INativeFunctions> bindMathFunctions() {
		return NativeFunctions.class;
	}

	public Class<? extends IPrettyLog> bindPrettyLog() {
		return PrettyLog.class;
	}

	public Class<? extends IInterpreterContextFactory> bindInterpreterContextFactory() {
		return (Class<? extends IInterpreterContextFactory>) InterpreterContextFactory.class;
	}

	public Class<? extends IInterpreter> bindInterpreter() {
		return InterpreterTypeless.class;
	}

	// Override generated, ResourceSet based.
	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).to(
				FixedSetCDOResourceDescriptions.class).in(Scopes.SINGLETON);
	}

	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return null;
	}
	
	public void configureIGlobalScopeProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IGlobalScopeProvider.class).to(
				FixedSetCDOScopeProvider.class).in(Scopes.SINGLETON);
	}

}
