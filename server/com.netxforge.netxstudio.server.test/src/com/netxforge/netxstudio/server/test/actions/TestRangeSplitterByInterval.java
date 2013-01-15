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

	@Before
	public void up() {

		_15minValues = Lists.newArrayList();
		// start 1 week from now, increase one hour each time.
		Date oneWeekAgo = modelUtils.oneWeekAgo();

		{
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
		oneWeekAgo = modelUtils.adjustToDayStart(oneWeekAgo);
		// start 1 week from now, increase one hour each time.
		{
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
		// start 3 months from now, increase one day each time.
		Date threeMonthsAgo = modelUtils.threeMonthsAgo();
		oneWeekAgo = modelUtils.adjustToDayStart(threeMonthsAgo);
		{
			Calendar instance = Calendar.getInstance();
			instance.setTime(threeMonthsAgo);
			for (int i = 0; i < 100; i++) {
				Value v = GenericsFactory.eINSTANCE.createValue();
				instance.add(Calendar.DAY_OF_MONTH, 1);
				v.setTimeStamp(modelUtils.toXMLDate(instance.getTime()));
				v.setValue(i);
				dayValues.add(v);
			}
		}
		monthValues = Lists.newArrayList();
		// start 3 months from now, increase one day each time.
		Date manyDaysAgo = modelUtils.daysAgo(500);
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
			Assert.assertEquals(size, subRangesSize);
		}

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
			Assert.assertEquals(size, subRangesSize);

		}

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
