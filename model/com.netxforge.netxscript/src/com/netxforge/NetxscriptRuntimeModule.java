/*
 * generated by Xtext
 */
package com.netxforge;

import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import com.google.inject.Scopes;
import com.netxforge.engine.ExpressionEngine;
import com.netxforge.engine.IExpressionEngine;
import com.netxforge.interpreter.IInterpreter;
import com.netxforge.interpreter.IInterpreterContextFactory;
import com.netxforge.interpreter.INativeFunctions;
import com.netxforge.interpreter.IPrettyLog;
import com.netxforge.interpreter.InterpreterContextFactory;
import com.netxforge.interpreter.InterpreterTypeless;
import com.netxforge.interpreter.NativeFunctions;
import com.netxforge.interpreter.PrettyLog;
import com.netxforge.scoping.CDOResourceServiceProvider;
import com.netxforge.scoping.DynamixCDONameProvider;
import com.netxforge.scoping.DynamixCDOResourceDescriptions;
import com.netxforge.scoping.DynamixCDOScopeProvider;
import com.netxforge.scoping.QualifiedDynamixCDONameProvider;

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
		return DynamixCDONameProvider.class;
	}

	// contributed by
	// org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIQualifiedNameProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.naming.IQualifiedNameProvider.class)
				.annotatedWith(
						com.google.inject.name.Names
								.named(com.netxforge.scoping.QualifiedDynamixCDONameProvider.NAMED_QUALIFIED_DYNAMIX_CDO_NAME_PROVIDER))
				.to(QualifiedDynamixCDONameProvider.class);
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

	public Class<? extends IExpressionEngine> bindExpressionEngine() {
		return (Class<? extends IExpressionEngine>) ExpressionEngine.class;
	}

	// Override generated, ResourceSet based.
	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class)
				.to(DynamixCDOResourceDescriptions.class).in(Scopes.SINGLETON);
	}

	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return null;
	}

	public void configureIGlobalScopeProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IGlobalScopeProvider.class)
				.to(DynamixCDOScopeProvider.class).in(Scopes.SINGLETON);
	}

}
