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
package com.netxforge.netxstudio.screens.editing.selector;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public interface IScreenFormService {
	
	public static final String ICON_PATH = "com.netxforge.netxstudio.models.edit";

	/**
	 * Get the currentScreen.
	 * 
	 * @return
	 */
	public abstract Composite getActiveScreen();

	/**
	 * Check if the proposed new screen is not the active screen already.
	 * @param proposedScreen
	 * @return
	 */
	public abstract boolean isActiveScreen(Class<?> proposedScreen);

	/**
	 * Check if there is an active screen.
	 * @return
	 */
	public abstract boolean hasActiveScreen();
	
	
	/**
	 * Set the active screen to this composite.
	 * 
	 * @param control
	 */
	public abstract void setActiveScreen(Composite control);
	
	
	/**
	 * Check if there is a previous screen.
	 * @return
	 */
	public abstract boolean hasPreviousScreen();
	
	
	/**
	 * Check if the proposed new screen is not the previous screen already.
	 * @param proposedScreen
	 * @return
	 */
	public abstract boolean isPreviousScreen(Class<?> proposedScreen);
	
	/**
	 * Initialize the service with the parent.
	 * 
	 * @param parent
	 */
	public abstract void initalize(Composite parent);
	
	
	/**
	 * @return
	 */
	public abstract Composite addScreenSelector(String name, String iconPath,
			Class<?> screen, int position, int operation);
	
	/**
	 * 
	 * @param above
	 * @param name
	 * @param iconPath
	 * @param screen
	 * @return
	 */
	public abstract Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int operation);
	
	/**
	 * Add a screen selector (Hyperlink) to the selector form.  
	 * 
	 * @param above The screen which is above this selector.
	 * @param name The name to appear on the selector. 
	 * @param iconPath The icon path is appended to {@link ICON_PATH} to get the icon. 
	 * @param screen The screen to add. 
	 * @param position The position of the selector. 
	 * @pparam operation The operation for this screen.
	 * @return
	 */
	public abstract Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int position, int operation);
	
	/**
	 * Restores the previously shown screened, if any, this is for  multi(two)-step
	 * UI data entry.  
	 */
	public abstract void restorePreviousScreen();
	
	/**
	 * Get the selector form. 
	 * @return
	 */
	public abstract Form getSelectorForm();
	
	/**
	 * Get the screen container. 
	 * @return
	 */
	public abstract Composite getScreenContainer();
	
	
	public abstract Viewer getSelectionViewer();
	

}