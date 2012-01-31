package com.netxforge.netxstudio.screens.f2;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerRow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;

public class AccessToRowsTreeViewer extends TreeViewer{

	public AccessToRowsTreeViewer(Composite parent) {
		super(parent);
	}

	public AccessToRowsTreeViewer(Composite parent, int style) {
		super(parent, style);
	}

	public AccessToRowsTreeViewer(Tree tree) {
		super(tree);
	}
	
	public ViewerRow getViewerRowFromItemExposed(Widget item){
		return this.getViewerRowFromItem(item);
	}
		
}