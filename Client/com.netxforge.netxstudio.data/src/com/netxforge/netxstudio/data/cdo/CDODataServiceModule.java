/*******************************************************************************
 * Copyright (c) May 12, 2011 NetXForge.
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
package com.netxforge.netxstudio.data.cdo;

import com.netxforge.netxstudio.data.DataService;
import com.netxforge.netxstudio.data.DataServiceModule;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.IRoleHandler;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public class CDODataServiceModule extends DataServiceModule {
	

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		this.bind(IDataProvider.class).to(CDODataProvider.class);
		this.bind(IDataService.class).to(DataService.class);
		this.bind(ICDOConnection.class).to(CDODataConnection.class);
		this.bind(IRoleHandler.class).to(CDORoleHandler.class);
	}
}
