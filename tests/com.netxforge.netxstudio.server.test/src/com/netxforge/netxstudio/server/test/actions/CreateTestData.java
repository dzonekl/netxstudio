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

import org.junit.After;
import org.junit.Before;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.data.cdo.NonStatic;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

/**
 * Creates test data. Steps:
 * <ol>
 * <li>Start with an empty database</li>
 * <li>Start the server</li>
 * <li>Run this testcase</li>
 * </ol>
 * 
 * @author Martin Taal
 */
public class CreateTestData extends AbstractInjectedTestJUnit4 {

	@Inject
	private TestDataCreator testDataCreator;

	@Inject
	@NonStatic
	private IData dataProvider;

	@Before
	public void setUp() throws Exception {
		super.getClientInjector().injectMembers(this);
		dataProvider.setDoGetResourceFromOwnTransaction(false);
		dataProvider.openSession("admin", "admin");
	}

	@After
	public void tearDown() throws Exception {
		dataProvider.closeSession();
	}

	public void testCreateTestData() throws Exception {
		testDataCreator.setDataProvider(dataProvider);
		testDataCreator.create();
	}

}
