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
package com.netxforge.netxstudio.callflow.screens.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;

import com.netxforge.netxstudio.callflow.screens.diagram.DiagramScreen;
import com.netxforge.screens.editing.base.AbstractScreenSelector;
import com.netxforge.screens.editing.base.AbstractScreenViewer;
import com.netxforge.screens.editing.base.IScreen;
import com.netxforge.screens.editing.base.ScreenUtil;

/**
 * A Chart screen in a viewer.
 * 
 * @author Christophe Bouhier
 * 
 */
public class DiagramScreenViewer extends AbstractScreenViewer {

	private DiagramScreen diagramScreen;

	public IScreen getScreen() {
		return diagramScreen;
	}

	public void initScreen(Composite parent) {
		diagramScreen = new DiagramScreen(parent, SWT.NONE);
		diagramScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
		diagramScreen.setEditingService(getEditingService());
		diagramScreen.buildUI();
	}

	public void editorActivated(IViewPart activeView) {
		if (activeView instanceof AbstractScreenSelector) {
			ISelection selection = ((AbstractScreenSelector) activeView)
					.getSelection();
			if (selection != null && !selection.isEmpty()
					&& selection instanceof StructuredSelection) {
				Object firstElement = ((StructuredSelection) selection)
						.getFirstElement();
				if (firstElement instanceof EObject) {
//					System.out.println(modelUtils
//							.printModelObject((EObject) firstElement));
				}
			}

		}
	}
}
