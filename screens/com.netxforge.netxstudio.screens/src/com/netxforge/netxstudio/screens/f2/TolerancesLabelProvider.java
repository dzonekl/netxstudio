/*******************************************************************************
 * Copyright (c) 22 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Tolerance;

public class TolerancesLabelProvider extends CellLabelProvider implements
		ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof Tolerance) {
			Tolerance t = (Tolerance) element;
			switch (columnIndex) {
			case 0: {
				if (t.getName() != null) {
					return t.getName();
				}
			}
			case 1: {
				if (t.getLevel() != null) {
					return t.getLevel().getName();
				}
			}
			case 2: {
				if (t.getExpressionRef() != null) {
					Expression e = t.getExpressionRef();
					EList<String> s = e.getExpressionLines();
					if (s.size() > 0) {
						return s.get(0)
								+ (s.size() > 1 ? " ( " + (s.size() - 1)
										+ " more lines)" : "");
					}
				}
			}
				break;
			}
		}
		return null;
	}

	@Override
	public void update(ViewerCell cell) {
		String text = getColumnText(cell.getElement(), cell.getColumnIndex());
		cell.setText(text);
	}
}