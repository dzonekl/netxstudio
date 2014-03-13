package com.netxforge.screens.editing.base.filter;

import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;

/**
 * The matching text, will be from the ItemProvider of the EObject. Make sure
 * the type name is not returned from the ItemProvider.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class TreeSearchFilter extends SearchFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		String searchString = getSearchString();
		if (searchString == null || searchString.equals(".*.*")) {
			return true;
		}
		boolean result = true;

		// When using Databinding the parent will be something else than an
		// eobject.
		if (element instanceof EObject) {
			String match = getMatch(element);

			try {
				result = match.matches(searchString);
				// If we don't have a positive result, consider the children of
				// the
				if (!result) {
					StructuredViewer sviewer = (StructuredViewer) viewer;
					ITreeContentProvider provider = (ITreeContentProvider) sviewer
							.getContentProvider();
					for (Object child : provider.getChildren(element)) {
						if (select(viewer, element, child)) {
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