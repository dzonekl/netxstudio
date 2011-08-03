package com.netxforge.netxstudio.screens.f2.parts;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.f2.model.NodeTypeToComponent;

public class NodeTypeEditPart extends AbstractLibraryEditPart {

	Label nameLabel = new Label();
	
	public NodeTypeEditPart(NodeType nt){
		super.setModel(nt);
		this.populateTransientModel();
	}
	
	public NodeType getNodeType(){
		return (NodeType) super.getModel();
	}
	
//	private final Insets CLIENT_AREA_INSETS = new Insets(2,2,21,21);

	
	@Override
	protected IFigure createFigure() {
		RoundedRectangle figure = new RoundedRectangle(){
			@Override
			public Rectangle getClientArea(Rectangle rect) {
				Rectangle clientArea = super.getClientArea(rect);
//				clientArea.shrink(CLIENT_AREA_INSETS);
				return clientArea;
			}
		};
		figure.setLayoutManager(new XYLayout());
		figure.setSize(50,50);
		figure.setLineWidth(2);
		figure.setBackgroundColor(ColorConstants.lightGray);
		
		Rectangle copy = figure.getBounds().getCopy();
		figure.add(nameLabel);
		figure.setConstraint(nameLabel, new Rectangle(0,0, copy.width, copy.height));
		
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
	
	
	@Override
	protected void refreshVisuals() {
		
		NodeType nt = this.getNodeType();
		this.nameLabel.setText(nt.getName());
		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this.getParent();
		IFigure figure = this.getFigure();
		parent.setLayoutConstraint(this, figure, this.getNodeType());
		figure.revalidate();
	}

	List<NodeTypeToComponent> modelSourceConnections;
	
	private void populateTransientModel(){
		modelSourceConnections = Lists.newArrayList();
		NodeType nt = (NodeType) this.getModel();
		
		List<EObject> it = nt.eContents();
		for( EObject o : it){
			if(o instanceof Component){
				modelSourceConnections.add(new NodeTypeToComponent(nt,
						(Component) o));	
			}
			
		}
	}
}
