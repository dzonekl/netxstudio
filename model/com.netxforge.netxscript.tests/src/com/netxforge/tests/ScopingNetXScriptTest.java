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
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;

/**
 * FIXME, Should target test repository.
 * 
 * @author dzonekl
 * 
 */
public class ScopingNetXScriptTest extends AbstractNetXScriptTest {

	IDataService dataService;
	IGlobalScopeProvider globalScopeProvider;
	IResourceDescription.Manager resourceDescriptionManager;

	Resource targetResource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		// Inject whatever we need.
		dataService = get(IDataService.class);
		resourceDescriptionManager = get(IResourceDescription.Manager.class);
		globalScopeProvider = get(IGlobalScopeProvider.class);

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

		Resource resource = this
				.getResourceFromString("mod test\ndef main(){var a = 0;}");

		IQualifiedNameConverter converter = this.getInjector().getInstance(
				IQualifiedNameConverter.class);

		IResourceDescription description = resourceDescriptionManager
				.getResourceDescription(resource);
		for (IEObjectDescription eod : description.getExportedObjects()) {
			System.out.println(converter.toString(eod.getQualifiedName()));
		}

	}

	public void testLocalScope() throws Exception {

		IScopeProvider scopeProvider = this.getInjector().getInstance(
				IScopeProvider.class);
		IQualifiedNameConverter converter = this.getInjector().getInstance(
				IQualifiedNameConverter.class);

		Mod model = this.getMod("def main(){var a = 0;}");

		IScope scope = scopeProvider.getScope(model,
				NetxscriptPackage.Literals.VAR_OR_ARGUMENT_CALL__CALL);
		assertNotNull(scope);

		Iterable<IEObjectDescription> candidates = scope.getAllElements();
		for (IEObjectDescription candidate : candidates) {
			// For this scope, we should only expect.
			if (!(candidate instanceof AliasedEObjectDescription)) {
				System.out.println(converter.toString(candidate
						.getQualifiedName()));
			}
		}

	}

	public void testCDOScope() throws Exception {

		// Add some objects, which are referable from our xtext model.
		Resource res = dataService.getProvider().getResource(
				LibraryPackage.Literals.LIBRARY);
		Library lib = (Library) res.getContents().get(0);

		NodeType sgsnType = LibraryFactory.eINSTANCE.createNodeType();
		Function sgsnFunction = LibraryFactory.eINSTANCE.createFunction();
		sgsnFunction.setFunctionName("SGSN");
		sgsnType.getFunctions().add(sgsnFunction);
		lib.getNodeTypes().add(sgsnType);

		res.save(null);

		// Now invoke the scope provider to find the added reference.
		IScopeProvider scopeProvider = this.getInjector().getInstance(
				IScopeProvider.class);
		IQualifiedNameConverter converter = this.getInjector().getInstance(
				IQualifiedNameConverter.class);

		Mod model = this.getMod("def main(){var a = 0;}");

		IScope scope = scopeProvider.getScope(model,
				NetxscriptPackage.Literals.NODE_REF__NODE);
		assertNotNull(scope);

		Iterable<IEObjectDescription> candidates = scope.getAllElements();
		for (IEObjectDescription candidate : candidates) {
			// For this scope, we should only expect.
			if (!(candidate instanceof AliasedEObjectDescription)) {
				System.out.println(converter.toString(candidate
						.getQualifiedName()));
			}
		}
	}

}
