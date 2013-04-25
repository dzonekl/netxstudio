/*******************************************************************************
 * Copyright (c) 25 apr. 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.callflow.screens.callflows.parts;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Maps;
import com.netxforge.netxstudio.library.NodeType;

/**
 * Special layout, which layouts on the model type. The model type is stored as
 * a constraint when the figure is created.
 * 
 * 
 * @author Christophe Bouhier
 */
public class CallFlowNodeTypeLayout extends AbstractLayout {

	Map<IFigure, EObject> constraints = Maps.newHashMap();
	private static int X_OFFSET = 20;
	private static int Y_OFFSET = 20;

	public void layout(IFigure container) {
		System.err.println("layout request" + container);

		printConstraints();

		Iterator<?> iterator = container.getChildren().iterator();
		@SuppressWarnings("unused")
		int childCount = 0;
		int heightDistance = 40;
		int widthDistance = 50;

		// First we need to group by type and layout separately.
		while (iterator.hasNext()) {
			IFigure f = (IFigure) iterator.next();
			Rectangle bounds = f.getBounds().getCopy();

			EObject c = constraints.get(f);
			int depth = depth(c, 0);
			System.out.print(depth);
			int x = widthDistance * depth + X_OFFSET;
			int y = heightDistance + Y_OFFSET;

			Rectangle constraint = new Rectangle(x, y, bounds.width,
					bounds.height);
			f.setBounds(constraint);
			childCount++;
		}
	}

	/**
	 * Print the current constraints for debugging.
	 */
	private void printConstraints() {

		for (Entry<IFigure, EObject> c : constraints.entrySet()) {
			System.out.println(" constraint for object: " + c.getValue()
					+ " bounds:" + c.getKey().getBounds());
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
		if (constraint.eContainer() instanceof NodeType) {
			return depth;
		} else {
			return depth(constraint.eContainer(), depth);
		}
	}

}
