package com.netxforge.netxstudio.screens.editing.filter;

import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
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
public class TreeSearchFilter extends ViewerFilter {

	IEditingService editingService;

	@Inject
	public TreeSearchFilter(IEditingService editingService) {
		this.editingService = editingService;
	}

	private String searchString;

	public void setSearchText(String s) {
		// Search must be a substring of the existing value
		this.searchString = ".*" + s + ".*"; //$NON-NLS-1$ //$NON-NLS-2$
	}
	

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.equals(".*.*")) {
			return true;
		}
		boolean result = true;
		
		// When using Databinding the parent will be something else than an eobject. 
		if(element instanceof EObject){
			String match = new AdapterFactoryItemDelegator(
					editingService.getAdapterFactory()).getText(element);

			System.out.println("String for element=" + element + " text="
					+ match);
			try {
				result = match.matches(searchString);
//				if (result) {
//					System.out.println("Searchsstring: match for: "
//							+ searchString + " on: " + match);
//				}
				// If we don't have a positive result, consider the children of the
				if (!result) {
					StructuredViewer sviewer = (StructuredViewer) viewer;
					ITreeContentProvider provider = (ITreeContentProvider) sviewer
							.getContentProvider();
					for (Object child : provider.getChildren(element)) {
						if (select(viewer, element, child)){
							return true;
						}
					}
				}
			} catch (PatternSyntaxException pse) {
				pse.printStackTrace();
			}

		}
		return result;
	}
}