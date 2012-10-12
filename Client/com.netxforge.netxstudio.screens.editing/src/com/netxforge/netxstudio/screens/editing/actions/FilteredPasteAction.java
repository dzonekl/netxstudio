package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.PasteAction;

/**
 * A customized PasteAction, which filters branches of the containment tree
 * based on feature filtering. For each paste class, we maintain a static list of 
 * 
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class FilteredPasteAction extends PasteAction {
	
	public FilteredPasteAction(EditingDomain domain) {
		super(domain);
	}

	public FilteredPasteAction() {
		super(null);
	}

	@Override
	public Command createCommand(Collection<?> selection) {
		if (selection.size() == 1) {
			return FilteredPasteFromClipboardCommand.create(domain, selection
					.iterator().next(), null);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

}
