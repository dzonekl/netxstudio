/*
 * generated by Xtext
 */
package com.netxforge;

import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.netxforge.interpreter.IInterpreter;
import com.netxforge.interpreter.IInterpreterContextFactory;
import com.netxforge.interpreter.INativeFunctions;
import com.netxforge.interpreter.IPrettyLog;
import com.netxforge.interpreter.InterpreterContextFactory;
import com.netxforge.interpreter.InterpreterTypeless;
import com.netxforge.interpreter.NativeFunctions;
import com.netxforge.interpreter.PrettyLog;
import com.netxforge.scoping.CDOResourceServiceProvider;
import com.netxforge.scoping.SimpleCDONameProvider;
import com.netxforge.scoping.SimpleCDOScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class NetxscriptRuntimeModule extends
		com.netxforge.AbstractNetxscriptRuntimeModule {

	@Override
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return SimpleCDOScopeProvider.class;
	}

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

	// @Provides
	// IInterpreter provideInterpreter(){
	// InterpreterTypeless interpreter = new InterpreterTypeless();
	// return interpreter;
	// }

}
