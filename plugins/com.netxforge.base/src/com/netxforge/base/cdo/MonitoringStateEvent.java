/*******************************************************************************
 * Copyright (c) 29 jan. 2013 NetXForge.
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
package com.netxforge.base.cdo;

/**
 * A Monitoring State Event, used in call backs.
 * 
 * @author Christophe Bouhier
 * 
 */
public class MonitoringStateEvent {
	
	
	/**
	 * The result of the event.
	 * 
	 */
	private Object result;

	/**
	 * Stores the result.
	 * 
	 * @param monitoringSummary
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * Retrieve the result object for this event.
	 * 
	 * @return
	 */
	public Object getResult() {
		return result;
	}

}
