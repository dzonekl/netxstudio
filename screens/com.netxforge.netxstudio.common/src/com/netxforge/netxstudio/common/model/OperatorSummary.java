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
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.common.context.IComputationContext;
import com.netxforge.netxstudio.common.context.ObjectContext;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Summarizes the state of an {@link Operator operator}
 * 
 * @author Christophe Bouhier
 */
public class OperatorSummary extends MonitoringAdapter {

	// Generated values.
	int services = 0;
	int nodes = 0;
	int functions = 0;
	int equipments = 0;
	int resources = 0;

	/** RAG for Nodes */
	Rag ragForNodes = new Rag();

	/** RAG for Resources */
	Rag ragForNetXResource = new Rag();

	@Override
	protected void computeForTarget(IProgressMonitor monitor) {

		final Operator operator = getTarget();
		int work = operator.getServices().size();

		final SubMonitor subMonitor = SubMonitor.convert(monitor, work);
		subMonitor.setTaskName("Computing summary for "
				+ modelUtils.printModelObject(operator));

		final DateTimeRange periodInContext = getPeriod();
		if (periodInContext == null) {
			return;
		}

		// Safely case, checked by our factory.

		clearComputation();
		nodes = 0;
		services = 0;
		equipments = 0;
		functions = 0;
		ragForNodes = new Rag();
		ragForNetXResource = new Rag();

		for (Service s : operator.getServices()) {
			RFSServiceSummary serviceSummary = RFSServiceSummary
					.adaptAndCompute(subMonitor, (RFSService) s,
							new IComputationContext[] {
									new ObjectContext<RFSService>(
											(RFSService) s),
									new ObjectContext<DateTimeRange>(
											getPeriod()) });
			if (serviceSummary != null) {
				resources += serviceSummary.resources;
				functions += serviceSummary.totalFunctions();
				equipments += serviceSummary.totalEquipments();
				if (serviceSummary.isComputed()) {
					ragForNodes.incrementRag(serviceSummary.ragForNodes);
				}
			}
			monitor.worked(1);
		}
	}

	public void clearComputation() {
		computationState = ComputationState.NOT_COMPUTED;
		summaryRag.cleanRag();
	}

	public Operator getTarget() {
		return (Operator) super.getTarget();
	}

	@Override
	protected boolean isRelated(CDOObject object) {
		// Not relevant for Operator object,
		// as it will be loaded as a sibbling.
		return true;
	}

	@Override
	protected boolean isNotFiltered(EObject object) {
		// Self-adapt for referenced Nodes. (Note, these are not contained).
		return object.eClass() == ServicesPackage.Literals.RFS_SERVICE;
	}

	@Override
	public int totalRag(RAG status) {
		return ragForNodes.totalRag(status);
	}
	
	public int totalServices() {
		return services;
	}

	public int totalNodes() {
		return nodes;
	}

	public int totalEquipments() {
		return equipments;
	}

	public int totalFunctions() {
		return functions;
	}

	public int totalResources() {
		return resources;
	}
	
}
