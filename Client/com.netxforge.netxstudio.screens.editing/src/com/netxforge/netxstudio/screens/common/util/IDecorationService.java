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

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.widgets.Control;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public interface IDecorationService {

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
	
	
	
	
}