/*******************************************************************************
 * Copyright (c) Oct 10, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.tables;

import java.util.Comparator;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
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

		private CellLabelProvider labelProvider = null;

		public TableViewerColumn tbvcFor(TableViewer tblViewer,
				String columnName, int width) {
			return tbvcFor(tblViewer, columnName, "", width, -1, null, null, -1);
		}

		public TableViewerColumn tbvcFor(TableViewer tblViewer,
				String columnName, String toolTip, int width) {
			return tbvcFor(tblViewer, columnName, toolTip, width, -1, null,
					null, -1);
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
				String columnName, String toolTip, int width,
				EditingSupport editingSupport) {
			return tbvcFor(tblViewer, columnName, toolTip, width, -1, null,
					null, -1);
		}

		public TableViewerColumn tbvcFor(TableViewer tblViewer,
				String columnName, String toolTip, int width,
				EditingSupport editingSupport, Comparator<T> comparator) {
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

		public TBVC() {
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
//			else {
				// Assume the objects implement comparable by default.
//				@SuppressWarnings("unused")
//				TBVCSorter<T> sorterFor = sorterFor(tblvc);
//			}

			// Column builder, set parameter or default properties.
			TableColumn tblc = tblvc.getColumn();

			tblc.setWidth(width != -1 ? width : DEFAULT_WIDTH);
			tblc.setText(columnName != null ? columnName : DEFAULT_COLUMN_NAME);
			tblc.setToolTipText(toolTip != null ? columnName : "");
			tblc.setAlignment(allignment != -1 ? allignment : SWT.LEFT);
			tblc.setMoveable(moveable);

			if (labelProvider != null) {
				tblvc.setLabelProvider(labelProvider);
			}

			return tblvc;
		}

//		private TBVCSorter<T> sorterFor(TableViewerColumn column) {
//			return new TBVCSorter<T>(column);
//		}

		private TBVCSorter<T> sorterFor(TableViewerColumn column,
				Comparator<T> comparator) {
			return new TBVCSorter<T>(column, comparator);
		}

	}

	/**
	 * Column sorter, which delegates to a comparator if any provided. The value
	 * is obtained from editing support, if installed.
	 * 
	 * @author Christophe
	 * 
	 * @param <T>
	 */
	public class TBVCSorter<T> extends TableViewerColumnSorter {

		private Comparator<T> delegateComparator = null;
		private TableViewerColumn column = null;

		public TBVCSorter(TableViewerColumn column) {
			this(column, null);
		}

		public TBVCSorter(TableViewerColumn column, Comparator<T> comparator) {
			super(column);
			this.column = column;
			this.delegateComparator = comparator;
		}

		@SuppressWarnings({ "unchecked" })
		@Override
		protected int doCompare(Viewer viewer, Object e1, Object e2) {

			int cIndex = -1;
			if (viewer instanceof TableViewer) {
				cIndex = ((TableViewer) viewer).getTable().indexOf(
						column.getColumn());
			}
			if (cIndex == -1) {
				return 0; // Can't compare without an index.
			}

			T value1 = (T) getValue(viewer, e1, cIndex);
			T value2 = (T) getValue(viewer, e2, cIndex);

			if (delegateComparator != null) {
				return delegateComparator.compare(value1, value2);
			}
			
//			if (value1 instanceof Comparable && value2 instanceof Comparable) {
//				return ((Comparable) value1).compareTo(value2);
//			}
			return 0;
		}

		protected Object getValue(Viewer v, Object o, int index) {
			Object value = super.getValue(o);
			if (value == null) {
				if (v instanceof StructuredViewer) {
					IBaseLabelProvider labelProvider = ((StructuredViewer) v)
							.getLabelProvider();
					if (labelProvider instanceof ITableLabelProvider) {
						ITableLabelProvider lp = (ITableLabelProvider) labelProvider;
						value = lp.getColumnText(o, index);
					}
				}
			}
			return value;
		}
	}

	public interface TBVCSorterValueProvider {

		/**
		 * should provide the value of the row Object, supported by the
		 * columnIndex.
		 * 
		 * @param rowObject
		 * @param columnIndex
		 * @return
		 */
		public Object valueOf(Object rowObject, int columnIndex);
	}
	
		
	
	/**
	 * A comparator which checks if the types are Comparables. 
	 * @author Christophe
	 * @param <K>
	 *
	 */
	public static class ComparableComparator<K> implements Comparator<K>{

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public int compare(K o1, K o2) {
			if(o1 instanceof Comparable && o2 instanceof Comparable){
				return ((Comparable) o1).compareTo(o2);
			}
			return 0;
		}
	}
}
