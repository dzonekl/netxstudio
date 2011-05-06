
package com.netxforge;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class NetxscriptStandaloneSetup extends NetxscriptStandaloneSetupGenerated{

	public static void doSetup() {
		new NetxscriptStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

