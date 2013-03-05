/*******************************************************************************
 * Copyright (c) Jun 16, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens;

import org.eclipse.swt.widgets.Composite;

import com.netxforge.netxstudio.screens.editing.AbstractScreenImpl;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Base for screens in this plugins, which require injection of modules
 * from this OSGI plugin. (See the Activator class for which modules are bound). 
 * 
 * @author Christophe Bouhier
 */
public abstract class AbstractScreen extends AbstractScreenImpl {
	
	public AbstractScreen(Composite parent, int style) {
		super(parent, style);
		injectMembers(ScreensActivator.getDefault().getInjector());
	}
	
}
