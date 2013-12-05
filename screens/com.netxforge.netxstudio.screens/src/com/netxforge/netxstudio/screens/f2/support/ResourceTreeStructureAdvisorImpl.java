/*******************************************************************************
 * Copyright (c) 24 nov. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.f2.support;

import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;

/**
 * A structure advisor for {@link NetXResource} and {@link MetricValueRange}.
 * 
 * @author Christophe Bouhier
 * 
 */
public class ResourceTreeStructureAdvisorImpl extends TreeStructureAdvisor {

	/**
	 * This is important and should return the correct parent as it is used to
	 * set the selection!
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof NetXResource) {
			return ((NetXResource) element).getComponentRef();
		} else if (element instanceof MetricValueRange) {
			return ((MetricValueRange) element).eContainer();
		}
		return super.hasChildren(element);
	}

	@Override
	public Boolean hasChildren(Object element) {

		if (element instanceof Component) {
			return !((Component) element).getResourceRefs().isEmpty();
		} else if (element instanceof NetXResource) {
			return !((NetXResource) element).getMetricValueRanges().isEmpty()
					|| !((NetXResource) element).getCapacityValues().isEmpty();
		}

		return super.hasChildren(element);
	}
}