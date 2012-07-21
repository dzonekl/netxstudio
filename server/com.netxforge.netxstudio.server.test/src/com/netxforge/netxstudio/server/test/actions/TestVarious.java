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

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;


/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class TestVarious {

	@Test
	public void testVarious() {
		
		ArrayList<String> newArrayList = Lists.newArrayList();
		String string = new String("test string");
		newArrayList.add(string);
		
		
		int index = newArrayList.indexOf(string);
		String string2 = newArrayList.get(index);
		
		ArrayList<Object> copiedList = Lists.newArrayList();
		copiedList.add(string2);
		
		newArrayList.remove(index);
		
		Assert.assertTrue(copiedList.contains(string2));
	}
	
	
}
