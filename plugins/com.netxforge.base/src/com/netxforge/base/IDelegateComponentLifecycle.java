/*******************************************************************************
 * Copyright (c) 11 mrt. 2014 NetXForge.
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
package com.netxforge.base;

import com.netxforge.base.IComponentLifecycleListener.LIFE_EVENT;

/**
 * An internal version which allows for registration of the source
 * 
 * @author Christophe
 * 
 */
public interface IDelegateComponentLifecycle {

	public void activate(Object source, Object target);

	public void deactivate(Object source, Object target);
	
	public void register(Object source);

	public void deregister(Object source);
	
	public LIFE_EVENT getState();
}
