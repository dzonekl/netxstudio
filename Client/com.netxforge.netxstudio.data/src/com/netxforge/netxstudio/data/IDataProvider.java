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

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
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
	public static final long SIGNAL_TIME_OUT = 60 * 1000;
	
	/**
	 * Get the resource in the the provided set, with the provided resourcePath.
	 * 
	 * @param set
	 * @param resourcePath
	 * @return
	 */
	public Resource getResource(ResourceSet set, EClass clazz);

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
	 * Get the resource for a specific EClass.
	 * 
	 * @param feature
	 * @return
	 */
	public Resource getResource(EClass clazz);

	/**
	 * Open a session, depending on the implementation will use default
	 * credentials or no credentials (which can fail if credentials are
	 * required).
	 */
	public CDOSession openSession();

	/**
	 * Open a session for the user credentials.
	 * 
	 * @param uid
	 * @param passwd
	 */
	public void openSession(String uid, String passwd);

	/**
	 * Gets the current transaction if no current transaction then a new one
	 * will be opened.
	 */
	public CDOTransaction getTransaction();

	/**
	 * Commit the current transaction if there is any.
	 */
	public void commitTransaction();

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