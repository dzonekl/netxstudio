/**
 * Copyright (c) 2011 NetXForge
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * Christophe Bouhier - initial API and implementation and/or initial documentation
 */
package com.netxforge.netxstudio.screens.editing.actions;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ContributionItemFactory;

/**
 * This is the action bar contributor for the Netxstudio model editor. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class UIActionsHandler implements IActionHandler,
		ISelectionChangedListener {
	/**
	 * This keeps track of the active editor. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected IWorkbenchPart activeEditorPart;

	/**
	 * This keeps track of the current selection provider. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ISelectionProvider selectionProvider;

	/**
	 * This action opens the Properties view. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	// protected IAction showPropertiesViewAction =
	// new Action("Show properties") {
	// @Override
	// public void run() {
	// try {
	// getPage().showView("org.eclipse.ui.views.PropertySheet");
	// }
	// catch (PartInitException exception) {
	// NetxstudioEditorPlugin.INSTANCE.log(exception);
	// }
	// }
	// };

	/**
	 * This action refreshes the viewer of the current editor if the editor
	 * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IAction refreshViewerAction = new Action("Refresh") {
		@Override
		public boolean isEnabled() {
			return activeEditorPart instanceof IViewerProvider;
		}

		@Override
		public void run() {
			if (activeEditorPart instanceof IViewerProvider) {
				Viewer viewer = ((IViewerProvider) activeEditorPart)
						.getViewer();
				if (viewer != null) {
					viewer.refresh();
				}
			}
		}
	};

	/**
	 * This creates an instance of the contributor. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public UIActionsHandler() {
		// loadResourceAction = new LoadResourceAction();
		// validateAction = new ValidateAction();
		// controlAction = new ControlAction();
	}

	public void initActions(IActionBars bars) {
	}

	/**
	 * When the active editor changes, this remembers the change and registers
	 * with it as a selection provider. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void setActivePart(IWorkbenchPart part) {
		activeEditorPart = part;

		// Switch to the new selection provider.
		//
		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(this);
		}
		if (part == null) {
			selectionProvider = null;
		} else {
			ISelectionProvider selectionProvider = part instanceof ISelectionProvider ? (ISelectionProvider) part
					: part.getSite().getSelectionProvider();
			selectionProvider.addSelectionChangedListener(this);

			// Fake a selection changed event to update the menus.
			//
			if (selectionProvider.getSelection() != null) {
				selectionChanged(new SelectionChangedEvent(selectionProvider,
						selectionProvider.getSelection()));
			}
		}
	}

	/**
	 * This implements
	 * {@link org.eclipse.jface.viewers.ISelectionChangedListener}, handling
	 * {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying for
	 * the children and siblings that can be added to the selected object and
	 * updating the menus accordingly. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public void selectionChanged(SelectionChangedEvent event) {

	}

	/**
	 * This populates the pop-up menu before it appears.
	 */
	public void showMenu(ActionHandlerDescriptor descriptor) {
		IMenuManager menuManager = descriptor.getMenuManager();
		this.addGlobalActions(menuManager);
	}

	/**
	 * This inserts global actions before the "additions-end" separator. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addGlobalActions(IMenuManager menuManager) {
		menuManager.insertAfter("additions-end", new Separator("ui-actions"));
		// menuManager.insertAfter("ui-actions", showPropertiesViewAction);

		refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());
		menuManager.insertAfter("ui-actions", refreshViewerAction);
		
		// The Show-in menu.		
		menuManager.add(new Separator());
		MenuManager showinMenuManager = new MenuManager("Show In");
		showinMenuManager.add(ContributionItemFactory.VIEWS_SHOW_IN.create(PlatformUI.getWorkbench().getActiveWorkbenchWindow()));
		menuManager.add(showinMenuManager);
	}

	public void propertyChanged(Object source, int propId) {
		if (source instanceof IWorkbenchPart) {
			update((IWorkbenchPart) source);
		}
	}

	public void update(IWorkbenchPart part) {
		// Update the actions, according to the selection provider.
		this.setActivePart(part);
	}

	public void deactivate() {
		// Ignore, nothing to deactivate.  
	}

}