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
package com.netxforge.editing.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;

import com.netxforge.base.DelegateComponentLifecycle;
import com.netxforge.base.IDelegateComponentLifecycle;
import com.netxforge.base.data.IBaseData;
import com.netxforge.screens.editing.base.AbstractScreensViewPart;
import com.netxforge.screens.editing.base.IEditingService;
import com.netxforge.screens.editing.base.IScreenProvider;

/**
 * For the lifetime of this service, we keep an editing domain. We also proxy to
 * a dataservice. (As the dataservice likely wants to know about our
 * resourceset).
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class EMFEditingService implements IEditingService {

	protected AdapterFactoryEditingDomain domain = null;

	private IBaseData data;

	// Composed as we would require multiple inheritance otherwise
	final IDelegateComponentLifecycle lcDelegate = new DelegateComponentLifecycle();

	public EMFEditingService(IBaseData data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.IEditingService#getEditingDomain
	 * ()
	 */
	public EditingDomain getEditingDomain() {

		if (domain == null) {
			BasicCommandStack commandStack = new BasicCommandStack();
			domain = new AdapterFactoryEditingDomain(
					AbstractScreensViewPart.getAdapterFactory(), commandStack);
		}
		return domain;
	}

	public EObject getObject() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.IEditingService#doSave(org.eclipse
	 * .core.runtime.IProgressMonitor)
	 */
	public IRunnableWithProgress doGetSaveOperation(IProgressMonitor monitor) {
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running
		// activity that modifies the workbench.
		//
		IRunnableWithProgress operation = new IRunnableWithProgress() {

			// This is the method that gets invoked when the operation runs.
			//
			public void run(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				for (Resource resource : getEditingDomain().getResourceSet()
						.getResources()) {
					if ((first || !resource.getContents().isEmpty())
							&& !getEditingDomain().isReadOnly(resource)) {
						try {

							resource.save(saveOptions);
							// Save a copy of the objects of certain resources.

						} catch (Exception exception) {
							// exception.printStackTrace();

							// Various reasons why save would fail...
							// At least warn the user.
							// The DIRTY objects will still appear in the UI, so
							// the editing
							// should be undone, or DIRTY objects rolled back.

							// MessageDialog.openError(Display.getDefault()
							// .getActiveShell(), "Error saving",
							// exception.getMessage());

							// TODO, give user feedback, and undo of domain.
							// Command cmd;
							// while( ( cmd =
							// domain.getCommandStack().getUndoCommand()) !=
							// null){
							// cmd.undo();
							// }
						}
						first = false;
					}
				}
			}
		};

		return operation;
	}

	public AdapterFactoryItemDelegator getDelegator() {
		return new AdapterFactoryItemDelegator(
				AbstractScreensViewPart.getAdapterFactory());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.IEditingService#doSave()
	 */
	public void doSave(IProgressMonitor monitor) {
		IRunnableWithProgress operation = doGetSaveOperation(monitor);
		if (operation == null)
			return;
		try {
			// This runs the options, and shows progress.
			new ProgressMonitorDialog(Display.getDefault().getActiveShell())
					.run(true, false, operation);

			// Refresh the necessary state.
			((BasicCommandStack) getEditingDomain().getCommandStack())
					.saveIsDone();
		} catch (Exception exception) {
			// exception.printStackTrace();
			// Hide here will be caught higher up.
		}
	}

	protected IViewerProvider delegateViewerProvider;

	public void setViewerProvider(IViewerProvider viewerProvider) {
		this.delegateViewerProvider = viewerProvider;
	}

	protected IScreenProvider delegateScreenProvider;

	public void setScreenProvider(IScreenProvider screenProvider) {
		this.delegateScreenProvider = screenProvider;
	}

	/**
	 * If a save is needed on {@link BasicCommandStack#isSaveNeeded()}.
	 */
	public boolean isDirty() {
		CommandStack commandStack = this.getEditingDomain().getCommandStack();
		if (commandStack instanceof BasicCommandStack) {
			return ((BasicCommandStack) commandStack).isSaveNeeded();
		}
		return false;
	}

	public void setDirty() {
		throw new UnsupportedOperationException("TODO Implement");

	}

	public Resource getData(int feature) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public List<Resource> getData(String path) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getData(EClass clazz) {
		// Should we cache it?
		Resource resource = this.data.getResource(this.getEditingDomain()
				.getResourceSet(), clazz);
		return resource;
	}

	public boolean isDataAlive(Object[] objects) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	/**
	 */
	public void disposeData() {
		// TODO Implement.

		// throw new UnsupportedOperationException("TODO Implement");
	}

	public String resolveHistoricalResourceName(Object object) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public IBaseData getData() {
		return data;
	}

	public void activate(Object source) {
		lcDelegate.activate(source, this);

	}

	public void deactivate(Object source) {
		lcDelegate.deactivate(source, this);

	}

	public void register(Object source) {
		lcDelegate.register(source);

	}

	public void deregister(Object source) {
		lcDelegate.deregister(source);
	}
}
