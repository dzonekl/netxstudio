/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;

import java.io.IOException;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;

import com.google.common.collect.ImmutableList;
import com.netxforge.NetxscriptStandaloneSetup;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;

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
 * @author dzonekl
 * 
 */
public class ContextSyntaxNetXScriptTest extends AbstractXtextTests {

	IDataService dataService;
	ModelUtils modelUtils;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new NetxscriptStandaloneSetup());

		// Inject whatever we need.
		dataService = get(IDataService.class);
		modelUtils = get(ModelUtils.class);
		dataService.getProvider().openSession("admin", "admin");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		dataService.getProvider().closeSession();
	}

	/**
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public void testContext() throws Exception {

		this.createModelData();
		
		
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

	/**
	 * Warning, we erase on the live DB!!!
	 */
	private Node createModelData() {
		{
			// Add some objects, which are referable from our xtext model.
			final CDOResource res = (CDOResource) dataService.getProvider()
					.getResource(LibraryPackage.Literals.LIBRARY);

			res.getContents().clear(); // Clear the Library resource from it's
										// contents.

			Library lib;
			if (res.getContents().size() > 0) {
				lib = (Library) res.getContents().get(0);
			} else {
				lib = LibraryFactory.eINSTANCE.createLibrary();
				res.getContents().add(lib);
			}

			final NodeType sgsnNodeType = LibraryFactory.eINSTANCE
					.createNodeType();
			final Function sgsnFunction = LibraryFactory.eINSTANCE
					.createFunction();
			sgsnFunction.setName("SGSN");
			sgsnNodeType.getFunctions().add(sgsnFunction);

			lib.getNodeTypes().add(sgsnNodeType);

			{
				final NetXResource sgsnRes = LibraryFactory.eINSTANCE
						.createNetXResource();
				sgsnRes.setShortName("RES1");
				sgsnRes.setExpressionName("RES1");

				// Create various ranges for AVG, BH.

				{

					final MetricValueRange range = MetricsFactory.eINSTANCE
							.createMetricValueRange();

					range.setKindHint(KindHintType.AVG); // Average values.
					range.setIntervalHint(60); // A 60 minute range.
					sgsnRes.getMetricValueRanges().add(range); // Index 0.
					final Value v = GenericsFactory.eINSTANCE.createValue();
					v.setValue(10.0);
					v.setTimeStamp(modelUtils.toXMLDate(modelUtils.yesterday()));

					final Value v1 = GenericsFactory.eINSTANCE.createValue();
					v1.setValue(10.1);
					v1.setTimeStamp(modelUtils.toXMLDate(modelUtils
							.twoDaysAgo()));

					final Value v2 = GenericsFactory.eINSTANCE.createValue();
					v2.setValue(9.8);
					v2.setTimeStamp(modelUtils.toXMLDate(modelUtils
							.threeDaysAgo()));

					final Value v3 = GenericsFactory.eINSTANCE.createValue();
					v3.setValue(10.2);
					v3.setTimeStamp(modelUtils.toXMLDate(modelUtils
							.fourDaysAgo()));
					range.getMetricValues().addAll(
							ImmutableList.of(v, v1, v2, v3));
				}

				{

					final MetricValueRange range = MetricsFactory.eINSTANCE
							.createMetricValueRange();

					range.setKindHint(KindHintType.BH); // Average values.
					range.setIntervalHint(60 * 24); // A one day range.
					sgsnRes.getMetricValueRanges().add(range); // Index 0.
					final Value v = GenericsFactory.eINSTANCE.createValue();
					v.setValue(2.0);
					v.setTimeStamp(modelUtils.toXMLDate(modelUtils.yesterday()));

					final Value v1 = GenericsFactory.eINSTANCE.createValue();
					v1.setValue(2.1);
					v1.setTimeStamp(modelUtils.toXMLDate(modelUtils
							.twoDaysAgo()));

					final Value v2 = GenericsFactory.eINSTANCE.createValue();
					v2.setValue(2.2);
					v2.setTimeStamp(modelUtils.toXMLDate(modelUtils
							.threeDaysAgo()));

					final Value v3 = GenericsFactory.eINSTANCE.createValue();
					v3.setValue(1.5);
					v3.setTimeStamp(modelUtils.toXMLDate(modelUtils
							.fourDaysAgo()));
					range.getMetricValues().addAll(
							ImmutableList.of(v, v1, v2, v3));
				}

				{
					// Create capacity values.
					final Value c1 = GenericsFactory.eINSTANCE.createValue();
					c1.setValue(5.0);
					c1.setTimeStamp(modelUtils.toXMLDate(modelUtils.yesterday()));

					final Value c2 = GenericsFactory.eINSTANCE.createValue();
					c2.setValue(5.0);
					c2.setTimeStamp(modelUtils.toXMLDate(modelUtils
							.twoDaysAgo()));

					final Value c3 = GenericsFactory.eINSTANCE.createValue();
					c3.setValue(5.0);
					c3.setTimeStamp(modelUtils.toXMLDate(modelUtils
							.threeDaysAgo()));

					sgsnRes.getCapacityValues().addAll(
							ImmutableList.of(c1, c2, c3));
				}

				sgsnFunction.getResources().add(sgsnRes);
			}
			{
				final NetXResource sgsnRes = LibraryFactory.eINSTANCE
						.createNetXResource();
				sgsnRes.setShortName("RES2");
				sgsnRes.setExpressionName("RES2");
				sgsnFunction.getResources().add(sgsnRes);
			}

			// Create some equipment:
			final Equipment board = LibraryFactory.eINSTANCE.createEquipment();
			// board.setName("BOARD");
			board.setEquipmentCode("BOARD");

			// Copy 10 equipments.
			for (int i = 0; i < 10; i++) {
				sgsnNodeType.getEquipments().add(EcoreUtil.copy(board));
			}

			// From the Nodetype, we create a node, copying the content.

			Node n = OperatorsFactory.eINSTANCE.createNode();
			n.setNodeID("YPSGSN01");
			NodeType copyofType = EcoreUtil.copy(sgsnNodeType);
			n.setNodeType(copyofType);

			try {
				res.save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return n;

		}
	}

}
