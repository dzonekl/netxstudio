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
package com.netxforge.netxstudio.screens.common.util;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.widgets.Control;

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
	 * Get a simple Update value strategy, which will set a status to warning
	 * with the provided message, before setting the value.  
	 * @param validationMessage
	 * @return
	 */
	public abstract EMFUpdateValueStrategy getUpdateValueStrategyBeforeSet(
			final String validationMessage);
	
	/**
	 * Get an update value strategy, with a custom validator, after getting the value
	 * 
	 * @param validator
	 * @return
	 */
	public EMFUpdateValueStrategy getUpdateValueStrategyAfterGet(IValidator validator);
	
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
	 * Get a control decoration which is hidden.
	 * @param control
	 * @return
	 */
	public ControlDecoration getErrorDecoration(Control control);

	/**
	 * Get a control decoration which is hidden.
	 * @param control
	 * @return
	 */
	public ControlDecoration getWarningDecoration(Control control);

	/**
	 * Get a control decoration which is hidden.
	 * @param control
	 * @return
	 */
	public ControlDecoration getRequiredDecoration(Control control);
	
	
	/**
	 * Register a warning decorator for a control.
	 * @param control
	 * @param cd
	 */
	public void registerWarningDecorator(Control control,Control decoratorControl);


	/**
	 * Register a required decorator for a control.
	 * @param control
	 * @param cd
	 */
	public void registerRequiredDecorator(Control control,Control decoratorControl);

	
	public void registerAllDecorators(Control control,Control decoratorControl);
	
	
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