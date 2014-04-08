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
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxstudio.data.ICDODataService;

/**
 * FIXME, Should target test repository.
 * 
 * @author Christophe Bouhier
 * 
 */
public class GlobalScopeProviderNetXScriptTest extends AbstractNetXScriptTest {

	ICDODataService dataService;
	IResourceDescription.Manager resourceDescriptionManager;

	Resource targetResource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// Inject whatever we need.
		dataService = get(ICDODataService.class);
		dataService.getCDOData().openSession("admin", "admin");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		dataService.getCDOData().closeSession();
	}

	/**
	 * Visual inspection, all object descriptions from the current resource. the
	 * resource is created from a simple NetXScript.
	 * 
	 * @throws Exception
	 */
	public void testScopingContext() throws Exception {

		// Now invoke the scope provider to find the added reference.
		final IScopeProvider scopeProvider = this.getInjector().getInstance(
				IScopeProvider.class);

		final Mod model = this
				.getMod("this.FUNCTION System -> RESOURCE STP_ORIGMSUS;");

		final IScope scope = scopeProvider.getScope(model,
				NetxscriptPackage.Literals.RESOURCE_REF__RESOURCE);

		for (IEObjectDescription ieo : scope.getAllElements()) {
			System.out.println(ieo);
		}
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

		final IQualifiedNameConverter converter = this.getInjector()
				.getInstance(IQualifiedNameConverter.class);

		resourceDescriptionManager = get(IResourceDescription.Manager.class);

		final IResourceDescription description = resourceDescriptionManager
				.getResourceDescription(resource);
		for (final IEObjectDescription eod : description.getExportedObjects()) {
			System.out.println(converter.toString(eod.getQualifiedName()));
		}

	}

}
