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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.AbstractEditorViewPart_Inj;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public abstract class AbstractScreenSelector_Inj extends AbstractEditorViewPart_Inj {

	public static final String ID = "com.netxforge.netxstudio.screens.selector.AbstractScreenSelectorII"; //$NON-NLS-1$

	@Inject
	protected ScreenFormService service;
	
	public AbstractScreenSelector_Inj() {
		ScreensActivator.getInjector().injectMembers(this);
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {

		createActions();
		initializeToolBar();
		initializeMenu();
		
		
		//Our service. 
		service.initalize(parent);
		service.setEditingService(getEditingService());
		buildSelector();
	}

	public abstract void buildSelector();

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		@SuppressWarnings("unused")
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		@SuppressWarnings("unused")
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.AbstractEditorViewPart#initBindings
	 * ()
	 */
	@Override
	protected void initBindings() {
	}
	
	@Override
	public void dispose() {
		super.dispose();
		// TODO Dispose used images. 
	}
	
}
