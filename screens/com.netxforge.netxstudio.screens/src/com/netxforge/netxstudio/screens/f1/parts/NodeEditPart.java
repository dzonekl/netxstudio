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
import com.netxforge.netxstudio.screens.f1.model.RFServiceToNode;

public class NodeEditPart extends AbstractEditPart {

	Label nameLabel = new Label();
	

	public NodeEditPart(Node node) {
		super.setModel(node);
		nameLabel.setText(node.getNodeID());
//		populateConnectionModel();
	}

	public Node getNode() {
		return (Node) super.getModel();
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
		Node model = this.getNode();
		nameLabel.setText(model.getNodeID());
		adaptLabelWidth(nameLabel);
		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this
				.getParent();
		parent.setLayoutConstraint(this, figure, this.getNode());
		figure.revalidate();
	}
	
	private final List<Object> modelTargetConnections = Lists
			.newArrayList();

	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelTargetConnections() {
		return modelTargetConnections;
	}

	public boolean addRFServiceToNodeTargetConnection(
			RFServiceToNodeEditPart part) {
		RFServiceToNode nttc = part.getRFSServiceToNode();
		if (!nttc.getTarget().equals(this.getNode())) {
			return false;
		}
		this.modelTargetConnections.add(nttc);
		int size = this.getTargetConnections().size();
		this.addTargetConnection(part, size);
		return true;
	}

	public boolean removeRFSServiceToNodeTargetConnection(
			RFServiceToNodeEditPart part) {
		if (!modelTargetConnections.remove(part.getModel())) {
			return false;
		}
		this.removeTargetConnection(part);
		return true;
	}
	
}
