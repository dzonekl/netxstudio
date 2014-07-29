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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.netxforge.netxstudio.callflow.screens.callflows.model.CanvasModel;
import com.netxforge.netxstudio.callflow.screens.callflows.model.NodeTypeToServiceRelationships;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;

/**
 * A GEF Factory for Edit Parts in the Call flow diagram
 * 
 * @author Christophe Bouhier
 */
public class CallflowEditPartsFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof CanvasModel) {
			System.out.println("FACTORY =>  edit part for model: "
					+ ((CanvasModel) model).getRoot().toString());
			return new CanvasModelEditPart((CanvasModel) model);
		}
		if (model instanceof ServiceFlowRelationship) {
			ServiceFlowRelationship sfr = (ServiceFlowRelationship) model;
			System.out.println("FACTORY =>  ServiceFlowRel. "
					+ sfr.getProtocol().getName() + ":"
					+ sfr.getMessage().getName() + " from: " + sfr.getDirection());
			return new ServiceFlowRelationshipEditPart(
					(ServiceFlowRelationship) model);
		}
		if (model instanceof NodeTypeToServiceRelationships) {
			System.out.println("FACTORY =>  edit part for model: " + model);
			return new NodeTypeEditPart((NodeTypeToServiceRelationships) model);
		}
		throw new IllegalStateException("Can't create requested edit part");
	}
}
