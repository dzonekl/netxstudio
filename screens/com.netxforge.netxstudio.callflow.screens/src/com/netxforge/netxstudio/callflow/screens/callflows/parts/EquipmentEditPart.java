package com.netxforge.netxstudio.callflow.screens.callflows.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.netxforge.netxstudio.library.Equipment;

public class EquipmentEditPart extends AbstractComponentEditPart {
	

	Label codeLabel = new Label();
	
	public EquipmentEditPart(Equipment eq){
		super.setModel(eq);
		super.populateConnectionModel();
	}
	
	public Equipment getEquipment(){
		return (Equipment) super.getModel();
	}
	
	@Override
	protected IFigure createFigure() {
		RoundedRectangle figure = new RoundedRectangle(){
			@Override
			public Rectangle getClientArea(Rectangle rect) {
				Rectangle clientArea = super.getClientArea(rect);
				clientArea.shrink(CLIENT_AREA_INSETS);
				return clientArea;
			}
		};
		FlowLayout fl = new FlowLayout();
		fl.setHorizontal(false);
		fl.setMajorAlignment(FlowLayout.ALIGN_CENTER);
		fl.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		figure.setLayoutManager(fl);
		figure.setSize(50,30);
		figure.setBackgroundColor(ColorConstants.lightGreen);
		figure.setLineWidth(2);
		Rectangle copy = figure.getBounds().getCopy();
		figure.add(codeLabel);
		figure.setConstraint(codeLabel, new Rectangle(0,0, copy.width, copy.height));
		return figure;
	}
	
	@Override
	protected void createEditPolicies() {

	}
	
	@Override
	protected void refreshVisuals() {
		Equipment model = getEquipment();
		codeLabel.setText(model.getEquipmentCode());
		
		this.adaptLabelWidth(codeLabel);
		
		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this.getParent();
		parent.setLayoutConstraint(this, figure, model);
		this.getFigure().revalidate();
	}


}
