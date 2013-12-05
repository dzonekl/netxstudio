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
package com.netxforge.netxstudio.common.context;

import java.util.List;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.services.RFSService;

/**
 * Provides one or more {@link IComputationContext}.
 * 
 * @author Christophe Bouhier
 */
public class SimpleComputationContext implements IComputationContextProvider {

	/** Our collection of context objects needed for computation **/
	protected final List<IComputationContext> context = Lists.newArrayList();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.common.context.IComputationContextProvider#
	 * addContextObject
	 * (com.netxforge.netxstudio.common.context.IComputationContext)
	 */
	public void addContextObject(IComputationContext object) {
		// Generic support for context objects.
		if (object != null && !context.contains(object)) {
			if (object.getContext() instanceof RFSService) {
				for (IComputationContext c : context) {
					if (c.getContext() instanceof RFSService) {
						// illegalstate, we should be unique for a type.
						throw new IllegalStateException(
								"attempt to add "
										+ object
										+ "while context already has an object of same type");
					}
				}
			}
			context.add(object);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.common.context.IComputationContextProvider#
	 * addContextObjects
	 * (com.netxforge.netxstudio.common.context.IComputationContext)
	 */
	public void addContextObjects(IComputationContext... objects) {
		for (IComputationContext o : objects) {
			this.addContextObject(o);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.common.context.IComputationContextProvider#
	 * clearContextObject()
	 */
	public void clearContextObjects() {
		this.context.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.common.context.IComputationContextProvider#
	 * getContextObjects()
	 */
	public IComputationContext[] getContextObjects() {
		IComputationContext[] array = new IComputationContext[context.size()];
		return this.context.toArray(array);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.common.context.IComputationContextProvider#
	 * getContextObjectsAsList()
	 */
	public List<IComputationContext> getContextObjectsAsList() {
		return this.context;
	}

}
