/*******************************************************************************
 * Copyright (c) 18 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.showins;

import org.eclipse.ui.part.ShowInContext;

import com.netxforge.netxstudio.generics.DateTimeRange;

/**
 * 
 * An input which is set on a {@link ShowInContext show-in context}.
 *  
 * @author Christophe Bouhier
 */
public class ChartInput {
	
	/**
	 * The period for the chart to show. 
	 */
	private DateTimeRange period;
	
	/**
	 * The interval for the range we would like to see. 
	 */
	private int interval;

	/**
	 * @return the dtr
	 */
	public DateTimeRange getPeriod() {
		return period;
	}

	/**
	 * @param dtr the dtr to set
	 */
	public void setPeriod(DateTimeRange dtr) {
		this.period = dtr;
	}

	/**
	 * @return the data interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

}
