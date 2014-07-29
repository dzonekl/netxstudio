/*******************************************************************************
 * Copyright (c) 25 jun. 2014 NetXForge.
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
package com.netxforge.base.context;

import java.util.List;

/**
 * Provider for {@link IComputationContext}. Typical use is to add context to a
 * (computation) process like a period of time or objects which are not primary
 * target of a process.
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IComputationContextProvider {

	/**
	 * Add a {@link IComputationContext}
	 * 
	 * @param object
	 */
	public abstract void addContextObject(IComputationContext object);

	/**
	 * Add multiple {@link IComputationContext}
	 * 
	 * @param objects
	 */
	public abstract void addContextObjects(IComputationContext... objects);

	/**
	 * clear the collection
	 */
	public abstract void clearContextObjects();

	/**
	 * Get the {@link IComputationContext} as an array.
	 * 
	 * @return
	 */
	public abstract IComputationContext[] getContextObjects();

	/**
	 * Get the {@link IComputationContext} ad a {@link List}
	 * 
	 * @return
	 */
	public abstract List<IComputationContext> getContextObjectsAsList();

}