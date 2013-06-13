/*******************************************************************************
 * Copyright (c) Feb 20, 2012 NetXForge.
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IShowInTarget;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.actions.ActionHandlerDescriptor;
import com.netxforge.netxstudio.screens.editing.actions.DynamicScreensActionHandler;

/**
 * Shows an IScreen standalone, supports showInTarget and
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public abstract class AbstractScreenViewer extends AbstractScreensViewPart
		implements IShowInTarget, ISelectionChangedListener {

	@Inject
	private IEditingServiceProvider editingServiceProvider;

	private IEditingService editingService;

	public static final String ID = "com.netxforge.netxstudio.screens.selector.AbstractScreenViewer"; //$NON-NLS-1$

	private boolean keepSynched = false;

	private ISelection lastSelection;

	/**
	 * An {@link IAction} for synchronizing screens.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class SyncViewerAction extends Action {
		public SyncViewerAction(String text, int style) {
			super(text, style);
		}

		public void run() {
			toggleLinking(isChecked());
		}
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
		final ImageDescriptor synchedDescriptor = ResourceManager
				.getPluginImageDescriptor(
						"com.netxforge.netxstudio.screens.editing",
						"/icons/full/elcl16/synced.gif");
		final SyncViewerAction syncViewerAction = new SyncViewerAction("",
				IAction.AS_CHECK_BOX);
		syncViewerAction.setImageDescriptor(synchedDescriptor);
		syncViewerAction
				.setToolTipText("Toggle linking to selection from other viewers");

		getViewSite().getActionBars().getToolBarManager().add(syncViewerAction);

		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		initScreen(parent);
	}

	protected void toggleLinking(boolean checked) {
		this.keepSynched = checked;
		if (keepSynched) {
			processSelection(lastSelection);
		}
	}

	public abstract void initScreen(Composite parent);

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
	}

	@Override
	public void contributeMenuAboutToShow(IMenuManager menuManager) {

		// Clear the menu manager.
		menuManager.removeAll();

		ActionHandlerDescriptor descriptor = this.getActionHandlerDescriptor();
		descriptor.setMenuManager(menuManager);

		if (!ScreenUtil.isReadOnlyOperation(getScreen().getOperation())) {

			descriptor.setEnableEditActions(true);

			if (this.getScreen().getViewer() instanceof TreeViewer) {
				descriptor.setEnableChildCreationActions(true);
			} else {
				descriptor.setEnableChildCreationActions(false);
			}
		} else {
			descriptor.setEnableEditActions(false);
			descriptor.setEnableChildCreationActions(false);
			descriptor.setEnableSiblingCreationActions(false);
		}

		DynamicScreensActionHandler dynamicScreensActionHandler;

		// !!!! actions would be created dynamicly.....
		IScreen screen = getScreen();
		if (screen != null && screen.getActions() != null) {
			List<IAction> actions = reverse(this.getScreen().getActions());
			dynamicScreensActionHandler = new DynamicScreensActionHandler();
			dynamicScreensActionHandler.addActions(actions);
			descriptor.addHandler(dynamicScreensActionHandler);
		}

		descriptor.showMenu();
	}

	public static List<IAction> reverse(IAction[] arr) {

		List<IAction> list = Arrays.asList(arr);
		Collections.reverse(list);
		return list;
	}

	@Override
	public IEditingService getEditingService() {
		editingService = editingServiceProvider.get();
		return editingService;
	}

	public boolean show(ShowInContext context) {
		// delegate to the screen.
		return getScreen().handleShowIn(context);
	}

	@Override
	public IScreenFormService getScreenService() {
		return null;
	}

	/**
	 * Process events from screen selectors only.
	 */
	@Override
	protected void customPartHook(IWorkbenchPart part, PART_EVENT event) {

//		 System.out.println(" Part: " + part + " event: "+event );
		if (part instanceof AbstractScreenSelector) {
			AbstractScreensViewPart screenViewPart = (AbstractScreensViewPart) part;
			switch (event) {
			case ACTIVATED: {
				screenViewPart.addSelectionChangedListener(this);
				// Note, we have multiple of those... not all might be
				// interresting...???
				// System.out.println("Let: " + this.getScreen().getScreenName()
				// + " listen to part:" + part + " ");

				// process the current selection.
				// processSelection(screenViewPart.getSelection());
			}
				break;
			case CLOSED:
				screenViewPart.removeSelectionChangedListener(this);
				// System.out.println("Remove: "
				// + this.getScreen().getScreenName() + " listen to part:"
				// + part + " ");

				break;
			case DEACTIVATE:
				// TODO We could be de-activated, but still have focus. 
				screenViewPart.removeSelectionChangedListener(this);
				// System.out.println("Remove: "
				// + this.getScreen().getScreenName() + " listen to part:"
				// + part + " ");
				break;
			case OPENEND:
				break;
			case TOTOP:
				break;
			default:
				break;

			}
		}

	}

	/**
	 * Only process a selection when we should sync. 
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		lastSelection = event.getSelection();
		if (keepSynched) {
			processSelection(lastSelection);
		}
	}

	/**
	 * Clients should implement.
	 * 
	 * @param selection
	 */
	protected void processSelection(ISelection selection) {
		// defaults to NOOP.
	}

}
