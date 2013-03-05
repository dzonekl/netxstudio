/*******************************************************************************
 * Copyright (c) Nov 7, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.actions;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.screens.ScreenDialog;
import com.netxforge.netxstudio.screens.ch9.ObjectExpressions;
import com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

/**
 * @author Christophe Bouhier
 */
public class ExpressionsAction extends BaseSelectionListenerAction {

	private IScreenFormService screenService;

	public ExpressionsAction(IScreenFormService screenService, String text) {
		super(text);
		this.screenService = screenService;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof Component) {
			Component c = (Component) firstElement;
			return c.eIsSet(LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF);
		}
		return false;
	}

	@Override
	public void run() {
		IStructuredSelection structuredSelection = this
				.getStructuredSelection();

		Object firstElement = structuredSelection.getFirstElement();
		if (firstElement instanceof Component) {

			Component comp = (Component) firstElement;

			ScreenDialog dialog = new ScreenDialog(Display.getDefault()
					.getActiveShell());
			dialog.create();
			dialog.inializeScreenFor(ObjectExpressions.class);
			dialog.screen().setScreenService(screenService);
			dialog.screen().setOperation(ScreenUtil.OPERATION_EDIT);
			ScreenUtil.dataScreenInjectionFor(dialog.screen()).injectData(
					comp.eResource(), comp);

			dialog.getShell().layout(true, true);
			dialog.open();
		}
	}

}