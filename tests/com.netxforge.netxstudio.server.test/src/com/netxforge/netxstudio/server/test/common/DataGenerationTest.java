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

import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

/**
 * Generates test data for the available epackages.
 * 
 * @author Martin Taal
 */
public class DataGenerationTest extends AbstractInjectedTestJUnit4 {

	@Inject
	private ICDODataService dataService;

	@Before
	public void before() {
		this.getClientInjector().injectMembers(this);
	}

	/**
	 * Generates data and persists it.
	 */
	@Test
	public void testGenerateData() throws Exception {

		this.dataService.getCDOData().openSession("admin", "admin");
		final CDOSession session = this.dataService.getCDOData().getSession();

		int persistedSize = 0;
		{

			final CDOTransaction transaction = session.openTransaction();

			// get/create a resource
			final CDOResource resource = transaction
					.getOrCreateResource("/test1"); //$NON-NLS-1$

			// clear any previous data
			resource.getContents().clear();

			resource.getContents().addAll(getTestData());
			transaction.commit();
			persistedSize = resource.getContents().size();
		}

		// read back and do some tests
		{
			final CDOTransaction transaction = session.openTransaction();
			final CDOResource resource = transaction.getResource("/test1"); //$NON-NLS-1$
			Assert.assertEquals(persistedSize, resource.getContents().size());
			transaction.commit();
		}
		session.close();
	}

	private List<EObject> getTestData() {
		throw new IllegalStateException(
				"Need to add dependency on datagenerator");
		// final ModelDataGenerator modelDataGenerator = new
		// ModelDataGenerator();
		// modelDataGenerator.setStartEClasses(getAllEClasses());
		// modelDataGenerator.setMaxDepth(3);
		// modelDataGenerator.setUseDynamicEnums(false);
		// modelDataGenerator.setCollectionSize(5);
		// modelDataGenerator.setDataSize(5);
		// modelDataGenerator.setMaxObjects(1000);
		// modelDataGenerator.setEPackages(getEPackages());
		// modelDataGenerator.generateTestData();
		// System.err.println("Generated " +
		// modelDataGenerator.getTotalObjectCount() + " objects ");
		// final List<EObject> result = modelDataGenerator.getResult();
		// return result;
	}
}
