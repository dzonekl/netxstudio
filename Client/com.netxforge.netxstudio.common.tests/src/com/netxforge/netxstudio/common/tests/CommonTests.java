/*******************************************************************************
 * Copyright (c) May 22, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.common.tests;


import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class CommonTests extends TestSuite {
	
	public static final String FIXTURE_PATH = "/Users/dzonekl/Documents/Spaces/netxstudio.gen4/com.netxforge.netxstudio.fixtures/";
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	public static Test suite() {
		TestSuite suite = new CommonTests("netxstudio common Tests");
		suite.addTestSuite(JCATest.class); 
		
		return suite;
	}

	public CommonTests(String name) {
		super(name);
	}

}
