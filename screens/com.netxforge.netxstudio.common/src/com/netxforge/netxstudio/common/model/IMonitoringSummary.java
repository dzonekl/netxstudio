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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;

import com.netxforge.netxstudio.common.context.IComputationContextProvider;
import com.netxforge.netxstudio.generics.DateTimeRange;

/**
 * Provides basic monitoring facilities. It extends {@link IComputationContextProvider} 
 * for the required context.  
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IMonitoringSummary extends IComputationContextProvider, Adapter {

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

	
	/**
	 * Get the {@link DateTimeRange period} formatted as a string
	 * @return
	 */
	public String getPeriodFormattedString();
	
	
	/**
	 * Get the {@link DateTimeRange period}
	 * 
	 * @return
	 */
	public DateTimeRange getPeriod();

	void clearComputation();
}
