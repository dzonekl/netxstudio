/*******************************************************************************
 * Copyright (c) 10 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.data.cdo;

import java.util.List;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;

/**
 * Provides convenience methods on top of {@link ICDOData} which is instantiated
 * here. As we use a {@link ClientCDODataProvider static provider}, we should
 * ensure the session is already open. Also an {@link CDOTransaction
 * transaction} which is opened will not be closed it is the clients
 * responsibility to close it.
 * 
 * @author Christophe Bouhier
 * 
 */
public class CDODataService implements ICDODataService {

	
	private ICDOData data;
	
	@Inject
	public CDODataService(ClientCDODataProvider provider) {
		data = provider.get();
	}

	public Role getCurrentRole() {

		final String currentUser = data.getSessionUserID();
		final Resource resource = data
				.getResource(GenericsPackage.Literals.PERSON);
		final List<Person> people = new StudioUtils.CollectionForObjects<Person>()
				.collectionForObjects(resource.getContents());
		final Role r = StudioUtils.roleForUserWithName(currentUser, people);
		return r;
	}

	public String getServer() {
		return data.getServer();
	}

	public ICDOData getCDOData() {
		return data;
	}

}
