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

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.swt.widgets.Display;

import com.google.common.collect.ImmutableList;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.editing.dawn.DawnEMFEditorSupport;
import com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor;
import com.netxforge.netxstudio.screens.editing.dawn.IDawnEditorSupport;

/**
 * For the lifetime of this service, we keep various editing facilities. We also
 * proxy to various other services, like a data and validation service.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
// @Singleton
public class CDOEditingService extends EMFEditingService implements
		IDawnEditor, IViewerProvider {

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
			if (((CDOTransaction) view).hasConflict()) {
				MessageDialog dialog = new MessageDialog(
						Display.getDefault().getActiveShell(),
						"Conflict",
						null,
						"There is a conflict with another user. Would you like to rollback your current transaction?",
						MessageDialog.QUESTION, new String[] { "yes", "no",
								"Cancel" }, 1);
				switch (dialog.open()) {
				case 0: // yes
					((IDawnEditor) this).getDawnEditorSupport().rollback();
					break;
				case 1: // no
					break;
				default: // cancel
					break;
				}
			} else {
				// this.doSaveHistory(monitor);
				IRunnableWithProgress operation = doGetSaveOperation(monitor);
				if (operation == null)
					return;
				try {
					// This runs the options, and shows progress.
					new ProgressMonitorDialog(Display.getDefault()
							.getActiveShell()).run(true, false, operation);

					// Refresh the necessary state.
					((BasicCommandStack) getEditingDomain().getCommandStack())
							.saveIsDone();

				} catch (Exception exception) {

				
				}
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
		if (this.getView() != null) {
			// check if we can create the resource from the current view.
		}

		@SuppressWarnings("deprecation")
		Resource res = dataService.getProvider().getResource(
				this.getEditingDomain().getResourceSet(), feature);

		if (res instanceof CDOResource) {
			dawnEditorSupport.setView(((CDOResource) res).cdoView());

			// TODO, should deregister!!
			dawnEditorSupport.registerListeners();
		}
		return res;
	}

	public Resource getData(EClass clazz) {
		// Check if we have a view already.
		if (this.getView() != null) {
			// check if we can create the resource from the current view.
		}

		Resource res = dataService.getProvider().getResource(
				this.getEditingDomain().getResourceSet(), clazz);

		if (res instanceof CDOResource) {
			dawnEditorSupport.setView(((CDOResource) res).cdoView());

			// TODO, should deregister!!
			dawnEditorSupport.registerListeners();
		}
		return res;
	}

	public List<Resource> getData(String path) {
		// Check if we have a view already.
		if (this.getView() != null) {
			// check if we can create the resource from the current view.
		}
		List<Resource> resources = dataService.getProvider().getResources(path);

		if (resources != null && resources.size() > 0) {
			dawnEditorSupport.setView(((CDOResource) resources.get(0))
					.cdoView());

			// TODO, should deregister!!
			dawnEditorSupport.registerListeners();
		}
		return resources;
	}

	public void disposeData() {
		// Will dispose for all resources in the resource set.
		// We need a copy, as we will removing from the resourceset.
		ImmutableList<Resource> list = ImmutableList.copyOf(this
				.getEditingDomain().getResourceSet().getResources());

		for (Resource res : list) {
			disposeData(res);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.IEditingService#tearDownScreen
	 * (int)
	 */
	public void disposeData(Resource res) {

		if (res instanceof CDOResource) {
			CDOView v = dawnEditorSupport.getView();
			dawnEditorSupport.close(); // Closes the view.
			CDOResource cdoRes = (CDOResource) res;
			if (cdoRes.cdoView().equals(v)) {
				if (res.isModified()) {
					System.out.println("unloading a modified resource!");
				}
				if (cdoRes.isLoaded()) {
					cdoRes.unload();
				}

				if (!cdoRes.cdoView().isClosed()) {
					System.out.println("Unloaded resource, has an open view!");
				}

				IListener[] listeners = cdoRes.cdoView().getListeners();
				if (listeners.length > 0) {
					System.out.println("Still listeners on our CDO view!");
				}
			}

		}
		// Close the view, but does it close the transaction?
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return this.delegateViewerProvider.getViewer();
	}

	/*
	 * (non-Javadoc)
	 * 
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

	// CB Remove later 6-10-2011
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.IEditingService#doSave()
	 */
	// public void doSaveHistory(IProgressMonitor monitor) {
	// IRunnableWithProgress operation = doGetSaveHistoryOperation(monitor);
	// if (operation == null)
	// return;
	// try {
	// // This runs the options, and shows progress.
	// new ProgressMonitorDialog(Display.getDefault().getActiveShell())
	// .run(true, false, operation);
	//
	// // Refresh the necessary state.
	// ((BasicCommandStack) getEditingDomain().getCommandStack())
	// .saveIsDone();
	// } catch (Exception exception) {
	// exception.printStackTrace();
	// }
	// }

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
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			// This is the method that gets invoked when the operation runs.
			public void run(IProgressMonitor monitor) {
				// Save the resources to the file system.
				try {
					monitor.beginTask("Saving history", 100);
					saveHistory();
					monitor.worked(50);
					monitor.subTask("Saving regular");
					saveRegular(saveOptions);
					monitor.done();
				} catch (Exception e) {
					e.printStackTrace();
					// List of possible exceptions.

//					MessageDialog.openError(Display.getDefault()
//							.getActiveShell(), "Error saving object",
//							"Error saving, rolling back. ");
					
					System.out.println("Can't save, rolling back");
					((IDawnEditor) CDOEditingService.this).getDawnEditorSupport().rollback();
				}
			}
		};

		return operation;
	}

	// TODO Remove later.
	// public IRunnableWithProgress doGetSaveHistoryOperation(
	// IProgressMonitor monitor) {
	// // Do the work within an operation because this is a long running
	// IRunnableWithProgress operation = new IRunnableWithProgress() {
	// // This is the method that gets invoked when the operation runs.
	// public void run(IProgressMonitor monitor) {
	// saveHistory();
	// }
	// };
	// return operation;
	// }

	private void saveRegular(final Map<Object, Object> saveOptions)
			throws IOException {
		boolean first = true;
		for (Resource resource : getEditingDomain().getResourceSet()
				.getResources()) {
			if ((first || !resource.getContents().isEmpty())
					&& !getEditingDomain().isReadOnly(resource)) {
				resource.save(saveOptions);
				first = false;
			}
		}
	}

	private void saveHistory() {
		ImmutableList<Resource> copyOf = ImmutableList
				.copyOf(getEditingDomain().getResourceSet().getResources());
		for (Resource resource : copyOf) {

			// Walk through the objects in the resource.
			if (resource instanceof CDOResource) {
				EClass hint;
				if ((hint = shouldHaveHistory(resource)) != null) {
					// Find all our dirty objects.
					TreeIterator<EObject> it = resource.getAllContents();
					while (it.hasNext()) {
						CDOObject cdoObject = (CDOObject) it.next();
						CDOState state = cdoObject.cdoState();
						// For State new, we won't be able to
						// resolve the CDOID.
						if (state.equals(CDOState.DIRTY)) {
							if (hint == LibraryPackage.Literals.NODE_TYPE) {
								doCopyNodeTypeToHistoryResource(cdoObject);
							}
							if (hint == OperatorsPackage.Literals.NODE) {
								doCopyNodeToHistoryResource(cdoObject);
							}
						}

					}
				}
			}
		}
	}

	/**
	 * Static acceptor for EClasses which should have a dirty.
	 * 
	 * @param resource
	 * @return
	 */
	public EClass shouldHaveHistory(Resource resource) {
		String name = ((CDOResource) resource).getName();
		if (name.equals(LibraryPackage.Literals.NODE_TYPE.getName())) {
			return LibraryPackage.Literals.NODE_TYPE;
		}
		if (name.equals(OperatorsPackage.Literals.OPERATOR.getName())) {
			return OperatorsPackage.Literals.NODE;
		}
		return null;
	}

	/**
	 * Creates a copy of the target object, and stores is in a resource which is
	 * named as the object class_the OID number.
	 * 
	 * As we use the current resource set to hold the history resource, this
	 * will automaticly be saved when saving the actual resource later on.
	 * 
	 * @param target
	 */
	public void doCopyNodeTypeToHistoryResource(CDOObject target) {

		target = modelUtils.resolveParentNodeType(target);
		if (target == null || !(target instanceof NodeType)) {
			return;
		}
		this.doCopyTarget(target);
	}

	/**
	 * Creates a copy of the target object, and stores is in a resource which is
	 * named as the object class_the OID number.
	 * 
	 * As we use the current resource set to hold the history resource, this
	 * will automaticly be saved when saving the actual resource later on.
	 * 
	 * @param target
	 */
	public void doCopyNodeToHistoryResource(CDOObject target) {

		target = modelUtils.resolveParentNode(target);
		if (target == null || !(target instanceof Node)) {
			return;
		}
		this.doCopyTarget(target);
	}

	private void doCopyTarget(CDOObject target) {
		String affectedPath = this.resolveHistoricalResourceName(target);
		if (affectedPath != null) {
			URI uri = URI.createURI(affectedPath);
			// Write a new version.
			Resource historyResource = dataService.getProvider().getResource(
					this.getEditingDomain().getResourceSet(), uri);

			// We make a copy, using a custom copier, as we don't want to copy
			// the references.
			Copier copier = new EcoreUtil.Copier();
			CDOObject copyOfTarget = (CDOObject) copier.copy(target);
			historyResource.getContents().add(copyOfTarget);
		}
	}

	/**
	 * Appends the cdo Object ID to the actual object resource name.
	 * 
	 * @param object
	 * @return
	 */
	public String resolveHistoricalResourceName(Object object) {

		// TODO, keep a cache of CDOObject ID, and resource path.
		CDOResource affectedResource = ((CDOObject) object).cdoResource();
		String affectedPath = affectedResource.getPath();

		// The object needs to be in the correct state.
		CDOID id = ((CDOObject) object).cdoID();
		if (id != null) {
			URI idURI = URI.createURI(id.toURIFragment());
			String fragment = idURI.fragment();
			if (fragment != null) {
				String[] fragments = fragment.split("#");
				affectedPath = affectedPath + "_"
						+ fragments[fragments.length - 1];
			}
			return affectedPath;
		} else
			return null;
	}

}
