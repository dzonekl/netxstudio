package com.netxforge.netxstudio.screens.tables;

import java.util.Comparator;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.TableViewerColumnSorter;

/**
 * A convenience class for creating tables. Column sorters, are based on
 * standard comparators which can be obtained from modelUtils.
 * 
 * @author Christophe Bouhier
 * 
 */
public class TableHelper {

	/**
	 * For the comparator type to an Object.
	 * 
	 * @param tblViewer
	 * @param numOfColumns
	 * @param columnNames
	 * @param toolTips
	 * @param widths
	 * @param allignments
	 * @param editingSupports
	 * @param comparators
	 * @param sortingDirections
	 * @return
	 */
	public TableViewerColumn[] columnsFor(TableViewer tblViewer,
			int numOfColumns, String[] columnNames, String[] toolTips,
			int[] widths, int[] allignments, EditingSupport[] editingSupports,
			Comparator<Object>[] comparators, int[] sortingDirections) {

		TableViewerColumn[] tbvcs = new TableViewerColumn[numOfColumns];
		for (int i = 0; i < numOfColumns; i++) {
			tbvcs[i] = new TBVC<Object>(null).tbvcFor(tblViewer,
					columnNames != null ? columnNames[i] : null,
					toolTips != null ? toolTips[i] : null,
					widths != null ? widths[i] : -1,
					allignments != null ? allignments[i] : -1,
					editingSupports != null ? editingSupports[i] : null,
					comparators != null ? comparators[i] : null,
					sortingDirections != null ? sortingDirections[i] : -1);
		}
		return tbvcs;
	}

	/**
	 * Type tableviewer Column, expecting a type which should match the
	 * comparator type (Used for building a TableViewerColumnSorter.
	 * 
	 * @author Christophe Bouhier
	 * 
	 * @param <T>
	 */
	public class TBVC<T> {

		// The default column name.
		private static final String DEFAULT_COLUMN_NAME = "<?>";

		// The default column width.
		private static final int DEFAULT_WIDTH = 150;

		private CellLabelProvider labelProvider;

		public TableViewerColumn tbvcFor(TableViewer tblViewer,
				String columnName, int width) {
			return tbvcFor(tblViewer, columnName, "", width, -1, null, null, -1);
		}

		public TableViewerColumn tbvcFor(TableViewer tblViewer,
				String columnName, String toolTip, int width) {
			return tbvcFor(tblViewer, columnName, toolTip, width, -1, null, null, -1);
		}

		
		public TableViewerColumn tbvcFor(TableViewer tblViewer,
				String columnName, int width, Comparator<T> comparator) {
			return tbvcFor(tblViewer, columnName, "", width, -1, null,
					comparator, -1);
		}

		public TableViewerColumn tbvcFor(TableViewer tblViewer,
				String columnName, String toolTip, int width,
				Comparator<T> comparator) {
			return tbvcFor(tblViewer, columnName, toolTip, width, -1, null,
					comparator, -1);
		}

		public TableViewerColumn tbvcFor(TableViewer tblViewer,
				String columnName, String toolTip, int width, int allignment,
				EditingSupport editingSupport, Comparator<T> comparator,
				int sortingDirection) {

			return buildColumn(tblViewer, columnName, toolTip, width,
					allignment, true, editingSupport, comparator, -1);
		}

		public TBVC(CellLabelProvider labelProvider) {
			this.labelProvider = labelProvider;
		}
		
		
		// BUILDERS
		private TableViewerColumn buildColumn(TableViewer tblViewer,
				String columnName, String toolTip, int width, int allignment,
				boolean moveable, EditingSupport editingSupport,
				Comparator<T> comparator, int sortingDirection) {

			// Note label provider should be re-installed, when deleting
			// columns.

			TableViewerColumn tblvc = new TableViewerColumn(tblViewer, SWT.NONE);

			// Optional Editing support.
			if (editingSupport != null) {
				tblvc.setEditingSupport(editingSupport);
			}

			// Optional Sorting support.
			if (comparator != null) {
				@SuppressWarnings("unused")
				TBVCSorter<T> sorterFor = sorterFor(tblvc, comparator);
				// sorterFor.setSorter(sortingDirection != -1 ? sortingDirection
				// : TBVCSorter.ASC);
			}

			// Column builder, set parameter or default properties.
			TableColumn tblc = tblvc.getColumn();

			tblc.setWidth(width != -1 ? width : DEFAULT_WIDTH);
			tblc.setText(columnName != null ? columnName : DEFAULT_COLUMN_NAME);
			tblc.setToolTipText(toolTip != null ? columnName : "");
			tblc.setAlignment(allignment != -1 ? allignment : SWT.RIGHT);
			tblc.setMoveable(moveable);

			if(labelProvider != null){
				tblvc.setLabelProvider(labelProvider);
			}
			
			return tblvc;
		}

		private TBVCSorter<T> sorterFor(TableViewerColumn column,
				Comparator<T> comparator) {
			return new TBVCSorter<T>(column, comparator);
		}

	}

	
	/**
	 * Column sorter, which delegates to a comparator if any provided.
	 * 
	 * @author Christophe
	 * 
	 * @param <T>
	 */
	public class TBVCSorter<T> extends TableViewerColumnSorter {

		private Comparator<T> delegateComparator;

		public TBVCSorter(TableViewerColumn column, Comparator<T> comparator) {
			super(column);
			this.delegateComparator = comparator;
			
		}
		
		@SuppressWarnings("unchecked")
		@Override
		protected int doCompare(Viewer viewer, Object e1, Object e2) {
			if (delegateComparator != null) {
				return delegateComparator.compare((T)e1, (T)e2);
			}
			return super.doCompare(viewer, e1, e2);
		}
		
	}
	
	public interface TBVCSorterValueProvider {
		
		/**
		 * should provide the value of the row Object, supported by the columnIndex.
		 * @param rowObject
		 * @param columnIndex
		 * @return
		 */
		public Object valueOf(Object rowObject, int columnIndex );
	}
	
	
	

}
