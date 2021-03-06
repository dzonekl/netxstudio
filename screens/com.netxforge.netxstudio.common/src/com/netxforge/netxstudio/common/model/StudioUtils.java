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
package com.netxforge.netxstudio.common.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDOAddFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOContainerFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOListFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOMoveFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORemoveFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOSetFeatureDelta;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.spi.cdo.FSMUtil;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import com.google.inject.Singleton;
import com.netxforge.base.NonModelUtils;
import com.netxforge.base.cdo.CDO;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.internal.CommonActivator;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MappingRecord;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricRetentionPeriod;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

@Singleton
public class StudioUtils {

	public static final DecimalFormat FORMAT_DOUBLE_NO_FRACTION = new DecimalFormat(
			"00");

	/**
	 * Lifecycle state Planned.
	 */
	public static final int LIFECYCLE_PROPOSED = 4;
	public static final int LIFECYCLE_PLANNED = 3;
	public static final int LIFECYCLE_CONSTRUCTED = 2;
	public static final int LIFECYCLE_INSERVICE = 1;
	public static final int LIFECYCLE_OUTOFSERVICE = 0;
	public static final int LIFECYCLE_NOTSET = -1;

	public static final String EXTENSION_PROCESS = ".process";
	public static final String EXTENSION_DONE = ".done";
	public static final String EXTENSION_ERROR = ".error";
	public static final String EXTENSION_DONE_WITH_FAILURES = ".done_with_failures";

	// Required to translate.
	public static final String NETWORK_ELEMENT_ID = "Network Element ID";
	public static final String NETWORK_ELEMENT = "Network Element";
	public static final String NODE_ID = "NodeID";
	public static final String NODE = "NODE";

	public static final int MAX_CHANGE_LENGTH = 2000;

	public static final Iterable<String> MAPPING_NODE_ATTRIBUTES = ImmutableList
			.of(NETWORK_ELEMENT_ID);
	public static final Iterable<String> MAPPING_REL_ATTRIBUTES = ImmutableList
			.of("Name", "Protocol");
	public static final Iterable<String> MAPPING_FUNCTION_ATTRIBUTES = ImmutableList
			.of("Name");
	public static final Iterable<String> MAPPING_EQUIPMENT_ATTRIBUTES = ImmutableList
			.of("Name", "EquipmentCode", "Position");

	public static final String GENERATED_EXPRESSION_PREFIX = " Generated_comp_";

	/**
	 * Compare the time stamp of two {@link Value} objects. This implementation
	 * delegates to {@link XMLGregorianCalendar#compare(XMLGregorianCalendar) }.
	 */
	public static class ValueTimeStampComparator implements Comparator<Value> {
		public int compare(final Value v1, final Value v2) {

			// check if set.
			if (v1 != null
					&& v1.eIsSet(GenericsPackage.Literals.VALUE__TIME_STAMP)
					&& v2 != null
					&& v2.eIsSet(GenericsPackage.Literals.VALUE__TIME_STAMP)) {
				return v1.getTimeStamp().compare(v2.getTimeStamp());
			}
			return -1;
		}
	};

	public static ValueTimeStampComparator valueTimeStampCompare() {
		return new ValueTimeStampComparator();
	}

	/**
	 * A predicate for a Value and provided timestamp.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public static class TimeStampPredicate implements Predicate<Value> {

		// The date to compate with.
		private Date d;

		public TimeStampPredicate(Date d) {
			this.d = d;
		}

		public boolean apply(final Value v) {
			if (v.eIsSet(GenericsPackage.Literals.VALUE__TIME_STAMP)) {
				return v.getTimeStamp().toGregorianCalendar().getTime()
						.equals(d);
			}
			return false;
		}
	}

	/**
	 * Compare two values
	 */
	public static class ValueValueComparator implements Comparator<Value> {
		public int compare(final Value v1, final Value v2) {
			// check if set.
			if (v1.eIsSet(GenericsPackage.Literals.VALUE__VALUE)
					&& v2.eIsSet(GenericsPackage.Literals.VALUE__VALUE)) {
				return Double.compare(v1.getValue(), v2.getValue());
			}
			return 0;
		}
	};

	public static ValueValueComparator valueValueCompare() {
		return new ValueValueComparator();
	}

	public static String value(Value v) {
		StringBuffer sb = new StringBuffer();
		if (v == null)
			return "";
		sb.append("v=" + v.getValue() + ", ");
		sb.append("ts=" + NonModelUtils.dateAndTime(v.getTimeStamp()));
		return sb.toString();
	}

	public static Value value() {
		Value createValue = GenericsFactory.eINSTANCE.createValue();
		return createValue;
	}

	/**
	 * Return a {@link Value} object with the
	 * {@link GenericsPackage.Literals#VALUE__VALUE } set to a random value
	 * between 0.0 and 1.0 multiplied by the
	 * 
	 * <pre>
	 * multiply factor
	 * </pre>
	 * 
	 * @param multiply
	 * @return
	 */
	public static Value valueWithRandom(int multiply) {
		Value value = value();
		double random = Math.random();
		value.setValue(random * multiply);
		return value;
	}

	/**
	 * Compare two value ranges, on the interval in minutes.
	 */
	public static class MvrComparator implements Comparator<MetricValueRange> {
		public int compare(final MetricValueRange mvr1,
				final MetricValueRange mvr2) {
			return new Integer(mvr1.getIntervalHint()).compareTo(mvr2
					.getIntervalHint());
		}
	};

	public static MvrComparator mvrCompare() {
		return new MvrComparator();
	}

	/**
	 * {@link Comparator} for {@link MetricRetentionRule}'s interval in minutes.
	 */
	public static class MetricRetentionRuleComparator implements
			Comparator<MetricRetentionRule> {
		public int compare(final MetricRetentionRule mrr1,
				final MetricRetentionRule mrr2) {
			return new Integer(mrr1.getIntervalHint()).compareTo(mrr2
					.getIntervalHint());
		}
	};

	public static MetricRetentionRuleComparator retentionRuleCompare() {
		return new MetricRetentionRuleComparator();
	}

	/**
	 * Compare two markers on the time stamps.
	 */
	public static class MarkerTimeStampComparator implements Comparator<Marker> {
		public int compare(final Marker m1, final Marker m2) {

			// CDOUtil.cleanStaleReference(m1,
			// OperatorsPackage.Literals.MARKER__VALUE_REF);
			// CDOUtil.cleanStaleReference(m2,
			// OperatorsPackage.Literals.MARKER__VALUE_REF);

			return new ValueTimeStampComparator().compare(m1.getValueRef(),
					m2.getValueRef());
		}
	};

	public static MarkerTimeStampComparator markerTimeStampCompare() {
		return new MarkerTimeStampComparator();
	}

	/**
	 * Simply compare the begin of the period, we do not check for potential
	 * overlap with the end of the period.
	 */
	public static class ServiceMonitorComparator implements
			Comparator<ServiceMonitor> {
		public int compare(final ServiceMonitor sm1, ServiceMonitor sm2) {
			return sm1.getPeriod().getBegin()
					.compare(sm2.getPeriod().getBegin());
		}
	};

	/**
	 * Compare two periods, if unequal the result has no meaning. (Do not use
	 * for Sorting!)
	 */
	public static class PeriodComparator implements Comparator<DateTimeRange> {
		public int compare(final DateTimeRange dtr1, DateTimeRange dtr2) {

			if (dtr1 != null && dtr2 != null) {

				int beginResult = dtr1.getBegin().compare(dtr2.getBegin());
				int endResult = dtr2.getEnd().compare(dtr2.getEnd());
				if (beginResult == 0 && endResult == 0) {
					return 0;
				}
			}
			return -1;
		}
	};

	/**
	 * Get the {@link ServerSettings}
	 * 
	 * @param serverSettingsResource
	 * @return
	 */
	public static ServerSettings serverSettings(Resource serverSettingsResource) {

		if (serverSettingsResource != null
				&& serverSettingsResource.getContents().size() == 1) {
			ServerSettings settings = (ServerSettings) serverSettingsResource
					.getContents().get(0);
			return settings;
		}
		return null;
	}

	public static ServiceMonitorComparator serviceMonitorCompare() {
		return new ServiceMonitorComparator();
	}

	public static class NodeTypeIsLeafComparator implements
			Comparator<NodeType> {
		public int compare(final NodeType nt1, NodeType nt2) {
			if (nt1.isLeafNode() && nt2.isLeafNode()) {
				return 0;
			}
			if (nt1.isLeafNode() && !nt2.isLeafNode()) {
				return 1;
			}
			if (!nt1.isLeafNode() && nt2.isLeafNode()) {
				return -1;
			}
			return 0;
		}
	};

	public static NodeTypeIsLeafComparator nodeTypeIsLeafComparator() {
		return new NodeTypeIsLeafComparator();
	}

	/**
	 * Explicitly evaluates to the time stamp being within the period.
	 * 
	 * @author Christophe Bouhier
	 */
	public static class MarkerWithinPeriodPredicate implements
			Predicate<Marker> {

		private long from;
		private long to;

		public MarkerWithinPeriodPredicate(final DateTimeRange dtr) {
			this(dtr.getBegin().toGregorianCalendar().getTimeInMillis(), dtr
					.getEnd().toGregorianCalendar().getTimeInMillis());
		}

		public MarkerWithinPeriodPredicate(Date from, Date to) {
			this(from.getTime(), to.getTime());
		}

		public MarkerWithinPeriodPredicate(long from, long to) {
			this.from = from;
			this.to = to;
		}

		public boolean apply(final Marker m) {
			if (m.eIsSet(OperatorsPackage.Literals.MARKER__VALUE_REF)) {
				long target = m.getValueRef().getTimeStamp()
						.toGregorianCalendar().getTimeInMillis();
				return from <= target && to >= target;
			} else {
				return false;
			}
		}
	}

	public static MarkerWithinPeriodPredicate markerInsidePeriod(
			DateTimeRange dtr) {
		return new MarkerWithinPeriodPredicate(dtr);
	}

	public static MarkerWithinPeriodPredicate markerInsidePeriod(Date from,
			Date to) {
		return new MarkerWithinPeriodPredicate(from, to);
	}

	public static MarkerWithinPeriodPredicate markerInsidePeriod(long from,
			long to) {
		return new MarkerWithinPeriodPredicate(from, to);
	}

	/**
	 * All markers inside this {@link DateTimeRange period}.
	 * 
	 * @param unfiltered
	 * @param dtr
	 * @return
	 */
	public static List<Marker> markersInsidePeriod(Iterable<Marker> unfiltered,
			DateTimeRange dtr) {

		Iterable<Marker> filterValues = Iterables.filter(unfiltered,
				markerInsidePeriod(dtr));
		return Lists.newArrayList(filterValues);
	}

	public static List<Marker> markersInsidePeriod(Iterable<Marker> unfiltered,
			Date from, Date to) {

		Iterable<Marker> filterValues = Iterables.filter(unfiltered,
				markerInsidePeriod(from, to));
		return Lists.newArrayList(filterValues);
	}

	public static List<Marker> markersInsidePeriod(Iterable<Marker> unfiltered,
			long from, long to) {

		Iterable<Marker> filterValues = Iterables.filter(unfiltered,
				markerInsidePeriod(from, to));
		return Lists.newArrayList(filterValues);
	}

	/**
	 * Explicitly evaluates to the timestamp being within the period. If the
	 * timestamp is equal to the period, it will not be included.
	 * 
	 * @author Christophe Bouhier
	 */
	public static class ValueWithinPeriodPredicate implements Predicate<Value> {

		private long from;
		private long to;

		public ValueWithinPeriodPredicate(final DateTimeRange dtr) {
			from = dtr.getBegin().toGregorianCalendar().getTimeInMillis();
			to = dtr.getEnd().toGregorianCalendar().getTimeInMillis();
		}

		public ValueWithinPeriodPredicate(Date from, Date to) {
			this.from = from.getTime();
			this.to = to.getTime();
		}

		public ValueWithinPeriodPredicate(long from, long to) {
			this.from = from;
			this.to = to;
		}

		public boolean apply(final Value v) {

			long target = v.getTimeStamp().toGregorianCalendar()
					.getTimeInMillis();
			return from <= target && to >= target;
		}
	}

	public static ValueWithinPeriodPredicate valueInsideRange(DateTimeRange dtr) {
		return new ValueWithinPeriodPredicate(dtr);
	}

	public static ValueWithinPeriodPredicate valueInsideRange(Date from, Date to) {
		return new ValueWithinPeriodPredicate(from, to);
	}

	public static ValueWithinPeriodPredicate valueInsideRange(long from, long to) {
		return new ValueWithinPeriodPredicate(from, to);
	}

	public static List<Value> valuesInsideRange(Iterable<Value> unfiltered,
			DateTimeRange dtr) {

		final Iterable<Value> filterValues = Iterables.filter(unfiltered,
				valueInsideRange(dtr));
		return Lists.newArrayList(filterValues);
	}

	public static List<Value> valuesInsideRange(Iterable<Value> unfiltered,
			Date from, Date to) {

		final Iterable<Value> filterValues = Iterables.filter(unfiltered,
				valueInsideRange(from, to));
		return Lists.newArrayList(filterValues);
	}

	public static List<Value> valuesInsideRange(Iterable<Value> unfiltered,
			long from, long to) {

		Iterable<Value> filterValues = Iterables.filter(unfiltered,
				valueInsideRange(from, to));
		return Lists.newArrayList(filterValues);
	}

	/**
	 * True when the a {@link Value} occurs in the collection of reference value
	 * objects with a matching {@link Value#getTimeStamp()}
	 * 
	 * @author Christophe Bouhier
	 */
	public static class ValueForValuesPredicate implements Predicate<Value> {

		List<Value> referenceValues;

		public ValueForValuesPredicate(final List<Value> referenceValues) {
			this.referenceValues = referenceValues;
		}

		public boolean apply(final Value unfilteredValue) {

			Predicate<Value> predicate = new Predicate<Value>() {
				public boolean apply(final Value v) {
					return valueTimeStampCompare().compare(unfilteredValue, v) == 0;
				}
			};
			try {
				Iterables.find(referenceValues, predicate);
				return true;
			} catch (NoSuchElementException nsee) {
				return false;
			}
		}
	}

	public static ValueForValuesPredicate valueForValues(
			List<Value> referenceValues) {
		return new ValueForValuesPredicate(referenceValues);
	}

	public static List<Value> valuesForValues(Iterable<Value> unfiltered,
			List<Value> referenceValues) {
		Iterable<Value> filterValues = Iterables.filter(unfiltered,
				valueForValues(referenceValues));
		return Lists.newArrayList(filterValues);
	}

	/**
	 * Filter a collection of {@link Value}, omitting the values which have do
	 * not occur in the target {@link Date} collection.
	 * 
	 * @param d
	 * @return
	 */
	public static List<Value> valuesForTimestamps(Iterable<Value> unfiltered,
			final Collection<Date> timeStampDates) {

		Iterable<Value> filtered = Iterables.filter(unfiltered,
				new Predicate<Value>() {
					public boolean apply(final Value input) {
						final Date valueDate = NonModelUtils.fromXMLDate(input
								.getTimeStamp());
						return Iterables.any(timeStampDates,
								new Predicate<Date>() {
									public boolean apply(Date inputDate) {
										return valueDate.compareTo(inputDate) == 0;
									}
								});
					}

				});

		return Lists.newArrayList(filtered);
	}

	/**
	 * Create a {@link DateTimeRange period} from a bunch of {@link Value
	 * values}. The values are sorted first. Returns <code>null</code> when the
	 * {@link Collection#isEmpty()}
	 * 
	 * @param values
	 * @return
	 */
	public static DateTimeRange period(List<Value> values) {

		if (values.isEmpty()) {
			return null;

		}
		List<Value> sortValuesByTimeStamp = sortValuesByTimeStamp(values);
		DateTimeRange createDateTimeRange = GenericsFactory.eINSTANCE
				.createDateTimeRange();
		createDateTimeRange.setBegin(sortValuesByTimeStamp.get(0)
				.getTimeStamp());
		createDateTimeRange.setEnd(sortValuesByTimeStamp.get(
				sortValuesByTimeStamp.size() - 1).getTimeStamp());

		return createDateTimeRange;
	}

	/**
	 * Return the period for the {@link Value}'s time stamp, bound by the
	 * interval specified.
	 * 
	 * @param v
	 * @param interval
	 * @return
	 */

	public static DateTimeRange period(Value v, int targetInterval) {
		return period(v.getTimeStamp(), targetInterval);
	}

	/**
	 * Return the period for the given {@link XMLGregorianCalendar time stamp}
	 * for a given interval. The interval is is 
	 * 
	 * @param timeStamp
	 * @param targetInterval
	 * @return
	 */
	public static DateTimeRange period(XMLGregorianCalendar timeStamp,
			int targetInterval) {

		final int[] fields = NonModelUtils
				.fieldsForTargetIntervalLowerOrder(targetInterval);
		Calendar cal = timeStamp.toGregorianCalendar();

		NonModelUtils.adjustToFieldStart(cal, fields);
		Date start = cal.getTime();

		NonModelUtils.adjustToFieldEnd(cal, fields);
		Date end = cal.getTime();

		DateTimeRange createDateTimeRange = GenericsFactory.eINSTANCE
				.createDateTimeRange();
		createDateTimeRange.setBegin(NonModelUtils.toXMLDate(start));
		createDateTimeRange.setEnd(NonModelUtils.toXMLDate(end));

		return createDateTimeRange;

	}

	/**
	 * Return if this is an unitialized {@link DateTimeRange period}
	 * 
	 * @param dtr
	 * @return
	 */
	public static boolean periodUnset(DateTimeRange dtr) {
		return !dtr.eIsSet(GenericsPackage.Literals.DATE_TIME_RANGE__BEGIN)
				&& !dtr.eIsSet(GenericsPackage.Literals.DATE_TIME_RANGE__END);
	}

	/**
	 * Split the {@link Value} collection, in sub-collections for the provided
	 * interval boundaries. So a Day interval will split the value collection
	 * containing hourly values in sub collections containing a maximum quantity
	 * of values which is lesser or equal of a day. (23) </br></p> This method
	 * will sort the values ascending, so a better implementation is needed,
	 * avoiding the sorting.
	 * 
	 * @FIXME Doesn't work for non-consecutive ranges. (Ranges with a gap in the
	 *        intervals).
	 * 
	 * 
	 * @param values
	 * @param srcInterval
	 *            in minutes.
	 * @deprecated
	 * @return
	 */
	public static List<List<Value>> values(List<Value> values, int srcInterval,
			int targetInterval) {

		List<List<Value>> valueMatrix = Lists.newArrayList();

		int field = NonModelUtils.fieldForInterval(srcInterval, targetInterval);

		if (field == -1) {
			// can't split, bale out.
			valueMatrix.add(values);
			return valueMatrix;
		}

		List<Value> nextSequence = Lists.newArrayList();
		// we expect at least one value, so we can safely add the first
		// sequence.
		if (!values.isEmpty()) {
			valueMatrix.add(nextSequence);
		}

		// Sort the values fist.
		List<Value> copyOfValues = sortValuesByTimeStamp(Lists
				.newArrayList(values));
		Iterator<Value> iterator = copyOfValues.iterator();

		GregorianCalendar cal = null;
		int actualMaximum = -1;
		int actualMinimum = -1;
		int lastVal = -1;
		while (iterator.hasNext()) {
			Value v = iterator.next();
			cal = v.getTimeStamp().toGregorianCalendar();
			if (actualMaximum == -1) {
				actualMaximum = cal.getActualMaximum(field);
				actualMinimum = cal.getActualMinimum(field);
			}
			int currentVal = cal.get(field);

			// Get the relevant field for this timestamp. the value for the
			// corresponding field
			// is pushed until the max value.
			if (currentVal == actualMinimum && lastVal == actualMaximum) {
				nextSequence = Lists.newArrayList();
				valueMatrix.add(nextSequence);
			}
			nextSequence.add(v);
			lastVal = currentVal;
		}

		return valueMatrix;
	}

	/**
	 * Split a collection of {@link Value } objects. The splitting criteria is
	 * the interval in minutes. Group the values by their time stamp with the
	 * interval as boundary.
	 * 
	 * For week target, do not consider the month field. Note that if a week is
	 * partially in two consecutive years, it will be split by this algo.
	 */
	public static List<List<Value>> values_(List<Value> values,
			int targetInterval) {

		final Map<String, List<Value>> targetMap = Maps.newHashMap();

		final int[] fields = NonModelUtils
				.fieldsForTargetInterval(targetInterval);

		GregorianCalendar cal;
		for (Value v : values) {
			cal = v.getTimeStamp().toGregorianCalendar();

			StringBuffer sb = new StringBuffer();
			for (int field : fields) {
				// Get the target map.
				final int currentFieldValue = cal.get(field);
				sb.append("_" + currentFieldValue);
			}
			String key = sb.toString();

			if (targetMap.containsKey(key)) {
				targetMap.get(key).add(v);
			} else {
				List<Value> vList = Lists.newArrayList();
				vList.add(v);
				targetMap.put(key, vList);
			}
		}

		// Sort the entries of our map.

		List<List<Value>> valueMatrix = Ordering.from(
				new Comparator<List<Value>>() {

					public int compare(List<Value> o1, List<Value> o2) {
						if (o1.isEmpty() || o2.isEmpty()) {
							return 0;
						}

						// Sort the collections first.
						List<Value> o1Sorted = sortValuesByTimeStamp(o1);
						List<Value> o2Sorted = sortValuesByTimeStamp(o2);

						return valueValueCompare().compare(o1Sorted.get(0),
								o2Sorted.get(0));
					}
				}).sortedCopy(targetMap.values());

		if (CommonActivator.DEBUG) {
			CommonActivator.TRACE.trace(
					CommonActivator.TRACE_COMMON_UTILS_OPTION,
					"Value by period splitter, key output");
			List<String> sortedKeys = Ordering.from(new Comparator<String>() {

				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}

			}).sortedCopy(targetMap.keySet());
			for (String s : sortedKeys) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_UTILS_OPTION, "key: " + s);
			}
		}

		return valueMatrix;
	}

	public static class NodeOfTypePredicate implements Predicate<Node> {
		private final NodeType nt;

		public NodeOfTypePredicate(final NodeType nt) {
			this.nt = nt;
		}

		public boolean apply(final Node node) {
			if (node.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
				if (node.getNodeType().eIsSet(
						LibraryPackage.Literals.NODE_TYPE__NAME)) {
					return node.getNodeType().getName().equals(nt.getName());
				}
			}
			return false;
		}
	}

	public static NodeOfTypePredicate nodeOfType(NodeType nodeType) {
		return new NodeOfTypePredicate(nodeType);
	}

	public static class NodeInRelationshipPredicate implements Predicate<Node> {
		private final Relationship r;

		public NodeInRelationshipPredicate(final Relationship r) {
			this.r = r;
		}

		public boolean apply(final Node n) {
			return r.getNodeID1Ref() == n;
		}
	}

	public static class SourceRelationshipForNodePredicate implements
			Predicate<Relationship> {
		private final Node n;

		public SourceRelationshipForNodePredicate(final Node n) {
			this.n = n;
		}

		public boolean apply(final Relationship r) {
			return r.getNodeID1Ref() == n;
		}
	}

	public static NodeInRelationshipPredicate nodeInRelationship(Relationship r) {
		return new NodeInRelationshipPredicate(r);
	}

	public static SourceRelationshipForNodePredicate sourceRelationshipInNode(
			Node n) {
		return new SourceRelationshipForNodePredicate(n);
	}

	/**
	 * Note will not provide the ServiceMonitors for which the period is partly
	 * in range. targetBegin <= begin && targetEnd <= end. (Example of an
	 * overlapping).
	 */
	public static class ServiceMonitorWithinPeriodPredicate implements
			Predicate<ServiceMonitor> {
		private final DateTimeRange dtr;

		public ServiceMonitorWithinPeriodPredicate(final DateTimeRange dtr) {
			this.dtr = dtr;
		}

		public boolean apply(final ServiceMonitor s) {

			long begin = dtr.getBegin().toGregorianCalendar().getTimeInMillis();
			long end = dtr.getEnd().toGregorianCalendar().getTimeInMillis();

			long targetBegin = s.getPeriod().getBegin().toGregorianCalendar()
					.getTimeInMillis();
			long targetEnd = s.getPeriod().getEnd().toGregorianCalendar()
					.getTimeInMillis();

			return targetBegin >= begin && targetEnd <= end;

		}
	}

	/**
	 * A predicate if a {@link MetricSource} has a reference to a specified
	 * {@link Metric}
	 * 
	 * @author Christophe Bouhier
	 */
	public static class MetricInMetricSourcePredicate implements
			Predicate<MetricSource> {

		private Metric metric;

		public MetricInMetricSourcePredicate(Metric metric) {
			this.metric = metric;
		}

		public boolean apply(MetricSource ms) {
			Iterable<Metric> metricsInMetricSource = Iterables.transform(ms
					.getMetricMapping().getDataMappingColumns(),
					new Function<MappingColumn, Metric>() {

						public Metric apply(MappingColumn mc) {
							if (mc.getDataType() instanceof ValueDataKind) {
								return ((ValueDataKind) mc.getDataType())
										.getMetricRef();
							}
							return null;
						}
					});

			return Iterables.any(metricsInMetricSource,
					new Predicate<Metric>() {

						public boolean apply(Metric input) {
							if (input != null && metric != null) {
								return input.equals(metric);
							}
							return false;
							// Equality based on the name of the Metic
							// if (input != null && metric != null
							// && input.getName() != null
							// && metric.getName() != null) {
							// return input.getName().equals(metric.getName());
							// }else {
							// return false;
							// }
						}

					});
		}

	}

	/**
	 * Get all the {@link ServiceMonitor}or duplicates.
	 * 
	 * @author Christophe Bouhier
	 */
	public static class ServiceMonitorDuplicates implements
			Predicate<ServiceMonitor> {
		private final DateTimeRange lookupDTR;
		final PeriodComparator periodComparator = new PeriodComparator();

		public ServiceMonitorDuplicates(DateTimeRange lookupDTR) {
			this.lookupDTR = lookupDTR;
		}

		public boolean apply(final ServiceMonitor s) {

			if (FSMUtil.isNew(s)) {
				return false;
			}
			return periodComparator.compare(s.getPeriod(), lookupDTR) == 0;
		}
	}

	public static ServiceMonitorWithinPeriodPredicate serviceMonitorWithinPeriod(
			DateTimeRange dtr) {
		return new ServiceMonitorWithinPeriodPredicate(dtr);
	}

	/**
	 * Get the {@link ServiceMonitor Service Monitors} for which the start and
	 * end date is within the provided {@link DateTimeRange period}.
	 * 
	 * @param service
	 * @param dtr
	 * @return
	 */
	public static List<ServiceMonitor> serviceMonitorsWithinPeriod(
			Service service, DateTimeRange dtr) {
		// Sort and reverse the Service Monitors.
		List<ServiceMonitor> sortedCopy = Ordering
				.from(serviceMonitorCompare()).reverse()
				.sortedCopy(service.getServiceMonitors());

		// Filter ServiceMonitors on the time range.
		List<ServiceMonitor> filtered = filterSerciceMonitorInRange(sortedCopy,
				dtr);
		return filtered;
	}

	/**
	 * get the {@link ServiceMonitor}'s which are duplicates, and return a
	 * unique copy of these.
	 * 
	 * 
	 * @param service
	 * @param dtr
	 * @return
	 */
	public static List<ServiceMonitor> serviceMonitorDuplicates(
			Service service, DateTimeRange dtr) {

		final List<ServiceMonitor> copy = ImmutableList.copyOf(service
				.getServiceMonitors());
		Iterable<ServiceMonitor> result = Iterables.filter(copy,
				new ServiceMonitorDuplicates(dtr));

		// Print the duplicates.
		// System.out.println("found " + Iterables.size(result)
		// + " duplicates with these periods:");
		// for (ServiceMonitor sm : result) {
		// if (sm.getPeriod() != null) {
		// System.out.println(period(sm.getPeriod()));
		// }
		// }
		return ImmutableList.copyOf(result);
		// Will delete all as we are dodgy...

	}

	public static class IsRelationshipPredicate implements Predicate<EObject> {
		public boolean apply(final EObject eo) {
			return eo instanceof Relationship;
		}
	}

	public static IsRelationshipPredicate isRelationship() {
		return new IsRelationshipPredicate();
	}

	/**
	 * Returns <code>true</code> when {@link Marker#getValueRef() value} equals
	 * the given {@link Value}.
	 * 
	 * @author Christophe Bouhier
	 */
	public static class MarkerForValuePredicate implements Predicate<Marker> {
		private final Value value;

		public MarkerForValuePredicate(final Value value) {
			this.value = value;
		}

		public boolean apply(final Marker m) {
			Value mValue = m.getValueRef();
			if (mValue != null) {
				return EcoreUtil.equals(mValue, value);
			}
			return false;
		}
	}

	public static MarkerForValuePredicate markerForValue(Value v) {
		return new MarkerForValuePredicate(v);
	}

	public static class MarkerForDatePredicate implements Predicate<Marker> {
		private final Date checkDate;

		public MarkerForDatePredicate(final Date value) {
			this.checkDate = value;
		}

		public boolean apply(final Marker m) {

			try {

				// if(m.cdoInvalid()){
				// m.cdoReload();
				// }

				// Check the Marker CDO Status, seems to become invalid??
				if (m.eIsSet(OperatorsPackage.Literals.MARKER__VALUE_REF)) {
					Value markerValue = m.getValueRef();
					if (markerValue
							.eIsSet(GenericsPackage.Literals.VALUE__TIME_STAMP)) {
						Date markerDate = NonModelUtils.fromXMLDate(markerValue
								.getTimeStamp());
						return markerDate.equals(checkDate);
					}
				}
			} catch (ObjectNotFoundException onfe) {
				System.out.println("Error dealing with: " + m.cdoRevision()
						+ m.cdoState());
			}
			return false;
		}
	}

	public static MarkerForDatePredicate markerForDate(Date d) {
		return new MarkerForDatePredicate(d);
	}

	public static class ToleranceMarkerPredicate implements Predicate<Marker> {
		public boolean apply(final Marker m) {
			return m instanceof ToleranceMarker;
		}
	}

	public static ToleranceMarkerPredicate toleranceMarkers() {
		return new ToleranceMarkerPredicate();
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	public static boolean isInService(Node node) {
		if (!node.eIsSet(OperatorsPackage.Literals.NODE__LIFECYCLE)) {
			return true;
		} else
			return isInService(node.getLifecycle());
	}

	/**
	 * Call {@link StudioUtils#isInService(Lifecycle)} for
	 * {@link LibraryPackage#COMPONENT__LIFECYCLE}
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isInService(Component c) {
		if (!c.eIsSet(LibraryPackage.Literals.COMPONENT__LIFECYCLE)) {
			return true;
		} else
			return isInService(c.getLifecycle());
	}

	/**
	 * 
	 * @param lc
	 * @return
	 */
	public static boolean isInService(Lifecycle lc) {
		final long time = System.currentTimeMillis();
		if (lc.getInServiceDate() != null
				&& lc.getInServiceDate().toGregorianCalendar()
						.getTimeInMillis() > time) {
			return false;
		}
		if (lc.getOutOfServiceDate() != null
				&& lc.getOutOfServiceDate().toGregorianCalendar()
						.getTimeInMillis() < time) {
			return false;
		}
		return true;
	}

	/**
	 * Compute a resource path on the basis of an instance. Components generate
	 * a specific path based on their location in the node/nodetype tree.
	 * 
	 * Note that Components with an empty name are not allowed. Also, the depth
	 * is limited to 5 as CDO folders, so we create a resource separated by an
	 * underscore instead of a forward slash.
	 * 
	 * Note: if the name changes, we won't be able to retrieve the resource.
	 * 
	 * @deprecated
	 * 
	 */
	public static String cdoCalculateResourcePath(EObject eObject) {
		if (eObject instanceof Component) {

			final Component component = (Component) eObject;
			if (!component.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)
					|| component.getName().length() == 0) {
				return null;
			}

			return cdoCalculateResourcePath(component.eContainer()) + "_"
					+ component.getName();
		} else if (eObject instanceof Node) {
			return "/Node_/" + ((Node) eObject).getNodeID();
		} else if (eObject instanceof NodeType) {
			final NodeType nodeType = (NodeType) eObject;
			if (nodeType.eContainer() instanceof Node) {
				return cdoCalculateResourcePath(nodeType.eContainer());
			}
			return "/NodeType_/" + ((NodeType) eObject).getName();
		} else {
			return eObject.eClass().getName();
		}
	}

	/**
	 * Retrieve a CDOResource for a target {@link CDOObject}.
	 * 
	 * 
	 * @param targetObject
	 * @return
	 */
	public static CDOResource cdoResourceGet(CDOObject targetObject) {

		if (!LifecycleUtil.isActive(targetObject))
			throw new IllegalStateException(" target object is not active"
					+ targetObject);

		if (targetObject.cdoView() instanceof CDOTransaction) {
			CDOTransaction transaction = (CDOTransaction) targetObject
					.cdoView();
			final CDOResourceFolder folder = transaction
					.getOrCreateResourceFolder("/Node_/");

			String cdoCalculateResourceName = null;

			try {
				cdoCalculateResourceName = cdoResourceName(targetObject);
			} catch (IllegalAccessException e) {
				if (CommonActivator.DEBUG) {
					CommonActivator.TRACE.trace(
							CommonActivator.TRACE_COMMON_UTILS_OPTION,
							"-- Can't resolve the Resource name for target object: "
									+ targetObject);
				}
				return null;
			}

			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_UTILS_OPTION,
						"-- looking for CDO resource with name:"
								+ cdoCalculateResourceName);
			}

			// Iterate through the nodes to find the CDOResource with the target
			// name.
			if (folder != null) {
				CDOResource cdoResource = cdoResourceFromFolder(folder,
						cdoCalculateResourceName);
				return cdoResource;
			}
		}
		return null;

	}

	/**
	 * 
	 * @param targetObject
	 * @param transaction
	 * @return
	 */
	public static Resource cdoResourceGetOrCreate(EObject targetObject,
			CDOTransaction transaction) {

		if (!LifecycleUtil.isActive(targetObject))
			throw new IllegalStateException(" target object is not active"
					+ targetObject);

		final CDOResourceFolder folder = transaction
				.getOrCreateResourceFolder("/Node_/");

		String cdoCalculateResourceName = null;

		try {
			cdoCalculateResourceName = cdoResourceName(targetObject);
		} catch (IllegalAccessException e) {
			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_UTILS_OPTION,
						"-- Can't resolve the Resource name for target object: "
								+ targetObject);
			}
			return null;
		}

		if (CommonActivator.DEBUG) {
			CommonActivator.TRACE.trace(
					CommonActivator.TRACE_COMMON_UTILS_OPTION,
					"-- looking for CDO resource with name:"
							+ cdoCalculateResourceName);
		}

		// Iterate through the nodes to find the CDOResource with the target
		// name.
		CDOResource cdoResource = null;
		if (folder != null) {
			cdoResource = cdoResourceFromFolder(folder,
					cdoCalculateResourceName);
		}

		if (cdoResource == null) {
			cdoResource = folder.addResource(cdoCalculateResourceName);
			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_UTILS_OPTION,
						"-- created resource:"
								+ cdoResource.getURI().toString());
			}

		}
		return cdoResource;

		// Set a prefetch policy so we can load a lot of objects in the
		// first
		// fetch.
		// this should affect the Value objects being loaded. NetXResource->
		// MVR
		// -> Value.

		// if (emfNetxResource instanceof CDOResource) {
		// ((CDOResource) emfNetxResource)
		// .cdoView()
		// .options()
		// .setRevisionPrefetchingPolicy(
		// CDOUtil.createRevisionPrefetchingPolicy(24));
		// }
	}

	/**
	 * @param folder
	 * @param cdoCalculateResourceName
	 * @param emfNetxResource
	 * @return
	 */
	public static CDOResource cdoResourceFromFolder(
			final CDOResourceFolder folder, String cdoCalculateResourceName) {
		CDOResource cdoResource = null;
		for (CDOResourceNode n : folder.getNodes()) {

			// http://work.netxforge.com/issues/325
			// Ignore the case of the CDO Resource name.
			if (n.getName().equalsIgnoreCase(cdoCalculateResourceName)
					&& n instanceof CDOResource) {
				cdoResource = (CDOResource) n;
				if (CommonActivator.DEBUG) {
					CommonActivator.TRACE.trace(
							CommonActivator.TRACE_COMMON_UTILS_OPTION,
							"-- found:" + cdoResource.getURI().toString());
				}
				break;
			}
		}
		return cdoResource;
	}

	/**
	 * Return the name to be set on a {@link CDOResource}, computed as
	 * 
	 * <pre>
	 * Netxresource_[Node ID]
	 * </pre>
	 * 
	 * </p>The argument object should be one of the contained children of a
	 * {@link Node} instance.
	 * 
	 * @param eObject
	 * @return
	 * @throws IllegalAccessException
	 */
	public static String cdoResourceName(EObject eObject)
			throws IllegalAccessException {
		if (eObject instanceof Component) {
			final Component component = (Component) eObject;
			// }
			return cdoResourceName(component.eContainer());
		} else if (eObject instanceof Node) {
			Node n = (Node) eObject;
			if (n.eIsSet(OperatorsPackage.Literals.NODE__NODE_ID)) {
				return LibraryPackage.Literals.NET_XRESOURCE.getName() + "_"
						+ ((Node) eObject).getNodeID();
			} else {
				throw new IllegalAccessException("The node ID should be set");
			}

		} else if (eObject instanceof NodeType) {
			final NodeType nodeType = (NodeType) eObject;
			if (nodeType.eContainer() instanceof Node) {
				return cdoResourceName(nodeType.eContainer());
			} else {
				return LibraryPackage.Literals.NET_XRESOURCE.getName() + "_"
						+ ((NodeType) eObject).getName();
			}
		} else {
			// throw an exception, we shouldn't call this method and expect an
			// invalid EObject.
			throw new IllegalAccessException(
					"Invalid argument EObject, shoud be Component, or parent");
		}
	}

	/**
	 * {@link com.netxforge.netxstudio.library.Function Function} and children
	 * with a name.
	 * 
	 * @param functions
	 * @param name
	 * @return
	 */
	public static List<com.netxforge.netxstudio.library.Function> functionsWithName(
			List<com.netxforge.netxstudio.library.Function> functions,
			String name) {
		final List<com.netxforge.netxstudio.library.Function> fl = Lists
				.newArrayList();
		for (final com.netxforge.netxstudio.library.Function f : functions) {
			if (f.getName().equals(name)) {
				fl.add(f);
			}
			fl.addAll(functionsWithName(f.getFunctions(), name));
		}
		return fl;
	}

	/**
	 * Return the closure of equipments matching the code and name.
	 * 
	 * @param equips
	 * @param code
	 * @return
	 */
	public static List<Equipment> equimentsWithCodeAndName(
			List<Equipment> equips, String code, String name) {
		final List<Equipment> el = Lists.newArrayList();
		for (final Equipment e : equips) {
			if (e.getEquipmentCode().equals(code) && e.getName().equals(name)) {
				el.add(e);
			}
			el.addAll(equimentsWithCodeAndName(e.getEquipments(), code, name));
		}
		return el;
	}

	/**
	 * Return the closure of equipments matching the code.
	 * 
	 * @param equips
	 * @param code
	 * @return
	 */
	public static List<Equipment> equimentsWithCode(List<Equipment> equips,
			String code) {
		final List<Equipment> el = Lists.newArrayList();
		for (final Equipment e : equips) {
			if (e.getEquipmentCode().equals(code)) {
				el.add(e);
			}
			el.addAll(equimentsWithCode(e.getEquipments(), code));
		}
		return el;
	}

	/**
	 * Generates a name for the target component using the feature and the
	 * component type.
	 * 
	 * @param target
	 * @param feature
	 * @return
	 */
	public static String expressionName(Component target,
			EStructuralFeature feature) {
		String cName = target instanceof com.netxforge.netxstudio.library.Function ? ((com.netxforge.netxstudio.library.Function) target)
				.getName() : target instanceof Equipment ? ((Equipment) target)
				.getEquipmentCode() : "Unknown";

		String name = GENERATED_EXPRESSION_PREFIX + cName + "_"
				+ feature.getName();
		return name;
	}

	/**
	 * Convert each single line of an {@link Expression } and return as a single
	 * String.
	 * 
	 * @param expression
	 * @return
	 */
	public static String expressionAsString(Expression expression) {
		final Collection<String> lines = expression.getExpressionLines();
		return Joiner.on("\n").join(lines);
	}

	public static List<NetXResource> resourcesFor(Node node) {
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

	/**
	 * State of a {@link NetXResource}, if it has any {@link Value} Objects in
	 * any of the {@link MetricValueRange value ranges}.
	 * 
	 * @param resource
	 * @return
	 */
	public static boolean resourceHasValues(NetXResource resource) {
		if (resource.getMetricValueRanges().isEmpty()) {
			return false;
		}

		for (MetricValueRange mvr : resource.getMetricValueRanges()) {
			if (!mvr.getMetricValues().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static List<NetXResource> resourcesForComponent(Component component) {
		List<NetXResource> resources = Lists.newArrayList();
		List<Component> componentsForComponent = componentsForComponent(component);
		for (Component c : componentsForComponent) {
			resources.addAll(c.getResourceRefs());
		}
		return resources;
	}

	public static List<DerivedResource> derivedResourcesWithName(Service s,
			String expressionName) {

		final List<DerivedResource> drL = Lists.newArrayList();

		for (ServiceUser su : s.getServiceUserRefs()) {
			if (su.eIsSet(ServicesPackage.Literals.SERVICE_USER__SERVICE_PROFILE)) {
				for (DerivedResource dr : su.getServiceProfile()
						.getProfileResources()) {
					if (dr.getExpressionName().equals(expressionName)) {
						drL.add(dr);
					}
				}
			}
		}
		return drL;
	}

	public static List<NetXResource> resourcesWithExpressionName(NodeType nt,
			String expressionName) {
		final List<Component> cl = Lists.newArrayList();
		cl.addAll(nt.getEquipments());
		cl.addAll(nt.getFunctions());
		return resourcesWithExpressionName(cl, expressionName, true);
	}

	public static List<NetXResource> resourcesWithExpressionName(Node n,
			String expressionName) {
		final List<Component> cl = Lists.newArrayList();
		cl.addAll(n.getNodeType().getEquipments());
		cl.addAll(n.getNodeType().getFunctions());
		return resourcesWithExpressionName(cl, expressionName, true);
	}

	public static List<Value> sortValuesByTimeStampAndReverse(List<Value> values) {
		List<Value> sortedCopy = Ordering.from(valueTimeStampCompare())
				.reverse().sortedCopy(values);
		return sortedCopy;

	}

	/**
	 * Sorts a list of value in chronological order. (oldest first).
	 * 
	 * @param values
	 * @return
	 */
	public static List<Value> sortValuesByTimeStamp(List<Value> values) {
		List<Value> sortedCopy = Ordering.from(valueTimeStampCompare())
				.sortedCopy(values);
		return sortedCopy;

	}

	public static List<Marker> sortMarkersByTimeStamp(List<Marker> markers) {
		List<Marker> sortedCopy = Ordering.from(markerTimeStampCompare())
				.sortedCopy(markers);
		return sortedCopy;
	}

	public static List<ServiceMonitor> filterSerciceMonitorInRange(
			List<ServiceMonitor> unfiltered, DateTimeRange dtr) {
		Iterable<ServiceMonitor> filterValues = Iterables.filter(unfiltered,
				serviceMonitorWithinPeriod(dtr));
		return (Lists.newArrayList(filterValues));
	}

	/**
	 * Return the Node or null if the target object, has a Node somewhere along
	 * the parent hiearchy.
	 * 
	 * @param target
	 * @return
	 */
	public static Node nodeFor(EObject target) {
		if (target instanceof Node) {
			return (Node) target;
		}
		if (target != null && target.eContainer() != null) {
			if (target.eContainer() instanceof Node) {
				return (Node) target.eContainer();
			} else {
				return nodeFor(target.eContainer());
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
	public static NodeType resolveParentNodeType(EObject target) {

		if (target instanceof NodeType) {
			return (NodeType) target;
		} else if (target != null && target.eContainer() != null) {
			if (target.eContainer() instanceof NodeType) {
				return (NodeType) target.eContainer();
			} else {
				return resolveParentNodeType(target.eContainer());
			}
		} else {
			return null;
		}
	}

	/**
	 * Resolve the root {@link Service} for a given {@link Service} object.
	 * 
	 * @param target
	 * @return
	 */
	public static Service resolveRootService(Service target) {
		if (target.eContainer() instanceof Service) {
			return resolveRootService((Service) target.eContainer());
		} else {
			return (Service) target;
		}
	}

	public static ServiceMonitor lastServiceMonitor(Service service) {
		if (service.getServiceMonitors().isEmpty()) {
			return null;
		}
		int size = service.getServiceMonitors().size();
		ServiceMonitor sm = service.getServiceMonitors().get(size - 1);
		return sm;
	}

	/**
	 * Business Rule:
	 * 
	 * A Lifecycle is valid when the Lifecycle sequence are in chronological
	 * order.
	 * 
	 * @param lf
	 * @return
	 */
	public static boolean lifeCycleValid(Lifecycle lf) {

		long proposed = lf.getProposed().toGregorianCalendar()
				.getTimeInMillis();
		long planned = lf.getPlannedDate().toGregorianCalendar()
				.getTimeInMillis();
		long construction = lf.getConstructionDate().toGregorianCalendar()
				.getTimeInMillis();
		long inService = lf.getInServiceDate().toGregorianCalendar()
				.getTimeInMillis();
		long outOfService = lf.getOutOfServiceDate().toGregorianCalendar()
				.getTimeInMillis();

		boolean proposed_planned = lf
				.eIsSet(GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE) ? proposed <= planned
				: true;
		boolean planned_construction = lf
				.eIsSet(GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE) ? planned <= construction
				: true;
		boolean construcion_inService = lf
				.eIsSet(GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE) ? construction <= inService
				: true;
		boolean inService_outOfService = lf
				.eIsSet(GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE) ? inService <= outOfService
				: true;

		return proposed_planned && planned_construction
				&& construcion_inService && inService_outOfService;
	}

	/**
	 * Get a String representation of the Lifeycycle State.
	 * 
	 * @param state
	 * @return
	 */
	public static String lifecycleText(Lifecycle lc) {
		return lifecycleText(lifecycleState(lc));
	}

	/**
	 * Get a String representation of the Lifeycycle State.
	 * 
	 * @param state
	 * @return
	 */
	public static String lifecycleText(int state) {

		switch (state) {
		case LIFECYCLE_PROPOSED:
			return "Proposed";
		case LIFECYCLE_CONSTRUCTED:
			return "Constructed";
		case LIFECYCLE_PLANNED:
			return "Planned";
		case LIFECYCLE_INSERVICE:
			return "In Service";
		case LIFECYCLE_OUTOFSERVICE:
			return "Out of Service";
		case LIFECYCLE_NOTSET:
		default:
			return "NotSet";
		}

	}

	/**
	 * Get the lifecycle state. Each date of a Lifecycle is compared with it's
	 * predecessor. From this the state is determined.
	 * 
	 * @param lc
	 * @return
	 */
	public static int lifecycleState(Lifecycle lc) {

		if (lc == null) {
			return LIFECYCLE_NOTSET;
		}
		EAttribute[] states = new EAttribute[] {

		GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE,
				GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE,
				GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE,
				GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE,
				GenericsPackage.Literals.LIFECYCLE__PROPOSED };

		long latestDate = -1;
		int latestIndex = -1;
		for (int i = 0; i < states.length; i++) {
			EAttribute state = states[i];
			if (lc.eIsSet(state)) {
				long currentDate = ((XMLGregorianCalendar) lc.eGet(state))
						.toGregorianCalendar().getTimeInMillis();
				if (latestDate != -1) {
					if (latestDate >= currentDate) {
						break;
					} else {
						latestDate = currentDate;
						latestIndex = i;
						if (CommonActivator.DEBUG) {
							CommonActivator.TRACE.trace(
									CommonActivator.TRACE_COMMON_UTILS_OPTION,
									"-- update index to: " + i);
						}
						// set the index, we are later then predecessor.

					}
				} else {
					latestDate = currentDate;
					latestIndex = i;
				}
			}
		}
		return latestIndex;
	}

	public static List<NodeType> uniqueNodeTypes(List<NodeType> unfiltered) {
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

	public static List<Node> nodesForNodeType(List<Node> nodes,
			NodeType targetNodeType) {
		final Iterable<Node> filtered = Iterables.filter(nodes,
				nodeOfType(targetNodeType));
		return Lists.newArrayList(filtered);
	}

	/**
	 * Get the {@link Node nodes} from a given {@link RFSService} for a given
	 * {@link NodeType}
	 * 
	 * @param service
	 * @param targetNodeType
	 * @return
	 */
	public static List<Node> nodesForNodeType(RFSService service,
			NodeType targetNodeType) {
		final Iterable<Node> filtered = Iterables.filter(service.getNodes(),
				nodeOfType(targetNodeType));
		return Lists.newArrayList(filtered);
	}

	/**
	 * Get the first marker with this value otherwise null.
	 * 
	 * @param markers
	 * @param v
	 * @return
	 */
	public static Marker markerForValue(List<Marker> markers, Value v) {

		final Iterable<Marker> filtered = Iterables.filter(markers,
				markerForValue(v));
		if (Iterables.size(filtered) > 0) {
			return filtered.iterator().next();
		}
		return null;
	}

	/**
	 * Get the first {@link ResourceMonitor}
	 * 
	 * @param service
	 * @param n
	 * @param netxResource
	 * @return
	 */
	public static ResourceMonitor resourceMonitorForServiceAndResource(
			Service service, Node n, NetXResource netxResource) {

		ResourceMonitor monitor = null;

		// Sort by begin date and reverse the Service Monitors.
		List<ServiceMonitor> serviceMonitors = Ordering
				.from(serviceMonitorCompare()).reverse()
				.sortedCopy(service.getServiceMonitors());

		for (ServiceMonitor sm : serviceMonitors) {
			for (ResourceMonitor rm : sm.getResourceMonitors()) {
				if (rm.getNodeRef().getNodeID().equals(n.getNodeID())) {
					if (rm.getResourceRef().equals(netxResource)) {
						monitor = rm;
					}
				}
			}

		}
		return monitor;
	}

	public static List<Component> componentsForMonitors(Service service,
			Node node) {

		// Sort by begin date and reverse the Service Monitors.
		List<ServiceMonitor> serviceMonitors = Ordering
				.from(serviceMonitorCompare()).reverse()
				.sortedCopy(service.getServiceMonitors());

		List<Component> collectedComponents = Lists.newArrayList();
		for (ServiceMonitor sm : serviceMonitors) {
			for (ResourceMonitor rm : sm.getResourceMonitors()) {
				if (rm.getNodeRef().getNodeID().equals(node.getNodeID())) {
					Component componentRef = rm.getResourceRef()
							.getComponentRef();
					if (!collectedComponents.contains(componentRef)) {
						collectedComponents.add(componentRef);
					}
				}
			}
		}
		return collectedComponents;
	}

	/**
	 * Get a {@link Map} of {@link NetXResource} with corresponding
	 * {@link ResourceMonitor}s
	 * 
	 * @param serviceMonitor
	 * @param n
	 * @param dtr
	 * @param monitor
	 * @return
	 */
	public static Map<NetXResource, List<ResourceMonitor>> resourceMonitorMapPerResourceForServiceMonitorAndNodeAndPeriod(
			Node n, DateTimeRange dtr, IProgressMonitor monitor,
			ServiceMonitor... serviceMonitors) {

		Map<NetXResource, List<ResourceMonitor>> monitorsPerResource = resourceMonitorMapPerResourceForServiceMonitorsAndNode(
				Arrays.asList(serviceMonitors), n, monitor);

		return monitorsPerResource;
	}

	/**
	 * Get a {@link Map} of {@link NetXResource} with corresponding
	 * {@link ResourceMonitor}s
	 * 
	 * @param serviceMonitors
	 * @param n
	 *            The {@link Node} for which the Resource Monitor should be.
	 * @return
	 */
	public static Map<NetXResource, List<ResourceMonitor>> resourceMonitorMapPerResourceForServiceMonitorsAndNode(
			List<ServiceMonitor> serviceMonitors, Node n,
			IProgressMonitor monitor) {
		Map<NetXResource, List<ResourceMonitor>> monitorsPerResource = Maps
				.newHashMap();

		for (ServiceMonitor sm : serviceMonitors) {
			for (ResourceMonitor rm : sm.getResourceMonitors()) {

				// Abort the task if we are cancelled.
				if (monitor != null && monitor.isCanceled()) {
					return monitorsPerResource;
				}

				if (rm.getNodeRef().getNodeID().equals(n.getNodeID())) {

					// Analyze per resource, why would a resource monitor
					// contain markers for a nother resource?
					List<ResourceMonitor> monitors;
					NetXResource res = rm.getResourceRef();
					if (!monitorsPerResource.containsKey(res)) {
						monitors = Lists.newArrayList();
						monitorsPerResource.put(res, monitors);
					} else {
						monitors = monitorsPerResource.get(res);
					}
					monitors.add(rm);
				}
			}

		}
		return monitorsPerResource;
	}

	/**
	 * Get the {@link JobRunContainer} which holds the {@link Job} objects from
	 * the provided {@link Resource}.
	 * 
	 * @param job
	 * @param containerResource
	 * @return
	 */
	public static JobRunContainer jobContainerForJob(Job job,
			Resource containerResource) {

		final CDOID cdoId = job.cdoID();

		for (final EObject eObject : containerResource.getContents()) {
			final JobRunContainer container = (JobRunContainer) eObject;
			final Job containerJob = container.getJob();
			final CDOID containerJobId = ((CDOObject) containerJob).cdoID();
			if (cdoId.equals(containerJobId)) {
				return container;
			}
		}
		return null;
	}

	/**
	 * Get the parent {@link Job} for a given {@link ComponentWorkFlowRun}. Walk
	 * up the hierarchy.
	 * 
	 * @param wfr
	 * @return
	 */
	public static Job jobForWorkflowRun(ComponentWorkFlowRun wfr) {
		if (wfr.eContainer() != null) {
			EObject eContainer = wfr.eContainer();
			if (eContainer instanceof JobRunContainer) {
				JobRunContainer jrc = (JobRunContainer) eContainer;
				return jrc.getJob();
			}
		}
		return null;
	}

	/**
	 * get a {@link Job} from a {@link Resource} by iterating over the root
	 * content and matching the name of the job.
	 * 
	 * @param jobName
	 * @param jobResource
	 * @return
	 */
	public static Job jobWithName(String jobName, Resource jobResource) {

		for (final EObject eObject : jobResource.getContents()) {
			final Job job = (Job) eObject;
			if (job.equals(jobName)) {
				return job;
			}
		}
		return null;
	}

	/**
	 * 
	 * Get the Job of a certain type with a target value for the target feature.
	 * 
	 * @param jobResource
	 * @param jobClass
	 * @param feature
	 * @param value
	 * @return
	 */
	public static Job jobForSingleObject(Resource jobResource, EClass jobClass,
			EStructuralFeature feature, EObject value) {

		// The job Class should extend the Job EClass.
		if (!jobClass.getESuperTypes().contains(SchedulingPackage.Literals.JOB)) {
			return null;
		}

		for (EObject eo : jobResource.getContents()) {
			if (eo.eClass() == jobClass) {
				if (eo.eIsSet(feature)) {
					Object v = eo.eGet(feature);
					if (v == value) {
						return (Job) eo;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Get the {@link Job} of a certain type with a target collection contained
	 * in the collection of the target feature.
	 * 
	 * @param jobResource
	 * @param jobClass
	 * @param feature
	 * @param targetValues
	 * @return
	 */
	public static Job jobForMultipleObjects(Resource jobResource,
			EClass jobClass, EStructuralFeature feature,
			Collection<?> targetValues) {

		assert feature.isMany();

		int shouldMatch = targetValues.size();

		// The job Class should extend the Job EClass.
		if (!jobClass.getESuperTypes().contains(SchedulingPackage.Literals.JOB)) {
			return null;
		}

		for (EObject eo : jobResource.getContents()) {
			int actuallyMatches = 0;
			if (eo.eClass() == jobClass) {
				if (eo.eIsSet(feature)) {
					Object v = eo.eGet(feature);
					if (v instanceof List<?>) {
						for (Object listItem : (List<?>) v) {
							// Do we contain any of our objects?
							for (Object target : targetValues) {
								if (listItem == target) {
									actuallyMatches++;
								}
							}
						}
					}
				}
			}
			// Check if the number of entries are actually in the target job.
			if (actuallyMatches == shouldMatch) {
				return (Job) eo;
			}
		}
		return null;
	}

	public static DateTimeRange lastMonthPeriod() {
		DateTimeRange dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
		dtr.setBegin(NonModelUtils.toXMLDate(NonModelUtils.oneMonthAgo()));
		dtr.setEnd(NonModelUtils.toXMLDate(NonModelUtils.todayAndNow()));
		return dtr;
	}

	public static Date begin(DateTimeRange dtr) {
		return NonModelUtils.fromXMLDate(dtr.getBegin());
	}

	public static Date end(DateTimeRange dtr) {
		return NonModelUtils.fromXMLDate(dtr.getEnd());
	}

	public static DateTimeRange period(Date start, Date end) {
		DateTimeRange dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
		dtr.setBegin(NonModelUtils.toXMLDate(start));
		dtr.setEnd(NonModelUtils.toXMLDate(end));
		return dtr;
	}

	public static String periodToString(DateTimeRange dtr) {
		StringBuffer sb = new StringBuffer();
		sb.append("from: " + NonModelUtils.dateAndTime(dtr.getBegin()));
		sb.append(" to: " + NonModelUtils.dateAndTime(dtr.getEnd()));

		return sb.toString();
	}

	public static String serviceMonitorToString(ServiceMonitor sm) {
		DateTimeRange dtr = sm.getPeriod();
		return periodToStringMore(dtr);
	}

	public static String periodToStringMore(DateTimeRange dtr) {
		StringBuilder sb = new StringBuilder();
		Date begin = NonModelUtils.fromXMLDate(dtr.getBegin());
		Date end = NonModelUtils.fromXMLDate(dtr.getEnd());
		sb.append("From: ");
		sb.append(NonModelUtils.date(begin));
		sb.append(" @ ");
		sb.append(NonModelUtils.time(begin));
		sb.append(" To: ");
		sb.append(NonModelUtils.date(end));
		sb.append(" @ ");
		sb.append(NonModelUtils.time(end));
		return sb.toString();
	}

	/**
	 * Return the {@link MetricSource metric sources} containing a specified
	 * {@link Metric}.
	 * 
	 * @param sources
	 * @param metric
	 * @return
	 */
	public static List<MetricSource> metricSourcesForMetric(
			List<MetricSource> sources, Metric metric) {
		Iterable<MetricSource> filter = Iterables.filter(sources,
				new MetricInMetricSourcePredicate(metric));
		List<MetricSource> result = Lists.newArrayList(filter);
		return result;
	}

	public static List<NetXResource> resourcesInMetricSource(
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

		return resourcesForMetrics(targetListInMetricSource);
	}

	public static List<NetXResource> resourcesForMetrics(
			List<Metric> targetListInMetricSource) {
		List<NetXResource> targetListNetXResources = Lists.newArrayList();

		// Cross reference the metrics from the target MetricSource.
		for (EObject o : targetListInMetricSource) {

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
								Node n = nodeFor(res.getComponentRef());
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
	 * This User's role.
	 * 
	 * @param users
	 * @return
	 */
	public static Role roleForUserWithName(String loginName, List<Person> users) {
		Person result = null;
		for (Person p : users) {
			if (p.eIsSet(GenericsPackage.Literals.PERSON__LOGIN)) {
				if (p.getLogin().equals(loginName)) {
					result = p;
					break;
				}
			}
		}
		if (result != null) {
			return result.getRoles();
		}
		return null;
	}

	public static Value mostRecentValue(List<Value> rawListOfValues) {
		List<Value> values = sortValuesByTimeStampAndReverse(rawListOfValues);
		if (values.size() > 0) {
			return values.get(0);
		}
		return null;
	}

	/**
	 * Iterate through the ranges, and find for this interval.
	 * 
	 * @param resource
	 * @param targetInterval
	 * @return
	 */
	public static Value mostRecentCapacityValue(NetXResource resource) {
		return mostRecentValue(resource.getCapacityValues());
	}

	/**
	 * Will return an empty list, if no range is found with the provided
	 * parameters.
	 * 
	 * @param res
	 * @param intervalHint
	 * @param kh
	 * @param dtr
	 * @return
	 */
	public static List<Value> valuesForIntervalKindAndPeriod(NetXResource res,
			int intervalHint, KindHintType kh, DateTimeRange dtr) {

		MetricValueRange mvr;
		if (kh == null) {
			mvr = valueRangeForInterval(res, intervalHint);
		} else {
			mvr = valueRangeForIntervalAndKind(res, kh, intervalHint);
		}

		if (mvr != null) {
			Iterable<Value> filterValues = Iterables.filter(
					mvr.getMetricValues(), valueInsideRange(dtr));
			return Lists.newArrayList(filterValues);
		}
		return Lists.newArrayList();
	}

	/**
	 * return the {@link MetricValueRange} for a given {@link NetXResource}
	 * which has the given interval. Note; the
	 * {@link MetricsPackage.Literals.METRIC_VALUE_RANGE__KIND_HINT } is not
	 * considered.
	 * 
	 * @param resource
	 * @param targetInterval
	 * @return
	 * @deprecated use {@link #valueRangesForInterval(NetXResource, int)}
	 */
	public static MetricValueRange valueRangeForInterval(NetXResource resource,
			int targetInterval) {
		for (MetricValueRange mvr : resource.getMetricValueRanges()) {
			if (mvr.getIntervalHint() == targetInterval) {
				return mvr;
			}
		}
		return null;
	}

	/**
	 * return a collection of {@link MetricValueRange} for a given
	 * {@link NetXResource} which has the given interval. Note; the
	 * {@link MetricsPackage.Literals.METRIC_VALUE_RANGE__KIND_HINT } is not
	 * considered.
	 * 
	 * @param resource
	 * @param targetInterval
	 * @return
	 */
	public static List<MetricValueRange> valueRangesForInterval(
			NetXResource resource, int targetInterval) {
		List<MetricValueRange> matchingRanges = Lists.newArrayList();
		for (MetricValueRange mvr : resource.getMetricValueRanges()) {
			if (mvr.getIntervalHint() == targetInterval) {
				matchingRanges.add(mvr);
			}
		}
		return matchingRanges;
	}

	/**
	 * Get a {@link MetricValueRange} for a {@link NetXResource} matching a kind
	 * and interval.
	 * 
	 * @param foundNetXResource
	 * @param kindHintType
	 * @param intervalHint
	 * @return The {@link MetricValueRange} matching the {@link KindHintType} &&
	 *         interval or null if none is found.
	 * 
	 */
	public static MetricValueRange valueRangeForIntervalAndKind(
			NetXResource foundNetXResource, KindHintType kindHintType,
			int intervalHint) {
		MetricValueRange foundMvr = null;
		for (final MetricValueRange mvr : foundNetXResource
				.getMetricValueRanges()) {

			// A succesfull match on Kind and Interval.
			if (mvr.getKindHint() == kindHintType
					&& mvr.getIntervalHint() == intervalHint) {
				foundMvr = mvr;
				break;
			}
		}
		return foundMvr;
	}

	/**
	 * Note, side effect of creating the value range if the range doesn't exist.
	 */
	public static MetricValueRange valueRangeForIntervalAndKindGetOrCreate(
			NetXResource foundNetXResource, KindHintType kindHintType,
			int intervalHint) {
		MetricValueRange foundMvr = null;
		for (final MetricValueRange mvr : foundNetXResource
				.getMetricValueRanges()) {

			// A succesfull match on Kind and Interval.
			if (mvr.getKindHint() == kindHintType
					&& mvr.getIntervalHint() == intervalHint) {
				foundMvr = mvr;
				break;
			}
		}

		if (foundMvr == null) {
			foundMvr = MetricsFactory.eINSTANCE.createMetricValueRange();
			foundMvr.setKindHint(kindHintType);
			foundMvr.setIntervalHint(intervalHint);
			foundNetXResource.getMetricValueRanges().add(foundMvr);
		}
		return foundMvr;
	}

	/**
	 * Get all {@link NetXResource resource }objects for a {@link NodeType }.
	 * 
	 * @param nodeTypes
	 * @return
	 */
	public static List<NetXResource> resourcesFromNodeTypes(CDOView view,
			final List<NodeType> nodeTypes) {

		Iterable<NetXResource> filter = Iterables.filter(resources(view),
				new Predicate<NetXResource>() {

					public boolean apply(NetXResource input) {
						try {
							final Node nodeFor = nodeFor(input
									.getComponentRef());
							if (nodeFor != null
									&& nodeFor
											.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {

								if (Iterables.any(nodeTypes,
										new Predicate<NodeType>() {

											public boolean apply(NodeType input) {
												return nodeFor
														.getNodeType()
														.getName()
														.equals(input.getName());

											}
										})) {
									return true;
								}
							}

						} catch (ObjectNotFoundException onfe) {
							System.out.println("error processing: "
									+ onfe.getID());
						}
						return false;
					}
				});

		return Lists.newArrayList(filter);
	}

	public static List<NetXResource> resources(CDOView view) {
		List<NetXResource> allResources = Lists.newArrayList();

		final CDOResourceFolder folder = view.getResourceFolder("/Node_");
		EList<CDOResourceNode> nodes = folder.getNodes();
		for (CDOResourceNode n : nodes) {
			if (n instanceof CDOResource) {
				CDOResource cdoRes = (CDOResource) n;
				EList<EObject> contents = cdoRes.getContents();
				for (EObject eo : contents) {
					if (eo instanceof NetXResource) {
						allResources.add((NetXResource) eo);
					}
				}
			}
		}
		return allResources;
	}

	public static List<NetXResource> resourcesWithExpressionNameFromNodeTypes(
			List<NodeType> nodeTypes, NetXResource resource) {

		List<NetXResource> allResources = Lists.newArrayList();
		for (NodeType nt : nodeTypes) {
			List<NetXResource> resources = resourcesWithExpressionName(nt,
					resource.getExpressionName());
			allResources.addAll(resources);
		}
		return allResources;
	}

	public static void printMatrix(Node[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Node n = matrix[i][j];
				if (n != null) {
					System.out.print(n.getNodeID() + ",");
				}
			}
			System.out.println("\n");
		}
	}

	public static String printNodeStructure(Node node) {
		StringBuilder result = new StringBuilder();
		result.append("-" + printModelObject(node) + "\n");
		if (node.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
			NodeType nt = node.getNodeType();
			result.append("-" + printModelObject(nt) + "\n");
			result.append(printComponents("--",
					transformToComponents(nt.getFunctions())));
			result.append(printComponents("--",
					transformToComponents(nt.getEquipments())));
		}
		return result.toString();
	}

	public static String printComponents(String prefix,
			List<Component> components) {
		StringBuilder result = new StringBuilder();
		for (Component c : components) {
			result.append(prefix + printModelObject(c) + "\n");

			if (c instanceof Equipment) {
				result.append(printComponents("--" + prefix,
						transformToComponents(((Equipment) c).getEquipments())));
			} else if (c instanceof com.netxforge.netxstudio.library.Function) {
				result.append(printComponents(
						"--" + prefix,
						transformToComponents(((com.netxforge.netxstudio.library.Function) c)
								.getFunctions())));
			}

		}
		return result.toString();
	}

	public static String printModelObject(EObject o) {
		StringBuilder result = new StringBuilder();

		if (o instanceof CDOResource) {
			result.append("CDO Resource:  name=" + ((CDOResource) o).getName());
		} else if (o instanceof CDOResourceFolder) {
			result.append("CDO Resource Folder: path="
					+ ((CDOResourceFolder) o).getPath());
		} else if (o instanceof Network) {
			Network net = (Network) o;
			result.append("Network: name=" + net.getName());
		} else if (o instanceof Node) {
			Node n = (Node) o;
			result.append("Node: name=" + n.getNodeID());
		} else if (o instanceof Equipment) {
			Equipment eq = (Equipment) o;
			result.append("Equipment: code=" + eq.getEquipmentCode() + " name="
					+ eq.getName());
		} else if (o instanceof com.netxforge.netxstudio.library.Function) {
			result.append("Function: name="
					+ ((com.netxforge.netxstudio.library.Function) o).getName());
		} else if (o instanceof NodeType) {
			NodeType nt = (NodeType) o;
			result.append("NodeType: name=" + nt.getName());
		} else if (o instanceof NetXResource) {
			NetXResource nt = (NetXResource) o;
			result.append("NetXResource: short name=" + nt.getShortName());
		} else if (o instanceof Service) {
			Service nt = (Service) o;
			result.append("Service: name=" + nt.getServiceName());
		} else if (o instanceof MetricSource) {
			MetricSource ms = (MetricSource) o;
			result.append("Metric Source: name=" + ms.getName());
		} else if (o instanceof Metric) {
			Metric m = (Metric) o;
			result.append("Metric name=" + m.getName());
		} else if (o instanceof Mapping) {
			Mapping mapping = (Mapping) o;
			result.append("Mapping: datarow=" + mapping.getFirstDataRow()
					+ "interval=" + mapping.getIntervalHint() + ",colums="
					+ mapping.getDataMappingColumns().size());
		} else if (o instanceof MappingColumn) {
			MappingColumn mc = (MappingColumn) o;
			result.append("mapping column: " + mc.getColumn());
		} else if (o instanceof DataKind) {
			DataKind dk = (DataKind) o;
			if (dk instanceof IdentifierDataKind) {
				result.append("Identifier Datakind: "
						+ ((IdentifierDataKind) dk).getObjectKind());
			}
			if (dk instanceof ValueDataKind) {
				result.append("Value Datakind: "
						+ ((ValueDataKind) dk).getValueKind());
			}
		} else if (o instanceof Value) {
			result.append(value((Value) o));
		}

		// if( ECoreUtil.geto.getClass() != null){
		// result.append(" class=" + o.eClass().getName());
		// }else if(o.eResource() != null){
		// result.append(" resource=" + o.eResource().getURI().toString());
		// }
		// result.append(" ( CDO Info object=" + ((CDOObject) o).cdoRevision()
		// + " )");

		return result.toString();
	}

	public static Node[][] matrix(List<Node> nodes) {

		// Node[][] emptyMatrix = new Node[0][0];

		List<NodeType> nts = transformNodeToNodeType(nodes);
		List<NodeType> unique = uniqueNodeTypes(nts);
		List<NodeType> sortedByIsLeafCopy = Ordering
				.from(nodeTypeIsLeafComparator()).reverse().sortedCopy(unique);

		int ntCount = sortedByIsLeafCopy.size();
		int nodeDepth = 0;

		// We need a two pass, to determine the array size first.
		// Is there another trick?

		for (NodeType nt : sortedByIsLeafCopy) {
			Iterable<Node> filtered = Iterables.filter(nodes, nodeOfType(nt));
			if (Iterables.size(filtered) > nodeDepth) {
				nodeDepth = Iterables.size(filtered);
			}
		}

		Node[][] matrix = new Node[ntCount][nodeDepth];

		for (int i = 0; i < ntCount; i++) {
			NodeType nt = sortedByIsLeafCopy.get(i);
			Iterable<Node> filtered = Iterables.filter(nodes, nodeOfType(nt));
			for (int j = 0; j < Iterables.size(filtered); j++) {
				Node n = Iterables.get(filtered, j);
				matrix[i][j] = n;
			}
		}

		return matrix;
	}

	public static List<Relationship> connections(RFSService service, Node n) {

		if (service.eContainer() instanceof Operator) {
			Operator op = (Operator) service.eContainer();

			List<Relationship> relationships = Lists.newArrayList();
			TreeIterator<EObject> eAllContents = op.eAllContents();
			while (eAllContents.hasNext()) {
				EObject eo = eAllContents.next();
				if (eo instanceof Relationship) {
					relationships.add((Relationship) eo);
				}
			}

			List<Relationship> filteredRelationships = Lists.newArrayList();
			Iterable<Relationship> filtered = Iterables.filter(relationships,
					sourceRelationshipInNode(n));
			if (Iterables.size(filtered) > 0) {
				filteredRelationships.addAll(Lists.newArrayList(filtered));
			}
			return filteredRelationships;
		}
		return null;
	};

	public static List<Node> connectedNodes(RFSService service) {

		if (service.eContainer() instanceof Operator) {
			Operator op = (Operator) service.eContainer();

			List<Relationship> relationships = Lists.newArrayList();
			TreeIterator<EObject> eAllContents = op.eAllContents();
			while (eAllContents.hasNext()) {
				EObject eo = eAllContents.next();
				if (eo instanceof Relationship) {
					relationships.add((Relationship) eo);
				}
			}

			List<Relationship> filteredRelationships = Lists.newArrayList();

			for (Node n : service.getNodes()) {
				Iterable<Relationship> filtered = Iterables.filter(
						relationships, sourceRelationshipInNode(n));
				if (Iterables.size(filtered) > 0) {
					filteredRelationships.addAll(Lists.newArrayList(filtered));
				}
			}
		}
		return null;

	};

	/**
	 * Resources with this name. Notice: Matching is on regular expression, i.e.
	 * name = .* is all resources.
	 * 
	 * Very slow approach.
	 * 
	 * @param components
	 * @param name
	 * @param closure
	 *            decend the child hierarchy and look for resources when
	 *            <code>true</code>
	 * @return
	 */
	public static List<NetXResource> resourcesWithExpressionName(
			List<Component> components, String name, boolean closure) {
		final List<NetXResource> rl = Lists.newArrayList();

		for (final Component c : components) {
			for (final NetXResource r : c.getResourceRefs()) {
				String expName = r.getExpressionName();
				if (expName.matches(name)) {
					rl.add(r);
				}
			}

			if (closure) {
				final List<Component> cl = Lists.newArrayList();
				if (c instanceof Equipment) {
					cl.addAll(((Equipment) c).getEquipments());
				}
				if (c instanceof com.netxforge.netxstudio.library.Function) {
					cl.addAll(((com.netxforge.netxstudio.library.Function) c)
							.getFunctions());
				}
				rl.addAll(resourcesWithExpressionName(cl, name, closure));
			}
		}
		return rl;
	}

	/**
	 * Get a collection of {@link Metric} objects from a the mapping definitions
	 * in a {@link MetricSource}
	 * 
	 * @param metricSource
	 * @return
	 */
	public static List<Metric> metricsInMetricSource(MetricSource metricSource) {
		final List<Metric> metricsInMetricSource = Lists.newArrayList();
		for (MappingColumn mc : metricSource.getMetricMapping()
				.getDataMappingColumns()) {
			if (mc.eIsSet(MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE)
					&& mc.getDataType() instanceof ValueDataKind) {
				ValueDataKind dataType = (ValueDataKind) mc.getDataType();
				if (dataType
						.eIsSet(MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF)) {
					metricsInMetricSource.add(dataType.getMetricRef());
				}

			}
		}
		return metricsInMetricSource;
	}

	/**
	 * Find the {@link MetricRetentionRule} from a collection using the given
	 * {@link MetricRetentionRule#getIntervalHint() interval hint}.
	 * 
	 * @param rules
	 * @param intervalHint
	 * @return
	 */
	public static MetricRetentionRule metricRuleGlobalForInterval(
			List<MetricRetentionRule> rules, final int intervalHint) {

		try {
			MetricRetentionRule find = Iterables.find(rules,
					new Predicate<MetricRetentionRule>() {
						public boolean apply(MetricRetentionRule input) {
							return input.getIntervalHint() == intervalHint;
						}
					});
			return find;
		} catch (NoSuchElementException nsee) {
		}
		return null;
	}

	/**
	 * All {@link Date timestamps} for the specified {@link DateTimeRange
	 * period}
	 * 
	 * @param dtr
	 * @return
	 */
	public static List<Date> timeStamps(DateTimeRange dtr) {
		List<Date> allTS = Lists.newArrayList();
		Multimap<Integer, XMLGregorianCalendar> timeStampsByWeek = hourlyTimeStampsByWeekFor(dtr);
		// build an index of colums and timestamps.
		for (int i : timeStampsByWeek.keySet()) {
			Collection<XMLGregorianCalendar> collection = timeStampsByWeek
					.get(i);
			allTS.addAll(NonModelUtils.transformXMLDateToDate(collection));

		}
		Collections.sort(allTS);
		return allTS;
	}

	/**
	 * Dump the dirty objects of a {@link CDOTransaction transaction} to
	 * standard out.
	 * 
	 * @param transaction
	 */
	public static void cdoDumpDirtyObject(CDOTransaction transaction) {
		StringBuffer sb = new StringBuffer();
		sb.append("\n Dirty objects for transaction: "
				+ transaction.getViewID());
		sb.append("\n Revisions ==============================\n");
		cdoPrintDirtyObjects(sb, transaction);
		System.out.println(sb.toString());
	}

	/**
	 * Get the number of days in a {@link DateTimeRange period}.
	 * 
	 * @param dtr
	 * @return
	 */
	public static int daysInPeriod(DateTimeRange dtr) {

		// Prep. a Calendar to roll down to the begin of the period.
		XMLGregorianCalendar end = dtr.getEnd();
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(end.toGregorianCalendar().getTime());

		long begin = dtr.getBegin().toGregorianCalendar().getTime().getTime();

		int days = 0;
		while (cal.getTime().getTime() > begin) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
			days++;
		}
		return days;
	}

	/**
	 * Print the dirty objects to a {@link StringBuffer} for a
	 * {@link CDOTransaction transaction}.
	 * 
	 * 
	 * @param transaction
	 */
	public static void cdoPrintDirtyObjects(StringBuffer sb,
			CDOTransaction transaction) {
		Map<CDOID, CDOObject> dirtyObjects = transaction.getDirtyObjects();
		Map<CDOID, CDORevisionDelta> revisionDeltas = transaction
				.getRevisionDeltas();

		for (CDOObject o : dirtyObjects.values()) {
			CDORevision rev = o.cdoRevision();
			sb.append("\n " + o.cdoID());
			sb.append("\n  " + printModelObject(o));
			sb.append("\n  ver:" + rev.getVersion());
			sb.append("\n  on:" + NonModelUtils.dateAndTime(rev.getTimeStamp()));

			if (revisionDeltas.containsKey(o.cdoID())) {
				CDORevisionDelta cdoRevisionDelta = revisionDeltas.get(o
						.cdoID());
				CDO.cdoPrintFeatureDeltas(sb,
						cdoRevisionDelta.getFeatureDeltas());
			}
		}
	}

	/**
	 * Extract the EReference's with referen type is Expression from a target
	 * object.
	 */
	public static List<EReference> expressionEReferences(EObject target) {
		final List<EReference> expRefs = Lists.newArrayList();
		for (EReference eref : target.eClass().getEAllReferences()) {
			if (eref.getEReferenceType() == LibraryPackage.Literals.EXPRESSION) {
				expRefs.add(eref);
			}
		}
		return expRefs;
	}

	/**
	 * Intended for use together with an ITableLabelProvider
	 * <ul>
	 * <li>Index = 0, returns a literal string of the feature for this delta.</li>
	 * <li>Index = 1, returns a literal string of the delta type. (Add, Remove
	 * etc..). {@link CDOFeatureDelta.Type}</li>
	 * <li>Index = 2, returns the new value if any for this type, if an object
	 * {@link #printModelObject(EObject)}</li>
	 * <li>Index = 3, returns the old value if any for this type, if an object
	 * {@link #printModelObject(EObject)}</li>
	 * </ul>
	 * 
	 * @see CDOFeatureDelta
	 * @param cdoFeatureDelta
	 */
	public static String cdoFeatureDeltaIndex(CDOFeatureDelta cdoFeatureDelta,
			int index) {

		// Only support index in a range.
		assert index >= 0 && index <= 3;

		Object newValue = null;
		Object oldValue = null;

		// if index = 0, we simp
		if (index == 0) {
			return cdoFeatureDelta.getFeature().getName();
		} else if (index == 1) {
			return cdoFeatureDelta.getType().name();
		} else if (index == 2 || index == 3) {
			switch (cdoFeatureDelta.getType()) {
			case ADD: {
				CDOAddFeatureDelta fdType = (CDOAddFeatureDelta) cdoFeatureDelta;
				newValue = fdType.getValue();
			}
				break;
			case REMOVE: {
				CDORemoveFeatureDelta fdType = (CDORemoveFeatureDelta) cdoFeatureDelta;
				newValue = fdType.getValue();
			}
				break;
			case CLEAR: {
				// CDOClearFeatureDelta fdType = (CDOClearFeatureDelta) delta;
				// has no value.
			}
				break;
			case MOVE: {
				CDOMoveFeatureDelta fdType = (CDOMoveFeatureDelta) cdoFeatureDelta;
				newValue = fdType.getValue();

				// A list position move.
				fdType.getNewPosition();
				fdType.getOldPosition();
			}
				break;
			case SET: {
				CDOSetFeatureDelta fdType = (CDOSetFeatureDelta) cdoFeatureDelta;
				newValue = fdType.getValue();
				oldValue = fdType.getOldValue();

			}
				break;
			case UNSET: {
				// CDOUnsetFeatureDelta fdType = (CDOUnsetFeatureDelta) delta;
				// has no value.
			}
				break;
			case LIST: {
				CDOListFeatureDelta fdType = (CDOListFeatureDelta) cdoFeatureDelta;

				@SuppressWarnings("unused")
				List<CDOFeatureDelta> listChanges = fdType.getListChanges();
				// What to do with this???
			}
				break;
			case CONTAINER: {
				CDOContainerFeatureDelta fdType = (CDOContainerFeatureDelta) cdoFeatureDelta;

				// Assume one of the two...
				fdType.getContainerID(); // The container ID.
				fdType.getResourceID(); // The resource ID.
			}
				break;
			}

			if (index == 2 && newValue != null) {
				if (newValue instanceof String) {
					return (String) newValue;
				} else if (newValue instanceof EObject) {
					printModelObject((EObject) newValue).toString();
				} else if (newValue instanceof CDOID) {
					// It would be nice for references, to get the mutated CDOID
					// and present it as a link
					// to the object.
					CDOID cdoID = (CDOID) newValue;
					return "Object ID =" + cdoID.toString();
				}
			} else if (index == 3 && oldValue != null) {
				return oldValue instanceof String ? (String) oldValue
						: printModelObject((EObject) oldValue).toString();
			}
		}
		return "";
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
		String affectedPath = CDO.cdoResourcePath((CDOObject) object);

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

	/*
	 * Historical components can exist in a Node or NodeType. when checking the
	 * path, we check both the Node and NodeType. (Both could be historical
	 * elements).
	 */
	public static boolean isHistoricalComponent(Component c) {

		if (c instanceof CDOObject) {
			String path = CDO.cdoResourcePath(c);

			// Check for Node first.
			Node node = nodeFor(c);
			if (node != null) {
				String nodeHistoricalPath = resolveHistoricalResourceName(node);
				if (path.equals(nodeHistoricalPath)) {
					return true;
				}
				return false;
			}

			// Check for Node type.
			NodeType nt = resolveParentNodeType(c);
			if (nt != null) {
				String nodeTypeHistoricalPath = resolveHistoricalResourceName(nt);
				if (path.equals(nodeTypeHistoricalPath)) {
					return true;
				}

			}

		}

		return false;
	}

	public static List<NodeType> transformNodeToNodeType(List<Node> nodes) {
		final Function<Node, NodeType> nodeTypeFromNode = new Function<Node, NodeType>() {
			public NodeType apply(Node from) {
				return from.getNodeType();
			}
		};
		return Lists.transform(nodes, nodeTypeFromNode);
	}

	/**
	 * Transform a list of Value object, to only the value part of the Value
	 * Object.
	 * 
	 * @param values
	 * @return
	 */
	public static List<BigDecimal> transformValueToBigDecimal(List<Value> values) {
		final Function<Value, BigDecimal> valueToBigDecimal = new Function<Value, BigDecimal>() {
			public BigDecimal apply(Value from) {
				return new BigDecimal(from.getValue());
			}
		};
		return Lists.transform(values, valueToBigDecimal);
	}

	public static double[] transformValueToDoubleArray(List<Value> values) {
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

	/**
	 * Trnsform a collection of {@link Value values} to a matrix which can be
	 * fed in a trending function.
	 * 
	 * @param values
	 * @return
	 */
	public static double[][] transformValueToDoubleMatrix(List<Value> values) {

		double[][] data = new double[values.size()][2];

		double xOffset = 0;
		for (int i = 0; i < values.size(); i++) {
			Value value = values.get(i);
			long timestamp = value.getTimeStamp().toGregorianCalendar()
					.getTimeInMillis();

			// Set an x-offset to deal with smaller numbers, but maintain the
			// the delta in seconds.
			if (i == 0) {
				xOffset = timestamp;
			}

			double x = (timestamp - xOffset);
			data[i][0] = x; // Store as seconds to
			data[i][1] = value.getValue();
			// deal with smaller
			// number
		}
		return data;
	}

	/**
	 * Transform a collection of {@link Value values} to a matrix which can be
	 * fed in a trending function. (Linear regression). The x is not the
	 * 
	 * @param values
	 * @return
	 */
	public static double[][] transformValueToDoubleTrendMatrix(
			List<Value> values) {

		double[][] data = new double[values.size()][2];

		for (int i = 0; i < values.size(); i++) {
			Value value = values.get(i);
			data[i][0] = i;
			data[i][1] = value.getValue();
		}
		return data;
	}

	public static List<Component> transformToComponents(
			List<? extends EObject> components) {
		final Function<EObject, Component> valueToDouble = new Function<EObject, Component>() {
			public Component apply(EObject from) {
				if (from instanceof Component) {
					return (Component) from;
				}
				return null;
			}
		};
		List<Component> result = Lists.transform(components, valueToDouble);
		return result;
	}

	/**
	 * Get all the day timestamps in the period.
	 * 
	 * @param dtr
	 * @return
	 */
	public static List<XMLGregorianCalendar> transformPeriodToDailyTimestamps(
			DateTimeRange dtr) {

		List<XMLGregorianCalendar> timeStamps = Lists.newArrayList();

		final Calendar cal = GregorianCalendar.getInstance();
		// Set the end time and count backwards, make the hour is the end hour.
		// Optional set to day end, the UI should have done this already.
		// this.setToDayEnd();

		// BACKWARD, WILL USE THE END TIME STAMP WHICH IS 23:59:999h
		// cal.setTime(dtr.getEnd().toGregorianCalendar().getTime());
		// Date begin = dtr.getBegin().toGregorianCalendar().getTime();
		// while (cal.getTime().after(begin)) {
		// timeStamps.add(this.toXMLDate(cal.getTime()));
		// cal.add(Calendar.DAY_OF_YEAR, -1);
		// }

		// FORWARD, WILL USE THE BEGIN TIME STAMP WHICH IS 00:00:000h
		cal.setTime(dtr.getBegin().toGregorianCalendar().getTime());
		Date end = dtr.getEnd().toGregorianCalendar().getTime();
		while (cal.getTime().before(end)) {
			timeStamps.add(NonModelUtils.toXMLDate(cal.getTime()));
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}

		return timeStamps;
	}

	/**
	 * Get all the hourly timestamps in the period.
	 * 
	 * @param dtr
	 * @return
	 */
	public static List<XMLGregorianCalendar> transformPeriodToHourlyTimestamps(
			DateTimeRange dtr) {

		List<XMLGregorianCalendar> timeStamps = Lists.newArrayList();

		final Calendar cal = GregorianCalendar.getInstance();
		// Set the end time and count backwards, make the hour is the end hour.
		// Optional set to day end, the UI should have done this already.
		// this.setToDayEnd();

		Date endTime = dtr.getEnd().toGregorianCalendar().getTime();

		Date beginTime = dtr.getBegin().toGregorianCalendar().getTime();

		cal.setTime(endTime);
		NonModelUtils.setToFullHour(cal);

		while (cal.getTime().compareTo(beginTime) >= 0) {
			cal.add(Calendar.HOUR_OF_DAY, -1);
			Date runTime = cal.getTime();
			timeStamps.add(NonModelUtils.toXMLDate(runTime));
		}

		return timeStamps;
	}

	public static List<Double> transformValueToDouble(List<Value> values) {
		final Function<Value, Double> valueToDouble = new Function<Value, Double>() {
			public Double apply(Value from) {
				return from.getValue();
			}
		};
		return Lists.transform(values, valueToDouble);
	}

	public static List<Date> transformValueToDate(List<Value> values) {
		final Function<Value, Date> valueToDouble = new Function<Value, Date>() {
			public Date apply(Value from) {
				return NonModelUtils.fromXMLDate(from.getTimeStamp());
			}
		};
		return Lists.transform(values, valueToDouble);
	}

	public static Date[] transformValueToDateArray(List<Value> values) {
		final Function<Value, Date> valueToDouble = new Function<Value, Date>() {
			public Date apply(Value from) {
				return NonModelUtils.fromXMLDate(from.getTimeStamp());
			}
		};
		List<Date> transform = Lists.transform(values, valueToDouble);
		return transform.toArray(new Date[transform.size()]);
	}

	public static List<Double> merge(List<Date> dates, List<Value> valuesToMerge) {
		return merge("", dates, valuesToMerge, null);
	}

	/**
	 * Separate and Merge the date and value from a value collection into two
	 * separate collections. if the Date is already in the date collection, we
	 * re-use that index.
	 * 
	 * @param existingDates
	 *            A Collection containing dates which should match.
	 * @return a collection of values.
	 */
	public static List<Double> merge(String mergingTaskName,
			List<Date> existingDates, List<Value> valuesToMerge,
			IProgressMonitor monitor) {

		// should from with the dates list.
		List<Double> doubles = Lists.newArrayListWithCapacity(existingDates
				.size());

		for (int i = 0; i < existingDates.size(); i++) {
			doubles.add(new Double(-1));
		}

		int s = valuesToMerge.size();
		if (monitor != null)
			monitor.subTask(mergingTaskName);
		// For CDO, this will fetch the object depending on the CDO Prefetch
		// policy on this list.
		for (int i = 0; i < s; i++) {
			if (monitor.isCanceled()) {
				return null;
			}

			Value v = valuesToMerge.get(i);

			// if (monitor != null && i % 10 == 0) {
			monitor.worked(1);
			// }
			Date dateToMergeOrAdd = NonModelUtils.fromXMLDate(v.getTimeStamp());
			int positionOf = NonModelUtils.positionOf(existingDates,
					dateToMergeOrAdd);
			if (positionOf != -1) {
				// store in the same position, the initial size should allow
				// this.
				doubles.set(positionOf, v.getValue());
			} else {
				existingDates.add(dateToMergeOrAdd);
				double value = v.getValue();
				doubles.add(value);
			}
		}
		return doubles;
	}

	/**
	 * Creates a {@link DateTimeRange period} from the
	 * {@link MetricRetentionPeriod Metric Retention Period} of
	 * {@link MetricRetentionRule}. The end date of the period is the numbers of
	 * days of the retention period, from today (End of the day), and the start
	 * as the number of years which should be evaluated.
	 * 
	 * @param rule
	 * @param years
	 *            the number of years to evaluate for retention.
	 * @return the {@link DateTimeRange period} or <code>null</code>, when the
	 *         retention period is {@link MetricRetentionPeriod#ALWAYS}
	 */
	public static DateTimeRange periodForRetentionRule(
			MetricRetentionRule rule, Date begin) {
		DateTimeRange dtr = null;
		dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
		Calendar instance = Calendar.getInstance();
		instance.setTime(NonModelUtils.todayAtDayEnd());

		switch (rule.getPeriod().getValue()) {
		case MetricRetentionPeriod.ALWAYS_VALUE: {
			return null;
		}
		case MetricRetentionPeriod.ONE_YEAR_VALUE: {
			instance.add(Calendar.YEAR, -1);
		}
			break;
		case MetricRetentionPeriod.ONE_MONTH_VALUE: {
			instance.add(Calendar.MONTH, -1);
		}
			break;
		case MetricRetentionPeriod.ONE_WEEK_VALUE: {
			instance.add(Calendar.WEEK_OF_YEAR, -1);
			break;
		}
		}

		dtr.setEnd(NonModelUtils.toXMLDate(instance.getTime()));
		dtr.setBegin(NonModelUtils.toXMLDate(begin));

		return dtr;
	}

	/**
	 * Get hourly timestamps in weekly chunks.
	 * 
	 * @param dtr
	 * @return
	 */
	public static Multimap<Integer, XMLGregorianCalendar> hourlyTimeStampsByWeekFor(
			DateTimeRange dtr) {

		List<XMLGregorianCalendar> tses = transformPeriodToHourlyTimestamps(dtr);

		Function<XMLGregorianCalendar, Integer> weekNumFunction = new Function<XMLGregorianCalendar, Integer>() {
			Calendar cal = Calendar.getInstance();

			public Integer apply(XMLGregorianCalendar from) {
				// convert to a regular calendar to get the time.
				cal.setTime(from.toGregorianCalendar().getTime());
				return cal.get(Calendar.WEEK_OF_YEAR);
			}
		};
		return Multimaps.index(tses, weekNumFunction);
	}

	/**
	 * Get monthly periods for the total period
	 * 
	 * @param dtr
	 * @return
	 */
	public static List<DateTimeRange> monthlyPeriods(DateTimeRange dtr) {

		List<DateTimeRange> result = Lists.newArrayList();

		final Calendar cal = Calendar.getInstance();
		cal.setTime(dtr.getEnd().toGregorianCalendar().getTime());
		// Go back in time and create a new DateTime Range for each Month
		// boundary.
		while (cal.getTime().getTime() > dtr.getBegin().toGregorianCalendar()
				.getTimeInMillis()) {
			final Date end = cal.getTime();
			cal.add(Calendar.MONTH, -1);
			Date begin;
			if (cal.getTime().getTime() < dtr.getBegin().toGregorianCalendar()
					.getTimeInMillis()) {
				begin = NonModelUtils.fromXMLDate(dtr.getBegin());
			} else {
				begin = cal.getTime();
			}

			DateTimeRange createDateTimeRange = GenericsFactory.eINSTANCE
					.createDateTimeRange();
			createDateTimeRange.setEnd(NonModelUtils.toXMLDate(end));
			createDateTimeRange.setEnd(NonModelUtils.toXMLDate(begin));
		}

		return result;

	}

	/**
	 * A Period is synonym for a {@link DateTimeRange}.</p> Create a collection
	 * of periods for the provided {@link DateTimeRange} with the granularity of
	 * the specified {@link Calendar#fields Calendar Fields} field.
	 * <ul>
	 * <li>{@link Calendar#MONTH}</li>
	 * <li>{@link Calendar#WEEK_OF_YEAR}</li>
	 * <li>{@link Calendar#DAY_OF_MONTH}</li>
	 * </ul>
	 * The earliest period starts at the specified Calendar field boundary. The
	 * following Calendar fields are supported
	 * 
	 * 
	 * @param dtr
	 * @param calField
	 * @return A collection of periods in the {@link DateTimeRange} format.
	 */
	public static List<DateTimeRange> periods(DateTimeRange dtr, int calField) {

		boolean weekTreatment = false;

		int childField = -1;
		switch (calField) {
		case Calendar.MONTH: {
			childField = Calendar.DAY_OF_MONTH;
		}
			break;
		case Calendar.DAY_OF_MONTH: {
			childField = Calendar.HOUR_OF_DAY;
		}
			break;
		case Calendar.WEEK_OF_YEAR: {
			childField = Calendar.DAY_OF_WEEK;
			weekTreatment = true;
		}
			break;
		}

		List<DateTimeRange> result = Lists.newArrayList();

		if (childField == -1) {
			result.add(dtr);
			return result;
		}

		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(dtr.getEnd().toGregorianCalendar().getTime());

		// An end calendar to compare the calendar field, and not take the field
		// maximum but the value from the end calendar.
		final Calendar endCal = GregorianCalendar.getInstance();
		endCal.setTime(dtr.getEnd().toGregorianCalendar().getTime());

		// Go back in time and create a new DateTime Range.
		do {

			// Set the begin to the actual minimum and end to the actual
			// maximum, except at the start, where we keep the actual.
			// At the end, roll one beyond the minimum to set the new actual.
			if (cal.get(calField) != endCal.get(calField)) {
				if (weekTreatment) {
					// :-( there is no method to get the last day of week.
					cal.set(childField, NonModelUtils.lastDayOfWeek(cal));

				} else {
					cal.set(childField, cal.getActualMaximum(childField));
				}

			}

			final Date end = cal.getTime();

			// Special Treatment for Week
			if (weekTreatment) {
				final int firstDayOfWeek = cal.getFirstDayOfWeek();
				cal.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);
			} else {
				int minimum = cal.getActualMinimum(childField);
				cal.set(childField, minimum);
			}

			Date begin;
			if (cal.getTime().getTime() < dtr.getBegin().toGregorianCalendar()
					.getTimeInMillis()) {
				begin = NonModelUtils.fromXMLDate(dtr.getBegin());
			} else {
				begin = cal.getTime();
			}

			final DateTimeRange period = period(
					NonModelUtils.adjustToDayStart(begin),
					NonModelUtils.adjustToDayEnd(end));
			result.add(period);

			// Role back one more, so the new actual can be applied.
			cal.add(calField, -1);
		} while (cal.getTime().getTime() > dtr.getBegin().toGregorianCalendar()
				.getTimeInMillis());

		return result;

	}

	/**
	 * All closure networks.
	 * 
	 * @param network
	 * @return
	 */
	public static List<Network> networksForOperator(Operator operator) {
		final List<Network> networks = new ArrayList<Network>();

		for (Network n : operator.getNetworks()) {
			networks.addAll(networksForNetwork(n));
		}
		return networks;
	}

	public static List<Network> networksForNetwork(Network network) {
		final List<Network> networks = new ArrayList<Network>();
		networks.add(network);
		for (Network child : network.getNetworks()) {
			networks.addAll(networksForNetwork(child));
		}
		return networks;
	}

	/**
	 * All closure nodes.
	 * 
	 * @param network
	 * @return
	 */
	public static List<Node> nodesForNetwork(Network network) {

		List<Node> nodes = Lists.newArrayList();
		nodes.addAll(network.getNodes());
		for (Network n : network.getNetworks()) {
			nodes.addAll(nodesForNetwork(n));
		}
		return nodes;
	}

	/**
	 * Get a collection of {@link Component } objects for a given
	 * {@link Operator}
	 * 
	 * @param op
	 * @return
	 */
	public static List<Component> componentsForOperator(Operator op) {

		List<Component> components = Lists.newArrayList();
		for (Network net : op.getNetworks()) {
			List<Node> nodesForNetwork = nodesForNetwork(net);
			for (Node n : nodesForNetwork) {
				List<Component> componentsForNode = componentsForNode(n);
				components.addAll(componentsForNode);
			}
		}
		return components;
	}

	/**
	 * All closure components for a {@link Node}
	 * 
	 * @param n
	 * @return
	 */
	public static List<Component> componentsForNode(Node n) {

		List<Component> components = Lists.newArrayList();
		if (n.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
			components.addAll(componentsForNodeType(n.getNodeType()));
		}
		return components;
	}

	/**
	 * All closure components for a {@link NodeType}
	 * 
	 * @param n
	 * @return
	 */

	public static List<Component> componentsForNodeType(NodeType nodeType) {
		final List<Component> components = new ArrayList<Component>();
		for (Component c : nodeType.getFunctions()) {
			components.addAll(componentsForComponent(c));
		}
		for (Component c : nodeType.getEquipments()) {
			components.addAll(componentsForComponent(c));
		}
		return components;
	}

	public static List<Component> childComponentsForNodeType(NodeType nodeType) {
		final List<Component> components = new ArrayList<Component>();
		components.addAll(nodeType.getFunctions());
		components.addAll(nodeType.getEquipments());
		return components;
	}

	/**
	 * all child {@link Component} including self.
	 * 
	 * @param c
	 * @return
	 */
	public static List<Component> componentsForComponent(Component c) {
		return componentsForComponent(c, true);
	}

	/**
	 * all (full depth) child {@link Component} with optionally the root
	 * argument component.
	 * 
	 * @param c
	 * @param self
	 * @return
	 */
	public static List<Component> componentsForComponent(Component c,
			boolean self) {
		final List<Component> components = new ArrayList<Component>();
		if (self) {
			components.add(c);
		}
		if (c instanceof com.netxforge.netxstudio.library.Function) {
			com.netxforge.netxstudio.library.Function f = (com.netxforge.netxstudio.library.Function) c;
			for (Component child : f.getFunctions()) {
				components.addAll(componentsForComponent(child));
			}
		}

		if (c instanceof Equipment) {
			Equipment eq = (Equipment) c;
			for (Component child : eq.getEquipments()) {
				components.addAll(componentsForComponent(child));
			}
		}

		return components;
	}

	/**
	 * child {@link Component} with optionally the root argument component.
	 * 
	 * @param c
	 * @param self
	 * @return
	 */
	public static List<Component> childComponentsForComponent(Component c,
			boolean self) {
		final List<Component> components = new ArrayList<Component>();
		if (self) {
			components.add(c);
		}
		if (c instanceof com.netxforge.netxstudio.library.Function) {
			com.netxforge.netxstudio.library.Function f = (com.netxforge.netxstudio.library.Function) c;
			components.addAll(f.getFunctions());
		}

		if (c instanceof Equipment) {
			Equipment eq = (Equipment) c;
			components.addAll(eq.getEquipments());
		}

		return components;
	}

	/**
	 * Gets the {@link Component components } with the feature
	 * {@link LibraryPackage.Literals#COMPONENT__METRIC_REFS } referencing the
	 * provided {@link Metric} which can occur in the provided non filtered
	 * collection.
	 * 
	 * @return
	 */
	public static Iterable<Component> componentsForMetric(
			List<Component> unfiltered, final Metric metric) {

		Iterable<Component> filter = Iterables.filter(unfiltered,
				new Predicate<Component>() {

					public boolean apply(Component c) {
						// return c.getMetricRefs().contains(metric);
						// Metric in path doesn't work.
						final List<Metric> metricsInPath = Lists.newArrayList();
						metricsInPath(metricsInPath, c);
						return Iterables.any(metricsInPath,
								new CDO.CDOObjectEqualsPredicate(metric));
					}

				});

		// We still have many results, look for a component in the left.
		if (Iterables.size(filter) > 1) {
			{
				Iterable<Component> narrowFilter = Iterables.filter(unfiltered,
						new Predicate<Component>() {

							public boolean apply(Component c) {
								return c.getMetricRefs().contains(metric);
							}
						});
				int resultSize = Iterables.size(narrowFilter);
				if (resultSize == 1) {
					return narrowFilter;
				}
			}
		}

		return filter;
	}

	/**
	 * Populate the provided collection with {@link Metric metrics} referenced
	 * by the provided {@link Component} along the parent Path.
	 * 
	 * @param result
	 * @param c
	 */
	public static void metricsInPath(List<Metric> result, Component c) {
		if (result != null) {

			if (!c.getMetricRefs().isEmpty()) {
				result.addAll(c.getMetricRefs());
			}

			EObject container = c.eContainer();
			if (container instanceof Component) {
				metricsInPath(result, (Component) container);
			}
		}
	}

	/**
	 * get the quantity of failed {@link MappingRecord} for a
	 * {@link MappingStatistic} and sub-statistics.
	 * 
	 * @param mapStat
	 * @return
	 */
	public static int mappingFailedCount(MappingStatistic mapStat) {
		int totalErrors = 0;
		for (MappingRecord mr : mapStat.getFailedRecords()) {
			totalErrors += mr.getCount();
		}
		for (MappingStatistic ms : mapStat.getSubStatistics()) {
			totalErrors += mappingFailedCount(ms);
		}
		return totalErrors;
	}

	/**
	 * The component name. If the component is a Function, the name will be
	 * returned. If the component is an Equipment, the code could be returned or
	 * the name.
	 * 
	 * @param fromObject
	 * @return
	 */
	public static String componentName(Component fromObject) {

		String name = fromObject.getName();

		if (fromObject instanceof Equipment) {
			String code = ((Equipment) fromObject).getEquipmentCode();

			StringBuilder sb = new StringBuilder();
			if (code != null && code.length() > 0) {
				sb.append(code + " ");
			}
			if (name != null && name.length() > 0) {
				sb.append(name);
			}
			return sb.toString();

		} else if (fromObject instanceof com.netxforge.netxstudio.library.Function) {
			return name != null ? name : "?";
		}
		return null;
	}

	/**
	 * Looks for instances of {@link Operator} in the given {@link Resource}.
	 * 
	 * @param resource
	 * @return
	 */
	public static List<NodeType> nodeTypesForResource(Resource resource) {

		final List<Node> nodesForNetwork = Lists.newArrayList();

		for (EObject eo : resource.getContents()) {
			if (eo instanceof Operator) {
				Operator op = (Operator) eo;
				for (Network n : op.getNetworks()) {
					nodesForNetwork.addAll(nodesForNetwork(n));
				}
			}
		}

		Iterable<NodeType> transform = Iterables.transform(nodesForNetwork,
				new Function<Node, NodeType>() {
					public NodeType apply(Node n) {
						return n.getNodeType();
					}
				});

		// filter null entries.
		transform = Iterables.filter(transform, new Predicate<NodeType>() {
			public boolean apply(NodeType nt) {
				return nt != null;
			}
		});

		final List<NodeType> nodeTypes = Lists.newArrayList(transform);

		return nodeTypes;
	}

	/**
	 * all {@link NodeType} objects belonging to the provided {@link Service} of
	 * type {@link RFService}
	 * 
	 * @param service
	 * @return
	 */
	public static List<NodeType> nodeTypeForService(Service service) {
		final List<NodeType> nodeTypes = new ArrayList<NodeType>();
		if (service instanceof RFSService) {
			for (Node n : ((RFSService) service).getNodes()) {
				nodeTypes.add(n.getNodeType());
			}
			// for (Service subService : service.getServices()) {
			// nodeTypes.addAll(nodeTypeForService(subService));
			// }
		}
		return nodeTypes;
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

	public static List<Value> sortAndApplyPeriod(List<Value> values,
			DateTimeRange dtr, boolean reverse) {
		List<Value> sortedCopy;
		if (reverse) {
			sortedCopy = sortValuesByTimeStampAndReverse(values);

		} else {
			sortedCopy = sortValuesByTimeStamp(values);

		}
		return valuesInsideRange(sortedCopy, dtr);
	}

}
