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
import com.netxforge.interpreter.Interpreter;
import com.netxforge.netxscript.Mod;

public class CalculatorTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new NetxscriptStandaloneSetup());
	}

	public void testSimple() throws Exception {

		
		System.out.println("=>Blocks");
		calc("def main(){}");
		calc("def a(){;}");
		calc("def a(){{}}"); // Nested blocks, each block will hold statements.
		calc("def a(){{{{}}}}"); // deeply nested blocks, each block will hold statements.
		calc("def a(){{2+2;}1+1;}"); // Nested blocks, each block will hold statements.
		
		System.out.println("=>Function expressions");
		calc("def a(){ } def b(){}");
		calc("def main(){function();}def function(){2;}");
		calc("def main(){function(5);}def function(c){c+2;}");

		System.out.println("=>Substitutes (Keywords)");
		calc("def main(){this;}"); // Should substitute to the provided context. (Not implemented yet!). 
		
		System.out.println("=>Assignment statements");
		calc("def main(){a = 3;}");
		calc("def main(){a = 3;4+a;}");
		
		System.out.println("=>Arithmetic expressions");
		calc("def main(){1 + 2 + 3;}");
		calc("def main(){5*5;}");
		calc("def main(){5.9-5.1;}");
		calc("def main(){5.9/5.9;}");
		calc("def main(){2%3;}");
		
		System.out.println("=>Arithmetic expressions, all in one");
		calc("def main(){1 + 2 + 3;2%3;5*5;5.9-5.1;5.9/5.9;2%3;}");
		
		System.out.println("=>Boolean expressions");
		calc("def main(){5 < 8;}");
		calc("def main(){5 == 8;}");
		calc("def main(){8 == 8;}");
		calc("def main(){8 != 8;}");
		calc("def main(){4+4 == 8;}");

		System.out.println("=>Logical expressions");
		calc("def main(){true;}");
		calc("def main(){false;}");
		calc("def main(){8 == 8  || 8==7 ;}");
		calc("def main(){true && true;}");
		calc("def main(){true == false;}");
		
		System.out.println("=>Unary operators");
		calc("def main(){!(1==2);}");
		calc("def main(){!true;}");
		calc("def main(){!false;}");
		try{
			calc("def main(){!1;}");
		}catch(Exception e){
			// Should happen.
			System.out.println("Not allowed, negation on a numeric");
		}

		System.out.println("=>Unary plus minus operators");
		calc("def main(){1 + -1;}");
		try{
			calc("def main(){+true;}");
		}catch(Exception e){
			// Should happen.
			System.out.println("Not allowed, unary on a boolean");
		}
		
		// check(0,"1 + 2 - 3");
		// check(5,"1 * 2 + 3");
		// check(-4,"1 - 2 - 3");
		// check(1.5,"1 / 2 * 3");
	}

	// protected String check(double expected, String expression) throws
	// Exception {
	// Object result = new Calculator().evaluate(getStatement(expression));
	// if (result instanceof BigDecimal) {
	// assertEquals(expected, result);
	// return new Double(((BigDecimal) result).doubleValue()).toString();
	// }
	// return null;
	// }

	protected void calc(String expression) throws Exception {
		Mod mod = getMod(expression);
		Interpreter c = new Interpreter();
		// We assume the first definition is a 
		Object result = c.evaluate(mod);
		if(result != null){
			System.out.println("Evaluation result: " + result);
		}else{
			System.out.println("Evaluation result empty");
		}
	}

	// protected Statement getStatement(String string) throws Exception {
	// Mod model = (Mod) getModel("mod test " + string + ";");
	// Statement statement = model.getStatements().get(0);
	// return statement;
	// }

	protected Mod getMod(String string) throws Exception {
		Mod model = (Mod) getModel("mod test " + string);
		return model;
	}
}
