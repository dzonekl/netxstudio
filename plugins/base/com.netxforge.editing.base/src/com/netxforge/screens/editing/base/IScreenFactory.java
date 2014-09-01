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

	/**
	 * Create (instantiate) an {@link IScreen} for a given parent
	 * {@link Composite} with a given name and a given {@link ScreenUtil
	 * style/operation}
	 * 
	 * @param screenName
	 * @param screenClass
	 * @param parent
	 * @param style
	 * @return
	 */
	public IScreen create(String screenName, Class<?> screenClass,
			Composite parent, int style);

	/**
	 * Register the {@link IScreen}
	 * 
	 * @param screenName
	 * @param screenClass
	 */
	public void registerScreen(String screenName, Class<?> screenClass);

	/**
	 * Create an {@link IScreen} matching a class name as declarared with
	 * extension:
	 * 
	 * <pre>
	 * com.netxforge.editing.iscreen
	 * </pre>
	 * 
	 * @param screenName
	 * @param screenClassName
	 * @param parent
	 * @param style
	 * @return
	 */
	public abstract IScreen createByDeclaration(String screenName,
			String screenClassName, Composite parent, int style);

}
