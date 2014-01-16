/*******************************************************************************
 * Copyright (c) 11 jan. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.editing;

import java.util.Set;

import org.eclipse.emf.cdo.CDOObject;

public interface IDataInjection {
	
	/**
	 * Screens for which data is injected from the editing service. 
	 */
	public abstract void injectData();
	
	
	/**
	 * Screens for which data is injected with two parameters. 
	 */
	public abstract void injectData(Object owner, Object object);
	
	
	/**
	 * Arbitrary number of params for injection. 
	 * @param params
	 */
	public abstract void injectData(Object... params);
	
	
	/**
	 * Screens can implement, to have injection occur automatically, 
	 * when a server invalidation occurs.
	 * 
	 * @return
	 */
	public abstract boolean shouldInjectForObject(Set<CDOObject> injectionSet);
	
}
