/*******************************************************************************
 * Copyright (c) 13 jan. 2014 NetXForge.
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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.PasteAction;

import com.netxforge.netxstudio.screens.editing.commands.FilteredPasteFromClipboardCommand;

/**
 * A customized PasteAction, which filters branches of the containment tree
 * based on feature filtering. For each paste class, we maintain a static list. 
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
