package com.netxforge.netxstudio.screens;

import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.IEditingService;

/**
 * The matching text, will be from the ItemProvider of the EObject. FIXME Make
 * sure the type name is not returned from the ItemProvider.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class SearchFilter extends ViewerFilter {

	IEditingService editingService;

	@Inject
	public SearchFilter(IEditingService editingService) {
		this.editingService = editingService;
	}

	private String searchString;

	public void setSearchText(String s) {
		// Search must be a substring of the existing value
		this.searchString = ".*" + s + ".*"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		boolean result = true;

		// Loop to the children, as we are called for the root only.

		if (element instanceof EObject) {

			String match = new AdapterFactoryItemDelegator(
					editingService.getAdapterFactory()).getText(element);

			System.out.println("String for element=" + element + " text="
					+ match);
			try {
				result = match.matches(searchString);
				if (result) {
					System.out.println("Searchsstring: match for: "
							+ searchString + " on: " + match);
				}
			} catch (PatternSyntaxException pse) {
				pse.printStackTrace();
			}
		}

		return result;
	}
}