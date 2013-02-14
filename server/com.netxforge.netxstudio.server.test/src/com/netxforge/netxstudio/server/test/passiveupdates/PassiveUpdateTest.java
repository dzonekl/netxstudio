/*******************************************************************************
 * Copyright (c) 13 feb. 2013 NetXForge.
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
package com.netxforge.netxstudio.server.test.passiveupdates;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.server.test.AbstractInjectedTestJUnit3;


/**
 * This test case creates a Server sessions which adds objects and a client 
 * session which reads object. This is to trace CDO errors. 
 * 
 * @author Christophe Bouhier
 *
 */
public class PassiveUpdateTest extends AbstractInjectedTestJUnit3 {

	IDataService service;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		 service = super.getInjector().getInstance(IDataService.class);
	}
	public void testConnection() throws Exception {
		// Open and close the session with an admin user. 
		service.getProvider().openSession("admin", "admin");
		service.getProvider().closeSession();
	}
	
	public void testFeatureAccessWithoutResourceSet() throws Exception {
		// Open and close the session with an admin user. 
		service.getProvider().openSession("admin", "admin");
		
		Resource res = service.getProvider().getResource(NetxstudioPackage.Literals.NETXSTUDIO);
		
		assertNotNull(res);
		assertTrue(res instanceof CDOResource);
		
		URI uri = res.getURI();
		System.out.println(uri.toString());
		service.getProvider().closeSession();
	}
	
}
