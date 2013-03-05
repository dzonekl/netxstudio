package com.netxforge.netxstudio.screens.editing.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;



/**
 * This action selects all entries currently showing in view.
 */
public class SelectAllAction extends Action {

	private StructuredViewer fViewer;


	/**
	 * Creates the action for a TableViewer
	 *
	 * @param viewer the table viewer
	 */
	public SelectAllAction() {
	}

	
	public void updateViewer(StructuredViewer viewer){
		Assert.isNotNull(viewer);
		fViewer= viewer;
	}
	
	private void collectExpandedAndVisible(TreeItem[] items, List<TreeItem> result) {
		for (int i= 0; i < items.length; i++) {
			TreeItem item= items[i];
			if (item.getData() != null) {
				result.add(item);
				if (item.getExpanded()) {
					collectExpandedAndVisible(item.getItems(), result);
				}
			}
		}
	}

	/**
	 * Selects all resources in the view.
	 */
	@Override
	public void run() {
		if (fViewer instanceof TreeViewer) {
			ArrayList<TreeItem> allVisible= new ArrayList<TreeItem>();
			Tree tree= ((TreeViewer) fViewer).getTree();
			collectExpandedAndVisible(tree.getItems(), allVisible);
			tree.setSelection(allVisible.toArray(new TreeItem[allVisible.size()]));
			fViewer.setSelection(fViewer.getSelection());
		} else if (fViewer instanceof TableViewer) {
			((TableViewer) fViewer).getTable().selectAll();
			// force viewer selection change
			fViewer.setSelection(fViewer.getSelection());
		}
	}
}
