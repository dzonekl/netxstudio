package com.netxforge.netxstudio.screens.f1.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class AbstractEditPart extends AbstractGraphicalEditPart {

	protected final Insets CLIENT_AREA_INSETS = new Insets(5, 5, 5, 5);
	
	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected void createEditPolicies() {

	}
	
	public boolean addRFSServiceToNodeTargetConnection(RFSServiceToNodeEditPart part){
		return false;
	}
	
	public boolean removeRFSServiceToNodeTargetConnection(RFSServiceToNodeEditPart part){
		return false;
	}

//	public boolean addComponentToComponentTargetConnection(
//			ComponentToComponentEditPart componentToComponentEditPart) {
//		return false;
//	}
//
//	public boolean removeComponentToComponentTargetConnection(
//			ComponentToComponentEditPart componentToComponentEditPart) {
//		return false;
//	}
//	
	protected void adaptLabelWidth(Label nameLabel) {
		// Adapt the figures bounds to the text bound width at least.
		Rectangle textBounds = nameLabel.getTextBounds();
		if (textBounds.width > figure.getBounds().width - (CLIENT_AREA_INSETS.left + CLIENT_AREA_INSETS.right) ) {
			int newWidth = CLIENT_AREA_INSETS.left + CLIENT_AREA_INSETS.right
					+ textBounds.width; // 5 for luck! 

			figure.getBounds().setWidth(newWidth);
			figure.setConstraint(
					nameLabel,
					new Rectangle(0, 0, figure.getBounds().width, figure
							.getBounds().height));
		}
	}
	
	

}
