/*******************************************************************************
 * Copyright (c) Aug 3, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ListDialog;

public class WarningDeleteAction extends DeleteAction {

	public WarningDeleteAction(boolean removeAllReferences) {
		super(removeAllReferences);
	}

	@Override
	public void run() {

		if (command instanceof WarningDeleteCommand) {

			Map<EObject, Collection<Setting>> usage = ((WarningDeleteCommand) command)
					.getUsage();
			// Issue warning here.
			if (usage.size() > 0) {

				ListDialog ld = new ListDialog(Display.getCurrent()
						.getActiveShell());
				ld.setContentProvider(new ArrayContentProvider());
				ld.setLabelProvider(new LabelProvider());
				ld.setTitle("Object references :");
				ld.setBlockOnOpen(true);
				int result = ld.open();
				if (result == Window.CANCEL) {
					System.err.println("WarningDeleteCommand: delete canceled");
					// Should actually clean the command stack.....
					return;
				}
			}
		}
		super.run();

	}

	@Override
	public Command createCommand(Collection<?> selection) {
		return removeAllReferences ? WarningDeleteCommand.create(domain,
				selection) : RemoveCommand.create(domain, selection);
	}
}
