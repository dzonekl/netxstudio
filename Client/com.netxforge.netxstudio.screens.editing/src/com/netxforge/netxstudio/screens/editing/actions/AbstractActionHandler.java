/*******************************************************************************
 * Copyright (c) Aug 2, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.screens.editing.actions;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.EditingDomainProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPart;

public abstract class AbstractActionHandler implements IActionHandler, ISelectionChangedListener  {
	
	
	/**
	 * Register the current active part. 
	 */
	protected IWorkbenchPart activePart;

	/**
	 * Register the current selection provider (from the current active part). 
	 */
	protected ISelectionProvider selectionProvider;
	
	
	protected EditingDomain domain;
	
	/**
	 * Simple notification of a property change, which delegates to update.
	 * This is often the result of a model change, like saving or model 
	 * commands being executed which might affect the status of some actions. 
	 * 
	 */
	public void propertyChanged(Object source, int propId) {
		if(source instanceof IWorkbenchPart){
			update((IWorkbenchPart) source);
		}
	}

	public void setActivePart(IWorkbenchPart part) {
		
		activePart = part;

		// Switch to the new selection provider.
		//
		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(this);
		}
		if (part == null) {
			selectionProvider = null;
		}
		else {
			ISelectionProvider selectionProvider = part instanceof ISelectionProvider ? (ISelectionProvider) part
					: part.getSite().getSelectionProvider();
			selectionProvider.addSelectionChangedListener(this);

			// Fake a selection changed event to update the menus.
			//
			if (selectionProvider.getSelection() != null) {
				selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
			}
		}
		
		if(part instanceof EditingDomainProvider ){
			domain = ((EditingDomainProvider) part).getEditingDomain();
		}
	}
	
	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener},
	 * handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}.
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1) {
			IStructuredSelection ss = (IStructuredSelection)selection;
			handleSelection(ss);
		}
	}
	
	/**
	 * Clients should implement to handle the selection. 
	 * Typical use case is to prepare (create) actions, which can be directly 
	 * presented when a menu shows. 
	 *    
	 * @param ss
	 */
	public abstract void handleSelection(IStructuredSelection ss);
	

		
	/**
	 * In this implementation simply call the setActivePart.  
	 */
	public void update(IWorkbenchPart part) {
		setActivePart(part);
	}

}
