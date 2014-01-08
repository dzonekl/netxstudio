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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.util.EresourceAdapterFactory;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.swt.widgets.Display;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.editing.dawn.DawnEMFEditorSupport;
import com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor;
import com.netxforge.netxstudio.screens.editing.dawn.IDawnEditorSupport;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;

/**
 * For the lifetime of this service, we keep various editing facilities. We also
 * proxy to various other services, like a data and validation service.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class CDOEditingService extends EMFEditingService implements
		IDawnEditor, IViewerProvider, IScreenProvider {

	/**
	 * Our editor support for Dawn.
	 */
	private DawnEMFEditorSupport dawnEditorSupport;

	@Inject
	public CDOEditingService(IDataService dataService, ModelUtils modelUtils) {
		super(dataService, modelUtils);
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

		// save could be triggered from
		CDOView view = dawnEditorSupport.getView();
		if (view instanceof CDOTransaction) {

			if (view.isDirty()) {
				modelUtils.cdoDumpDirtyObject((CDOTransaction) view);
			}

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
			dawnEditorSupport.registerListeners();
		}
		return res;
	}

	public Resource getData(EClass clazz) {

		sessionStillValid();
		Resource res = dataService.getProvider().getResource(
				this.getEditingDomain().getResourceSet(), clazz);

		if (res instanceof CDOResource) {
			// we could fail adding listeners, as these might already exist.
			CDOView cdoView = ((CDOResource) res).cdoView();
			dawnEditorSupport.setView(cdoView);
			dawnEditorSupport.registerListeners();
		}

		return res;
	}

	public List<Resource> getData(String path) {
		// Check if we have a view already.
		sessionStillValid();
		List<Resource> resources = dataService.getProvider().getResources(
				this.getEditingDomain().getResourceSet(), path);

		if (resources != null && resources.size() > 0) {
			dawnEditorSupport.setView(((CDOResource) resources.get(0))
					.cdoView());

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
	private void disposeData(Resource res) {

		if (res instanceof CDOResource) {
			CDOView v = dawnEditorSupport.getView();

			CDOResource cdoRes = (CDOResource) res;
			if (cdoRes.cdoView().equals(v)) {
				// Unload has no effect.
				if (cdoRes.isLoaded()) {
					cdoRes.unload();
				}

				// Closes the view before de-registrating the listners to get
				// lifecycle notifications.
				dawnEditorSupport.close();

				// Clean up listeners.
				IListener[] listeners = cdoRes.cdoView().getListeners();
				if (listeners != null) {
					for (IListener l : listeners) {
						cdoRes.cdoView().removeListener(l);
					}
				}
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return this.delegateViewerProvider.getViewer();
	}

	public IScreen getScreen() {
		return this.delegateScreenProvider.getScreen();
	}

	public IScreen[] getScreens() {
		return this.delegateScreenProvider.getScreens();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.IEditingService#isDirty()
	 */
	public boolean isDirty() {

		boolean result = false;

		// CB 19-12-2011, disable dirty state for the editing domain, this will
		// force usage of
		// save link, when we deal with a detached object. (As a operations on a
		// detached object are not marked dirty in
		// in the CDO View).

		// boolean result = ((BasicCommandStack) getEditingDomain()
		// .getCommandStack()).isSaveNeeded();

		// Note views get dirty when invalidated ! state proxy.

		if (this.getView() != null) {
			boolean viewDirty = this.getView().isDirty();
			if (EditingActivator.DEBUG && viewDirty) {
				printDirtyState();
			}
			result |= viewDirty;
		}

		// Check the standalone transaction for dirtyness...
		CDOTransaction transaction = this.dataService.getProvider()
				.getTransaction();
		if (transaction != null) {
			boolean transactionDirty = transaction.isDirty();
			if (EditingActivator.DEBUG && transactionDirty) {
				printDirtyState(transaction);
			}
			if (transactionDirty) {
				result |= true;
			}
		}

		return result;
	}

	/*
	 * Print the dirty state (If in debugging mode only).
	 */
	private void printDirtyState() {
		EditingActivator.TRACE.trace(EditingActivator.TRACE_EDITING_OPTION,
				" Requesting dirty state");
		CDOView view = this.getView();
		printDirtyState(view);
	}

	private void printDirtyState(CDOView view) {
		if (view instanceof CDOTransaction) {
			CDOTransaction transaction = (CDOTransaction) view;
			Map<CDOID, CDOObject> dirtyObjects = transaction.getDirtyObjects();
			for (CDOID id : dirtyObjects.keySet()) {
				CDOObject cdoObject = dirtyObjects.get(id);
				EditingActivator.TRACE.trace(
						EditingActivator.TRACE_EDITING_OPTION, "dirty object="
								+ cdoObject.cdoID().toURIFragment()
								+ " , state=" + cdoObject.cdoState() + ", rev="
								+ cdoObject.cdoRevision()
								+ " , dangling state="
								+ cdoObject.cdoID().isDangling());
			}
		}
	}

	/**
	 * Return the data status for this service.
	 * 
	 * @return
	 */
	public String printDataStatus() {
		return dataService.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.dawn.IDawnEditor#setDirty()
	 */
	public void setDirty() {
		dawnEditorSupport.setDirty(true);
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
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			// This is the method that gets invoked when the operation runs.
			public void run(IProgressMonitor monitor) {
				// Save the resources to the file system.
				try {
					monitor.beginTask("Saving all Objects", 100);

					// FIXME, REVISION HANDLING WITH NEW STORE.
					// monitor.subTask("Copy history");
					// saveHistory();
					monitor.worked(50);
					monitor.subTask("Committing transaction from regular view");
					CDOTransaction transaction = getView() instanceof CDOTransaction ? (CDOTransaction) getView()
							: null;
					if (transaction != null) {
						commitRegular(monitor, transaction);
					}
					monitor.subTask("Committing transaction from regular view");
					transaction = dataService.getProvider().getTransaction();
					if (transaction != null) {
						commitRegular(monitor, transaction);
					}

					monitor.done();
				} catch (Exception e) {
					e.printStackTrace();
					// List of possible exceptions.

					// MessageDialog.openError(Display.getDefault()
					// .getActiveShell(), "Error saving object",
					// "Error saving, rolling back. ");
					if (EditingActivator.DEBUG) {
						System.out.println("Can't save, rolling back");
					}

					((IDawnEditor) CDOEditingService.this)
							.getDawnEditorSupport().rollback();
				}
			}
		};

		return operation;
	}

	@SuppressWarnings("unused")
	private void saveRegular(IProgressMonitor monitor,
			final Map<Object, Object> saveOptions) throws IOException {
		boolean first = true;
		for (Resource resource : getEditingDomain().getResourceSet()
				.getResources()) {

			if ((first || !resource.getContents().isEmpty())
					&& !getEditingDomain().isReadOnly(resource)) {

				if (resource instanceof CDOResource) {
					CDOResource cdoRes = (CDOResource) resource;
					CDOState cdoState = cdoRes.cdoState();
					CDOView cdoView = cdoRes.cdoView();

					// Print saving state.
					if (EditingActivator.DEBUG) {
						EditingActivator.TRACE.trace(
								EditingActivator.TRACE_EDITING_OPTION,
								"Saving resource: "
										+ cdoRes.getURI().toString()
										+ ", state=" + cdoState.name());

					}

					if (cdoView instanceof CDOTransaction) {
						Map<CDOID, CDOObject> dirtyObjects = ((CDOTransaction) cdoView)
								.getDirtyObjects();
						String subMsg = "Saving resource: " + cdoRes.getPath()
								+ " object count=" + dirtyObjects.size();
						monitor.subTask(subMsg);
					}

				}

				resource.save(saveOptions);
				first = false;
			}
		}
	}

	private void commitRegular(IProgressMonitor monitor,
			CDOTransaction transaction) throws CommitException {

		if (EditingActivator.DEBUG) {
			EditingActivator.TRACE.trace(
					EditingActivator.TRACE_EDITING_OPTION,
					"Commit transaction: " + transaction.getViewID()
							+ " last time update"
							+ new Date(transaction.getLastUpdateTime()));

			if (transaction.isDirty()) {
				Map<CDOID, CDOObject> dirtyObjects = transaction
						.getDirtyObjects();

				for (CDOID id : dirtyObjects.keySet()) {
					CDOObject cdoObject = dirtyObjects.get(id);
					EditingActivator.TRACE.trace(
							EditingActivator.TRACE_EDITING_OPTION,
							"-- dirty object="
									+ cdoObject.cdoID().toURIFragment()
									+ " , state=" + cdoObject.cdoState()
									+ ", rev=" + cdoObject.cdoRevision()
									+ " , dangling state="
									+ cdoObject.cdoID().isDangling());

					// CB, this forces all CDO Objects to be read, as our
					// cdoObject could be the root resource.
					// "/" when a child resource is created!
					// TreeIterator<EObject> eAllContents = cdoObject
					// .eAllContents();
					// while (eAllContents.hasNext()) {
					// CDOObject next = (CDOObject) eAllContents.next();
					// System.out.println("-- content object="
					// + next.cdoID().toURIFragment() + " , state=" +
					// next.cdoState() +", rev="
					// + next.cdoRevision() + " , dangling state="
					// + next.cdoID().isDangling() );
					// }
				}
			}
		}

		if (monitor != null) {
			Map<CDOID, CDOObject> dirtyObjects = transaction.getDirtyObjects();
			String subMsg = "Committing transaction: "
					+ transaction.getViewID() + " object count="
					+ dirtyObjects.size();
			monitor.subTask(subMsg);

		}
		transaction.setCommitComment(IData.CLIENT_COMMIT_COMMENT);
		transaction.commit();

	}

	/**
	 * Save a history of objects of type Node or NodeType We can't save an
	 * initial copy when the state is NEW, as no CDOID will exist yet, and this
	 * is what we base the Resource Name on. (We append the CDOID to the default
	 * object resource name).
	 */
	@SuppressWarnings("unused")
	private void saveHistory() {
		ImmutableList<Resource> copyOf = ImmutableList
				.copyOf(getEditingDomain().getResourceSet().getResources());
		for (Resource resource : copyOf) {
			// Walk through the objects in the resource.
			if (resource instanceof CDOResource) {
				CDOResource cdoRes = (CDOResource) resource;
				if (cdoRes.cdoView() instanceof CDOTransaction) {
					CDOTransaction cdoTransaction = (CDOTransaction) cdoRes
							.cdoView();
					Map<CDOID, CDOObject> dirtyObjects = cdoTransaction
							.getDirtyObjects();

					cdoTransaction.getNewObjects();

					if (dirtyObjects.size() > 0) {

						// Create a copy, to avoid concurrency issues.
						ImmutableList<CDOObject> dirtyObjectsList = ImmutableList
								.copyOf(dirtyObjects.values());

						EClass hint;
						if ((hint = shouldHaveHistory(cdoRes)) != null) {

							// Build a cache of unique nodetypes.
							// Use the node type as the point of reference.
							// the copy will resolve either NodeType or Node
							// depending
							// on the hint.
							List<NodeType> uniqueNodeTypes = Lists
									.newArrayList();

							for (CDOObject cdoObject : dirtyObjectsList) {

								NodeType resolveNodeType = null;
								if (hint == LibraryPackage.Literals.NODE_TYPE) {
									resolveNodeType = modelUtils
											.resolveParentNodeType(cdoObject);
								} else if (hint == OperatorsPackage.Literals.NODE) {
									if (cdoObject.eClass() == OperatorsPackage.Literals.NODE) {
										resolveNodeType = ((Node) cdoObject)
												.getNodeType();
									} else {
										resolveNodeType = modelUtils
												.resolveParentNodeType(cdoObject);
									}
								}
								if (resolveNodeType != null
										&& !uniqueNodeTypes
												.contains(resolveNodeType)) {
									uniqueNodeTypes.add(resolveNodeType);
								}
							}

							for (CDOObject cdoObject : uniqueNodeTypes) {
								if (hint == LibraryPackage.Literals.NODE_TYPE) {
									doCopyNodeTypeToHistoryResource(cdoObject);
								} else if (hint == OperatorsPackage.Literals.NODE) {
									doCopyNodeToHistoryResource(cdoObject);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Static acceptor for EClasses which should have a history.
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
		target = modelUtils.nodeFor(target);
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

	/*
	 * Delegate to ModelUtils. (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.IEditingService#
	 * resolveHistoricalResourceName(java.lang.Object)
	 */
	public String resolveHistoricalResourceName(Object object) {
		return modelUtils.resolveHistoricalResourceName(object);
	}

	public void sessionStillValid() {
		try {
			this.dataService.getProvider().getSession();
		} catch (final IllegalStateException ise) {

			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					// Session is dead, we should close.
					MessageDialog
							.openError(
									Display.getDefault().getActiveShell(),
									"Connection to server lost",
									"There is currently no connection with the Server"
											+ "\nPlease exit and try to login again to re-establish the connection");
					throw ise;
				}

			});
		}
	}

	public void handleStale(final EObject source,
			final EStructuralFeature feature, final int index,
			final CDOID target) {

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				// Session is dead, we should close.
				MessageDialog
						.openError(
								Display.getDefault().getActiveShell(),
								"Trying to load nong-existing object",
								"Source Object: "
										+ modelUtils.printModelObject(source)
										+ "\n"
										+ "Reference: "
										+ feature.getName()
										+ "\n"
										+ "Index: "
										+ index
										+ "\n"
										+ "ID of targeted object: "
										+ target
										+ "\n"
										+ "this will happens when a referenced object is deleted and potential references"
										+ "to it are not removed.\n"
										+ "Now attempting to clean this reference, please retry your previous action"

						);

				CDOUtil.cleanStaleReference(source, feature, index);

			}

		});
	}

	public static AdapterFactory getAdapterFactory() {
		AdapterFactory adapterFactory = EMFEditingService.getAdapterFactory();
		if (adapterFactory instanceof ComposedAdapterFactory) {
			((ComposedAdapterFactory) adapterFactory)
					.addAdapterFactory(new EresourceAdapterFactory());
		}
		return adapterFactory;
	}

}
