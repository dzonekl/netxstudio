/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;


public class VisualNetXScriptTest extends AbstractNetXScriptTest {

	
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
}
