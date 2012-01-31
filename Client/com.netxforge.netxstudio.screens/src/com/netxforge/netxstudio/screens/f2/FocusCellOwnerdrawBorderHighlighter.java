package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.FocusCellHighlighter;
import org.eclipse.jface.viewers.TreeViewerFocusCellManager;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerRow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * A concrete implementation of {@link FocusCellHighlighter} using by setting
 * the control into owner draw mode and highlighting the currently selected
 * cell. To make the use this class you should create the control with the
 * {@link SWT#FULL_SELECTION} bit set
 * 
 * This class can be subclassed to configure how the coloring of the selected
 * cell.
 * 
 * @since 3.3
 * 
 */
public class FocusCellOwnerdrawBorderHighlighter extends FocusCellHighlighter {

	private ColumnViewer viewer;
	private int index;
	private Object item;

	/**
	 * Create a new instance which can be passed to a
	 * {@link TreeViewerFocusCellManager}
	 * 
	 * @param viewer
	 *            the viewer
	 */
	public FocusCellOwnerdrawBorderHighlighter(ColumnViewer viewer) {
		super(viewer);
		this.viewer = viewer;
		index = 1;
		hookListener(viewer);
	}

	private void removeSelectionInformation(Event event, ViewerCell cell) {
		GC gc = event.gc;
		gc.setBackground(cell.getViewerRow().getBackground(
				cell.getColumnIndex()));
		gc.setForeground(cell.getViewerRow().getForeground(
				cell.getColumnIndex()));
		gc.fillRectangle(cell.getBounds());
		event.detail &= ~SWT.SELECTED;
	}

	private void hookListener(final ColumnViewer viewer) {

		Listener listener = new Listener() {

			public void handleEvent(Event event) {
				if ((event.detail & SWT.SELECTED) > 0) {
					ViewerCell focusCell = getFocusCell();

					if (viewer instanceof AccessToRowsTreeViewer) {
						ViewerRow row = ((AccessToRowsTreeViewer) viewer)
								.getViewerRowFromItemExposed(event.item);
						// }
						// ViewerRow row =
						// viewer.getViewerRowFromItem(event.item);

						Assert.isNotNull(row,
								"Internal structure invalid. Item without associated row is not possible."); //$NON-NLS-1$

						ViewerCell cell = row.getCell(event.index);

						if (focusCell == null || !cell.equals(focusCell)) {
							// removeSelectionInformation(event, cell);
						} else {
							removeSelectionInformation(event, cell);
							drawBorder(event, cell);
							notifyTraverse(event);
						}
					}
				}
			}

		};
		viewer.getControl().addListener(SWT.EraseItem, listener);
	}

	private void drawBorder(Event event, ViewerCell cell) {
		Rectangle rect = cell.getBounds();
		Color fg = event.gc.getForeground();
		event.gc.setForeground(event.display.getSystemColor(SWT.COLOR_BLACK));
		event.gc.drawRectangle(rect.x, rect.y, rect.width - 1, rect.height - 1);
		event.gc.setForeground(fg);
	}

	protected void focusCellChanged(ViewerCell newCell, ViewerCell oldCell) {
		super.focusCellChanged(newCell, oldCell);

		// Redraw new area
		redrawCellArea(newCell);

		// Redraw old area
		redrawCellArea(oldCell);

	}

	protected void redrawCellArea(ViewerCell cell) {
		if (cell == null)
			return;

		Rectangle rect = cell.getBounds();
		int x = cell.getColumnIndex() == 0 ? 0 : rect.x;
		int width = cell.getColumnIndex() == 0 ? rect.x + rect.width
				: rect.width;
		// 1 is a fix for Linux-GTK
		cell.getControl().redraw(x, rect.y - 1, width, rect.height + 1, true);
	}

	/**
	 * Send event to viewer's control (SWT.Traverse)
	 * 
	 * @param event
	 */
	protected void notifyTraverse(Event event) {
		if (event.index != index || event.item != item) {
			index = event.index;
			item = event.item;
			viewer.getControl().notifyListeners(SWT.Traverse, event);
		}
	}
}