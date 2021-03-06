/*******************************************************************************
 * Copyright (c) May 10, 2011 NetXForge.
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
package com.netxforge.screens.editing.base;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;

import com.netxforge.base.IComponentLifecycle;
import com.netxforge.base.data.IBaseData;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public interface IEditingService extends IComponentLifecycle {
	
	
	/**
	 * Get the editing domain for this service.
	 * 
	 * @return
	 */
	public abstract EditingDomain getEditingDomain();

	/**
	 * A Convenience delegator.
	 * 
	 * @return
	 */
	public AdapterFactoryItemDelegator getDelegator();

	/**
	 * Get the save operation.
	 * 
	 * @param monitor
	 * @return
	 */

	// CB Remove later.
	// public abstract IRunnableWithProgress
	// doGetSaveHistoryOperation(IProgressMonitor monitor);

	/**
	 * Saves the data permanently.
	 * 
	 * @param monitor
	 */
	public abstract void doSave(IProgressMonitor monitor);

	/**
	 * returns if editing is dirty and should be saved.
	 * 
	 * @return
	 */
	public abstract boolean isDirty();

	/**
	 * sets dirty for saving.
	 * 
	 * @return
	 */
	public abstract void setDirty();

	/**
	 * Call when a screen is changed, also tell us what kind of root data
	 * feature is expected, we will return the resource which contains it or can
	 * be used..
	 * 
	 * @deprecated
	 */
	public abstract Resource getData(int feature);

	/**
	 * Call to get the data for a specific path which could result in a list of
	 * resources.
	 * 
	 * @param path
	 * @return
	 */
	public abstract List<Resource> getData(String path);

	/**
	 * Call to get the data for a specific EClass, we return a resource which
	 * contains the data.
	 * 
	 * @param clazz
	 * @return
	 */
	public abstract Resource getData(EClass clazz);

	/**
	 * The implementation has an opportunity to guard against objects which are
	 * not alive anymore. As we optionally deal wil proxied objects this is a
	 * common case when for example closing a transaction which obtained the
	 * objects.
	 * 
	 * 
	 * @param objects
	 * @return
	 */
	public abstract boolean isDataAlive(Object[] objects);

	/**
	 * Revoke all relations with the data provider.
	 */
	public abstract void disposeData();

	/**
	 * Set the provider for the active viewer.
	 * 
	 * @param provider
	 * @deprecated Use setScreenProvider instead.
	 */
	public abstract void setViewerProvider(IViewerProvider provider);

	/**
	 * Set the provider for the active screen.
	 * 
	 * @param provider
	 */
	public abstract void setScreenProvider(IScreenProvider provider);

	/**
	 * Implementors require to provide a unique name for a resource, which can
	 * be used to store historical versions of the object.
	 * 
	 * @param object
	 * @return
	 */
	public String resolveHistoricalResourceName(Object object);

	/**
	 * Get the data accessor.
	 * 
	 * @return
	 */
	public IBaseData getData();

}