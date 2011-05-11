/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.selector;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public interface IScreenFormService {

	/**
	 * Get the currentScreen.
	 * 
	 * @return
	 */
	public abstract Composite getActiveScreen();

	/**
	 * Check if the propsed new screen is not the active screen already.
	 * 
	 * @param proposedScreen
	 * @return
	 */
	public abstract boolean isActiveScreen(Class<?> proposedScreen);

	/**
	 * Set the active screen to this composite.
	 * 
	 * @param control
	 */
	public abstract void setActiveScreen(Composite control);

	/**
	 * Initialize the service with the parent.
	 * 
	 * @param parent
	 */
	public abstract void initalize(Composite parent);

	public abstract Composite addScreenSelector(String name, String iconPath,
			Class<?> screen, int position);

	public abstract Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen);

	public abstract Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int position);

	public abstract void restorePreviousScreen();

	public abstract Form getSelectorForm();

	public abstract Composite getScreenContainer();

}