/*******************************************************************************
 * Copyright (c) May 1, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.internal;

import com.google.inject.Injector;
import com.netxforge.base.di.IInjectorProxy;

/**
 * Expose our injector for other modules, which do not which to define their own 
 * binding. 
 *  
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public class NetXScriptInjectorProxy implements IInjectorProxy {
		
	/**
	 * 
	 * @param grammarName
	 * @return
	 */
	public Injector getInjector(String grammarName){
		
		if(grammarName.equals("")){
			throw new java.lang.UnsupportedOperationException();
		}
		// and this one comes just next. 
		return RuntimeActivator.getInstance().getInjector(grammarName);
		
	}
}
