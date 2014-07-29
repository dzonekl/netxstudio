/*******************************************************************************
 * Copyright (c) 9 jun. 2013 NetXForge.
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
package com.netxforge.editing.base.impl;

import com.google.inject.Inject;
import com.netxforge.base.data.IDataProvider;
import com.netxforge.screens.editing.base.IEditingService;
import com.netxforge.screens.editing.base.IEditingServiceProvider;

public class EMFEditingServiceProvider implements IEditingServiceProvider {

	private IDataProvider dataProvider;

	@Inject
	public EMFEditingServiceProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.IEditingServiceProvider#get()
	 */
	public IEditingService get() {
		// Create a single provider instance associated with this editing session.
		// When closing the editing
		return new EMFEditingService(dataProvider.get());
	}

}
