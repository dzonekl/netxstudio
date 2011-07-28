package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.ui.action.DeleteAction;

public class WarningDeleteAction extends DeleteAction {

	@Override
	public Command createCommand(Collection<?> selection) {
		
		// We might need to unwrap the collection of objects here. 
//		Map<EObject, Collection<Setting>> findAll = EcoreUtil.UsageCrossReferencer.findAll(selection, domain.getResourceSet());
		
		
		
		return super.createCommand(selection);
	}
	
}
