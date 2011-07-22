package com.netxforge.netxstudio.screens.f2.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.screens.f2.model.NodeTypeToComponent;

public class AbstractComponentEditPart extends AbstractLibraryEditPart {
	
	
	public Component getComponent(){
		return (Component) super.getModel();
	}
	
	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected void createEditPolicies() {

	}
	
	private final List<NodeTypeToComponent> modelTargetConnections = Lists.newArrayList();
	
	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelTargetConnections() {
		return modelTargetConnections;
	}
	
	public boolean addNodeTypeToComponentTargetConnection(NodeTypeToComponentEditPart part){
		NodeTypeToComponent nttc = part.getNodeTypeToComponent();
		if(!nttc.getTarget().equals(this.getComponent())){
			return false;
		}
		this.modelTargetConnections.add(nttc);
		this.addTargetConnection(part, 0);
		return true;
	}

	
	public boolean removeNodeTypeToComponentTargetConnection(NodeTypeToComponentEditPart part){
		if(!modelTargetConnections.remove(part.getModel())){
			return false;
		}
		this.removeTargetConnection(part);
		return true;
	}
	
	
}
