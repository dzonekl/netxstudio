/*******************************************************************************
 * Copyright (c) 5 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.common.util;

import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;

/**
 * Views can add to site with: <br/>
 * <br/>
 * <code> 
 * IPartListener2 linkWithEditorPartListener  = new LinkWithEditorPartListener(this);
 * getSite().getPage().addPartListener(linkWithEditorPartListener);
 * </code>
 * 
 * Then, if the editor is from the Screens Framework, get the selection directly
 * from the editor. If supported by the view.
 * 
 * @author Christophe Bouhier
 * 
 */
public class LinkWithEditorPartListener implements IPartListener2 {

	private final ILinkedWithEditorView view;

	public LinkWithEditorPartListener(ILinkedWithEditorView view) {
		this.view = view;
	}

	public void partActivated(IWorkbenchPartReference ref) {
		IWorkbenchPart part = ref.getPart(true);
		if (part instanceof IViewPart) {
			view.editorActivated((IViewPart) part);
		}
	}

	public void partBroughtToTop(IWorkbenchPartReference ref) {
		IWorkbenchPart part = ref.getPart(true);
		if (part instanceof IViewPart) {
			view.editorActivated((IViewPart) part);
		}
	}

	public void partOpened(IWorkbenchPartReference ref) {
		IWorkbenchPart part = ref.getPart(true);
		if (part instanceof IViewPart) {
			view.editorActivated((IViewPart) part);
		}
	}

	public void partVisible(IWorkbenchPartReference ref) {
		IWorkbenchPart part = ref.getPart(true);
		if (part instanceof IViewPart) {
			view.editorActivated((IViewPart) part);
		}
	}

	public void partClosed(IWorkbenchPartReference ref) {
	}

	public void partDeactivated(IWorkbenchPartReference ref) {
	}

	public void partHidden(IWorkbenchPartReference ref) {
	}

	public void partInputChanged(IWorkbenchPartReference ref) {
	}
}
