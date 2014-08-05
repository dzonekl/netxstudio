/*******************************************************************************
 * Copyright (c) 11 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.f1.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.f1.model.RFServiceToNode;
import com.netxforge.netxstudio.screens.f1.model.RFServiceToRFService;
import com.netxforge.netxstudio.screens.f1.model.WrappedRFSService;
import com.netxforge.netxstudio.services.RFSService;

public class ServiceEditPartFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof WrappedRFSService) {
			return new CanvasEditPart((WrappedRFSService) model);
		} else if (model instanceof RFSService) {
			return new RFServiceEditPart((RFSService) model);
		} else if (model instanceof Node) {
			return new NodeEditPart((Node) model);
		} else if (model instanceof RFServiceToNode) {
			return new RFServiceToNodeEditPart((RFServiceToNode) model);
		} else if (model instanceof RFServiceToRFService) {
			return new RFServiceToRFServiceEditPart(
					(RFServiceToRFService) model);
		}
		throw new IllegalStateException("Can't create requested edit part");
	}
}
