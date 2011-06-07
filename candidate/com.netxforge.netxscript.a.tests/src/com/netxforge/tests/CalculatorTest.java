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

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.netxforge.NetxscriptStandaloneSetup;
import com.netxforge.interpreter.InterpreterTypeless;
import com.netxforge.netxscript.Assignment;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.NetxscriptFactory;
import com.netxforge.netxscript.Statement;
import com.netxforge.netxscript.Variable;

public class CalculatorTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new NetxscriptStandaloneSetup());
	}

	public void testSimple() throws Exception {
		checkFunction("def main(){true;}", new Object[]{Boolean.TRUE});
		checkFunction("def main(){1 + 1;}", new Object[]{new BigDecimal(2)});
	}
	
	public void testStatements() throws Exception {
		checkStatements("1 + 1;", new Object[]{new BigDecimal(2)});
		checkStatements("4 * 5;", new Object[]{new BigDecimal(20)});
		Variable v = NetxscriptFactory.eINSTANCE.createVariable();
		v.setName("a");
		checkStatements("var a = 3;a + 3;", new Object[]{v, new BigDecimal(6)});
		Assignment a = NetxscriptFactory.eINSTANCE.createAssignment();
		a.setVar(v);
		checkStatements("var a = 3;a = a + 3;a;", new Object[]{v,a ,new BigDecimal(6)});
		
		// TODO, with BigDecimal operators, scale factor. 
//		checkStatements("20/4;", new Object[]{new BigDecimal(5.0)});
//		checkStatements("(3+3)/2;", new Object[]{new BigDecimal(3)});
	}
	
	public void testReferences() throws Exception {
		
	}
	
	public void testVisual() throws Exception {

		System.out.println("=>Blocks");
		evaluateModule("def main(){}");
		evaluateModule("def a(){}");
		evaluateModule("def a(){{}}"); // Nested blocks, each block will hold statements.
		evaluateModule("def a(){{{{}}}}"); // deeply nested blocks, each block will hold
									// statements.
		evaluateModule("def a(){{2+2;}1+1;}"); // Nested blocks, each block will hold
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

		// check(0,"1 + 2 - 3");
		// check(5,"1 * 2 + 3");
		// check(-4,"1 - 2 - 3");
		// check(1.5,"1 / 2 * 3");
	}
	
	
	/**
	 * @param expected
	 * @param expression
	 * @throws Exception
	 */
	protected void checkFunction(String expression, Object... result) throws Exception {
		Mod mod = getMod(expression);
		InterpreterTypeless c = new InterpreterTypeless();

		Function first = mod.getFunctions().get(0);
		 //The evaluation check should match the number of expected results.
		if(first == null || first.getBlock().getStatements().size() != result.length){
			throw new Exception();
		}
		Map<String, Object> localVarsAndArguments = Maps.newHashMap();
		
		for(Statement s : first.getBlock().getStatements()){
			Object eResult = c.evaluate(s,  ImmutableMap.copyOf(localVarsAndArguments));
			
			{ // Pre-evaluation of variables and assignments.
				Object varEval = null;
				Variable v = null;
				if (s instanceof Variable) {
					v = (Variable) s;
					if (v != null) {
						varEval = c.evaluate(v.getExpression(),
								ImmutableMap.copyOf(localVarsAndArguments));
					}
					localVarsAndArguments.put(v.getName(), varEval);
				}
				if (s instanceof Assignment) {
					v = (Variable) ((Assignment) s).getVar();
					if (v != null) {
						varEval = c.evaluate(v.getExpression(),
								ImmutableMap.copyOf(localVarsAndArguments));
					}
					localVarsAndArguments.put(v.getName(), varEval);
				}
				
			}
			
			
			int i = first.getBlock().getStatements().indexOf(s);
			Object expected = result[i];
			
			/**
			 * Object equality will work? 
			 */
			assertEquals(expected,eResult);
		}
	}
	
	
	protected void checkStatements(String expression, Object... result) throws Exception {
		Mod mod = getMod(expression);
		InterpreterTypeless c = new InterpreterTypeless();
		 //The evaluation check should match the number of expected results.
		if(mod.getStatements().size() != result.length){
			throw new Exception();
		}
		
		Map<String, Object> localVarsAndArguments = Maps.newHashMap();
		
		for(Statement s : mod.getStatements()){
			Object eResult = c.evaluate(s, ImmutableMap.copyOf(localVarsAndArguments));
			
			
			{ // Pre-evaluation of variables and assignments.
				Object varEval = null;
				Variable v = null;
				if (s instanceof Variable) {
					v = (Variable) s;
					if (v != null) {
						varEval = c.evaluate(v.getExpression(),
								ImmutableMap.copyOf(localVarsAndArguments));
					}
					localVarsAndArguments.put(v.getName(), varEval);
				}
				if (s instanceof Assignment) {
					v = (Variable) ((Assignment) s).getVar();
					if (v != null) {
						varEval = c.evaluate(v.getExpression(),
								ImmutableMap.copyOf(localVarsAndArguments));
					}
					localVarsAndArguments.put(v.getName(), varEval);
				}
				
			}
			
			// Assert result.
			
			int i = mod.getStatements().indexOf(s);
			Object expected = result[i];
			
			if(eResult instanceof EObject){
				assert EcoreUtil.equals((EObject)expected,(EObject)eResult) : new AssertionFailedError("EObject unequal");
			}else{
				/**
				 * Object equality will work? 
				 */
				assertEquals(expected,eResult);
			}
		}
		
	}
	
	protected boolean hasManyStatements(Function f){
		return f.getBlock().getStatements().size() > 1;
	};
	
	protected Object evaluateModule(String expression) throws Exception {
		Mod mod = getMod(expression);
		InterpreterTypeless c = new InterpreterTypeless();
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
