/*******************************************************************************
 * Copyright (c) 24 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.common.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

public class ModelUtilsTest extends AbstractInjectedTestJUnit4 {

	@Inject
	private ModelUtils modelUtils;

	@Before
	public void setUp() throws Exception {
		this.getInjector().injectMembers(this);

	}

	@Test
	public void testRandomValue() {
		Date d = modelUtils.todayAndNow();
		d = modelUtils.adjustToDayStart(d);
		XMLGregorianCalendar xmlDate = modelUtils.toXMLDate(d);
		for (int i = 0; i < 24; i++) {
			Value valueWithRandom = modelUtils.valueWithRandom(100);
			xmlDate = modelUtils.rollHours(xmlDate, 1);
			valueWithRandom.setTimeStamp(xmlDate);
			System.out.println(modelUtils.printModelObject(valueWithRandom));
		}
	}

	@Test
	public void testMonthPeriods() {

		Date sixMonthsAgo = modelUtils.adjustToDayStart(modelUtils
				.sixMonthsAgo());

		Date todayDayStart = modelUtils.adjustToDayStart(modelUtils
				.todayAndNow());
		DateTimeRange sixMonthPeriod = modelUtils.period(sixMonthsAgo,
				todayDayStart);
		System.out.println("Full: "
				+ modelUtils.periodToStringMore(sixMonthPeriod));
		for (DateTimeRange dtr : modelUtils.periods(sixMonthPeriod,
				Calendar.MONTH)) {
			System.out.println(" Month: " + modelUtils.periodToStringMore(dtr));
			final List<DateTimeRange> days = modelUtils.periods(dtr,
					Calendar.DAY_OF_MONTH);
			for (DateTimeRange dtrDay : days) {
				System.out.println("   Day: "
						+ modelUtils.periodToStringMore(dtrDay));
			}
		}
	}

	@Test
	public void testWeekPeriods() {

		Date sixMonthsAgo = modelUtils.adjustToDayStart(modelUtils
				.sixMonthsAgo());

		Date todayDayStart = modelUtils.adjustToDayStart(modelUtils
				.todayAndNow());
		DateTimeRange sixMonthPeriod = modelUtils.period(sixMonthsAgo,
				todayDayStart);
		System.out.println("Full: "
				+ modelUtils.periodToStringMore(sixMonthPeriod));
		for (DateTimeRange dtr : modelUtils.periods(sixMonthPeriod,
				Calendar.WEEK_OF_YEAR)) {
			System.out.println(" Week: " + modelUtils.periodToStringMore(dtr));
			final List<DateTimeRange> days = modelUtils.periods(dtr,
					Calendar.DAY_OF_MONTH);
			for (DateTimeRange dtrDay : days) {
				System.out.println("   Day: "
						+ modelUtils.periodToStringMore(dtrDay));
			}
		}
	}

}
