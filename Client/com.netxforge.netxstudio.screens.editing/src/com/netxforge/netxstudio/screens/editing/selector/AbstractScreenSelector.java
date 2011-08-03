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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISaveablePart2;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.AbstractScreensViewPart;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.actions.ActionHandlerDescriptor;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public abstract class AbstractScreenSelector extends AbstractScreensViewPart
		implements ScreenChangeListener {

	public static final String ID = "com.netxforge.netxstudio.screens.selector.AbstractScreenSelectorII"; //$NON-NLS-1$

	@Inject
	protected ScreenFormService screenFormService;

	private IScreen activeScreen;

	public AbstractScreenSelector() {
	}

	@Override
	public IScreen getActiveScreen() {
		return activeScreen;
	}

	public ScreenFormService getScreenFormService() {
		return screenFormService;
	}
	
	public IEditingService getEditingService() {
		return screenFormService.getEditingService();
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {

		createActions();
		initializeToolBar();
		initializeMenu();

		// Our service.
		screenFormService.initalize(parent);
		getEditingService().setViewerProvider(this);
		screenFormService.addScreenChangeListener(this);
		buildSelector();
	}

	public abstract void buildSelector();

	public IScreen getCurrentScreen() {
		return activeScreen;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.selector.ScreenChangeListener
	 * #screenChanged()
	 */
	public void screenChanged(IScreen screen) {
		// Some screens won't have a viewer, in this case
		// the current viewer will be null, and an empty selection will be set.
		if (screen != null ) {
			activeScreen = screen;
			Viewer viewer = screen.getViewer();
			setCurrentViewer(viewer);
			// Make sure we update the dirty state, when changing screen.
			firePropertyChange(ISaveablePart2.PROP_DIRTY);
		}
	}

	@Override
	public void contributeMenuAboutToShow(IMenuManager menuManager) {

		// Customize the descriptor based on the
		ActionHandlerDescriptor descriptor = this.getActionHandlerDescriptor();
		descriptor.setMenuManager(menuManager);
		if (!Screens.isReadOnlyOperation(getCurrentScreen().getOperation())) {
			descriptor.setEnableEditActions(true);

			if (this.getCurrentScreen().getViewer() instanceof TreeViewer) {
				descriptor.setEnableChildCreationActions(true);
			} else {
				descriptor.setEnableChildCreationActions(false);
			}

			// FIXME, Siblings need more work, disable for now.
			descriptor.setEnableSiblingCreationActions(false);
			EStructuralFeature[] features = getCurrentScreen()
					.permittedCreationFeatures();
			descriptor.setPermittedChildCreationFeatures(features);
		} else {
			descriptor.setEnableEditActions(false);
			descriptor.setEnableChildCreationActions(false);
			descriptor.setEnableSiblingCreationActions(false);
		}

		descriptor.showMenu();

		if (this.getCurrentScreen() != null
				&& this.getCurrentScreen().getActions() != null) {
			// Reverse the order, to make the appear in the correct order.
			Object[] actions = reverse(this.getCurrentScreen().getActions());
			for (int i = 0; i < actions.length; i++) {
				IAction a = (IAction) actions[i];
				menuManager.insertAfter("screen", a);
			}
		}
	}

	public static Object[] reverse(Object[] arr) {
		List<Object> list = Arrays.asList(arr);
		Collections.reverse(list);
		return list.toArray();
	}
}
