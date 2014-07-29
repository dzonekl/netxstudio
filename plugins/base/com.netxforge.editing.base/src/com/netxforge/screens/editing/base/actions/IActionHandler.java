/*******************************************************************************
 * Copyright (c) Nov 7, 2011 NetXForge.
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
package com.netxforge.screens.editing.base.actions;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;

import com.netxforge.screens.editing.base.actions.handlers.ActionHandlerDescriptor;

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
	
	
	/**
	 * Deactivate the handler. 
	 * 
	 * @param part
	 */
	public abstract void deactivate();
	
}