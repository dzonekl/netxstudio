package com.netxforge.netxstudio.callflow.screens.callflows.parts;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.netxforge.netxstudio.callflow.screens.callflows.model.NodeTypeToComponent;
import com.netxforge.netxstudio.operators.Node;

public class NodeEditPart extends AbstractLibraryEditPart {

	Label nameLabel = new Label();

	public NodeEditPart(Node n) {
		super.setModel(n);
		this.populateTransientModel();
	}

	public Node getNode() {
		return (Node) super.getModel();
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

		Node n = this.getNode();
		this.nameLabel.setText(n.getNodeID());
		this.adaptLabelWidth(nameLabel);

		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) this
				.getParent();
		IFigure figure = this.getFigure();
		parent.setLayoutConstraint(this, figure, this.getNode());
		figure.revalidate();
	}

	List<NodeTypeToComponent> modelSourceConnections;
	
	
	// TODO
	private void populateTransientModel() {
//		modelSourceConnections = Lists.newArrayList();
//		Node nt = (Node) this.getModel();

//		List<EObject> it = nt.eContents();
//		for (EObject o : it) {
//			if (o instanceof Component) {
//				modelSourceConnections.add(new NodeTypeToComponent(nt,
//						(Component) o));
//			}
//
//		}
	}
}
