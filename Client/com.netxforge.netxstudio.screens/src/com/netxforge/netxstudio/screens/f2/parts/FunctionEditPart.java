package com.netxforge.netxstudio.screens.f2.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.netxforge.netxstudio.library.Function;

public class FunctionEditPart extends AbstractComponentEditPart {

	Label nameLabel = new Label();
	

	public FunctionEditPart(Function fc) {
		super.setModel(fc);
		nameLabel.setText(fc.getName());
		populateConnectionModel();
	}

	public Function getFunction() {
		return (Function) super.getModel();
	}

	@Override
	protected IFigure createFigure() {
		RoundedRectangle figure = new RoundedRectangle() {
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
		figure.setLineWidth(2);
		figure.setSize(50, 30);
		figure.setForegroundColor(ColorConstants.darkGray);
		figure.setBackgroundColor(ColorConstants.lightBlue);
		figure.add(nameLabel);
//		Rectangle copy = nameLabel.getBounds().getCopy();
//		figure.setConstraint(nameLabel, new Rectangle(0, 0, copy.width,
//				copy.height));
		return figure;
	}

	@Override
	protected void createEditPolicies() {
	}

	@Override
	protected void refreshVisuals() {
		Function model = this.getFunction();
		nameLabel.setText(model.getName());
		adaptLabelWidth(nameLabel);
		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this
				.getParent();
		parent.setLayoutConstraint(this, figure, this.getFunction());
		figure.revalidate();
	}
}
