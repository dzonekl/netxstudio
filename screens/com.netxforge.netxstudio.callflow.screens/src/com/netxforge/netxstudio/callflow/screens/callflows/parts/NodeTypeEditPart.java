/*******************************************************************************
 * Copyright (c) 27 apr. 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.callflow.screens.callflows.parts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Panel;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.callflow.screens.callflows.model.NodeTypeToServiceRelationships;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.services.ServiceFlow;
import com.netxforge.netxstudio.services.ServiceFlowDirection;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * @author Christophe Bouhier
 */
public class NodeTypeEditPart extends AbstractLibraryEditPart {

	private static final int NODETYPE_HEIGHT = 600;
	Label nameLabel = new Label();

	public NodeTypeEditPart(NodeTypeToServiceRelationships nt) {
		super.setModel(nt);
		this.populateTransientModel();
	}

	public NodeType getNodeType() {
		NodeTypeToServiceRelationships model = (NodeTypeToServiceRelationships) this
				.getModel();
		return model.getSource();
		// return (NodeType) super.getModel();
	}

	public ServiceFlow getServiceFlow() {
		NodeTypeToServiceRelationships model = (NodeTypeToServiceRelationships) this
				.getModel();
		return model.getParent();
		// return (NodeType) super.getModel();
	}

	@Override
	protected IFigure createFigure() {

		if (super.figure == null) {

			// Consists of a transparent parent figure
			Panel delegationBounds = new Panel();
			delegationBounds.setOpaque(false);
			delegationBounds.setLayoutManager(new DelegatingLayout());
			delegationBounds.setSize(60, 640);

			RoundedRectangle nodeTypeCalledFigure = new RoundedRectangle() {
				@Override
				public Rectangle getClientArea(Rectangle rect) {
					Rectangle clientArea = super.getClientArea(rect);
					clientArea.shrink(CLIENT_AREA_INSETS);
					return clientArea;
				}
			};
			// We want a nodetype which represents the length.
			nodeTypeCalledFigure.setSize(4, NODETYPE_HEIGHT);
			nodeTypeCalledFigure.setLineWidth(1);
			nodeTypeCalledFigure.setBackgroundColor(ColorConstants.darkGreen);

			delegationBounds.add(nodeTypeCalledFigure, new RelativeLocator(
					delegationBounds, 0.5, 0.5));

			nameLabel.setOpaque(true);
			nameLabel.setBackgroundColor(ColorConstants.buttonLightest);
			nameLabel.setBorder(new LineBorder());

			// Rectangle copy = figure.getBounds().getCopy();

			// figure.setConstraint(nameLabel, new Rectangle(0, 0, copy.width,
			// copy.height));

			delegationBounds.add(nameLabel, new FixedOutboundLocator(
					nodeTypeCalledFigure, 0.0, 0.0));
			super.figure = delegationBounds;
		}
		return super.figure;
	}

	Map<String, CallFlowConnectionAnchor> sourceConnectionAnchors = new HashMap<String, CallFlowConnectionAnchor>();

	protected void updateSourceConnectionAnchors(IFigure nodeTypeFigure) {

		System.out.println("ANCHOR => Updating source Connection Anchors: "
				+ this.getNodeType().getName());

		// Reset our anchors when updating.
		sourceConnectionAnchors.clear();

		if (modelSourceConnections.isEmpty()) {
			return;
		}

		int offset = -1;

		for (ServiceFlowRelationship sfr : modelSourceConnections) {
			// Calculate the the total number of relationships and use as anchor
			// vertical offset
			// for each relationship.

			if (offset == -1) {
				int serviceFlowRelationshipsSize = getServiceFlow()
						.getServiceFlowRelationships().size();
				offset = NODETYPE_HEIGHT / (serviceFlowRelationshipsSize + 1);
			}

			// find out the target.
			if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
				CallFlowConnectionAnchor callFlowConnectionAnchor = new CallFlowConnectionAnchor(
						nodeTypeFigure);
				int index = getServiceFlow().getServiceFlowRelationships()
						.indexOf(sfr);
				callFlowConnectionAnchor.offsetV = (index + 1) * offset;

				NodeType target = this.getTarget(sfr);
				if (target != null) {
					String targetSymbol = target.getName();
					System.out
							.println("ANCHOR => Adding Source anchor with symbol: "
									+ targetSymbol
									+ " anchor: "
									+ callFlowConnectionAnchor);
					setRightConnectionAnchor(targetSymbol,
							callFlowConnectionAnchor);
				}
			}
		}
	}

	Map<String, CallFlowConnectionAnchor> targetConnectionAnchors = new HashMap<String, CallFlowConnectionAnchor>();

	/**
	 * Although we update all target (Also the previously requested ones, a
	 * reconfiguration of targets).
	 * 
	 * @param nodeTypeFigure
	 */
	protected void addTargetConnectionAnchors(IFigure nodeTypeFigure,
			ServiceFlowRelationship sfr, ConnectionAnchor sourceAnchor) {

		System.out.println("ANCHOR => Add target Connection Anchors");

		// Reset our anchors when updating.
		// targetConnectionAnchors.clear();

		// int offset = NODETYPE_HEIGHT / modelTargetConnections.size();
		// for (ServiceFlowRelationship sfr : modelTargetConnections) {

		// int index = modelTargetConnections.indexOf(sfr);
		// find out the target.
		if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
			CallFlowConnectionAnchor callFlowConnectionAnchor = new CallFlowConnectionAnchor(
					nodeTypeFigure);
			// Height should be the same as the source anchor.
			if (sourceAnchor instanceof CallFlowConnectionAnchor) {
				callFlowConnectionAnchor.offsetV = ((CallFlowConnectionAnchor) sourceAnchor).offsetV;
			}

			NodeType target = this.getSource(sfr);
			if (target != null) {
				String targetSymbol = target.getName();
				System.out
						.println("ANCHOR => Adding Target anchor with symbol: "
								+ targetSymbol + " anchor: "
								+ callFlowConnectionAnchor);
				setLeftConnectionAnchor(targetSymbol, callFlowConnectionAnchor);
			}
			// }
		}
	}

	public void setLeftConnectionAnchor(String targetSymbol,
			CallFlowConnectionAnchor c) {
		targetConnectionAnchors.put(targetSymbol, c);
	}

	public void setRightConnectionAnchor(String targetSymbol,
			CallFlowConnectionAnchor c) {
		sourceConnectionAnchors.put(targetSymbol, c);
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {

		if (connection instanceof ServiceFlowRelationshipEditPart) {
			ServiceFlowRelationship sfr = (ServiceFlowRelationship) connection
					.getModel();
			System.out.println("ANCHOR => Requesting source anchor for "
					+ connection.toString() + " on "
					+ this.getNodeType().getName());
			// determine if the request is for left or right.
			NodeType target = this.getTarget(sfr);
			if (target != null) {
				CallFlowConnectionAnchor callFlowConnectionAnchor = sourceConnectionAnchors
						.get(target.getName());
				System.out.println("ANCHOR => Resolved anchor for target: "
						+ target.getName() + " with: "
						+ callFlowConnectionAnchor);
				return callFlowConnectionAnchor;
			}
		}
		return super.getSourceConnectionAnchor(connection);
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {

		if (connection instanceof ServiceFlowRelationshipEditPart) {
			ServiceFlowRelationship sfr = (ServiceFlowRelationship) connection
					.getModel();
			System.out.println("ANCHOR => Requesting target anchor for "
					+ connection.toString() + " on "
					+ this.getNodeType().getName());
			// determine if the request is for left or right.
			NodeType target = this.getSource(sfr);
			if (target != null) {
				CallFlowConnectionAnchor callFlowConnectionAnchor = targetConnectionAnchors
						.get(target.getName());
				System.out.println("ANCHOR => Resolved anchor for target: "
						+ target.getName() + " with: "
						+ callFlowConnectionAnchor);
				return callFlowConnectionAnchor;
			} else {
				System.err
						.println("ANCHOR => Error, there should be a target anchor!");
			}
		}

		return super.getTargetConnectionAnchor(connection);
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
		nameLabel.setSize(new Dimension(100, 20));
		// this.adaptLabelWidth(nameLabel);

		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this
				.getParent();
		IFigure figure = this.getFigure();
		parent.setLayoutConstraint(this, figure, this.getNodeType());
		// figure.revalidate();
	}

	List<ServiceFlowRelationship> modelSourceConnections;

	private void populateTransientModel() {
		NodeTypeToServiceRelationships model = (NodeTypeToServiceRelationships) getModel();
		modelSourceConnections = model.getTarget();
		updateSourceConnectionAnchors(this.getFigure());
	}

	private final List<ServiceFlowRelationship> modelTargetConnections = Lists
			.newArrayList();

	@Override
	public boolean addNodeTypeToNodeTypeTargetConnection(
			ServiceFlowRelationshipEditPart serviceFlowRelationshipEditPart) {
		ServiceFlowRelationship sfr = serviceFlowRelationshipEditPart
				.getServiceFlowRelationship();

		if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
			ReferenceRelationship rr = ((ServiceFlowRelationship) sfr)
					.getReferenceRelationship();

			NodeType ref1 = rr.getRefInterface1Ref();
			NodeType ref2 = rr.getRefInterface2Ref();
			if (!ref1.equals(getNodeType()) && !ref2.equals(getNodeType())) {
				System.out.println("CONNECTION => Deny target connection "
						+ this.getNodeType().getName() + "  ( from "
						+ ref1.getName() + " to " + ref2.getName() + ")");
				return false;
			}

			if (!modelTargetConnections.contains(sfr)) {
				// Grant if we are the target, minding the direction.
				if ((ref1 == this.getNodeType() && sfr.getDirection() == ServiceFlowDirection.RIGHTTOLEFT)
						|| (ref2 == this.getNodeType() && sfr.getDirection() == ServiceFlowDirection.LEFTTORIGHT)) {

					System.out
							.println("CONNECTION => Grant target connection to "
									+ this.getNodeType().getName()
									+ "  ( from "
									+ ref1.getName()
									+ " to "
									+ ref2.getName() + ")");
					this.modelTargetConnections.add(sfr);
					ConnectionAnchor sourceAnchor = serviceFlowRelationshipEditPart
							.getConnectionFigure().getSourceAnchor();
					addTargetConnectionAnchors(this.getFigure(), sfr,
							sourceAnchor);
					this.addTargetConnection(serviceFlowRelationshipEditPart, 0);
					return true;
				}
			}
			System.out
					.println("CONNECTION => Deny duplicate target connection "
							+ this.getNodeType().getName() + "  ( from "
							+ ref1.getName() + " to " + ref2.getName() + ")");
			return false;

		} else {
			if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW)) {
				System.out
						.println("CONNECTION => Deny target connection "
								+ this.getNodeType().getName()
								+ " the relaship is not a Reference Relationship, but a Service Flow"
								+ sfr.getServiceFlow().getName());
				return false;
			} else {
				return false;
			}
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
			if (!modelTargetConnections.remove(sfr)) {
				return false;
			}
			System.out.println("Request to remove a target connection"
					+ rr.getName());
			this.removeTargetConnection(sfr);
			return true;
		}
		return false;
	}

	public NodeType getTarget(ServiceFlowRelationship sfr) {
		if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
			ReferenceRelationship rr = sfr.getReferenceRelationship();
			if (rr.getRefInterface1Ref() == this.getNodeType()) {
				if (sfr.getDirection() == ServiceFlowDirection.LEFTTORIGHT) {
					return rr.getRefInterface2Ref();
				}
			}
			if (rr.getRefInterface2Ref() == this.getNodeType()) {
				if (sfr.getDirection() == ServiceFlowDirection.RIGHTTOLEFT) {
					return rr.getRefInterface1Ref();
				}
			}
		}
		return null;
	}

	public NodeType getSource(ServiceFlowRelationship sfr) {
		if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
			ReferenceRelationship rr = sfr.getReferenceRelationship();
			if (rr.getRefInterface1Ref() == this.getNodeType()) {
				if (sfr.getDirection() == ServiceFlowDirection.RIGHTTOLEFT) {
					return rr.getRefInterface2Ref();
				}
			}
			if (rr.getRefInterface2Ref() == this.getNodeType()) {
				if (sfr.getDirection() == ServiceFlowDirection.LEFTTORIGHT) {
					return rr.getRefInterface1Ref();
				}
			}
		}
		return null;
	}

}
