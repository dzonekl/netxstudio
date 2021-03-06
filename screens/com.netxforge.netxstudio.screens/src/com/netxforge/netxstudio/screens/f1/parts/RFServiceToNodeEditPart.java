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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import com.netxforge.netxstudio.screens.f1.model.RFServiceToNode;

public class RFServiceToNodeEditPart extends AbstractConnectionEditPart {

	public RFServiceToNodeEditPart(RFServiceToNode stn) {
		this.setModel(stn);
	}

	public RFServiceToNode getRFSServiceToNode() {
		return (RFServiceToNode) this.getModel();
	}

	@Override
	protected void createEditPolicies() {
	}

	public void activate() {
		super.activate();
		final EditPart manager = (EditPart) this.getParent().getChildren()
				.get(0);
		for (Object child : manager.getChildren()) {
			AbstractEditPart part = (AbstractEditPart) child;
			if (part.addRFServiceToNodeTargetConnection(this)) {
				return; // Target found... no need for a listener.
			}
		}

		manager.addEditPartListener(new EditPartListener.Stub() {

			@Override
			public void childAdded(EditPart child, int index) {

				AbstractEditPart part = (AbstractEditPart) child;
				if (part.addRFServiceToNodeTargetConnection(RFServiceToNodeEditPart.this)) {
					manager.removeEditPartListener(this);
				}
			}
		});
	}

	public void deactivate() {
		final EditPart manager = (EditPart) this.getParent().getChildren()
				.get(0);
		for (Object child : manager.getChildren()) {
			AbstractEditPart part = (AbstractEditPart) child;
			if (part.removeRFServiceToNodeTargetConnection(this)) {
				break; // Target found... no need to look further.
			}
		}
		super.deactivate();
	}
}
