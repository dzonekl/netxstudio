/*******************************************************************************
 * Copyright (c) 25 jun. 2014 NetXForge.
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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.data.index.IComponentLocator;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;

public class ClientInjectionTest extends AbstractInjectedTestJUnit4 {

	@Inject
	private ICDODataService dataService;

	@Inject
	private IComponentMappingIndex mappingIndex;

	@Inject
	private IComponentLocator locator;

	@Before
	public void setup() {
		this.getClientInjector().injectMembers(this);
	}

	@Test
	public void testCommonServices() {
		Assert.assertNotNull(dataService);
		Assert.assertNotNull(dataService.getCDOData());
		Assert.assertNotNull(mappingIndex);
		Assert.assertNotNull(locator);

	}

}
