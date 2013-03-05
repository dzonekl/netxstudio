package com.netxforge.netxstudio.screens.f1.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.f1.model.RFSServiceToNode;
import com.netxforge.netxstudio.screens.f1.model.WrappedRFSService;
import com.netxforge.netxstudio.services.RFSService;

public class ServiceEditPartFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof WrappedRFSService){
			return new CanvasEditPart((WrappedRFSService) model);
		}
		if(model instanceof RFSService){
			return new RFSServiceEditPart((RFSService) model);
		}
		if(model instanceof Node){
			return new NodeEditPart((Node) model);
		}
		
//		if(model instanceof Equipment){
//			return new EquipmentEditPart((Equipment) model);
//		}
//		if(model instanceof NodeTypeToComponent){
//			return new NodeTypeToComponentEditPart((NodeTypeToComponent) model);
//		}
		if(model instanceof RFSServiceToNode){
			return new RFSServiceToNodeEditPart((RFSServiceToNode) model);
		}
		throw new IllegalStateException("Can't create requested edit part");
	}
}
