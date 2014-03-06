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
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;

/**
 * A data service implementation.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class DataService implements IDataService {

	private final IQueryService queryService;
	
	
	@Inject
	public DataService(IQueryService queryService) {
		this.queryService = queryService;
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
		String currentUser = data.getSessionUserID();
		Resource resource = data
				.getResource(GenericsPackage.Literals.PERSON);
		final List<Person> people = new StudioUtils.CollectionForObjects<Person>()
				.collectionForObjects(resource.getContents());
		Role r = StudioUtils.roleForUserWithName(currentUser, people);
		return r;
	}

	public String getServer() {
		return data.getServer();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(data.toString());
		return sb.toString();
	}
	
	

}
