package com.netxforge.netxstudio.common.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ModelUtils {
	
	@Inject
	private DatatypeFactory dataTypeFactory; 
		
	
	/**
	 * Get the days of the week, in a long textual format i.e. "Monday". 
	 * The days of the week, adapts to the current Locale.
	 * @return
	 */
	public List<String> weekDays(){
		Function<Integer, String> getDayString = new Function<Integer, String>() {
			public String apply(Integer from) {
				Calendar c = Calendar.getInstance();
				c.set(Calendar.DAY_OF_WEEK, from.intValue());
				Date date = c.getTime();
				SimpleDateFormat df = new SimpleDateFormat("EEEE");
				return df.format(date);
			}
		};
		List<Integer> week = ImmutableList
				.of(Calendar.MONDAY, Calendar.TUESDAY,
						Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY);
		return Lists.transform(week, getDayString);
	}
	
	public XMLGregorianCalendar xmlDate(Date date) {
		final XMLGregorianCalendar gregCalendar = dataTypeFactory
				.newXMLGregorianCalendar();
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		gregCalendar.setYear(calendar.get(Calendar.YEAR));
		gregCalendar.setMonth(calendar.get(Calendar.MONTH) + 1); // correct with
																	// 1 on
																	// purpose
		gregCalendar.setDay(calendar.get(Calendar.DAY_OF_MONTH));

		gregCalendar.setHour(calendar.get(Calendar.HOUR_OF_DAY));
		gregCalendar.setMinute(calendar.get(Calendar.MINUTE));
		gregCalendar.setSecond(calendar.get(Calendar.SECOND));
		gregCalendar.setMillisecond(calendar.get(Calendar.MILLISECOND));
		// gregCalendar.setTimezone(calendar.get(Calendar.ZONE_OFFSET));

		return gregCalendar;
	}

	public Date lastWeek(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.roll(Calendar.WEEK_OF_YEAR, false);
		return cal.getTime();
	}
	
	public Date yesterday(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.roll(Calendar.DAY_OF_WEEK, false);
		return cal.getTime();
	}

	public Date twoDaysAgo(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.roll(Calendar.DAY_OF_MONTH, false);
		cal.roll(Calendar.DAY_OF_MONTH, false);
		return cal.getTime();
	}

	public Date threeDaysAgo(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.roll(Calendar.DAY_OF_MONTH, false);
		cal.roll(Calendar.DAY_OF_MONTH, false);
		cal.roll(Calendar.DAY_OF_MONTH, false);
		return cal.getTime();
	}
	
	public Date fourDaysAgo(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.roll(Calendar.DAY_OF_MONTH, false);
		cal.roll(Calendar.DAY_OF_MONTH, false);
		cal.roll(Calendar.DAY_OF_MONTH, false);
		cal.roll(Calendar.DAY_OF_MONTH, false);
		return cal.getTime();
	}
	
	public Date today(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		return cal.getTime();
	}
	
	public String toString(Date date){
		return DateFormat.getDateInstance().format(date);
	}
	

}
