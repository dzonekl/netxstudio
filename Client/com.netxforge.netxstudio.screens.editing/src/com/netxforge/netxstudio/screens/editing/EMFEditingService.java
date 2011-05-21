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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.data.IDataService;

/**
 * For the lifetime of this service, we keep an editing domain. We also proxy to
 * a dataservice. (As the dataservice likely wants to know about our
 * resourceset).
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
@Singleton
public abstract class EMFEditingService implements IEditingService {

	@Inject
	protected IDataService dataService;
	
	public EMFEditingService() {
	}

	static AdapterFactoryEditingDomain domain = null;

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
			domain = new AdapterFactoryEditingDomain(this.getAdapterFactory(),
					commandStack);
		}
		return domain;
	}

	// The declared EMF edit adapter factory.
	static ComposedAdapterFactory emfEditAdapterFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.IEditingService#getAdapterFactory
	 * ()
	 */
	public ComposedAdapterFactory getAdapterFactory() {
		if (emfEditAdapterFactory == null) {
			emfEditAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return emfEditAdapterFactory;
	}

	public EObject getObject() {
		return null;
		// TODO implement.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.IEditingService#doSave(org.eclipse
	 * .core.runtime.IProgressMonitor)
	 */
	public IRunnableWithProgress doGetSaveOperation(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
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
						} catch (Exception exception) {
						}
						first = false;
					}
				}
			}
		};

		return operation;
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
			//
			((BasicCommandStack) getEditingDomain().getCommandStack())
					.saveIsDone();
		} catch (Exception exception) {
			// Something went wrong that shouldn't.
		}
	}

	IViewerProvider delegateViewerProvider;

	public void setViewerProvider(IViewerProvider viewerProvider) {
		this.delegateViewerProvider = viewerProvider;
	}

	public IDataService getDataService() {
		return this.dataService;
	}
	
}
