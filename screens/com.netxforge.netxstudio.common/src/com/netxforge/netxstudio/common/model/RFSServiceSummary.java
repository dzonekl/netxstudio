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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.common.context.IComputationContext;
import com.netxforge.netxstudio.common.context.ObjectContext;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * A model object, holding the summary of a Service.
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

	/** RAG for Nodes */
	Rag ragForNodes = new Rag();

	/** RAG for Resources */
	Rag ragForNetXResource = new Rag();

	@Override
	protected void computeForTarget(IProgressMonitor monitor) {

		final DateTimeRange periodInContext = getPeriod();
		if (periodInContext == null) {
			return;
		}
		// Safely case, checked by our factory.
		final RFSService rfsService = getRFSServiceFromTarget();

		// Add ourself as a context, if not already.
		if (this.getRFSService() == null) {
			this.addContextObject(new ObjectContext<RFSService>(rfsService));
		}

		clearComputation();
		nodes = 0;
		services = 0;
		equipments = 0;
		functions = 0;
		ragForNodes = new Rag();
		ragForNetXResource = new Rag();

		computeForRFService(monitor, rfsService);
	}

	/**
	 * Explicitly allow RAG to be set from an external calculation. (By an
	 * {@link IExpressionEngine} for example.
	 */
	public void setRag(RAG rag, int ragValue) {
		super.setRag(rag, ragValue);
	}

	/**
	 * Computation here is based on the RAG status for the nodes and resources.
	 * The computation for the service can be set externally. For this we have
	 * special set*** methods. </br> The Computation of rage for {@link Node}
	 * and {@link NetXResource}.
	 * 
	 * @param monitor
	 * @param service
	 */
	public void computeForRFService(IProgressMonitor monitor, RFSService service) {

		// Include our own service as well.
		services += 1;

		boolean childServiceComputed = true;

		// Descend the Service Hierarchy for additional aggregation.
		for (Service childService : service.getServices()) {
			if (service instanceof RFSService) {
				RFSServiceSummary serviceSummary = adaptAndCompute(monitor,
						(RFSService) childService, new IComputationContext[] {
								new ObjectContext<RFSService>(
										(RFSService) childService),
								new ObjectContext<DateTimeRange>(getPeriod()) });
				if (serviceSummary != null) {
					resources += serviceSummary.resources;
					functions += serviceSummary.totalFunctions();
					equipments += serviceSummary.totalEquipments();
					if (serviceSummary.isComputed()) {
						ragForNodes.incrementRag(serviceSummary.ragForNodes);
					} else {
						childServiceComputed = false;
					}
				}
			}
		}

		// Node computation.
		nodes += service.getNodes().size();
		int computedNodes = 0;

		if (!service.getNodes().isEmpty()) {

			int work = service.getNodes().size();
			final SubMonitor nodeMonitor = SubMonitor.convert(monitor, work);
			nodeMonitor.setTaskName("Computing summary for "
					+ modelUtils.printModelObject(service));

			// Narrow the node scope to the ones which have monitoring data.

			for (Node node : service.getNodes()) {

				// With no NODE Type, bail out.
				if (!node.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
					nodeMonitor.worked(1);
					continue;
				}

				// When not accessing child collections, we will not load.
				NodeType nodeType = node.getNodeType();

				NodeTypeSummary nodeTypeSummary = adaptAndCompute(nodeMonitor,
						nodeType, this.getContextObjects());

				if (nodeTypeSummary != null) {
					if (nodeTypeSummary.isComputed()) {
						computedNodes++;
						ragForNodes.incrementRag(nodeTypeSummary.rag());
					}

					resources += nodeTypeSummary.totalResources();
					functions += nodeTypeSummary.totalFunctions();
					equipments += nodeTypeSummary.totalEquipments();
				} else {
					System.out.println("SHOULD NOT OCCUR: child not adapted! "
							+ modelUtils.printModelObject(nodeType));
				}

				nodeMonitor.worked(1);
			}

		}

		if (computedNodes == nodes && childServiceComputed) {
			computationState = ComputationState.COMPUTED;
		}

	}

	/**
	 * Adapt an {@link RFSService} and compute with a
	 * {@link IComputationContext computation context}. If the object is already
	 * adapted, we don't invoke the {@link MonitoringStateModel} for adaptation.
	 * 
	 * @param monitor
	 * @param service
	 * 
	 * @return {@link RFSServiceSummary}
	 */
	public static RFSServiceSummary adaptAndCompute(IProgressMonitor monitor,
			RFSService service, IComputationContext... contextObjects) {

		IMonitoringSummary adaptAndCompute = MonitoringAdapter.adaptAndCompute(
				monitor, service, contextObjects);

		if (adaptAndCompute instanceof RFSServiceSummary) {
			RFSServiceSummary serviceSummary = (RFSServiceSummary) adaptAndCompute;
			return serviceSummary;
		}
		return null;
	}

	public static NodeTypeSummary adaptAndCompute(IProgressMonitor monitor,
			NodeType nodeType, IComputationContext... contextObjects) {

		IMonitoringSummary adaptAndCompute = MonitoringAdapter.adaptAndCompute(
				monitor, nodeType, contextObjects);

		if (adaptAndCompute instanceof NodeTypeSummary) {
			NodeTypeSummary nodeTypeSummary = (NodeTypeSummary) adaptAndCompute;
			return nodeTypeSummary;
		}
		return null;
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

		// 1. Nodes should be referenced by the service. (Non-Containment).
		// 2. NodeType should be adapted so contained by one of the nodes
		// referenced
		// by the service.

		final RFSService rfsServiceFromTarget = getRFSServiceFromTarget();

		List<NodeType> nodeTypeForService = modelUtils
				.nodeTypeForService(rfsServiceFromTarget);

		return this.isContained(object) || nodeTypeForService.contains(object);
	}

	public int totalNodeRag(RAG status) {
		return ragForNodes.ragCount[status.ordinal()];
	}

	public int totalNetXResourceRag(RAG status) {
		return ragForNetXResource.ragCount[status.ordinal()];
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

	public RFSService getRFSServiceFromTarget() {
		final RFSService target = (RFSService) super.getTarget();
		return target;
	}

	@Override
	public int totalRag(RAG status) {
		return ragForNodes.totalRag(status);
	}

}