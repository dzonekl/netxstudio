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
package com.netxforge.netxstudio.screens.app;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.netxforge.netxstudio.screens.app.internal.ScreensApplicationActivator;

/**
 * A {@link WorkbenchAdvisor} which can be used in an RCP application
 * 
 * @author Christophe Bouhier
 * 
 */
public class ScreensWorkbenchAdvisor extends WorkbenchAdvisor {

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
		configurer.setSaveAndRestore(true);
		this.configPluginPreferences();
	}

	public String getInitialWindowPerspectiveId() {
		// return LibraryPerspective.ID;
		return null; // With a common screen, there is no initial perspective.
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

}
