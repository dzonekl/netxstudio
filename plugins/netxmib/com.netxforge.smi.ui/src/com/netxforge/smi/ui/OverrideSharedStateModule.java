/*******************************************************************************
 * Copyright (c) 18 aug. 2014 NetXForge.
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

package com.netxforge.smi.ui;

import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;

/**
 * @See extension point for overriding the shared.ui.module entries
 * @author Christophe
 * 
 */
public class OverrideSharedStateModule extends AbstractModule {

	public OverrideSharedStateModule() {
	}

	@Override
	protected void configure() {
		binder().install(new PrivateModule() {
			@Override
			protected void configure() {

			}
		});
	}

}
