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
package com.netxforge.base.context;

import org.eclipse.emf.ecore.EObject;

/**
 * An implementation of a computation object, which we expect to be an object of type T. 
 * 
 * @author Christophe Bouhier
 */
public class ObjectContext<T> extends AbstractComputationContext {
	
	private T internalObject;
	
	public ObjectContext(T object){
		this.internalObject = object;
	}
	
	public ObjectContext(T object, int kind){
			this.internalObject = object;
			this.contextKind = kind;
	}

	@Override
	public T getContext() {
		return internalObject;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(internalObject instanceof EObject){
			builder.append(((EObject)internalObject).eClass().getName());
		}
		return builder.toString();
	}
}
