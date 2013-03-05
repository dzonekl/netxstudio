package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;

import com.netxforge.netxstudio.edit.CreateChildFromPoolCommand;

public class CreateChildFromPoolAction extends CreateChildAction {

	public CreateChildFromPoolAction(EditingDomain editingDomain,
			ISelection selection, Object descriptor) {
		super(editingDomain, selection, descriptor);
	}

	public CreateChildFromPoolAction(IEditorPart editorPart,
			ISelection selection, Object descriptor) {
		super(editorPart, selection, descriptor);
	}

	public CreateChildFromPoolAction(IWorkbenchPart workbenchPart,
			ISelection selection, Object descriptor) {
		super(workbenchPart, selection, descriptor);
	}

	@Override
	protected Command createActionCommand(EditingDomain editingDomain,
			Collection<?> collection) {
		
		if (collection.size() == 1)
	    {
	      Object owner = collection.iterator().next();
	      
	      
	      // Deletegated to editing domain. 
	      return CreateChildFromPoolCommand.create(editingDomain, owner,
	                                       descriptor, collection);
	      
	      // When not delegated, we unfortunately don't have the item provider. 
	      
	      
	    }
	    return UnexecutableCommand.INSTANCE;
	}

	
	
	
	
	
	
}
