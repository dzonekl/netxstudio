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

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.cdo.NonStatic;
import com.netxforge.netxstudio.server.test.dataprovider.AbstractDataProviderTest;

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
public class CreateTestData extends AbstractDataProviderTest {
	
	@Inject
	private TestDataCreator testDataCreator;
	
	@Inject
	@NonStatic
	private IDataProvider dataProvider;
	
	@Inject
	private ModelUtils modelUtils;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		super.getInjector().injectMembers(this);
		dataProvider.setDoGetResourceFromOwnTransaction(false);
		dataProvider.openSession("admin", "admin");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		dataProvider.closeSession();
	}

	public void testCreateTestData() throws Exception {
		testDataCreator.setDataProvider(dataProvider);
		testDataCreator.create();
	}

}
