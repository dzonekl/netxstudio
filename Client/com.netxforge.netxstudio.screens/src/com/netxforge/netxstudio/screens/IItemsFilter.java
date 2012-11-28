/*******************************************************************************
 * Copyright (c) 28 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens;

/**
 * An items filter.
 */
public interface IItemsFilter {

	/**
	 * Check if the given filter is a sub-filter of this filter. 
	 * 
	 * @param filter
	 *            the filter to be checked, or <code>null</code>
	 * @return <code>true</code> if the given filter is sub-filter of this
	 *         filter, <code>false</code> if the given filter isn't a sub-filter
	 *         or is <code>null</code>
	 * 
	 * @see org.eclipse.ui.dialogs.SearchPattern#isSubPattern(org.eclipse.ui.dialogs.SearchPattern)
	 */
	public abstract boolean isSubFilter(IItemsFilter filter);

	/**
	 * Matches an item against filter conditions.
	 * 
	 * @param item
	 * @return <code>true<code> if item matches against filter conditions, <code>false</code>
	 *         otherwise
	 */
	public abstract boolean matchItem(Object item);

	/**
	 * Checks consistency of an item. Item is inconsistent if was changed or
	 * removed.
	 * 
	 * @param item
	 * @return <code>true</code> if item is consistent, <code>false</code> if
	 *         item is inconsistent
	 */
	public abstract boolean isConsistentItem(Object item);

	/**
	 * Checks whether the provided filter is equal to the current filter.
	 * 
	 */
	public abstract boolean equalsFilter(IItemsFilter filter);

	/**
	 * Get the pattern
	 * 
	 * @return
	 */
	public abstract ISearchPattern getPattern();

}