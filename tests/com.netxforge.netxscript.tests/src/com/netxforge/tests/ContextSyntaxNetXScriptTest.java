/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;

import org.eclipse.xtext.junit.AbstractXtextTests;

import com.netxforge.NetxscriptStandaloneSetup;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.operators.Node;

/**
 * FIXME, Should target test repository.
 * 
 * 
 * From xText Documentation on Linking ==================================== the
 * LazyLinker (src) first creates an EMF proxy and assigns it to the
 * corresponding EReference. In EMF a proxy is described by a URI, which points
 * to the real EObject. In the case of lazy linking the stored URI comprises of
 * the context information given at parse time, which is the EObject containing
 * the cross-reference, the actual EReference, the index (in case it's a
 * multi-valued cross-reference) and the string which represented the crosslink
 * in the concrete syntax. The latter usually corresponds to the name of the
 * referenced EObject. In EMF a URI consists of information about the resource
 * the EObject is contained in as well as a so called fragment part, which is
 * used to find the EObject within that resource. When an EMF proxy is resolved,
 * the current ResourceSet is asked. The resource set uses the first part to
 * obtain (i.e. load if it is not already loaded) the resource. Then the
 * resource is asked to return the EObject based on the fragment in the URI. The
 * actual cross-reference resolution is done by
 * LazyLinkingResource.getEObject(String) (src) which receives the fragment and
 * delegates to the implementation of the ILinkingService (src). The default
 * implementation in turn delegates to the scoping API.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class ContextSyntaxNetXScriptTest extends AbstractXtextTests {

	ICDODataService dataService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new NetxscriptStandaloneSetup());

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
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public void testContext() throws Exception {

		Node node = TestModel.INSTANCE
				.createModelData(dataService.getCDOData());

		// Resource context expressions.
		{

			Mod m = (Mod) this.getModel("this METRIC 60;");
		}

		// An expression which assigns a range of values to a var.
		// An expression which performs native function calls on a range.
		// The range arithmetics.
		{
			Mod m = (Mod) this.getModel("var a = [1,2,3,4].sum();a;");
		}
		// CONTEXTUAL REFERENCES
		{
			Mod m = (Mod) this
					.getModel("var a = this.FUNCTION SGSN->RESOURCE RES1  METRIC AVG 60;a;");
			// values.

		}
		// An expression which reads values from a resource, and writes them
		// to
		// another resource.

		{
			Mod m = (Mod) this
					.getModel("this.FUNCTION SGSN->RESOURCE RES2 UTILIZATION AVG 60 = this.FUNCTION SGSN->RESOURCE RES1 METRIC AVG 60;");

		}

		// An expression which reads values from a resource and does an
		// indirect
		// write to another resource.
		{
			// context.
			Mod m = (Mod) this
					.getModel("var a = this.FUNCTION SGSN->RESOURCE RES1 METRIC AVG 60;this.FUNCTION SGSN->RESOURCE RES2 UTILIZATION AVG 60 = a;");

		}
		// An expression which writes a single value to a Capacity range.
		{
			Mod m = (Mod) this
					.getModel("this.FUNCTION SGSN->RESOURCE RES1 CAP 60 = 30 * 60;");
		}

		// An expression which reads capacity values from a resource,
		{
			Mod m = (Mod) this
					.getModel("var a = this.FUNCTION SGSN->RESOURCE RES1 CAP 60;");
		}

		// An expression which reads values from a resource, performs an
		// operation on each of the values and writes the result
		// to another resource. .

		{
			Mod m = (Mod) this
					.getModel("var a = this.FUNCTION SGSN->RESOURCE RES1 METRIC AVG 60; var i = 0; var c = []; while( i < a.count()){ c += a[i];  i+=1;} this.FUNCTION SGSN->RESOURCE RES2 UTILIZATION AVG 60 = c;");

		}
		// An expression which reads values from a resource, performs an
		// operation on each of the values and writes the result
		// to another range from that resource.
		// Notice how an empty temp range, transports the range type (Value)
		// to
		// the expression result. (Cool typeless system).
		{

			Mod m = (Mod) this
					.getModel("var metric = this.FUNCTION SGSN->RESOURCE RES1 METRIC AVG 60; var i = 0; var temp = []; while( i < metric.count()){ temp += metric[i] ;  i+=1;} this.FUNCTION SGSN->RESOURCE RES2 UTILIZATION AVG 60 = temp;");
		}

		// An expression which takes a model object and applies a native
		// expression.
		{
			Mod m = (Mod) this
					.getModel("var a = this.EQUIPMENT BOARD.count();");
		}

		// Absolute reference expressions. (Non-contextual).
		{
			Mod m = (Mod) this
					.getModel("var a = NODE.EQUIPMENT BOARD.count();");
		}
	}

}
