package com.netxforge.netxstudio.screens.f1.parts;

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
import com.netxforge.netxstudio.services.RFSService;

/**
 * Special layout, which layouts on the model type. The model type is stored as
 * a constraint when the figure is created.
 * 
 * 
 * @author dzonekl
 */
public class RFSServiceLayout extends AbstractLayout {

	Map<IFigure, EObject> constraints = Maps.newHashMap();
	private List<String> nodeTypeCache = Lists.newArrayList();

	public void layout(IFigure container) {
		System.err.println("layout request" + container);
		Iterator<?> iterator = container.getChildren().iterator();
		int childCount = 0;
		int heightDistance = 40;
		int widthDistance = 50;

		// First we need to group by type and layout separately.
		while (iterator.hasNext()) {
			IFigure f = (IFigure) iterator.next();
			Rectangle bounds = f.getBounds().getCopy();

			EObject c = constraints.get(f);
			// Calc the depth of the child's with constraint.
			int depth = depth(c, 0);
			int span = span(c, 1);
			int x = widthDistance * depth * span;
			int y = childCount * heightDistance;

			Rectangle constraint = new Rectangle(x, y, bounds.width,
					bounds.height);
			f.setBounds(constraint);
			childCount++;
		}
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

		if (constraint.eContainer() == null) {
			return depth;
		}

		depth++;
		if (constraint.eContainer() instanceof RFSService) {
			return depth;
		} else {
			return depth(constraint.eContainer(), depth);
		}
	}

	int span(EObject constraint, int span) {

		if (constraint.eContainer() == null) {
			return span;
		}

		if (constraint instanceof Node) {
			Node n = (Node) constraint;
			if (n.getNodeType() != null) {
				NodeType nodeType = n.getNodeType();
				if (nodeTypeCache.indexOf(nodeType.getName()) == -1) {
					nodeTypeCache.add(nodeType.getName());
				}
				span = nodeTypeCache.indexOf(nodeType.getName()) + 1;
			}
			return span;
		}
		return span;
	}

}
