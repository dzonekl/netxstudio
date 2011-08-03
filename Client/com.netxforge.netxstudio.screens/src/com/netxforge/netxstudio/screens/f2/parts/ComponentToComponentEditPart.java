package com.netxforge.netxstudio.screens.f2.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import com.netxforge.netxstudio.screens.f2.model.ComponentToComponent;

public class ComponentToComponentEditPart extends AbstractConnectionEditPart {

	public ComponentToComponentEditPart(ComponentToComponent ctc) {
		this.setModel(ctc);
	}

	public ComponentToComponent getComponentToComponent() {
		return (ComponentToComponent) this.getModel();
	}

	@Override
	protected void createEditPolicies() {
	}

	public void activate() {
		super.activate();
		final EditPart manager = (EditPart) this.getParent().getChildren()
				.get(0);
		for (Object child : manager.getChildren()) {
			AbstractLibraryEditPart part = (AbstractLibraryEditPart) child;
			if (part.addComponentToComponentTargetConnection(this)) {
				return; // Target found... no need for a listener.
			}
		}

		manager.addEditPartListener(new EditPartListener.Stub() {

			@Override
			public void childAdded(EditPart child, int index) {

				AbstractLibraryEditPart part = (AbstractLibraryEditPart) child;
				if (part.addComponentToComponentTargetConnection(ComponentToComponentEditPart.this)) {
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
			if (part.removeComponentToComponentTargetConnection(this)) {
				break; // Target found... no need to look further.
			}
		}
		super.deactivate();
	}
}
