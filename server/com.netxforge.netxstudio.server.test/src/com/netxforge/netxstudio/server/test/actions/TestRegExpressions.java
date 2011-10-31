/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.test.actions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test regular expressions.
 * http://www.regular-expressions.info/java.html
 * @author Martin Taal
 */
public class TestRegExpressions {

	// @Test
	// public void testRegExp1() {
	// doTestRegExp("([^\\s]+(\\.(?i)(csv))$)");
	// }
	//

	@Test
	// any file name ending on .csv
	public void testRegExp() {
		doTestReg("[^\\s]+(\\.(?i)(csv))$");
	}

	@Test
	// file name with _fix_ in the middle ending on .csv
	public void testRegExp2() {
		doTestRegExp2("[^\\s]+(_fix_)[^\\s]+(\\.(?i)(csv))$");
	}

	@Test
	// file name with _fix- (Dash) in the middle ending on .csv
	public void testRegExp3() {
		doTestRegExp3("[^\\s]+(_fix-)[^\\s]+(\\.(?i)(csv))$");

	}

	@Test
	// file name with _fix- (Dash) in the middle ending on .csv
	public void testRegExp4() {
		// Alternative allowing only numbers and characters in the file name.
		doTestRegExp4("[a-zA-Z0-9_-]+(_fix-)[a-zA-Z0-9_-]+(\\.(?i)(csv))$");
	}

	private void doTestReg(String regExp) {
		Assert.assertTrue("test.csv".matches(regExp));
		Assert.assertTrue("test.CSV".matches(regExp));
		Assert.assertFalse(" test.xsl".matches(regExp));
		Assert.assertFalse("test.xsl".matches(regExp));
		Assert.assertFalse("test.CSA".matches(regExp));
		Assert.assertFalse("test.cvs.done".matches(regExp));
	}

	private void doTestRegExp2(String regExp) {
		Assert.assertTrue("stp01_fix_01012011.csv".matches(regExp));
		Assert.assertFalse("stp01_fix_01012011.csa".matches(regExp));
		Assert.assertFalse("stp01_fix01012011.csv".matches(regExp));
		Assert.assertFalse("stp01_fix-01012011.csv".matches(regExp));
	}

	private void doTestRegExp3(String regExp) {
		Assert.assertTrue("stp01_fix-01012011.csv".matches(regExp));
		Assert.assertFalse("stp01_fix-01012011.csa".matches(regExp));
		Assert.assertFalse("stp01_fix01012011.csv".matches(regExp));
		Assert.assertFalse("stp01_fix_01012011.csv".matches(regExp));
	}
	
	private void doTestRegExp4(String regExp) {
		Assert.assertTrue("stp01_fix-01012011.csv".matches(regExp)); 
		Assert.assertTrue("stp01-_fix-01012011.csv".matches(regExp)); 
		Assert.assertFalse("stp01_fix-01012011.csa".matches(regExp)); // doesn't match _fix-
		Assert.assertFalse("stp01_fix01012011.csv".matches(regExp)); // doesn't match _fix-
		Assert.assertFalse("stp01_fix_01012011.csv".matches(regExp)); // doesn't match _fix-
		Assert.assertFalse("stp01_fix 01012011.csv".matches(regExp)); // As a whitespace.
	}
	
}
