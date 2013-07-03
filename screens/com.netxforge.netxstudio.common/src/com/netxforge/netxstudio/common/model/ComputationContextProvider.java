/*******************************************************************************
 * Copyright (c) 3 jul. 2013 NetXForge.
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
package com.netxforge.netxstudio.common.model;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.netxforge.netxstudio.common.context.IComputationContext;
import com.netxforge.netxstudio.common.context.SimpleComputationContext;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.services.RFSService;

/**
 * A Computation context which deals with objects which are specific for
 * monitoring, and can provide a global value.
 * 
 * @author Christophe Bouhier
 */
public class ComputationContextProvider extends SimpleComputationContext {

	/**
	 * Get the {@link DateTimeRange period} setting from the computation
	 * context.
	 * 
	 * @return the period or <code>null</code> if none specified.
	 */
	public DateTimeRange periodInContext() {
		final Iterable<IComputationContext> filter = Iterables.filter(context,
				new Predicate<IComputationContext>() {
					public boolean apply(IComputationContext o) {
						return o.getContext() instanceof DateTimeRange;
					}
				});
		if (Iterables.size(filter) == 1) {
			return (DateTimeRange) ((IComputationContext) filter.iterator()
					.next()).getContext();
		}
		return null;
	}

	/**
	 * Get the {@link RFSService Resource Facing Service } setting from the
	 * computation context.
	 * 
	 * @return the period or <code>null</code> if none specified.
	 */
	public RFSService rfsServiceInContext() {
		final Iterable<IComputationContext> filter = Iterables.filter(context,
				new Predicate<IComputationContext>() {
					public boolean apply(IComputationContext o) {
						return o.getContext() instanceof RFSService;
					}
				});
		if (Iterables.size(filter) == 1) {
			return (RFSService) ((IComputationContext) filter.iterator().next())
					.getContext();
		}
		return null;

	}
}
