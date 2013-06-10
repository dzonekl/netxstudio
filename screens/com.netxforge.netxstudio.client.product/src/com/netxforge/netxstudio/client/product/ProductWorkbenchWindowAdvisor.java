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
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;

import com.google.inject.Inject;
import com.netxforge.netxstudio.console.ConsoleService;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.screens.activities.IActivityAndRoleService;
import com.netxforge.netxstudio.screens.app.AbstractWorkbenchWindowLifecycle;
import com.netxforge.netxstudio.screens.app.IWorkbenchWindowLifecycle;
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

	/**
	 * A self, which is offered as an OSGI service.
	 */
	private static ProductWorkbenchWindowAdvisor self = new ProductWorkbenchWindowAdvisor();

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

		String currentUser = activityAndRoleService.getCurrentUser();

		if (currentUser != null) {
			configurer.setTitle("NetXStudio User: " + currentUser.toUpperCase()
					+ "  with role: " + currentRole.getName().toUpperCase());

		} else {
			configurer.setTitle("NetXStudio");
		}
		if (currentRole != null) {
			activityAndRoleService.enableActivity(currentRole);
		} else {
			// Data corruption issue.
		}

		// close the transaction.
		// dService.getProvider().commitTransactionThenClose();

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

	public IWorkbenchWindowLifecycle getWorkbenchWindowLifecycle() {
		return self;
	}

	public static IWorkbenchWindowLifecycle getINSTANCE() {
		return self;
	}

}
