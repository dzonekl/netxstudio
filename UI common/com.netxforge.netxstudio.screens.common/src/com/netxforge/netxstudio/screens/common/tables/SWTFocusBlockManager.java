package com.netxforge.netxstudio.screens.common.tables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerRow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.ACC;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * This class is responsible to provide cell management base features for the
 * SWT-Controls {@link org.eclipse.swt.widgets.Table} and
 * {@link org.eclipse.swt.widgets.Tree}.
 * 
 * @since 3.3
 * 
 */
abstract class SWTFocusBlockManager {

	private CellNavigationStrategyExposed navigationStrategy;

	private ColumnViewer viewer;

	// Consider putting this in the block.
	private ViewerCell focusCell;

	// The cells which are below the selection.
	private List<ViewerCell> focusBlock = new ArrayList<ViewerCell>();

	// Our focus block highlighter.
	private FocusBlockHighlighter cellHighlighter;

	private DisposeListener itemDeletionListener = new DisposeListener() {

		public void widgetDisposed(DisposeEvent e) {
			setFocusCell(null);
		}

	};

	/*
	 * The command which will execute the drag copy.
	 */
	private CopyFeatureCommand copyFeatureCommand;

	/*
	 * The editing domain holding the stack and resource set.
	 */
	private EditingDomain editingDomain;

	/*
	 * The feature to drag copy.
	 */
	private FocusColumnToModelMap featureMap;

	/*
	 * dragging state.
	 */
	private boolean cellDragging;

	/**
	 * @param viewer
	 * @param focusDrawingDelegate
	 * @param navigationDelegate
	 */
	public SWTFocusBlockManager(ColumnViewer viewer,
			FocusBlockHighlighter focusDrawingDelegate,
			CellNavigationStrategyExposed navigationDelegate) {
		this.viewer = viewer;
		this.cellHighlighter = focusDrawingDelegate;
		if (this.cellHighlighter != null) {
			this.cellHighlighter.setMgr(this);
		}

		this.navigationStrategy = navigationDelegate;
		hookListener(viewer);
	}

	/**
	 * This method is called by the framework to initialize this cell manager.
	 */
	void init() {
		this.cellHighlighter.init();
		this.navigationStrategy.init();
	}

	private void handleMouseDown(Event event) {

		ViewerCell cell = viewer.getCell(new Point(event.x, event.y));
		if (cell != null) {
			if (!cell.equals(focusCell)) {
				setFocusCell(cell);

			}
		}
		cleanFocusBlock(focusCell);
		cellDragging = true;
		System.out
				.println(" moving down, activate cell dragging, block size = "
						+ focusBlock.size());
	}

	private void handleMouseMove(Event event) {

		if (cellDragging) {
			System.out.println(" dragging mouse" + event.x + "," + event.y);
			handleCellDragging(event);
		} else {
			// we are not dragging, do nothing.
			System.out.println(" moving mouse" + event.x + "," + event.y);
			// Show the cursor if the position is at the bottom, right.
		}
	}

	private void handleCellDragging(Event event) {

		// in the new position, look if we are the focus cell,
		// if not, add to our cell blow only if we are the below neighbour...
		ViewerCell cell = viewer.getCell(new Point(event.x, event.y));

		if (cell != null) {

			if (!lastInFocusBlock(cell)) {
				// if we are not the last cell, but we are in the block, we
				// should get the position
				// to remove other cells..
				if (inFocusBlock(cell)) {
					cleanFocusBlock(cell);
					System.out.println("Dragging....removing cell in column:"
							+ cell.getVisualIndex() + " size of block = "
							+ focusBlock.size());
				} else {

					// we can add it now.
					// do this for the last cell, not last focus cell.
					ViewerCell belowNeighborCell = lastCellInBlock()
							.getNeighbor(ViewerCell.BELOW, false);
					if (cell.equals(belowNeighborCell)) {
						addCellToBlock(cell);
						System.out.println("Dragging....Adding cell in column:"
								+ cell.getVisualIndex() + " size of block = "
								+ focusBlock.size());
					}
				}
			} else {
				// last cell in the block do nothing...
			}
		}
	}

	private void cleanFocusBlock(ViewerCell cell) {

		if (focusBlock.isEmpty()) {
			// do nothing, we always have the focus cell.
		} else {
			// remember the old block for the highlighter to repaint.
			ViewerCell[] oldBlock = block();
			// When we are the focus cell, we should clean the block.
			if (focusCell.equals(cell)) {
				// System.out.println("Dragging....Clearing cells:"
				// + cell.getVisualIndex());
				focusBlock.clear();
				cellHighlighter.focusBlockChanged(null, oldBlock);
				updateCommand();

			} else if (focusBlock.contains(cell)) {
				int indexOf = focusBlock.indexOf(cell);
				Collection<ViewerCell> retain = new ArrayList<ViewerCell>();
				// Note pre-increment, to get the first item from the list index
				// 0.
				for (int i = -1; i < indexOf; i++) {
					retain.add(focusBlock.get(i + 1));
				}
				focusBlock.retainAll(retain);
				// System.out.println("Dragging....Clearing cells:"
				// + cell.getVisualIndex());
				ViewerCell[] newBlock = block();
				cellHighlighter.focusBlockChanged(newBlock, oldBlock);
				updateCommand();
			}
		}
	}

	private void updateCommand() {

		if (!initialized()) {
			System.out
					.println("command can't be created, command creation not initialized");
			// dispose the command. 
			if (copyFeatureCommand != null) {
				copyFeatureCommand.dispose();
				copyFeatureCommand = null;
			}
			return;
		} else {
			if (copyFeatureCommand == null) {
				EStructuralFeature feature = mapColumnToFeature(focusCell
						.getColumnIndex());
				EObject element = (EObject) focusCell.getElement();
				copyFeatureCommand = new CopyFeatureCommand(editingDomain,
						element, feature, new CopyFeatureCommand.Helper());

			} else {
				System.out
						.println("TODO, update the command with target objects");
				// TODO, add drag targets here.
			}
		}
	}

	/*
	 * We need a focus cell, an editing domain, a feature
	 */
	private boolean initialized() {
		if (editingDomain == null | featureMap == null
				| featureMap.getColumnFeatureMap().isEmpty()) {
			return false;
		}
		if (focusCell != null && focusCell.getElement() instanceof EObject) {
			// Make sure the feature is a feature for the focus object.
			EStructuralFeature feature = mapColumnToFeature(focusCell
					.getColumnIndex());
			EObject element = (EObject) focusCell.getElement();
			if (element.eClass().getEAllStructuralFeatures().contains(feature)) {
				return true;
			}
		}
		return false;
	}

	private EStructuralFeature mapColumnToFeature(int columnIndex) {
		return featureMap.getColumnFeatureMap().get(columnIndex);
	}

	private ViewerCell[] block() {
		ViewerCell[] block = null;
		if (!focusBlock.isEmpty()) {
			block = new ViewerCell[focusBlock.size()];
			focusBlock.toArray(block);
		}
		return block;
	}

	private boolean lastInFocusBlock(ViewerCell cell) {
		// return the focus cell equality or the the last cell in the focus
		// block equality.
		return lastCellInBlock().equals(cell);
	}

	private boolean inFocusBlock(ViewerCell cell) {
		return focusCell.equals(cell) || focusBlock.contains(cell);
	}

	private ViewerCell lastCellInBlock() {
		if (focusBlock.isEmpty()) {
			return focusCell;
		} else {
			return focusBlock.get(focusBlock.size() == 1 ? 0 : focusBlock
					.size() - 1);
		}
	}

	private void addCellToBlock(ViewerCell cell) {

		if (!focusBlock.contains(cell)) {
			ViewerCell[] oldBlock = new ViewerCell[focusBlock.size()];
			focusBlock.toArray(oldBlock);
			focusBlock.add(cell);

			ViewerCell[] newBlock = new ViewerCell[focusBlock.size()];
			focusBlock.toArray(newBlock);
			cellHighlighter.focusBlockChanged(newBlock, oldBlock);
			updateCommand();
		}
	}

	private void handleMouseUp(Event event) {
		System.out.println(" mouse up, disable dragging");
		if (cellDragging && copyFeatureCommand != null) {
			System.out.println(" Executing copy command");
			copyFeatureCommand.execute();
		}
		this.cellDragging = false;
	}

	private void handleKeyDown(Event event) {
		ViewerCell tmp = null;

		if (navigationStrategy.isCollapseEvent(viewer, focusCell, event)) {
			navigationStrategy.collapse(viewer, focusCell, event);
		} else if (navigationStrategy.isExpandEvent(viewer, focusCell, event)) {
			navigationStrategy.expand(viewer, focusCell, event);
		} else if (navigationStrategy.isNavigationEvent(viewer, event)) {
			tmp = navigationStrategy.findSelectedCell(viewer, focusCell, event);

			if (tmp != null) {
				if (!tmp.equals(focusCell)) {
					setFocusCell(tmp);
				}
			}
		}

		if (navigationStrategy.shouldCancelEvent(viewer, event)) {
			event.doit = false;
		}
	}

	private void handleSelection(Event event) {
		// ignore while dragging.
		if (cellDragging) {
			return;
		}

		if ((event.detail & SWT.CHECK) == 0 && focusCell != null
				&& focusCell.getItem() != event.item && event.item != null
				&& !event.item.isDisposed()) {
			if (viewer instanceof OpenTreeViewer) {
				OpenTreeViewer atrViewer = (OpenTreeViewer) viewer;
				ViewerRow row = atrViewer
						.getViewerRowFromItemExposed(event.item);
				Assert.isNotNull(row,
						"Internal Structure invalid. Row item has no row ViewerRow assigned"); //$NON-NLS-1$

				// CB TODO, update to sync our focus block.
				ViewerCell tmp = row.getCell(focusCell.getColumnIndex());
				if (!focusCell.equals(tmp)) {
					setFocusCell(tmp);
				}
			}
		}
	}

	/**
	 * Handles the {@link SWT#FocusIn} event.
	 * 
	 * @param event
	 *            the event
	 */
	private void handleFocusIn(Event event) {
		if (focusCell == null) {
			setFocusCell(getInitialFocusCell());
		}
	}

	abstract ViewerCell getInitialFocusCell();

	private void hookListener(final ColumnViewer viewer) {
		Listener listener = new Listener() {

			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.MouseDown:
					handleMouseDown(event);
					break;
				case SWT.MouseMove:
					handleMouseMove(event);
					break;
				case SWT.MouseUp:
					handleMouseUp(event);
					break;
				case SWT.KeyDown:
					handleKeyDown(event);
					break;
				case SWT.Selection:
					handleSelection(event);
					break;
				case SWT.FocusIn:
					handleFocusIn(event);
					break;
				}
			}

		};

		viewer.getControl().addListener(SWT.MouseDown, listener);
		viewer.getControl().addListener(SWT.MouseUp, listener);
		viewer.getControl().addListener(SWT.MouseMove, listener);
		viewer.getControl().addListener(SWT.KeyDown, listener);
		viewer.getControl().addListener(SWT.Selection, listener);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection().isEmpty()) {
					setFocusCell(null);
				}
			}

		});
		viewer.getControl().addListener(SWT.FocusIn, listener);

		// Disable accessibility as we do not have access to the viewer column.
		// viewer.getControl().getAccessible()
		// .addAccessibleListener(new AccessibleAdapter() {
		// public void getName(AccessibleEvent event) {
		// ViewerCell cell = getFocusCell();
		// if (cell == null)
		// return;
		//
		// ViewerRow row = cell.getViewerRow();
		// if (row == null)
		// return;
		//
		// ViewerColumn viewPart = viewer.getViewerColumn(cell
		// .getColumnIndex());
		//
		// if (viewPart == null)
		// return;
		//
		// CellLabelProvider labelProvider = viewPart
		// .getLabelProvider();
		//
		// if (labelProvider == null)
		// return;
		// labelProvider.update(cell);
		// event.result = cell.getText();
		// }
		// });

	}

	/**
	 * @return the cell with the focus
	 * 
	 */
	public ViewerCell getFocusCell() {
		return focusCell;
	}

	final ViewerCell _getFocusCell() {
		return focusCell;
	}

	// Get the focus block, excluding the focus cell itself.
	final ViewerCell[] _getFocusBlock() {
		ViewerCell[] focusBlockArray = new ViewerCell[focusBlock.size()];
		return focusBlock.toArray(focusBlockArray);
	}

	void setFocusCell(ViewerCell focusCell) {
		ViewerCell oldCell = this.focusCell;

		if (this.focusCell != null && !this.focusCell.getItem().isDisposed()) {
			this.focusCell.getItem()
					.removeDisposeListener(itemDeletionListener);
		}

		this.focusCell = focusCell;

		if (this.focusCell != null && !this.focusCell.getItem().isDisposed()) {
			this.focusCell.getItem().addDisposeListener(itemDeletionListener);
		}

		if (focusCell != null) {
			focusCell.scrollIntoView();
		}
		this.cellHighlighter.focusCellChanged(focusCell, oldCell);
		updateCommand();
		getViewer().getControl().getAccessible().setFocus(ACC.CHILDID_SELF);
	}

	ColumnViewer getViewer() {
		return viewer;
	}

	/**
	 * @return the editingDomain
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @param editingDomain
	 *            the editingDomain to set
	 */
	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * @param focusColumnToModelMap
	 *            the feature to set
	 */
	public void setFeatureMap(FocusColumnToModelMap focusColumnToModelMap) {
		this.featureMap = focusColumnToModelMap;
	}
}
