/*******************************************************************************
 * Copyright (c) 29 jan. 2013 NetXForge.
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

import org.eclipse.core.runtime.IProgressMonitor;

import com.netxforge.netxstudio.generics.DateTimeRange;

/**
 * A marker interface for monitoring objects processed in a state.
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IMonitoringSummary {

	enum RAG {
		RED, AMBER, GREEN
	}

	/**
	 * Get the monitoring period.
	 * 
	 * @return
	 */
	public DateTimeRange getPeriod();

	/**
	 * Set the monitoring period.
	 * 
	 * @param period
	 */
	public void setPeriod(DateTimeRange period);

	/**
	 * Get the monitoring period formatted as String for presentation.
	 * 
	 * @return
	 */
	public String getPeriodFormattedString();

	/**
	 * Add an additional context for computations.
	 * 
	 * @param object
	 */
	public void addContextObject(Object object);

	/**
	 * Add a bunch of context objects.
	 * 
	 * @param object
	 */
	public void addContextObjects(Object... objects);

	/**
	 * Get the context objects.
	 * 
	 * @return
	 */
	public Object[] getContextObjects();

	/**
	 * 
	 * @param monitor
	 */
	public void compute(IProgressMonitor monitor);

	/**
	 * Returns if the computation succeeded. Clients must define 'success' by
	 * their implementation of this method. Implementors are recommended that
	 * derived features of the summary, will not return <code>null</code> when
	 * this method returns <code>true</code>
	 * 
	 * @return
	 */
	public boolean isComputed();

	/**
	 * All summaries have a rag.
	 */
	public int[] rag();

}
