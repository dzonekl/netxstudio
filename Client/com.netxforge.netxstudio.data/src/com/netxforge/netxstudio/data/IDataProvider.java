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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public interface IDataProvider {
	
	/**
	 * Get a resource with a given resource set. 
	 * @param set
	 * @param feature
	 * @return
	 */
	public Resource getResource(ResourceSet set, int feature);
	
	/**
	 * Get the resource for a specific feature. 
	 * @param feature
	 * @return
	 */
	public Resource getResource(int feature);
	
	/**
	 * TODO Remove later. 
	 * @return
	 */
	public EObject getNetXScriptWrapper();
	
	/**
	 * Open a session for the user credentials. 
	 * @param uid
	 * @param passwd
	 */
	public void openSession(String uid, String passwd);
	
	/**
	 * Get the current User ID for this session. 
	 * @return
	 */
	public String getSessionUserID();
	
	/**
	 * Get the active session
	 * @return
	 */
	public CDOSession getSession();
	
}