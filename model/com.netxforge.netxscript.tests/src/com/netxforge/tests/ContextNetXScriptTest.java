/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.xtext.junit.AbstractXtextTests;

import com.google.common.collect.Lists;
import com.netxforge.NetxscriptStandaloneSetup;
import com.netxforge.interpreter.IInterpreter;
import com.netxforge.interpreter.IInterpreterContext;
import com.netxforge.interpreter.IInterpreterContextFactory;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.NetXResource;
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
 * @author dzonekl
 * 
 */
public class ContextNetXScriptTest extends AbstractXtextTests {

	IDataService dataService;
	IInterpreter interpreter;
	IInterpreterContextFactory interpreterContextFactory;
	ModelUtils modelUtils;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new NetxscriptStandaloneSetup());

		// Inject whatever we need.
		dataService = get(IDataService.class);
		modelUtils = get(ModelUtils.class);
		interpreter = get(IInterpreter.class);
		interpreterContextFactory = get(IInterpreterContextFactory.class);
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
	public void testContext() throws Exception {

		Node node = TestModel.INSTANCE.createModelData(dataService.getProvider(), modelUtils);

		// Set a period context.

		final DateTimeRange timeRange = GenericsFactory.eINSTANCE
				.createDateTimeRange();

		final XMLGregorianCalendar t0 = modelUtils.toXMLDate(modelUtils
				.todayAndNow());
		final XMLGregorianCalendar t1 = modelUtils.toXMLDate(modelUtils
				.lastWeek());

		timeRange.setBegin(t1);
		timeRange.setEnd(t0);

		final IInterpreterContext periodContext = interpreterContextFactory
				.createPeriodContext(timeRange);
		final IInterpreterContext nc = interpreterContextFactory
				.createContext(node);

		final List<IInterpreterContext> contextList = Lists.newArrayList();

		System.out.println(interpreter.toString());

		// An expression which assigns a range of values to a var.
		// An expression which performs native function calls on a range.
		// The range arithmetics.

		{

			Mod m = (Mod) this.getModel("var a = [1,2,3,4].sum();a;");
			@SuppressWarnings("unused")
			Object result = interpreter.evaluate(m); // Returns the intermediate
														// results.
			List<BaseExpressionResult> expressionResults = interpreter
					.getResult(); // Returns
			printExpressionResult(expressionResults);
		}
		// CONTEXTUAL REFERENCES
		{
			contextList.clear();
			contextList.add(periodContext);
			contextList.add(nc);
			final IInterpreterContext[] contextArray = new IInterpreterContext[contextList
					.size()];

			// An expression which reads values from a resource.
			{
				interpreter.clear(); // Clear the interpreter.
				interpreter.setContext(contextList.toArray(contextArray)); // Set
																			// a
				Mod m = (Mod) this
						.getModel("var a = this.FUNCTION Function1 ->RESOURCE RES1 METRIC AVG 60;a;");
				@SuppressWarnings("unused")
				Object result = interpreter.evaluate(m); // Returns the
															// intermediate
				List<BaseExpressionResult> expressionResults = interpreter
						.getResult(); // Returns
				printExpressionResult(expressionResults); // Should print all
															// values.

			}

			// An expression which reads values from a resource, and writes them
			// to
			// another resource.
			// WARNING: The syntax of the expression is subject to change.

			{
				interpreter.clear(); // Clear the interpreter.
				interpreter.setContext(contextList.toArray(contextArray)); // Set
																			// a
																			// context.
				Mod m = (Mod) this
						.getModel("this.FUNCTION SGSN->RESOURCE RES2 UTILIZATION AVG 60 = this.FUNCTION SGSN->RESOURCE RES1 METRIC AVG 60;");
				@SuppressWarnings("unused")
				Object result = interpreter.evaluate(m); // Returns the
															// intermediate
				List<BaseExpressionResult> expressionResults = interpreter
						.getResult(); // Returns
				printExpressionResult(expressionResults);

			}

			// An expression which reads values from a resource and does an
			// indirect
			// write to another resource.

			{
				interpreter.clear(); // Clear the interpreter.
				interpreter.setContext(contextList.toArray(contextArray)); // Set
																			// a
																			// context.
				Mod m = (Mod) this
						.getModel("var a = this.FUNCTION SGSN->RESOURCE RES1 METRIC AVG 60;this.FUNCTION SGSN->RESOURCE RES2 UTILIZATION AVG 60 = a;");
				@SuppressWarnings("unused")
				Object result = interpreter.evaluate(m); // Returns the
															// intermediate
				List<BaseExpressionResult> expressionResults = interpreter
						.getResult(); // Returns
				printExpressionResult(expressionResults);

			}

			// An expression which writes a single value to a Capacity range.
			{
				interpreter.clear(); // Clear the interpreter.
				interpreter.setContext(contextList.toArray(contextArray)); // Set
																			// a

				Mod m = (Mod) this
						.getModel("this.FUNCTION SGSN->RESOURCE RES1 CAP 60 = 30 * 60;");
				@SuppressWarnings("unused")
				Object result = interpreter.evaluate(m); // Returns the
															// intermediate
				List<BaseExpressionResult> expressionResults = interpreter
						.getResult(); // Returns
				printExpressionResult(expressionResults);
			}

			// An expression which reads capacity values from a resource,

			{
				interpreter.clear(); // Clear the interpreter.
				interpreter.setContext(contextList.toArray(contextArray)); // Set
																			// a
				Mod m = (Mod) this
						.getModel("var a = this.FUNCTION SGSN->RESOURCE RES1 CAP 60;");
				@SuppressWarnings("unused")
				Object result = interpreter.evaluate(m); // Returns the
															// intermediate
				List<BaseExpressionResult> expressionResults = interpreter
						.getResult(); // Returns
				printExpressionResult(expressionResults);
			}

			// An expression which reads values from a resource, performs an
			// operation on each of the values and writes the result
			// to another resource. .

			{

				interpreter.clear(); // Clear the interpreter.
				interpreter.setContext(contextList.toArray(contextArray)); // Set
																			// a
				Mod m = (Mod) this
						.getModel("var a = this.FUNCTION SGSN->RESOURCE RES1 METRIC AVG 60; var i = 0; var c = []; while( i < a.count()){ c += a[i];  i+=1;} this.FUNCTION SGSN->RESOURCE RES2 UTILIZATION AVG 60 = c;");
				@SuppressWarnings("unused")
				Object result = interpreter.evaluate(m); // Returns the
															// intermediate
				List<BaseExpressionResult> expressionResults = interpreter
						.getResult(); // Returns
				printExpressionResult(expressionResults);

			}

			// An expression which reads values from a resource, performs an
			// operation on each of the values and writes the result
			// to another range from that resource.
			// Notice how an empty temp range, transports the range type (Value)
			// to
			// the expression result. (Cool typeless system).

			{

				interpreter.clear(); // Clear the interpreter.
				interpreter.setContext(contextList.toArray(contextArray)); // Set
																			// a
				Mod m = (Mod) this
						.getModel("var metric = this.FUNCTION SGSN->RESOURCE RES1 METRIC AVG 60; var i = 0; var temp = []; while( i < metric.count()){ temp += metric[i] ;  i+=1;} this.FUNCTION SGSN->RESOURCE RES2 UTILIZATION AVG 60 = temp;");
				@SuppressWarnings("unused")
				Object result = interpreter.evaluate(m); // Returns the
															// intermediate
				List<BaseExpressionResult> expressionResults = interpreter
						.getResult(); // Returns
				printExpressionResult(expressionResults);

			}

			// An expression which takes a model object and applies a native
			// expression.
			{

				interpreter.clear(); // Clear the interpreter.
				interpreter.setContext(contextList.toArray(contextArray)); // Set
																			// a
				Mod m = (Mod) this
						.getModel("var a = this.EQUIPMENT BOARD.count();");
				@SuppressWarnings("unused")
				Object result = interpreter.evaluate(m); // Returns the
															// intermediate
				List<BaseExpressionResult> expressionResults = interpreter
						.getResult(); // Returns
				printExpressionResult(expressionResults);
			}
		}

		// Resource context expressions.
		{

			List<Component> cl = Lists.newArrayList();
			cl.addAll(node.getNodeType().getEquipments());
			cl.addAll(node.getNodeType().getFunctions());
			List<NetXResource> allResources = modelUtils
					.resourcesWithExpressionName(cl, ".*", true); // All resources.
			for (NetXResource r : allResources) {
				contextList.clear();
				contextList.add(periodContext);
				IInterpreterContext resourceContext = this.interpreterContextFactory
						.createContext(r);
				contextList.add(resourceContext);
				final IInterpreterContext[] contextArray = new IInterpreterContext[contextList
						.size()];
				// An expression which takes a model object and applies a native
				// expression.
				{

					interpreter.clear(); // Clear the interpreter.
					interpreter.setContext(contextList.toArray(contextArray)); // Set

					Mod m = (Mod) this
							.getModel("this UTILIZATION 60 = this METRIC AVG 60 / this CAP 60;");
					@SuppressWarnings("unused")
					Object result = interpreter.evaluate(m); // Returns the
																// intermediate
					List<BaseExpressionResult> expressionResults = interpreter
							.getResult(); // Returns
					printExpressionResult(expressionResults);

				}
			}
		}

		// Resource context expressions which calculates the tolerance. .
		{

			List<Component> cl = Lists.newArrayList();
			cl.addAll(node.getNodeType().getEquipments());
			cl.addAll(node.getNodeType().getFunctions());
			List<NetXResource> allResources = modelUtils
					.resourcesWithExpressionName(cl, ".*", true); // All resources.
			for (NetXResource r : allResources) {
				contextList.clear();
				contextList.add(periodContext);
				IInterpreterContext resourceContext = this.interpreterContextFactory
						.createContext(r);
				contextList.add(resourceContext);
				final IInterpreterContext[] contextArray = new IInterpreterContext[contextList
						.size()];
				// An expression which takes a model object and applies a native
				// expression.
				{

					interpreter.clear(); // Clear the interpreter.
					interpreter.setContext(contextList.toArray(contextArray)); // Set

					Mod m = (Mod) this
							.getModel("this TOLERANCE 60 = this CAP 60 * 0.9;");
					@SuppressWarnings("unused")
					Object result = interpreter.evaluate(m); // Returns the
																// intermediate
					List<BaseExpressionResult> expressionResults = interpreter
							.getResult(); // Returns
					printExpressionResult(expressionResults);

				}
			}
		}

	}

	private void printExpressionResult(List<BaseExpressionResult> results) {
		for (BaseExpressionResult result : results) {

			if (result instanceof ExpressionResult) {
				ExpressionResult er = (ExpressionResult) result;

				System.out.println("On Resource:"
						+ er.getTargetResource().getShortName());
				System.out.println("In Range:" + er.getTargetRange().getName());
				System.out.println("With values:");
				for (Value v : er.getTargetValues()) {

					System.out.println("Value: " + v.getValue());
					if (v.getTimeStamp() != null) {
						Date d = modelUtils.fromXMLDate(v.getTimeStamp());
						System.out.println(modelUtils.date(d) + ", "
								+ modelUtils.time(d));
					} else {
						System.out.println("No date in the result set");
					}
				}

			}

		}
	}

	

}
