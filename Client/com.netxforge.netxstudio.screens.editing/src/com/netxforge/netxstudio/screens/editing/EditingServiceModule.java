/*******************************************************************************
 * Copyright (c) May 10, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.editing;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.netxforge.netxstudio.screens.editing.actions.clipboard.ClipboardService;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.editing.selector.ScreenFormService;


/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class EditingServiceModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		this.bind(IEditingService.class).to(CDOEditingService.class);
		bind(IScreenFactory.class).to(ScreenFactory.class);
		this.bind(IScreenFormService.class).to(ScreenFormService.class);
		this.bind(ClipboardService.class).in(Scopes.SINGLETON);
	}
}
