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
package com.netxforge.netxstudio.client.product;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.screens.activities.IActivityAndRoleService;
import com.netxforge.netxstudio.screens.app.IWorkbenchService;
import com.netxforge.netxstudio.screens.app.ScreensWorkbenchWindowAdvisor;
import com.netxforge.netxstudio.screens.app.internal.ScreensApplicationActivator;
import com.netxforge.netxstudio.screens.ide.IDEWorkbenchAdvisor;
import com.netxforge.netxstudio.screens.ide.PickWorkspaceDialog;

/**
 * A {@link WorkbenchAdvisor} which can be used in an RCP application correctly
 * initializing the IDE plugin.
 * 
 * @author Christophe Bouhier
 */
public class ProductWorkbenchAdvisor extends IDEWorkbenchAdvisor {

	@Inject
	private IActivityAndRoleService roleService;

	@Override
	public void preStartup() {
		super.preStartup();

		// SHould force the workbench to start with a clean sheet, if the role
		// changed.
		resetWorkbenchIfRoleChanged();
	}

	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {

		final ScreensWorkbenchWindowAdvisor screensWorkbenchWindowAdvisor = new ScreensWorkbenchWindowAdvisor(
				configurer);

		IWorkbenchService wbWindowLifecycleService = ScreensApplicationActivator
				.getDefault().getWorkbenchService();

		// Hook in the advisor and workbench window listeners from the actual
		// product, if any, otherwise we will be a bare bone application.
		if (wbWindowLifecycleService != null) {

			// Hook in listeners from the actual product, if any, otherwise we
			// will be a bare bone application.

			screensWorkbenchWindowAdvisor
					.addLifecycleListener(wbWindowLifecycleService
							.getWorkbenchWindowLifecycle());
		}
		return screensWorkbenchWindowAdvisor;
	}

	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);
		this.configPluginPreferences();
	}

	public String getInitialWindowPerspectiveId() {
		// return LibraryPerspective.ID;
		return null; // With a common screen, there is no initial perspective.
	}

	/**
	 * checks the last role of the user, which was authenticated by now and
	 * makes sure the workbench init file is cleaned, if the role changed from
	 * the previous this to avoid the workbench restoring UI components not
	 * allowed by the activities.
	 * 
	 * @param dataService
	 */
	public void resetWorkbenchIfRoleChanged() {
		Role r = roleService.getCurrentRole();

		if (r != null && PickWorkspaceDialog.roleChanged(r.getName())) {
			this.getWorkbenchConfigurer().setSaveAndRestore(false);
			// Should really show the intro. 
		}
	}

	/*
	 * simply removes the workbench file.
	 */
	@SuppressWarnings("unused")
	private void clearWorkbench() {
		IPath location = Platform.getLocation();
		IPath workbenchXml = location.addTrailingSeparator()
				.append(".metadata").addTrailingSeparator().append(".plugins")
				.addTrailingSeparator().append("org.eclipse.ui.workbench")
				.addTrailingSeparator().append("workbench.xml");
		if (workbenchXml.toFile().exists()) {
			workbenchXml.toFile().delete();
		}
	}

	private void configPluginPreferences() {

		// DOESN'T WORK.
		// DISABLE_OPEN_EDITOR_IN_PLACE
		boolean currentValue = Platform.getPreferencesService().getBoolean(
				"org.eclipse.ui.workbench",
				IWorkbenchPreferenceConstants.DISABLE_OPEN_EDITOR_IN_PLACE,
				true, null);
		IScopeContext scopeContext = DefaultScope.INSTANCE;
		IEclipsePreferences node = scopeContext
				.getNode("org.eclipse.ui.workbench");
		node.putBoolean(
				IWorkbenchPreferenceConstants.DISABLE_OPEN_EDITOR_IN_PLACE,
				true);
		currentValue = Platform.getPreferencesService().getBoolean(
				"org.eclipse.ui.workbench",
				IWorkbenchPreferenceConstants.DISABLE_OPEN_EDITOR_IN_PLACE,
				true, null);
		System.out.println(currentValue ? "inplace editing disabled"
				: " coudn't change preference for inplace editing");
	}

	public void setWorkspaceLocation(Shell splash) {
		// set location to c:\temp

		// fetch the Location that we will be modifying
		Location instanceLoc = Platform.getInstanceLocation();
		if (instanceLoc.isSet()) {
			return;
		}
		try {
			// // temp should always return a location.
			// String temp = System.getProperty("java.io.tmpdir");
			// if (temp != null) {
			// instanceLoc.set(new URL("file", null, temp), false);
			// }
			//

			// get what the user last said about remembering the workspace
			// location
			boolean remember = PickWorkspaceDialog.isRememberWorkspace();

			// get the last used workspace location
			String lastUsedWs = PickWorkspaceDialog
					.getLastSetWorkspaceDirectory();

			// if we have a "remember" but no last used workspace, it's not much
			// to
			// remember
			if (remember && (lastUsedWs == null || lastUsedWs.length() == 0)) {
				remember = false;
			}

			// check to ensure the workspace location is still OK
			if (remember) {
				// if there's any problem whatsoever with the workspace, force a
				// dialog which in its turn will tell them what's bad
				String ret = PickWorkspaceDialog.checkWorkspaceDirectory(
						splash, lastUsedWs, false, false);
				if (ret != null) {
					remember = false;
				}

			}

			// if we don't remember the workspace, show the dialog
			if (!remember) {
				PickWorkspaceDialog pwd = new PickWorkspaceDialog(splash, false);
				int pick = pwd.open();

				// if the user cancelled, we can't do anything as we need a
				// workspace, so in this case, we tell them and exit
				if (pick == Window.CANCEL) {
					if (pwd.getSelectedWorkspaceLocation() == null) {
						MessageDialog
								.openError(splash, "Error",
										"The application can not start without a workspace root and will now exit.");
						try {
							PlatformUI.getWorkbench().close();
						} catch (Exception err) {

						}
					}
				} else {
					// tell Eclipse what the selected location was and continue
					instanceLoc.set(
							new URL("file", null, pwd
									.getSelectedWorkspaceLocation()), false);
				}
			} else {
				// set the last used location and continue
				instanceLoc.set(new URL("file", null, lastUsedWs), false);
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
