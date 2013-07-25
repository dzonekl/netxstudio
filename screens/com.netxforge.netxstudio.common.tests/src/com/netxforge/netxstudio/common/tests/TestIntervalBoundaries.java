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

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

public class TestIntervalBoundaries extends AbstractInjectedTestJUnit4 {

	@Inject
	private ModelUtils modelUtils;

	@Before
	public void setUp() throws Exception {
		this.getClientInjector().injectMembers(this);

	}

	@Test
	public void testRandomValue() {

		Date todayAndNow = modelUtils.todayAndNow();

		Value v = GenericsFactory.eINSTANCE.createValue();
		v.setValue(1.0);
		v.setTimeStamp(modelUtils.toXMLDate(todayAndNow));

		{

			DateTimeRange period = modelUtils.period(v,
					ModelUtils.MINUTES_IN_AN_HOUR);
			System.out.println(modelUtils.periodToStringMore(period));

		}

		{
			DateTimeRange period = modelUtils.period(v,
					ModelUtils.MINUTES_IN_A_DAY);
			System.out.println(modelUtils.periodToStringMore(period));
		}

		{
			DateTimeRange period = modelUtils.period(v,
					ModelUtils.MINUTES_IN_A_WEEK);
			System.out.println(modelUtils.periodToStringMore(period));
		}
		{

			DateTimeRange period = modelUtils.period(v,
					ModelUtils.MINUTES_IN_A_MONTH);
			System.out.println(modelUtils.periodToStringMore(period));

		}

	}

}
