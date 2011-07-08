/*******************************************************************************
 * Copyright (c) May 12, 2011 NetXForge.
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

import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.log.PrintLogHandler;
import org.eclipse.net4j.util.om.trace.PrintTraceHandler;

import com.google.inject.Singleton;

/**
 * A CDO connection, which can be initialized.
 * 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
@Singleton
public class CDODataConnection implements ICDOConnection {

	// TODO, Migrate the Data Store UI.

	protected static final String REPO_NAME = "repo1"; //$NON-NLS-1$

	protected static final String CONNECTION_ADDRESS = "localhost:2036"; //$NON-NLS-1$
	
	protected String currentServer;
	
	private CDOSessionConfiguration sessionConfiguration = null;

	public CDOSessionConfiguration getConfig() {
		return sessionConfiguration;
	}

	/**
	 * Initializes the connection and creates a {@link CDOSessionConfiguration}
	 * which is stored in a member of this class.
	 */
	public void initialize() {
		this.initialize(CONNECTION_ADDRESS);
	}
	
	public void initialize(String server) {
		
		if(server == null || server.length() == 0){
			server = CONNECTION_ADDRESS;
		}
		currentServer = server;

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
		
		
		// TODO, We should decompose the Server string, to: 
		// URL => protocol (Scheme) :// server / repo
		
		// Create connector
		final IConnector connector = TCPUtil.getConnector(container,
				server);
		// Create configuration
		sessionConfiguration = CDONet4jUtil.createSessionConfiguration();
		sessionConfiguration.setConnector(connector);
		sessionConfiguration.setRepositoryName(REPO_NAME);
	}
	
	public String getCurrentServer(){
		return currentServer;
	}
	
}
