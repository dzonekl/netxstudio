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
package com.netxforge.nextstudio.server;

import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.hibernate.IHibernateStore;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;
import org.eclipse.emf.cdo.spi.server.RepositoryUserManager;
import org.eclipse.net4j.util.factory.ProductCreationException;
import org.eclipse.net4j.util.security.UserManager;
import org.hibernate.Query;
import org.hibernate.Session;

import com.netxforge.netxstudio.generics.GenericsPackage;

/**
 * Implements the CDO {@link UserManager} which reads user information from the
 * database.
 * 
 * @author Martin Taal
 */
public class NetxForgeUserManager extends RepositoryUserManager {
	
	public static final String TYPE = "NetxForgeUserManager";
	
	public static class Factory extends RepositoryUserManagerFactory {
		public Factory() {
			// Must match the type attribute in plugin.xml
			super(TYPE);
		}

		@Override
		protected RepositoryUserManager doCreate(String description)
				throws ProductCreationException {
			return new NetxForgeUserManager();
		}
	}
	
	@Override
	protected char[] getPassword(IRepository repository, String userID) {
		if (userID.equals("admin")) {
			return "admin".toCharArray();
		}
		final IHibernateStore hbStore = (IHibernateStore) repository.getStore();
		final Session session = hbStore.getHibernateSessionFactory()
				.openSession();
		final Query qry = session
				.createQuery("select p from Person p where login=?");
		qry.setParameter(0, userID);
		if (qry.list().size() != 1) {
			return null;
		}
		final InternalCDORevision cdoRevision = (InternalCDORevision) qry
				.list().get(0);
		final String pwd = (String) cdoRevision.get(
				GenericsPackage.eINSTANCE.getPerson_Password(), -1);
		final boolean active = (Boolean) cdoRevision.get(
				GenericsPackage.eINSTANCE.getPerson_Active(), -1);
		if (!active) {
			return null;
		}
		if (pwd == null) {
			return null;
		}
		return pwd.toCharArray();
	}
}
