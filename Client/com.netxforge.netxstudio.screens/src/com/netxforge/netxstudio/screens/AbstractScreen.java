/*******************************************************************************
 * Copyright (c) Jun 16, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.widgets.Form;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.observables.FormValidationEvent;
import com.netxforge.netxstudio.screens.editing.observables.IValidationListener;
import com.netxforge.netxstudio.screens.editing.observables.IValidationService;
import com.netxforge.netxstudio.screens.editing.observables.ValidationEvent;
import com.netxforge.netxstudio.screens.editing.observables.ValidationService;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Convenience implementation of a screen, sharing commonality like the screen
 * operation, and the supporting services, a validation service, an observables
 * manager and a Managed form (for Master/Detail).
 * 
 * @author dzonekl
 */
public abstract class AbstractScreen extends Composite implements IScreen,
		IValidationListener, DisposeListener, SelectionListener {

	protected int operation;

	protected IEditingService editingService;

	protected IScreenFormService screenService;

	protected IValidationService validationService;
	
	@Inject
	protected ModelUtils modelUtils;

	public void setScreenService(IScreenFormService screenService) {
		this.screenService = screenService;
		this.editingService = screenService.getEditingService();
	}

	public AbstractScreen(Composite parent, int style) {
		super(parent, style);
		this.addDisposeListener(this);
//		ScreensActivator.getDefault().getInjector().injectMembers(this);
		validationService = new ValidationService();
	}

	public abstract Viewer getViewer();

	public int getOperation() {
		return operation;
	}

	public abstract void setOperation(int operation);

	public abstract boolean isValid();

	public abstract Form getScreenForm();

	/**
	 * @param currentStatus
	 * @param ctx
	 */
	public void handleValidationStateChange(ValidationEvent event) {

		if (event instanceof FormValidationEvent) {
			int type = ((FormValidationEvent) event).getMsgType();
			List<IMessage> list = ((FormValidationEvent) event).getMessages();
			if (getScreenForm().isDisposed()
					|| this.getScreenForm().getHead().isDisposed()) {
				return;
			}
			if (type != IMessage.NONE) {
				String errorType = "";
				if (type == IMessage.ERROR) {
					errorType = "Error:";
				}
				if (type == IMessage.WARNING) {
					errorType = "Required:";
				}
				StringBuffer msgBuffer = new StringBuffer();
				msgBuffer.append(errorType + "(" + list.size() + "), "
						+ list.get(0).getMessage());
				this.getScreenForm().setMessage(msgBuffer.toString(), type,
						list.toArray(new IMessage[list.size()]));

			} else {
				this.getScreenForm().setMessage(null);
			}
		}
	}

	public IAction[] getActions() {
		return new IAction[0];
	}

	public EStructuralFeature[] permittedCreationFeatures() {
		return null;
	}

	public void widgetDisposed(DisposeEvent e) {
		if (validationService != null) {
			validationService.dispose();
		}
	}

	protected Collection<Object> selectedElements;
	
	@SuppressWarnings("unchecked")
	public void widgetSelected(SelectionEvent e) {
		ISelection selection = this.getViewer().getSelection();
		if(selection instanceof IStructuredSelection ){
			selectedElements = ((IStructuredSelection) selection).toList();
			this.doSetSelection(selectedElements);
		}
	}

	public void widgetDefaultSelected(SelectionEvent e) {
	}
	
//	public abstract void doSetSelection(Collection<Object> selectedElements);

	/**
	 * Clients should override. 
	 * @param selectedElements
	 */
	protected void doSetSelection(Collection<Object> selectedElements){
		// do nothing. 
	}
	
	
}
