package com.netxforge.netxstudio.screens.f2.parts;

import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.LayerConstants;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.f2.model.WrappedNodeType;

public class LibraryEditPart extends AbstractLibraryEditPart {

	public LibraryEditPart(WrappedNodeType resource) {
		this.setModel(resource);
	}

	@Override
	protected IFigure createFigure() {
//		
//		IFigure container = new Figure();
		FreeformLayer layer = new FreeformLayer();
		
		// CHOICE 1. Layout is grid layout, the constraint with grid data is set in "refresh visuals of the child edit part"/
		// Note: The grid layout fills up the grid and wraps to a new row, when "numcolumns is exceeded. 
		
		
//		GridLayout gridLayout = new GridLayout();
//		gridLayout.numColumns = 4;
//		gridLayout.makeColumnsEqualWidth = true;
//		layer.setLayoutManager(gridLayout);
		
		// CHOICE 2. Layout is freeform, the constraint is set in "refresh visuals of the child edit part"/
		layer.setLayoutManager(new NodeTypeLayout());
		
		// Create the static router for the connection layer
		ConnectionLayer connLayer = (ConnectionLayer)getLayer(LayerConstants.CONNECTION_LAYER);
		connLayer.setConnectionRouter(new ShortestPathConnectionRouter(layer));
		
		
		return layer;
	}

	public WrappedNodeType getWrappedNodeType() {
		return (WrappedNodeType) this.getModel();
	}

	
	@Override
	protected void createEditPolicies() {
	}

	@Override
	protected List<Object> getModelChildren() {
		List<Object> result = Lists.newArrayList();
		WrappedNodeType wnt = (WrappedNodeType) this.getModel();
		NodeType nt = wnt.getNodeType();
		result.add(nt);

		// We need to iterate through the hiarchy to get all objects.
		TreeIterator<EObject> ti = nt.eAllContents();
		while (ti.hasNext()) {
			EObject next = ti.next();
			if (next instanceof Component) {
				result.add(next);
			}
		}
		return result;
	}
	
}
