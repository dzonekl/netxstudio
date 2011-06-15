/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;

import java.math.BigDecimal;
import java.util.Map;

import junit.framework.AssertionFailedError;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;

import com.google.common.collect.Maps;
import com.netxforge.NetxscriptStandaloneSetup;
import com.netxforge.interpreter.IInterpreter;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.Return;

public class AbstractNetXScriptTest extends AbstractXtextTests {
	
	IInterpreter interpreter;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new NetxscriptStandaloneSetup());
		interpreter = this.get(IInterpreter.class);
	}

	protected void checkModule(String expression, Map<String, Object> testMap)
			throws Exception {
		checkModule(interpreter, expression, testMap);
		
	}
	
	/**
	 * Check the module with a test map as input.  
	 * 
	 * @param expression
	 * @param result
	 * @throws Exception
	 */
	protected void checkModule(IInterpreter interpreter, String expression, Map<String, Object> testMap)
			throws Exception {
		
		Mod mod = getMod(expression);

		// Assert result.
		Object eval = interpreter.evaluate(mod);
		
		// Returns, have a non-pre-evaluated expression. 
		if(eval instanceof Return){
			if( ((Return)eval).getExpression() != null){
				eval = interpreter.evaluate(((Return)eval).getExpression());
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

	/**
	 * Creat a test map. 
	 * @param s
	 * @param o
	 * @return
	 */
	protected Map<String, Object> testMap(String s, Object o) {
		Map<String, Object> testMap = Maps.newHashMap();
		testMap.put(s, o);
		return testMap;
	}
	
	protected Object evaluateModule(String expression) throws Exception {
		Mod mod = getMod(expression);
		// We assume the first definition is a
		Object result = interpreter.evaluate(mod);
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
