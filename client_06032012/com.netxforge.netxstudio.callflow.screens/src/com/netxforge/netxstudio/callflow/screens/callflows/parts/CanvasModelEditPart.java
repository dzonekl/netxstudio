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

import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.LayerConstants;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.callflow.screens.callflows.model.CanvasModel;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.services.ServiceFlow;
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
		connLayer.setConnectionRouter(new ShortestPathConnectionRouter(layer));
		// connLayer.setConnectionRouter(new ManhattanConnectionRouter());

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
			
			EList<ServiceFlowRelationship> serviceFlowRelationships = sf
					.getServiceFlowRelationships();
			result.addAll(serviceFlowRelationships);

		}

		return result;
	}

	/**
	 * Aggregate all the {@link NodeType node type } from the
	 * {@link ReferenceRelationship Reference relationships}
	 * 
	 * @param serviceFlow
	 * @return
	 */
	public List<Object> childrenFromParentModel(ServiceFlow serviceFlow) {

		List<Object> nodeTypes = Lists.newArrayList();

		for (ServiceFlowRelationship sfRelationship : serviceFlow
				.getServiceFlowRelationships()) {
			
			// Handle the case where a ServiceFlowRelationship is a reference between node types. 
			if(sfRelationship.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)){
				ReferenceRelationship referenceRelationship = sfRelationship
						.getReferenceRelationship();
				{
					NodeType nt = referenceRelationship.getRefInterface1Ref();
					if (nt != null && !nodeTypes.contains(nt)) {
						nodeTypes.add(nt);
					}
				}
				{
					NodeType nt = referenceRelationship.getRefInterface2Ref();
					if (nt != null && !nodeTypes.contains(nt)) {
						nodeTypes.add(nt);
					}
				}
			}
			// Handle the case where a ServiceFlowRelationship is a another ServiceFlow. 
			
		}
		return nodeTypes;
	}
}
