/*******************************************************************************
 * Copyright (c) 2007, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package com.netxforge.netxstudio.navigator.resources;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IAggregateWorkingSet;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.navigator.framelist.Frame;
import org.eclipse.ui.internal.navigator.framelist.FrameList;
import org.eclipse.ui.internal.navigator.framelist.TreeFrame;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.INavigatorContentService;

import com.netxforge.netxstudio.internal.navigator.resources.ResourceToItemsMapper;
import com.netxforge.netxstudio.internal.navigator.resources.plugin.WorkbenchNavigatorMessages;

/**
 * 
 * @see CommonNavigator
 * @see INavigatorContentService
 * @since 3.2
 * 
 */
public final class NetXStudioExplorer extends CommonNavigator {

	/**
	 * Provides a constant for the standard instance of the Common Navigator.
	 * 
	 * @see PlatformUI#getWorkbench()
	 * @see IWorkbench#getActiveWorkbenchWindow()
	 * @see IWorkbenchWindow#getActivePage()
	 * 
	 * @see IWorkbenchPage#findView(String)
	 * @see IWorkbenchPage#findViewReference(String)
	 */
	public static final String VIEW_ID = "com.netxforge.netxstudio.navigator.ProjectExplorer";

	/**
	 * Our root object.
	 */
	private INetXStudioRoot root = new NetXStudioRoot(ResourcesPlugin
			.getWorkspace().getRoot());

	/**
	 * @since 3.4
	 */
	public static final int WORKING_SETS = 0;

	/**
	 * @since 3.4
	 */
	public static final int PROJECTS = 1;

	private int rootMode;

	/**
	 * Used only in the case of top level = PROJECTS and only when some working
	 * sets are selected.
	 */
	private String workingSetLabel;

	public void createPartControl(Composite aParent) {
		super.createPartControl(aParent);

		if (!false)
			getCommonViewer().setMapper(
					new ResourceToItemsMapper(getCommonViewer()));
	}

	/**
	 * The superclass does not deal with the content description, handle it
	 * here.
	 * 
	 * @noreference
	 */
	public void updateTitle() {
		super.updateTitle();
		Object input = getCommonViewer().getInput();

		if (input == null || input instanceof IAggregateWorkingSet) {
			setContentDescription(""); //$NON-NLS-1$
			return;
		}

		if (!(input instanceof IResource)) {
			if (input instanceof IAdaptable) {
				IWorkbenchAdapter wbadapter = (IWorkbenchAdapter) ((IAdaptable) input)
						.getAdapter(IWorkbenchAdapter.class);
				if (wbadapter != null) {
					setContentDescription(wbadapter.getLabel(input));
					return;
				}
			}
			setContentDescription(input.toString());
			return;
		}

		IResource res = (IResource) input;
		setContentDescription(res.getName());
	}

	/**
	 * Returns the tool tip text for the given element.
	 * 
	 * @param element
	 *            the element
	 * @return the tooltip
	 * @noreference
	 */
	public String getFrameToolTipText(Object element) {
		String result;
		if (!(element instanceof IResource)) {
			if (element instanceof IAggregateWorkingSet) {
				result = WorkbenchNavigatorMessages.ProjectExplorerPart_workingSetModel;
			} else if (element instanceof IWorkingSet) {
				result = ((IWorkingSet) element).getLabel();
			} else {
				result = super.getFrameToolTipText(element);
			}
		} else {
			IPath path = ((IResource) element).getFullPath();
			if (path.isRoot()) {
				result = WorkbenchNavigatorMessages.ProjectExplorerPart_workspace;
			} else {
				result = path.makeRelative().toString();
			}
		}

		if (rootMode == PROJECTS) {
			if (workingSetLabel == null)
				return result;
			if (result.length() == 0)
				return NLS.bind(
						WorkbenchNavigatorMessages.ProjectExplorer_toolTip,
						new String[] { workingSetLabel });
			return NLS.bind(
					WorkbenchNavigatorMessages.ProjectExplorer_toolTip2,
					new String[] { result, workingSetLabel });
		}

		// Working set mode. During initialization element and viewer can
		// be null.
		if (element != null && !(element instanceof IWorkingSet)
				&& getCommonViewer() != null) {
			FrameList frameList = getCommonViewer().getFrameList();
			// Happens during initialization
			if (frameList == null)
				return result;
			int index = frameList.getCurrentIndex();
			IWorkingSet ws = null;
			while (index >= 0) {
				Frame frame = frameList.getFrame(index);
				if (frame instanceof TreeFrame) {
					Object input = ((TreeFrame) frame).getInput();
					if (input instanceof IWorkingSet
							&& !(input instanceof IAggregateWorkingSet)) {
						ws = (IWorkingSet) input;
						break;
					}
				}
				index--;
			}
			if (ws != null) {
				return NLS.bind(
						WorkbenchNavigatorMessages.ProjectExplorer_toolTip3,
						new String[] { ws.getLabel(), result });
			}
			return result;
		}
		return result;

	}

	/**
	 * @param mode
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 3.4
	 */
	public void setRootMode(int mode) {
		rootMode = mode;
	}

	/**
	 * @return the root mode
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 3.4
	 */
	public int getRootMode() {
		return rootMode;
	}

	/**
	 * @param label
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 3.4
	 */
	public void setWorkingSetLabel(String label) {
		workingSetLabel = label;
	}

	/**
	 * @return the working set label
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 3.4
	 */
	public String getWorkingSetLabel() {
		return workingSetLabel;
	}

	@Override
	protected Object getInitialInput() {
		// TeneoUI.INSTANCE.getSet().eAdapters().add(cnfResourceSetAdapter);
		// We should add our CNF listener based on an Edit part being added. 
		// return root;
		return ResourcesPlugin.getWorkspace().getRoot();
	}

//	protected EContentAdapter cnfResourceSetAdapter = new EContentAdapter() {
//		@Override
//		public void notifyChanged(Notification notification) {
//			if (notification.getNotifier() instanceof Resource) {
//				switch (notification.getFeatureID(Resource.class)) {
//				case Resource.RESOURCE__IS_LOADED:
//				case Resource.RESOURCE__ERRORS:
//				case Resource.RESOURCE__WARNINGS: {
//					Resource resource = (Resource) notification.getNotifier();
//					System.out.println("Set changed:"
//							+ resource.getURI().toString());
//					// Run on UI Thread. 
//					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
//						@Override
//						public void run() {
//							NetXStudioExplorer.this.getCommonViewer().refresh();
//						}
//					});
//				}
//				}
//			} else {
//				super.notifyChanged(notification);
//			}
//		}
//
//		@Override
//		protected void setTarget(Resource target) {
//			basicSetTarget(target);
//		}
//
//		@Override
//		protected void unsetTarget(Resource target) {
//			basicUnsetTarget(target);
//		}
//	};
//
//	ResourceSetListener setListener = new ResourceSetListenerImpl() {
//
//		@Override
//		public void resourceSetChanged(ResourceSetChangeEvent event) {
//			super.resourceSetChanged(event);
//			List<Notification> notifies = event.getNotifications();
//			for (Notification notification : notifies) {
//				if (notification.getNotifier() instanceof Resource) {
//					switch (notification.getFeatureID(Resource.class)) {
//					case Resource.RESOURCE__IS_LOADED:
//					case Resource.RESOURCE__ERRORS:
//					case Resource.RESOURCE__WARNINGS: {
//						// Update our viewer.
//						System.out.println("Set changed, resource added"
//								+ notification.getNotifier());
//						break;
//					}
//					}
//				}
//			}
//		}
//	};

}
