/*******************************************************************************
 * Copyright (c) 11 jun. 2013 NetXForge.
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
import com.netxforge.netxstudio.screens.f1.model.RFServiceToRFService;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

public class RFServiceEditPart extends AbstractEditPart {

	Label nameLabel = new Label();

	public RFServiceEditPart(RFSService service) {
		super.setModel(service);
		this.populateTransientModel();
	}

	public RFSService getRFService() {
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

		RFSService nt = this.getRFService();
		this.nameLabel.setText(nt.getServiceName());
		this.adaptLabelWidth(nameLabel);

		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this
				.getParent();
		IFigure figure = this.getFigure();
		parent.setLayoutConstraint(this, figure, this.getRFService());
		figure.revalidate();
	}

	List<Object> modelSourceConnections;

	private void populateTransientModel() {
		modelSourceConnections = Lists.newArrayList();
		RFSService service = (RFSService) this.getModel();
		for (Service s : service.getServices()) {
			if (s instanceof RFSService) {
				modelSourceConnections.add(new RFServiceToRFService(service,
						(RFSService) s));
			}

		}

		for (Node node : service.getNodes()) {
			modelSourceConnections.add(new RFServiceToNode(service, node));
		}
	}

	private final List<Object> modelTargetConnections = Lists.newArrayList();

	public boolean addRFServiceToRFServiceTargetConnection(
			RFServiceToRFServiceEditPart part) {
		RFServiceToRFService nttc = part.getRFSServiceToRFService();
		if (!nttc.getTarget().equals(this.getRFService())) {
			return false;
		}
		this.modelTargetConnections.add(nttc);
		int size = this.getTargetConnections().size();
		this.addTargetConnection(part, size);
		return true;
	}

	public boolean removeRFServiceToRFServiceTargetConnection(
			RFServiceToRFServiceEditPart part) {
		if (!modelTargetConnections.remove(part.getModel())) {
			return false;
		}
		this.removeTargetConnection(part);
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelTargetConnections() {
		return modelTargetConnections;
	}
}
