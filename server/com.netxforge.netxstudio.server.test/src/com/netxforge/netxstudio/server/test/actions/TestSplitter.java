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

import org.junit.Test;


/**
 * Test google collect splitter.
 * @author Christophe Bouhier christophe.bouhier@netxforge.com 
 */
public class TestSplitter {

	@Test
	public void testSplitter_1() {
		this.doTestFor("A,B,C", ",");
		this.doTestFor("A,B,C", "\"");
	}
	
	@Test
	public void testSplitter_2() {
		this.doTestFor("\"A,B,C\",D,E", "\"");
	}
	
	@Test
	public void testSplitter_3() {
		String[]  result = this.doTestFor("\"A,B,C\",D,E", "\"");
		for(int j = 0; j < result.length ; j++){
			this.doTestFor(result[j], ",");
		}
	}
	
	String[] doTestFor(String s, String pattern){
		String[] split = s.split(pattern);
		for(int i = 0; i < split.length ; i++){
			System.out.println(split[i]);
		}
		return split;
	}

}
