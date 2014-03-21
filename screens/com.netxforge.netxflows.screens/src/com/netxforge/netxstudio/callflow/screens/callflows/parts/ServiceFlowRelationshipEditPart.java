/*******************************************************************************
 * Copyright (c) 24 apr. 2013 NetXForge.
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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MidpointLocator;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.swt.SWT;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.protocols.Message;
import com.netxforge.netxstudio.services.ServiceFlow;
import com.netxforge.netxstudio.services.ServiceFlowDirection;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Adds the
 * 
 * @author Christophe Bouhier
 */
public class ServiceFlowRelationshipEditPart extends AbstractConnectionEditPart {

	public ServiceFlowRelationshipEditPart(ServiceFlowRelationship sfr) {
		this.setModel(sfr);
	}

	@Override
	protected void createEditPolicies() {
	}

	/**
	 * Add a decoration matching the flow relationship.
	 */
	@Override
	protected IFigure createFigure() {
		PolylineConnection connection = new PolylineConnection();
		connection.setLineStyle(SWT.LINE_DASH);
		connection.setLineCap(SWT.CAP_ROUND);

		ServiceFlowRelationship serviceFlowRelationship = this
				.getServiceFlowRelationship();
		String name = "";
		if (serviceFlowRelationship
				.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__MESSAGE)) {
			Message message = serviceFlowRelationship.getMessage();
			name = message.getName();
		} else {

			if (serviceFlowRelationship
					.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
				ReferenceRelationship rr = this.getServiceFlowRelationship()
						.getReferenceRelationship();

				// Set a target decoration (Arrow), as we are organized by
				// targets.
				connection.setTargetDecoration(new PolygonDecoration());

				if (rr.eIsSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__PROTOCOL_REF)) {
					name = rr.getProtocolRef().getName();
				}

			}
		}
		Label label = new Label(name);
		label.setOpaque(true);
		label.setBackgroundColor(ColorConstants.tooltipBackground);
		label.setBorder(new LineBorder());
		// Add the label to the connection, with the Locator as a
		// constraint.
		connection.add(label, new MidpointLocator(connection, 1));

		return connection;
	}

	public void activate() {
		super.activate();
		final EditPart manager = (EditPart) this.getParent().getChildren()
				.get(0);
		for (Object child : manager.getChildren()) {
			AbstractLibraryEditPart part = (AbstractLibraryEditPart) child;
			if (part.addNodeTypeToNodeTypeTargetConnection(this)) {
				return; // Target found... no need for a listener.
			}
		}

		manager.addEditPartListener(new EditPartListener.Stub() {

			@Override
			public void childAdded(EditPart child, int index) {

				AbstractLibraryEditPart part = (AbstractLibraryEditPart) child;
				if (part.addNodeTypeToNodeTypeTargetConnection(ServiceFlowRelationshipEditPart.this)) {
					manager.removeEditPartListener(this);
				}
			}
		});
	}

	public void deactivate() {
		final EditPart manager = (EditPart) this.getParent().getChildren()
				.get(0);
		for (Object child : manager.getChildren()) {
			AbstractLibraryEditPart part = (AbstractLibraryEditPart) child;
			if (part.removeNodeTypeToNodeTypeTargetConnection(this)) {
				break; // Target found... no need to look further.
			}
		}
		super.deactivate();
	}

	public ServiceFlowRelationship getServiceFlowRelationship() {
		return (ServiceFlowRelationship) this.getModel();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		printSFR(sb, this.getServiceFlowRelationship());
		return sb.toString();
	}

	/**
	 * @param sb
	 * @param sfr
	 */
	private void printSFR(StringBuilder sb, ServiceFlowRelationship sfr) {
		if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
			ReferenceRelationship rr = sfr.getReferenceRelationship();
			sb.append(" ( "
					+ rr.getRefInterface1Ref().getName()
					+ (sfr.getDirection() == ServiceFlowDirection.RIGHTTOLEFT ? "<--"
							: "-->") + rr.getRefInterface2Ref().getName() + ")");
		} else {
			if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW)) {
				ServiceFlow serviceFlow = sfr.getServiceFlow();
				sb.append(" Service flow: " + serviceFlow.getName() + "\n");
			}
		}
	}
}
