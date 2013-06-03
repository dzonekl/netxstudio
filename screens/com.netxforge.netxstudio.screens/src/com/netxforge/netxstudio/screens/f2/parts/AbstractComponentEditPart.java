package com.netxforge.netxstudio.screens.f2.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.screens.f2.model.ComponentToComponent;
import com.netxforge.netxstudio.screens.f2.model.NodeTypeToComponent;

public abstract class AbstractComponentEditPart extends AbstractLibraryEditPart {

	

	public AbstractComponentEditPart() {
		super();
	}

	public Component getComponent() {
		return (Component) getModel();
	}

	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected void createEditPolicies() {

	}

	private final List<NodeTypeToComponent> modelTargetConnections = Lists
			.newArrayList();
	private final List<ComponentToComponent> modelTargetComponentConnections = Lists
			.newArrayList();

	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelTargetConnections() {
		return modelTargetConnections;
	}

	public boolean addNodeTypeToComponentTargetConnection(
			NodeTypeToComponentEditPart part) {
		NodeTypeToComponent nttc = part.getNodeTypeToComponent();
		if (!nttc.getTarget().equals(this.getComponent())) {
			return false;
		}
		this.modelTargetConnections.add(nttc);
		this.addTargetConnection(part, 0);
		return true;
	}

	public boolean removeNodeTypeToComponentTargetConnection(
			NodeTypeToComponentEditPart part) {
		if (!modelTargetConnections.remove(part.getModel())) {
			return false;
		}
		this.removeTargetConnection(part);
		return true;
	}

	public boolean addComponentToComponentTargetConnection(
			ComponentToComponentEditPart part) {
		ComponentToComponent ctc = part.getComponentToComponent();
		if (!ctc.getTarget().equals(this.getComponent())) {
			return false;
		}
		this.modelTargetComponentConnections.add(ctc);
		this.addTargetConnection(part, 0);
		return true;
	}

	public boolean removeComponentToComponentTargetConnection(
			ComponentToComponentEditPart part) {
		if (!modelTargetComponentConnections.remove(part.getModel())) {
			return false;
		}
		this.removeTargetConnection(part);
		return true;
	}

	List<ComponentToComponent> modelSourceComponentConnections;

	public void populateConnectionModel() {
		modelSourceComponentConnections = Lists.newArrayList();
		Component c = this.getComponent();

		List<EObject> it = c.eContents();
		for (EObject o : it) {
			if (o instanceof Component) {
				modelSourceComponentConnections.add(new ComponentToComponent(c,
						(Component) o));
			}

		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelSourceConnections() {
		return modelSourceComponentConnections;
	}

}
