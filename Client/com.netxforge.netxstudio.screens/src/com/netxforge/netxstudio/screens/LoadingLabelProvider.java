/*******************************************************************************
 * Copyright (c) 15 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;

/**
 * A simple label provider dealing with a String element input as text.
 * 
 * @author Christophe Bouhier
 * 
 */
public class LoadingLabelProvider extends StyledCellLabelProvider {

	@Override
	public void update(ViewerCell cell) {

		Object element = cell.getElement();
		if (element instanceof String) {
			// Do some styling on our loading string. .
			StyledString styledString = new StyledString();
			styledString.append((String) element, StyledString.COUNTER_STYLER);
			cell.setText(styledString.toString());
			cell.setStyleRanges(styledString.getStyleRanges());
		}
		// We only support String (for now).
		super.update(cell);
	}
}
