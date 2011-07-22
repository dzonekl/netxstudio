package com.netxforge.netxstudio.screens.f2.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.f2.model.NodeTypeToComponent;

public class NodeTypeEditPart extends AbstractLibraryEditPart {

	
	private Label label;
	
	
	
	public NodeTypeEditPart(NodeType nt){
		super.setModel(nt);
		this.populateTransientModel();
	}
	
	public NodeType getNodeType(){
		return (NodeType) super.getModel();
	}
	
	private final Insets CLIENT_AREA_INSETS = new Insets(10,10,21,21);

	
	@Override
	protected IFigure createFigure() {
		RoundedRectangle figure = new RoundedRectangle(){
			@Override
			public Rectangle getClientArea(Rectangle rect) {
				Rectangle clientArea = super.getClientArea(rect);
				clientArea.shrink(CLIENT_AREA_INSETS);
				return clientArea;
			}
		};
		figure.setSize(50,50);
		return figure;
	}

	@Override
	protected void createEditPolicies() {

	}

	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelSourceConnections() {
		return modelSourceConnections;	
	}
	
	List<NodeTypeToComponent> modelSourceConnections;
	
	private void populateTransientModel(){
		modelSourceConnections = Lists.newArrayList();
		NodeType nt = (NodeType) this.getModel();
		for(Function f : nt.getFunctions()){
			modelSourceConnections.add(new NodeTypeToComponent(nt, f));
		}
	}
	
	
//	@Override
//	protected List<Object> getModelChildren() {
//		List<Object> result = Lists.newArrayList();
//		WrappedNodeType wnt = (WrappedNodeType) this.getModel();
//		NodeType nt = wnt.getNodeType();
//		result.add(nt);
//		if (nt.getFunctions().size() > 0) {
//			result.addAll(nt.getFunctions());
//		}
//		if (nt.getEquipments().size() > 0) {
//			result.addAll(nt.getEquipments());
//		}
//		return result;
//	}
	
}
