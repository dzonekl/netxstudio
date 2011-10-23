package com.netxforge.netxstudio.screens;

import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;


/**
 * Only filter items on a specified column. 
 * 
 * @author dzonekl
 *
 */
public class TableColumnFilter extends ViewerFilter {

	
	public static final String COLUMN_FILTER = "column.filter.";

	private TableColumn column;

	public TableColumnFilter(TableColumn column) {
		this.column = column;
	}

	private String searchString;
	
	
	@Override
	public boolean isFilterProperty(Object element, String property) {
		
		// Potential use the property firing to enable/disable a filter. 
		
		String columnProperty = COLUMN_FILTER.concat(column.getText());
		if( property.equals(columnProperty)){
			return true;
		}else{
			// Disable the filter by default. 
			return false;
//			return super.isFilterProperty(element, property);
		}
	}

	public void setFilterText(String s) {
		// Search must be a substring of the existing value
		this.searchString = ".*" + s + ".*"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		boolean result = true;
		
		if (element instanceof EObject) {
			
			// Get the n'th column matching the provided column. 
			if( viewer instanceof TableViewer){
				Table table = ((TableViewer) viewer).getTable();
				int targetColumnIndex = table.indexOf(column);
				
				// Blindly cast to ITableLabelProvider, we could also use EditingSupport instead to get the edited 
				// value. 
				ITableLabelProvider labelProvider = (ITableLabelProvider) ((TableViewer) viewer).getLabelProvider();
				String match = labelProvider.getColumnText(element, targetColumnIndex);
				
				try {
					result = match.matches(searchString);
					if(result){
					System.out.println("Searchsstring: match for: " + searchString + " on: " + match);
					}
				} catch (PatternSyntaxException pse) {
					pse.printStackTrace();
				}
			}
		}
		return result;
	}
}