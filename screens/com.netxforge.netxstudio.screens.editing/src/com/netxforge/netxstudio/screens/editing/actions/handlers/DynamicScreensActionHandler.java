/*******************************************************************************
 * Copyright (c) Aug 2, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.actions.handlers;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;

import com.netxforge.netxstudio.screens.editing.actions.SeparatorAction;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;

/**
 * An action handler which accepts non-predefined actions.
 */
public class DynamicScreensActionHandler extends AbstractActionHandler {

	@SuppressWarnings("unused")
	private IStructuredSelection selection;

	private List<IAction> actions;

	public void initActions(IActionBars actionBars) {
		// Ignore for dynamic screen actions, as we would ....
	}

	public void showMenu(ActionHandlerDescriptor descriptor) {
		IMenuManager menuManager = descriptor.getMenuManager();
		this.addActions(menuManager);
	}

	public void addActions(List<IAction> actions) {
		this.actions = actions;
	}

	private void addActions(IMenuManager menuManager) {

		for (IAction action : actions) {
			if (EditingActivator.DEBUG) {
				EditingActivator.TRACE.trace("/debug",
						"inserting dynanmic action" + action.getText());
				// System.out.println("EDITING: update action=" +
				// action.getText());
			}
			if (action instanceof SeparatorAction) {
				menuManager.insertAfter("screen", new Separator());
			} else {
				menuManager.insertAfter("screen", action);
			}
		}
	}

	@Override
	public void handleSelection(IStructuredSelection ss) {
		this.selection = ss;

		if (EditingActivator.DEBUG && !ss.isEmpty()) {
			EditingActivator.TRACE.trace(null, "update selection: " + ss);
		}

		for (IAction action : actions) {

			if (action instanceof com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction) {
				com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction bsla = (com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction) action;
				bsla.selectionChanged(ss);
			} else if (action instanceof org.eclipse.ui.actions.BaseSelectionListenerAction) {
				org.eclipse.ui.actions.BaseSelectionListenerAction bsla = (org.eclipse.ui.actions.BaseSelectionListenerAction) action;
				bsla.selectionChanged(ss);

			}
		}
	}

}
