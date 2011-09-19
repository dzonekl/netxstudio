/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.logic;

import java.util.Date;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.services.Service;

/**
 * Common code for all logic implementations.
 * 
 * @author Martin Taal
 */
public abstract class BasePeriodLogic extends BaseLogic {

	private Date startTime;
	private Date endTime;

	private DateTimeRange timeRange;

	protected DateTimeRange getTimeRange() {
		if (timeRange != null) {
			return timeRange;
		}
		timeRange = GenericsFactory.eINSTANCE.createDateTimeRange();
		timeRange.setBegin(getModelUtils().toXMLDate(getStartTime()));
		timeRange.setEnd(getModelUtils().toXMLDate(getEndTime()));
		return timeRange;
	}


	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public void calculatePeriod(Service service) {
		Date startTime = getStartTime();
		if (startTime == null) {
			// TODO: make the period for the look back configurable
			// TODO: note that a user can do a separate run which runs in the
			// past
			// creating new last service monitor with an end date in the past
			// the system, should not pick the last servicemonitor in the list
			// but should find the last end time of all service monitors.
			startTime = new Date(System.currentTimeMillis() - 30 * 24 * 60 * 60
					* 1000);
			if (!service.getServiceMonitors().isEmpty()) {
				final Date previousEndTime = service.getServiceMonitors()
						.get(service.getServiceMonitors().size() - 1)
						.getPeriod().getEnd().toGregorianCalendar().getTime();
				startTime = new Date(previousEndTime.getTime() + 1);
			}
			setStartTime(startTime);
		}
		Date endTime = getEndTime();
		if (endTime == null) {
			endTime = new Date(System.currentTimeMillis());
			setEndTime(endTime);
		}
	}
}
