/*******************************************************************************
 * Copyright (c) 26 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f4;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;

import com.netxforge.netxstudio.metrics.MetricSource;

public class MetricSourceLabelProvider extends CellLabelProvider implements
		ITableLabelProvider {

	public String getColumnText(Object element, int columnIndex) {

		if (element instanceof MetricSource) {

			MetricSource ms = (MetricSource) element;
			switch (columnIndex) {
			case 0: {
				return ms.getName();
			}
			case 1: {
				return ms.getMetricLocation();
			}
			case 2: {

				// long ts = modelUtils.mostRecentContainedDated(ms);
				// if (ts == 0) {
				// return "<unknown>";
				// }
				// Date d = new Date(ts);
				// return modelUtils.date(d) + " @ " + modelUtils.time(d);
				return "";
			}

			}

		}
		return null;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public void update(ViewerCell cell) {
		String text = getColumnText(cell.getElement(), cell.getColumnIndex());
		cell.setText(text);
	}

}