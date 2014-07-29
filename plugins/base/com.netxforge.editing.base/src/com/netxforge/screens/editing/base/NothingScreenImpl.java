/*******************************************************************************
 * Copyright (c) 6 dec. 2012 NetXForge.
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
package com.netxforge.screens.editing.base;

import java.util.Collection;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.part.ShowInContext;



/**
 * A Nothing implementation of IScreen, it implements nothing from IScreen. 
 * 
 * @author Christophe
 *
 */
public class NothingScreenImpl extends Composite implements IScreen {

	public NothingScreenImpl(Composite parent, int style) {
		super(parent, style);
		
		this.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				// do dispose.  
			}
		});
	}

	public Viewer getViewer() {
		return null;
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		
	}

	public ISelection getSelection() {
		return null;
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
	}

	public void setSelection(ISelection selection) {
		
	}

	public void saveState(IMemento memento) {
		
	}

	public int getOperation() {
		return ScreenUtil.OPERATION_READ_ONLY;
	}

	public void setOperation(int operation) {
		
	}

	public boolean isValid() {
		return false;
	}

	public Form getScreenForm() {
		return null;
	}

	public String getScreenName() {
		return null;
	}

	public void setScreenName(String screenName) {
		
	}

	public boolean handleShowIn(ShowInContext context) {
		return false;
	}

	public ShowInContext getShowIn(ISelection selection) {
		return null;
	}

	public IScreenFormService getScreenService() {
		return null;
	}

	public IEditingService getEditingService() {
		return null;
	}

	public void setScreenService(IScreenFormService screenService) {
		
	}

	public void setScreenFocus() {
		
	}

	public void setEditingService(IEditingService editingService) {
		
	}

	public EMFDataBindingContext initDataBindings_() {
		return null;
	}

	public IAction[] getActions() {
		return null;
	}

	public Viewer[] getViewers() {
		return null;
	}

	public void restoreState(IMemento memento) {
		
	}

	public Collection<Object> getScreenObjects() {
		return null;
	}

	public boolean shouldHandleRefresh() {
		return false;
	}

	public void handleRefresh(Object... objects) {
	}

}
