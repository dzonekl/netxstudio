/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

import junit.framework.AssertionFailedError;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;

import com.google.common.collect.Maps;
import com.netxforge.NetxscriptStandaloneSetup;
import com.netxforge.interpreter.IInterpreter;
import com.netxforge.interpreter.InterpreterTypeless;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.Return;

public class CalculatorTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new NetxscriptStandaloneSetup());
	}

	public void testFunction() throws Exception {

		checkModule("def main(){var a = true;}", testMap("a", Boolean.TRUE));
		checkModule("def main(){var a = 1 + 1;}",
				testMap("a", new BigDecimal(2)));
	}

	@SuppressWarnings("unchecked")
	public void testStatements() throws Exception {

		// Numerical
		checkModule("var a = 1 + 1;", testMap("a", new BigDecimal(2)));
		checkModule("var a = 4 * 5;", testMap("a", new BigDecimal(20)));
		checkModule("var a = 20/4;", testMap("a", new BigDecimal(5)));
		checkModule("var a = (3+3)/2;", testMap("a", new BigDecimal(3)));
		checkModule("var a = 2%3;", testMap("a", new BigDecimal(2)));
		checkModule("var a = 1/2;", testMap("a", new BigDecimal(0.5)));
		checkModule("var a = 0.5 + 0.5;", testMap("a", new BigDecimal(1)));

		// Numerical, with re-assignments.
		// A variable is pre-assigned, but not re-assigned in an expression, so
		// the old value is kept.
		checkModule("var a = 3;a + 3;", testMap("a", new BigDecimal(3)));
		checkModule("var a = 3;a = a + 3;", testMap("a", new BigDecimal(6)));
		checkModule("var a = 3;a = a + 3;a;", testMap("a", new BigDecimal(6)));

		// Negations with re-assignments
		checkModule("var a = 3;a = -a;", testMap("a", new BigDecimal(-3)));
		checkModule("var a = 3;a = +a;", testMap("a", new BigDecimal(3)));
		checkModule("var a = 3;a = +-a;", testMap("a", new BigDecimal(-3)));


		// Logical
		checkModule("var a = true;", testMap("a", Boolean.TRUE));
		checkModule("var a = (1 == 1);", testMap("a", Boolean.TRUE));
		checkModule("var a = 1 == 1;", testMap("a", Boolean.TRUE));
		checkModule("var a = (1 != 1);", testMap("a", Boolean.FALSE));
		checkModule("var a = (1 <= 1);", testMap("a", Boolean.TRUE));
		checkModule("var a = (1 <= 2);", testMap("a", Boolean.TRUE));
		checkModule("var a = (1 < 2);", testMap("a", Boolean.TRUE));
		checkModule("var a = (1 >= 1);", testMap("a", Boolean.TRUE));
		checkModule("var a = (1 >= 2);", testMap("a", Boolean.FALSE));

		checkModule("var a = false || false;", testMap("a", Boolean.FALSE));
		checkModule("var a = false || true;", testMap("a", Boolean.TRUE));
		checkModule("var a = false && false;", testMap("a", Boolean.FALSE));
		checkModule("var a = false && true;", testMap("a", Boolean.FALSE));
		checkModule("var a = true && true;", testMap("a", Boolean.TRUE));
		checkModule("var a = !true;", testMap("a", Boolean.FALSE));
		checkModule("var a = !false;", testMap("a", Boolean.TRUE));

		{
			Map<String, Object> map = testMap("a", Boolean.TRUE);
			map.put("b", Boolean.TRUE);
			checkModule("var a = true;var b = a;", map);
		}

		{
			Map<String, Object> map = testMap("a", Boolean.TRUE);
			map.put("b", Boolean.TRUE);
			checkModule("var a = true;var b = a || a;", map);
		}

		{
			Map<String, Object> map = testMap("a", Boolean.TRUE);
			map.put("b", Boolean.TRUE);
			checkModule("var a = true;var b = a && a;", map);
		}

		// Flow control, scoping and functions.
		checkModule("var a = 4;{a = a -1;}", testMap("a", new BigDecimal(3)));
		checkModule("var a = 4;{{a = a -1;}}", testMap("a", new BigDecimal(3)));
		checkModule("var a = 4;if(a == 4){a = a -1;}",
				testMap("a", new BigDecimal(3)));
		checkModule("var a = 4;if(a != 4){a = a -1;}else{a = a + 1;}",
				testMap("a", new BigDecimal(5)));
		checkModule("var a = 4;if(true){var b = 5;a = b;}",
				testMap("a", new BigDecimal(5)));
		// proving a local assigned variable, is not available outside the
		// scoped block.
		checkModule("if(true){var a = -1;}", Collections.EMPTY_MAP);
		// deeply nested (re)assignment
		checkModule("var a = 0;if(true){if(true){if(true){a = 6;}}}",
				testMap("a", new BigDecimal(6)));
		// while statement
		checkModule("var a = 0;while(a < 5){ a = a + 1;}",
				testMap("a", new BigDecimal(5)));
		
		// Returns have a special meaning. 
		checkModule("return;", Collections.EMPTY_MAP);
		checkModule("def main(){var a = 1;}",
				testMap("a", new BigDecimal(1)));

		checkModule("def main(){var a = other();}def other(){ return 5;}",
				testMap("a", new BigDecimal(5)));
		
		// Re-assignment from a function, with same var as argument 
		checkModule("def main(){var a = 3; a = other(a);}def other(arg){ return arg + 3;}",
				testMap("a", new BigDecimal(6)));

		// Returned value from the first function has no result. 
		checkModule("def main(){return 1 + 1;}",
				testMap("a", Collections.EMPTY_MAP));
			
		// Negative testing. (Syntacticly correct, but not evaluable). 
		try {
			checkModule("def main(){!1;}", Collections.EMPTY_MAP);
		} catch (java.lang.UnsupportedOperationException e) {
			// Not allowed, negation on a numeric
		}
		
		try {
			evaluateModule("def main(){+true;}");
		} catch (java.lang.UnsupportedOperationException e) {
			// Not allowed, unary on a boolean"
		}
		
		try {
			checkModule("var a;a = a + 3;a;", testMap("a", new BigDecimal(6)));
		} catch (java.lang.UnsupportedOperationException e) {
			// Unassigned variable declaration, throws expression
		}
	}
	
	
	/**
	 * Creat a test map. 
	 * @param s
	 * @param o
	 * @return
	 */
	private Map<String, Object> testMap(String s, Object o) {
		Map<String, Object> testMap = Maps.newHashMap();
		testMap.put(s, o);
		return testMap;
	}

	public void testReferences() throws Exception {

	}

	public void testVisual() throws Exception {

		System.out.println("=>Blocks");
		evaluateModule("def main(){}");
		evaluateModule("def a(){}");
		evaluateModule("def a(){{}}"); // Nested blocks, each block will hold
										// statements.
		evaluateModule("def a(){{{{}}}}"); // deeply nested blocks, each block
											// will hold
		// statements.
		evaluateModule("def a(){{2+2;}1+1;}"); // Nested blocks, each block will
												// hold
		// statements.

		System.out.println("=>Function expressions");
		evaluateModule("def a(){ } def b(){}");
		evaluateModule("def main(){function();}def function(){2;}");
		evaluateModule("def main(){function(5);}def function(c){c+2;}");

		System.out.println("=>Substitutes (Keywords)");
		// calc("def main(){this;}"); // Should substitute to the provided
		// context. (Not implemented yet!).

		System.out.println("=>Assignment statements");
		evaluateModule("def main(){var a = 3;}");
		evaluateModule("def main(){var a = 3;4+a;}");

		System.out.println("=>Arithmetic expressions");
		evaluateModule("def main(){1 + 2 + 3;}");
		evaluateModule("def main(){5*5;}");
		evaluateModule("def main(){5.9-5.1;}");
		evaluateModule("def main(){5.9/5.9;}");
		evaluateModule("def main(){2%3;}");

		System.out.println("=>Arithmetic expressions, all in one");
		evaluateModule("def main(){1 + 2 + 3;2%3;5*5;5.9-5.1;5.9/5.9;2%3;}");

		System.out.println("=>Boolean expressions");
		evaluateModule("def main(){5 < 8;}");
		evaluateModule("def main(){5 == 8;}");
		evaluateModule("def main(){8 == 8;}");
		evaluateModule("def main(){8 != 8;}");
		evaluateModule("def main(){4+4 == 8;}");

		System.out.println("=>Logical expressions");
		evaluateModule("def main(){true;}");
		evaluateModule("def main(){false;}");
		evaluateModule("def main(){8 == 8  || 8==7 ;}");
		evaluateModule("def main(){true && true;}");
		evaluateModule("def main(){true == false;}");

		System.out.println("=>Unary operators");
		evaluateModule("def main(){!(1==2);}");
		evaluateModule("def main(){!true;}");
		evaluateModule("def main(){!false;}");
		try {
			evaluateModule("def main(){!1;}");
		} catch (Exception e) {
			// Should happen.
			System.out.println("Not allowed, negation on a numeric");
		}

		System.out.println("=>Unary plus minus operators");
		evaluateModule("def main(){1 + -1;}");
		try {
			evaluateModule("def main(){+true;}");
		} catch (Exception e) {
			// Should happen.
			System.out.println("Not allowed, unary on a boolean");
		}
	}

	/**
	 * 
	 * @param expression
	 * @param result
	 * @throws Exception
	 */
	protected void checkModule(String expression, Map<String, Object> testMap)
			throws Exception {
		Mod mod = getMod(expression);
		IInterpreter c = new InterpreterTypeless();

		// Assert result.
		Object eval = c.evaluate(mod);
		
		// Returns, have a non-pre-evaluated expression. 
		if(eval instanceof Return){
			if( ((Return)eval).getExpression() != null){
				eval = c.evaluate(((Return)eval).getExpression());
			}
		}
		
		if (eval instanceof Map<?, ?>) {
			@SuppressWarnings("unchecked")
			Map<String, Object> innerMap = (Map<String, Object>) eval;

			// The evaluation check should match the number of expected results.
			if (innerMap.size() != testMap.size()) {
				throw new Exception();
			}

			for (String s : innerMap.keySet()) {
				Object eResult = innerMap.get(s);
				Object expected = testMap.get(s);
				if (eResult instanceof EObject) {
					assert EcoreUtil.equals((EObject) expected,
							(EObject) eResult) : new AssertionFailedError(
							"EObject unequal");
				} else {

					// For BigDecimal, we need to use the compare method, to
					// ignore the scale of the BigD.
					if (eResult instanceof BigDecimal) {
						assertEquals(0,
								((BigDecimal) eResult)
										.compareTo((BigDecimal) expected));
					} else {
						/**
						 * Object equality will work?
						 */
						assertEquals(expected, eResult);
					}
				}
			}
		}
	}

	protected Object evaluateModule(String expression) throws Exception {
		Mod mod = getMod(expression);
		IInterpreter c = new InterpreterTypeless();
		// We assume the first definition is a
		Object result = c.evaluate(mod);
		if (result != null) {
			System.out.println("Evaluation result: " + result);
		} else {
			System.out.println("Evaluation result empty");
		}

		return result;
	}

	protected Mod getMod(String string) throws Exception {
		Mod model = (Mod) getModel("mod test " + string);
		return model;
	}
}
