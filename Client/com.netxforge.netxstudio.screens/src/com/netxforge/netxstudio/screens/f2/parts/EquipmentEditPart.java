package com.netxforge.netxstudio.screens.f2.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.Equipment;

public class EquipmentEditPart extends AbstractComponentEditPart {

	public EquipmentEditPart(Equipment eq){
		super.setModel(eq);
	}
	
	public Equipment getFunction(){
		return (Equipment) super.getModel();
	}
	
	@Override
	protected IFigure createFigure() {
		RoundedRectangle figure = new RoundedRectangle(){
			@Override
			public Rectangle getClientArea(Rectangle rect) {
				return super.getClientArea(rect);
			}
		};
		figure.setSize(50,50);
		return figure;
	}

	@Override
	protected void createEditPolicies() {

	}

	@Override
	protected List<Object> getModelChildren() {
		Equipment eq = (Equipment) this.getModel();
		List<Object> result = Lists.newArrayList();
		result.addAll(eq.getEquipments());
		return result;
	}

}
