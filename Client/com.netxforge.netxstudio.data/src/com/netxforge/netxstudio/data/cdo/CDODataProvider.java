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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.net4j.util.security.IPasswordCredentialsProvider;
import org.eclipse.net4j.util.security.PasswordCredentials;
import org.eclipse.net4j.util.security.PasswordCredentialsProvider;
import org.eclipse.net4j.util.transaction.TransactionException;

import com.google.inject.Inject;
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
public abstract class CDODataProvider implements IDataProvider, IFixtures {

	private List<EPackage> ePackages = new ArrayList<EPackage>();
	private ICDOConnection connection;

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

	public void openSession(String uid, String passwd) throws SecurityException {

		if (connection.getConfig() == null) {
			connection.initialize();
		}

		// Session Config and Sessions go hand in hand.
		// Recover our session, if some reason we try to reopen for the same
		// user and
		// this very same config.
		if (connection.getConfig().isSessionOpen()) {
			final CDOSession openSession = connection.getConfig().openSession();
			setSession(openSession);
			return;
		}

		final IPasswordCredentialsProvider credentialsProvider = new PasswordCredentialsProvider(
				new PasswordCredentials(uid, passwd.toCharArray()));

		connection.getConfig().getAuthenticator()
				.setCredentialsProvider(credentialsProvider);

		try {
			setSession(connection.getConfig().openSession());
			for (final EPackage ePackage : ePackages) {
				getSession().getPackageRegistry().putEPackage(ePackage);
			}
		} catch (final SecurityException se) {
			throw new SecurityException(se);
		}
	}

	public abstract CDOSession getSession();

	public abstract CDOTransaction getTransaction();

	protected abstract boolean isTransactionSet();

	protected abstract void setSession(CDOSession session);

	protected abstract void setTransaction(CDOTransaction transaction);

	/**
	 * Close the session.
	 */
	public void closeSession() {
		if (getSession() != null) {
			if (!getSession().isClosed()) {
				getSession().close();
			}
			setSession(null);
		}
	}

	/**
	 * Opens a CDOSession without credentials unless the connection already
	 * handles this.
	 */
	public CDOSession openSession() {
		if (connection.getConfig() == null) {
			connection.initialize();
		}
		final CDOSession cdoSession = connection.getConfig().openSession();
		for (final EPackage ePackage : ePackages) {
			cdoSession.getPackageRegistry().putEPackage(ePackage);
		}
		setSession(cdoSession);
		return cdoSession;
	}

	public Resource getResource(ResourceSet set, EClass feature) {
		final String res = resolveResourceName(feature);
		return getResource(set, res);
	}

	public Resource getResource(ResourceSet set, int feature) {
		final String res = resolveResourceName(feature);
		return getResource(set, res);
	}

	private Resource getResource(ResourceSet set, String resourcePath) {
		assert resourcePath != null && resourcePath.length() > 0;

		// Before attempting to open a new CDOView, we want to know what is
		// already
		// in our session and resource set.
		final CDOView[] views = this.getSession().getViews();

		// FIXME, we seem to have multiple views????
		// if(views.length > 1){
		// // How can we have multiple views??
		// throw new java.lang.IllegalArgumentException();
		// }

		for (int i = 0; i < views.length; i++) {
			final CDOView view = views[i];
			if (view.getResourceSet().equals(set)) {
				if (view.hasResource(resourcePath)) {
					final CDOResource resource = view.getResource(resourcePath);
					return resource;
				}
				// We haven't found this resource in the current view's set,
				// but we can't create a new getTransaction(), so we have to see
				// if
				// the
				// the CDOView has a getTransaction().
				if (view instanceof CDOTransaction) {
					final CDOTransaction transaction = (CDOTransaction) view;
					final CDOResource resource = transaction
							.getOrCreateResource(resourcePath);
					return resource;
				}
			}
		}

		// We don't have a view, so let's open one.
		final CDOTransaction transaction = getSession().openTransaction(set);
		final CDOResource resource = transaction
				.getOrCreateResource(resourcePath);
		return resource;
	}

	public Resource getResource(CDOView view, EClass feature) {
		final String res = resolveResourceName(feature);
		return getResource(view, res);
	}

	public Resource getResource(CDOView view, String res) {

		assert res != null && res.length() > 0;

		// Before attempting to open a new CDOView, we want to know what is
		// already
		// in our session and resource set.
		if (view.getResourceSet() != null) {
			if (view.hasResource(res)) {
				final CDOResource resource = view.getResource(res);
				return resource;
			}
		} else {
			return null; // We need a resourceset.
		}

		// We haven't found this resource in the current view's and set's,
		// but we can't create a new getTransaction(), so we have to see if the
		// the CDOView has a getTransaction().
		if (view instanceof CDOTransaction) {
			final CDOTransaction transaction = (CDOTransaction) view;
			// Should create in the set.
			final CDOResource resource = transaction.getOrCreateResource(res);
			return resource;
		}
		return null;
	}

	private String resolveResourceName(EClass clazz) {
		return "/" + clazz.getName();
	}

	/**
	 * Dispatcher to break-up which objects go into which resources.
	 * 
	 * @deprecated
	 * @param feature
	 * @return
	 */
	@Deprecated
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
			break;
		}
		return resource;
	}

	private String resolveResourceCommitInfo(String userID) {
		return "CDOCommitInfo_" + userID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataProvider#getResource(int)
	 */
	public Resource getResource(int feature) {
		final String res = resolveResourceName(feature);
		assert res != null && res.length() > 0;
		return this.getResource(res);
	}

	public Resource getResource(EClass feature) {
		final String res = resolveResourceName(feature);
		assert res != null && res.length() > 0;
		return this.getResource(res);
	}

	public Resource getCommitInfoResource(String userID) {
		final String resourceName = this.resolveResourceCommitInfo(userID);
		CDOResource resource = this.resolveInCurrentView(resourceName);
		if (resource == null) {
			final CDOTransaction transaction = getSession().openTransaction();
			resource = transaction.getOrCreateResource(resourceName);
		}
		return resource;
	}

	private Resource getResource(String resourceName) {
		CDOResource resource = resolveInCurrentView(resourceName);

		if (resource == null) {
			if (createResourceInSeparateTransaction()) {
				final CDOTransaction transaction = getSession()
						.openTransaction();
				resource = transaction.getOrCreateResource(resourceName);
			} else {
				resource = getTransaction().getOrCreateResource(resourceName);
			}
		}
		return resource;
	}

	protected boolean createResourceInSeparateTransaction() {
		return true;
	}

	private CDOResource resolveInCurrentView(String resourceName) {
		final CDOView[] views = this.getSession().getViews();
		for (int i = 0; i < views.length; i++) {
			final CDOView view = views[i];
			if (view.hasResource(resourceName)) {
				final CDOResource resource = view.getResource(resourceName);
				if (resource != null) {
					return resource;
				}
			}
		}
		return null;
	}

	public void loadFixtures() {

		final CDOResource res = (CDOResource) getResource(NetxstudioPackage.NETXSTUDIO);
		final CDOView view = res.cdoView();

		// Should do some basic import data validation.
		if (res.getContents() != null && (res.getContents().size() > 0)) {
			if (res.getContents().get(0) instanceof Netxstudio) {
				return;
			}
		}

		// Anything else than checked before, is bogus so we start from scratch.
		res.getContents().clear();
		final Netxstudio studio = NetxstudioFactory.eINSTANCE
				.createNetxstudio();

		// Add the fixture roles.
		{
			final Role r = GenericsFactory.eINSTANCE.createRole();
			r.setName(ROLE_ADMIN);
			studio.getRoles().add(r);

			// FIXME, the admin user is hard coded for now.
			{
				final Person p = GenericsFactory.eINSTANCE.createPerson();
				p.setLogin("admin");
				p.setFirstName("admin");
				p.setLastName("admin");
				// p.setPassword("admin");
				p.setActive(true);
				p.setRoles(r);
				studio.getUsers().add(p);
			}
		}
		{
			final Role r = GenericsFactory.eINSTANCE.createRole();
			r.setName(ROLE_PLANNER);
			studio.getRoles().add(r);
		}
		{
			final Role r = GenericsFactory.eINSTANCE.createRole();
			r.setName(ROLE_READONLY);
			studio.getRoles().add(r);
		}

		res.getContents().add(studio);

		@SuppressWarnings("unused")
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		try {
			res.save(null);
		} catch (final TransactionException e) {
			((CDOTransaction) view).rollback();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public CDOTransaction getgetTransaction() {
		if (getTransaction() == null) {
			setTransaction(getSession().openTransaction());
		}
		return getTransaction();
	}

	public void commitTransaction() {
		try {
			if (isTransactionSet()) {
				getTransaction().commit();
			}
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		} finally {
			setTransaction(null);
		}
	}

	public void rollbackTransaction() {
		try {
			if (isTransactionSet()) {
				getTransaction().rollback();
			}
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		} finally {
			setTransaction(null);
		}
	}

}
