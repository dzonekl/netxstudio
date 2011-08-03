package com.netxforge.netxstudio.screens.f2.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.netxforge.netxstudio.library.Function;

public class FunctionEditPart extends AbstractComponentEditPart {

	Label nameLabel = new Label();

	public FunctionEditPart(Function fc) {
		super.setModel(fc);
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
				return super.getClientArea(rect);
			}
		};
		figure.setLayoutManager(new XYLayout());
		figure.setLineWidth(2);
		figure.setSize(50, 50);
		figure.setForegroundColor(ColorConstants.darkGray);
		Rectangle copy = figure.getBounds().getCopy();
		figure.setBackgroundColor(ColorConstants.lightBlue);
		figure.add(nameLabel);
		figure.setConstraint(nameLabel, new Rectangle(0, 0, copy.width,
				copy.height));
		// figure.setConstraint(this, new Rectangle(0,0, copy.width,
		// copy.height));
		return figure;
	}

	@Override
	protected void createEditPolicies() {

	}

	@Override
	protected void refreshVisuals() {
		Function model = this.getFunction();
		nameLabel.setText(model.getName());
		IFigure figure = this.getFigure();

		// Adapt the figures bounds to the text bound width at least.
		Rectangle textBounds = nameLabel.getTextBounds();
		if (textBounds.width > figure.getBounds().width) {
			figure.getBounds().setWidth(textBounds.width);
			figure.setConstraint(nameLabel, new Rectangle(0, 0, figure.getBounds().width,
					figure.getBounds().height));
		}
		
		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this
				.getParent();

		parent.setLayoutConstraint(this, figure, this.getFunction());
		figure.revalidate();
	}

}
