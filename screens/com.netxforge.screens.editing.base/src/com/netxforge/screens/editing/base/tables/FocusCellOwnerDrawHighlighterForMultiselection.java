package com.netxforge.screens.editing.base.tables;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.FocusCellHighlighter;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
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
 * Hack for solving the jface Bug 268135
 * (https://bugs.eclipse.org/bugs/show_bug.cgi?id=268135) [Viewers]
 * [CellEditors] Table with SWT.MULTI and TableViewerEditor problem.
 * 
 * @see FocusCellOwnerDrawHighlighter
 */
public class FocusCellOwnerDrawHighlighterForMultiselection extends
		FocusCellHighlighter {

	/**
	 * Create a new instance which can be passed to a
	 * {@link TreeViewerFocusCellManager}
	 * 
	 * @param viewer
	 *            the viewer
	 */
	public FocusCellOwnerDrawHighlighterForMultiselection(ColumnViewer viewer) {
		super(viewer);
		hookListener(viewer);
	}

	private void markFocusedCell(Event event, ViewerCell cell) {
		Color background = (cell.getControl().isFocusControl()) ? getSelectedCellBackgroundColor(cell)
				: getSelectedCellBackgroundColorNoFocus(cell);
		Color foreground = (cell.getControl().isFocusControl()) ? getSelectedCellForegroundColor(cell)
				: getSelectedCellForegroundColorNoFocus(cell);

		if (foreground != null || background != null
				|| onlyTextHighlighting(cell)) {
			GC gc = event.gc;

			if (background == null) {
				background = cell.getItem().getDisplay()
						.getSystemColor(SWT.COLOR_LIST_SELECTION);
			}

			if (foreground == null) {
				foreground = cell.getItem().getDisplay()
						.getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT);
			}

			gc.setBackground(background);
			gc.setForeground(foreground);

			if (onlyTextHighlighting(cell)) {
				Rectangle area = event.getBounds();
				Rectangle rect = cell.getTextBounds();
				if (rect != null) {
					area.x = rect.x;
				}
				gc.fillRectangle(area);
			} else {
				gc.fillRectangle(event.getBounds());
				
			}
			event.detail &= ~SWT.SELECTED;
		}else{
			drawBorder(event, cell);
		}
		event.detail &= ~SWT.SELECTED;
	}

	private void drawBorder(Event event, ViewerCell cell) {
		Rectangle rect = cell.getBounds();
		Color fg = event.gc.getForeground();
		event.gc.setForeground(event.display.getSystemColor(SWT.COLOR_BLACK));
//		event.gc.drawRectangle(rect.x, rect.y, rect.width-1, rect.height);
		event.gc.drawRoundRectangle(rect.x, rect.y, rect.width-1, rect.height, 3,3);
		event.gc.setForeground(fg);
	}

	private void hookListener(final ColumnViewer viewer) {

		Listener listener = new Listener() {

			public void handleEvent(Event event) {
				if ((event.detail & SWT.SELECTED) > 0) {
					ViewerCell focusCell = getFocusCell();

//					System.out.println("focus cell="
//							+ focusCell.getColumnIndex());

					// try {
					//

					if (viewer instanceof OpenTreeViewer) {
						ViewerRow row = ((OpenTreeViewer) viewer)
								.getViewerRowFromItemExposed(event.item);
						Assert.isNotNull(row,
								"Internal structure invalid. Item without associated row is not possible."); //$NON-NLS-1$

						ViewerCell cell = row.getCell(event.index);
						if (focusCell == null || !cell.equals(focusCell)) {
							removeSelectionInformation(event, cell);
						} else {
							
							// skip if the cell index = 0.
							
							// FIXME, Should prevent focus for index = 0;
							if( event.index > 0){
								markFocusedCell(event, cell);
							}
							
						}
						// } catch (Exception e) {
						// LOGGER.error(e.getLocalizedMessage(), e);
						// }
					}
				}
			}

		};
		viewer.getControl().addListener(SWT.EraseItem, listener);
	}

	/**
	 * The color to use when rendering the background of the selected cell when
	 * the control has the input focus
	 * 
	 * @param cell
	 *            the cell which is colored
	 * @return the color or <code>null</code> to use the default
	 */
	protected Color getSelectedCellBackgroundColor(ViewerCell cell) {
		return null;
	}

	/**
	 * The color to use when rendering the foreground (=text) of the selected
	 * cell when the control has the input focus
	 * 
	 * @param cell
	 *            the cell which is colored
	 * @return the color or <code>null</code> to use the default
	 */
	protected Color getSelectedCellForegroundColor(ViewerCell cell) {
		return null;
	}

	/**
	 * The color to use when rendering the foreground (=text) of the selected
	 * cell when the control has <b>no</b> input focus
	 * 
	 * @param cell
	 *            the cell which is colored
	 * @return the color or <code>null</code> to use the same used when control
	 *         has focus
	 * @since 3.4
	 */
	protected Color getSelectedCellForegroundColorNoFocus(ViewerCell cell) {
		return null;
	}

	/**
	 * The color to use when rendering the background of the selected cell when
	 * the control has <b>no</b> input focus
	 * 
	 * @param cell
	 *            the cell which is colored
	 * @return the color or <code>null</code> to use the same used when control
	 *         has focus
	 * @since 3.4
	 */
	protected Color getSelectedCellBackgroundColorNoFocus(ViewerCell cell) {
		return null;
	}

	/**
	 * Controls whether the whole cell or only the text-area is highlighted
	 * 
	 * @param cell
	 *            the cell which is highlighted
	 * @return <code>true</code> if only the text area should be highlighted
	 * @since 3.4
	 */
	protected boolean onlyTextHighlighting(ViewerCell cell) {
		return false;
	}

	@Override
	protected void focusCellChanged(ViewerCell newCell, ViewerCell oldCell) {
		super.focusCellChanged(newCell, oldCell);
		
		// Redraw new area
		if (newCell != null) {
			Rectangle rect = newCell.getBounds();
			int x = newCell.getColumnIndex() == 0 ? 0 : rect.x;
			int width = newCell.getColumnIndex() == 0 ? rect.x + rect.width
					: rect.width;
			// 1 is a fix for Linux-GTK
			newCell.getControl().redraw(x, rect.y - 1, width, rect.height + 1,
					true);
		}

		if (oldCell != null) {
			Rectangle rect = oldCell.getBounds();
			int x = oldCell.getColumnIndex() == 0 ? 0 : rect.x;
			int width = oldCell.getColumnIndex() == 0 ? rect.x + rect.width
					: rect.width;
			// 1 is a fix for Linux-GTK
			oldCell.getControl().redraw(x, rect.y - 1, width, rect.height + 1,
					true);
		}
	}

	private void removeSelectionInformation(Event event, ViewerCell cell) {
		GC gc = event.gc;
		gc.setBackground(getUnselectedCellBackgroundColor(cell));
		gc.setForeground(getUnselectedCellForegroundColor(cell));
		gc.fillRectangle(event.getBounds());

		event.detail &= ~SWT.SELECTED;
	}

	private Color getUnselectedCellForegroundColor(ViewerCell cell) {
		return cell.getControl().getDisplay().getSystemColor(SWT.COLOR_BLACK);
	}

	private Color getUnselectedCellBackgroundColor(ViewerCell cell) {
		return cell.getControl().getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION);
	}

}