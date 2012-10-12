package com.netxforge.netxstudio.screens;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.netxforge.netxstudio.generics.Base;

/**
 * Filters objects from type Base, with deleted flag on. 
 * @author Christophe Bouhier
 *
 */
public class DeletedFilter extends ViewerFilter {

//	IEditingService editingService;
	
//	@Inject
//	public DeletedFilter(IEditingService editingService){
//		this.editingService = editingService;
//	}
	
	
//	private String searchString;
//
//	public void setSearchText(String s) {
//		// Search must be a substring of the existing value
//		this.searchString = ".*" + s + ".*"; //$NON-NLS-1$ //$NON-NLS-2$
//	}

	@Override
	public boolean select(Viewer viewer, Object parentElement,
			Object element) {
		if (element instanceof Base) {
			return ((Base) element).isDeleted();
		}
		return false;
	}
}