package com.netxforge.netxstudio.screens.f1.parts;

import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.gef.LayerConstants;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.screens.f1.model.WrappedRFSService;
import com.netxforge.netxstudio.services.RFSService;

public class CanvasEditPart extends AbstractEditPart {

	public CanvasEditPart(WrappedRFSService resource) {
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
		layer.setLayoutManager(new RFSServiceLayout());
		
		// Create the static router for the connection layer
		ConnectionLayer connLayer = (ConnectionLayer)getLayer(LayerConstants.CONNECTION_LAYER);
		connLayer.setConnectionRouter(new ShortestPathConnectionRouter(layer));
//		connLayer.setConnectionRouter(new ManhattanConnectionRouter());
		
		
		
		return layer;
	}

	public WrappedRFSService getWrappedRFSService() {
		return (WrappedRFSService) this.getModel();
	}

	
	@Override
	protected void createEditPolicies() {
	}

	@Override
	protected List<Object> getModelChildren() {
		List<Object> result = Lists.newArrayList();
		WrappedRFSService wnt = (WrappedRFSService) this.getModel();
		RFSService service = wnt.getService();
		result.add(service);
		result.addAll(service.getServices());
		result.addAll(service.getNodes());
		// We need to iterate through the hiarchy to get all objects.
//		TreeIterator<EObject> ti = nt.eAllContents();
//		while (ti.hasNext()) {
//			EObject next = ti.next();
//			if (next instanceof RFSService) {
//				result.add(next);
//			}
//			if (next instanceof Node) {
//				result.add(next);
//			}
//
//		}
		return result;
	}
	
}
