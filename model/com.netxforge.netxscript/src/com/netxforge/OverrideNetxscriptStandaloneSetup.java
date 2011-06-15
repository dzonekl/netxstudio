
package com.netxforge;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;

import static com.google.inject.util.Modules.override;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;

/**
 * Generated from StandaloneSetup.xpt!
 */
@SuppressWarnings("all")
public class OverrideNetxscriptStandaloneSetup implements ISetup {

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	
	/**
	 * Modified to inject additional modules, also in stand-alone mode. 
	 * @return
	 */
	
	public Injector createInjector() {
		
		Module om = new com.netxforge.NetxscriptRuntimeModule();
		om = override(om).with(new CDODataServiceModule());
		return Guice.createInjector(om);
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://www.netxforge.com/Netxscript")) {
		EPackage.Registry.INSTANCE.put("http://www.netxforge.com/Netxscript", com.netxforge.netxscript.NetxscriptPackage.eINSTANCE);
	}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("netxscript", resourceFactory);
		
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("netxscript", serviceProvider);
		//  NetXStudio: Add a registration for the CDO protocol. 
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getProtocolToFactoryMap().put("cdo", serviceProvider);


	}
}
