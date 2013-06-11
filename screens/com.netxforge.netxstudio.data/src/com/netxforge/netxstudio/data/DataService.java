/*******************************************************************************
 * Copyright (c) May 3, 2011 NetXForge.
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
package com.netxforge.netxstudio.data;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;

/**
 * A data service implementation.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class DataService implements IDataService {

	private final IDataProvider provider;
	private final IQueryService queryService;
	private ModelUtils modelUtils;

	@Inject
	public DataService(IDataProvider provider, IQueryService queryService,
			ModelUtils modelUtils) {
		this.provider = provider;
		this.queryService = queryService;
		this.modelUtils = modelUtils;
	}

	public IDataProvider getProvider() {
		return provider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataService#getRoleHandler()
	 */
	public IQueryService getQueryService() {
		return queryService;
	}

	public Role getCurrentRole() {
		String currentUser = provider.getSessionUserID();
		Resource resource = provider
				.getResource(GenericsPackage.Literals.PERSON);
		List<Person> people = new ModelUtils.CollectionForObjects<Person>()
				.collectionForObjects(resource.getContents());
		Role r = modelUtils.roleForUserWithName(currentUser, people);
		return r;
	}

	public String getServer() {
		return provider.getServer();
	}

}
