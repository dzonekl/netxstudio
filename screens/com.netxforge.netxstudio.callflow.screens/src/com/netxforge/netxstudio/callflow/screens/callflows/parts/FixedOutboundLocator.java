/*******************************************************************************
 * Copyright (c) 26 apr. 2013 NetXForge.
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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public class FixedOutboundLocator implements Locator {
	private double relativeX;
	private double relativeY;
	private IFigure reference;

	/**
	 * Null constructor. The reference figure must be set before use. The
	 * relative locations will default to (0.0, 0.0).
	 * 
	 * @since 2.0
	 */
	public FixedOutboundLocator() {
		relativeX = 0.0;
		relativeY = 0.0;
	}

	/**
	 * Constructs a RelativeLocator with the given reference figure and relative
	 * location. The location is a constant from {@link PositionConstants} used
	 * as a convenient and readable way to set both the relativeX and relativeY
	 * values.
	 * 
	 * @param reference
	 *            the reference figure
	 * @param location
	 *            one of NORTH, NORTH_EAST, etc.
	 * @since 2.0
	 */
	public FixedOutboundLocator(IFigure reference, int location) {
		setReferenceFigure(reference);
		switch (location & PositionConstants.NORTH_SOUTH) {
		case PositionConstants.NORTH:
			relativeY = 0;
			break;
		case PositionConstants.SOUTH:
			relativeY = 1.0;
			break;
		default:
			relativeY = 0.5;
		}

		switch (location & PositionConstants.EAST_WEST) {
		case PositionConstants.WEST:
			relativeX = 0;
			break;
		case PositionConstants.EAST:
			relativeX = 1.0;
			break;
		default:
			relativeX = 0.5;
		}
	}

	/**
	 * Constructs a RelativeLocator with the given reference Figure and offset
	 * ratios.
	 * 
	 * @param reference
	 *            the reference figure
	 * @param relativeX
	 *            the relative X offset
	 * @param relativeY
	 *            the relative Y offset
	 * @since 2.0
	 */
	public FixedOutboundLocator(IFigure reference, double relativeX, double relativeY) {
		setReferenceFigure(reference);
		this.relativeX = relativeX;
		this.relativeY = relativeY;
	}

	/**
	 * Returns the Reference Box in the Reference Figure's coordinate system.
	 * The returned Rectangle may be by reference, and should <b>not</b> be
	 * modified.
	 * 
	 * @return the reference box
	 * @since 2.0
	 */
	protected Rectangle getReferenceBox() {
		return getReferenceFigure().getBounds();
	}

	/**
	 * Returns the Figure this locator is relative to.
	 * 
	 * @return the reference figure
	 * @since 2.0
	 */
	protected IFigure getReferenceFigure() {
		return reference;
	}

	/**
	 * Relocates the target using the relative offset locations.
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 */
	public void relocate(IFigure target) {
		IFigure reference = getReferenceFigure();
		
		// Shrink the reference figure bounds by 1 px 
		Rectangle targetBounds = new PrecisionRectangle(getReferenceBox()
				.getResized(-1, -1));
		
		// Translates the target to the parents absolute coordinates
		reference.translateToAbsolute(targetBounds);
		target.translateToRelative(targetBounds);
		
		// Resize it 
		targetBounds.resize(1, 1);

		Dimension targetSize = target.getPreferredSize();

		targetBounds.x += (int) (targetBounds.width * relativeX - ((targetSize.width + 1) / 2));
		targetBounds.y += (int) (targetBounds.height * relativeY - ((targetSize.height + 1) / 2));
		targetBounds.setSize(targetSize);
		target.setBounds(targetBounds);
	}

	/**
	 * Sets the reference figure this locator uses to place the target figure.
	 * 
	 * @param reference
	 *            the reference figure
	 * @since 2.0
	 */
	public void setReferenceFigure(IFigure reference) {
		this.reference = reference;
	}
	

}
