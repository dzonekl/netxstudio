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

import com.netxforge.netxstudio.client.product.splashHandlers.InjectionHelper;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.ui.roles.IRoleService;

/**
 * A role implementation which delegate to a remotel stored role and user information.  
 * 
 * @author Christophe Bouhier
 *
 */
public class ProductRoleService implements IRoleService {
	
	public Role getCurrentRole() {
		return InjectionHelper.get().getDataService().getCurrentRole();
	}

	public String getCurrentUser() {
		return InjectionHelper.get().getDataService().getProvider().getSessionUserID();
	}

}
