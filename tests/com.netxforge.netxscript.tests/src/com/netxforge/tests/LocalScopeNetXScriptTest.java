/*******************************************************************************
 * Copyright (c) 8 apr. 2014 NetXForge.
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
package com.netxforge.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxstudio.data.ICDODataService;

/**
 * @author Christophe Bouhier
 */
public class LocalScopeNetXScriptTest extends AbstractNetXScriptTest {

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
				.getMod("this.FUNCTION System -> RESOURCE STP_ORIGMSUS CAP;");

		final IScope scope = scopeProvider.getScope(model,
				NetxscriptPackage.Literals.RESOURCE_REF__RESOURCE);

		for (IEObjectDescription ieod : scope.getAllElements()) {
			System.out.println(ieod.getQualifiedName());
		}

	}
}
