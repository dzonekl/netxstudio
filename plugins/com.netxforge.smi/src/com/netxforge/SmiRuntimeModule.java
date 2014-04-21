/*
 * generated by Xtext
 */
package com.netxforge;

import com.netxforge.converters.SMIValueConverters;
import com.netxforge.scoping.SMIGlobalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class SmiRuntimeModule extends com.netxforge.AbstractSmiRuntimeModule {

	/**
	 * Bind to a converter which can process large numeric values.
	 */
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return SMIValueConverters.class;
	}

	/**
	 * This Global Scope provider appends an extension to the 'importURI'
	 * attribute.
	 */
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return SMIGlobalScopeProvider.class;
	}
}
