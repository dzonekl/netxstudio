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

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;

/**
 * Screens operations and utilities on operations. IScreen interface is usually
 * implemented by a Composite, as Composite doesn't have an interface, we can
 * test and cast here so the Composite becomes available.
 * 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class ScreenUtil {

	public static final String RED_MARKER = "RED";
	public static final String AMBER_MARKER = "AMBER";
	public static final String YELLOW_MARKER = "YELLOW";

	static {
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		colorRegistry.put(AMBER_MARKER, new RGB(252, 200, 58));
		colorRegistry.put(YELLOW_MARKER, new RGB(252, 242, 92)); // yellowish
		colorRegistry.put(RED_MARKER, new RGB(235, 80, 75)); // cherry
	}

	public static final int OPERATION_EDIT = 0x0100;
	public static final int OPERATION_NEW = 0x0200;
	public static final int OPERATION_READ_ONLY = 0x0400;
	
	public static boolean isNewOperation(int operation) {
		return (operation & OPERATION_NEW) != 0;
	}

	public static boolean isNewOperation(IScreen screen) {
		return (screen.getOperation() & OPERATION_NEW) != 0;
	}

	public static boolean isEditOperation(int operation) {
		return (operation & OPERATION_EDIT) != 0;
	}

	public static boolean isReadOnlyOperation(int operation) {
		return (operation & OPERATION_READ_ONLY) != 0;
	}

	// Some sort of screen adapter functionality.

	public static Composite compositeFor(IScreen screen) {
		if (screen instanceof Composite) {
			return (Composite) screen;
		}
		return null;
	}

	public static boolean isComposite(IScreen screen) {
		return screen instanceof Composite;
	}

	public static boolean isScreen(Composite composite) {
		return composite instanceof IScreen;
	}

	public static IScreen screenFor(Composite composite) {
		if (composite instanceof IScreen) {
			return (IScreen) composite;
		}
		return null;
	}

	public static boolean isDataScreenInjection(IScreen screen) {
		return screen instanceof IDataScreenInjection;
	}

	public static IDataScreenInjection dataScreenInjectionFor(IScreen screen) {
		if (screen instanceof IDataScreenInjection) {
			return (IDataScreenInjection) screen;
		}
		return null;
	}

	public static boolean isDataServiceInjection(IScreen screen) {
		return screen instanceof IDataServiceInjection;
	}

	public static IDataServiceInjection dataServiceInjectionFor(IScreen screen) {
		if (screen instanceof IDataServiceInjection) {
			return (IDataServiceInjection) screen;
		}
		return null;
	}

	public static IDataInjection dataInjectionFor(IScreen screen) {
		if (screen instanceof IDataInjection) {
			return (IDataInjection) screen;
		}
		return null;
	}

}
