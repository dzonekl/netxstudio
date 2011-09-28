package com.netxforge.netxstudio.screens.f1.parts;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.f1.model.RFSServiceToNode;
import com.netxforge.netxstudio.services.RFSService;

public class RFSServiceEditPart extends AbstractEditPart {

	Label nameLabel = new Label();

	public RFSServiceEditPart(RFSService service) {
		super.setModel(service);
		this.populateTransientModel();
	}

	public RFSService getRFSService() {
		return (RFSService) super.getModel();
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
		figure.setSize(50, 30);
		figure.setLineWidth(2);
		figure.setBackgroundColor(ColorConstants.lightGray);

		Rectangle copy = figure.getBounds().getCopy();
		figure.add(nameLabel);
		figure.setConstraint(nameLabel, new Rectangle(0, 0, copy.width,
				copy.height));

		return figure;
	}

	// @Override
	// protected void createEditPolicies() {
	// }

	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelSourceConnections() {
		return modelSourceConnections;
	}

	@Override
	protected void refreshVisuals() {

		RFSService nt = this.getRFSService();
		this.nameLabel.setText(nt.getServiceName());
		this.adaptLabelWidth(nameLabel);

		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this
				.getParent();
		IFigure figure = this.getFigure();
		parent.setLayoutConstraint(this, figure, this.getRFSService());
		figure.revalidate();
	}

	List<RFSServiceToNode> modelSourceConnections;

	private void populateTransientModel() {
		modelSourceConnections = Lists.newArrayList();
		RFSService service = (RFSService) this.getModel();

		for (Node node : service.getNodes()) {
			modelSourceConnections.add(new RFSServiceToNode(service, node));

		}
	}
}
