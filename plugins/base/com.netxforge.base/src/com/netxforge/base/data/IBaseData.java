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
package com.netxforge.base.data;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.netxforge.base.IComponentLifecycle;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public interface IBaseData extends IComponentLifecycle {

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

}