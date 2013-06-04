/*******************************************************************************
 * Copyright (c) 6 feb. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.common.util;

import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.google.common.collect.Lists;

/**
 * Supports multiple {@link IStructuredSelection structured selections}
 * 
 * @author Christophe Bouhier
 */
public class AggregateSelection implements ISelection {

	private final List<IStructuredSelection> ssCollection = Lists
			.newArrayList();
	
	public boolean isEmpty() {
		return ssCollection.isEmpty();
	}

	public void add(IStructuredSelection ss) {
		ssCollection.add(ss);
	}
	
	public List<IStructuredSelection> getAll(){
		return ssCollection;
	}

}
