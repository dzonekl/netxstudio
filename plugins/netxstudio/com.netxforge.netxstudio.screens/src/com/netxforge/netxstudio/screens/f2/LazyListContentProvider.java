/*******************************************************************************
 * Copyright (c) 21 nov. 2012 NetXForge.
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

import java.util.List;

import org.eclipse.jface.viewers.AbstractTableViewer;
import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import com.netxforge.netxstudio.screens.dialog.HierarchyFilteredItemsSelectionDialog;

/**
 * Support for TableViewer.
 * 
 * 
 * TODO, Extend with filtering and history capability see: {@link HierarchyFilteredItemsSelectionDialog}
 * 
 * 
 * @author Christophe Bouhier
 */
public class LazyListContentProvider implements ILazyContentProvider {
	
	private Viewer viewer;
	private List<?> content;

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		this.content = (List<?>) newInput;
	}

	public void updateElement(int index) {

		if (viewer instanceof TableViewer) {
			((AbstractTableViewer) viewer).replace(content.get(index), index);
		} else if (viewer instanceof ListViewer) {
			((ListViewer) viewer).insert(content.get(index), index);
		} else if (viewer instanceof TreeViewer) {
			throw new UnsupportedOperationException(
					"tree viewer not supported (yet)");
		}
	}
}