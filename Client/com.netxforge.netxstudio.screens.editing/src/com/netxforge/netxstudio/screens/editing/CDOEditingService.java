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
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.google.inject.Singleton;
import com.netxforge.netxstudio.screens.editing.dawn.DawnEMFEditorSupport;
import com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor;
import com.netxforge.netxstudio.screens.editing.dawn.IDawnEditorSupport;

/**
 * For the lifetime of this service, we keep an editing domain. We also proxy to
 * a dataservice. (As the dataservice likely wants to know about our
 * resourceset).
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
@Singleton
public class CDOEditingService extends EMFEditingService implements IDawnEditor {

	/**
	 * Our editor support for Dawn.
	 */
	private DawnEMFEditorSupport dawnEditorSupport;

	public CDOEditingService() {
		dawnEditorSupport = new DawnEMFEditorSupport(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor#getView()
	 */
	@Override
	public CDOView getView() {
		return dawnEditorSupport.getView();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor#setDirty()
	 */
	@Override
	public void setDirty() {
		dawnEditorSupport.setDirty(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor#
	 * getDawnEditorSupport()
	 */
	@Override
	public IDawnEditorSupport getDawnEditorSupport() {
		return dawnEditorSupport;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		CDOView view = dawnEditorSupport.getView();
		if (view instanceof CDOTransaction) {
			if (view.hasConflict()) {
				MessageDialog.openError(Display.getDefault().getActiveShell(),
						"conflict",
						"Your Resource is in conflict and cannot be committed");
			} else {
				super.doSave(monitor);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.IEditingService#initScreen(int)
	 */
	@Override
	public Resource initScreen(int feature) {
		Resource res = dataService.getProvider().getResource(
				this.getEditingDomain().getResourceSet(), feature);
		if (res instanceof CDOResource) {
			dawnEditorSupport.setView(((CDOResource) res).cdoView());
			dawnEditorSupport.registerListeners();
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.IEditingService#tearDownScreen(int)
	 */
	@Override
	public void tearDownScreen() {
		  dawnEditorSupport.close(); // Closes the view.
		  // Close the view, but does it close the transaction? 
		  
	}
}
