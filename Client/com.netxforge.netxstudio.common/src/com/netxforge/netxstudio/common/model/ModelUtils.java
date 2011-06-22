package com.netxforge.netxstudio.common.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.Value;

public class ModelUtils {

	@Inject
	private DatatypeFactory dataTypeFactory;

	public static final int SECONDS_IN_A_MINUTE = 60;
	public static final int SECONDS_IN_A_QUARTER = SECONDS_IN_A_MINUTE * 15;
	public static final int SECONDS_IN_AN_HOUR = SECONDS_IN_A_MINUTE * 60;
	public static final int SECONDS_IN_A_DAY = SECONDS_IN_AN_HOUR * 24;
	public static final int SECONDS_IN_A_WEEK = SECONDS_IN_A_DAY * 7;

	/**
	 * Merge the time from a date into a given base date.
	 * 
	 * @param baseDate
	 * @param dateWithTime
	 * @return
	 */
	public Date mergeTimeIntoDate(Date baseDate, Date dateWithTime) {
		Calendar baseCalendar = GregorianCalendar.getInstance();
		baseCalendar.setTime(baseDate);

		Calendar dateWithTimeCalendar = GregorianCalendar.getInstance();
		dateWithTimeCalendar.setTime(dateWithTime);

		baseCalendar.set(Calendar.HOUR_OF_DAY,
				dateWithTimeCalendar.get(Calendar.HOUR_OF_DAY));
		baseCalendar.set(Calendar.MINUTE,
				dateWithTimeCalendar.get(Calendar.MINUTE));
		return baseCalendar.getTime();

	}

	public List<Integer> weekDaysAsInteger() {
		List<Integer> week = ImmutableList.of(Calendar.MONDAY,
				Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY,
				Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY);
		return week;
	}

	public String weekDay(Integer weekDay) {
		Function<Integer, String> getDayString = new Function<Integer, String>() {
			public String apply(Integer from) {
				Calendar c = GregorianCalendar.getInstance();
				c.set(Calendar.DAY_OF_WEEK, from.intValue());
				Date date = c.getTime();
				SimpleDateFormat df = new SimpleDateFormat("EEEE");
				return df.format(date);
			}
		};
		return getDayString.apply(weekDay);
	}

	public String date(Date d) {
		Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	public String time(Date d) {
		Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				SimpleDateFormat df = new SimpleDateFormat("hh:mm");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	/**
	 * Get the days of the week, in a long textual format i.e. "Monday". The
	 * days of the week, adapts to the current Locale.
	 * 
	 * @return
	 */
	public List<String> weekDays() {
		Function<Integer, String> getDayString = new Function<Integer, String>() {
			public String apply(Integer from) {
				Calendar c = GregorianCalendar.getInstance();
				c.set(Calendar.DAY_OF_WEEK, from.intValue());
				Date date = c.getTime();
				SimpleDateFormat df = new SimpleDateFormat("EEEE");
				return df.format(date);
			}
		};

		return Lists.transform(weekDaysAsInteger(), getDayString);
	}

	public int weekDay(String day) {
		Function<String, Integer> getDayFromString = new Function<String, Integer>() {
			public Integer apply(String from) {
				try {
					Date d = DateFormat.getDateInstance().parse(from);
					Calendar c = GregorianCalendar.getInstance();
					c.setTime(d);
					return c.get(Calendar.DAY_OF_WEEK);

				} catch (ParseException e) {
					e.printStackTrace();
				}
				return -1;
			}
		};
		return getDayFromString.apply(day).intValue();
	}

	public Date mergeDateIntoTime(Date baseTime, Date targetDate) {

		Calendar baseCalendar = GregorianCalendar.getInstance();
		baseCalendar.setTime(baseTime);

		Calendar targetCalendar = GregorianCalendar.getInstance();
		targetCalendar.setTime(targetDate);

		if (targetCalendar.compareTo(GregorianCalendar.getInstance()) > 0) {
			baseCalendar.set(Calendar.YEAR, targetCalendar.get(Calendar.YEAR));
			baseCalendar
					.set(Calendar.MONTH, targetCalendar.get(Calendar.MONTH));
			baseCalendar.set(Calendar.WEEK_OF_YEAR,
					targetCalendar.get(Calendar.WEEK_OF_YEAR));

			// We need to roll the week, if the target day
			// is after the current day in that same week
			if (targetCalendar.get(Calendar.WEEK_OF_YEAR) == baseCalendar
					.get(Calendar.WEEK_OF_YEAR)
					&& targetCalendar.get(Calendar.DAY_OF_WEEK) > baseCalendar
							.get(Calendar.DAY_OF_WEEK)) {
				baseCalendar.add(Calendar.WEEK_OF_YEAR, 1);
			}
			// baseCalendar.set(Calendar.DAY_OF_WEEK,
			// targetCalendar.get(Calendar.DAY_OF_WEEK));
		}
		return baseCalendar.getTime();
	}

	/**
	 * Calculate a new date for a certain day of week and hour of day. If the
	 * startdate is not provided or earlier than today, the current date (today)
	 * is used.
	 * 
	 * @param baseDate
	 * @param dayOfWeek
	 * @return
	 */
	public Date mergeDayIntoDate(Date baseDate, int dayOfWeek) {

		Calendar c = GregorianCalendar.getInstance();
		c.setTime(baseDate);
		if (dayOfWeek != -1) {
			c.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		}
		return c.getTime();
	}

	public XMLGregorianCalendar toXMLDate(Date date) {
		final XMLGregorianCalendar gregCalendar = dataTypeFactory
				.newXMLGregorianCalendar();
		final Calendar calendar = GregorianCalendar.getInstance();
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

	public Date fromXMLDate(XMLGregorianCalendar date) {
		return date.toGregorianCalendar().getTime();
	}

	public Date lastWeek() {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		return cal.getTime();
	}

	public Date yesterday() {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_WEEK, -1);
		return cal.getTime();
	}

	public Date tomorrow() {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_WEEK, 1);
		return cal.getTime();
	}

	public Date twoDaysAgo() {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -2);
		return cal.getTime();
	}

	public Date threeDaysAgo() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -3);
		return cal.getTime();
	}

	public Date fourDaysAgo() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -4);
		return cal.getTime();
	}

	public Date todayAndNow() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		return cal.getTime();
	}

	public int inSeconds(String field) {
		Function<String, Integer> getFieldInSeconds = new Function<String, Integer>() {
			public Integer apply(String from) {
				if (from.equals("Week")) {
					return ModelUtils.SECONDS_IN_A_WEEK;
				}
				if (from.equals("Day")) {
					return ModelUtils.SECONDS_IN_A_DAY;
				}
				if (from.equals("Hour")) {
					return ModelUtils.SECONDS_IN_AN_HOUR;
				}
				if (from.equals("Quarter")) {
					return ModelUtils.SECONDS_IN_A_QUARTER;
				}
				return -1;
			}
		};
		return getFieldInSeconds.apply(field);
	}

	public int inWeeks(String field) {
		Function<String, Integer> getFieldInSeconds = new Function<String, Integer>() {
			public Integer apply(String from) {
				if (from.equals("Week")) {
					return 1;
				}
				return null;
			}
		};
		return getFieldInSeconds.apply(field);
	}

	public String toString(Date date) {
		return DateFormat.getDateInstance().format(date);
	}

	/**
	 * limits occurences to 52.
	 * 
	 * @param start
	 * @param end
	 * @param interval
	 * @param repeat
	 * @return
	 */
	public List<Date> occurences(Date start, Date end, int interval, int repeat) {
		return this.occurences(start, end, interval, repeat, 52);
	}

	public List<Date> occurences(Date start, Date end, int interval,
			int repeat, int maxEntries) {

		List<Date> occurences = Lists.newArrayList();
		Date occurenceDate = start;
		occurences.add(start);
		
		if (repeat > 0 && interval > 60 * 10) {
			// We roll on the interval from the start date until repeat is
			// reached.
			for (int i = 0; i < repeat; i++) {
				occurenceDate = rollSeconds(occurenceDate, interval);
				occurences.add(occurenceDate);
			}
			return occurences;
		}
		if( end != null  && interval > 60 * 10) {
			// We roll on the interval from the start date until the end date.
			int i = 0;
			while (i < maxEntries) {
				occurenceDate = rollSeconds(occurenceDate, interval);
				if(!crossedDate(end, occurenceDate)){
					occurences.add(occurenceDate);
				}else{
					break;
				}
				i++;
			}
			return occurences;
		}
		if(repeat == -1 && interval > 60*10){
			int i = 0;
			while (i < maxEntries) {
				occurenceDate = rollSeconds(occurenceDate, interval);
				occurences.add(occurenceDate);
				i++;
			}
			return occurences;
		}
		
		
		return occurences;
	}

	public Date rollSeconds(Date baseDate, int seconds) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(baseDate);

		// We can't roll large numbers.
		if (seconds / SECONDS_IN_A_DAY > 0) {
			int days = new Double(seconds / SECONDS_IN_A_DAY).intValue();
			c.add(Calendar.DAY_OF_YEAR, days);
			return c.getTime();
		}
		if (seconds / SECONDS_IN_AN_HOUR > 0) {
			int hours = new Double(seconds / SECONDS_IN_AN_HOUR).intValue();
			c.add(Calendar.HOUR_OF_DAY, hours);
			return c.getTime();
		}

		if (seconds / SECONDS_IN_A_MINUTE > 0) {
			int minutes = new Double(seconds / SECONDS_IN_A_MINUTE).intValue();
			c.add(Calendar.MINUTE, minutes);
			return c.getTime();
		}

		c.add(Calendar.SECOND, seconds);
		return c.getTime();

	}

	public boolean crossedDate(Date refDate, Date variantDate) {
		Calendar refCal = GregorianCalendar.getInstance();
		refCal.setTime(refDate);

		Calendar variantCal = GregorianCalendar.getInstance();
		variantCal.setTime(variantDate);

		return refCal.compareTo(variantCal) < 0;

	}
	
	/**
	 * Transform a list of Value object, to only the value part of the Value Object. 
	 * 
	 * @param values
	 * @return
	 */
	public List<BigDecimal> transformValueToBigDecimal(List<Value> values){
		Function<Value, BigDecimal> valueToBigDecimal = new Function<Value, BigDecimal>(){
			public BigDecimal apply(Value from) {
				return new BigDecimal(from.getValue());
			}
		};
		return Lists.transform(values, valueToBigDecimal);
	}
	
	public List<Double> transformBigDecimalToDouble(List<BigDecimal> values){
		Function<BigDecimal, Double> valueToBigDecimal = new Function<BigDecimal, Double>(){
			public Double apply(BigDecimal from) {
				return from.doubleValue();
			}
		};
		return Lists.transform(values, valueToBigDecimal);
	}
	
	
	
}
