/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxstudio.data.IDataService;

/**
 * FIXME, Should target test repository.
 * 
 * @author Christophe Bouhier
 * 
 */
public class LocalScopeNetXScriptTest extends AbstractNetXScriptTest {

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
	public void testScopingContext() throws Exception {

		// Now invoke the scope provider to find the added reference.
		final IScopeProvider scopeProvider = this.getInjector().getInstance(
				IScopeProvider.class);

		final Mod model = this
				.getMod("this.FUNCTION System -> RESOURCE STP_ORIGMSUS CAP;");

		final IScope scope = scopeProvider.getScope(model,
				NetxscriptPackage.Literals.RESOURCE_REF__RESOURCE);
		
		for(IEObjectDescription ieod : scope.getAllElements()){
			System.out.println(ieod.getQualifiedName());
		}
		
	}
}
