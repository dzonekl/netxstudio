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
package com.netxforge.screens.editing.base;

import java.util.Collection;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistable;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.part.ShowInContext;



/**
 * Screens participating in the screen service, should implement. 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public interface IScreen extends IViewerProvider, ISelectionProvider, IPersistable {
	
	
	/**
	 * Screens should implement, and tell us what kind of operation they should perform. 
	 * {@link ScreenUtil}
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
	 * The name of the screen. 
	 */
	public abstract String getScreenName();
	
	
	/**
	 * set the name of the screen. 
	 * @param screenName
	 */
	public abstract void setScreenName(String screenName);
	
	
	/**
	 * update the screen with a show in context.
	 * @return 
	 */
	public abstract boolean handleShowIn(ShowInContext context);
	
	/**
	 * update the screen with a show in context.
	 * @return 
	 */
	public abstract ShowInContext getShowIn(ISelection selection);
	
	
		
	/**
	 * Get the screen service for this screen. 
	 * @return
	 */
	public abstract IScreenFormService getScreenService();

	
	
	/**
	 * Convenience, should delegate to the IScreenFormService
	 * @return
	 */
	public abstract IEditingService getEditingService();

	
	/**
	 * Set the screen service for this screen. 
	 * @param screenService
	 */
	public abstract void setScreenService(IScreenFormService screenService);
	
	/**
	 * Set the focus on the desired widget. 
	 * 
	 */
	public abstract void setScreenFocus();
	
	/**
	 * Set the editing service for this screen. 
	 * @param screenService
	 */
	public abstract void setEditingService(IEditingService editingService);
	
	/**
	 * 
	 * @return
	 */
	public abstract EMFDataBindingContext initDataBindings_();
	
	
	/**
	 * An array of actions which will be populated on the context menu o the viewer. 
	 * @return
	 */
	public abstract IAction[] getActions();
		
	
	/**
	 * The viewers which are supported by this screen. 
	 * The 
	 * 
	 * @return
	 */
	public Viewer[] getViewers();
	
	
	/**
	 * Ask the screen, if it wants to handle the refreshing.
	 * Refreshing, could be needed, as data is remotely updated. 
	 * This can be done by refreshing the viewers from the screen, 
	 * or delegating it to the IScreen itself.  
	 * 
	 * @return
	 */
	public abstract boolean shouldHandleRefresh();
	
	
	/**
	 * Will be called, if {@link #shouldHandleRefresh()} returns true. 
	 * 
	 * @param objects the objects which could be needing a refresh. 
	 */
	public abstract void handleRefresh(Object... objects);
	
	
	/**
	 * Delegate from the IViewerPart
	 * @param memento
	 */
	public abstract void restoreState(IMemento memento);
	
	
	/**
	 * The screen objects being served. 
	 * @return
	 */
	public abstract Collection<? extends Object> getScreenObjects();
	
}
