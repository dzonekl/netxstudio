package com.netxforge.netxstudio.screens.f2.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.netxforge.netxstudio.library.NodeType;

public class NodeTypeEditPart extends AbstractGraphicalEditPart {

	public NodeTypeEditPart(NodeType nt){
		super.setModel(nt);
	}
	
	public NodeType getNodeType(){
		return (NodeType) super.getModel();
	}
	
	@Override
	protected IFigure createFigure() {
		RoundedRectangle figure = new RoundedRectangle(){
			@Override
			public Rectangle getClientArea(Rectangle rect) {
				// TODO Auto-generated method stub
				return super.getClientArea(rect);
			}
		};
		figure.setSize(50,50);
		return figure;
	}

	@Override
	protected void createEditPolicies() {

	}

}
