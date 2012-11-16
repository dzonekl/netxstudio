/*******************************************************************************
 * Copyright (c) 15 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.selector;

/**
 * Screens supporting Lazy loading should implement.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public interface IScreenII {

	/**
	 * For post-UI loading screens, we can init the UI fist.
	 * 
	 * @return
	 */
	public abstract boolean initUI();

	public abstract void showPreLoadedUI();
}
