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
package com.netxforge.netxstudio.server;

import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.spi.server.RepositoryUserManager;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.net4j.util.factory.ProductCreationException;
import org.eclipse.net4j.util.security.UserManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.server.internal.ServerActivator;

/**
 * Implements the CDO {@link UserManager} which reads user information from the
 * database. The CDO {@link org.eclipse.net4j.util.factory.Factory factory} is satisfied by 
 * instantiation through DI. 
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
@Singleton
public class NetxForgeUserManager extends RepositoryUserManager {

	private IServerUtils serverUtils;

	@Inject
	public NetxForgeUserManager(IServerUtils serverUtils) {
		this.serverUtils = serverUtils;

	}

	public static final String TYPE = "NetxForgeUserManager";

	public static class Factory extends RepositoryUserManagerFactory {
		public Factory() {
			// Must match the type attribute in plugin.xml
			super(TYPE);
		}

		@Override
		protected RepositoryUserManager doCreate(String description)
				throws ProductCreationException {
			return ServerActivator.getInstance().getInjector()
					.getInstance(RepositoryUserManager.class);
		}
	}

	@Override
	protected char[] getPassword(IRepository repository, String userID) {
		serverUtils.checkRepositorySupported(repository);

		if (userID.equals("admin")) {
			return "admin".toCharArray();
		}

		if (userID.equals(serverUtils.getServerSideLogin())) {
			return serverUtils.getServerSideLogin().toCharArray();
		}
		
		// Triggers another login check.
		final CDOSession session = serverUtils.openJVMSession();
		final CDOTransaction transaction = session.openTransaction();
		try {

			CDOResource resource = transaction.getResource("/"
					+ GenericsPackage.Literals.PERSON.getName());

			List<Person> people = new ModelUtils.CollectionForObjects<Person>()
					.collectionForObjects(resource.getContents());
			String pwd = null;
			// find the user.
			for (Person p : people) {
				if (userID.equals(p.getLogin())) {
					if (!p.isActive()) {
						return null; // will not authenticate
					}
					pwd = p.getPassword();

				}
			}
			if (pwd == null) {
				return null;
			}
			return pwd.toCharArray();
		} finally {
			try {
				transaction.commit();
			} catch (final Exception e) {
				throw new IllegalStateException(e);
			}
			transaction.close();
			session.close();
		}
	}
}
