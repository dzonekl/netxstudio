/*******************************************************************************
 * Copyright (c) May 18, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.activities;

import org.eclipse.ui.activities.IActivityManager;
import org.eclipse.ui.application.WorkbenchAdvisor;

import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.screens.roles.IRoleService;


/**
 * The {@link Platform} offers an {@link IActivityManager}. 
 * This service maps a user {@link Role} with a defined activity 
 * and enables it. 
 * </p>
 * Note: The mapping is hard-coded in the service. 
 * </p>
 * This service is typically called after authentication, in a
 * {@link WorkbenchAdvisor}
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public interface IActivityAndRoleService extends IRoleService {

	/**
	 * Enable the activities for an associated role. 
	 * @param role
	 */
	public abstract void enableActivity(Role role);

	
	/**
	 * Get the data service as well, as we likely inject it to get the role. 
	 * @return 
	 */
	public abstract IDataService getDataService();
	
	
}