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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IShowInTarget;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.actions.handlers.ActionHandlerDescriptor;
import com.netxforge.netxstudio.screens.editing.actions.handlers.DynamicScreensActionHandler;

/**
 * Shows an {@link IScreen} in an {@link IViewPart}. A Client must implement
 * {@link AbstractScreenViewer#initScreen(Composite)} to perform it's own screen
 * initialization. </p><b>Synchronisation</b></p> It can synchronize with the
 * selection of another active {@link IViewPart}. Clients should implement
 * {@link AbstractScreenViewer#processSelection(ISelection)}
 * </p><b>Show-In</b></p> it supports {@link IShowInTarget}.
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
	 * The Viewer options.
	 * 
	 */
	private int options = 0;

	public static final int VIEWER_NO_SYNC_OPTION = 1 << 1;

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

	public AbstractScreenViewer() {
	}

	public AbstractScreenViewer(int options) {
		this.options = options;
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {

		initScreen(parent);
		if (!((options & VIEWER_NO_SYNC_OPTION) != 0)) {
			initSyncAction();
		}
	}

	/**
	 * 
	 */
	public void initSyncAction() {
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
	}

	protected void toggleLinking(boolean checked) {
		this.keepSynched = checked;
		if (keepSynched) {
			processSelection(lastSelection);
		}
	}

	public abstract void initScreen(Composite parent);

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
		// Add ourselves from the source, as here it is too hard to determine
		// the
		// exact state of source and destination part.
	}

	/**
	 * Only process a selection when we should sync.
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		// System.out.println(event + " on: " + this);
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
