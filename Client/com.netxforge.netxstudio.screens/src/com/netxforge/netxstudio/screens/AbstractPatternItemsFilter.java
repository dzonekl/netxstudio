package com.netxforge.netxstudio.screens;

import org.eclipse.ui.dialogs.SearchPattern;

/**
 * Filters elements using SearchPattern by comparing the names of items with the
 * filter pattern.
 */
public abstract class AbstractPatternItemsFilter implements IItemsFilter {

	protected TextSearchPattern patternMatcher;

	/**
	 * Creates new instance of ItemsFilter.
	 * 
	 * @param searchPattern
	 *            the pattern to be used when filtering
	 */
	public AbstractPatternItemsFilter(TextSearchPattern searchPattern) {
		patternMatcher = searchPattern;
	}

	/**
	 * Check if the given filter is a sub-filter of this filter. The default
	 * implementation checks if the <code>SearchPattern</code> from the given
	 * filter is a sub-pattern of the one from this filter.
	 * <p>
	 * <i>WARNING: This method is <b>not</b> defined in reading order, i.e.
	 * <code>a.isSubFilter(b)</code> is <code>true</code> iff <code>b</code> is
	 * a sub-filter of <code>a</code>, and not vice-versa. </i>
	 * </p>
	 * 
	 * @param filter
	 *            the filter to be checked, or <code>null</code>
	 * @return <code>true</code> if the given filter is sub-filter of this
	 *         filter, <code>false</code> if the given filter isn't a sub-filter
	 *         or is <code>null</code>
	 * 
	 * @see org.eclipse.ui.dialogs.SearchPattern#isSubPattern(org.eclipse.ui.dialogs.SearchPattern)
	 */
	public boolean isSubFilter(IItemsFilter filter) {
		if (filter != null && filter instanceof AbstractPatternItemsFilter) {
			return this.patternMatcher
					.isSubPattern(((AbstractPatternItemsFilter) filter).patternMatcher);
		}
		return false;
	}

	/**
	 * Checks whether the provided filter is equal to the current filter. The
	 * default implementation checks if <code>SearchPattern</code> from current
	 * filter is equal to the one from provided filter.
	 * 
	 * @param filter
	 *            filter to be checked, or <code>null</code>
	 * @return <code>true</code> if the given filter is equal to current filter,
	 *         <code>false</code> if given filter isn't equal to current one or
	 *         if it is <code>null</code>
	 * 
	 * @see org.eclipse.ui.dialogs.SearchPattern#equalsPattern(org.eclipse.ui.dialogs.SearchPattern)
	 */
	public boolean equalsFilter(IItemsFilter filter) {
		if (filter != null && filter instanceof AbstractPatternItemsFilter) {
			if (((AbstractPatternItemsFilter) filter).patternMatcher
					.equalsPattern(this.patternMatcher))
				return true;
		}
		return false;
	}

	/**
	 * Checks whether the pattern's match rule is camel case.
	 * 
	 * @return <code>true</code> if pattern's match rule is camel case,
	 *         <code>false</code> otherwise
	 */
	public boolean isCamelCasePattern() {
		return patternMatcher.getMatchRule() == SearchPattern.RULE_CAMELCASE_MATCH;
	}

	/**
	 * Returns the pattern string.
	 * 
	 * @return pattern for this filter
	 * 
	 * @see SearchPattern#getPattern()
	 */
	public ISearchPattern getPattern() {
		return patternMatcher;
	}

	/**
	 * Returns the rule to apply for matching keys.
	 * 
	 * @return an implementation-specific match rule
	 * 
	 * @see SearchPattern#getMatchRule() for match rules returned by the default
	 *      implementation
	 */
	public int getMatchRule() {
		return patternMatcher.getMatchRule();
	}

	/**
	 * Matches text with filter.
	 * 
	 * @param text
	 *            the text to match with the filter
	 * @return <code>true</code> if text matches with filter pattern,
	 *         <code>false</code> otherwise
	 */
	public boolean matches(String text) {
		return patternMatcher.matches(text);
	}

	/**
	 * General method for matching raw name pattern. Checks whether current
	 * pattern is prefix of name provided item.
	 * 
	 * @param item
	 *            item to check
	 * @return <code>true</code> if current pattern is a prefix of name provided
	 *         item, <code>false</code> if item's name is shorter than prefix or
	 *         sequences of characters don't match.
	 */
	public boolean matchesRawNamePattern(String text) {

		String prefix = patternMatcher.getPattern();
		// String text = this.abstractCachedTableViewer.getElementName(item);

		if (text == null)
			return false;

		int textLength = text.length();
		int prefixLength = prefix.length();
		if (textLength < prefixLength) {
			return false;
		}
		for (int i = prefixLength - 1; i >= 0; i--) {
			if (Character.toLowerCase(prefix.charAt(i)) != Character
					.toLowerCase(text.charAt(i)))
				return false;
		}
		return true;
	}

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

}