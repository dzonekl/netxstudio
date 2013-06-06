package com.netxforge.netxstudio.server.logic.netxscript;

import com.google.inject.Scopes;
import com.netxforge.internal.NetxscriptRuntimeModule;

public class NetxscriptServerModule extends NetxscriptRuntimeModule {

	// Override generated, ResourceSet based.
	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).to(
				DynamixServerCDOResourceDescriptions.class).in(Scopes.SINGLETON);
	}
}
