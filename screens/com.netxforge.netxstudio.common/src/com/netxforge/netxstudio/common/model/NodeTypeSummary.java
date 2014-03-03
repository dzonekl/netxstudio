/*******************************************************************************
 * Copyright (c) 31 jan. 2013 NetXForge.
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
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.RFSService;

/**
 * 
 * @author Christophe Bouhier
 */
public class NodeTypeSummary extends MonitoringAdapter {

	int functions = 0;
	int equipments = 0;
	int resources = 0;

	public NodeTypeSummary() {
	}

	@Override
	protected void computeForTarget(IProgressMonitor monitor) {

		clearComputation();

		RFSService rfsService = this.getRFSService();

		// Safely case, checked by our factory.
		final NodeType target = getNodeType();

		// Get the corresponding node.
		Node node = StudioUtils.nodeFor(target);

		// In case there is a Service, we get the components with a matching
		// node in the service and resource monitors, if not we get all underlying
		// components.

		List<Component> components = null;

		if (rfsService != null && node != null) {
			components = StudioUtils.componentsForMonitors(rfsService, node);
		}else{
			components = StudioUtils.componentsForNodeType(target);
		}

		if (!components.isEmpty()) {

			// Might throw an Exception.
			int work = components.size();

			final SubMonitor nodeTypeMonitor = SubMonitor
					.convert(monitor, work);
			nodeTypeMonitor.setTaskName("Computing summary for "
					+ StudioUtils.printModelObject(target));

			int computedComponents = 0;

			for (Component component : components) {

				if (monitor != null && monitor.isCanceled()) {
					System.out.println("Computation cancelled...");
					break;
				}

				ComponentSummary componentSummary = ComponentSummary
						.adaptAndCompute(nodeTypeMonitor, component,
								getContextObjects());
				if (componentSummary != null) {
					resources += componentSummary.totalResources();
					functions += componentSummary.totalFunctions();
					equipments += componentSummary.totalEquipments();

					if (componentSummary.isComputed()) {
						computedComponents++;
						// Base our RAG status, on the child's status
						// Could potentially keep the rag per
						// function/equipment.
						incrementRag(componentSummary.rag());
					}
				} else {
					System.out.println("SHOULD NOT OCCUR: child not adapted! "
							+ StudioUtils.printModelObject(component));
				}

				nodeTypeMonitor.worked(1);
			}

			if (computedComponents == components.size()) {
				computationState = ComputationState.COMPUTED;
			}
		}

	}

	@Override
	protected boolean isSameAdapterFor(EObject object) {
		return false; // Always produce new adapters.
	}

	@Override
	protected boolean isNotFiltered(EObject object) {
		// Self-adapt for contained hierarchy. (Note NetXResource is not
		// contained!).
		return object.eClass() == LibraryPackage.Literals.FUNCTION
				|| object.eClass() == LibraryPackage.Literals.EQUIPMENT;
	}

	@Override
	public void clearComputation() {
		super.clearComputation();
		resources = 0;
		equipments = 0;
		functions = 0;
	}

	public String getFunctionCountAsString() {
		return new Integer(functions).toString();
	}

	public String getEquipmentCountAsString() {
		return new Integer(equipments).toString();
	}

	public String getResourCountAsString() {
		return new Integer(resources).toString();
	}

	public int totalFunctions() {
		return functions;
	}

	public int totalEquipments() {
		return equipments;
	}

	public int totalResources() {
		return resources;
	}

	public NodeType getNodeType() {
		final NodeType target = (NodeType) super.getTarget();
		return target;
	}

	/**
	 * The markers for all resources in the target {@link Node}
	 * 
	 * @return
	 */
	public Map<NetXResource, List<Marker>> markers() {
		throw new UnsupportedOperationException("TODO");
	}

}