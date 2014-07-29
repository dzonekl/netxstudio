/*******************************************************************************
 * Copyright (c) 28 apr. 2013 NetXForge.
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

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScalableFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * An Anchor at a fixed position.
 * 
 * @author Christophe Bouhier
 */
public class CallFlowConnectionAnchor extends AbstractConnectionAnchor {

	public int offsetV;

	public CallFlowConnectionAnchor(IFigure owner) {
		super(owner);
	}

	/**
	 * @see org.eclipse.draw2d.AbstractConnectionAnchor#ancestorMoved(IFigure)
	 */
	public void ancestorMoved(IFigure figure) {
		if (figure instanceof ScalableFigure) {
			return;
		}
		super.ancestorMoved(figure);
	}

	public Point getLocation(Point reference) {

		// A rectangle as the owner, but expanded by 1 px.
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getOwner().getBounds());
		r.translate(-1, -1);
		r.resize(1, 1);

		// Rectangle r = getOwner().getBounds();
		int x, y;
		y = r.y + offsetV;

		// The center of the owner.
		float centerX = r.x + 0.5f * r.width;
		x = (int) centerX;
		if (reference != null) {
			if (reference.x < x) {
				x -= 2;
			} else {
				x += 2;
			}
		}

		Point p = new PrecisionPoint(x, y);
		getOwner().translateToAbsolute(p);
		return p;
	}

	public Point getReferencePoint() {
		Point reference = getLocation(null);
		IFigure owner = this.getOwner();
		System.out.println("ANCHOR => Figure: " + owner + "Reference: "
				+ reference);
		return reference;
	}

	/**
	 * @param offsetV
	 *            The offsetV to set.
	 */
	public void setOffsetV(int offsetV) {
		this.offsetV = offsetV;
		fireAnchorMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof CallFlowConnectionAnchor) {
			CallFlowConnectionAnchor fa = (CallFlowConnectionAnchor) o;

			if (fa.offsetV == this.offsetV && fa.getOwner() == this.getOwner()) {
				return true;
			}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return (this.offsetV * 47) ^ this.getOwner().hashCode();
	}

	@Override
	public String toString() {
		return " offsetV: " + offsetV;
	}
}
