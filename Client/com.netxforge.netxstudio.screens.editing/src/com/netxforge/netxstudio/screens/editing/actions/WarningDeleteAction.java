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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ListDialog;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;

/**
 * 
 * Action gives user feedback on what will be deleted.
 * 
 * @author dzonekl
 * 
 */
public class WarningDeleteAction extends DeleteAction {

	private IEditingService editingService;
	public static final int UNDO_LIMIT = 1;

	public WarningDeleteAction(boolean removeAllReferences,
			IEditingService editingService) {
		super(removeAllReferences);
		this.editingService = editingService;
	}

	@Override
	public void run() {

		if (command instanceof WarningNWBDeleteCommand) {

			Collection<EObject> eObjects = ((WarningNWBDeleteCommand) command)
					.getObjects();

			EObject first = eObjects.iterator().next();
			boolean questionResult = MessageDialog
					.openQuestion(
							Display.getCurrent().getActiveShell(),
							"Delete object of type (first object) : "
									+ first.eClass().getName(),
							"Are you sure you want to delete \""
									+ editingService.getDelegator().getText(
											first)
									+ "\". Related objects ("
									+ (eObjects.size() - 1)
									+ "), this operation can not be undone as the default undo limit("
									+ UNDO_LIMIT + ") is exceeded");
			if (questionResult) {
				super.run();
			}

		} else if (command instanceof WarningDeleteCommand) {

			Collection<EObject> eObjects = ((WarningDeleteCommand) command)
					.getObjects();

			EObject first = eObjects.iterator().next();

			boolean questionResult = MessageDialog.openQuestion(Display
					.getCurrent().getActiveShell(), "Delete object of type: "
					+ first.eClass().getName(),
					"Are you sure you want to delete \""
							+ editingService.getDelegator().getText(first)
							+ "\". Related objects (" + (eObjects.size() - 1)
							+ ")");
			if (questionResult) {

				// // Assume similar objects, skip cross-referencing for
				// NetXResource.
				// if(first instanceof NetXResource){
				// super.run();
				// return;
				// }

				List<CDOObjectReference> xRefs = ((WarningDeleteCommand) command)
						.getUsage(eObjects);

				// Issue warning here.
				if (xRefs != null && xRefs.size() > 0) {

					ListDialog ld = new ListDialog(Display.getCurrent()
							.getActiveShell());
					ld.setContentProvider(new ArrayContentProvider());
					ld.setLabelProvider(new LabelProvider() {
						@Override
						public String getText(Object element) {

							if (element instanceof CDOObjectReference) {
								EObject source = ((CDOObjectReference) element)
										.getSourceObject();
								EObject target = ((CDOObjectReference) element)
										.getTargetObject();
								return editingService.getDelegator().getText(
										source)
										+ " --> "
										+ editingService.getDelegator()
												.getText(target);
							}
							return null;
						}

					});
					ld.setTitle("Object references :");
					ld.setInput(xRefs);
					ld.setBlockOnOpen(true);
					int result = ld.open();
					if (result == Window.CANCEL) {
						System.err
								.println("WarningDeleteCommand: delete canceled");
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

		// Increment the target selection for certain objects.
		// Make sure we keep the order.
		Collection<Object> newSelection = Lists.newLinkedList();

		for (Object o : selection) {

			// For jobs, we also need to delete the job container.
			// ..this will also delete the workflow runs...
			if (o instanceof Job) {
				Job job = (Job) o;
				Resource jobRunContainerResource = editingService
						.getData(SchedulingPackage.Literals.JOB_RUN_CONTAINER);
				// find our jobcontainer .
				for (final EObject eObject : jobRunContainerResource
						.getContents()) {
					final JobRunContainer container = (JobRunContainer) eObject;
					final Job containerJob = container.getJob();
					final CDOID containerJobId = ((CDOObject) containerJob)
							.cdoID();
					if (job.cdoID().equals(containerJobId)) {
						newSelection.add(container);
						// newSelection.add(job);
						break;
					}
				}
			}
		}

		if (newSelection.size() == 0 && selection.size() > 0) {
			newSelection.addAll(selection);
		}

		if (EditingActivator.DEBUG) {
			for (Object o : newSelection) {
				CDOObject cdoObject = (CDOObject) o;
				System.out.println("delete selection=" + cdoObject.eClass()
						+ " state=" + cdoObject.cdoState());
			}
		}

		Command c;

//		// Specialize deletion of large amount of objects.
//		if (newSelection.size() >= UNDO_LIMIT) {
//			if (EditingActivator.DEBUG) {
//				System.out
//						.println("Undo limit reached, "
//								+ newSelection.size()
//								+ " objects selected for deletion (Excluding children)");
//			}
//			c = createNWBCommand(newSelection);
//		} else {

			// check the objects, is a NetXResource, create dummy command,
			// not executed on the command stack.
			c = removeAllReferences ? WarningDeleteCommand.create(domain,
					newSelection) : RemoveCommand.create(domain, newSelection);
//		}
		return c;
	}

	private Command createNWBCommand(Collection<?> selection) {

		return WarningNWBDeleteCommand.create(domain, selection);
	}
}
