package com.netxforge.netxstudio.screens.f2.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class AbstractLibraryEditPart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected void createEditPolicies() {

	}
	
	public boolean addNodeTypeToComponentTargetConnection(NodeTypeToComponentEditPart part){
		return false;
	}
	
	public boolean removeNodeTypeToComponentTargetConnection(NodeTypeToComponentEditPart part){
		return false;
	}

}
