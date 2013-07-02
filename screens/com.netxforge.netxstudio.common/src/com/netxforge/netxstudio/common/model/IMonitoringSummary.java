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
import org.eclipse.emf.common.notify.AdapterFactory;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.services.RFSService;

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
	 * The total number of RAG entries for a summary. 
	 * 
	 * @param status
	 * @return
	 */
	public int totalRag(RAG status);
	
	/**
	 * All summaries have a rag.
	 */
	public int[] rag();
	
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
	 * Clear the computation context.
	 */
	public void clearContextObject();

	/**
	 * Get the period from the context or <code>null</code>
	 * 
	 * @return
	 */
	public DateTimeRange getPeriod();

	/**
	 * Get the {@link RFSService} from the context or <code>null</code>
	 * 
	 * @return
	 */
	public RFSService getRFSService();

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
	 * Set the {@link AdapterFactory} for producing adapters when Self-adapting.
	 * 
	 * @param monitoringAdapterFactory
	 */
	public void setSelfAdaptFactory(AdapterFactory adapterFactory);

}
