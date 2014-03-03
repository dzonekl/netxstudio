/*******************************************************************************
 * Copyright (c) Nov 2, 2012 NetXForge.
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
package com.netxforge.base;

import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.common.branch.CDOBranchVersion;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDOAddFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta.Type;
import org.eclipse.emf.cdo.common.revision.delta.CDOListFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORemoveFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOSetFeatureDelta;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.internal.common.id.CDOIDObjectLongImpl;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.spi.cdo.FSMUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

@SuppressWarnings("restriction")
public class NonModelUtils {

	public static final double ONE_BILLION = 1E+9; // Seconds
	public static final double ONE_MILLION = 1E+6; // Milli Seconds
	public static final double ONE_THOUSAND = 1E+3; // Pico Seconds

	public static final String DATE_PATTERN_1 = "MM/dd/yyyy";
	public static final String DATE_PATTERN_2 = "dd-MM-yyyy";
	public static final String DATE_PATTERN_3 = "dd.MM.yyyy";

	public static final String TIME_PATTERN_1 = "HH:mm:ss"; // 24 hour.
	public static final String TIME_PATTERN_2 = "HH:mm"; // 24 hour
	public static final String TIME_PATTERN_3 = "hh:mm:ss"; // AM PM
	public static final String TIME_PATTERN_4 = "hh:mm"; // AM PM

	public static final String TIME_PATTERN_5 = "a"; // AM PM marker.
	public static final String DEFAULT_DATE_TIME_PATTERN = "MM/dd/yyyy HH:mm:ss";

	public static final int SECONDS_IN_A_MINUTE = 60;
	public static final int SECONDS_IN_15MIN = SECONDS_IN_A_MINUTE * 15;
	public static final int SECONDS_IN_AN_HOUR = SECONDS_IN_A_MINUTE * 60;
	public static final int SECONDS_IN_A_DAY = SECONDS_IN_AN_HOUR * 24;
	public static final int SECONDS_IN_A_WEEK = SECONDS_IN_A_DAY * 7;

	public static final DecimalFormat FORMAT_DOUBLE_NO_FRACTION = new DecimalFormat(
			"00");

	/** Default value formatter */
	public static final String DEFAULT_VALUE_FORMAT_PATTERN = "###,###,###,##0.00";

	/**
	 * this is seconds in 4 weeks. Should be use only as an interval rule.
	 */
	public static final int SECONDS_IN_A_MONTH = SECONDS_IN_A_DAY * 30;

	public static final int MINUTES_IN_AN_HOUR = 60;
	public static final int MINUTES_IN_A_DAY = 60 * 24;
	public static final int MINUTES_IN_A_WEEK = MINUTES_IN_A_DAY * 7;

	// Note! For months, we better use a calendar function.
	public static final int MINUTES_IN_A_MONTH = MINUTES_IN_A_DAY * 30;

	private static final int MAX_CHANGE_LENGTH = 2000;

	private static DatatypeFactory dataTypeFactory;

	static {
		try {
			dataTypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Compares the values of two {@link EStructuralFeature} when the value
	 * implements {@link Comparable}
	 * 
	 * @author Christophe
	 */
	public static class EFeatureComparator implements Comparator<EObject> {

		private EStructuralFeature eFeature;

		public EFeatureComparator(EStructuralFeature eFeature) {
			this.eFeature = eFeature;
			// Analyse the data type for supported comparison types?
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public int compare(final EObject v1, final EObject v2) {

			// check if set.
			if (v1 != null && v1.eIsSet(eFeature) && v2 != null
					&& v2.eIsSet(eFeature)) {
				Object eGet1 = v1.eGet(eFeature);
				Object eGet2 = v2.eGet(eFeature);

				if (eGet1 instanceof Comparable) {
					return ((Comparable) eGet1).compareTo(eGet2);
				}
			}
			return -1;
		}
	};

	public static EFeatureComparator eFeatureComparator(
			EStructuralFeature eFeature) {
		return new EFeatureComparator(eFeature);
	}

	/**
	 * A Generic comparator for EObject attributes of which the type supports
	 * Comparable.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static class ObjectEAttributeComparator<T extends EObject, O>
			implements Comparator<T> {

		// The attribute
		private EAttribute attrib;
		private Class<O> attribType;

		public ObjectEAttributeComparator(EAttribute attrib) {

			Assert.isNotNull(attrib);
			this.attrib = attrib;
			EDataType eAttributeType = attrib.getEAttributeType();

			// How do we check?
			attribType = (Class<O>) eAttributeType.getInstanceClass();

		}

		public int compare(T o1, T o2) {

			O eGet1 = attribType.cast(o1.eGet(attrib));
			O eGet2 = attribType.cast(o2.eGet(attrib));

			if (eGet1 instanceof Comparable) {
				return ((Comparable<O>) eGet1).compareTo(eGet2);
			}
			return 0;
		}
	}

	/**
	 * Return an object attribute comparator for type T and expected attribute
	 * type O
	 * 
	 * @param attrib
	 * @return
	 */
	public static <T extends EObject, O> Comparator<T> objectEAttributeComparator(
			EAttribute attrib) {
		return new ObjectEAttributeComparator<T, O>(attrib);
	}

	/**
	 * CDO Object equality, is not customized {@link CDOObject#equals(Object)
	 * see equals()} when two CDOObjects with same OID are compared with '=='
	 * will result in false if either is read by a different CDOTransaction. A
	 * dedicated comparator will compare the OID's, even if from different
	 * transactions. </br> The {@link CDOState} of the objects is required to be
	 * {@link CDOState#CLEAN clean} (Object is state {@link CDOState#NEW new}
	 * and {@link CDOState#TRANSIENT transient} have a temporary OID} which
	 * makes comparison superfluous)
	 * 
	 * @author Christophe Bouhier
	 */
	public static boolean cdoOIDEquals(CDOObject o1, CDOObject o2) {
		if (FSMUtil.isClean(o1) && FSMUtil.isClean(o2)) {
			return o1.cdoID().equals(o2.cdoID());
		}
		return false;
	}

	/**
	 * Compare two values
	 */
	public static class DateComparator implements Comparator<Date> {
		public int compare(final Date v1, final Date v2) {
			return v1.compareTo(v2);
		}
	};

	public static DateComparator dateComparator() {
		return new DateComparator();
	}

	/**
	 * Compare two values
	 */
	public class DoubleComparator implements Comparator<Double> {
		public int compare(final Double v1, final Double v2) {
			return Double.compare(v1, v2);
		}
	};

	public DoubleComparator doubleCompare() {
		return new DoubleComparator();
	}

	/**
	 * A Predicate which checks equality of a target {@link CDOObject object}
	 * which delegates to {@link #cdoOIDEquals}
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public static class CDOObjectEqualsPredicate implements
			Predicate<CDOObject> {
		private final CDOObject target;

		public CDOObjectEqualsPredicate(CDOObject target) {
			this.target = target;
		}

		public boolean apply(CDOObject test) {
			return cdoOIDEquals(target, test);
		}
	}

	public static FileLastModifiedComparator fileLastModifiedComparator() {
		return new FileLastModifiedComparator();
	}

	/**
	 * {@link Comparator} for a {@link File file's } last modification date.
	 * 
	 * @author Christophe Bouhier
	 */
	public static class FileLastModifiedComparator implements Comparator<File> {
		public int compare(final File f1, File f2) {
			return new Long(f2.lastModified()).compareTo(f1.lastModified());
		}
	};

	/**
	 * The IntervalHint is required if to compare the difference is less than
	 * the interval.
	 * 
	 * @param intervalHint
	 *            in Minutes
	 * @param time1
	 * @param time2
	 * @return
	 * @deprecated DO NOT USE, WORK IN PROGRESS.
	 */
	public static boolean isSameTime(int intervalHint, Date d1, Date d2) {

		Calendar instance = Calendar.getInstance();
		instance.setTime(d1);

		// Get the next timestamp for this interval,

		@SuppressWarnings("unused")
		int fieldForInterval = fieldForInterval(intervalHint, -1);

		return false;
	}

	/**
	 * The IntervalHint is required if to compare the difference is less than
	 * the interval. For an Interval hint which corresponding to an HOUR, the
	 * equality also considers in-between values.
	 * 
	 * Note: This function doesn't consider interval boundaries, as the
	 * comparison uses the time representation, from Date.
	 * 
	 * 
	 * @param intervalHint
	 *            in Minutes
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean isSameTime(int intervalHint, long time1,
			XMLGregorianCalendar time2) {

		long diff = time1 - time2.toGregorianCalendar().getTimeInMillis();

		// make the diff value absolute.
		if (diff < 0) {
			diff = diff * -1;
		}

		if (intervalHint == MINUTES_IN_AN_HOUR) {
			// Substract one second, to make sure we really do not skip closely
			// related entries.
			boolean isDiff = diff < ((intervalHint * 60 * 1000) - 1000);
			return isDiff;
		} else {
			return diff == 0; // exact equal timestamp.
		}

	}

	/**
	 * Return a Calendar field value which corresponds to the source interval
	 * provided in minutes. The target Interval is used for some source interval
	 * only. (Like Day, could be day of the week or day of the month), if the
	 * target Interval is not specified (-1), day of the month is the default.
	 * 
	 * @param srcInterval
	 * @param targetInterval
	 * @return
	 */
	public static int fieldForInterval(int srcInterval, int targetInterval) {

		switch (srcInterval) {
		case 15: { // FIXME, SHOULD treat all interval < 60 as HOUR_OF_DAY.
			switch (targetInterval) {
			case MINUTES_IN_A_DAY:
			case -1:
				return Calendar.HOUR_OF_DAY;
			case MINUTES_IN_AN_HOUR: {
				// we can't split using a field.
				// return -1;
			}
			}
		}
		case MINUTES_IN_AN_HOUR: // one hour interval.
			return Calendar.HOUR_OF_DAY;
		case MINUTES_IN_A_DAY: { // one day interval
			switch (targetInterval) {
			case MINUTES_IN_A_MONTH:
			case -1:
				return Calendar.DAY_OF_MONTH;
			case MINUTES_IN_A_WEEK:
				return Calendar.DAY_OF_WEEK;
			}
		}
		case MINUTES_IN_A_WEEK:
			return Calendar.WEEK_OF_YEAR;
		case MINUTES_IN_A_MONTH: {
			return Calendar.MONTH;
		}
		default:
			return -1;
		}
	}

	/**
	 * Populate an array of {@link Calendar} higher order fields, deduced from
	 * the target interval.</p> Example: </br> If the interval is
	 * {@link NonModelUtils#MINUTES_IN_AN_HOUR} the fields are
	 * {@link Calendar#HOUR_OF_DAY}, {@link Calendar#DAY_OF_YEAR},
	 * {@link Calendar#WEEK_OF_YEAR}, {@link Calendar#MONTH},
	 * {@link Calendar#YEAR},
	 */
	public static int[] fieldsForTargetInterval(int targetInterval) {

		// We don't need decades or higher.
		int[] calFieldForPeriods = new int[] { Calendar.HOUR_OF_DAY,
				Calendar.DAY_OF_YEAR, Calendar.WEEK_OF_YEAR, Calendar.MONTH,
				Calendar.YEAR };

		switch (targetInterval) {
		case MINUTES_IN_AN_HOUR:
			return calFieldForPeriods; // All are needed.
		case MINUTES_IN_A_DAY:
			return copyOfRange(calFieldForPeriods, 1, 5);
		case MINUTES_IN_A_WEEK:
			return new int[] { Calendar.WEEK_OF_YEAR, Calendar.YEAR };
		case MINUTES_IN_A_MONTH:
			return copyOfRange(calFieldForPeriods, 3, 5);
		default:
			return null;
		}
	}

	/**
	 * Populate an array of {@link Calendar} lower order fields, deduced from
	 * the target interval.
	 * 
	 * @param targetInterval
	 * @return
	 */
	public static int[] fieldsForTargetIntervalLowerOrder(int targetInterval) {

		int[] calFieldForPeriods = new int[] { Calendar.MILLISECOND,
				Calendar.SECOND, Calendar.MINUTE, Calendar.HOUR_OF_DAY,
				Calendar.DAY_OF_YEAR, Calendar.WEEK_OF_YEAR, Calendar.MONTH,
				Calendar.YEAR };

		switch (targetInterval) {
		case MINUTES_IN_AN_HOUR:
			return copyOfRange(calFieldForPeriods, 0, 3);
		case MINUTES_IN_A_DAY:
			return copyOfRange(calFieldForPeriods, 0, 4);
		case MINUTES_IN_A_WEEK:
			return new int[] { Calendar.MILLISECOND, Calendar.SECOND,
					Calendar.MINUTE, Calendar.HOUR_OF_DAY,
					Calendar.DAY_OF_WEEK_IN_MONTH };
		case MINUTES_IN_A_MONTH:
			return new int[] { Calendar.MILLISECOND, Calendar.SECOND,
					Calendar.MINUTE, Calendar.HOUR_OF_DAY,
					Calendar.DAY_OF_MONTH };
		default:
			return null;
		}
	}

	/**
	 * Copied from class {@link Arrays#copyOfRange(int[], int, int)} , as this
	 * requires java 1.6, and our app should work with 1.5.
	 * 
	 * @param original
	 * @param from
	 * @param to
	 * @return
	 */
	public static int[] copyOfRange(int[] original, int from, int to) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		int[] copy = new int[newLength];
		System.arraycopy(original, from, copy, 0,
				Math.min(original.length - from, newLength));
		return copy;
	}

	public static int fieldForTargetInterval(int targetInterval) {

		switch (targetInterval) {
		case MINUTES_IN_AN_HOUR:
			return Calendar.HOUR_OF_DAY; // Hourly target.
		case MINUTES_IN_A_DAY:
			return Calendar.DAY_OF_YEAR; // Daily target.
		case MINUTES_IN_A_WEEK:
			return Calendar.WEEK_OF_YEAR; // Weekly target.
		case MINUTES_IN_A_MONTH: {
			return Calendar.MONTH; // Montly target.
		}
		default:
			return -1;
		}
	}

	public static class NonHiddenFilePredicate implements Predicate<File> {
		public boolean apply(final File f) {
			return !f.isHidden();
		}
	}

	public static NonHiddenFilePredicate nonHiddenFile() {
		return new NonHiddenFilePredicate();
	}

	/**
	 * A Predicate which can filter files based on one or more file extensions
	 * including the '.' separator, when the negate paramter is provided the
	 * reverse predicate is applied.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public static class ExtensionFilePredicate implements Predicate<File> {

		private String[] extensions;
		private boolean negate = false;

		public ExtensionFilePredicate(String... extensions) {
			this.extensions = extensions;
		}

		public ExtensionFilePredicate(boolean negate, String... extensions) {
			this.extensions = extensions;
			this.negate = negate;
		}

		public boolean apply(final File f) {
			String fileName = f.getName();
			if (f.isDirectory())
				return false;

			int dotIndex = fileName.lastIndexOf('.');

			if (dotIndex == -1) {
				return false;
			}
			String extension = fileName.substring(dotIndex, fileName.length());

			for (String ext : this.extensions) {
				if (ext.equals(extension)) {
					return negate ? true : !true;
				}
			}
			return false;
		}
	}
	
	public static ExtensionFilePredicate extensionFile(String... extension) {
		return new ExtensionFilePredicate(extension);
	}

	public static ExtensionFilePredicate extensionFile(boolean negate,
			String... extensions) {
		return new ExtensionFilePredicate(negate, extensions);
	}

	/**
	 * Cleans state references by iterating over a collection and
	 * 
	 * @param eo
	 * @param feature
	 */
	public static void findAndCleanONFE(EObject eo, EStructuralFeature feature) {

		if (feature instanceof EReference) {
			Object eGet = eo.eGet(feature);

			if (feature.isMany()) {
				if (eGet instanceof List<?>) {
					List<?> refs = (List<?>) eGet;
					boolean stillONF = true;

					// Keeps going until no more stale references.
					RESTART_ONFE_CHECK: while (stillONF) {
						for (int i = 0; i < refs.size(); i++) {
							try {
								Object object = refs.get(i);
								System.out.println("ONFE check for: " + object
										+ " is it proxy?");
								if (object instanceof CDOObject) {
								}
								// catch the onfe.
							} catch (ObjectNotFoundException exception) {

								System.out.println("ONFE detected, Reference: "
										+ eo + " feature: " + feature
										+ " index: " + i);

								CDOUtil.cleanStaleReference(eo, feature, i);

								System.out.println("ONFE cleaned, Reference: "
										+ eo + " feature: " + feature
										+ " index: " + i);
								break RESTART_ONFE_CHECK;
							}
						}
						stillONF = false;
					}
				}
			}
		}
	}

	public static Collection<String> splitLines(String Expression) {
		final String[] splitByNewLine = Expression.split("\n");
		final Collection<String> collection = Lists
				.newArrayList(splitByNewLine);
		return collection;
	}

	/**
	 * return a String with a fixed length.
	 * 
	 * @param string
	 * @param length
	 * @return
	 */
	public static String fixedLenthString(String string, int length) {
		return String.format("%1$-" + length + "s", string);
	}

	public static int depthToResource(int initialDepth, EObject eObject) {
		if (eObject.eContainer() != null) {
			return depthToResource(++initialDepth, eObject.eContainer());
		}
		return initialDepth;
	}

	/**
	 * Replaces all white spaces with an underscore
	 * 
	 * @param inString
	 * @return
	 */
	public static String underscopeWhiteSpaces(String inString) {
		return inString.replaceAll("\\s", "_");
	}

	/**
	 * Merge the time from a date into a given base date and return the result.
	 * 
	 * @param baseDate
	 * @param dateWithTime
	 * @return
	 */
	public static Date mergeTimeIntoDate(Date baseDate, Date dateWithTime) {
		final Calendar baseCalendar = GregorianCalendar.getInstance();
		baseCalendar.setTime(baseDate);

		final Calendar dateWithTimeCalendar = GregorianCalendar.getInstance();
		dateWithTimeCalendar.setTime(dateWithTime);

		baseCalendar.set(Calendar.HOUR_OF_DAY,
				dateWithTimeCalendar.get(Calendar.HOUR_OF_DAY));
		baseCalendar.set(Calendar.MINUTE,
				dateWithTimeCalendar.get(Calendar.MINUTE));
		return baseCalendar.getTime();

	}

	public static List<Integer> weekDaysAsInteger() {
		final List<Integer> week = ImmutableList.of(Calendar.MONDAY,
				Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY,
				Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY);
		return week;
	}

	public static int weekDay(Date date) {

		final Function<Date, Integer> getDayString = new Function<Date, Integer>() {
			public Integer apply(Date from) {
				final Calendar c = GregorianCalendar.getInstance();
				c.setTime(from);
				return new Integer(c.get(Calendar.DAY_OF_WEEK));
			}
		};
		return getDayString.apply(date);
	}

	public static String weekDay(Integer weekDay) {
		final Function<Integer, String> getDayString = new Function<Integer, String>() {
			public String apply(Integer from) {
				final Calendar c = GregorianCalendar.getInstance();
				c.set(Calendar.DAY_OF_WEEK, from.intValue());
				final Date date = c.getTime();
				final SimpleDateFormat df = new SimpleDateFormat("EEEE");
				return df.format(date);
			}
		};
		return getDayString.apply(weekDay);
	}

	/**
	 * Returns a {@link Date} as a <code>String</code> in the pre-defined
	 * format: <code>'dd-MM-yyyy'</code>
	 * 
	 * @param d
	 * @return
	 */
	public static String date(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	public static String folderDate(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	/**
	 * Returns a {@link Date} as a <code>String</code> in a pre-defined format:
	 * <code>'HH:mm'</code>
	 * 
	 * @param d
	 * @return
	 */
	public static String time(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	/**
	 * The duration as a String since the provided UTC
	 * 
	 * @param l
	 *            UTC
	 * @return
	 */
	public static String timeDuration(long l) {
		long delta = System.currentTimeMillis() - l;
		String result = (delta > 1000 ? (delta / 1000 + "." + delta % 1000 + " (sec) : ")
				: delta + " (ms) ");
		return result;
	}

	/**
	 * The duration as a String since the provided nanotime. nano is 10 to the
	 * power of -10 (So one billionth of a second). The presentation is
	 * depending on the size of the nano value.
	 * 
	 * @param l
	 * 
	 * @return
	 */
	public static String timeDurationNanoFromStart(long l) {
		// long delta = (long) ((System.nanoTime() - l) / ONE_MILLION);
		// return timeAndSecondsAmdMillis(new Date(delta));

		long delta = (System.nanoTime() - l);
		return timeFormatNano(delta);
	}

	/**
	 * The duration as a String for the provided nano seconds. nano is 10 to the
	 * power of -10 (So one billionth of a second). The presentation is
	 * depending on the size of the nano value.
	 * 
	 * @param l
	 * @return
	 */
	public static String timeDurationNanoElapsed(long l) {
		// long delta = (long) (l / ONE_MILLION);
		// return timeAndSecondsAmdMillis(new Date(delta));
		return timeFormatNano(l);
	}

	/**
	 * @param delta
	 * @return
	 */
	private static String timeFormatNano(long delta) {

		StringBuilder sb = new StringBuilder();

		// double rest = 0;

		// @SuppressWarnings("unused")
		// String[] units = new String[] { "(min:sec:ms)", "(sec)", "(ms)" };
		// @SuppressWarnings("unused")
		// String unit = "";

		// int granularity = 2;

		// In minutes;
		if (delta > ONE_BILLION * 60) {
			sb.append(FORMAT_DOUBLE_NO_FRACTION.format(delta
					/ (ONE_BILLION * 60))
					+ ":");
			// granularity--;
		} else {
			sb.append("00:");
		}
		// In seconds
		if (delta > ONE_BILLION) {
			sb.append(FORMAT_DOUBLE_NO_FRACTION.format(delta / ONE_BILLION)
					+ "::");
			// granularity--;
		} else {
			sb.append("00::");
		}
		// In mili seconds
		if (delta > ONE_MILLION) {
			sb.append(FORMAT_DOUBLE_NO_FRACTION.format(delta / ONE_MILLION)
					+ ":::");
			// granularity--;
		} else {
			sb.append("000:::");
		}
		// even less
		if (delta > ONE_THOUSAND) {
			sb.append(FORMAT_DOUBLE_NO_FRACTION.format(delta / ONE_THOUSAND));
			// granularity--;
		}
		sb.append(" (min:sec::ms:::psec)");
		return sb.toString();
	}

	/**
	 * Returns a {@link Date} as a <code>String</code> in a pre-defined format:
	 * <code>'HH:mm:ss'</code>
	 * 
	 * @param d
	 * @return
	 */
	public static String timeAndSeconds(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	/**
	 * Returns a {@link Date} as a <code>String</code> in a pre-defined format:
	 * <code>'HH:mm:ss SSS'</code>
	 * 
	 * @param d
	 * @return
	 */
	public static String timeAndSecondsAmdMillis(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss SSS");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	/**
	 * The current time as a <code>String</code> formatted as
	 * {@link #timeAndSeconds(Date)}
	 * 
	 * @return
	 */
	public static String currentTimeAndSeconds() {
		return timeAndSeconds(new Date());
	}

	/**
	 * The current time as a String formatted as "HH:mm:ss SSS"
	 * 
	 * @return
	 */
	public static String currentTimeAndSecondsAndMillis() {
		return timeAndSecondsAmdMillis(new Date());
	}

	/**
	 * returns a {@link Date} as a <code>String</code> with the following
	 * pre-defined format. {@link #date} '-' {@link #time}
	 * 
	 * @param l
	 * @return
	 */

	public static String dateAndTime(long l) {
		return dateAndTime(new Date(l));
	}

	/**
	 * returns a {@link Date} as a <code>String</code> with the following
	 * pre-defined format. {@link #date} '-' {@link #time}
	 * 
	 * @param d
	 * @return
	 */
	public static String dateAndTime(Date d) {

		StringBuilder sb = new StringBuilder();
		sb.append(date(d) + " ");
		sb.append(time(d));
		return sb.toString();
	}

	public static String dateAndTime(XMLGregorianCalendar d) {
		Date date = fromXMLDate(d);
		return folderDateAndTime(date);
	}

	/**
	 * returns a {@link Date} as a <code>String</code> with the following
	 * pre-defined format. <code>'ddMMyyyy-HHmm'</code> suitable for a file
	 * folder name.
	 * 
	 * 
	 * @see {@link File}
	 * @param d
	 * @return
	 */
	public static String folderDateAndTime(Date d) {

		StringBuilder sb = new StringBuilder();

		final Function<Date, String> folderTime = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("HHmm");
				return df.format(from);
			}
		};
		sb.append(folderDate(d) + "_");
		sb.append(folderTime.apply(d));
		return sb.toString();
	}

	/**
	 * Get the days of the week, in a long textual format i.e. "Monday". The
	 * days of the week, adapts to the current Locale.
	 * 
	 * @return
	 */
	public static List<String> weekDays() {
		final Function<Integer, String> getDayString = new Function<Integer, String>() {
			public String apply(Integer from) {
				final Calendar c = GregorianCalendar.getInstance();
				c.set(Calendar.DAY_OF_WEEK, from.intValue());
				final Date date = c.getTime();
				final SimpleDateFormat df = new SimpleDateFormat("EEEE");
				return df.format(date);
			}
		};

		return Lists.transform(weekDaysAsInteger(), getDayString);
	}

	public static int weekDay(String day) {
		final Function<String, Integer> getDayFromString = new Function<String, Integer>() {
			public Integer apply(String from) {
				try {
					final Date d = DateFormat.getDateInstance().parse(from);
					final Calendar c = GregorianCalendar.getInstance();
					c.setTime(d);
					return c.get(Calendar.DAY_OF_WEEK);

				} catch (final ParseException e) {
					e.printStackTrace();
				}
				return -1;
			}
		};
		return getDayFromString.apply(day).intValue();
	}

	public static Date mergeDateIntoTime(Date baseTime, Date targetDate) {

		final Calendar baseCalendar = GregorianCalendar.getInstance();
		baseCalendar.setTime(baseTime);

		final Calendar targetCalendar = GregorianCalendar.getInstance();
		targetCalendar.setTime(targetDate);

		// CB 06-09-2011, removed date has to be later requirement.
		// if (targetCalendar.compareTo(GregorianCalendar.getInstance()) > 0) {
		baseCalendar.set(Calendar.YEAR, targetCalendar.get(Calendar.YEAR));
		baseCalendar.set(Calendar.MONTH, targetCalendar.get(Calendar.MONTH));
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
		// }
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
	public static Date mergeDayIntoDate(Date baseDate, int dayOfWeek) {

		final Calendar c = GregorianCalendar.getInstance();
		c.setTime(baseDate);
		if (dayOfWeek != -1) {
			c.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		}
		return c.getTime();
	}

	public static XMLGregorianCalendar toXMLDate(Date date) {
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

	public static Date fromXMLDate(XMLGregorianCalendar date) {
		return date.toGregorianCalendar().getTime();
	}

	public static int daysInJanuary(int year) {
		return daysInMonth(year, Calendar.JANUARY);
	}

	public static int daysInFebruari(int year) {
		return daysInMonth(year, Calendar.FEBRUARY);
	}

	public static int daysInMarch(int year) {
		return daysInMonth(year, Calendar.MARCH);
	}

	public static int daysInApril(int year) {
		return daysInMonth(year, Calendar.APRIL);
	}

	public static int daysInMonth(int year, int month) {
		final Calendar cal = new GregorianCalendar(year, month, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static Date lastWeek() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		return cal.getTime();
	}

	public static Date yesterday() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_WEEK, -1);
		return cal.getTime();
	}

	public static Date tomorrow() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_WEEK, 1);
		return cal.getTime();
	}

	public static Date twoDaysAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -2);
		return cal.getTime();
	}

	public static Date threeDaysAgo() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -3);
		return cal.getTime();
	}

	public static Date fourDaysAgo() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -4);
		return cal.getTime();
	}

	public static Date daysAgo(int days) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_YEAR, -days);
		return cal.getTime();

	}

	public static Date oneWeekAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		return cal.getTime();
	}

	public static Date oneMonthAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}

	public static Date twoMonthsAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -2);
		return cal.getTime();
	}

	public static Date threeMonthsAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -3);
		return cal.getTime();
	}

	public static Date sixMonthsAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -6);
		return cal.getTime();
	}

	public static Date oneYearAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.YEAR, -1);
		return cal.getTime();
	}

	/**
	 * Get a {@link Date} for the specified number of months ago.
	 * 
	 * @param n
	 * @return
	 */
	public static Date monthsAgo(int n) {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -n);
		return cal.getTime();
	}

	public static Date todayAndNow() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		return cal.getTime();
	}

	public static Date todayAtDayEnd() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		adjustToDayEnd(cal);
		return cal.getTime();
	}

	/**
	 * Get a {@link Date} for the specified number of years ago.
	 * 
	 * @param n
	 * @return
	 */
	public static Date yearsAgo(int n) {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.YEAR, -n);
		return cal.getTime();
	}

	/**
	 * Set a period to day start and end.
	 * 
	 * @param from
	 * @param to
	 */
	public static void adjustToDayStartAndEnd(Date from, Date to) {
		adjustToDayStart(from);
		adjustToDayEnd(to);
	}

	/**
	 * Set the hour, minutes, seconds and milliseconds so the calendar
	 * represents midnight, which is the start of the day.
	 * 
	 * @param cal
	 */
	public static void adjustToDayStart(Calendar cal) {
		// When doing this, we push it forward one day, so if the day is 7 Jan
		// at 11:50:27h,
		// it will become 8 Jan at 00:00:00h, so we substract one day.
		cal.add(Calendar.DAY_OF_MONTH, -1);
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

	}

	public static Date adjustToDayStart(Date d) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		adjustToDayStart(cal);
		d.setTime(cal.getTime().getTime());
		return cal.getTime();
	}

	/**
	 * Set the calendar fields in the array to their actual (Considering the
	 * current Calendar time) max.
	 * 
	 * @param cal
	 * @param fields
	 */
	public static void adjustToFieldEnd(Calendar cal, int[] fields) {

		for (int i = 0; i < fields.length; i++) {
			int f = fields[i];
			if (f == Calendar.DAY_OF_WEEK_IN_MONTH) {
				cal.set(Calendar.DAY_OF_WEEK, lastDayOfWeek(cal));
			} else {
				cal.set(f, cal.getActualMaximum(f));
			}
		}
	}

	/**
	 * Set the calendar fields in the array to their actual (Considering the
	 * current Calendar time) minimum.
	 * 
	 * @param cal
	 * @param fields
	 */
	public static void adjustToFieldStart(Calendar cal, int[] fields) {

		for (int i = 0; i < fields.length; i++) {
			int f = fields[i];
			if (f == Calendar.DAY_OF_WEEK_IN_MONTH) {
				// int weekInMonth = cal.get(Calendar.WEEK_OF_MONTH);
				// Read the day of the week once. See bug:
				//
				cal.get(Calendar.DAY_OF_WEEK);
				cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
				// currentTime = cal.getTime();
			} else {
				cal.set(f, cal.getActualMinimum(f));
			}

		}
	}

	/**
	 * Set the hours, minutes, seconds and milliseconds so the calendar
	 * represents midnight minus one milli-second.
	 * 
	 * @param cal
	 */
	public static void adjustToDayEnd(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
	}

	public static Date adjustToDayEnd(Date d) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		adjustToDayEnd(cal);
		d.setTime(cal.getTime().getTime());
		return cal.getTime();
	}

	public static void setToFullHour(Calendar cal) {
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.MILLISECOND, 000);
	}

	public static Tuple interval(int interval) {

		String label = "";
		String primaryDatePattern = "";

		switch (interval) {
		case NonModelUtils.MINUTES_IN_AN_HOUR: {
			primaryDatePattern = "dd-MMM HH:mm";
			label = "HOUR";
		}
			break;
		case NonModelUtils.MINUTES_IN_A_DAY: {
			primaryDatePattern = "dd-MMM";
			label = "DAY";

		}
			break;
		case NonModelUtils.MINUTES_IN_A_WEEK: {
			primaryDatePattern = "ww";
			label = "WEEK";
		}
			break;
		case NonModelUtils.MINUTES_IN_A_MONTH: {
			primaryDatePattern = "MMMMM";
			label = "MONTH";
		}
			break;
		default: {
			primaryDatePattern = "dd-MMM HH:mm";
			label = fromMinutes(interval);
		}
		}
		return new Tuple(label, primaryDatePattern);
	}

	public static int inSeconds(String field) {
		final Function<String, Integer> getFieldInSeconds = new Function<String, Integer>() {
			public Integer apply(String from) {
				if (from.equals("Week")) {
					return NonModelUtils.SECONDS_IN_A_WEEK;
				}
				if (from.equals("Day")) {
					return NonModelUtils.SECONDS_IN_A_DAY;
				}
				if (from.equals("Hour")) {
					return NonModelUtils.SECONDS_IN_AN_HOUR;
				}
				if (from.equals("Quarter")) {
					return NonModelUtils.SECONDS_IN_15MIN;
				}

				if (from.endsWith("min")) {
					// Strip the minutes
					int indexOfMin = from.indexOf("min");
					from = from.substring(0, indexOfMin).trim();
					try {
						return new Integer(from) * 60;
					} catch (final NumberFormatException nfe) {
						// nfe.printStackTrace();
					}
				}

				try {
					return new Integer(from);
				} catch (final NumberFormatException nfe) {
					// nfe.printStackTrace();
				}
				return -1;
			}
		};
		return getFieldInSeconds.apply(field);
	}

	public static String fromMinutes(int minutes) {

		switch (minutes) {
		case MINUTES_IN_A_MONTH: {
			return "Month";
		}
		case MINUTES_IN_A_WEEK: {
			return "Week";
		}
		}
		return fromSeconds(minutes * 60);
	}

	/**
	 * Convert in an interval in seconds to a String value. The Week, Day and
	 * Hour values in seconds are converted to the respective screen. Any other
	 * value is converted to the number of minutes with a "min" prefix.
	 * 
	 * @param secs
	 * @return
	 */
	public static String fromSeconds(int secs) {
		final Function<Integer, String> getFieldInSeconds = new Function<Integer, String>() {
			public String apply(Integer from) {

				if (from.equals(NonModelUtils.SECONDS_IN_A_MONTH)) {
					return "Month";
				}
				if (from.equals(NonModelUtils.SECONDS_IN_A_WEEK)) {
					return "Week";
				}
				if (from.equals(NonModelUtils.SECONDS_IN_A_DAY)) {
					return "Day";
				}
				if (from.equals(NonModelUtils.SECONDS_IN_AN_HOUR)) {
					return "Hour";
				}

				// if (from.equals(ModelUtils.SECONDS_IN_A_QUARTER)) {
				// return "Quarter";
				// }

				// Do also multiples intepretation in minutes.
				if (from.intValue() % 60 == 0) {
					int minutes = from.intValue() / 60;
					return new Integer(minutes).toString() + " min";
				}

				return new Integer(from).toString();
			}
		};
		return getFieldInSeconds.apply(secs);
	}

	public static int inWeeks(String field) {
		final Function<String, Integer> getFieldInSeconds = new Function<String, Integer>() {
			public Integer apply(String from) {
				if (from.equals("Week")) {
					return 1;
				}
				return null;
			}
		};
		return getFieldInSeconds.apply(field);
	}

	public static String toString(Date date) {
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
	public static List<Date> occurences(Date start, Date end, int interval,
			int repeat) {
		return occurences(start, end, interval, repeat, 52);
	}

	public static List<Date> occurences(Date start, Date end, int interval,
			int repeat, int maxEntries) {

		final List<Date> occurences = Lists.newArrayList();
		Date occurenceDate = start;
		occurences.add(start);

		if (repeat > 0 && interval > 1) {
			// We roll on the interval from the start date until repeat is
			// reached.
			for (int i = 0; i < repeat; i++) {
				occurenceDate = rollSeconds(occurenceDate, interval);
				occurences.add(occurenceDate);
			}
			return occurences;
		}
		if (end != null && interval > 1) {
			// We roll on the interval from the start date until the end date.
			int i = 0;
			while (i < maxEntries) {
				occurenceDate = rollSeconds(occurenceDate, interval);
				if (!crossedDate(end, occurenceDate)) {
					occurences.add(occurenceDate);
				} else {
					break;
				}
				i++;
			}
			return occurences;
		}
		if (repeat == 0 && interval > 1) {
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

	/**
	 * Roll forward or backwards (With minus hours).
	 * 
	 * @param baseDate
	 * @param hours
	 * @return
	 */
	public static XMLGregorianCalendar rollHours(XMLGregorianCalendar baseDate,
			int hours) {
		GregorianCalendar gregorianCalendar = baseDate.toGregorianCalendar();
		gregorianCalendar.add(Calendar.HOUR_OF_DAY, hours);

		return toXMLDate(gregorianCalendar.getTime());
	}

	/**
	 * Roll forward or backwards (With minus hours).
	 * 
	 * @param baseDate
	 * @param hours
	 * @return
	 */
	public static Date rollHours(Date baseDate, int hours) {
		final Calendar c = GregorianCalendar.getInstance();
		c.setTime(baseDate);
		c.add(Calendar.HOUR_OF_DAY, hours);
		return c.getTime();
	}

	/**
	 * WARNING investigate this implementation. the Calendar should roll seconds
	 * properly.
	 * 
	 * @param baseDate
	 * @param seconds
	 * @return
	 */
	public static Date rollSeconds(Date baseDate, int seconds) {
		final Calendar c = GregorianCalendar.getInstance();
		c.setTime(baseDate);

		// We can't roll large numbers.
		if (seconds / SECONDS_IN_A_DAY > 0) {
			final int days = new Double(seconds / SECONDS_IN_A_DAY).intValue();
			c.add(Calendar.DAY_OF_YEAR, days);
			return c.getTime();
		}
		if (seconds / SECONDS_IN_AN_HOUR > 0) {
			final int hours = new Double(seconds / SECONDS_IN_AN_HOUR)
					.intValue();
			c.add(Calendar.HOUR_OF_DAY, hours);
			return c.getTime();
		}

		if (seconds / SECONDS_IN_A_MINUTE > 0) {
			final int minutes = new Double(seconds / SECONDS_IN_A_MINUTE)
					.intValue();
			c.add(Calendar.MINUTE, minutes);
			return c.getTime();
		}

		c.add(Calendar.SECOND, seconds);
		return c.getTime();

	}

	public static boolean crossedDate(Date refDate, Date variantDate) {
		final Calendar refCal = GregorianCalendar.getInstance();
		refCal.setTime(refDate);

		final Calendar variantCal = GregorianCalendar.getInstance();
		variantCal.setTime(variantDate);

		return refCal.compareTo(variantCal) < 0;

	}

	/**
	 * Casts to AbstractCDOIDLong and returns the long as String.
	 * 
	 * @param cdoObject
	 * @return
	 */
	public static String cdoLongIDAsString(CDOObject cdoObject) {
		long lValue = ((CDOIDObjectLongImpl) cdoObject.cdoID()).getLongValue();
		return new Long(lValue).toString();
	}

	public static String cdoLongIDAsString(CDOID cdoID) {
		long lValue = ((CDOIDObjectLongImpl) cdoID).getLongValue();
		return new Long(lValue).toString();
	}

	/**
	 * 
	 * @param eClass
	 * @param cdoString
	 * @return
	 */
	public static CDOID cdoLongIDFromString(EClass eClass, String cdoString) {
		return CDOIDUtil.createLongWithClassifier(new CDOClassifierRef(eClass),
				Long.parseLong(cdoString));
	}

	public static CDOID cdoLongIDFromString(String idString) {
		return CDOIDUtil.createLong(Long.parseLong(idString));
	}

	/**
	 * Get a CDOID for a String representing the Object ID.
	 * 
	 * @param s
	 * @return
	 */
	public static CDOID cdoStringAsCDOID(String s) {
		return CDOIDUtil.createLong(Long.parseLong(s));
	}

	public static String cdoResourcePath(CDOObject cdoObject) {
		if (cdoObject.eResource() != null) {
			Resource eResource = cdoObject.eResource();
			if (eResource instanceof CDOResource) {
				CDOResource cdoR = (CDOResource) eResource;
				return cdoR.getPath();
			}
		}
		return null;
	}

	/**
	 * Get all revisions from this object.
	 * 
	 * @param cdoObject
	 * @return
	 */
	public static Iterator<CDORevision> cdoRevisions(CDOObject cdoObject) {

		List<CDORevision> revisions = Lists.newArrayList();

		CDORevision cdoRevision = cdoObject.cdoRevision();
		// get the previous.
		for (int version = cdoRevision.getVersion(); version > 0; version--) {

			CDOBranchVersion branchVersion = cdoRevision.getBranch()
					.getVersion(version);

			CDORevision revision = cdoObject
					.cdoView()
					.getSession()
					.getRevisionManager()
					.getRevisionByVersion(cdoObject.cdoID(), branchVersion, 0,
							true);
			revisions.add(revision);
		}
		return revisions.iterator();
	}

	/**
	 * Make a string representation of a CDO Object.
	 * 
	 * @param next
	 * @return
	 */
	public static String cdoObjectToString(CDOObject cdoObject,
			String objectText) {
		StringBuffer sb = new StringBuffer();

		CDORevision cdoRevision = cdoObject.cdoRevision();
		int version = -1;
		if (cdoRevision != null) {
			version = cdoRevision.getVersion();
		}
		CDOID cdoID = cdoObject.cdoID();
		CDOResource cdoResource = cdoObject.cdoResource();

		sb.append(objectText + " ");

		// Depending on the state, transient don't have an Object. ID>
		if (cdoID != null) {
			sb.append("OID: " + cdoID + " ");
		}
		if (version != -1) {
			sb.append("version: " + version + " ");
		}

		sb.append("state: " + cdoObject.cdoState() + " ");

		if (cdoResource != null) {
			sb.append("path: " + cdoResource.getPath());
		}

		return sb.toString();
	}

	/**
	 * Dump the content of a CDORevision. Iterates through the features of the
	 * revision, and gets the value of the object. The String will not exceed a
	 * maximum change length.
	 * 
	 * @param revision
	 * @return
	 */
	public static String cdoDumpNewObject(InternalCDORevision revision) {
		final StringBuilder sb = new StringBuilder();
		for (final EStructuralFeature feature : revision.getClassInfo()
				.getAllPersistentFeatures()) {
			final Object value = revision.getValue(feature);
			cdoDumpFeature(sb, feature, value);
		}
		return truncate(sb.toString());
	}

	/**
	 * For each {@link CDOFeatureDelta} in the collection, dump the feature
	 * delta content to the StringBuffer.
	 * 
	 * @param sb
	 * @param featureDeltas
	 */
	public static void cdoDumpFeatureDeltas(StringBuilder sb,
			List<CDOFeatureDelta> featureDeltas) {
		for (final CDOFeatureDelta featureDelta : featureDeltas) {
			if (featureDelta instanceof CDOListFeatureDelta) {
				final CDOListFeatureDelta list = (CDOListFeatureDelta) featureDelta;
				cdoDumpFeatureDeltas(sb, list.getListChanges());
			} else {
				cdoDumpFeature(sb, featureDelta);
			}
		}
	}

	public static void cdoDumpFeature(StringBuilder sb,
			EStructuralFeature feature, Object value) {
		addNewLine(sb);
		sb.append(feature.getName() + " = " + value);
	}

	public static void cdoDumpFeature(StringBuilder sb,
			CDOFeatureDelta featureDelta) {
		addNewLine(sb);
		sb.append(featureDelta.getFeature().getName() + " = "
				+ cdoPrintFeatureDelta(featureDelta));
	}

	public static String cdoPrintFeatureDelta(CDOFeatureDelta delta) {
		String str = delta.toString();
		if (str.indexOf(",") != -1) {
			// do + 2 to get of one space
			str = str.substring(str.indexOf(",") + 2);
		}
		// and get rid of the ] at the end
		return str.substring(0, str.length() - 1);
	}

	public static void addNewLine(StringBuilder sb) {
		if (sb.length() > 0) {
			sb.append("\n");
		}
	}

	/**
	 * Truncates a string to the max. length of a change.
	 * 
	 * @param value
	 * @return
	 */
	public static String truncate(String value) {
		if (value.length() >= MAX_CHANGE_LENGTH) {
			return value.substring(0, MAX_CHANGE_LENGTH);
		}
		return value;
	}

	public static CDOObject cdoObject(CDOObject currentObject,
			CDORevision cdoRevision) {
		CDOView revView = currentObject.cdoView().getSession().openView();
		boolean revViewOk = revView.setTimeStamp(cdoRevision.getTimeStamp());
		if (revViewOk) {
			CDOObject object = revView.getObject(cdoRevision.getID());
			return object;
		}
		return null;
	}

	public static void cdoDumpRevisionDelta(CDORevisionDelta delta) {
		for (CDOFeatureDelta fd : delta.getFeatureDeltas()) {
			System.out.println("-- delta=" + fd);
		}
	}

	/**
	 * Print the {@link CDORevisionDelta Revision delta} to a
	 * {@link StringBuffer}, for a {@link CDOTransaction transaction}. The
	 * content will contain information from {@link CDOFeatureDelta the feature
	 * delta(s)}
	 * 
	 * @param sb
	 * @param transaction
	 */
	public static void cdoPrintRevisionDeltas(StringBuffer sb,
			CDOTransaction transaction) {
		Map<CDOID, CDORevisionDelta> revisionDeltas = transaction
				.getRevisionDeltas();
		for (CDORevisionDelta delta : revisionDeltas.values()) {
			for (CDOFeatureDelta fd : delta.getFeatureDeltas()) {
				sb.append("\n delta: " + fd);
			}
		}
	}

	public static void cdoPrintFeatureDeltas(StringBuffer sb,
			List<CDOFeatureDelta> deltas) {

		for (CDOFeatureDelta fd : deltas) {
			Type type = fd.getType();
			sb.append("\n    delta: " + " type:" + type);
			sb.append("\n     feature: " + fd.getFeature().getName());
			switch (type) {
			case LIST: {
				CDOListFeatureDelta castedFd = (CDOListFeatureDelta) fd;
				// Dependency on CDO 4.2
				// sb.append("\n     original size: " +
				// castedFd.getOriginSize());
				cdoPrintFeatureDeltas(sb, castedFd.getListChanges());
			}
				break;
			case ADD: {
				CDOAddFeatureDelta castedFd = (CDOAddFeatureDelta) fd;
				sb.append("\n     index: " + castedFd.getIndex());
				if (castedFd.getFeature().isMany()) {
					// castedFd.getFeature().
				}
			}
				break;
			case SET: {
				CDOSetFeatureDelta castedFd = (CDOSetFeatureDelta) fd;

				sb.append("\n     index: " + castedFd.getIndex());
				sb.append("\n     old: " + castedFd.getOldValue() + " new: "
						+ castedFd.getValue());
			}

				break;
			case REMOVE: {
				CDORemoveFeatureDelta castedFd = (CDORemoveFeatureDelta) fd;
				sb.append("\n     index: " + castedFd.getIndex());
			}
				break;

			default: {
				sb.append(" TODO create an entry for  type " + type
						+ " entry for feature delta attributes of this type");
			}
			}

		}
	}

	public static void cdoPrintRevisionDelta(StringBuffer sb,
			CDORevisionDelta delta) {
		for (CDOFeatureDelta fd : delta.getFeatureDeltas()) {
			sb.append("-- delta=" + fd);
		}
	}

	/**
	 * Appends the cdo Object ID to the actual object resource name.
	 * 
	 * @param object
	 * @return
	 */
	public static String resolveHistoricalResourceName(Object object) {

		if (!(object instanceof CDOObject)) {
			return null;
		}

		// TODO, keep a cache of CDOObject ID, and resource path.
		String affectedPath = cdoResourcePath((CDOObject) object);

		// The object needs to be in the correct state, if not persisted (CLEAN,
		// DIRTY etc..),
		// no cdoID will be present.
		CDOID id = ((CDOObject) object).cdoID();
		if (id != null) {
			URI idURI = URI.createURI(id.toURIFragment());
			String fragment = idURI.fragment();
			if (fragment != null) {
				String[] fragments = fragment.split("#");
				affectedPath = affectedPath + "_"
						+ fragments[fragments.length - 1];
			}
			return affectedPath;
		} else
			return null;
	}

	/**
	 * Transform a list of resources to a list of URI for the resource.
	 * 
	 * @param resources
	 * @return
	 */
	public static List<URI> transformResourceToURI(List<Resource> resources) {
		final Function<Resource, URI> resourceToURI = new Function<Resource, URI>() {
			public URI apply(Resource from) {
				return from.getURI();
			}
		};
		return Lists.transform(resources, resourceToURI);
	}

	public static Iterator<CDOObject> transformEObjectToCDOObjects(
			Iterator<EObject> eObjects) {
		final Function<EObject, CDOObject> cdoObjectFromEObject = new Function<EObject, CDOObject>() {
			public CDOObject apply(EObject from) {
				return (CDOObject) from;
			}
		};
		return Iterators.transform(eObjects, cdoObjectFromEObject);
	}

	public static List<Double> transformBigDecimalToDouble(
			List<BigDecimal> values) {
		final Function<BigDecimal, Double> valueToBigDecimal = new Function<BigDecimal, Double>() {
			public Double apply(BigDecimal from) {
				return from.doubleValue();
			}
		};
		return Lists.transform(values, valueToBigDecimal);
	}

	public static double[] multiplyByHundredAndToArray(List<Double> values) {
		final Function<Double, Double> valueToDouble = new Function<Double, Double>() {
			public Double apply(Double from) {
				return from * 100;
			}
		};
		List<Double> doubles = Lists.transform(values, valueToDouble);
		double[] doubleArray = new double[doubles.size()];
		for (int i = 0; i < doubles.size(); i++) {
			doubleArray[i] = doubles.get(i).doubleValue();
		}
		return doubleArray;
	}

	public static List<Date> transformXMLDateToDate(
			Collection<XMLGregorianCalendar> dates) {
		final Function<XMLGregorianCalendar, Date> valueToDouble = new Function<XMLGregorianCalendar, Date>() {
			public Date apply(XMLGregorianCalendar from) {
				return fromXMLDate(from);
			}
		};
		return Lists.newArrayList(Iterables.transform(dates, valueToDouble));
	}

	/**
	 * Get the last day of the week respecting the first day of the week for the
	 * provided Calendar.
	 * 
	 * @param cal
	 * @return
	 */
	public static int lastDayOfWeek(Calendar cal) {
		final int firstDayOfWeek = cal.getFirstDayOfWeek();

		final int lastDayOfWeek;
		if (firstDayOfWeek != 1) {
			lastDayOfWeek = firstDayOfWeek - 1; // One before the first day...
		} else {
			lastDayOfWeek = cal.getActualMaximum(Calendar.DAY_OF_WEEK); // Expect
		}
		return lastDayOfWeek;
	}

	public static int positionOf(List<Date> dates, Date toCheckDate) {
		int indexOf = dates.indexOf(toCheckDate);
		return indexOf;
	}

	/**
	 * Transform to a primitive double array.
	 * 
	 * @param values
	 * @return
	 */
	public static double[] transformToDoublePrimitiveArray(List<Double> values) {
		final double[] doubles = new double[values.size()];
		int i = 0;
		for (final Double d : values) {
			doubles[i] = d.doubleValue();
			i++;
		}
		return doubles;
	}

	/**
	 * Transform to an Array primitive double array.
	 * 
	 * @param values
	 * @return
	 */
	public static double[] transformToDoublePrimitiveArray(Double[] values) {
		final double[] doubles = new double[values.length];
		int i = 0;
		for (final Double d : values) {
			doubles[i] = d.doubleValue();
			i++;
		}
		return doubles;
	}

	/**
	 * Transform from a Double list to a double array.
	 * 
	 * @param values
	 * @return
	 */
	public static Double[] transformToDoubleArray(double[] array) {
		final Double[] doubles = new Double[array.length];
		int i = 0;
		for (final double d : array) {
			doubles[i] = d;
			i++;
		}
		return doubles;
	}

	/**
	 * look down the containment tree, and find the most recenrt date.
	 * 
	 * @param object
	 * @return
	 */
	public static long mostRecentContainedDated(CDOObject object) {

		long ts = object.cdoRevision().getTimeStamp();

		TreeIterator<EObject> eAllContents = object.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eo = eAllContents.next();
			if (eo.eContainer() != null) {
				// We are contained, so we might have been updated.
				if (eo instanceof CDOObject) {
					long leafTS = ((CDOObject) eo).cdoRevision().getTimeStamp();
					if (leafTS > ts) {
						ts = leafTS;
					}
				}

			}
		}
		return ts;
	}

	public static class CollectionForObjects<T> {

		@SuppressWarnings("unchecked")
		public List<T> collectionForObjects(List<EObject> objects) {

			List<T> typedList = Lists.transform(objects,
					new Function<Object, T>() {
						public T apply(Object from) {
							return (T) from;
						}
					});
			return typedList;
		}

	}

	/**
	 * Let's vommit!
	 */
	public static void puke() {
		System.out.println("Beeeeuuuuuuh........@!");

	}
}
