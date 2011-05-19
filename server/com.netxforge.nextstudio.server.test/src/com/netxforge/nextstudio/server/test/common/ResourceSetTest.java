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
package com.netxforge.nextstudio.server.test.common;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.GeoFactory;
import com.netxforge.nextstudio.server.test.base.BaseAuthTest;
import com.netxforge.nextstudio.server.test.base.BaseTest;

/**
 * A Test showing persisting of data using an editing domain and a resource set.
 * The test also show the undo and redo command. 
 *  
 * To run these tests the CDO server has to be
 * started on tcp port 2036. This can be accomplished by using the CDOHibernateServer.launch configuration which makes
 * use of the cdo-server.xml config file in the config directory.
 * <p/>
 * The connection logic resides in the {@link BaseTest} parent class.
 *
 * @author Martin Taal
 */
public class ResourceSetTest extends BaseAuthTest
{

  /**
   * Simple test that opens a connection gets a resource and creates an address
   */
  public void testCreatePersist() throws Exception
  {
    // first create an address and persist it
    final String name = "name " + System.currentTimeMillis(); //$NON-NLS-1$
    {
      final CDOSession session = openSession();
      
      
      // Create an EMF adapter factory which constructed from the registered adapter factoy descriptors. 
      // as by extension:  <extension point="org.eclipse.emf.edit.itemProviderAdapterFactories">
      final ComposedAdapterFactory emfEditAdapterFactory = new ComposedAdapterFactory(
  					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
      
      final BasicCommandStack commandStack = new BasicCommandStack();
      
      // Create the editing domain and 
      final AdapterFactoryEditingDomain domain = new AdapterFactoryEditingDomain(emfEditAdapterFactory,commandStack);
      
      final CDOTransaction transaction = session.openTransaction(domain.getResourceSet());
      
      // get/create a resource, in the resourceset. 
      final CDOResource resource = transaction.getOrCreateResource("/test1"); //$NON-NLS-1$
      
      // Our CDO resource should be contained in the resource set. 
      assert domain.getResourceSet().getResources().size() > 0;
      
      // clear any previous data
      resource.getContents().clear();

      // Create an object and add it to the resource, using the edit framework. 
      final Country country = GeoFactory.eINSTANCE.createCountry();
      country.setCountryCode("NL"); //$NON-NLS-1$
      country.setName(name);
      
      // Use the edit framework 
      final Command c = new AddCommand(domain, resource.getContents(), country);
      assert !(c instanceof UnexecutableCommand);
      if(c.canExecute()){
    	  domain.getCommandStack().execute(c);
      }
      
      if(((BasicCommandStack)domain.getCommandStack()).isSaveNeeded()){
    	  // Something was added.
    	  final EObject whatwasadded = resource.getContents().get(0);
    	  assert whatwasadded != null && whatwasadded instanceof Country;
    	  
      }else{
    	  // test fails. 
    	  fail();
      }
      
      // When undoing our resourceset should be empty. 
      if(domain.getCommandStack().canUndo())
    	  domain.getCommandStack().undo();
      
      assert resource.getContents().size() == 0;
      
      // When redoing our object should be back. 
      if(domain.getCommandStack().canRedo())
    	  domain.getCommandStack().redo();
      
      transaction.commit();
    }

    // read back and do some tests
    {
      final CDOSession session = openSession();
      final CDOTransaction transaction = session.openTransaction();
      
      final CDOResource resource = transaction.getResource("/test1"); //$NON-NLS-1$
      assertEquals(true, resource.getContents().get(0) instanceof Country);
      assertEquals(1, resource.getContents().size());
      final Country address = (Country)resource.getContents().get(0);
      assertEquals(name, address.getName());
      transaction.commit();
    }
  }
}
