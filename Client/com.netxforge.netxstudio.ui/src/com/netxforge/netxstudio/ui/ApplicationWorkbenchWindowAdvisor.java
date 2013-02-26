/*******************************************************************************
 * Copyright (c) Apr 26, 2011 NetXForge.
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
package com.netxforge.netxstudio.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.google.inject.Inject;
import com.netxforge.netxstudio.console.ConsoleService;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.ui.activities.IActivityAndRoleService;
import com.netxforge.netxstudio.ui.activities.internal.ActivitiesActivator;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	@Inject
	private IDataService dService;

	@Inject
	private IActivityAndRoleService activityService;

	private Role currentRole;

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		
		configurer.setInitialSize(new Point(1200, 1000));
		
		// Fast views are not compatible with standalone views. 
//		configurer.setShowFastViewBars(true);
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(true);
		configurer.setShowPerspectiveBar(true);
		configurer.setShowProgressIndicator(true);

		initializeApplication(configurer);

	}

	@Override
	public void postWindowOpen() {
		super.postWindowOpen();
		this.hideActionSets(getWindowConfigurer().getWindow().getActivePage());
	}

	/**
	 * Initialize application. Console, the current role, activities and action
	 * sets.
	 * 
	 * @param configurer
	 */
	private void initializeApplication(IWorkbenchWindowConfigurer configurer) {

		ConsoleService.INSTANCE.addConsole("NetXStudio");

		WorkspaceUtil.INSTANCE.initDefaultProject();

		// Kick of activities.
		// Inject the data service.
		ActivitiesActivator.getDefault().getInjector().injectMembers(this);

		// 15-11-2011 fixtures moved server side.

		currentRole = dService.getCurrentRole();
		configurer.setTitle("NetXStudio User: "
				+ dService.getProvider().getSessionUserID().toUpperCase()
				+ "  with role: " + currentRole.getName().toUpperCase());

		if (currentRole != null) {
			activityService.enableActivity(currentRole);
		} else {
			// Data corruption issue.
		}

		// close the transaction.
		dService.getProvider().commitTransactionThenClose();

		// dService.getQueryService().close();

		// Get the workbench and disable some actionsets:
		// These will be added again for another perspective.

		// The platform is not capable to set another input or do stuff with
		// editors, when changing pespective.
		// We need to close the editor and maintain which pespective is active
		// to be used with functions.

		configurer.getWindow().addPerspectiveListener(
				new IPerspectiveListener() {

					public void perspectiveActivated(IWorkbenchPage page,
							IPerspectiveDescriptor perspective) {
						page.closeAllEditors(true);

						hideActionSets(page);
					}

					public void perspectiveChanged(IWorkbenchPage page,
							IPerspectiveDescriptor perspective, String changeId) {

					}

				});

	}

	protected void hideActionSets(IWorkbenchPage page) {
		page.hideActionSet("org.eclipse.ui.WorkingSetActionSet");
		page.hideActionSet("org.eclipse.ui.actionSet.openFiles");
		page.hideActionSet("org.eclipse.ui.edit.text.actionSet.annotationNavigation");
		page.hideActionSet("org.eclipse.ui.edit.text.actionSet.navigation");
		page.hideActionSet("org.eclipse.ui.edit.text.actionSet.convertLineDelimitersTo");
		page.hideActionSet("org.eclipse.ui.actionSet.keyBindings");
		// page.hideActionSet("org.eclipse.update.ui.softwareUpdates");
	}

	@Override
	public boolean preWindowShellClose() {

		return super.preWindowShellClose();
	}

	@Override
	public IStatus saveState(IMemento memento) {
		// TODO Auto-generated method stub
		return super.saveState(memento);
	}

	@Override
	public void postWindowClose() {
		super.postWindowClose();

		// Close our session.
		dService.getProvider().closeSession();

		// Save our workspace.
		WorkspaceUtil.INSTANCE.saveChanges();

	}

}
