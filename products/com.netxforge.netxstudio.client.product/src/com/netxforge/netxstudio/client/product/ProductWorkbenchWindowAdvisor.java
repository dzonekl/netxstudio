/*******************************************************************************
 * Copyright (c) 4 mrt. 2013 NetXForge.
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
package com.netxforge.netxstudio.client.product;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;

import com.google.inject.Inject;
import com.netxforge.netxstudio.console.ConsoleService;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.screens.activities.IActivityAndRoleService;
import com.netxforge.netxstudio.screens.app.AbstractWorkbenchWindowLifecycle;
import com.netxforge.netxstudio.screens.ide.WorkspaceUtil;

/**
 * This products workbench window settings.
 * 
 * @author Christophe Bouhier
 */
public class ProductWorkbenchWindowAdvisor extends
		AbstractWorkbenchWindowLifecycle {

	@Inject
	private IActivityAndRoleService activityAndRoleService;

	@Override
	public void preWindowOpen(IWorkbenchWindowConfigurer configurer) {
		configurer.setInitialSize(new Point(1200, 1000));

		// Fast views are not compatible with standalone views.
		// configurer.setShowFastViewBars(true);
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(true);
		configurer.setShowPerspectiveBar(true);
		configurer.setShowProgressIndicator(true);

		initializeApplication(configurer);
	}

	/**
	 * Initialize application. Console, the current role, activities and action
	 * sets.
	 * 
	 * @param configurer
	 */
	private void initializeApplication(IWorkbenchWindowConfigurer configurer) {

		// Create a Console.
		// Requires auto activation in OSGI config.ini
		ConsoleService.INSTANCE.addConsole("NetXStudio");

		WorkspaceUtil.INSTANCE.initDefaultProject();

		final Role currentRole = activityAndRoleService.getCurrentRole();
		final String currentUser = activityAndRoleService.getCurrentUser();
		final String server = activityAndRoleService.getDataService()
				.getServer();

		if (currentUser != null) {
			configurer.setTitle("NetXStudio User: " + currentUser.toUpperCase()
					+ "  with role: " + currentRole.getName().toUpperCase()
					+ " on: " + server);

		} else {
			configurer.setTitle("NetXStudio");
		}
		if (currentRole != null) {
			activityAndRoleService.enableActivity(currentRole);
			currentRole.cdoView().close();
		} else {
			// Data corruption issue.
		}

		// Get the workbench and disable some actionsets:
		// These will be added again for another perspective.

		// The platform is not capable to set another input or do stuff with
		// editors, when changing pespective.
		// We need to close the editor and maintain which pespective is active
		// to be used with functions.

		configurer.getWindow().addPerspectiveListener(new PerspectiveAdapter() {

			public void perspectiveActivated(IWorkbenchPage page,
					IPerspectiveDescriptor perspective) {
				page.closeAllEditors(true);
				hideActionSets(page);
				System.out.println("Perspective : Activated "
						+ perspective.getId());
				printPage(page);
			}

			@Override
			public void perspectiveOpened(IWorkbenchPage page,
					IPerspectiveDescriptor perspective) {
				System.out.println("Perspective : Opened "
						+ perspective.getId());
			}

			@Override
			public void perspectiveClosed(IWorkbenchPage page,
					IPerspectiveDescriptor perspective) {
				System.out.println("Perspective : Closed "
						+ perspective.getId());
			}

			@Override
			public void perspectiveDeactivated(IWorkbenchPage page,
					IPerspectiveDescriptor perspective) {
				System.out.println("Perspective : Deactivated "
						+ perspective.getId());
				printPage(page);
			}

		});

	}

	@Override
	public void postWindowClose(
			IWorkbenchWindowConfigurer iWorkbenchWindowConfigurer) {
		// Save our workspace.
		WorkspaceUtil.INSTANCE.saveChanges();
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

}
