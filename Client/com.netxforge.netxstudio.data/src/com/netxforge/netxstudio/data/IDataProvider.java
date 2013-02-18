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

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public interface IDataProvider {

	/**
	 * The timeout time.
	 */
	public static final long SIGNAL_TIME_OUT = 600L * 1000L;
	public static final long SIGNAL_TIME_OUT_CLIENT = 60L * 1000L;
	
	/**
	 * Comment set on a server side CDO Transaction when committing. 
	 */
	public static final String SERVER_COMMIT_COMMENT = "servercommit";
	
	/**
	 * Comment set on a client side CDO Transaction when committing.
	 */
	public static final String CLIENT_COMMIT_COMMENT = "clientcommit";
	
	/**
	 * Comment set on a commit handler side CDO Transaction when committing.
	 */
	public static final String COMMITINFO_COMMIT_COMMENT = "infocommit";

	
	
	
	/**
	 * Get the server as a String.
	 * 
	 * @param set
	 * @param resourcePath
	 * @return
	 */
	public String getServer();

	
	/**
	 * Get the resource in the the provided set, with the provided resourcePath.
	 * 
	 * @param set
	 * @param resourcePath
	 * @return
	 */
	public Resource getResource(ResourceSet set, EClass clazz);
	
	/**
	 * The resource path. 
	 * @param set
	 * @param resourcePath
	 * @return
	 */
	public Resource getResource(ResourceSet set, String resourcePath);

	/**
	 * Get a resource with a given resource set.
	 * 
	 * @deprecated Use getResource(EStructuralFeature feature) instead.
	 * @param set
	 * @param feature
	 * @return
	 */
	@Deprecated
	public Resource getResource(ResourceSet set, int feature);

	/**
	 * Get a specific commit info resource for the specified user. TODO Consider
	 * refactoring this, and making it less object specific.
	 * 
	 * @param userID
	 * @return
	 */
	public Resource getCommitInfoResource(String userID);

	/**
	 * Get the resource for a feature (Index)
	 * 
	 * @deprecated Use getResource(EStructuralFeature feature) instead.
	 * @param feature
	 * @return
	 */
	@Deprecated
	public Resource getResource(int feature);

	
	/**
	 * If the repository has a resource with this URI. 
	 * @param resourcePath
	 * @return
	 */
	public boolean hasResource(URI resourceURI);

	
	/**
	 * If the repository has a resource with this path. 
	 * @param resourcePath
	 * @return
	 */
	public boolean hasResource(String resourcePath);
	
	
	
	
	/**
	 * Get the resource for a specific EClass.
	 * 
	 * @param feature
	 * @return
	 */
	public Resource getResource(EClass clazz);

	/**
	 * Get the resource for the specified EClass using 
	 * the provided view. 
	 * @param view
	 * @param clazz
	 * @return
	 */
	public Resource getResource(CDOView view, EClass clazz);
	
	
	
	/**
	 * et the resource for the specified path using 
	 * the provided view. 
	 * 
	 * @param view
	 * @param res
	 * @return
	 */
	public Resource getResource(CDOView view, String res);
	
	
	/**
	 * Get a resource from it's URI. 
	 * @param uri
	 * @return
	 */
	public Resource getResource(ResourceSet set, URI uri);
	
	/**
	 * Get a resource from it's URI. 
	 * @param uri
	 * @return
	 */
	public Resource getResource(URI uri);
	
	/**
	 * @return a resource on the basis of a string path
	 */
	public Resource getResource(String resourcePath);
	
	/**
	 * Implementers should consider parsing the path and look for 
	 * folder structures. 
	 * 
	 * @return a list of resources on the basis of a string path
	 */
	public List<Resource> getResources(ResourceSet set, String resourcePath);
	
	
	/**
	 * Implementers should consider parsing the path and look for 
	 * folder structures.
	 *   
	 * @param resourcePath
	 * @return
	 */
	public List<Resource> getResources(String resourcePath);
	
	
	/**
	 * Open a session, depending on the implementation will use default
	 * credentials or no credentials (which can fail if credentials are
	 * required).
	 */
	public CDOSession openSession();

	/**
	 * Open a session for the user credentials on the local host. .
	 * 
	 * @param uid
	 * @param passwd
	 */
	public void openSession(String uid, String passwd);
	
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param server
	 */
	public void openSession(String username, String password, String server);
	
	/**
	 * Open a session and capability to reset the session. 
	 * 
	 * @param username
	 * @param password
	 * @param server
	 */
	public void openSession(String username, String password, String server, boolean reset);
	
	/**
	 * Gets the current transaction if no current transaction then a new one
	 * will be opened.
	 */
	public CDOTransaction getTransaction();
	
	
	/**
	 * Gets the current view if no current view then a new one
	 * will be opened.
	 */
	public CDOView getView();
	

	/**
	 * Commit the current transaction if there is any.
	 */
	public void commitTransaction();
	
	/**
	 * Closes a view, and potentially nullify an instance in the provider. 
	 */
	public void closeView();

	/**
	 * Rollback the current transaction if there is any.
	 */
	public void rollbackTransaction();

	/**
	 * Get the current User ID for this session.
	 * 
	 * @return
	 */
	public String getSessionUserID();

	/**
	 * Get the active session
	 * 
	 * @return
	 */
	public CDOSession getSession();

	/**
	 * close the active session.
	 * 
	 * @return
	 */
	public void closeSession();

	/**
	 * Tells the system to create resources in a separate transaction. If true
	 * (default) then resource.save should be called to save the resource. If
	 * false then commitTransaction must be used.
	 * 
	 * @param createResourceInSeparateTransaction
	 */
	public void setDoGetResourceFromOwnTransaction(
			boolean createResourceInSeparateTransaction);

	

}