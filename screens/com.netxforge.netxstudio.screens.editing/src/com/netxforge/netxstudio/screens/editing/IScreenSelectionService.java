/*******************************************************************************
 * Copyright (c) 28 aug. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.editing;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IWorkbenchPart;

import com.netxforge.netxstudio.screens.editing.actions.IActionHandler;

/**
 * Typical UI selection use, is to implement {@link ISelectionProvider} on an UI
 * object like a {@link IWorkbenchPart}. The selection provider can be
 * subscribed by other parts or action handlers interested in the part's
 * selection. </p> For {@link IScreen} we require to have the selection of a
 * screen, which can be an {@link ISelection} in a {@link Viewer} or if the
 * screen operators on a single object, it can be the object itself. </p> The
 * {@link IScreenSelectionService} is in the center of a screen application. The
 * service is injected by parts or action handlers and fires selection changes
 * on annotated methods. TODO develop a Selection annotation for methods to be
 * called. </p>
 * </p>
 * Migration Examples: 
 * </p>
 * The {@link IActionHandler#setActivePart(IWorkbenchPart)} is called 
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class IScreenSelectionService {

	/**
	 * initialize the service.
	 * </p>
	 * 1. Register to PlatformUI and get notified of part lifecycle. 
	 * 2. extract the selection from IScreen which implements ISelectionProvider. 
	 * 3. fire annotated elements.
	 */

}
