package com.netxforge.netxstudio.screens.common.tables;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerRow;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerRow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class TreeViewerFocusBlockManager extends SWTFocusBlockManager {

	private static final CellNavigationStrategyExposed TREE_NAVIGATE = new CellNavigationStrategyExposed() {
		public void collapse(ColumnViewer viewer, ViewerCell cellToCollapse,
				Event event) {
			if (cellToCollapse != null) {
				((TreeItem) cellToCollapse.getItem()).setExpanded(false);
			}
		}

		public void expand(ColumnViewer viewer, ViewerCell cellToExpand,
				Event event) {
			if (cellToExpand != null) {
				OpenTreeViewer v = (OpenTreeViewer) viewer;
				v.setExpandedState(v
						.getTreePathFromItemExposed((Item) cellToExpand
								.getItem()), true);
			}
		}

		public boolean isCollapseEvent(ColumnViewer viewer,
				ViewerCell cellToCollapse, Event event) {

			if (cellToCollapse == null) {
				return false;
			}

			return cellToCollapse != null
					&& ((TreeItem) cellToCollapse.getItem()).getExpanded()
					&& event.keyCode == SWT.ARROW_LEFT
					&& isFirstColumnCell(cellToCollapse);
		}

		public boolean isExpandEvent(ColumnViewer viewer,
				ViewerCell cellToExpand, Event event) {

			if (cellToExpand == null) {
				return false;
			}

			return cellToExpand != null
					&& ((TreeItem) cellToExpand.getItem()).getItemCount() > 0
					&& !((TreeItem) cellToExpand.getItem()).getExpanded()
					&& event.keyCode == SWT.ARROW_RIGHT
					&& isFirstColumnCell(cellToExpand);
		}

		private boolean isFirstColumnCell(ViewerCell cell) {
			// CB VisualIndex is not exposed through API, so look for it the TreeViewerRow impl. 
			TreeViewerRow viewerRow = (TreeViewerRow) cell.getViewerRow();
			return viewerRow.getVisualIndex(cell.getColumnIndex()) == 0;
		}
	};

	/**
	 * Create a new manager using a default navigation strategy:
	 * <ul>
	 * <li><code>SWT.ARROW_UP</code>: navigate to cell above</li>
	 * <li><code>SWT.ARROW_DOWN</code>: navigate to cell below</li>
	 * <li><code>SWT.ARROW_RIGHT</code>: on first column (collapses if item is
	 * expanded) else navigate to next visible cell on the right</li>
	 * <li><code>SWT.ARROW_LEFT</code>: on first column (expands if item is
	 * collapsed) else navigate to next visible cell on the left</li>
	 * </ul>
	 * 
	 * @param viewer
	 *            the viewer the manager is bound to
	 * @param focusDrawingDelegate
	 *            the delegate responsible to highlight selected cell
	 */
	public TreeViewerFocusBlockManager(TreeViewer viewer,
			FocusBlockHighlighter focusDrawingDelegate) {
		this(viewer, focusDrawingDelegate, TREE_NAVIGATE);
	}

	/**
	 * Create a new manager with a custom navigation strategy
	 * 
	 * @param viewer
	 *            the viewer the manager is bound to
	 * @param focusDrawingDelegate
	 *            the delegate responsible to highlight selected cell
	 * @param navigationStrategy
	 *            the strategy used to navigate the cells
	 * @since 3.4
	 */
	public TreeViewerFocusBlockManager(TreeViewer viewer,
			FocusBlockHighlighter focusDrawingDelegate,
			CellNavigationStrategyExposed navigationStrategy) {
		super(viewer, focusDrawingDelegate, navigationStrategy);
	}

	ViewerCell getInitialFocusCell() {
		Tree tree = (Tree) getViewer().getControl();

		if (!tree.isDisposed() && tree.getItemCount() > 0
				&& !tree.getTopItem().isDisposed()) {

			OpenTreeViewer v = (OpenTreeViewer) getViewer();
			ViewerRow aViewerRow = v.getViewerRowFromItemExposed(tree
					.getTopItem());
			if (tree.getColumnCount() == 0) {
				return aViewerRow.getCell(0);
			}

			Rectangle clientArea = tree.getClientArea();
			for (int i = 0; i < tree.getColumnCount(); i++) {
				// CB, getWidth() is not available through the API.
				int width = aViewerRow.getBounds(i).width;
				if (width > 0 && columnInVisibleArea(clientArea, aViewerRow, i))
					return aViewerRow.getCell(i);
			}
		}

		return null;
	}

	private boolean columnInVisibleArea(Rectangle clientArea, ViewerRow row,
			int colIndex) {
		return row.getBounds(colIndex).x >= clientArea.x;
	}

	public ViewerCell getFocusCell() {
		ViewerCell cell = super.getFocusCell();
		Tree t = (Tree) getViewer().getControl();

		// It is possible that the selection has changed under the hood
		if (cell != null) {
			if (t.getSelection().length == 1
					&& t.getSelection()[0] != cell.getItem()) {

				OpenTreeViewer v = (OpenTreeViewer) this.getViewer();
				setFocusCell(v.getViewerRowFromItemExposed(t.getSelection()[0])
						.getCell(cell.getColumnIndex()));
			}
		}

		return super.getFocusCell();
	}

	
}
