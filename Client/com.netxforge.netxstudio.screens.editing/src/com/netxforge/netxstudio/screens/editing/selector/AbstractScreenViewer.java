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
package com.netxforge.netxstudio.screens.editing.selector;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.IShowInTarget;
import org.eclipse.ui.part.ShowInContext;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.AbstractScreensViewPart;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.actions.ActionHandlerDescriptor;
import com.netxforge.netxstudio.screens.editing.actions.DynamicScreensActionHandler;

/**
 * Shows an IScreen standalone. 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public abstract class AbstractScreenViewer extends AbstractScreensViewPart implements IShowInTarget {


	public static final String ID = "com.netxforge.netxstudio.screens.selector.AbstractScreenViewer"; //$NON-NLS-1$
	
	@Inject
	private IEditingService editingService;
	
//	@Inject
//	private ModelUtils modelUtils;

	public AbstractScreenViewer() {
		
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
		
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		initScreen(parent);
		
		
		// Our service.
//		getEditingService().setViewerProvider(this);
//		getEditingService().setScreenProvider(this);
		
		
		
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
		// Do we need a service, here as we are injected by selection. 
		return editingService;
	}
	
	public boolean show(ShowInContext context) {
		
		// delegate to the screen. 
		return getScreen().handleShowIn(context);
//		
//		if( ScreenUtil.isDataScreenInjection(getScreen())) {
//			ISelection selection = context.getSelection();
//			if(selection instanceof IStructuredSelection){
//				
//				// TODO ... HACK.....
//				Object firstElement = ((IStructuredSelection) selection).getFirstElement();
//				System.out.println(" show-in" + firstElement.getClass().getSimpleName());
//				
//				if(firstElement instanceof NetXResource){
//					
//					MetricValueRange mvr = modelUtils.valueRangeForInterval((NetXResource) firstElement, 60);
//					if(ScreenUtil.isDataScreenInjection(getScreen())){
//						ScreenUtil.dataScreenInjectionFor(getScreen()).injectData(firstElement, mvr.getMetricValues());
//					}
//				}
//			}
//			
//		}
	}
	
}
