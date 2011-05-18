/*******************************************************************************
 * Copyright (c) May 3, 2011 NetXForge.
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
package com.netxforge.netxstudio.data;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * A data service implementation. 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
@Singleton
public class DataService implements IDataService {
	
	private final IDataProvider provider;
	private final IRoleHandler roleHandler;
	
	@Inject
	public DataService(IDataProvider provider, IRoleHandler roleHandler) {
		this.provider = provider;
		this.roleHandler = roleHandler;
	}
	
	public IDataProvider getProvider(){
		return provider;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataService#getRoleHandler()
	 */
	public IRoleHandler getRoleHandler() {
		return roleHandler;
	}
}
