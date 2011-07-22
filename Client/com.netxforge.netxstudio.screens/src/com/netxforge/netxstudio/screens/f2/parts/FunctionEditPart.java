package com.netxforge.netxstudio.screens.f2.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

import com.netxforge.netxstudio.library.Function;

public class FunctionEditPart extends AbstractComponentEditPart {

	public FunctionEditPart(Function fc){
		super.setModel(fc);
	}
	
	public Function getFunction(){
		return (Function) super.getModel();
	}
	
	@Override
	protected IFigure createFigure() {
		RoundedRectangle figure = new RoundedRectangle(){
			@Override
			public Rectangle getClientArea(Rectangle rect) {
				return super.getClientArea(rect);
			}
		};
		figure.setSize(30,30);
		figure.setBackgroundColor(ColorConstants.cyan);
		return figure;
	}

	@Override
	protected void createEditPolicies() {

	}

}
