package com.netxforge.netxstudio.screens.f2.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.netxforge.netxstudio.library.NodeType;

public class NodeTypeEditPartsFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof NodeType){
			return new NodeTypeEditPart((NodeType) model);
		}
		throw new IllegalStateException("Can't create requested edit part");
	}
}
