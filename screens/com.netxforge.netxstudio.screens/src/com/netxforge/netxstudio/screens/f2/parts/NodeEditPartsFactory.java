package com.netxforge.netxstudio.screens.f2.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.f2.model.ComponentToComponent;
import com.netxforge.netxstudio.screens.f2.model.NodeTypeToComponent;
import com.netxforge.netxstudio.screens.f2.model.WrappedNode;

public class NodeEditPartsFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof WrappedNode){
			return new WrappedNodeEditPart((WrappedNode) model);
		}
		if(model instanceof Node){
			return new NodeEditPart((Node) model);
		}
		if(model instanceof NodeType){
			return new NodeTypeEditPart((NodeType) model);
		}
		if(model instanceof Function){
			return new FunctionEditPart((Function) model);
		}
		if(model instanceof Equipment){
			return new EquipmentEditPart((Equipment) model);
		}
		if(model instanceof NodeTypeToComponent){
			return new NodeTypeToComponentEditPart((NodeTypeToComponent) model);
		}
		if(model instanceof ComponentToComponent){
			return new ComponentToComponentEditPart((ComponentToComponent) model);
		}
		throw new IllegalStateException("Can't create requested edit part");
	}
}
