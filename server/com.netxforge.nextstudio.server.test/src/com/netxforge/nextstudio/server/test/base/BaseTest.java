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
package com.netxforge.nextstudio.server.test.base;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.log.PrintLogHandler;
import org.eclipse.net4j.util.om.trace.PrintTraceHandler;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * This class contains code to connect to a CDO server in a standalone manner .
 * So the junit test is not running inside an OSGI container.
 * 
 * @author Martin Taal
 */
public class BaseTest extends TestCase {
	protected static final String REPO_NAME = "repo1"; //$NON-NLS-1$

	protected static final String CONNECTION_ADDRESS = "localhost:2036"; //$NON-NLS-1$

	private CDOSessionConfiguration sessionConfiguration = null;

	private List<EPackage> ePackages = new ArrayList<EPackage>();

	public BaseTest() {
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

	public List<EPackage> getEPackages() {
		return ePackages;
	}

	/**
	 * Opens a CDOSession, does not register an EPackage with the session. This
	 * should be done by the caller.
	 */
	protected CDOSession openSession() {
		if (sessionConfiguration == null) {
			initialize();
		}
		final CDOSession cdoSession = sessionConfiguration.openSession();
		for (final EPackage ePackage : ePackages) {
			cdoSession.getPackageRegistry().putEPackage(ePackage);
		}
		return cdoSession;
	}

	protected List<EClass> getAllEClasses() {
		final List<EClass> eClasses = new ArrayList<EClass>();
		for (final EPackage ePackage : ePackages) {
			for (final EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					eClasses.add((EClass)eClassifier);
					
					eClassifier.setInstanceClass(null);
				}
			}
		}
		return eClasses;
	}
	
	/**
	 * Initializes the connection and creates a {@link CDOSessionConfiguration}
	 * which is stored in a member of this class.
	 */
	protected void initialize() {
		OMPlatform.INSTANCE.setDebugging(true);
		OMPlatform.INSTANCE.addLogHandler(PrintLogHandler.CONSOLE);
		OMPlatform.INSTANCE.addTraceHandler(PrintTraceHandler.CONSOLE);

		// Prepare container
		final IManagedContainer container = ContainerUtil.createContainer();
		Net4jUtil.prepareContainer(container); // Register Net4j factories
		TCPUtil.prepareContainer(container); // Register TCP factories
		CDONet4jUtil.prepareContainer(container); // Register CDO factories
		// LifecycleUtil.activate(container);
		container.activate();

		// Create connector
		final IConnector connector = TCPUtil.getConnector(container,
				CONNECTION_ADDRESS);

		// Create configuration
		sessionConfiguration = CDONet4jUtil.createSessionConfiguration();
		sessionConfiguration.setConnector(connector);
		sessionConfiguration.setRepositoryName(REPO_NAME);
	}

	/**
	 * Nullifies the session configuration so that a new test will start with a
	 * new one.
	 */
	@Override
	protected void tearDown() throws Exception {
		sessionConfiguration = null;
	}
}
