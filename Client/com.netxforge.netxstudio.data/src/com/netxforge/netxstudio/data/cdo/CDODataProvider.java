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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Inject;
import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.NetxstudioFactory;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
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
 * Clients should use a Session to
 * 
 * final CDOSession session = openSession(); final CDOTransaction transaction =
 * session.openTransaction();
 * 
 * // get/create a resource CDOResource resource =
 * transaction.getOrCreateResource("/test1");
 * 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class CDODataProvider implements IDataProvider {

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
		CDOTransaction transaction = openSession().openTransaction(set);
		CDOResource resource = transaction.getOrCreateResource(res);
		return resource;
	}
	
	
	private String resolveResourceName(int feature){
		String resource = "/"; 
		// We switch on the resource to use. 
		switch(feature){
		case NetxstudioPackage.NETXSTUDIO:{
			resource += "netxstudio";
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
	 * @see com.netxforge.netxstudio.data.IDataProvider#getNetXStudio()
	 */
	public Netxstudio getNetXStudio() {
		return getNetXStudio(null);
	}

	public Person getPerson() {
		return null;
	}

	public Person getPerson(String first, String last, String login,
			String email) {
		return null;
	}

	private Netxstudio initO_Netxstudio() {
		Netxstudio netxs = NetxstudioFactory.eINSTANCE.createNetxstudio();
		return netxs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataProvider#getNetXStudio(org.eclipse
	 * .emf.ecore.resource.ResourceSet)
	 */
	public Netxstudio getNetXStudio(ResourceSet set) {

		CDOTransaction transaction = null;
		if (set != null) {
			transaction = openSession().openTransaction(set);
		} else {
			transaction = openSession().openTransaction();
		}
		// get/create a resource, the resource name is arbitrary and helps us
		CDOResource resource = transaction.getOrCreateResource("/netxstudio"); //$NON-NLS-1$
		if (resource.getContents().size() == 0) {
			Netxstudio netx = initO_Netxstudio();
			resource.getContents().add(netx);
			return (Netxstudio) netx;
		} else {
			return (Netxstudio) resource.getContents().get(0);
		}
	}

}
