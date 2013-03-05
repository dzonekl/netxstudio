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
package com.netxforge.netxstudio.screens.app;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * Clients should implement and register as an OSGI service, for this
 * application to discover and invoke during the lifecycle of the Application
 * startup. The Screens application will optionally use:
 * <ul>
 * <li>A custom {@link WorkbenchAdvisor} obtained from {@link }</li>
 * <li>A {@link WorkbenchWindowAdvisor} lifecycle listener§</li>
 * </ul>
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IWorkbenchService {

	/**
	 * Get a custom advisor for the Screens Application to use.
	 * 
	 * @return
	 */
	public WorkbenchAdvisor getWorkbenchAdvisor();

	/**
	 * A lifecyle notifier which is attached to the lifecycle events of the
	 * {@link WorkbenchWindowAdvisor}
	 * 
	 * @return
	 */
	public IWorkbenchWindowLifecycle getWorkbenchWindowLifecycle();

	/**
	 * An opportunity to hookin before the call to
	 * {@link PlatformUI#createAndRunWorkbench(org.eclipse.swt.widgets.Display, WorkbenchAdvisor) }
	 * It can be use to set the workspace for example. 
	 */
	public void doPreStartup(Display display);

}
