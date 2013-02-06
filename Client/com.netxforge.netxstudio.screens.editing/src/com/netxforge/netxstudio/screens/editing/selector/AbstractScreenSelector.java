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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISaveablePart2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IShowInSource;
import org.eclipse.ui.part.ShowInContext;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.common.util.MementoUtil;
import com.netxforge.netxstudio.screens.editing.AbstractScreensViewPart;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.IScreenProvider;
import com.netxforge.netxstudio.screens.editing.actions.ActionHandlerDescriptor;
import com.netxforge.netxstudio.screens.editing.actions.DynamicScreensActionHandler;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;

/**
 * A Screen selector which handles specific behaviour for {@link IScreen }
 * objects. </p>
 * <ul>
 * <li><b>Current screen</b></p>
 * This class implements {@link IScreenProvider}. The current screen is updated by registering to the 
 * {@link IScreenFormService#addScreenChangeListener(ScreenChangeListener) Screen service} 
 * </li>
 * </p>
 * <li><b>Context menu</b></p>
 * This class implements {@link AbstractScreensViewPart#contributeMenuAboutToShow(IMenuManager) }, by
 * calling {@link IScreen#getActions()} and populating a
 * {@link DynamicScreensActionHandler}. The context menu will also
 * enable/disable default creation and editing actions depending on the screen.
 * If the screen is {@link ScreenUtil#OPERATION_READ_ONLY read-only}</li>
 * </p>
 * <li><b>Show In</b></p>
 * This class implements {@link IShowInSource}. This implementation delegates showin to the current 
 * screen by calling {@link IScreen#getShowIn(org.eclipse.jface.viewers.ISelection)} 
 * </li>
 * </ul>
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public abstract class AbstractScreenSelector extends AbstractScreensViewPart
		implements ScreenChangeListener, IShowInSource {

	public static final String ID = "com.netxforge.netxstudio.screens.selector.AbstractScreenSelector"; //$NON-NLS-1$

	@Inject
	protected IScreenFormService screenFormService;

	private IScreen activeScreen;

	public AbstractScreenSelector() {
	}

	public IScreenFormService getScreenService() {
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
	@SuppressWarnings("deprecation")
	@Override
	public void createPartControl(Composite parent) {

		createActions();
		initializeToolBar();
		initializeMenu();

		// Our service.
		screenFormService.initalize(this, parent);
		getEditingService().setViewerProvider(this);
		getEditingService().setScreenProvider(this);
		screenFormService.addScreenChangeListener(this);
		buildSelector();

		// Restore the current Screen:
		if (this.memento != null) {
			String screenName = mementoUtil.retrieveString(this.memento,
					MementoUtil.MEM_KEY_CURRENT_SCREEN);
			this.getScreenService().realize(screenName);
		}

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
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.selector.ScreenChangeListener
	 * #screenChanged()
	 */
	public void screenChanged(IScreen screen) {

		if (EditingActivator.DEBUG) {
			EditingActivator.TRACE.trace(
					EditingActivator.TRACE_EDITING_DETAILS_OPTION,
					"Screen changed: " + screen.getScreenName());
		}

		// Some screens won't have a viewer, in this case
		// the current viewer will be null, and an empty selection will be set.
		if (screen != null) {
			getActionHandlerDescriptor().clearDynamicHandlers();
			// before activating the screen, set the selection providerts.
			this.activeScreen = screen;
			this.setCurrentScreen(screen);

			// Make sure we update the dirty state, when changing screen.
			// Action handlers will use this to update the current viewer.
			firePropertyChange(ISaveablePart2.PROP_DIRTY);

			setFocus();
		}
	}

	/**
	 * @see com.netxforge.netxstudio.screens.editing.selector.ScreenChangeListener
	 *      #screenWidgetChanged
	 *      (com.netxforge.netxstudio.screens.editing.selector.IScreen)
	 */
	public void screenWidgetChanged(IScreen screen) {

		if (EditingActivator.DEBUG) {
			EditingActivator.TRACE.trace(
					EditingActivator.TRACE_EDITING_DETAILS_OPTION,
					"Screen widget changed: " + screen.getScreenName());
		}

		// force an update of the current screen, in the case of a viewer
		// change,
		// this will force the installation of a selection change listener on
		// the current
		// active viewer and corresponding provider.
		this.setCurrentScreen(screen);

		// Make sure we update the dirty state, when changing screen.
		// Action handlers will use this to update the current viewer.
		firePropertyChange(ISaveablePart2.PROP_DIRTY);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.selector.ScreenChangeListener
	 * #screenInvalid(com.netxforge.netxstudio.screens.editing.selector.IScreen)
	 */
	public void screenInvalid(IScreen screen) {
		// When our screen is invalidated, we should do whatever necessary for
		// now update the status line.
		if (screen != null) {
			this.setStatusLineManager(screen.getScreenObjects());
		}
	}

	public IScreen getScreen() {
		return this.activeScreen;
	}

	@Override
	public void contributeMenuAboutToShow(IMenuManager menuManager) {

		// Clear the menu manager.
		menuManager.removeAll();

		final ActionHandlerDescriptor actionHandlerDescriptor = this
				.getActionHandlerDescriptor();
		actionHandlerDescriptor.setMenuManager(menuManager);

		if (!ScreenUtil.isReadOnlyOperation(getScreen().getOperation())) {
			actionHandlerDescriptor.setEnableEditActions(true);
			if (this.getScreen().getViewer() instanceof TreeViewer) {
				actionHandlerDescriptor.setEnableChildCreationActions(true);
			} else {
				actionHandlerDescriptor.setEnableChildCreationActions(false);
			}
		} else {
			actionHandlerDescriptor.setEnableEditActions(false);
			actionHandlerDescriptor.setEnableChildCreationActions(false);
			actionHandlerDescriptor.setEnableSiblingCreationActions(false);
		}
		actionHandlerDescriptor.clearDynamicHandlers();

		// actions created lazily.
		final IScreen screen = getScreen();
		if (screen != null && screen.getActions() != null) {

			// get actions per widget.
			final List<IAction> actions = reverse(this.getScreen().getActions());

			final DynamicScreensActionHandler dynamicScreensActionHandler = new DynamicScreensActionHandler();
			dynamicScreensActionHandler.addActions(actions);
			actionHandlerDescriptor.addHandler(dynamicScreensActionHandler);

		}
		actionHandlerDescriptor.showMenu();
	}

	public static List<IAction> reverse(IAction[] arr) {

		List<IAction> list = Arrays.asList(arr);
		Collections.reverse(list);
		return list;
	}

	public ShowInContext getShowInContext() {
		if (this.getScreen() != null) {
			return this.getScreen().getShowIn(this.getSelection());
		}
		return new ShowInContext(null, this.getSelection());
	}

	@Override
	protected void customPartHook(IWorkbenchPart part, PART_EVENT event) {
		// Override to something with part events. . 
	}
	
}
