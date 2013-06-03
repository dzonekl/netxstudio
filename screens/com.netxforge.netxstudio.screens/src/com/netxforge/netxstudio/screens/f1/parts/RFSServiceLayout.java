package com.netxforge.netxstudio.screens.f1.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * Special layout, which layouts on the model type. The model type is stored as
 * a constraint when the figure is created.
 * 
 * 
 * @author Christophe Bouhier
 */
public class RFSServiceLayout extends AbstractLayout {

	Map<IFigure, EObject> constraints = Maps.newHashMap();
	private static int X_OFFSET = 20;

	static class Position {
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		int x = 0;
		int y = 0;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

	// Map with service name, contains a map of nodetype name / node.
	private Map<String, Map<String, List<Node>>> nodeTypeCache = Maps
			.newLinkedHashMap();

	public void layout(IFigure container) {
		System.err.println("layout request" + container);

		Iterator<?> iterator = container.getChildren().iterator();
		nodeTypeCache.clear();

		int heightDistance = 40;
		int widthDistance = 80;

		// First we need to group by type and layout separately.
		while (iterator.hasNext()) {
			IFigure f = (IFigure) iterator.next();
			Rectangle bounds = f.getBounds().getCopy();

			EObject c = constraints.get(f);

			Position itemPosition = new Position(0, 0);
			// Set the current Node Type and cache.
			if (c instanceof Node) {
				itemPosition = indexOfNodeType(c);

			} else if (c instanceof RFSService) {
				buildCacheForService(c);

				int serviceSpan = span(c, 0);
				// Calc the depth of the child's with constraint, the initial
				// depth
				// is
				// depending on the nodeType depth.
				int serviceDepth = depth(c, 0);
				itemPosition = new Position(serviceSpan, serviceDepth);
			}

			System.out.println("Layout for : " + c.eClass().getName() + " x="
					+ itemPosition.x + " y=" + itemPosition.y);

			int x = widthDistance * (itemPosition.x) + X_OFFSET;
			int y = heightDistance * (itemPosition.y);

			Rectangle constraint = new Rectangle(x, y, bounds.width,
					bounds.height);
			f.setBounds(constraint);
		}
	}

	private void buildCacheForService(EObject c) {
		RFSService rfsService = (RFSService) c;
		String serviceKey = rfsService.getServiceName();
		// Build a cache for the nodes.
		for (Node n : rfsService.getNodes()) {
			if (n.getNodeType() != null) {
				NodeType nt = n.getNodeType();
				String ntKey = nt.getName();
				if (nodeTypeCache.containsKey(serviceKey)) {
					Map<String, List<Node>> nodeTypeMap = nodeTypeCache
							.get(serviceKey);
					if (nodeTypeMap.containsKey(ntKey)) {
						nodeTypeMap.get(ntKey).add(n);
					} else {
						ArrayList<Node> newArrayList = Lists.newArrayList(n);
						nodeTypeMap.put(ntKey, newArrayList);
					}
				} else {
					ArrayList<Node> newArrayList = Lists.newArrayList(n);
					HashMap<String, List<Node>> newHashMap = Maps.newHashMap();
					newHashMap.put(ntKey, newArrayList);
					nodeTypeCache.put(serviceKey, newHashMap);
				}
			}
		}
	}

	private Position indexOfNodeType(EObject c) {

		int serviceIndex = 0;
		int x = -1;
		int y = -1;
		int serviceNodeDepth = 0;
		
		if (c instanceof Node && ((Node) c).getNodeType() != null) {
			String ntKey = ((Node) c).getNodeType().getName();
			// loop through the service cache.
			for (String serviceKey : nodeTypeCache.keySet()) {
				Map<String, List<Node>> nodeTypeMap = nodeTypeCache
						.get(serviceKey);
				
				int nodeDepth = 0;
				List<String> ntKeyList = Lists.newArrayList(nodeTypeMap
						.keySet());
				for (int i = 0; i < ntKeyList.size(); i++) {
					String ntKeyCache = ntKeyList.get(i);
					// check for the matching key.
					nodeDepth = Math.max(nodeTypeMap.get(ntKeyCache).size(), nodeDepth);
					
					if (ntKeyCache.equals(ntKey)) {
						if(nodeTypeMap.get(ntKeyCache).contains(c)){
							System.out.println("Service depth =" + serviceNodeDepth + ", serviceIndex=" + serviceIndex + ", serviceKey=" + serviceKey);
							x = i + 1 + serviceIndex;
							y = nodeTypeMap.get(ntKeyCache).indexOf(c)
									 + serviceNodeDepth  + 1 + serviceIndex;
							break;
						}
						
					}
//					
				}
				serviceNodeDepth += nodeDepth;
				serviceIndex++;
				
			}
		}
		return new Position(x, y);
	}

	@Override
	public void setConstraint(IFigure child, Object constraint) {
		if (!constraints.containsKey(child) && constraint instanceof EObject) {
			constraints.put(child, (EObject) constraint);
		}
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
		Dimension dim = new Dimension();
		Rectangle r = container.getBounds().getCopy();
		dim.width = r.width;
		dim.height = r.height;
		return dim;
	}

	/**
	 * Returns the constraint for the given figure.
	 * 
	 * @param child
	 *            The figure
	 * @return The constraint
	 */
	public Object getConstraint(IFigure child) {
		return null;
	}

	int depth(EObject constraint, int depth) {

		// Return the lowest depth for the root service.
		if (constraint.eContainer().eClass() == OperatorsPackage.Literals.OPERATOR) {
			return depth;
		}
		// increment the depth for each existing parent service + the deepest
		// node type.
		depth++;
		if (constraint.eContainer() instanceof RFSService) {
			// Get the max depth for this service.
			
			//
			return depth(constraint.eContainer(), depth)
					+ this.maxDepth(((RFSService) constraint.eContainer())
							.getServiceName());
		}
		return depth;

	}

	int span(EObject constraint, int span) {

		if (constraint.eContainer().eClass() == OperatorsPackage.Literals.OPERATOR) {
			return span;
		}
		if (constraint instanceof Service) {
			span++;
			return span(constraint.eContainer(), span);
		}
		return span;
	}

	int maxDepth(String serviceKey) {
		int maxDepth = 0;
		if (this.nodeTypeCache.containsKey(serviceKey)) {
			Map<String, List<Node>> map = nodeTypeCache.get(serviceKey);
			for (String ntKey : map.keySet()) {
				maxDepth = Math.max(maxDepth, map.get(ntKey).size());
			}
		}
		return maxDepth;
	}

}
