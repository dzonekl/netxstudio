package com.netxforge.netxstudio.callflow.screens.callflows.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import com.netxforge.netxstudio.callflow.screens.callflows.model.NodeTypeToServiceRelationships;

public class NodeTypeToComponentEditPart extends AbstractConnectionEditPart {

	public NodeTypeToComponentEditPart(NodeTypeToServiceRelationships nttc) {
		this.setModel(nttc);
	}

	public NodeTypeToServiceRelationships getNodeTypeToComponent() {
		return (NodeTypeToServiceRelationships) this.getModel();
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}

	public void activate() {
		super.activate();
		final EditPart manager = (EditPart) this.getParent().getChildren()
				.get(0);
		for (Object child : manager.getChildren()) {
			AbstractLibraryEditPart part = (AbstractLibraryEditPart) child;
			if (part.addNodeTypeToComponentTargetConnection(this)) {
				return; // Target found... no need for a listener.
			}
		}

		manager.addEditPartListener(new EditPartListener.Stub() {

			@Override
			public void childAdded(EditPart child, int index) {

				AbstractLibraryEditPart part = (AbstractLibraryEditPart) child;
				if (part.addNodeTypeToComponentTargetConnection(NodeTypeToComponentEditPart.this)) {
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
			if (part.removeNodeTypeToComponentTargetConnection(this)) {
				break; // Target found... no need to look further.
			}
		}
		super.deactivate();
	}
}
