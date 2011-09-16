package com.netxforge.netxstudio.common.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LevelKind;
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
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceMonitor;

public class ModelUtils {

	public static final String DATE_PATTERN_1 = "MM/dd/yyyy";
	public static final String DATE_PATTERN_2 = "dd-MM-yyyy";
	public static final String DATE_PATTERN_3 = "dd.MM.yyyy";

	public static final String TIME_PATTERN_1 = "HH:mm:ss"; // 24 hour.
	public static final String TIME_PATTERN_2 = "HH:mm"; // 24 hour
	public static final String TIME_PATTERN_3 = "hh:mm:ss"; // AM PM
	public static final String TIME_PATTERN_4 = "hh:mm"; // AM PM

	public static final String TIM_PATTERN_5 = "a"; // AM PM marker.
	public static final String DEFAULT_DATE_TIME_PATTERN = "MM/dd/yyyy hh:mm:ss";

	public static final int SECONDS_IN_A_MINUTE = 60;
	public static final int SECONDS_IN_A_QUARTER = SECONDS_IN_A_MINUTE * 15;
	public static final int SECONDS_IN_AN_HOUR = SECONDS_IN_A_MINUTE * 60;
	public static final int SECONDS_IN_A_DAY = SECONDS_IN_AN_HOUR * 24;
	public static final int SECONDS_IN_A_WEEK = SECONDS_IN_A_DAY * 7;

	public static final int MINUTES_IN_AN_HOUR = 60;
	public static final int MINUTES_IN_A_DAY = 60 * 24;
	public static final int MINUTES_IN_A_WEEK = MINUTES_IN_A_DAY * 4;

	// Note! For months, we better use a calendar function.
	public static final int MINUTES_IN_A_MONTH = MINUTES_IN_A_DAY * 30;

	/**
	 * Compare two dates.
	 */
	public class TimeStampComparator implements Comparator<Value> {
		public int compare(final Value v1, final Value v2) {
			return v1.getTimeStamp().compare(v2.getTimeStamp());
		}
	};

	public TimeStampComparator tsCompare() {
		return new TimeStampComparator();
	}

	public class InsideRange implements Predicate<Value> {
		private final DateTimeRange dtr;

		public InsideRange(final DateTimeRange dtr) {
			this.dtr = dtr;
		}

		public boolean apply(final Value v) {
			Date begin = fromXMLDate(dtr.getBegin());
			Date end = fromXMLDate(dtr.getEnd());
			Date target = fromXMLDate(v.getTimeStamp());
			return (target == begin || target == end) || begin.before(target)
					&& end.after(target);
		}
	}

	public InsideRange insideRange(DateTimeRange dtr) {
		return new InsideRange(dtr);
	}

	public boolean isValidNode(Node node) {
		if (node.getLifecycle() == null) {
			return true;
		}
		final long time = System.currentTimeMillis();
		if (node.getLifecycle().getInServiceDate() != null
				&& node.getLifecycle().getInServiceDate().toGregorianCalendar()
						.getTimeInMillis() > time) {
			return false;
		}
		if (node.getLifecycle().getOutOfServiceDate() != null
				&& node.getLifecycle().getOutOfServiceDate()
						.toGregorianCalendar().getTimeInMillis() < time) {
			return false;
		}
		return true;
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

	public List<NetXResource> allResources(Node node) {
		List<NetXResource> resources = Lists.newArrayList();
		TreeIterator<EObject> iterator = node.eAllContents();
		while (iterator.hasNext()) {
			EObject eo = iterator.next();
			if (eo instanceof NetXResource) {
				resources.add((NetXResource) eo);
			}
		}
		return resources;
	}

	public List<NetXResource> resourcesWithName(Node n, String expressionName) {
		final List<Component> cl = Lists.newArrayList();
		cl.addAll(n.getNodeType().getEquipments());
		cl.addAll(n.getNodeType().getFunctions());
		return this.resourcesWithExpressionName(cl, expressionName);
	}

	public List<Value> sortByTimeStampAndReverse(List<Value> values) {
		System.out.println("ResourceMonitor: sorting entries:" + values.size()
				+ new Date(System.currentTimeMillis()));

		List<Value> sortedCopy = Ordering.from(tsCompare()).reverse()
				.sortedCopy(values);

		System.out.println("ResourceMonitor: done sorting entries:"
				+ new Date(System.currentTimeMillis()));
		return sortedCopy;

	}

	public List<Value> filterInRange(List<Value> unfiltered, DateTimeRange dtr) {
		Iterable<Value> filterValues = Iterables.filter(unfiltered,
				this.insideRange(dtr));
		return (Lists.newArrayList(filterValues));
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

	public ServiceMonitor lastServiceMonitor(Service service) {
		if (service.getServiceMonitors().isEmpty()) {
			return null;
		}
		int size = service.getServiceMonitors().size();
		ServiceMonitor sm = service.getServiceMonitors().get(size - 1);
		return sm;
	}

	// public class HasNodeType implements Predicate<NodeType> {
	//
	// private List<NodeType> baseList;
	//
	// public HasNodeType(List<NodeType> baseList) {
	// this.baseList = baseList;
	// }
	// public boolean apply(final NodeType toApply) {
	// for(NodeType nt : baseList){
	// if(nt.getName().equals(toApply)){
	// return true;
	// }
	// }
	// return false;
	// }
	// }
	//
	// public Predicate<NodeType> hasNodeType(List<NodeType> nodeTypes){
	// return new HasNodeType(nodeTypes);
	// }

	public List<NodeType> uniqueNodeTypes(List<NodeType> unfiltered) {
		List<NodeType> uniques = Lists.newArrayList();
		for (NodeType nt : unfiltered) {
			ImmutableList<NodeType> uniquesCopy = ImmutableList.copyOf(uniques);
			boolean found = false;
			for (NodeType u : uniquesCopy) {
				if (nt.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)
						&& u.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)) {
					if (u.getName().equals(nt.getName())) {
						found = true;
					}
				} else {
					continue;
				}
			}
			if (!found) {
				uniques.add(nt);
			}
		}
		return uniques;
	}

	/**
	 * Overall RAG Status.
	 * 
	 * @param sm
	 * @return
	 */
	public int[] ragCount(ServiceMonitor sm) {

		int red = 0, amber = 0, green = 0;

		for (ResourceMonitor rm : sm.getResourceMonitors()) {
			Marker[] markerArray = new Marker[rm.getMarkers().size()];
			ToleranceMarker tm = lastToleranceMarker(rm.getMarkers().toArray(
					markerArray));
			switch (tm.getLevel().getValue()) {
			case LevelKind.RED_VALUE: {
				red++;
			}
				break;
			case LevelKind.AMBER_VALUE: {
				red++;
			}
				break;
			case LevelKind.GREEN_VALUE: {
				red++;
			}
				break;

			}
		}

		return new int[] { red, amber, green };

	}

	public boolean ragShouldReport(int[] ragStatus) {
		if (ragStatus.length != 3) {
			return false;
		}

		if (ragStatus[0] > 0) {
			return true;
		}

		if (ragStatus[1] > 0) {
			return true;
		}

		return false;
	}
	
	
	public int[] ragCount(Service service, Node n, DateTimeRange dtr) {

		// FIXME Implement getting markers for a time range.
		// So should iterator over service monitors inside this range and
		// return the markers for this node (Within the range).
		return new int[] { 0, 0, 0 };
	}

	public int[] ragCount(Node n, ServiceMonitor sm) {

		if (sm == null) {
			return new int[] { 0, 0, 0 };
		}

		int red = 0, amber = 0, green = 0;

		for (ResourceMonitor rm : sm.getResourceMonitors()) {

			Marker[] markerArray = new Marker[rm.getMarkers().size()];
			List<Marker> markersForNodeList = this.markersForNode(n,
					markerArray);

			Marker[] markerForNodeArray = new Marker[markersForNodeList.size()];
			ToleranceMarker tm = lastToleranceMarker(markersForNodeList
					.toArray(markerForNodeArray));

			switch (tm.getLevel().getValue()) {
			case LevelKind.RED_VALUE: {
				red++;
			}
				break;
			case LevelKind.AMBER_VALUE: {
				red++;
			}
				break;
			case LevelKind.GREEN_VALUE: {
				red++;
			}
				break;
			}
		}
		return new int[] { red, amber, green };
	}

	public List<Marker> markersForNode(Node n, Marker... markers) {
		List<Marker> resultList = Lists.newArrayList();
		List<Marker> markerList = Lists.newArrayList(markers);
		for (Marker m : markerList) {
			if (m instanceof ToleranceMarker) {
				ToleranceMarker tempMarker = (ToleranceMarker) m;

				if (tempMarker
						.eIsSet(OperatorsPackage.Literals.MARKER__COMPONENT_REF)) {
					Node resolvedNode = this.resolveParentNode(tempMarker
							.getComponentRef());
					if (resolvedNode.getNodeID().equals(n.getNodeID())) {
						resultList.add(tempMarker);
					}
				}
			}
		}
		return resultList;
	}

	public ToleranceMarker lastToleranceMarker(Marker... markers) {
		ToleranceMarker tm = null;
		List<Marker> markerList = Lists.newArrayList(markers);

		// TODO, We are not sure the list is sorted by marker value's timestamp,
		// here we simply reverse the list, but this could well be wrong.
		// Otherwise, use a Comparator, to sort first. (See ResourceMonitor).

		Collections.reverse(markerList);
		for (Marker m : markerList) {
			if (m instanceof ToleranceMarker) {
				ToleranceMarker tempMarker = (ToleranceMarker) m;
				if (tempMarker.getDirection() == ToleranceMarkerDirectionKind.UP
						|| tempMarker.getDirection() == ToleranceMarkerDirectionKind.START) {
					tm = tempMarker;
					return tm;
				}
			}
		}
		return tm;
	}

	public DateTimeRange lastMonthPeriod() {
		DateTimeRange dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
		dtr.setBegin(this.toXMLDate(oneMonthAgo()));
		dtr.setEnd(this.toXMLDate(todayAndNow()));
		return dtr;
	}

	
	public Date start(DateTimeRange dtr) {
		return this.fromXMLDate(dtr.getBegin());
	}
	
	public Date end(DateTimeRange dtr) {
		return this.fromXMLDate(dtr.getEnd());
	}
	
	public String formatLastMonitorDate(ServiceMonitor sm) {
		DateTimeRange dtr = sm.getPeriod();
		StringBuilder sb = new StringBuilder();
		Date begin = fromXMLDate(dtr.getBegin());
		Date end = fromXMLDate(dtr.getEnd());
		sb.append("From: ");
		sb.append(date(begin));
		sb.append(" @ ");
		sb.append(time(begin));
		sb.append(" To: ");
		sb.append(date(end));
		sb.append(" @ ");
		sb.append(time(end));
		return sb.toString();
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
	public MetricValueRange valueRangeForInterval(NetXResource resource,
			int targetInterval) {
		for (MetricValueRange mvr : resource.getMetricValueRanges()) {
			if (mvr.getIntervalHint() == targetInterval) {
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

	public String dateAndTime(Date d) {

		StringBuilder sb = new StringBuilder();

		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("HHmm");
				return df.format(from);
			}
		};
		sb.append(date(d) + "_");
		sb.append(getDateString.apply(d));
		return sb.toString();
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

	public int daysInJanuary(int year) {
		return daysInMonth(year, Calendar.JANUARY);
	}

	public int daysInFebruari(int year) {
		return daysInMonth(year, Calendar.FEBRUARY);
	}

	public int daysInMarch(int year) {
		return daysInMonth(year, Calendar.MARCH);
	}

	public int daysInApril(int year) {
		return daysInMonth(year, Calendar.APRIL);
	}

	// .... etc...

	public int daysInMonth(int year, int month) {
		final Calendar cal = new GregorianCalendar(year, month, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
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

	public double[] transformValueToDoubleArray(List<Value> values) {
		final Function<Value, Double> valueToDouble = new Function<Value, Double>() {
			public Double apply(Value from) {
				return from.getValue();
			}
		};
		List<Double> doubles = Lists.transform(values, valueToDouble);
		double[] doubleArray = new double[doubles.size()];
		for (int i = 0; i < doubles.size(); i++) {
			doubleArray[i] = doubles.get(i).doubleValue();
		}
		return doubleArray;
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
