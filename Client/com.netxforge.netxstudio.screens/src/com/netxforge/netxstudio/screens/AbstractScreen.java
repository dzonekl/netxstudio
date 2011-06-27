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

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;


/**
 * Convenience implementation of a screen, sharing commonality like the 
 * screen operation, and the supporting services. 
 *  
 * @author dzonekl
 */
public abstract class AbstractScreen extends Composite implements IScreen {
	
	private int operation;
	
	@Inject
	protected IEditingService editingService;

	@Inject
	protected IScreenFormService screenService;
	
	public AbstractScreen(Composite parent, int style) {
		super(parent, style);
		operation = style & 0xFF00; // Ignore first bits, as we piggy back on
//		ScreensActivator.getDefault().getInjector().injectMembers(this);
	}

	public abstract Viewer getViewer();

	public int getOperation() {
		return operation;
	}

	public  abstract boolean isValid();

	public abstract Form getScreenForm();

}
