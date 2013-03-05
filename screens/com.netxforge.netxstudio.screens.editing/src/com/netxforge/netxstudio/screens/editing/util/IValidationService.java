/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.editing.util;

import org.eclipse.core.databinding.DataBindingContext;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public interface IValidationService {

	/**
	 * Aggregates the validation status providers from a binding context.
	 * Fires validation events on which clients can register separately. depending on the context.
	 * Note: Only one context can be registered. 
	 * 
	 * @param mgr
	 * @param ctx
	 */
	public abstract void registerBindingContext(final DataBindingContext ctx);

	/**
	 * Add a validation listener. 
	 * 
	 * @param listener
	 */
	public abstract void addValidationListener(IValidationListener listener);
	
	
	/**
	 * Remove a validation listener.
	 * @param listener
	 */
	public abstract void removeValidationListener(IValidationListener listener);
	
	/**
	 * Dispose of all our registrations.
	 */
	public void dispose();
	
	
	/**
	 * Returns if the registered bindings in this service are valid.
	 * 
	 */
	public boolean isValid();
	
	
}