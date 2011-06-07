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
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import com.google.inject.Singleton;
import com.netxforge.netxstudio.screens.editing.dawn.DawnEMFEditorSupport;
import com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor;
import com.netxforge.netxstudio.screens.editing.dawn.IDawnEditorSupport;

/**
 * For the lifetime of this service, we keep various editing facilities. We also proxy to
 * various other services, like a data and validation service. 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
@Singleton
public class CDOEditingService extends EMFEditingService implements IDawnEditor, IViewerProvider {

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
	public CDOView getView() {
		return dawnEditorSupport.getView();
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor#
	 * getDawnEditorSupport()
	 */
	public IDawnEditorSupport getDawnEditorSupport() {
		return dawnEditorSupport;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		CDOView view = dawnEditorSupport.getView();
		System.out.println("View ID when saving:" + view.getViewID());
		if (view instanceof CDOTransaction) {
			if (((CDOTransaction)view).hasConflict()) {
				// TODO, remove later. 
//				MessageDialog.openError(Display.getDefault().getActiveShell(),
//						"conflict",
//						"Your Resource is in conflict and cannot be committed");
				MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), "Conflict", null,
				          "There is a conflict with another user. Would you like to rollback your current transaction?",
				          MessageDialog.QUESTION, new String[] { "yes", "no", "Cancel" }, 1);
				      switch (dialog.open())
				      {
				      case 0: // yes
				        ((IDawnEditor)this).getDawnEditorSupport().rollback();
				        break;
				      case 1: // no
				        break;
				      default: // cancel
				        break;
				      }
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
	public Resource getData(int feature) {
		
		// Check if we have a view already. 
		if(this.getView() != null){
			// check if we can create the resource from the current view. 
		}
		
		Resource res = dataService.getProvider().getResource(
				this.getEditingDomain().getResourceSet(), feature);
		
		if (res instanceof CDOResource) {
			dawnEditorSupport.setView(((CDOResource) res).cdoView());
			
			
			// TODO, should deregister!!
			dawnEditorSupport.registerListeners();
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.IEditingService#tearDownScreen(int)
	 */
	public void disposeData() {
		  dawnEditorSupport.close(); // Closes the view.
		  // Close the view, but does it close the transaction? 
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return this.delegateViewerProvider.getViewer();
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.IEditingService#isDirty()
	 */
	public boolean isDirty() {
		boolean result = ((BasicCommandStack) getEditingDomain()
				.getCommandStack()).isSaveNeeded();
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor#setDirty()
	 */
	public void setDirty() {
		dawnEditorSupport.setDirty(true);
	}
}
