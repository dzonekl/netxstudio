/*******************************************************************************
 * Copyright (c) 2006, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Anton Leherbauer (Wind River Systems) - http://bugs.eclipse.org/247294
 ******************************************************************************/

package org.eclipse.ui.navigator.resources;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.internal.navigator.Policy;
import org.eclipse.ui.navigator.CommonDragAdapterAssistant;
import org.eclipse.ui.navigator.INavigatorDnDService;
import org.eclipse.ui.part.ResourceTransfer;

/**
 * Clients may reference this class in the <b>dragAssistant</b> element of a
 * <b>org.eclipse.ui.navigator.viewer</b> extension point.
 * 
 * <p>
 * Clients may not extend or instantiate this class for any purpose other than
 * {@link INavigatorDnDService#bindDragAssistant(CommonDragAdapterAssistant)}.
 * Clients may have no direct dependencies on the contract of this class.
 * </p>
 * 
 * @since 3.2
 * @noextend This class is not intended to be subclassed by clients.
 * 
 */
public class ResourceDragAdapterAssistant extends
		CommonDragAdapterAssistant {

	private static final Transfer[] SUPPORTED_TRANSFERS = new Transfer[] {
			ResourceTransfer.getInstance(),
			FileTransfer.getInstance() };

	private static final Class IRESOURCE_TYPE = IResource.class;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.CommonDragAdapterAssistant#getSupportedTransferTypes()
	 */
	public Transfer[] getSupportedTransferTypes() {
		return SUPPORTED_TRANSFERS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.CommonDragAdapterAssistant#setDragData(org.eclipse.swt.dnd.DragSourceEvent,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public boolean setDragData(DragSourceEvent anEvent,
			IStructuredSelection aSelection) {

		IResource[] resources = getSelectedResources(aSelection);
		if (resources.length > 0) {
			if (ResourceTransfer.getInstance().isSupportedType(anEvent.dataType)) {
				anEvent.data = resources;
				if (Policy.DEBUG_DND) {
					System.out
							.println("ResourceDragAdapterAssistant.dragSetData set ResourceTransfer"); //$NON-NLS-1$
				}
				return true;
			} 
				
			if (FileTransfer.getInstance().isSupportedType(anEvent.dataType)) {
				// Get the path of each file and set as the drag data
				final int length = resources.length;
				int actualLength = 0;
				String[] fileNames = new String[length];
				for (int i = 0; i < length; i++) {
					IPath location = resources[i].getLocation();
					// location may be null. See bug 29491.
					if (location != null) {
						fileNames[actualLength++] = location.toOSString();
					}
				}
				if (actualLength > 0) { 
					// was one or more of the locations null?
					if (actualLength < length) {
						String[] tempFileNames = fileNames;
						fileNames = new String[actualLength];
						for (int i = 0; i < actualLength; i++)
							fileNames[i] = tempFileNames[i];
					}
					anEvent.data = fileNames;
		
					if (Policy.DEBUG_DND)
						System.out
								.println("ResourceDragAdapterAssistant.dragSetData set FileTransfer"); //$NON-NLS-1$
					return true;
				}
			}
		}
		return false;

	}

	private IResource[] getSelectedResources(IStructuredSelection aSelection) {
		Set resources = new LinkedHashSet();
		IResource resource = null;
		for (Iterator iter = aSelection.iterator(); iter.hasNext();) {
			Object selected = iter.next();
			resource = adaptToResource(selected);
			if (resource != null) {
				resources.add(resource);
		}
		}
		return (IResource[]) resources.toArray(new IResource[resources.size()]);
	}

	private IResource adaptToResource(Object selected) {
		IResource resource;
		if (selected instanceof IResource) {
			resource = (IResource) selected;
		} else if (selected instanceof IAdaptable) {
			resource = (IResource) ((IAdaptable) selected)
					.getAdapter(IRESOURCE_TYPE);
		} else {
			resource = (IResource) Platform.getAdapterManager().getAdapter(
					selected, IRESOURCE_TYPE);
		}
		return resource;
	}

}
