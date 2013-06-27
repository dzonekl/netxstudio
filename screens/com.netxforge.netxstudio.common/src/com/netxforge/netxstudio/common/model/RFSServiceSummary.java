/*******************************************************************************
 * Copyright (c) 5 dec. 2012 NetXForge.
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

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * A model object, showing the summary of a Service.
 * 
 * @author Christophe Bouhier
 * 
 */
public class RFSServiceSummary extends MonitoringAdapter {

	// Generated values.
	int services = 0;
	int nodes = 0;
	int functions = 0;
	int equipments = 0;
	int resources = 0;

	@Override
	protected void computeForTarget(IProgressMonitor monitor) {

		final DateTimeRange periodInContext = getPeriod();
		if (periodInContext == null) {
			return;
		}
		// Safely case, checked by our factory.
		final RFSService target = getRFSService();

		// Add ourself as a context, if not already.
		if (this.rfsServiceInContext() == null) {
			this.addContextObject(target);
		}

		nodes = 0;
		services = 0;
		equipments = 0;
		functions = 0;

		computeForRFService(target, monitor);

	}
	
	/**
	 * Computation here is based on 
	 * 
	 * 
	 * @param service
	 * @param monitor
	 */
	public void computeForRFService(RFSService service, IProgressMonitor monitor) {

		// Include our own service as well.
		services += 1;

		int work = service.getNodes().size();
		final SubMonitor subMonitor = SubMonitor.convert(monitor, work);
		subMonitor.setTaskName("Computing summary for "
				+ modelUtils.printModelObject(service));

		for (Node node : service.getNodes()) {

			nodes += 1;

			// With no NODE Type, don't bail out.
			if (!node.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
				continue;
			}

			// When not accessing child collections, we will not load.
			node.getNodeType();

			IMonitoringSummary childAdapter = this.getChildAdapter(node
					.getNodeType());
			//
			// Guard for potentially non-adapted children.
			if (childAdapter != null) {

				childAdapter.addContextObjects(this.getContextObjects());
				childAdapter.compute(monitor);

				// FIXME We should base our RAG on external expression
				// computation.
				this.incrementRag(childAdapter.rag());

				if (childAdapter instanceof NodeTypeSummary) {

					NodeTypeSummary nodeTypeSummary = (NodeTypeSummary) childAdapter;
					resources += nodeTypeSummary.totalResources();
					functions += nodeTypeSummary.totalFunctions();
					equipments += nodeTypeSummary.totalEquipments();
				}
			} else {
				// Self Adapt?

			}
			monitor.worked(1);
		}

		for (Service childService : service.getServices()) {
			// Descend the Service Hiearchy first.
			if (service instanceof RFSService) {
				computeForRFService((RFSService) childService, monitor);
			}
		}
	}

	@Override
	protected boolean isSameAdapterFor(EObject object) {
		return false; // Always produce new adapters.
	}

	@Override
	protected boolean isNotFiltered(EObject object) {
		// Self-adapt for referenced Nodes. (Note, these are not contained).
		return object.eClass() == OperatorsPackage.Literals.NODE;
	}

	@Override
	protected boolean isRelated(CDOObject object) {
		// TODO, Should apply to the full hiarchy.
		// Containments are handled with isContained().

		// So:
		// 1. Nodes should be referenced by the service. (Non-Containment). 
		// 2. NodeType should be contained by the Node.
		return this.isContained(object)
				|| getRFSService().getNodes().contains(object)
				|| modelUtils.nodeTypeForService(this.getRFSService())
						.contains(object);
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

	public RFSService getRFSService() {
		final RFSService target = (RFSService) super.getTarget();
		return target;
	}

}