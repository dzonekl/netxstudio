package com.netxforge.netxstudio.screens.f1.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import com.netxforge.netxstudio.screens.f1.model.RFSServiceToNode;

public class RFSServiceToNodeEditPart extends AbstractConnectionEditPart {

	public RFSServiceToNodeEditPart(RFSServiceToNode stn) {
		this.setModel(stn);
	}

	public RFSServiceToNode getRFSServiceToNode() {
		return (RFSServiceToNode) this.getModel();
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
			if (part.addRFSServiceToNodeTargetConnection(this)) {
				return; // Target found... no need for a listener.
			}
		}

		manager.addEditPartListener(new EditPartListener.Stub() {

			@Override
			public void childAdded(EditPart child, int index) {

				AbstractEditPart part = (AbstractEditPart) child;
				if (part.addRFSServiceToNodeTargetConnection(RFSServiceToNodeEditPart.this)) {
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
			if (part.removeRFSServiceToNodeTargetConnection(this)) {
				break; // Target found... no need to look further.
			}
		}
		super.deactivate();
	}
}
