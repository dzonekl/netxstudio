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
package com.netxforge.netxstudio.screens.editing;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public interface IEditingService {

	public abstract EditingDomain getEditingDomain();

	public abstract ComposedAdapterFactory getAdapterFactory();
	
	public abstract IRunnableWithProgress doGetSaveOperation(IProgressMonitor monitor);
	
	public abstract void doSave(IProgressMonitor monitor);
		
	/**
	 * Call when a screen is changed, also tell us what kind of root 
	 * data feature is expected, we will return the resource which contains it or can be used..
	 */
	public abstract Resource initScreen(int feature);
		
	/**
	 * Can when the screen is gone, we can tear down the connections 
	 * to the data provider. 
	 * 
	 * @return
	 */
	public abstract void tearDownScreen();
}