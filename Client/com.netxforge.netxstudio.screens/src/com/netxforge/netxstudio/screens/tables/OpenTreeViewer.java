package com.netxforge.netxstudio.screens.tables;

import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerRow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;

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