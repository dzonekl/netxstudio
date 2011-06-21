package com.netxforge.netxstudio.common.tests;

import java.util.Calendar;
import java.util.Date;

import com.netxforge.netxstudio.common.model.ModelUtils;

public class ModelUtilsTest extends AbstractCommonTest {

	ModelUtils modelUtils;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		modelUtils = this.injector.getInstance(ModelUtils.class);

	}

	public void testModelUtils() throws Exception {

		{
			Date today = modelUtils.todayAndNow();
			Date lastWeek = modelUtils.lastWeek();

			System.out.println(modelUtils.toString(today));
			System.out.println(modelUtils.toString(lastWeek));
		}
		System.out.println(modelUtils.weekDays());

		{
			Date today = modelUtils.todayAndNow();
			
			Date afewhourslater = modelUtils.todayAndNow();
			Calendar c = Calendar.getInstance();
			c.setTime(afewhourslater);
			c.roll(Calendar.HOUR_OF_DAY, 3);
			
			Date newDate = modelUtils.mergeTimeIntoDate(today, c.getTime());
			System.out.println(newDate);
		}

	}
}
