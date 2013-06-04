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

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.ui.activities.internal.ActivitiesActivator;
import com.netxforge.netxstudio.ui.perspective.LibraryPerspective;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisorHack {


	@Override
	public void preStartup() {
		super.preStartup();
		
		IDataService dataService = ActivitiesActivator.getDefault().getInjector().getInstance(IDataService.class);
		//		 SHould force the workbench to start with a clean sheet, if the role changed. 
		resetWorkbenchIfRoleChanged(dataService);
	}

	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    public void initialize(IWorkbenchConfigurer configurer) {
        super.initialize(configurer);
        configurer.setSaveAndRestore(true);
        this.configPluginPreferences();
    }

	public String getInitialWindowPerspectiveId() {
		return LibraryPerspective.ID;
	}
		
	/**
	 * checks the last role of the user, which was authenticated by now and
	 * makes sure the workbench init file is cleaned, if the role changed from
	 * the previous this to avoid the workbench restoring UI components not
	 * allowed by the activities.
	 * @param dataService 
	 */
	public void resetWorkbenchIfRoleChanged(IDataService dataService) {
		Role r = dataService.getCurrentRole();
		if (PickWorkspaceDialog.roleChanged(r)) {
			this.getWorkbenchConfigurer().setSaveAndRestore(false);
		}
	}

	/*
	 * simply removes the workbench file.
	 */
	@SuppressWarnings("unused")
	private void clearWorkbench() {
		IPath location = Platform.getLocation();
		IPath workbenchXml = location.addTrailingSeparator().append(".metadata").addTrailingSeparator().append(".plugins")
				.addTrailingSeparator().append("org.eclipse.ui.workbench")
				.addTrailingSeparator().append("workbench.xml");
		if (workbenchXml.toFile().exists()) {
			workbenchXml.toFile().delete();
		}
	}
	
	private void configPluginPreferences(){

		// DOESN'T WORK.
//		DISABLE_OPEN_EDITOR_IN_PLACE
		boolean currentValue = Platform.getPreferencesService().getBoolean("org.eclipse.ui.workbench", IWorkbenchPreferenceConstants.DISABLE_OPEN_EDITOR_IN_PLACE, true, null);
		IScopeContext scopeContext = DefaultScope.INSTANCE;
		IEclipsePreferences node = scopeContext.getNode("org.eclipse.ui.workbench");
		node.putBoolean(IWorkbenchPreferenceConstants.DISABLE_OPEN_EDITOR_IN_PLACE, true);
		currentValue = Platform.getPreferencesService().getBoolean("org.eclipse.ui.workbench", IWorkbenchPreferenceConstants.DISABLE_OPEN_EDITOR_IN_PLACE, true, null);
		System.out.println(currentValue ? "inplace editing disabled" : " coudn't change preference for inplace editing");
	}
	
}
