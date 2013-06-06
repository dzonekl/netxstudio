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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.dialogs.ListDialog;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.actions.TableViewerWithState.StateSelectionChangedEvent;

/**
 * 
 * Action gives user feedback on what will be deleted.
 * 
 * @author Christophe Bouhier
 * 
 */
public class WarningDeleteAction extends DeleteAction {

	private IEditingService editingService;
	private boolean nwb;
	public static final int UNDO_LIMIT = 1;

	public WarningDeleteAction(boolean removeAllReferences,
			IEditingService editingService) {
		super(removeAllReferences);
		this.editingService = editingService;
	}

	@Override
	public void runWithEvent(Event event) {
		nwb = (event.stateMask & SWT.ALT) != 0 ? true : false;
		run();
	}

	@Override
	public void run() {
		if (nwb) {
			doRunNoWayBack();
		} else {
			doRunUndo();
		}
		nwb = false;
	}

	/**
	 * Run the delete with undo.
	 */
	private void doRunUndo() {
		Collection<EObject> eObjects = ((WarningDeleteCommand) command)
				.getObjects();

		EObject first = eObjects.iterator().next();

		boolean questionResult = MessageDialog
				.openQuestion(Display.getCurrent().getActiveShell(),
						"Delete object of type: " + first.eClass().getName(),
						"Are you sure you want to delete \""
								+ editingService.getDelegator().getText(first)
								+ "\". Related objects ("
								+ (eObjects.size() - 1) + ")");
		if (questionResult && warnUserOnReferences(eObjects)) {
			domain.getCommandStack().execute(command);
		}
	}

	/**
	 * Run the delete without undo.
	 */
	private void doRunNoWayBack() {
		Collection<EObject> eObjects = ((WarningNWBDeleteCommand) command)
				.getObjects();

		EObject first = eObjects.iterator().next();
		boolean questionResult = MessageDialog
				.openQuestion(
						Display.getCurrent().getActiveShell(),
						"Delete object of type (first object) : "
								+ first.eClass().getName(),
						"Are you sure you want to delete \""
								+ editingService.getDelegator().getText(first)
								+ "\". Related objects ("
								+ (eObjects.size() - 1)
								+ "), this operation can not be undone as the default undo limit("
								+ UNDO_LIMIT + ") is exceeded");
		if (questionResult && warnUserOnReferences(eObjects)) {
			// Set the undo flag to false.
			// Note: it might already have been created with undo = false, when selection of the objects occurred while pressing the CTRL key. 
			((WarningDeleteCommand) command).undo = false;
			domain.getCommandStack().execute(command);
		}
	}

	/**
	 * 
	 * 
	 * @param eObjects
	 */
	private boolean warnUserOnReferences(Collection<EObject> eObjects) {

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
						return editingService.getDelegator().getText(source)
								+ " --> "
								+ editingService.getDelegator().getText(target);
					}
					return null;
				}

			});
			ld.setTitle("Object references :");
			ld.setInput(xRefs);
			ld.setBlockOnOpen(true);
			int result = ld.open();
			if (result == Window.CANCEL) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Command createCommand(Collection<?> selection) {

		// Increment the target selection for certain objects.
		// Make sure we keep the order.
		Collection<Object> newSelection = incrementSelection(selection);

		if (newSelection.size() == 0 && selection.size() > 0) {
			newSelection.addAll(selection);
		}

		Command c = null;

		SelectionChangedEvent originalEvent = this.getOriginalEvent();
		if (originalEvent instanceof StateSelectionChangedEvent) {
			if (((StateSelectionChangedEvent) originalEvent).isState_ALT()) {
				
				c = removeAllReferences ? WarningDeleteCommand.create(domain,
						newSelection) : RemoveCommand.create(domain,
						newSelection);
				if(c instanceof WarningDeleteCommand){
					// Pre-instruct the command, not to support undo. 
					((WarningDeleteCommand) c).undo = false;
				}
				
			}
		}
		if (c == null) {
			c = removeAllReferences ? WarningDeleteCommand.create(domain,
					newSelection) : RemoveCommand.create(domain, newSelection);
		}

		return c;
	}

	/*
	 * Facility to update the selection (the target deletion objects), for
	 * specific cases. The default handling, will not know which objects belong
	 * together.
	 */
	private Collection<Object> incrementSelection(Collection<?> selection) {
		Collection<Object> newSelection = Lists.newLinkedList();

		for (Object o : selection) {
			// For jobs, we also need to delete the job container.
			// ..this will also delete the workflow runs...
			if (o instanceof Job) {
				Job job = (Job) o;

				// Use a call, which doesn't force listing to changes.
				Resource jobRunContainerResource = editingService
						.getDataService()
						.getProvider()
						.getResource(
								editingService.getEditingDomain()
										.getResourceSet(),
								SchedulingPackage.Literals.JOB_RUN_CONTAINER);

				// Resource jobRunContainerResource = editingService
				// .getData(SchedulingPackage.Literals.JOB_RUN_CONTAINER);
				
				// find our jobcontainer .
				for (final EObject eObject : jobRunContainerResource
						.getContents()) {
					final JobRunContainer container = (JobRunContainer) eObject;
					final Job containerJob = container.getJob();
					final CDOID containerJobId = ((CDOObject) containerJob)
							.cdoID();
					if (job.cdoID().equals(containerJobId)) {
						newSelection.add(container);
						newSelection.add(job);
						break;
					}
				}
			}
		}
		return newSelection;
	}

	// private Command createNWBCommand(Collection<?> selection) {
	//
	// return WarningNWBDeleteCommand.create(domain, selection);
	// }

}
