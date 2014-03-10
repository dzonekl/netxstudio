/*******************************************************************************
 * Copyright (c) 7 mrt. 2014 NetXForge.
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
package com.netxforge.netxstudio.data.cdo;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Provider;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.base.data.AbstractBeanObject;

/**
 * A DI {@link Provider} which is suitable for
 * 
 * @author Christophe
 */
public abstract class AbstractCDODataProvider extends AbstractBeanObject
		implements Provider<ICDOData> {

	protected final List<ICDOData> cdoDataCollection = Lists.newArrayList();

	public List<ICDOData> getCdoDataCollection() {
		return cdoDataCollection;
	}
	
	// mis setter? Beans don't like? 

}
