/*******************************************************************************
 * Copyright (c) 3 jul. 2013 NetXForge.
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
package com.netxforge.netxstudio.common.context;

/**
 * Holds a context used by computing logic. 
 * 
 * @author Christophe Bouhier
 */
public interface IComputationContext {
	
	
	/**
	 * When the context is unset. 
	 */
	public static final int UNSET = 0;

	/**
	 * When the context is a {@link NetxstudioPackage model} object
	 */
	public static final int MODEL_OBJECT = 1;

	/**
	 * When the context is a {@link DateTimeRange period} in time
	 */
	public static final int MODEL_PERIOD = 2;
	
	
	/**
	 * The context object. 
	 * 
	 * @return
	 */
	public abstract Object getContext();

	/**
	 * The kind of context object. 
	 * 
	 * @return
	 */
	public abstract int getKind();

}
