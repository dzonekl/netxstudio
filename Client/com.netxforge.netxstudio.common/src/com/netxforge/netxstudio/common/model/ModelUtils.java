package com.netxforge.netxstudio.common.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.operators.Node;

public class ModelUtils {

	public static final String DATE_PATTERN_1 = "MM/dd/yyyy";
	public static final String DATE_PATTERN_2 = "dd-MM-yyyy";
	public static final String DATE_PATTERN_3 = "dd.MM.yyyy";

	public static final String TIME_PATTERN_1 = "HH:mm:ss"; // 24 hour.
	public static final String TIME_PATTERN_2 = "HH:mm"; // 24 hour
	public static final String TIME_PATTERN_3 = "hh:mm:ss"; // AM PM
	public static final String TIME_PATTERN_4 = "hh:mm"; // AM PM

	public static final String TIM_PATTERN_5 = "a" // AM PM marker.
	;
	public static final String DEFAULT_DATE_TIME_PATTERN = "MM/dd/yyyy hh:mm:ss";

	public class InsideRange implements Predicate<Value> {
		private final DateTimeRange dtr;

		public InsideRange(final DateTimeRange dtr) {
			this.dtr = dtr;
		}

		public boolean apply(final Value v) {
			Date begin = fromXMLDate(dtr.getBegin());
			Date end = fromXMLDate(dtr.getEnd());
			Date target = fromXMLDate(v.getTimeStamp());
			return ( target == begin || target == end ) || begin.before(target) && end.after(target);
		}
	}

	@Inject
	private DatatypeFactory dataTypeFactory;

	/**
	 * Compute a resource path on the basis of an instance. Components generate
	 * a specific path based on their location in the node/nodetype tree.
	 */
	public String getResourcePath(EObject eObject) {
		if (eObject instanceof Component) {
			final Component component = (Component) eObject;
			return getResourcePath(component.eContainer()) + "/"
					+ component.getName();
		} else if (eObject instanceof Node) {
			return "/Node_/" + ((Node) eObject).getNodeID();
		} else if (eObject instanceof NodeType) {
			final NodeType nodeType = (NodeType) eObject;
			if (nodeType.eContainer() instanceof Node) {
				return getResourcePath(nodeType.eContainer());
			}
			return "/NodeType_/" + ((NodeType) eObject).getName();
		} else {
			return eObject.eClass().getName();
		}
	}

	public List<com.netxforge.netxstudio.library.Function> functionsWithName(
			List<com.netxforge.netxstudio.library.Function> functions,
			String name) {
		final List<com.netxforge.netxstudio.library.Function> fl = Lists
				.newArrayList();
		for (final com.netxforge.netxstudio.library.Function f : functions) {
			if (f.getName().equals(name)) {
				fl.add(f);
			}
			fl.addAll(this.functionsWithName(f.getFunctions(), name));
		}
		return fl;
	}

	public List<Equipment> equimentsWithCode(List<Equipment> equips, String code) {
		final List<Equipment> el = Lists.newArrayList();
		for (final Equipment e : equips) {
			if (e.getEquipmentCode().equals(code)) {
				el.add(e);
			}
			el.addAll(this.equimentsWithCode(e.getEquipments(), code));
		}
		return el;
	}

	public List<NetXResource> resourcesWithName(Node n, String expressionName) {
		final List<Component> cl = Lists.newArrayList();
		cl.addAll(n.getNodeType().getEquipments());
		cl.addAll(n.getNodeType().getFunctions());
		return this.resourcesWithExpressionName(cl, expressionName);
	}

	/**
	 * Return the Node or null if the target object, has a Node somewhere along
	 * the parent hiearchy.
	 * 
	 * @param target
	 * @return
	 */
	public Node resolveParentNode(EObject target) {
		if (target != null && target.eContainer() != null) {
			if (target.eContainer() instanceof Node) {
				return (Node) target.eContainer();
			} else {
				return resolveParentNode(target.eContainer());
			}
		} else {
			return null;
		}
	}

	/**
	 * Return the Node or null if the target object, has a NodeType somewhere
	 * along the parent hiearchy.
	 * 
	 * @param target
	 * @return
	 */
	public NodeType resolveParentNodeType(EObject target) {
		if (target != null && target.eContainer() != null) {
			if (target.eContainer() instanceof NodeType) {
				return (NodeType) target.eContainer();
			} else {
				return resolveParentNodeType(target.eContainer());
			}
		} else {
			return null;
		}
	}

	public List<NetXResource> resourcesInMetricSource(
			EList<EObject> allMetrics, MetricSource ms) {

		List<Metric> targetListInMetricSource = Lists.newArrayList();

		// Cross reference the metrics.
		for (EObject o : allMetrics) {
			if (o instanceof CDOObject) {
				CDOView cdoView = ((CDOObject) o).cdoView();
				try {
					List<CDOObjectReference> queryXRefs = cdoView
							.queryXRefs(
									(CDOObject) o,
									new EReference[] { MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF });

					if (queryXRefs != null) {
						for (CDOObjectReference xref : queryXRefs) {

							EObject referencingValueDataKind = xref
									.getSourceObject();
							EObject targetMetric = xref.getTargetObject();
							for (MappingColumn mc : ms.getMetricMapping()
									.getDataMappingColumns()) {
								DataKind dk = mc.getDataType();
								// auch, that hurts....
								if (dk instanceof ValueDataKind
										&& (dk.cdoID() == ((CDOObject) referencingValueDataKind)
												.cdoID())) {
									// Yes, this is the one, add the metric.
									targetListInMetricSource
											.add((Metric) targetMetric);
								}
							}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					// The query sometimes throws exeception, if i.e an entity
					// can't be found..
					// EClass ExpressionResult does not have an entity name, has
					// it been mapped to Hibernate?
				}
			}
		}

		List<NetXResource> targetListNetXResources = Lists.newArrayList();

		// Cross reference the metrics from the target MetricSource.
		for (EObject o : targetListInMetricSource) {

			System.out.println("Look for NetXResource referencing : "
					+ ((Metric) o).getName());

			if (o instanceof CDOObject) {
				CDOView cdoView = ((CDOObject) o).cdoView();
				try {
					List<CDOObjectReference> queryXRefs = cdoView
							.queryXRefs(
									(CDOObject) o,
									new EReference[] { LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF });

					if (queryXRefs != null) {
						for (CDOObjectReference xref : queryXRefs) {

							EObject referencingEObject = xref.getSourceObject();
							// Gather all metrics from the target source.
							if (referencingEObject instanceof NetXResource) {
								NetXResource res = (NetXResource) referencingEObject;
								Node n = this.resolveParentNode(res
										.getComponentRef());
								if (n != null) {
									targetListNetXResources
											.add((NetXResource) referencingEObject);
								}
							}

						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					// The query sometimes throws exeception, if i.e an entity
					// can't be found..
					// EClass ExpressionResult does not have an entity name, has
					// it been mapped to Hibernate?
				}
			}
		}

		return targetListNetXResources;
	}

	/**
	 * Get a collection from a target object, use the last occurrence in the
	 * collection, to get an attribute value. return the attribute value
	 * incremented by 1.
	 * 
	 * 
	 * @param targetObject
	 * @param collectionFeature
	 * @param identityFeature
	 *            An identity attribute which should be of type String.
	 * @return A String incremented by 1.
	 */
	public String getSequenceNumber(EObject targetObject,
			EStructuralFeature collectionFeature, EAttribute identityFeature) {
		String newName = null;
		if (collectionFeature.isMany()) {
			final List<?> collection = (List<?>) targetObject
					.eGet(collectionFeature);
			final int size = collection.size();
			if (size > 0) {
				final EObject lastChild = (EObject) collection.get(size - 1);
				if (lastChild.eIsSet(identityFeature)) {
					final String lastName = (String) lastChild
							.eGet(identityFeature);
					// See if the last 2 chars are a digit.
					try {

						final Pattern MY_PATTERN = Pattern.compile("[0-9]*");
						final Matcher m = MY_PATTERN.matcher(lastName);
						String lastDigits = null;
						while (m.find()) {
							final String match = m.group();
							if (!match.isEmpty())
								lastDigits = match;
						}
						if (lastDigits != null) {
							final String nameWithNoDigits = lastName.substring(
									0, lastName.indexOf(lastDigits));
							try {
								Integer ld = new Integer(lastDigits);
								ld++;
								// Perhaps format with 0...

								// Do a simple text format.
								final DecimalFormat format = new DecimalFormat();
								format.applyPattern("###");
								newName = nameWithNoDigits + format.format(ld);

							} catch (final NumberFormatException nfe) {
								System.err.println("ModelUtils: Can't formart"
										+ lastDigits);
							}
						}
					} catch (final PatternSyntaxException pse) {
						System.err.println("ModelUtils: Wrong syntax");
					}
				}
			}
			if (newName == null) {
				newName = "1";
			}

		}

		return newName;
	}
	
	/**
	 * Iterate through the ranges, and find for this interval. 
	 * 
	 * @param resource
	 * @param targetInterval
	 * @return
	 */
	public MetricValueRange valueRangeForInterval(NetXResource resource, int targetInterval){
		for( MetricValueRange mvr : resource.getMetricValueRanges()){
			if(mvr.getIntervalHint() == targetInterval){
				return mvr;
			}
		}
		return null;
	}

	/**
	 * Resources with this name. Notice: Matching is on regular expression, i.e.
	 * name = .* is all resources.
	 * 
	 * @param components
	 * @param name
	 * @return
	 */
	public List<NetXResource> resourcesWithExpressionName(
			List<Component> components, String name) {
		final List<NetXResource> rl = Lists.newArrayList();
		final List<Component> cl = Lists.newArrayList();
		for (final Component c : components) {
			for (final NetXResource r : c.getResourceRefs()) {
				if (r.getExpressionName().matches(name)) {
					rl.add(r);
				}
			}
			if (c instanceof Equipment) {
				cl.addAll(((Equipment) c).getEquipments());
			}
			if (c instanceof com.netxforge.netxstudio.library.Function) {
				cl.addAll(((com.netxforge.netxstudio.library.Function) c)
						.getFunctions());
			}
			rl.addAll(this.resourcesWithExpressionName(cl, name));
		}
		return rl;
	}

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

	public List<Integer> weekDaysAsInteger() {
		final List<Integer> week = ImmutableList.of(Calendar.MONDAY,
				Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY,
				Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY);
		return week;
	}

	public int weekDay(Date date) {

		final Function<Date, Integer> getDayString = new Function<Date, Integer>() {
			public Integer apply(Date from) {
				final Calendar c = GregorianCalendar.getInstance();
				c.setTime(from);
				return new Integer(c.get(Calendar.DAY_OF_WEEK));
			}
		};
		return getDayString.apply(date);
	}

	public String weekDay(Integer weekDay) {
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

	public String date(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	public String time(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("HH:mm");
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

	public int weekDay(String day) {
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

	public Date mergeDateIntoTime(Date baseTime, Date targetDate) {

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
	public Date mergeDayIntoDate(Date baseDate, int dayOfWeek) {

		final Calendar c = GregorianCalendar.getInstance();
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
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		return cal.getTime();
	}

	public Date yesterday() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_WEEK, -1);
		return cal.getTime();
	}

	public Date tomorrow() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_WEEK, 1);
		return cal.getTime();
	}

	public Date twoDaysAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -2);
		return cal.getTime();
	}

	public Date threeDaysAgo() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -3);
		return cal.getTime();
	}

	public Date fourDaysAgo() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -4);
		return cal.getTime();
	}

	public Date oneMonthAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}

	public Date twoMonthsAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -2);
		return cal.getTime();
	}

	public Date threeMonthsAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -3);
		return cal.getTime();
	}

	public Date todayAndNow() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		return cal.getTime();
	}

	public int inSeconds(String field) {
		final Function<String, Integer> getFieldInSeconds = new Function<String, Integer>() {
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
				try {
					return new Integer(from);
				} catch (final NumberFormatException nfe) {
					nfe.printStackTrace();
				}
				return -1;
			}
		};
		return getFieldInSeconds.apply(field);
	}

	public String fromSeconds(int secs) {
		final Function<Integer, String> getFieldInSeconds = new Function<Integer, String>() {
			public String apply(Integer from) {

				if (from.equals(ModelUtils.SECONDS_IN_A_WEEK)) {
					return "Week";
				}
				if (from.equals(ModelUtils.SECONDS_IN_A_DAY)) {
					return "Day";
				}
				if (from.equals(ModelUtils.SECONDS_IN_AN_HOUR)) {
					return "Hour";
				}
				if (from.equals(ModelUtils.SECONDS_IN_A_QUARTER)) {
					return "Quarter";
				}
				return new Integer(from).toString();
			}
		};
		return getFieldInSeconds.apply(secs);
	}

	public int inWeeks(String field) {
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

	public Date rollSeconds(Date baseDate, int seconds) {
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

	public boolean crossedDate(Date refDate, Date variantDate) {
		final Calendar refCal = GregorianCalendar.getInstance();
		refCal.setTime(refDate);

		final Calendar variantCal = GregorianCalendar.getInstance();
		variantCal.setTime(variantDate);

		return refCal.compareTo(variantCal) < 0;

	}

	/**
	 * Transform a list of Value object, to only the value part of the Value
	 * Object.
	 * 
	 * @param values
	 * @return
	 */
	public List<BigDecimal> transformValueToBigDecimal(List<Value> values) {
		final Function<Value, BigDecimal> valueToBigDecimal = new Function<Value, BigDecimal>() {
			public BigDecimal apply(Value from) {
				return new BigDecimal(from.getValue());
			}
		};
		return Lists.transform(values, valueToBigDecimal);
	}

	public List<Double> transformBigDecimalToDouble(List<BigDecimal> values) {
		final Function<BigDecimal, Double> valueToBigDecimal = new Function<BigDecimal, Double>() {
			public Double apply(BigDecimal from) {
				return from.doubleValue();
			}
		};
		return Lists.transform(values, valueToBigDecimal);
	}

	public List<Double> transformValueToDouble(List<Value> values) {
		final Function<Value, Double> valueToDouble = new Function<Value, Double>() {
			public Double apply(Value from) {
				return from.getValue();
			}
		};
		return Lists.transform(values, valueToDouble);
	}

	public List<Date> transformValueToDate(List<Value> values) {
		final Function<Value, Date> valueToDouble = new Function<Value, Date>() {
			public Date apply(Value from) {
				return fromXMLDate(from.getTimeStamp());
			}
		};
		return Lists.transform(values, valueToDouble);
	}

	/**
	 * FIXME, No other way that iterator through.
	 * 
	 * @param values
	 * @return
	 */
	public double[] transformToDoublePrimitiveArray(List<Double> values) {
		final double[] doubles = new double[values.size()];
		int i = 0;
		for (final Double d : values) {
			doubles[i] = d.doubleValue();
			i++;
		}
		return doubles;
	}

}
