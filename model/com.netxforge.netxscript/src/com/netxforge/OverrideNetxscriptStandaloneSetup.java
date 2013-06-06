/*******************************************************************************
 * Copyright (c) 6 jun. 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

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
		
		Module om = new com.netxforge.internal.NetxscriptRuntimeModule();
		// TODO Require a BundleContext to inject from other modules, with peaberry 
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
