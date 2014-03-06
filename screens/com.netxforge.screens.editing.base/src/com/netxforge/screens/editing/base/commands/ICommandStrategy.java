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
package com.netxforge.screens.editing.base.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * A marker interface.
 * 
 * @author Christophe Bouhier
 * 
 */
public interface ICommandStrategy {

	/**
	 * Command creation delegated by an {@link AdapterFactoryEditingDomain}.
	 * 
	 * 
	 * @param domain
	 * @param commandClass
	 * @param commandParameter
	 * @param optimizedCopy
	 * @return
	 */
	public Command createCommand(EditingDomain domain,
			Class<? extends Command> commandClass,
			CommandParameter commandParameter, boolean optimizedCopy);

}
