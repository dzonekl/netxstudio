/*******************************************************************************
 * Copyright (c) 24 apr. 2013 NetXForge.
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
package com.netxforge.netxstudio.callflow.screens.callflows.parts;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.LayerConstants;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netxforge.netxstudio.callflow.screens.callflows.model.CanvasModel;
import com.netxforge.netxstudio.callflow.screens.callflows.model.NodeTypeToServiceRelationships;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.services.ServiceFlow;
import com.netxforge.netxstudio.services.ServiceFlowDirection;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * A Canvas model edit part for {@link ServiceFlow service flows}. The children
 * are
 * 
 * @link {@link ServiceFlowRelationShips}
 * 
 * 
 * @author Christophe
 */
public class CanvasModelEditPart extends AbstractLibraryEditPart {

	public CanvasModelEditPart(CanvasModel model) {
		this.setModel(model);
	}

	@Override
	protected IFigure createFigure() {
		//
		// IFigure container = new Figure();
		FreeformLayer layer = new FreeformLayer();

		// CHOICE 1. Layout is grid layout, the constraint with grid data is set
		// in "refresh visuals of the child edit part"/
		// Note: The grid layout fills up the grid and wraps to a new row, when
		// "numcolumns is exceeded.

		// GridLayout gridLayout = new GridLayout();
		// gridLayout.numColumns = 4;
		// gridLayout.makeColumnsEqualWidth = true;
		// layer.setLayoutManager(gridLayout);

		// CHOICE 2. Layout is freeform, the constraint is set in
		// "refresh visuals of the child edit part"/
		layer.setLayoutManager(new CallFlowNodeTypeLayout());

		// Create the static router for the connection layer
		ConnectionLayer connLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		// connLayer.setConnectionRouter(new
		// ShortestPathConnectionRouter(layer));
		connLayer.setConnectionRouter(ConnectionRouter.NULL);

		return layer;
	}

	@Override
	protected void createEditPolicies() {
	}

	@Override
	protected List<Object> getModelChildren() {
		List<Object> result = Lists.newArrayList();
		Object model = this.getModel();

		if (model instanceof CanvasModel
				&& ((CanvasModel) model).getRoot() instanceof ServiceFlow) {

			// Add the Service Flow, which are the actual relationships.
			ServiceFlow sf = (ServiceFlow) ((CanvasModel) model).getRoot();

			// Add the NodeTypes as these will play a role in the
			result.addAll(childrenFromParentModel(sf));

			// EList<ServiceFlowRelationship> serviceFlowRelationships = sf
			// .getServiceFlowRelationships();
			// result.addAll(serviceFlowRelationships);

		}

		return result;
	}

	/**
	 * Re-model.
	 * 
	 * @param serviceFlow
	 * @return
	 */
	public Collection<NodeTypeToServiceRelationships> childrenFromParentModel(
			ServiceFlow serviceFlow) {

		// List<Object> nodeTypeToServiceRelationships = Lists.newArrayList();
		Map<NodeType, NodeTypeToServiceRelationships> nodeTypeToRelationships = Maps
				.newLinkedHashMap();

		for (ServiceFlowRelationship sfr : serviceFlow
				.getServiceFlowRelationships()) {

			// Handle the case where a ServiceFlowRelationship is a reference
			// between node types, set as a source connection with a specialized
			// model depending the flow direction. s
			if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
				ReferenceRelationship rr = sfr.getReferenceRelationship();

				NodeType nt1 = rr.getRefInterface1Ref();
				NodeType nt2 = rr.getRefInterface2Ref();
				List<ServiceFlowRelationship> sfrsNT1;
				List<ServiceFlowRelationship> sfrsNT2;

				if (nt1 != null && !nodeTypeToRelationships.containsKey(nt1)) {
					sfrsNT1 = Lists.newArrayList();
					NodeTypeToServiceRelationships nodeTypeToServiceRelationships = new NodeTypeToServiceRelationships(
							serviceFlow, nt1, sfrsNT1);
					nodeTypeToRelationships.put(nt1,
							nodeTypeToServiceRelationships);
				} else {
					sfrsNT1 = nodeTypeToRelationships.get(nt1).getTarget();
				}
				if (nt2 != null && !nodeTypeToRelationships.containsKey(nt2)) {
					sfrsNT2 = Lists.newArrayList();
					NodeTypeToServiceRelationships nodeTypeToServiceRelationships = new NodeTypeToServiceRelationships(
							serviceFlow, nt2, sfrsNT2);
					nodeTypeToRelationships.put(nt2,
							nodeTypeToServiceRelationships);
				} else {
					sfrsNT2 = nodeTypeToRelationships.get(nt2).getTarget();
				}

				if (sfr.getDirection() == ServiceFlowDirection.LEFTTORIGHT) {
					sfrsNT1.add(0, sfr);
				} else {
					sfrsNT2.add(0, sfr);
				}
			}
			// Handle the case where a ServiceFlowRelationship is a another
			// ServiceFlow.

		}
		// List<NodeTypeToServiceRelationships> asList = Lists
		// .newArrayList(nodeTypeToRelationships.values());
		// return Lists.newArrayList(Iterables.reverse(asList));
		return nodeTypeToRelationships.values();
	}
}
