package com.netxforge.netxstudio.screens.editing.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;

public class DecoratedDeleteAction extends DeleteAction {

	private IEditingService editingService;

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateSelection(IStructuredSelection selection) {

		@SuppressWarnings("rawtypes")
		List selectedObjects = selection.toList();
		
		// Increment the target selection for certain objects.
		Collection<Object> newSelection = Lists.newArrayList();

		for (Object o : selectedObjects) {

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
						// newSelection.add(job);
						newSelection.add(container);
						break;
					}
				}
			}
		}

		if (newSelection.size() == 0 && selection.size() > 0) {
			newSelection.addAll(selectedObjects);
		}
		
		
		// TODO Debuging, remove later. 
		for (Object o : newSelection) {
			System.out.println("delete selection=" + o);
		}

		Collection<Object> collection = new ArrayList<Object>(newSelection);
		command = createCommand(collection);
		return command.canExecute();
	}

}
