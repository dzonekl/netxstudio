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
package com.netxforge.netxstudio.screens.editing.selector;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.forms.widgets.Form;


/**
 * Screens participating in the screen service, should implement. 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public interface IScreen extends IViewerProvider {

	/**
	 * Screens should implement, and tell us what kind of operation they should perform. 
	 * {@link Screens}
	 * @return
	 */
	public abstract int getOperation();
		
	
	public abstract void setOperation(int operation);
	
	/**
	 * Let us know if this screen is valid.
	 * @return
	 */
	public abstract boolean isValid();
		
	/**
	 * Get the form object, for this screen. 
	 * @return
	 */
	public abstract Form getScreenForm();
	
	
	/**
	 * the name of the screen. 
	 */
	public abstract String getScreenName();

	
	/**
	 * Set the screen service for this screen. 
	 * @param screenService
	 */
	public abstract void setScreenService(IScreenFormService screenService);
	
	/**
	 * 
	 * @return
	 */
	public abstract EMFDataBindingContext initDataBindings_();
	
//	public abstract void disposeData();
	
	/**
	 * 
	 * @return
	 */
	public abstract EStructuralFeature[] permittedCreationFeatures();
	
	
	/**
	 * An array of actions which will be populated on the context menu o the viewer. 
	 * @return
	 */
	public abstract IAction[] getActions();
	

	
}
