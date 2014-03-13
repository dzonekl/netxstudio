/*******************************************************************************
 * Copyright (c) 12 mrt. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.filter;

import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;

import com.netxforge.netxstudio.screens.editing.CDOEditingService;
import com.netxforge.screens.editing.base.filter.TreeSearchFilter;

/**
 * The matching text, will be from the ItemProvider of the EObject. Make sure
 * the type name is not returned from the ItemProvider.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class CDOTreeSearchFilter extends TreeSearchFilter {

	public CDOTreeSearchFilter() {
	}

	@Override
	protected String getMatch(Object element) {

		if (adapterFactoryItemDelegator == null) {
			adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
					CDOEditingService.getAdapterFactory());
		}
		return adapterFactoryItemDelegator.getText(element);
	}
}