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
package com.netxforge.netxstudio.screens.editing.selector;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.screens.editing.AbstractEditorViewPart;

/**
 * FIXME, DOESN'T WORK YET. 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public abstract class AbstractScreenSelector extends AbstractEditorViewPart {

	public static final String ID = "com.netxforge.netxstudio.screens.demo.DemoViewPartSelector"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Composite parentComposite = null;
	
	private Form frmSelectorForm;
	FormData fd_frmSelectorForm = new FormData();
	
	public AbstractScreenSelector() {
		
	}
	
	/**
	 * The container which fills the ViewPart.
	 * Clients should respect the installed layout. 
	 * 
	 * @return
	 */
	private Composite screenContainer;
	
	private Composite activeScreen = null;
	
	/**
	 * Get the currentScreen. 
	 * @return
	 */
	public Composite getActiveScreen() {
		return activeScreen;
	}


	
	/**
	 * Check if the propsed new screen is not the active screen already. 
	 * @param proposedScreen
	 * @return
	 */
	public boolean isActiveScreen(Class<?> proposedScreen){
		return activeScreen.getClass().equals(proposedScreen);
	}
	

	/**
	 * A dynamic selector screen selector.  
	 * Extends an Editor view part for dirtyness, editing domain, command stack etc...
	 * 
	 * Clients should implement <pre>buildSelector()</pre> to populate the container. 
	 * TODO, for now the container layout is fixed as a Form layout, but this could be  
	 *  
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		parentComposite = parent;
		
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		screenContainer = toolkit.createComposite(parent, SWT.NONE);
		toolkit.paintBordersFor(screenContainer);
		screenContainer.setLayout(new FormLayout());
		
		Composite blankScreen = new Composite(screenContainer, SWT.BORDER);
		
		Composite selectorContainer = toolkit.createComposite(parent, SWT.BORDER);
		
		fd_frmSelectorForm.left = new FormAttachment(0, 10);
		fd_frmSelectorForm.bottom = new FormAttachment(100, -5);
		fd_frmSelectorForm.top = new FormAttachment(0, 10);
		fd_frmSelectorForm.right = new FormAttachment(blankScreen, -6);
		
		selectorContainer.setLayoutData(fd_frmSelectorForm);
		
		toolkit.paintBordersFor(selectorContainer);
		selectorContainer.setLayout(new FillLayout());
		
		frmSelectorForm = toolkit.createForm(selectorContainer);
		frmSelectorForm.setSeparatorVisible(true);
		frmSelectorForm.setText("M");
		toolkit.paintBordersFor(frmSelectorForm);
		frmSelectorForm.getBody().setLayout(new FormLayout());
		
		updateComposite(blankScreen);
		
		createActions();
		initializeToolBar();
		initializeMenu();
		
		buildSelector(screenContainer);
	}

	public abstract void buildSelector(Composite container);
	
	
	public void updateComposite(Composite control) {
		if (activeScreen != null) {
			activeScreen.dispose();
		}

		activeScreen = control;
		
		// TODO, 
		FormData fd_currentComposite = new FormData();
		fd_currentComposite.left = new FormAttachment(0, 100);
		fd_currentComposite.right = new FormAttachment(100, -10);
		fd_currentComposite.bottom = new FormAttachment(100, -5);
		fd_currentComposite.top = new FormAttachment(0, 5);
		activeScreen.setLayoutData(fd_currentComposite);

		toolkit.adapt(activeScreen);
		toolkit.paintBordersFor(activeScreen);

		fd_frmSelectorForm.right = new FormAttachment(activeScreen, -6);

		screenContainer.pack();
		// parentComposite.pack();
		parentComposite.layout(true);
	}

	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

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
		IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		@SuppressWarnings("unused")
		IMenuManager manager = getViewSite().getActionBars().getMenuManager();
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
	protected Form getSelectorForm() {
		return frmSelectorForm;
	}
}
