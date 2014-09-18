/*******************************************************************************
 * Copyright (c) 18 sep. 2014 NetXForge.
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
package com.netxforge.base.data;

import java.lang.reflect.Proxy;

/**
 * Clients should implement to provide validation services for Objects. Some
 * Object frameworks (I.e. {@link http://www.eclipse.org/cdo CDO } use Object
 * {@link Proxy} and maintain state, like if the Object is new, proxy, valid or
 * any other intended state. OSS2 abstracts away the data layer, so checking object state, 
 * which is needed, is abstracted away with this interface. Common states are supported, 
 * more can/will follow. 
 * 
 * 
 * @author Christophe Bouhier
 * @since 1.1
 * 
 */
public interface IDataObjectValidator {
	
	/**
	 * Is this POJO valid? 
	 * 
	 * @param o
	 * @return
	 */
	public boolean isValid(Object o);
	

}
