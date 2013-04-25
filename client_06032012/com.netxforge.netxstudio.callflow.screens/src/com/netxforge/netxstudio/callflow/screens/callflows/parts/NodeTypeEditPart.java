package com.netxforge.netxstudio.callflow.screens.callflows.parts;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.callflow.screens.callflows.model.NodeTypeToComponent;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesPackage;

public class NodeTypeEditPart extends AbstractLibraryEditPart {

	Label nameLabel = new Label();

	public NodeTypeEditPart(NodeType nt) {
		super.setModel(nt);

		// this.populateTransientModel();
	}

	public NodeType getNodeType() {
		return (NodeType) super.getModel();
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

		// We want a nodetype which represents the length.
		figure.setSize(4, 400);
		figure.setLineWidth(1);
		figure.setBackgroundColor(ColorConstants.lightGray);

		Rectangle copy = figure.getBounds().getCopy();
		figure.add(nameLabel);
		figure.setConstraint(nameLabel, new Rectangle(0, 0, copy.width,
				copy.height));

		return figure;
	}

	@Override
	protected void createEditPolicies() {

	}

	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelSourceConnections() {
		return modelSourceConnections;
	}

	@Override
	protected void refreshVisuals() {

		NodeType nt = this.getNodeType();
		this.nameLabel.setText(nt.getName());
		this.adaptLabelWidth(nameLabel);

		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this
				.getParent();
		IFigure figure = this.getFigure();
		parent.setLayoutConstraint(this, figure, this.getNodeType());
		figure.revalidate();
	}

	List<NodeTypeToComponent> modelSourceConnections;

	// private void populateTransientModel() {
	// modelSourceConnections = Lists.newArrayList();
	// NodeType nt = (NodeType) this.getModel();
	//
	// List<EObject> it = nt.eContents();
	// for (EObject o : it) {
	// if (o instanceof Component) {
	// modelSourceConnections.add(new NodeTypeToComponent(nt,
	// (Component) o));
	// }
	//
	// }
	// }

	private final List<ReferenceRelationship> modelTargetConnections = Lists
			.newArrayList();

	@Override
	public boolean addNodeTypeToNodeTypeTargetConnection(
			ServiceFlowRelationshipEditPart serviceFlowRelationshipEditPart) {
		Object sfr = serviceFlowRelationshipEditPart.getModel();
		if (sfr instanceof ServiceFlowRelationship
				&& ((ServiceFlowRelationship) sfr)
						.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
			ReferenceRelationship rr = ((ServiceFlowRelationship) sfr)
					.getReferenceRelationship();
			if (!rr.getRefInterface2Ref().equals(this.getNodeType())) {
				System.out
						.println("Deny request to add a target connection to "
								+ this.getNodeType().getName()
								+ " for Ref Relationship" + rr.getName());
				return false;
			}
			System.out.println("Grant request to add a target connection to "
					+ this.getNodeType().getName() + " for Ref Relationship"
					+ rr.getName());
			this.modelTargetConnections.add(rr);

			// The index should be according to the
			this.addTargetConnection(serviceFlowRelationshipEditPart, 0);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeNodeTypeToNodeTypeTargetConnection(
			ServiceFlowRelationshipEditPart sfr) {
		if (sfr instanceof ServiceFlowRelationship
				&& ((ServiceFlowRelationship) sfr)
						.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
			ReferenceRelationship rr = ((ServiceFlowRelationship) sfr)
					.getReferenceRelationship();
			if (!modelTargetConnections.remove(rr)) {
				return false;
			}
			System.out.println("Request to remove a target connection" + rr.getName());
			this.removeTargetConnection(sfr);
			return true;
		}
		return false;
	}
}
