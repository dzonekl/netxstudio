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
package com.netxforge.netxstudio.data.cdo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.net4j.util.security.IPasswordCredentialsProvider;
import org.eclipse.net4j.util.security.PasswordCredentials;
import org.eclipse.net4j.util.security.PasswordCredentialsProvider;
import org.eclipse.net4j.util.transaction.TransactionException;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.NetxstudioFactory;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * A CDO Data provider, which gets data from a CDO Server. The CDO provider has
 * some special requirements. - It require to initialize a connection.
 * 
 * Note: One single data provider, is associated with one single user/session.
 * The session is static.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
@Singleton
public class CDODataProvider implements IDataProvider, IFixtures {

	private List<EPackage> ePackages = new ArrayList<EPackage>();
	private ICDOConnection connection;
//	private String loggedInUser;

	@Inject
	public CDODataProvider(ICDOConnection conn) {
		this.connection = conn;

		ePackages.add(GeoPackage.eINSTANCE);
		ePackages.add(GenericsPackage.eINSTANCE);
		ePackages.add(NetxstudioPackage.eINSTANCE);
		ePackages.add(LibraryPackage.eINSTANCE);
		ePackages.add(MetricsPackage.eINSTANCE);
		ePackages.add(OperatorsPackage.eINSTANCE);
		ePackages.add(ProtocolsPackage.eINSTANCE);
		ePackages.add(SchedulingPackage.eINSTANCE);
		ePackages.add(ServicesPackage.eINSTANCE);
	}

	public String getSessionUserID() {
		return this.getSession().getUserID();
	}

	/**
	 * Our session, we keep it final, as Google Guice, Singleton instantiates
	 * another instance.
	 */
	private static CDOSession clientSession = null;

	public void openSession(String uid, String passwd) throws SecurityException {

		if (connection.getConfig() == null) {
			connection.initialize();
		}

		// Session Config and Sessions go hand in hand.
		// Recover our session, if some reason we try to reopen for the same
		// user and
		// this very same config.
		if (connection.getConfig().isSessionOpen()) {
			CDOSession openSession = connection.getConfig().openSession();
			clientSession = openSession;
			return;
		}

		IPasswordCredentialsProvider credentialsProvider = new PasswordCredentialsProvider(
				new PasswordCredentials(uid, passwd.toCharArray()));

		connection.getConfig().getAuthenticator()
				.setCredentialsProvider(credentialsProvider);

		try {
			clientSession = connection.getConfig().openSession();
			for (EPackage ePackage : ePackages) {
				clientSession.getPackageRegistry().putEPackage(ePackage);
			}
		} catch (SecurityException se) {
			throw new SecurityException(se);
		}
	}

	/**
	 * Close the session.
	 */
	public void closeSession() {
		if (clientSession != null) {
			if (!clientSession.isClosed()) {
				clientSession.close();
			}
		}
	}

	public CDOSession getSession() {
		if (clientSession == null) {
			// We can't get a session, which has not be opened and
			// authenticated.
			throw new java.lang.IllegalStateException();
		} else {
			System.out.println("Currrent session instance:"
					+ clientSession.toString());
			return clientSession;
		}
	}

	/**
	 * Opens a CDOSession, does not register an EPackage with the session. This
	 * should be done by the caller.
	 */
	protected CDOSession openSession() {
		if (connection.getConfig() == null) {
			connection.initialize();
		}
		final CDOSession cdoSession = connection.getConfig().openSession();
		for (EPackage ePackage : ePackages) {
			cdoSession.getPackageRegistry().putEPackage(ePackage);
		}
		return cdoSession;
	}

	public Resource getResource(ResourceSet set, int feature) {

		String res = resolveResourceName(feature);
		assert res != null && res.length() > 0;

		// Before attempting to open a new CDOView, we want to know what is
		// already
		// in our session and resource set.
		CDOView[] views = this.getSession().getViews();
		for (int i = 0; i < views.length; i++) {
			CDOView view = views[i];
			if (view.getResourceSet().equals(set)) {
				CDOResource resource = view.getResource(res);
				if (resource != null) {
					return resource;
				}
			}
		}

		// We haven't found this resource in the current view's and set's,
		// OK create a new one.
		CDOTransaction transaction = getSession().openTransaction(set);
		CDOResource resource = transaction.getOrCreateResource(res);
		return resource;
	}

	/**
	 * Dispatcher to break-up which objects go into which resources.
	 * 
	 * @param feature
	 * @return
	 */
	private String resolveResourceName(int feature) {
		String resource = "/";
		// We switch on the resource to use.
		switch (feature) {
		case NetxstudioPackage.NETXSTUDIO: {
			resource += "netxstudio";
		}
			break;
		case LibraryPackage.LIBRARY: {
			resource += "library";
		}
		}
		return resource;
	}

	public EObject getNetXScriptWrapper() {
		// NetXScriptWrapper wrapper =
		// XtextwrapperFactory.eINSTANCE.createNetXScriptWrapper();
		// wrapper.setAsString("");
		// wrapper.setXblock(XbaseFactory.eINSTANCE.createXBlockExpression());
		// return wrapper;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataProvider#getResource(int)
	 */
	public Resource getResource(int feature) {
		String res = resolveResourceName(feature);
		assert res != null && res.length() > 0;

		CDOView[] views = this.getSession().getViews();
		for (int i = 0; i < views.length; i++) {
			CDOView view = views[i];
			CDOResource resource = view.getResource(res);
			if (resource != null) {
				return resource;
			}
		}

		CDOTransaction transaction = getSession().openTransaction();
		CDOResource resource = transaction.getOrCreateResource(res);

		return resource;

	}

	public void loadFixtures() {

		CDOResource res = (CDOResource) getResource(NetxstudioPackage.NETXSTUDIO);
		CDOView view = res.cdoView();

		res.getContents().clear();
		Netxstudio studio = NetxstudioFactory.eINSTANCE.createNetxstudio();

		// Add the fixture roles.
		{
			Role r = GenericsFactory.eINSTANCE.createRole();
			r.setName(ROLE_ADMIN);
			studio.getRoles().add(r);
			
			// Make Tom an Admin. 
			Person p = GenericsFactory.eINSTANCE.createPerson();
			p.setLogin("tom");
			p.setRoles(r);
			studio.getUsers().add(p);
		}
		{
			Role r = GenericsFactory.eINSTANCE.createRole();
			r.setName(ROLE_PLANNER);
			studio.getRoles().add(r);
		}
		{
			Role r = GenericsFactory.eINSTANCE.createRole();
			r.setName(ROLE_READONLY);
			studio.getRoles().add(r);
		}

		res.getContents().add(studio);

		// TODO, add some actions.
		@SuppressWarnings("unused")
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		try {
			res.save(null);
		} catch (TransactionException e) {
			// TODO, some rollback of the transaction.
			// See CDO Editor.
			((CDOTransaction) view).rollback();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
