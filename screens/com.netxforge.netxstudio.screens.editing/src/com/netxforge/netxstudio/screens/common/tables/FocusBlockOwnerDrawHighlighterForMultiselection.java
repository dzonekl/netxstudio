/*******************************************************************************
 * Copyright (c) 6 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.common.tables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ColumnViewer;
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
public class FocusBlockOwnerDrawHighlighterForMultiselection extends
		FocusBlockHighlighter {

	/**
	 * Create a new instance which can be passed to a
	 * {@link TreeViewerFocusCellManager}
	 * 
	 * @param viewer
	 *            the viewer
	 */
	public FocusBlockOwnerDrawHighlighterForMultiselection(ColumnViewer viewer) {
		super(viewer);
		hookListener(viewer);
	}

	private void markFocusedBlock(Event event, List<ViewerCell> block) {

		// iterate through the cell, and draw a rectangle.
		for (ViewerCell cell : block) {
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

			}
		}
		drawBorder(event, block);
		event.detail &= ~SWT.SELECTED;
	}

	private void drawBorder(Event event, List<ViewerCell> block) {

		Rectangle allCellsRectangle = null;

		for (ViewerCell cell : block) {
			Rectangle rect = cell.getBounds();
			if (allCellsRectangle == null) {
				allCellsRectangle = rect;
			} else {
				allCellsRectangle.add(rect);
			}
		}

		Color fg = event.gc.getForeground();
		event.gc.setForeground(event.display.getSystemColor(SWT.COLOR_BLACK));

		// Rectangle originalClipping = event.gc.getClipping();

		// Adapt the clipping, as we draw outside the bounds of the cell.
		// allCellsRectangle.x = allCellsRectangle.x - 2;
		// allCellsRectangle.y = allCellsRectangle.y - 2;
		// allCellsRectangle.height = allCellsRectangle.height + 6;
		// allCellsRectangle.width = allCellsRectangle.width + 6;

		// event.gc.setClipping(allCellsRectangle);
		event.gc.drawRoundRectangle(allCellsRectangle.x, allCellsRectangle.y,
				allCellsRectangle.width - 1, allCellsRectangle.height - 1, 3, 3);

		// event.gc.setClipping(originalClipping);
		event.gc.setForeground(fg);
	}

	private void hookListener(final ColumnViewer viewer) {
		Listener listener = new Listener() {

			public void handleEvent(Event event) {

				// System.out.println("Event index = " + event.index
				// + " coordinates = " + event.x + "," + event.y + ","
				// + event.width + "," + event.height);
				//

				if ((event.detail & SWT.SELECTED) > 0) {
					List<ViewerCell> allCells = new ArrayList<ViewerCell>();
					ViewerCell focusCell = getFocusCell();
					if (focusCell != null)
						allCells.add(focusCell);

					// add the block to the focus cell, and mark in one go.
					ViewerCell[] focusBlock = getFocusBlock();
					if (focusBlock.length > 0) {
						allCells.addAll(Arrays.asList(focusBlock));
					}

					if (viewer instanceof OpenTreeViewer) {
						ViewerRow row = ((OpenTreeViewer) viewer)
								.getViewerRowFromItemExposed(event.item);
						Assert.isNotNull(row,
								"Internal structure invalid. Item without associated row is not possible."); //$NON-NLS-1$

						// Remove selection if our cell is mot in the block.
						ViewerCell cell = row.getCell(event.index);
						if (focusCell == null || !allCells.contains(cell)) {
							removeSelectionInformation(event, cell);
						} else {

							// skip if the cell index = 0.
							// FIXME, Should prevent focus for index = 0;
							if (event.index > 0) {
								markFocusedBlock(event, allCells);
							}

						}
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
		return cell.getControl().getDisplay().getSystemColor(SWT.COLOR_WHITE);
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
		return cell.getControl().getDisplay().getSystemColor(SWT.COLOR_BLACK);
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
		// return cell.getControl().getDisplay().getSystemColor(SWT.COLOR_GRAY);
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

		// System.out
		// .println("FocusBlockOwnerDrawHighlighter => focus cell changed");

		// Redraw new area
		if (newCell != null) {
			redrawCell(newCell);
		}

		if (oldCell != null) {
			redrawCell(oldCell);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.tables.FocusBlockHighlighter#
	 * focusBlockChanged(org.eclipse.jface.viewers.ViewerCell[],
	 * org.eclipse.jface.viewers.ViewerCell[])
	 */
	@Override
	protected void focusBlockChanged(ViewerCell[] newBlock,
			ViewerCell[] oldBlock) {
		super.focusBlockChanged(newBlock, oldBlock);

		// Fire only what update on the viewer.

		if (newBlock != null) {
			for (ViewerCell cell : newBlock) {
				redrawCell(cell);
			}
		}
		if (oldBlock != null) {
			for (ViewerCell cell : oldBlock) {
				redrawCell(cell);
			}
		}
	}

	private void redrawCell(ViewerCell redrawCell) {
		Rectangle rect = redrawCell.getBounds();

		int x = redrawCell.getColumnIndex() == 0 ? 0 : rect.x;
		int width = redrawCell.getColumnIndex() == 0 ? rect.x + rect.width
				: rect.width;

		// int y = (rect.y + 1);
		// System.out.println("redraw viewercell horizontal from " + x + " to "
		// + (x + width));
		// System.out.println("redraw viewercell vertical from " + y + " to "
		// + (y + rect.height));

		// 1 is a fix for Linux-GTK
		redrawCell.getControl().redraw(x, rect.y - 1, width, rect.height + 1,
				true);
	}

	//
	// private void redrawBlock(ViewerCell[] redrawCells) {
	// // Rectangle rect = redrawCell.getBounds();
	//
	// Rectangle allCellsRectangle = null;
	//
	// for (ViewerCell cell : redrawCells) {
	// Rectangle rect = cell.getBounds();
	// if (allCellsRectangle == null) {
	// allCellsRectangle = rect;
	// } else {
	// allCellsRectangle.add(rect);
	// }
	// }
	//
	// // int x = redrawCell.getColumnIndex() == 0 ? 0 : rect.x;
	// // int width = redrawCell.getColumnIndex() == 0 ? rect.x + rect.width
	// // : rect.width;
	//
	// int y = (allCellsRectangle.y + 1);
	//
	// // System.out.println("redraw viewercell horizontal from " + x + " to "
	// // +( x + width) );
	// // System.out.println("redraw viewercell vertical from " + y + " to " +
	// // ( y
	// // + rect.height) );
	//
	// // 1 is a fix for Linux-GTK
	// viewer.getControl().redraw(allCellsRectangle.x,
	// allCellsRectangle.y - 1, allCellsRectangle.width,
	// allCellsRectangle.height + 1, true);
	// }

	private void removeSelectionInformation(Event event, ViewerCell cell) {
		GC gc = event.gc;
		gc.setBackground(getUnselectedCellBackgroundColor(cell));
		gc.setForeground(getUnselectedCellForegroundColor(cell));
		gc.fillRectangle(cell.getBounds());

		event.detail &= ~SWT.SELECTED;
	}

	private Color getUnselectedCellForegroundColor(ViewerCell cell) {
		return cell.getControl().getDisplay().getSystemColor(SWT.COLOR_BLACK);
	}

	private Color getUnselectedCellBackgroundColor(ViewerCell cell) {
		return cell.getControl().getDisplay()
				.getSystemColor(SWT.COLOR_LIST_SELECTION);
	}

}