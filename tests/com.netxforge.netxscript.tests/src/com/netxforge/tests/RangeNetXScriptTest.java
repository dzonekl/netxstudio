/*******************************************************************************
 * Copyright (c) 8 apr. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.tests;

import java.math.BigDecimal;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.netxforge.netxstudio.data.ICDODataService;

public class RangeNetXScriptTest extends AbstractNetXScriptTest {

	ICDODataService dataService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// Inject whatever we need.
		dataService = get(ICDODataService.class);
		// As we have no global scoping in these tests,
		// CDO connection is not required.
		 dataService.getCDOData().openSession("admin", "admin");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		// dataService.getProvider().closeSession();
	}

	public void testRanges() throws Exception {
		// Assigns a range to a and returns the range.
		checkModule(
				"var a = [1,2,3,4];a;",
				testMap("a", ImmutableList
						.of(new BigDecimal(1), new BigDecimal(2),
								new BigDecimal(3), new BigDecimal(4))));

		// Native functions.
		checkModule("var a = [1,2,3,4].sum();a;",
				testMap("a", new BigDecimal(10)));
		checkModule("var a = [4,2,12,4].max();a;",
				testMap("a", new BigDecimal(12)));
		checkModule("var a = [4,2,12,4].min();a;",
				testMap("a", new BigDecimal(2)));
		checkModule("var a = [5,4,5,4].mean();a;",
				testMap("a", new BigDecimal(4.5)));

		{
			// Loop through a range, not Index out of bound could occur if the
			// loop condition is not chosen properly.
			Map<String, Object> tm = testMap("b", new BigDecimal(4));
			tm.put("a", ImmutableList.of(new BigDecimal(5), new BigDecimal(4),
					new BigDecimal(5), new BigDecimal(4)));
			tm.put("c", new BigDecimal(18));
			checkModule(
					"var a = [5,4,5,4]; var b = 0; var c = 0; while(b<4){ c = c + a[b]; b = b + 1;}",
					tm);
		}
		// assign one range to another range.
		{
			Map<String, Object> tm = testMap("a", ImmutableList.of(
					new BigDecimal(5), new BigDecimal(4), new BigDecimal(5),
					new BigDecimal(4)));
			tm.put("b", ImmutableList.of(new BigDecimal(5), new BigDecimal(4),
					new BigDecimal(5), new BigDecimal(4)));

			checkModule("var a = [5,4,5,4]; var b; b = a;", tm);
		}
		// execute a native expression on a range variable
		// assign one range to another range.
		{
			Map<String, Object> tm = testMap("a", ImmutableList.of(
					new BigDecimal(5), new BigDecimal(4), new BigDecimal(5),
					new BigDecimal(4)));
			tm.put("b", new BigDecimal(18));

			checkModule("var a = [5,4,5,4]; var b = a.sum();", tm);
		}
		
		
		// Execute a range increment, adds a value to a range. 
		{
			Map<String, Object> tm = testMap("a", ImmutableList.of(
					new BigDecimal(5), new BigDecimal(4), new BigDecimal(5),
					new BigDecimal(4), new BigDecimal(10)));
			checkModule("var a = [5,4,5,4]; a += 10;a;", tm);
		}
		
		
		// A var expression with a numeric value, which is re-assigned as a range.    
		{
			Map<String, Object> tm = testMap("a", ImmutableList.of(
					new BigDecimal(10)));
			checkModule("var a = []; a += 10;a;", tm);
		}
		
		
		

	}
}
