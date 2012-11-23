/*******************************************************************************
 * Copyright (c) 23 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * An action for invoking a sub-screen, it maintains a mode. 
 * 
 * @author Christophe Bouhier
 *
 */
public abstract class ScreenAction extends Action {
	
	public static final int EDIT_OR_VIEW_MODE = 0x00;
	public static final int NEW_MODE = 0x01;
	public static final int UNDEFINED_MODE = 0xff;
	
	private int mode = UNDEFINED_MODE;
	
	public ScreenAction(int mode) {
		super();
		this.mode = mode;
	}

	public ScreenAction(String text, ImageDescriptor image, int mode) {
		super(text, image);
		this.mode = mode;
	}

	public ScreenAction(String text, int mode) {
		super(text);
		this.mode = mode;
	}

	public ScreenAction(String text, int style, int mode) {
		super(text, style);
		this.mode = mode;
	}
	
	@Override
	public void run() {
		super.run();
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

}
