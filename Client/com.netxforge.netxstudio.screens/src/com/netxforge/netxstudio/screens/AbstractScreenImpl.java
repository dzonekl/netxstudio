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

import java.util.List;
import java.util.Set;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.part.ShowInContext;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.netxforge.netxstudio.common.guice.IInjectorProxy;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.screens.common.internal.ScreensCommonActivator;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.observables.FormValidationEvent;
import com.netxforge.netxstudio.screens.editing.observables.IValidationListener;
import com.netxforge.netxstudio.screens.editing.observables.IValidationService;
import com.netxforge.netxstudio.screens.editing.observables.ValidationEvent;
import com.netxforge.netxstudio.screens.editing.selector.IDataInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Convenience implementation of a screen, sharing commonality like the screen
 * operation, and the supporting services, a validation service, an observables
 * manager and a Managed form (for Master/Detail).
 * 
 * @author dzonekl
 */
public abstract class AbstractScreenImpl extends Composite implements IScreen,
		IDataInjection, IValidationListener, DisposeListener, FocusListener {

	protected int operation;

	protected IEditingService editingService;

	protected IScreenFormService screenService;

	public boolean isValid() {
		return false;
	}

	@Inject
	protected ModelUtils modelUtils;

	@Inject
	protected IValidationService validationService;

	@Inject
	@Named("Screens")
	protected IInjectorProxy injectorProxy;
	
	
	private Object currentFocusWidget;

	public AbstractScreenImpl(Composite parent, int style) {
		super(parent, style);
		this.addDisposeListener(this);
		
		// Should be replaced, by instantiation of this class with GUICE, so the injection already occurs.
		// See Screen Service.
		ScreensActivator.getDefault().getInjector().injectMembers(this);
//		injectorProxy.getInjector("").injectMembers(this);
	}
	
	
	/**
	 * Clients could call to update the selection provider depending on focus. 
	 * 
	 * @param c
	 */
	protected void registerFocus(Control c) {
		if (c instanceof Composite) {
			Composite comp = (Composite) c;
			for (Control cChild : comp.getChildren()) {
				cChild.addFocusListener(this);
				registerFocus(cChild);
			}
		}
	}
	
	
	/**
	 * Called automaticly when we are disposed. 
	 * @param c
	 */
	private void unRegisterFocus(Control c) {
		if (c instanceof Composite) {
			Composite comp = (Composite) c;
			for (Control cChild : comp.getChildren()) {
				cChild.removeFocusListener(this);
				unRegisterFocus(cChild);
			}
		}
	}

	
	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public void setScreenService(IScreenFormService screenService) {
		this.screenService = screenService;
		this.editingService = screenService.getEditingService();
	}

	public IScreenFormService getScreenService() {
		return screenService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.selector.IScreen#setEditingService
	 * (com.netxforge.netxstudio.screens.editing.IEditingService)
	 */
	public void setEditingService(IEditingService editingService) {
		this.editingService = editingService;
	}

	public IEditingService getEditingService() {
		if (screenService != null) {
			return screenService.getEditingService();
		} else {
			return editingService;
		}
	}

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
		this.unRegisterFocus(this);
	}

	/**
	 * Store a preference, merely delegate to the Activator.
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	protected boolean storePreference(String key, String value) {
		ScreensCommonActivator.doGetPreferenceStore().setValue(key, value);
		return true;
	}

	/**
	 * Find a preference, delegate to the Activator.
	 * 
	 * @param key
	 * @return
	 */
	protected String findPreference(String key) {
		if (ScreensCommonActivator.doGetPreferenceStore().contains(key)) {
			return ScreensCommonActivator.doGetPreferenceStore().getString(key);
		}
		return null;
	}

	/* Clients should override */
	public String getScreenName() {
		return "<TODO: Provide screenname>";
	}

	public String getOperationText() {
		if (ScreenUtil.isReadOnlyOperation(this.getOperation())) {
			return "View: ";
		} else if (ScreenUtil.isNewOperation(this.getOperation())) {
			return "New: ";
		} else {
			return "Edit: ";
		}
	}

	public void injectData(Object... params) {
		// do nothing.
	}

	public void injectData() {
		// do nothing.
	}

	public void injectData(Object owner, Object object) {
		// do nothing.
	}

	// ISelectionProvider - Composition.
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
			ISelectionProvider currentSelectionProvider = this.resolveSelectionProviderFromWidget(currentFocusWidget);
			if(currentSelectionProvider != null){
				currentSelectionProvider.addSelectionChangedListener(listener);
		}
		
//		for (Viewer v : this.getViewers()) {
//			if (v != null) {
//				v.addSelectionChangedListener(listener);
//			}
//		}
	}

	public ISelection getSelection() {
		
			ISelectionProvider currentSelectionProvider = this.resolveSelectionProviderFromWidget(currentFocusWidget);
			if(currentSelectionProvider != null){
				return currentSelectionProvider.getSelection();
			}
		
		// return the selection from the first viewer with focus.
//		for (Viewer v : this.getViewers()) {
//			if (v != null && v.getControl().isFocusControl()) {
//				return v.getSelection();
//			}
//		}
		return StructuredSelection.EMPTY;
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		
			ISelectionProvider currentSelectionProvider = this.resolveSelectionProviderFromWidget(currentFocusWidget);
			if(currentSelectionProvider != null){
				currentSelectionProvider.removeSelectionChangedListener(listener);
			}
		
//		for (Viewer v : this.getViewers()) {
//			if (v != null) {
//				v.removeSelectionChangedListener(listener);
//			}
//		}
	}

	public void setSelection(ISelection selection) {
//		for (Viewer v : this.getViewers()) {
//			if (v != null && v.getSelection() != null) {
//				v.setSelection(selection);
//			}
//		}
		
		if( this.currentFocusWidget != null){
			ISelectionProvider currentSelectionProvider = this.resolveSelectionProviderFromWidget(currentFocusWidget);
			if(currentSelectionProvider != null){
				currentSelectionProvider.setSelection(selection);
			}
		}
	}

	public Viewer[] getViewers() {
		// defaults to the IViewerProvider single viewer, note could be null.
		return new Viewer[] { this.getViewer() };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.selector.IScreen#getShowIn(org
	 * .eclipse.ui.part.ShowInContext)
	 */
	public ShowInContext getShowIn(ISelection selection) {
		return new ShowInContext(null, selection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.selector.IScreen#handleShowIn
	 * (org.eclipse.ui.part.ShowInContext)
	 */
	public boolean handleShowIn(ShowInContext context) {
		if (this instanceof IDataInjection) {
			// inject the context.
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.FocusListener#focusGained(org.eclipse.swt.events
	 * .FocusEvent)
	 */
	public void focusGained(FocusEvent e) {
		this.currentFocusWidget = e.getSource();
		fireScreenSelectionProviderChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.FocusListener#focusLost(org.eclipse.swt.events
	 * .FocusEvent)
	 */
	public void focusLost(FocusEvent e) {
	}
	
	/**
	 * Convenience method to fire a widget change within our IScreen. 
	 */
	private void fireScreenSelectionProviderChanged(){
		this.screenService.fireScreenWidgetChangedExternal(this);
	}
		
	/**
	 * Clients should override to return custom selection providers based on the current focus control. 
	 * The default implementation returns the active viewer. 
	 *  
	 * @param widget
	 * @return
	 */
	protected ISelectionProvider resolveSelectionProviderFromWidget(Object widget){
		return this.getViewer();
	}


	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.selector.IDataInjection#shouldInjectForObject(org.eclipse.emf.cdo.CDOObject)
	 */
	public boolean shouldInjectForObject(Set<CDOObject> injectionObjects) {
		return false;
	}
	
}
