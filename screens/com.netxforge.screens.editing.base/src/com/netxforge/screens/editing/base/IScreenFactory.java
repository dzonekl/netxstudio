/*******************************************************************************
 * Copyright (c) 3 dec. 2012 NetXForge.
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
package com.netxforge.screens.editing.base;

import org.eclipse.swt.widgets.Composite;


/**
 * A Factory for IScreen's
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IScreenFactory {
	public IScreen create(String screenName, Class<?> screenClass,
			Composite parent, int style);

	public void registerScreen(String screenName, Class<?> screenClass);
}
