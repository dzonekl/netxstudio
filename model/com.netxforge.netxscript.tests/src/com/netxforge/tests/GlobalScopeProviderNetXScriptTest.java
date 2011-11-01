/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import com.netxforge.netxstudio.data.IDataService;

/**
 * FIXME, Should target test repository.
 * 
 * @author dzonekl
 * 
 */
public class GlobalScopeProviderNetXScriptTest extends AbstractNetXScriptTest {

	IDataService dataService;
	IResourceDescription.Manager resourceDescriptionManager;

	Resource targetResource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		// Inject whatever we need.
		dataService = get(IDataService.class);
		dataService.getProvider().openSession("admin", "admin");
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		dataService.getProvider().closeSession();
	}




	/**
	 * Visual inspection, all object descriptions from the current resource. the
	 * resource is created from a simple NetXScript.
	 * 
	 * @throws Exception
	 */
	public void testDescriptions() throws Exception {

		final Resource resource = this
				.getResourceFromString("this.FUNCTION Sigtran;");

		final IQualifiedNameConverter converter = this.getInjector().getInstance(
				IQualifiedNameConverter.class);
		
		resourceDescriptionManager = get(IResourceDescription.Manager.class);
		
		final IResourceDescription description = resourceDescriptionManager
				.getResourceDescription(resource);
		for (final IEObjectDescription eod : description.getExportedObjects()) {
			System.out.println(converter.toString(eod.getQualifiedName()));
		}

	}


}