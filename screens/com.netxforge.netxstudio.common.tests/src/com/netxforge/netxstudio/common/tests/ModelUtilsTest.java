package com.netxforge.netxstudio.common.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;

public class ModelUtilsTest extends AbstractCommonTest {

	ModelUtils modelUtils;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		modelUtils = this.injector.getInstance(ModelUtils.class);

	}

	//
	// public void testModelUtils() throws Exception {
	//
	// {
	// Date today = modelUtils.todayAndNow();
	// Date lastWeek = modelUtils.lastWeek();
	//
	// System.out.println(modelUtils.toString(today));
	// System.out.println(modelUtils.toString(lastWeek));
	// }
	// System.out.println(modelUtils.weekDays());
	//
	// {
	// Date today = modelUtils.todayAndNow();
	//
	// Date afewhourslater = modelUtils.todayAndNow();
	// Calendar c = Calendar.getInstance();
	// c.setTime(afewhourslater);
	// c.roll(Calendar.HOUR_OF_DAY, 3);
	//
	// Date newDate = modelUtils.mergeTimeIntoDate(today, c.getTime());
	// System.out.println(newDate);
	// }
	// }

	public void testMonthPeriods() {

		Date sixMonthsAgo = modelUtils.adjustToDayStart(modelUtils.sixMonthsAgo());
		
		Date todayDayStart = modelUtils.adjustToDayStart(modelUtils.todayAndNow());
		DateTimeRange sixMonthPeriod = modelUtils.period(sixMonthsAgo,
				todayDayStart);
		System.out.println("Full: " + modelUtils.periodToStringMore(sixMonthPeriod));
		for (DateTimeRange dtr : modelUtils.periods(sixMonthPeriod,
				Calendar.MONTH)) {
			System.out.println(" Month: " + modelUtils.periodToStringMore(dtr));
			final List<DateTimeRange> days = modelUtils.periods(dtr,
					Calendar.DAY_OF_MONTH);
			for (DateTimeRange dtrDay : days) {
				System.out.println( "   Day: " + modelUtils.periodToStringMore(dtrDay));
			}
		}
	}
	
	public void testWeekPeriods() {

		Date sixMonthsAgo = modelUtils.adjustToDayStart(modelUtils.sixMonthsAgo());
		
		Date todayDayStart = modelUtils.adjustToDayStart(modelUtils.todayAndNow());
		DateTimeRange sixMonthPeriod = modelUtils.period(sixMonthsAgo,
				todayDayStart);
		System.out.println("Full: " + modelUtils.periodToStringMore(sixMonthPeriod));
		for (DateTimeRange dtr : modelUtils.periods(sixMonthPeriod,
				Calendar.WEEK_OF_YEAR)) {
			System.out.println(" Week: " + modelUtils.periodToStringMore(dtr));
			final List<DateTimeRange> days = modelUtils.periods(dtr,
					Calendar.DAY_OF_MONTH);
			for (DateTimeRange dtrDay : days) {
				System.out.println( "   Day: " + modelUtils.periodToStringMore(dtrDay));
			}
		}
	}

}
