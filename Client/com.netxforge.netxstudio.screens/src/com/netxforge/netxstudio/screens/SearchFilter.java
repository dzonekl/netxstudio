package com.netxforge.netxstudio.screens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.IEditingService;

public class SearchFilter extends ViewerFilter {

	IEditingService editingService;
	
	@Inject
	public SearchFilter(IEditingService editingService){
		this.editingService = editingService;
	}
	
	
	private String searchString;

	public void setSearchText(String s) {
		// Search must be a substring of the existing value
		this.searchString = ".*" + s + ".*"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement,
			Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}

		if (element instanceof EObject) {

			String match = new AdapterFactoryItemDelegator(
					editingService.getAdapterFactory()).getText(element);
			return match.matches(searchString);
		}
		return false;
	}
}