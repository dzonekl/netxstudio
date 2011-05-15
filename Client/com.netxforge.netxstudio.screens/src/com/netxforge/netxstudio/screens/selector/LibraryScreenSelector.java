/*******************************************************************************
 * Copyright (c) May 8, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.screens.selector;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.screens.ch9.Expressions;
import com.netxforge.netxstudio.screens.f2.Resource;

public class LibraryScreenSelector extends AbstractScreenSelector_Inj {

	public static final String ID = "com.netxforge.netxstudio.screens.selector.library"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	public LibraryScreenSelector() {
		super();
	}

	/**
	 * A dynamic selector screen selector. 
	 * Extends an Editor view part for dirtyness, editing domain, command stack etc...
	 * 
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		screenFormService.getSelectorForm().setText("Library");
	}

	public void buildSelector(){
		Composite result;
		
		result = screenFormService.addScreenSelector("Expressions","icons/full/obj16/Expression_H.png", Expressions.class, 1, Screens.OPERATION_VIEWER);
		screenFormService.addScreenSelector( result, "Resource", "icons/full/obj16/Equipment_H.png",  Resource.class, Screens.OPERATION_VIEWER);
	}
	
	
	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.AbstractEditorViewPart#initBindings()
	 */
	
	@Override
	protected void initBindings() {
		// TODO Auto-generated method stub
		// Static initialization of bindings. We need a dynamic form for this. 
		// 
		
	}
}
