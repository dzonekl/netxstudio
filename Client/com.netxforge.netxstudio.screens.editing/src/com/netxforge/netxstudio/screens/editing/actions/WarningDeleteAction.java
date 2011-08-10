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
import java.util.List;

import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ListDialog;

import com.netxforge.netxstudio.screens.editing.IEditingService;

public class WarningDeleteAction extends DeleteAction {

	private IEditingService editingService;

	public WarningDeleteAction(boolean removeAllReferences, IEditingService editingService) {
		super(removeAllReferences);
		this.editingService = editingService;
	}

	@Override
	public void run() {

		if (command instanceof WarningDeleteCommand) {

			Collection<EObject> eObjects = ((WarningDeleteCommand) command)
					.getObjects();

			EObject first = eObjects.iterator().next();
			
			boolean questionResult = MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
					"Delete object of type: " + first.eClass().getName(), "Are you sure you want to delete \""
							+ editingService.getDelegator().getText(first) 
							+ "\" and all contained objects ("
							+ (eObjects.size() - 1) + ")");
			if(questionResult){
				List<CDOObjectReference> xRefs = ((WarningDeleteCommand) command)
						.getUsage(eObjects);
				// Issue warning here.
				if (xRefs != null && xRefs.size() > 0) {

					ListDialog ld = new ListDialog(Display.getCurrent()
							.getActiveShell());
					ld.setContentProvider(new ArrayContentProvider());
					ld.setLabelProvider(new LabelProvider(){
						@Override
						public String getText(Object element) {
							
							if(element instanceof CDOObjectReference){
								EObject source = ((CDOObjectReference) element).getSourceObject();
								EObject target = ((CDOObjectReference) element).getTargetObject();
								return editingService.getDelegator().getText(source) + " --> " + editingService.getDelegator().getText(target);
							}
							return null;
						}
						
					});
					ld.setTitle("Object references :");
					ld.setInput(xRefs.toArray());
					ld.setBlockOnOpen(true);
					int result = ld.open();
					if (result == Window.CANCEL) {
						System.err.println("WarningDeleteCommand: delete canceled");
						// Should actually clean the command stack.....
						return;
					}
				}
				super.run();
			}
		}
		

	}

	@Override
	public Command createCommand(Collection<?> selection) {
		return removeAllReferences ? WarningDeleteCommand.create(domain,
				selection) : RemoveCommand.create(domain, selection);
	}
}
