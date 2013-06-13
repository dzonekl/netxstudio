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

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
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
			timeRange.setBegin(getModelUtils().toXMLDate(getBeginTime()));
			timeRange.setEnd(getModelUtils().toXMLDate(getEndTime()));
			
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
			startTime = this.getModelUtils().threeMonthsAgo();
			startTime = getModelUtils().adjustToDayStart(startTime);
			setBeginTime(startTime);
		}

		// Perhaps should calculate on midnght hours.
		Date endTime = getEndTime();
		if (endTime == null) {
			endTime = this.getModelUtils().todayAtDayEnd();
			setEndTime(endTime);
		}
	}

	/**
	 * Return the default logic period of 6 months.
	 * 
	 * @return
	 */
	public DateTimeRange getDefaultLogicPeriod() {

		Date startTime = this.getModelUtils().monthsAgo(8);
		startTime = getModelUtils().adjustToDayStart(startTime);

		// Perhaps should calculate on midnght hours.
		Date endTime = this.getModelUtils().todayAtDayEnd();
		setEndTime(endTime);

		return this.getModelUtils().period(startTime, endTime);
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

		Resource res = this.getDataProvider().getResource(
				NetxstudioPackage.Literals.SERVER_SETTINGS);
		ServerSettings settings = this.getModelUtils().serverSettings(res);
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
			d = this.getModelUtils().daysAgo(valueInDays);
		}
			break;
		case ExpansionDuration.SHORT_VALUE: {
			int valueInDays = expansionDurationSettings.getShortDuration()
					.getValue();
			d = this.getModelUtils().daysAgo(valueInDays);
		}
			break;
		case ExpansionDuration.MEDIUM_VALUE: {
			int valueInDays = expansionDurationSettings.getMediumDuration()
					.getValue();
			d = this.getModelUtils().daysAgo(valueInDays);
		}
			break;
		case ExpansionDuration.LONG_VALUE: {
			int valueInDays = expansionDurationSettings.getLongDuration()
					.getValue();
			d = this.getModelUtils().daysAgo(valueInDays);
		}
			break;
		}

		if (d != null) {
			this.setBeginTime(d);
			this.setEndTime(this.getModelUtils().todayAndNow());
		}
	}

}
