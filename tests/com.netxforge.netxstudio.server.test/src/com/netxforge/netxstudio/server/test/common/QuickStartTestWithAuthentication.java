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
package com.netxforge.netxstudio.server.test.common;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.GeoFactory;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.Unit;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

/**
 * A quick test to show creating and persisting some data in the repository. To
 * run these tests the CDO server has to be started on tcp port 2036. This can
 * be accomplished by using the CDOHibernateServer.launch configuration which
 * makes use of the cdo-server.xml config file in the config directory.
 * <p/>
 * The connection logic resides in the {@link BaseTest} parent class.
 * 
 * @author Martin Taal
 */
public class QuickStartTestWithAuthentication extends
		AbstractInjectedTestJUnit4 {

	@Inject
	private ICDODataService dataService;

	@Before
	public void before() {
		super.getClientInjector().injectMembers(this);
	}

	/**
	 * Simple test that opens a connection gets a resource and creates an
	 * address
	 */
	@Test
	public void testCreatePersist() throws Exception {

		dataService.getCDOData().openSession("tom", "123");
		final CDOSession session = dataService.getCDOData().getSession();

		// first create an address and persist it
		final String name = "name " + System.currentTimeMillis(); //$NON-NLS-1$
		{

			final CDOTransaction transaction = session.openTransaction();

			// get/create a resource
			final CDOResource resource = transaction
					.getOrCreateResource("/test1"); //$NON-NLS-1$

			// clear any previous data
			resource.getContents().clear();

			final Country country = GeoFactory.eINSTANCE.createCountry();
			country.setCountryCode("NL"); //$NON-NLS-1$
			country.setName(name);
			resource.getContents().add(country);

			final Unit unit = LibraryFactory.eINSTANCE.createUnit();
			unit.setName(name);
			unit.setCode("m");
			unit.setDescription("description");
			resource.getContents().add(unit);
			transaction.commit();
		}

		// read back and do some tests
		{
			final CDOTransaction transaction = session.openTransaction();
			final CDOResource resource = transaction.getResource("/test1"); //$NON-NLS-1$
			Assert.assertEquals(true, resource.getContents().get(0) instanceof Country);
			Assert.assertEquals(2, resource.getContents().size());
			final Country address = (Country) resource.getContents().get(0);
			Assert.assertEquals(name, address.getName());
			transaction.commit();
		}
	}
}
