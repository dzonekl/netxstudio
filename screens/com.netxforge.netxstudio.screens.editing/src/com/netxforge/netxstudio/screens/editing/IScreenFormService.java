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
package com.netxforge.netxstudio.screens.editing;

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
	public abstract IScreen getActiveScreen();

	
	/**
	 * Get the current Composite
	 * @return
	 */
	public abstract Composite getActiveComposite();
	
	/**
	 * Set the active screen to this composite. Pushes the previous screen on a
	 * screen stack. It's best to clear the cache when switching a branch of
	 * screens.
	 * 
	 * 
	 * @param control
	 */
	public abstract void setActiveScreen(IScreen screen);

	public abstract void undoAndFlush();
	
	/**
	 * Execute dirty warning
	 * 
	 * @return false when the user cancelled the warning and save. 
	 */
	public abstract boolean dirtyWarning();
	
	/**
	 * Initialize the service with the parent.
	 * 
	 * @param parent
	 */
	public abstract void initalize(AbstractScreensViewPart absViewPart, Composite parent);

	
	/**
	 * Get the abstract screen view part. 
	 * @return
	 */
	public abstract AbstractScreensViewPart getAbsViewPart();
	
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
	 * @param above
	 *            The screen which is above this selector.
	 * @param name
	 *            The name to appear on the selector.
	 * @param iconPath
	 *            The icon path is appended to {@link ICON_PATH} to get the
	 *            icon.
	 * @param screen
	 *            The screen to add.
	 * @param position
	 *            The position of the selector.
	 * @pparam operation The operation for this screen.
	 * @return
	 */
	public abstract Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int position, int operation);

	// public abstract void restorePreviousScreen();

	/**
	 * Get the selector form.
	 * 
	 * @return
	 */
	public abstract Form getSelectorForm();

	/**
	 * Get the screen container.
	 * 
	 * @return
	 */
	public abstract Composite getScreenContainer();
	
	
	/**
	 * Save the screen state. API for saving the {@link IScreen} state, 
	 * when a i.e. ViewPart closes.  
	 * 
	 * @param screen
	 */
	public abstract void saveScreenState(IScreen screen);
	
	/**
	 * Get the screen action bar.
	 * 
	 * @return
	 */
	public abstract Composite getScreenActionBar();

	/**
	 * Get the viewer of the screen providing the selection.
	 * 
	 * @return
	 */
	public abstract IEditingService getEditingService();

	/**
	 * Notify of an external screen change. (An IScreen not managed by our
	 * service, but wishes to use the notification system).
	 * 
	 * @return
	 */
	public abstract void fireScreenChangedExternal(IScreen screen);
	
	
	/**
	 * Notify of an external screen invalidation ( An IScreen
	 * @param screen
	 */
	public abstract void fireScreenInvalidExternal(IScreen screen);
	
	/**
	 * Notify of a widget changed within the screen.
	 * this could trigger to query which widget should provide selection. 
	 * The screen itself can be queried for the current widget in focus. 
	 * 
	 * @return
	 */
	public abstract void fireScreenWidgetChangedExternal(IScreen screen);

	
	/**
	 * A listener which is notified of screen changes. 
	 * 
	 * @param screenChangedListener
	 */
	public abstract void addScreenChangeListener(
			ScreenChangeListener screenChangedListener);
	
	/**
	 * Implementations are expected to reset the screen to the initial state and disable 
	 * all potential actions. 
	 */
	public abstract void disable();

	
	/**
	 * Try to instantiate an IScreen with this name. 
	 * @param screenName
	 */
	public abstract void realize(String screenName);

}