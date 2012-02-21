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

public class BasicNetXScriptTest extends AbstractNetXScriptTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
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
		
		// Incremental assignements
		checkModule("var a = 1;a += 1;", testMap("a", new BigDecimal(2)));
		
		
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
			// Unassigned variable declaration, throws exception
		}
	}

}
