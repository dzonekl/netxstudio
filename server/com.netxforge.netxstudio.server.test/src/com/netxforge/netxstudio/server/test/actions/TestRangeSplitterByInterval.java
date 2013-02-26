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
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.test.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.server.test.AbstractInjectedTestJUnit4;

/**
 * Test a function, which splits ranges depending on the provided interval.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class TestRangeSplitterByInterval extends AbstractInjectedTestJUnit4 {

	List<Value> _15minValues;
	List<Value> hourValues;
	List<Value> dayValues;
	List<Value> monthValues;
	List<Value> weekValues;

	@Before
	public void up() {

		_15minValues = Lists.newArrayList();

		{ // start 1 week from now, increase one hour each time.
			Date oneWeekAgo = modelUtils.oneWeekAgo();
			oneWeekAgo = modelUtils.adjustToDayStart(oneWeekAgo);
			Calendar instance = Calendar.getInstance();
			instance.setTime(oneWeekAgo);
			for (int i = 0; i < 672; i++) {
				Value v = GenericsFactory.eINSTANCE.createValue();
				instance.add(Calendar.MINUTE, 15);
				v.setTimeStamp(modelUtils.toXMLDate(instance.getTime()));
				v.setValue(i);
				_15minValues.add(v);
			}
		}

		hourValues = Lists.newArrayList();

		
		{
			Date oneWeekAgo = modelUtils.oneWeekAgo();
			oneWeekAgo = modelUtils.adjustToDayStart(oneWeekAgo);
			Calendar instance = Calendar.getInstance();
			instance.setTime(oneWeekAgo);
			for (int i = 0; i < 100; i++) {
				Value v = GenericsFactory.eINSTANCE.createValue();
				instance.add(Calendar.HOUR_OF_DAY, 1);
				v.setTimeStamp(modelUtils.toXMLDate(instance.getTime()));
				v.setValue(i);
				hourValues.add(v);
			}
		}
		dayValues = Lists.newArrayList();
		// start 365 days from now, increase one day each time.
		{
			Date today = modelUtils.todayAndNow();
			today = modelUtils.adjustToDayStart(today);
			Calendar instance = Calendar.getInstance();
			instance.setTime(today);
			for (int i = 0; i < 365; i++) {
				Value v = GenericsFactory.eINSTANCE.createValue();
				instance.add(Calendar.DAY_OF_YEAR, -1);
				v.setTimeStamp(modelUtils.toXMLDate(instance.getTime()));
				v.setValue(i);
				dayValues.add(v);
			}
		}

		weekValues = Lists.newArrayList();
		// start today, decrease one year, one week each time. 
		{
			Date today = modelUtils.todayAndNow();
			today = modelUtils.adjustToDayStart(today);
			Calendar instance = Calendar.getInstance();
			instance.setTime(today);
			for (int i = 0; i < 52; i++) {
				Value v = GenericsFactory.eINSTANCE.createValue();
				instance.add(Calendar.WEEK_OF_YEAR, -1);
				v.setTimeStamp(modelUtils.toXMLDate(instance.getTime()));
				v.setValue(i);
				weekValues.add(v);
			}
		}

		monthValues = Lists.newArrayList();
		// start 3 months from now, increase one day each time.
		Date manyDaysAgo = modelUtils.daysAgo(500);
		manyDaysAgo = modelUtils.adjustToDayStart(manyDaysAgo);
		{
			Calendar instance = Calendar.getInstance();
			instance.setTime(manyDaysAgo);
			for (int i = 0; i < 24; i++) {
				Value v = GenericsFactory.eINSTANCE.createValue();
				instance.add(Calendar.MONTH, 1);
				v.setTimeStamp(modelUtils.toXMLDate(instance.getTime()));
				v.setValue(i);
				monthValues.add(v);
			}
		}
	}

	@Test
	public void testValueRangeSplitter() {

		System.out.println("Split 15 min by hour (One week values)");
		{
			int size = _15minValues.size();
			List<List<Value>> splitValueRange = modelUtils.values_(
					_15minValues, ModelUtils.MINUTES_IN_AN_HOUR);
			int subRangesSize = 0;
			for (List<Value> seq : splitValueRange) {
				subRangesSize += seq.size();
				System.out.print("Subrange:" + seq.size() + " ");
				for (Value v : seq) {
					System.out.print("{" + v.getTimeStamp() + "}");
				}
				System.out.println();
			}
			System.out.println(" range count: " + splitValueRange.size());
//			Assert.assertEquals(splitValueRange.size(), 168); // Expecting 168
//																// (one week's
//																// worth of
//			// hourly values).
			Assert.assertEquals(size, subRangesSize);
		}

		System.out.println("Split 15 min by day (One week values)");
		{
			int size = _15minValues.size();
			List<List<Value>> splitValueRange = modelUtils.values_(
					_15minValues, ModelUtils.MINUTES_IN_A_DAY);
			int subRangesSize = 0;
			for (List<Value> seq : splitValueRange) {
				subRangesSize += seq.size();
				System.out.print("Subrange:" + seq.size() + " ");
				for (Value v : seq) {
					System.out.print("{" + v.getTimeStamp() + "}");
				}
				System.out.println();
			}
			System.out.println(" range count: " + splitValueRange.size());
			Assert.assertEquals(splitValueRange.size(), 8); // Expecting 7 (one
															// week's worth of
															// day
			// values).
			Assert.assertEquals(size, subRangesSize);
		}

		System.out.println("Split 15 min by week (One week values)");
		{
			int size = _15minValues.size();
			List<List<Value>> splitValueRange = modelUtils.values_(
					_15minValues, ModelUtils.MINUTES_IN_A_WEEK);
			int subRangesSize = 0;
			for (List<Value> seq : splitValueRange) {
				subRangesSize += seq.size();
				System.out.print("Subrange:" + seq.size() + " ");
				for (Value v : seq) {
					System.out.print("{" + v.getTimeStamp() + "}");
				}
				System.out.println();
			}
			System.out.println(" range count: " + splitValueRange.size());
			Assert.assertTrue(splitValueRange.size() == 2
					|| splitValueRange.size() == 1); // Expecting 1 (one
			// or 2 week's worth of
			// week values).
			Assert.assertEquals(size, subRangesSize);
		}

		System.out.println("Split hour by day (100 hours)");
		{
			int size = hourValues.size();
			List<List<Value>> splitValueRange = modelUtils.values_(hourValues,
					ModelUtils.MINUTES_IN_A_DAY);
			int subRangesSize = 0;
			for (List<Value> seq : splitValueRange) {
				subRangesSize += seq.size();
				System.out.print("Subrange:" + seq.size() + " ");
				for (Value v : seq) {
					System.out.print("{" + v.getTimeStamp() + "}");
				}
				System.out.println();
			}
			Assert.assertEquals(size, subRangesSize);
		}

		System.out.println("Split day by day (1 Year)");
		{
			int size = dayValues.size();
			List<List<Value>> splitValueRange = modelUtils.values_(dayValues,
					ModelUtils.MINUTES_IN_A_DAY);
			int subRangesSize = 0;
			for (List<Value> seq : splitValueRange) {
				subRangesSize += seq.size();
				System.out.print("Subrange:" + seq.size() + " ");
				for (Value v : seq) {
					System.out.print("{" + v.getTimeStamp() + "}");
				}
				System.out.println();
			}
			Assert.assertEquals(size, subRangesSize);
		}
		{

			System.out.println("Split day by week (1 year)");
			int size = dayValues.size();
			List<List<Value>> splitValueRange = modelUtils.values_(dayValues,
					ModelUtils.MINUTES_IN_A_WEEK);
			int subRangesSize = 0;
			for (List<Value> seq : splitValueRange) {
				subRangesSize += seq.size();
				System.out.print("Subrange:" + seq.size() + " ");
				for (Value v : seq) {
					System.out.print("{" + v.getTimeStamp() + "}");
				}
				System.out.println();
			}
			System.out.println("# sub ranges: " + splitValueRange.size());
			
			Assert.assertEquals(size, subRangesSize);
			Assert.assertEquals(subRangesSize, 52);
		}

		System.out.println("Split weeks by month (3 Months)");
		{
			int size = weekValues.size();
			List<List<Value>> splitValueRange = modelUtils.values_(weekValues,
					ModelUtils.MINUTES_IN_A_MONTH);
			int subRangesSize = 0;
			for (List<Value> seq : splitValueRange) {
				subRangesSize += seq.size();
				System.out.print("Subrange:" + seq.size() + " ");
				for (Value v : seq) {
					System.out.print("{" + v.getTimeStamp() + "}");
				}
				System.out.println();
			}
			System.out.println("# sub ranges: " + splitValueRange.size());
			Assert.assertEquals(size, subRangesSize);

		}

		System.out.println("Split month by month (24 months)");
		{
			int size = monthValues.size();
			List<List<Value>> splitValueRange = modelUtils.values_(monthValues,
					ModelUtils.MINUTES_IN_A_MONTH);
			int subRangesSize = 0;
			for (List<Value> seq : splitValueRange) {
				subRangesSize += seq.size();
				System.out.print("Subrange:" + seq.size() + " ");
				for (Value v : seq) {
					System.out.print("{" + v.getTimeStamp() + "}");
				}
				System.out.println();
			}
			Assert.assertEquals(size, subRangesSize);

		}
	}
}
