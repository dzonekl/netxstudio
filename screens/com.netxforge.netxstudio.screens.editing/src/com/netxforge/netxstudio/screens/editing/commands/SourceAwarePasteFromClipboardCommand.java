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
package com.netxforge.netxstudio.screens.editing.commands;

import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.screens.editing.actions.SourceAwarePasteAction.PasteStrategy;

public class SourceAwarePasteFromClipboardCommand extends
		PasteFromClipboardCommand {

	/**
	 * An option which can be set to instruct pasting in the
	 * {@link EObject#eResource()}.
	 */
	private boolean pasteToResourceOption;

	public SourceAwarePasteFromClipboardCommand(EditingDomain domain,
			Object owner, Object feature, int index) {
		super(domain, owner, feature, index);
	}

	public SourceAwarePasteFromClipboardCommand(EditingDomain domain,
			Object owner, Object feature, int index, boolean optimize) {
		super(domain, owner, feature, index, optimize);
	}

	public boolean isPasteToResourceOption() {
		return pasteToResourceOption;
	}

	public void setPasteToResourceOption(boolean pasteToResourceOption) {
		this.pasteToResourceOption = pasteToResourceOption;
	}

	/**
	 * This creates a command to add copies from the clipboard to the specified
	 * feature of the owner.
	 * 
	 * @param pasteStrategy
	 */
	public static Command create(EditingDomain domain, Object owner,
			Object feature, PasteStrategy pasteStrategy) {
		return create(domain, owner, feature, CommandParameter.NO_INDEX,
				pasteStrategy);
	}

	/**
	 * This creates a command to add copies from the clipboard to the specified
	 * feature of the owner and at the given index.
	 * 
	 * @param pasteStrategy
	 */
	public static Command create(EditingDomain domain, Object owner,
			Object feature, int index, PasteStrategy pasteStrategy) {

		if (domain == null) {
			return new SourceAwarePasteFromClipboardCommand(domain, owner,
					feature, index, true);
		} else {
			StrategyCommandParameter strategyCommandParameter = new StrategyCommandParameter(
					owner, feature, Collections.emptyList(), index);
			strategyCommandParameter.setCmdStrategy(pasteStrategy);
			Command command = domain.createCommand(
					SourceAwarePasteFromClipboardCommand.class,
					strategyCommandParameter);
			return command;
		}
	}

}
