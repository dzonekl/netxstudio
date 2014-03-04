/*******************************************************************************
 * Copyright (c) May 18, 2011 NetXForge.
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
package com.netxforge.netxstudio.data.fixtures;

import com.netxforge.base.cdo.ICDOData;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public interface IFixtures {

	public static String ROLE_ADMIN = "admin";
	public static String ROLE_PLANNER = "planner";
	public static String ROLE_READONLY = "readonly";

	/**
	 * Will load the fixture data. Only if not existing.
	 */
	public abstract void loadFixtures();

	/**
	 * Unload the fixtures
	 */
	public void unloadFixtures();

	/**
	 * Will clear and load the retention rules.
	 */
	public void reloadRetentionRules();

	/**
	 * Inspect the load status.
	 * 
	 * @return <code>true</code> when fixtures are loaded correctly.
	 */
	public boolean areLoaded();

	/**
	 * Unloads all Fixtures (Which might have changed from the initial creation)
	 * and loads them back in again.
	 */
	public void reload();
	
	
	/**
	 * Set the data provider. 
	 * @param dataProvider
	 */
	public void setDataProvider(ICDOData dataProvider);
}