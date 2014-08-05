/*******************************************************************************
 * Copyright (c) Oct 26, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.TableColumn;

import com.google.common.base.Function;


/**
 * A table column filter which can filter CDOObject based on a provided function. 
 * 
 * @author Christophe
 *
 */
public class FunctionLabelTextTableColumnFilter extends
		LabelTextTableColumnFilter {
	
	/*
	 * The function, 
	 */
	private Function<CDOObject, Boolean> function = null;

	public FunctionLabelTextTableColumnFilter(TableColumn column) {
		super(column);
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		boolean result = true;

		if (element instanceof CDOObject && function != null) {
			result &= function.apply((CDOObject) element);
			if(!result){
				return result;
			}
		}

		// first select on the Function, then on the text.
		result &= super.select(viewer, parentElement, element);

		return result;
	}
	
	/**
	 * Set the function to filter objects. 
	 * @param function
	 */
	public void setFilterFunction(
			com.google.common.base.Function<CDOObject, Boolean> function) {
		this.function = function;
	}

}
