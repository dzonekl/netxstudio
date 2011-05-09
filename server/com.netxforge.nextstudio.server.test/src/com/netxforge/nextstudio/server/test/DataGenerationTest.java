/*******************************************************************************
 * Copyright (c) Apr 26, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.nextstudio.server.test;

import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.texo.datagenerator.ModelDataGenerator;

/**
 * Generates test data for the available epackages.
 *
 * @author Martin Taal
 */
public class DataGenerationTest extends BaseTest
{

  /**
   * Generates data and persists it.
   */
  public void testGenerateData() throws Exception
  {
	int persistedSize = 0;
    {
      final CDOSession session = openSession();
      final CDOTransaction transaction = session.openTransaction();

      // get/create a resource
      CDOResource resource = transaction.getOrCreateResource("/test1"); //$NON-NLS-1$

      // clear any previous data
      resource.getContents().clear();

      resource.getContents().addAll(getTestData());      
      transaction.commit();
      persistedSize = resource.getContents().size();
    }

    // read back and do some tests
    {
      final CDOSession session = openSession();
      final CDOTransaction transaction = session.openTransaction();
      CDOResource resource = transaction.getResource("/test1"); //$NON-NLS-1$
      assertEquals(persistedSize, resource.getContents().size());
      transaction.commit();
    }
  }
  
  private List<EObject> getTestData() {
	  final ModelDataGenerator modelDataGenerator = new ModelDataGenerator();
	  modelDataGenerator.setStartEClasses(getAllEClasses());
	  modelDataGenerator.setMaxDepth(3);
	  modelDataGenerator.setUseDynamicEnums(false);
	  modelDataGenerator.setCollectionSize(3);
	  modelDataGenerator.setDataSize(3);
	  modelDataGenerator.setMaxObjects(1000);
	  modelDataGenerator.setEPackages(getEPackages());
	  modelDataGenerator.generateTestData();
	  System.err.println("Generated " + modelDataGenerator.getTotalObjectCount() + " objects ");
	  final List<EObject> result = modelDataGenerator.getResult();
	  return result;
  }
}
