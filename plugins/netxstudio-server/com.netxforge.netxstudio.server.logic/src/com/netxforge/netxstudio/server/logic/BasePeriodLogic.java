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

import org.eclipse.emf.ecore.resource.Resource;

import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.generics.ExpansionDurationSetting;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.services.Service;

/**
 * Common code for all logic implementations.
 * 
 * @author Martin Taal
 */
public abstract class BasePeriodLogic extends BaseLogic {

	private Date beginTime;
	private Date endTime;

	private DateTimeRange timeRange;

	/**
	 * Get the period, could be <code>null</code>
	 * @return
	 */
	public DateTimeRange getPeriod() {
		if (timeRange != null) {
			return timeRange;
		}

		if (getBeginTime() != null && getEndTime() != null) {
			timeRange = GenericsFactory.eINSTANCE.createDateTimeRange();
			timeRange.setBegin(NonModelUtils.toXMLDate(getBeginTime()));
			timeRange.setEnd(NonModelUtils.toXMLDate(getEndTime()));
			
		}
		return timeRange;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date startTime) {
		this.beginTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void calculatePeriod(Service service) {
		Date startTime = getBeginTime();
		if (startTime == null) {
			startTime = NonModelUtils.threeMonthsAgo();
			startTime = NonModelUtils.adjustToDayStart(startTime);
			setBeginTime(startTime);
		}

		// Perhaps should calculate on midnght hours.
		Date endTime = getEndTime();
		if (endTime == null) {
			endTime = NonModelUtils.todayAtDayEnd();
			setEndTime(endTime);
		}
	}

	/**
	 * Return the default logic period of 12 months.
	 * 
	 * @return
	 */
	public DateTimeRange getDefaultLogicPeriod() {

		Date startTime = NonModelUtils.monthsAgo(12);
		startTime = NonModelUtils.adjustToDayStart(startTime);

		// Perhaps should calculate on midnight hours.
		Date endTime = NonModelUtils.todayAtDayEnd();
		setEndTime(endTime);

		return StudioUtils.period(startTime, endTime);
	}

	/**
	 * Set the start and end time of the logic.
	 * 
	 * @param duration
	 */
	public void setPeriod(DateTimeRange dtr) {
		this.timeRange = dtr;
	}

	/**
	 * Set the start and end time of the logic according to the Expansion
	 * Duration definitions.
	 * 
	 * @param duration
	 */
	public void setPeriod(ExpansionDuration duration) {

		Resource res = this.getData().getResource(
				NetxstudioPackage.Literals.SERVER_SETTINGS);
		ServerSettings settings = StudioUtils.serverSettings(res);
		if (settings == null) {
			return; // Set period failed.
		}

		ExpansionDurationSetting expansionDurationSettings = settings
				.getExpansionDurationSettings();

		Date d = null;

		switch (duration.getValue()) {

		case ExpansionDuration.QUICK_VALUE: {
			int valueInDays = expansionDurationSettings.getQuickDuration()
					.getValue();
			d = NonModelUtils.daysAgo(valueInDays);
		}
			break;
		case ExpansionDuration.SHORT_VALUE: {
			int valueInDays = expansionDurationSettings.getShortDuration()
					.getValue();
			d = NonModelUtils.daysAgo(valueInDays);
		}
			break;
		case ExpansionDuration.MEDIUM_VALUE: {
			int valueInDays = expansionDurationSettings.getMediumDuration()
					.getValue();
			d = NonModelUtils.daysAgo(valueInDays);
		}
			break;
		case ExpansionDuration.LONG_VALUE: {
			int valueInDays = expansionDurationSettings.getLongDuration()
					.getValue();
			d = NonModelUtils.daysAgo(valueInDays);
		}
			break;
		}

		if (d != null) {
			this.setBeginTime(d);
			this.setEndTime(NonModelUtils.todayAndNow());
		}
	}

}
