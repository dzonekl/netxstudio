/*******************************************************************************
 * Copyright (c) Sep 14, 2012 NetXForge.
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
package com.netxforge.screens.editing.base.tables;

import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerRow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;


/**
 * A TreeViewer exposing some internal methods needed for additional tree functionality. 
 * @author Christophe
 *
 */
public class OpenTreeViewer extends TreeViewer{

	public OpenTreeViewer(Composite parent) {
		super(parent);
	}

	public OpenTreeViewer(Composite parent, int style) {
		super(parent, style);
	}

	public OpenTreeViewer(Tree tree) {
		super(tree);
	}
	
	
	
	// Exposing API. 
	public ViewerRow getViewerRowFromItemExposed(Widget item){
		return this.getViewerRowFromItem(item);
	}
	
	public TreePath getTreePathFromItemExposed(Item item) {
		return this.getTreePathFromItem(item);
	}
			
}