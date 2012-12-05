/*******************************************************************************
 * Copyright (c) 1 dec. 2012 NetXForge.
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

import java.util.Date;

import com.netxforge.netxstudio.common.model.ModelUtils;

/**
 * Matches items within a certain period.
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class PeriodItemsFilter implements IItemsFilter {

	/*
	 * Our Search Pattern.
	 */
	private ISearchPattern pattern;

	private ModelUtils modelUtils;

	public PeriodItemsFilter(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
		pattern = new PeriodPattern();
	}

	public PeriodItemsFilter(ISearchPattern pattern, ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
		this.pattern = pattern;
	}

	/**
	 * The filter is a subfilter if the pattern is a {@link PeriodPattern} and
	 * if it's within the period of this filter.
	 * 
	 */

	public boolean isSubFilter(IItemsFilter filter) {

		if (filter instanceof PeriodItemsFilter
				&& ((PeriodItemsFilter) filter).pattern instanceof PeriodPattern
				&& pattern instanceof PeriodPattern) {
			PeriodItemsFilter pif = (PeriodItemsFilter) filter;
			return ((PeriodPattern) pattern).subPeriod((PeriodPattern) pif.pattern);

		}
		return false;
	}

	public abstract boolean matchItem(Object item);

	public boolean isConsistentItem(Object item) {
		return true;
	}

	public boolean equalsFilter(IItemsFilter filter) {
		if (this.pattern == null) {
			return false;
		}

		if (filter instanceof PeriodItemsFilter
				&& pattern instanceof PeriodPattern) {
			PeriodItemsFilter pif = (PeriodItemsFilter) filter;
			((PeriodPattern) pattern).equals(pif.getPattern());
		}
		return false;
	}

	public ISearchPattern getPattern() {
		return pattern;
	}

	/**
	 * 
	 * A search pattern, which will match an item within the specified period.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class PeriodPattern implements ISearchPattern {

		@Override
		public String toString() {
			return "from:" + modelUtils.date(new Date(from)) + " to: "
					+ modelUtils.date(new Date(to));
		}

		private long from = -1;

		public long getFrom() {
			return from;
		}

		public long getTo() {
			return to;
		}

		private long to = -1;

		public void updateDates(Date from, Date to) {
			assert from == null || to == null : new IllegalArgumentException();
			this.from = from.getTime();
			this.to = to.getTime();
		}

		public boolean isEmpty() {
			return false;
		}

		public boolean matches(Date dateToMatch) {
			if (from <= 0 && to <= 0) {
				return true;
			}

			long target = dateToMatch != null ? dateToMatch.getTime() : 0;
			return from <= target && to >= target;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof PeriodPattern) {
				PeriodPattern p = (PeriodPattern) obj;
				return p.getFrom() == from && p.getTo() == to;
			}
			return false;
		}

		public boolean subPeriod(PeriodPattern p) {
			return p.getFrom() >= from && p.getTo() < to || p.getFrom() > from
					&& p.getTo() <= to;
		}

	}

}
