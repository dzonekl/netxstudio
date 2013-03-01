/*******************************************************************************
 * Copyright (c) 1 mrt. 2013 NetXForge.
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
package com.netxforge.netxstudio.ui;

import com.netxforge.netxstudio.generics.Role;

public interface IRoleService {
		
	
	/**
	 * A null implementation. 
	 * 
	 * @author Christophe Bouhier
	 *
	 */
	public static class NullRoleService implements IRoleService {
		
		public Role getCurrentRole() {
			return null;
		}

		public String getCurrentUser() {
			return null;
		}
		
	}
	
	public Role getCurrentRole();
	
	/**
	 * Get the current User
	 * @return
	 */
	public String getCurrentUser();
	
}
