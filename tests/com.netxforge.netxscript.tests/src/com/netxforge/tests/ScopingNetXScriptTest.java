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
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;

/**
 * @author Christophe Bouhier
 * 
 */
public class ScopingNetXScriptTest extends AbstractNetXScriptTest {

	ICDODataService dataService;
	IGlobalScopeProvider globalScopeProvider;
	IResourceDescription.Manager resourceDescriptionManager;

	Resource targetResource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// Inject whatever we need.
		dataService = get(ICDODataService.class);
		resourceDescriptionManager = get(IResourceDescription.Manager.class);
		globalScopeProvider = get(IGlobalScopeProvider.class);

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
	public void testDescriptions() throws Exception {

		final Resource resource = this
				.getResourceFromString("mod test\ndef main(){var a = 0;}");

		final IQualifiedNameConverter converter = this.getInjector()
				.getInstance(IQualifiedNameConverter.class);

		final IResourceDescription description = resourceDescriptionManager
				.getResourceDescription(resource);
		for (final IEObjectDescription eod : description.getExportedObjects()) {
			System.out.println(converter.toString(eod.getQualifiedName()));
		}

	}

	public void testLocalScope() throws Exception {

		final IScopeProvider scopeProvider = this.getInjector().getInstance(
				IScopeProvider.class);
		final IQualifiedNameConverter converter = this.getInjector()
				.getInstance(IQualifiedNameConverter.class);

		final Mod model = this.getMod("def main(){var a = 0;}");

		final IScope scope = scopeProvider.getScope(model,
				NetxscriptPackage.Literals.VAR_OR_ARGUMENT_CALL__CALL);
		assertNotNull(scope);

		final Iterable<IEObjectDescription> candidates = scope.getAllElements();
		for (final IEObjectDescription candidate : candidates) {
			// For this scope, we should only expect.
			if (!(candidate instanceof AliasedEObjectDescription)) {
				System.out.println(converter.toString(candidate
						.getQualifiedName()));
			}
		}

	}

	public void testCDOScope() throws Exception {

		// Add some objects, which are referable from our xtext model.
		final Resource res = dataService.getCDOData().getResource(
				LibraryPackage.Literals.LIBRARY);
		final Library lib = (Library) res.getContents().get(0);

		final NodeType sgsnType = LibraryFactory.eINSTANCE.createNodeType();
		final Function sgsnFunction = LibraryFactory.eINSTANCE.createFunction();
		sgsnFunction.setName("SGSN");
		sgsnType.getFunctions().add(sgsnFunction);
		lib.getNodeTypes().add(sgsnType);

		res.save(null);

		// Now invoke the scope provider to find the added reference.
		final IScopeProvider scopeProvider = this.getInjector().getInstance(
				IScopeProvider.class);
		final IQualifiedNameConverter converter = this.getInjector()
				.getInstance(IQualifiedNameConverter.class);

		final Mod model = this.getMod("def main(){var a = 0;}");

		final IScope scope = scopeProvider.getScope(model,
				NetxscriptPackage.Literals.NAVIGATION__FUNCTION);
		assertNotNull(scope);

		final Iterable<IEObjectDescription> candidates = scope.getAllElements();
		for (final IEObjectDescription candidate : candidates) {
			// For this scope, we should only expect.
			if (!(candidate instanceof AliasedEObjectDescription)) {
				System.out.println(converter.toString(candidate
						.getQualifiedName()));
			}
		}
	}

}
