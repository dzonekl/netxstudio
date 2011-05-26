/*******************************************************************************
 * Copyright (c) May 17, 2011 NetXForge.
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
package com.netxforge.netxstudio.data.cdo;

import java.util.List;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOQuery;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IRoleHandler;
import com.netxforge.netxstudio.generics.Role;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public class CDORoleHandler implements IRoleHandler {
	
	private IDataProvider provider;
	
	@Inject
	public CDORoleHandler(IDataProvider dataProvider){
		this.provider = dataProvider;
	}
	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.cdo.ICDORoleHandler#getRole(java.lang.String)
	 */
	public List<Role> getRole(String userID) {
		
		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql", ICDOQueries.SELECT_ROLES_FROM_PERSON);
		q.setParameter("name", userID);
		CDOQueryUtil.addCacheParameter(q);
		return q.getResult(Role.class);
	}
	public Role getCurrentRole() {
		
		String userID = provider.getSessionUserID();
		List<Role> roles = this.getRole(userID);
		if(roles.size()!= 1 ){
			throw new java.lang.IllegalStateException("Data corruption, user +" + userID + "should have a role defined");
		}else{
			return roles.get(0);
		}
	}
	
	
}
