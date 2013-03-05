package com.netxforge.netxstudio.screens.editing.actions;

import org.eclipse.emf.common.command.AbstractCommand;

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
