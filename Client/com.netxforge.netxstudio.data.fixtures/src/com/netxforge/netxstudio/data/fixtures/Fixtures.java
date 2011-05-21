/*******************************************************************************
 * Copyright (c) May 18, 2011 NetXForge.
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
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.data.fixtures;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.net4j.util.transaction.TransactionException;

import com.google.inject.Inject;
import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.NetxstudioFactory;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.fixtures.internal.FixturesActivator;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Role;

/**
 * NetXStudio fixture data.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class Fixtures implements IFixtures {
	
	
	IDataService dService;

	
	@Inject
	public Fixtures(IDataService dataService){
		this.dService = dataService;
	}
	
	
	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.fixtures.IFixtures#loadFixtures()
	 */
	public void loadFixtures(){
		
		dService.getProvider().openSession("fixture", "fixture");
		CDOResource res = (CDOResource) dService.getProvider().getResource(NetxstudioPackage.NETXSTUDIO);
		CDOView view = res.cdoView();
		
		res.getContents().clear();
		Netxstudio studio = NetxstudioFactory.eINSTANCE.createNetxstudio();
		
		// Add the fixture roles. 
		Role r = GenericsFactory.eINSTANCE.createRole();
		r.setName(ROLE_ADMIN);
		studio.getRoles().add(r);
		r = GenericsFactory.eINSTANCE.createRole();
		r.setName(ROLE_PLANNER);
		studio.getRoles().add(r);
		r = GenericsFactory.eINSTANCE.createRole();
		r.setName(ROLE_READONLY);
		studio.getRoles().add(r);
		
		res.getContents().add(studio);
		
		
		// TODO, add some actions.
		@SuppressWarnings("unused")
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		try {
			res.save(null);
			FixturesActivator.logInfo("Fixtures loaded");
		} catch (TransactionException e) {
			// TODO, some rollback of the transaction. 
			// See CDO Editor. 
			((CDOTransaction)view).rollback();
		} catch (IOException e) {
			e.printStackTrace();
			FixturesActivator.logInfo("Error loading Fixtures");
		}
	}
	
}
