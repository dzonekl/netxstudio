/*******************************************************************************
 * Copyright (c) Nov 2, 2012 NetXForge.
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
package com.netxforge.netxstudio.client.product.splashHandlers;

import com.netxforge.netxstudio.common.internal.CommonActivator;
import com.netxforge.netxstudio.common.properties.PropertiesUtil;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.ui.activities.IActivityAndRoleService;
import com.netxforge.netxstudio.ui.activities.internal.ActivitiesActivator;

/**
 * Delegate to other plugins, having access to DI modules.
 * 
 * @author Christophe Bouhier
 * 
 */
public class InjectionHelper {

	private IDataService dataService;

	private PropertiesUtil propsUtil;

	private IActivityAndRoleService activityAndRoleService;

	private static final InjectionHelper self = new InjectionHelper();

	public InjectionHelper() {
	}

	public static InjectionHelper get() {
		return self;
	}

	public IDataService getDataService() {
		if (dataService == null) {
			dataService = DataActivator.getInjector().getInstance(
					IDataService.class);
		}

		return dataService;
	}

	public PropertiesUtil getPropsUtil() {
		if (propsUtil == null) {
			propsUtil = CommonActivator.getInstance().getInjector()
					.getInstance(PropertiesUtil.class);
		}
		return propsUtil;
	}

	public IActivityAndRoleService getActivityAndRoleService() {

		if (activityAndRoleService == null) {
			activityAndRoleService = ActivitiesActivator.getDefault()
					.getInjector().getInstance(IActivityAndRoleService.class);
		}
		return activityAndRoleService;
	}

}
