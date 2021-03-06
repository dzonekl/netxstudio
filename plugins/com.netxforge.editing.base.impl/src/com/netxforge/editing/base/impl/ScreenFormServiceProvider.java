/*******************************************************************************
 * Copyright (c) 10 jun. 2013 NetXForge.
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
import com.netxforge.screens.editing.base.IEditingService;
import com.netxforge.screens.editing.base.IEditingServiceProvider;
import com.netxforge.screens.editing.base.IScreenFactory;
import com.netxforge.screens.editing.base.IScreenFormService;
import com.netxforge.screens.editing.base.IScreenFormServiceProvider;

public class ScreenFormServiceProvider implements IScreenFormServiceProvider {

	private IEditingServiceProvider editingServiceProvider;
	
	private IScreenFactory screenFactory;

	@Inject
	public ScreenFormServiceProvider(
			IEditingServiceProvider editingServiceProvider,
			IScreenFactory screenFactory) {
		this.editingServiceProvider = editingServiceProvider;
		this.screenFactory = screenFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.internal.IScreenFormServiceProvider
	 * #get()
	 */
	public IScreenFormService get() {
		IEditingService editingService = editingServiceProvider.get();
		return new ScreenFormService(editingService, screenFactory);
	}

}
