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

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.net4j.util.transaction.TransactionException;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.NetxstudioFactory;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;

/**
 * A CDO Data provider, for single threaded clients. The session and transaction
 * are stored in a static member and this object is a singleton.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
@Singleton
public class ClientCDODataProvider extends CDODataProvider implements IFixtures{
	
	
	@Inject
	ModelUtils modelUtils;
	
	@Inject
	public ClientCDODataProvider(ICDOConnection conn) {
		super(conn);
	}

	private static CDOSession session = null;

	private static CDOTransaction transaction = null;

	@Override
	public CDOSession getSession() {
		if (session == null) {
			// We can't get a session, which has not be opened and
			// authenticated.
			throw new java.lang.IllegalStateException();
		} else {
			// System.out.println("Currrent session instance:"
			// + clientSession.toString());
			return session;
		}
	}

	@Override
	public CDOTransaction getTransaction() {
		if (transaction == null) {
			transaction = getSession().openTransaction();
		}
		return transaction;
	}

	@Override
	protected boolean isTransactionSet() {
		return transaction != null;
	}

	@Override
	protected void setSession(CDOSession session) {
		ClientCDODataProvider.session = session;
	}

	@Override
	protected void setTransaction(CDOTransaction transaction) {
		ClientCDODataProvider.transaction = transaction;
	}
	
	// FIXME, move this to the test data. 
	public void loadFixtures(){
		loadSettings();
		loadRoles();
//		loadLibrary();
	}
	
	private void loadSettings() {
		final CDOResource settingsResource = (CDOResource) getResource(NetxstudioPackage.Literals.SERVER_SETTINGS);
		if(settingsResource.getContents().size() > 0){
			return;
		}
		ServerSettings serverSettings = NetxstudioFactory.eINSTANCE.createServerSettings();
		serverSettings.setExportPath("/Users/dzonekl/Documents/Projects/NetXStudio/Reports");
		serverSettings.setImportPath("/Users/dzonekl/Documents/Projects/NetXStudio/TestData");
		settingsResource.getContents().add(serverSettings);
		try {
			settingsResource.save(null);
		} catch (final TransactionException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	private void loadRoles() {
		final CDOResource rolesResource = (CDOResource) getResource(GenericsPackage.Literals.ROLE);
		if(rolesResource.getContents().size() > 0){
			return;
		}
		
		final CDOResource userResource = (CDOResource) getResource(GenericsPackage.Literals.PERSON);
		// Add the fixture roles.
		{
			final Role r = GenericsFactory.eINSTANCE.createRole();
			r.setName(ROLE_ADMIN);
			rolesResource.getContents().add(r);

			// FIXME, the admin user is hard coded for now.
			{
				final Person p = GenericsFactory.eINSTANCE.createPerson();
				p.setLogin("admin");
				p.setFirstName("admin");
				p.setLastName("admin");
				// p.setPassword("admin");
				p.setActive(true);
				p.setRoles(r);
				userResource.getContents().add(p);
			}
		}
		{
			final Role r = GenericsFactory.eINSTANCE.createRole();
			r.setName(ROLE_PLANNER);
			rolesResource.getContents().add(r);
		}
		{
			final Role r = GenericsFactory.eINSTANCE.createRole();
			r.setName(ROLE_READONLY);
			rolesResource.getContents().add(r);
		}

		try {
			userResource.save(null);
		} catch (final TransactionException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// FIXME Remove later, fixtures go elsewhere. 
	@SuppressWarnings("unused")
	private void loadLibrary() {

		final CDOResource res = (CDOResource) getResource(LibraryPackage.Literals.LIBRARY);
		final CDOView view = res.cdoView();
		
		Library lib = null;
		// Should do some basic import data validation.
		if (res.getContents() != null && (res.getContents().size() > 0)) {
			if (res.getContents().get(0) instanceof Library) {
				// Ok, proceed. 
				lib = (Library) res.getContents().get(0);
			}
		}else{
			lib = LibraryFactory.eINSTANCE.createLibrary();
			res.getContents().add(lib);
		}
		
		final NodeType sgsnType = LibraryFactory.eINSTANCE.createNodeType();
		final Function sgsnFunction = LibraryFactory.eINSTANCE
				.createFunction();
		sgsnFunction.setName("SGSN");
		sgsnType.getFunctions().add(sgsnFunction);

		lib.getNodeTypes().add(sgsnType);

		final NetXResource sgsnRes = LibraryFactory.eINSTANCE
				.createNetXResource();
		final MetricValueRange range = MetricsFactory.eINSTANCE
				.createMetricValueRange();
		sgsnRes.getMetricValueRanges().add(range);

		sgsnFunction.getResourceRefs().add(sgsnRes);

		final Value v = GenericsFactory.eINSTANCE.createValue();
		v.setValue(2.0);
		v.setTimeStamp(modelUtils.toXMLDate(modelUtils.yesterday()));

		final Value v1 = GenericsFactory.eINSTANCE.createValue();
		v1.setValue(2.1);
		v1.setTimeStamp(modelUtils.toXMLDate(modelUtils.twoDaysAgo()));

		final Value v2 = GenericsFactory.eINSTANCE.createValue();
		v2.setValue(2.1);
		v2.setTimeStamp(modelUtils.toXMLDate(modelUtils.threeDaysAgo()));

		range.getMetricValues().addAll(ImmutableList.of(v, v1, v2));

		try {
			res.save(null);
		} catch (final TransactionException e) {
			((CDOTransaction) view).rollback();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
