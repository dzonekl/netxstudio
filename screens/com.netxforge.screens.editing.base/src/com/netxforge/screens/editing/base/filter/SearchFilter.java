/*******************************************************************************
 * Copyright (c) 8 jan. 2014 NetXForge.
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
package com.netxforge.screens.editing.base.filter;

import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.netxforge.screens.editing.base.EMFEditingService;

/**
 * The matching text, will be from the ItemProvider of the EObject. FIXME Make
 * sure the type name is not returned from the ItemProvider.
 * 
 * @author Christophe Bouhier
 */
public class SearchFilter extends ViewerFilter implements ISearchFilter {

	private String searchString;

	// Lazy initialize
	protected AdapterFactoryItemDelegator adapterFactoryItemDelegator;

	/* (non-Javadoc)
	 * @see com.netxforge.screens.editing.base.filter.ISearchFilter#setSearchText(java.lang.String)
	 */
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

			String match = getMatch(element);
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

	/**
	 * @param element
	 * @return
	 */
	protected String getMatch(Object element) {
		if (adapterFactoryItemDelegator == null) {
			adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
					EMFEditingService.getAdapterFactory());
		}
		return adapterFactoryItemDelegator.getText(element);
	}

	/* (non-Javadoc)
	 * @see com.netxforge.screens.editing.base.filter.ISearchFilter#getSearchString()
	 */
	public String getSearchString() {
		return searchString;
	}
}