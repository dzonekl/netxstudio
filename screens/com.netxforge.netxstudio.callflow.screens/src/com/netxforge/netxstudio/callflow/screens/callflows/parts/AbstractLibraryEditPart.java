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

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

/**
 * A common Edit part for linking Component parts
 * 
 * @author Christophe
 */
public class AbstractLibraryEditPart extends AbstractGraphicalEditPart
		implements NodeEditPart {

	protected final Insets CLIENT_AREA_INSETS = new Insets(5, 5, 5, 5);

	@Override
	protected IFigure createFigure() {
		return null;
	}

	protected void createEditPolicies() {

	}

	public boolean addNodeTypeToComponentTargetConnection(
			NodeTypeToComponentEditPart part) {
		return false;
	}

	public boolean removeNodeTypeToComponentTargetConnection(
			NodeTypeToComponentEditPart part) {
		return false;
	}

	public boolean addComponentToComponentTargetConnection(
			ComponentToComponentEditPart componentToComponentEditPart) {
		return false;
	}

	public boolean removeComponentToComponentTargetConnection(
			ComponentToComponentEditPart componentToComponentEditPart) {
		return false;
	}

	public boolean addNodeTypeToNodeTypeTargetConnection(
			ServiceFlowRelationshipEditPart serviceFlowRelationshipEditPart) {
		return false;
	}

	public boolean removeNodeTypeToNodeTypeTargetConnection(
			ServiceFlowRelationshipEditPart serviceFlowRelationshipEditPart) {
		return false;
	}

	protected void adaptLabelWidth(Label nameLabel) {
		// Adapt the figures bounds to the text bound width at least.
		Rectangle textBounds = nameLabel.getTextBounds();
		if (textBounds.width > figure.getBounds().width
				- (CLIENT_AREA_INSETS.left + CLIENT_AREA_INSETS.right)) {
			int newWidth = CLIENT_AREA_INSETS.left + CLIENT_AREA_INSETS.right
					+ textBounds.width; // 5 for luck!

			figure.getBounds().setWidth(newWidth);
			figure.setConstraint(
					nameLabel,
					new Rectangle(0, 0, figure.getBounds().width, figure
							.getBounds().height));
		}
	}

	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		System.out.println("requesting source anchor for " + connection.toString());
		return getConnectionAnchor();
	}

	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		System.out.println("requesting target anchor for " + connection.toString());
		return getConnectionAnchor();
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		System.out.println("requesting source anchor for " + request);
		return getConnectionAnchor();
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		System.out.println("requesting target anchor for " + request);
		return getConnectionAnchor();
	}
	
	protected ConnectionAnchor getConnectionAnchor() {
		ChopboxAnchor chopboxAnchor = new ChopboxAnchor(getFigure());
		return chopboxAnchor;
	}
	
}
