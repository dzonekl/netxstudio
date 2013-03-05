package com.netxforge.netxstudio.screens.tables;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ViewerCell;

/**
 * @since 3.3
 *
 */
public abstract class FocusBlockHighlighter {
	private ColumnViewer viewer;
	private SWTFocusBlockManager mgr;

	/**
	 * @param viewer
	 */
	public FocusBlockHighlighter(ColumnViewer viewer) {
		this.viewer = viewer;
	}

	void setMgr(SWTFocusBlockManager mgr) {
		this.mgr = mgr;
	}
	
	/**
	 * @return the focus cell
	 */
	public ViewerCell getFocusCell() {
		// Mgr is normally not null because the highlighter is passed
		// to the SWTFocusCellManager instance
		if( mgr != null ) {
		    // Use this method because it ensure that no
		    // cell update (which might cause scrolling) happens 
			return mgr._getFocusCell();
		}
		
		return viewer.getColumnViewerEditor().getFocusCell();
	}

	
	/**
	 * Return the focus block or null;
	 * @return
	 */
	public ViewerCell[] getFocusBlock() {
		// Mgr is normally not null because the highlighter is passed
		// to the SWTFocusCellManager instance
		if( mgr != null ) {
		    // Use this method because it ensure that no
		    // cell update (which might cause scrolling) happens 
			return mgr._getFocusBlock();
		}
		return null;
	}

	
	/**
	 * Called by the framework when the focus cell has changed. Subclasses may
	 * extend.
	 * <p>
	 * <b>The default implementation for this method calls
	 * focusCellChanged(ViewerCell). Subclasses should override this method
	 * rather than {@link #focusCellChanged(ViewerCell)} .</b>
	 *
	 * @param newCell
	 *            the new focus cell or <code>null</code> if no new cell
	 *            receives the focus
	 * @param oldCell
	 *            the old focus cell or <code>null</code> if no cell has been
	 *            focused before
	 * @since 3.4
	 */
	protected void focusCellChanged(ViewerCell newCell, ViewerCell oldCell) {
		// do nothing, clients should extend. 
	}
	
	protected void focusBlockChanged(ViewerCell[] newBlock, ViewerCell[] oldBlock) {
		// do nothing, clients should extend. 
	}

	/**
	 * This method is called by the framework to initialize this cell
	 * highlighter object. Subclasses may extend.
	 */
	protected void init() {
	}
}
