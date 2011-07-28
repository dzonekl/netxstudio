package com.netxforge.netxstudio.screens.editing.actions;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;

public interface IActionHandler extends IPropertyListener {

	/**
	 * Allows the registration of global actions on the IActionBars. 
	 * @param actionBars
	 */
	public abstract void initActions(IActionBars actionBars);

	/**
	 * Set the active workbenchpart, which is used to retrieve the 
	 * selection provider. 
	 * @param part
	 */
	public abstract void setActivePart(IWorkbenchPart part);

	/**
	 * Flexibly allows to enable/disable actions. 
	 * @param menuManager
	 */
	public abstract void showMenu(ActionHandlerDescriptor descriptor);

	
	/**
	 * Required to update the menu's on a workbench part change. 
	 * 
	 * @param part
	 */
	public abstract void update(IWorkbenchPart part);
	
	
}