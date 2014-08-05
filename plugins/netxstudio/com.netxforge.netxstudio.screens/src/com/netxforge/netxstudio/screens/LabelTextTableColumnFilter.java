/*******************************************************************************
 * Copyright (c) Oct 26, 2012 NetXForge.
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

import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * Only filter items on a specified column.
 * 
 * @author Christophe Bouhier
 * 
 */
public class LabelTextTableColumnFilter extends ViewerFilter {

	public static final String COLUMN_FILTER = "column.filter.";

	private TableColumn column;

	public LabelTextTableColumnFilter(TableColumn column) {
		this.column = column;
	}

	private String searchString;

	@Override
	public boolean isFilterProperty(Object element, String property) {

		// Potential use the property firing to enable/disable a filter.

		String columnProperty = COLUMN_FILTER.concat(column.getText());
		if (property.equals(columnProperty)) {
			return true;
		} else {
			// Disable the filter by default.
			return false;
			// return super.isFilterProperty(element, property);
		}
	}

	public void setFilterText(String s) {
		// Search must be a substring of the existing value
		this.searchString = ".*" + s + ".*"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		boolean result = true;
		if (element instanceof EObject) {
			result |= filterObjectOnText(viewer, element);
		}
		return result;
	}

	private boolean filterObjectOnText(Viewer viewer, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		boolean result = true;
		// Get the n'th column matching the provided column.
		if (viewer instanceof TableViewer) {
			Table table = ((TableViewer) viewer).getTable();
			int targetColumnIndex = table.indexOf(column);

			// Blindly cast to ITableLabelProvider, we could also use
			// EditingSupport instead to get the edited
			// value.
			ITableLabelProvider labelProvider = (ITableLabelProvider) ((TableViewer) viewer)
					.getLabelProvider();
			String match = labelProvider.getColumnText(element,
					targetColumnIndex);

			try {
				result = match.matches(searchString);
				if (result) {
					System.out.println("Searchsstring: match for: "
							+ searchString + " on: " + match);
				}
			} catch (PatternSyntaxException pse) {
				pse.printStackTrace();
			}
		}
		return result;
	}
}