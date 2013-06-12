/*******************************************************************************
 * Copyright (c) 11 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.f1.parts;

import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Maps;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * Special layout, which layouts on the model type. The model type is stored as
 * a constraint when the figure is created. The algorithm walks the model
 * hierarchy updating a position pointer, looks up the IFigure and places the
 * figure. The position pointer is: +1X,+1Y for service depth +1X for service
 * siblling +1X for nodes and nodes siblings.
 * 
 * @author Christophe Bouhier
 */
public class RFServiceLayout extends AbstractLayout {

	Map<EObject, IFigure> constraints = Maps.newHashMap();
	private static int X_OFFSET = 20;
	int heightDistance = 40;
	int widthDistance = 80;
	private Object rootConstraint;

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

		public void upX() {
			this.x = x + 1;
		}

		public int getY() {
			return y;
		}

		public void upY() {
			this.y = y + 1;
		}
	}

	public void layout(IFigure container) {
		if (rootConstraint instanceof RFSService) {
			System.out.println(((RFSService) rootConstraint).getServiceName());
			placeModel((EObject) rootConstraint, new Position(0, 0));
		}

	}

	private void placeModel(EObject object, Position pos) {

		if (object instanceof RFSService) {
			RFSService service = (RFSService) object;
			place(constraints.get(object), pos);
			if (!service.getServices().isEmpty()) {
				pos.upX();
				pos.upY();
				for (Service child : service.getServices()) {
					pos.upY();
					place(constraints.get(child), pos);
					if (child instanceof RFSService) {
						RFSService childService = (RFSService) child;
						
						// Should push the X position, as X will drift.
						int xSibling = pos.getX();
						placeModel(childService, pos);
						
						// Should pop the X position as X has drifted. 
						if (!childService.getNodes().isEmpty()) {
							pos.upY();
							for (Node n : childService.getNodes()) {
								placeModel(n, pos);
							}
						}
						pos = new Position(xSibling, pos.getY());
					}
				}
			}

		} else if (object instanceof Node) {
			pos.upX();
			place(constraints.get(object), pos);
		}
	}

	private void place(IFigure fig, Position pos) {

		Rectangle bounds = fig.getBounds();

		int x = widthDistance * (pos.x) + X_OFFSET;
		int y = heightDistance * (pos.y);

		Rectangle constraint = new Rectangle(x, y, bounds.width, bounds.height);
		fig.setBounds(constraint);
	}

	@Override
	public void setConstraint(IFigure child, Object constraint) {
		if (rootConstraint == null) {
			rootConstraint = constraint;
		}

		if (!constraints.containsKey(constraint)
				&& constraint instanceof EObject) {
			constraints.put((EObject) constraint, child);
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

}
