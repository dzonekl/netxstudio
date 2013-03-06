/*******************************************************************************
 * Copyright (c) May 1, 2011 NetXForge.
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

package com.netxforge.netxstudio.screens.editing;

import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISaveablePart2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

/**
 * A ViewPart which acts as an editor.
 * 
 * @author Christophe Bouhier
 */
public abstract class AbstractEditorViewPartSimple extends ViewPart implements
		ISaveablePart2, IPartListener, IEditingDomainProvider {

	//	public static final String ID = "com.netxforge.netxstudio.ui.forms.EquipmentsViewPart"; //$NON-NLS-1$

	/**
	 * This keeps track of the selection of the view as a whole.
	 */
	protected ISelection viewSelection = StructuredSelection.EMPTY;

	// Our global action handler.
	private GlobalActionsHandler globActionsHandler = new GlobalActionsHandler();

	public AbstractEditorViewPartSimple() {
		createActions();
	}

	/**
	 * Supers should override.
	 */
	private void createActions() {

	}

	// The declared EMF edit adapter factory.
	ComposedAdapterFactory emfEditAdapterFactory;

	private ComposedAdapterFactory getAdapterFactory() {
		if (emfEditAdapterFactory == null) {
			emfEditAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return emfEditAdapterFactory;
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		initBindings();
		initializeToolBar();
		initializeMenu();
	}

	// Databinding API
	private void initBindings() {
		// we don't do any bindings here.
	}

	public void dispose() {
		super.dispose();
		this.getSite().getPage().removeSelectionListener(pageSelectionListener);
	}

	private ISelectionListener pageSelectionListener;

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
		IMenuManager manager = getViewSite().getActionBars().getMenuManager();
		IMenuManager x = new MenuManager("Test",
				"com.netxforge.netxstudio.test");
		manager.add(x);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	// Save memento state.
	String AKEY = "AKey";
	float aValue;

	@Override
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		if (memento != null && memento.getFloat(AKEY) != null) {
			aValue = memento.getFloat(AKEY);
		}
		site.getPage().addPartListener(this);
		// Set the current editor as selection provider.
		globActionsHandler.initActions(site.getActionBars());
	}

	// ISaveablePart2 API.
	@Override
	public void saveState(IMemento memento) {
		super.saveState(memento);
		memento.putFloat(AKEY, 0.1f);
	}

	/**
	 * We deal with objects in resources outside our own editing domain.
	 */
	public void doSave(IProgressMonitor monitor) {

		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running
		// activity that modifies the workbench.
		//
		IRunnableWithProgress operation = new IRunnableWithProgress() {

			// This is the method that gets invoked when the operation runs.
			//
			public void run(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				for (Resource resource : getEditingDomain().getResourceSet()
						.getResources()) {
					if ((first || !resource.getContents().isEmpty())
							&& !getEditingDomain().isReadOnly(resource)) {
						try {
							resource.save(saveOptions);
						} catch (Exception exception) {
						}
						first = false;
					}
				}
			}
		};

		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false,
					operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack) getEditingDomain().getCommandStack())
					.saveIsDone();
			firePropertyChange(ISaveablePart2.PROP_DIRTY);
		} catch (Exception exception) {
			// Something went wrong that shouldn't.
		}

	}

	public void doSaveAs() {
	}

	// @Override
	// public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
	// if (key.equals(ISaveablePart2.class)) {
	// return this;
	// }
	// return super.getAdapter(key);
	// }

	/**
	 * Based on the command stack statues.
	 */
	public boolean isDirty() {

		boolean result = ((BasicCommandStack) getEditingDomain()
				.getCommandStack()).isSaveNeeded();

		return result;
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	public boolean isSaveOnCloseNeeded() {
		return true;
	}

	public int promptToSaveOnClose() {
		return ISaveablePart2.PROP_DIRTY;
	}

	// IPartListner API.
	public void partActivated(IWorkbenchPart part) {
		// Register selection listeners.
		if (part instanceof AbstractEditorViewPartSimple) {
			// Activate our global actions.
			globActionsHandler.activate(part);
			System.out.println("NodePopulateViewPart, part actived");
		} else {
			System.out.println("Other part activated: "
					+ part.getSite().getId());
		}
	}

	public void partBroughtToTop(IWorkbenchPart part) {
		// Not used.
	}

	public void partClosed(IWorkbenchPart part) {
		// Not used.
	}

	public void partDeactivated(IWorkbenchPart part) {
		if (part instanceof AbstractEditorViewPartSimple) {
			globActionsHandler.deactivate(part);
			System.out.println("NodePopulateViewPart, part deactived");
		} else {
			System.out.println("Other part de-activated: "
					+ part.getSite().getId());
		}
	}

	public void partOpened(IWorkbenchPart part) {
		// Not used.
		System.out.println("NodePopulateViewPart, part opened");
	}


	// IEditingDomainProvider API.

	AdapterFactoryEditingDomain domain = null;

	public EditingDomain getEditingDomain() {
		if (domain == null) {
			BasicCommandStack commandStack = new BasicCommandStack();

			// Add a listener to set the viewer dirty state.

			CommandStackListener cmdStackListener = new CommandStackListener() {
				public void commandStackChanged(final EventObject event) {
					getViewSite().getShell().getDisplay()
							.asyncExec(new Runnable() {
								public void run() {
									firePropertyChange(ISaveablePart2.PROP_DIRTY);
								}
							});
				}
			};
			commandStack.addCommandStackListener(cmdStackListener);

			domain = new AdapterFactoryEditingDomain(this.getAdapterFactory(),
					commandStack);
		}
		return domain;
	}
}