/*******************************************************************************
 * Copyright (c) 23 mei 2013 NetXForge.
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
package com.netxforge.screens.editing.base.commands;

import org.eclipse.emf.common.command.AbstractCommand;

/**
 * A Command which doesn't support undo etc... 
 * It's not executed on a command stack, it's not even a command 
 * actually.   
 * 
 * @author Christophe Bouhier
 */
public abstract class NoWayBackCommand extends AbstractCommand {

	
	@Override
	public boolean canExecute() {
		// Can always execute!
		return true;
	}

	@Override
	public boolean canUndo() {
		// Can never UNDO.
		return false;
	}

	@Override
	public void undo() {
		// Do nothing, Can't UNDO. 
	}
	
	public void redo() {
		// Do Nothing, we can't REDO. 
	}
	

}
