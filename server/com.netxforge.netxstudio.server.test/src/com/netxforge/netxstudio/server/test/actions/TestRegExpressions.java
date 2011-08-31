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
 * 
 * @author Martin Taal
 */
public class TestRegExpressions {
	
	@Test
	public void testRegExp1() {
		doTestRegExp("([^\\s]+(\\.(?i)(csv))$)");
	}
	
	@Test
	public void testRegExp2() {
		doTestRegExp(".+\\.(?i)(csv)");
	}
	
	private void doTestRegExp(String regExp) {
		Assert.assertTrue("test.csv".matches(regExp));
		Assert.assertTrue("test.CSV".matches(regExp));
		Assert.assertFalse("test.xsl".matches(regExp));
		Assert.assertFalse("test.CSA".matches(regExp));		
	}
}
