/*******************************************************************************
 * Copyright (c) 28 dec. 2012 NetXForge.
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
package com.netxforge.scoping;

import com.netxforge.interpreter.IInterpreterContext;

 
/**
 * Clients should implement to be informed about various {@link IInterpreterContext} objects 
 * which can influence the clients behaviour.   
 * 
 * @author Christophe Bouhier
 */
public interface IExternalContextAware {

	/**
	 * Sets the external context. 
	 * @param context
	 */
	public void setExternalContext(IInterpreterContext... context);
	
	/**
	 * Clear the external context	 
	 */
	public void clearExternalContext();
	
}
