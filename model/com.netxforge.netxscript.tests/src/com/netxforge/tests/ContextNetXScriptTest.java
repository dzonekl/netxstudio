/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;

import java.math.BigDecimal;

public class ContextNetXScriptTest extends AbstractNetXScriptTest {


	public void testWithContext() throws Exception {
		
		
		
		
		
		// Numerical
		checkModule("var a = 1 + 1;", testMap("a", new BigDecimal(2)));

	}
	
	

}
