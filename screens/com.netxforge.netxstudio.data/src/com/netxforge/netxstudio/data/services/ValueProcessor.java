/*******************************************************************************
 * Copyright (c) May 12, 2011 NetXForge.
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
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.services;

import static com.netxforge.base.NonModelUtils.toXMLDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.spi.cdo.FSMUtil;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.ReferenceHelper;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.RangeKind;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.ServiceMonitor;

/**
 * This class is a supporting class for processing results from Expression
 * Evaluations {@link ExpressionResult } and also directly processing Value
 * results from imports. </p> When an Expression Result involves a tolerance
 * {@link ValueRange range}, the {@link ToleranceProcessor} is invoked. It needs
 * to be configured with a {@link ResourceMonitor} and a {@link Tolerance}
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
@Singleton
public class ValueProcessor {

	@Inject
	private IQueryService queryService;

	/**
	 * In this mode the processor will match a single value within the target
	 * interval. If the time stamp equals and the value equals, the existing
	 * value will be kept.
	 */
	public static final int SINGLE_VALUE_IN_INTERVAL_MODE = 100;

	/**
	 * Do not consider the interval, simply match on the timestamp.
	 */
	public static final int INDIFFERENT_VALUES_IN_INTERVAL_MODE = 200;

	/**
	 * Process a Service Profile calculation result.
	 * 
	 * @param currentContext
	 * @param expressionResults
	 * @param start
	 * @param end
	 */
	public  void processServiceProfileResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, Date start, Date end) {
		for (final BaseExpressionResult baseExpressionResult : expressionResults) {

			if (baseExpressionResult instanceof ExpressionResult) {
				ExpressionResult expressionResult = (ExpressionResult) baseExpressionResult;

				if (DataActivator.DEBUG) {
					DataActivator.TRACE
							.trace(DataActivator.TRACE_RESULT_EXPRESSION_OPTION,
									"writing expression result: resource="
											+ expressionResult
													.getTargetResource()
													.getShortName()
											+ " target="
											+ expressionResult.getTargetRange()
													.getName()
											+ " values="
											+ expressionResult
													.getTargetValues().size());
				}

				// FIXME: We could want to write to a resource, where the node
				// doesn't match the context.
				final BaseResource baseResource = expressionResult
						.getTargetResource();

				// Process a DerivedResource

				if (baseResource instanceof DerivedResource) {
					DerivedResource resource = (DerivedResource) baseResource;
					if (expressionResult.getTargetRange().getValue() == RangeKind.DERIVED_VALUE) {

						// TODO Decide, what to do with the existing values.
						addToValues(resource.getValues(),
								expressionResult.getTargetValues(),
								expressionResult.getTargetIntervalHint());
					} else {
						throw new IllegalStateException("Range kind "
								+ expressionResult.getTargetRange()
								+ " not supported");
					}
				}
			}
		}
	}

	/**
	 * Remove {@link Value} objects and potential references to them. Currently
	 * only {@link Marker} objects reference the <code>Value</code> object, so
	 * remove the entire marker and potentially the resource monitor belonging
	 * to it.
	 * 
	 * @param values
	 */
	public  void removeValues(EList<Value> values, Date start, Date end) {
		final long startMillis = start.getTime();
		final long endMillis = end.getTime();
		final List<Value> toRemove = new ArrayList<Value>();
		for (final Value value : values) {
			final long millis = value.getTimeStamp().toGregorianCalendar()
					.getTimeInMillis();
			if (millis >= startMillis && millis <= endMillis) {
				toRemove.add(value);
			}
		}

		removeValueReferences(toRemove);
		values.removeAll(toRemove);
	}

	/**
	 * Remove {@link Value} objects and potential references to them. Currently
	 * only {@link Marker} objects reference the <code>Value</code> object, so
	 * remove the entire marker and potentially the resource monitor belonging
	 * to it.
	 * 
	 * @param values
	 */
	public  void removeValues(List<Value> values) {
		final List<Value> toRemove = new ArrayList<Value>(values);

		removeValueReferences(toRemove);
		values.removeAll(toRemove);
	}

	/**
	 * Remove {@link Value} objects from a {@link MetricValueRange} and
	 * potential references to them. Currently only {@link Marker} objects
	 * reference the <code>Value</code> object, so remove the entire marker and
	 * potentially the resource monitor belonging to it.
	 * 
	 * @param values
	 */
	public  boolean removeValues(MetricValueRange mvr, List<Value> values) {

		int size = mvr.getMetricValues().size();
		// final List<Value> toRemove = Lists.newArrayList(values);

		removeValueReferences(values);

		for (Value v : values) {

			if (mvr.getMetricValues().contains(v)) {
				mvr.getMetricValues().remove(v);
			}

		}
		// Assume these are contained here.
		return mvr.getMetricValues().size() != size;
	}

	/**
	 * Remove the {@link Value } objects from the target collection
	 * 
	 * @param targetRange
	 *            The target values to remove from
	 * @param values
	 *            The values to remove.
	 * @return
	 */
	public  boolean removeValues(EList<Value> targetRange,
			List<Value> values) {

		int size = targetRange.size();

		removeValueReferences(values);

		for (Value v : values) {

			if (targetRange.contains(v)) {
				targetRange.remove(v);
			}
		}

		// Assume these are contained here.
		return targetRange.size() != size;
	}

	/**
	 * @param toRemove
	 */
	public void removeValueReferences(final List<Value> toRemove) {
		// Produce a list of resource monitors to check, if they indirectly
		// reference values scheduled for removal.
		List<ResourceMonitor> monitorsList = Lists.newArrayList();
		List<Marker> markersToRemove = Lists.newArrayList();

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_RESULT_VALUE_OPTION,
					"x-ref value references");
		}

		List<CDOObjectReference> xRefs = ReferenceHelper
				.findReferencesGlobally(toRemove);

		if (xRefs != null) {
			for (CDOObjectReference xref : xRefs) {
				EObject referencingEObject = xref.getSourceObject();
				if (referencingEObject instanceof Marker) {
					markersToRemove.add((Marker) referencingEObject);
					if (referencingEObject.eContainer() != null
							&& referencingEObject.eContainer() instanceof ResourceMonitor) {

						ResourceMonitor rm = (ResourceMonitor) referencingEObject
								.eContainer();
						rm.getMarkers().remove(referencingEObject);
						monitorsList.add(rm);

					}
				}
				// EObject eObject = xref.getTargetObject();
			}
		}

		Map<ServiceMonitor, List<ResourceMonitor>> serviceMonitorsList = Maps
				.newHashMap();

		// Clear empty monitors.
		for (ResourceMonitor rm : monitorsList) {

			if (rm.getMarkers().isEmpty()) {

				if (rm.eContainer() != null
						&& rm.eContainer() instanceof ServiceMonitor) {
					ServiceMonitor sm = (ServiceMonitor) rm.eContainer();
					if (serviceMonitorsList.containsKey(sm)) {
						serviceMonitorsList.get(sm).add(rm);
					} else {
						List<ResourceMonitor> rms = Lists.newArrayList();
						rms.add(rm);
						serviceMonitorsList.put(sm, rms);
					}
				}
			}
		}

		for (ServiceMonitor sm : serviceMonitorsList.keySet()) {
			sm.getResourceMonitors().removeAll(serviceMonitorsList.get(sm));
		}

		// TODO, Do something with empty service monitors, if any.

	}

	/*
	 * Takes the set of values from the expression result and populates a new
	 * set of values filled from the provided start date upto the end date, with
	 * an interval as specified in the expression result. The "filler" value is
	 * respectively the first and last of the set in the expression result.
	 * 
	 * I.e. when start and end is exactly one day apart, and the interval is 60,
	 * the number of values should be exactly 24.
	 */
	@SuppressWarnings("unused")
	private List<Value> getCreateValues(ExpressionResult result, Date start,
			Date end) {

		List<Value> resultValues = StudioUtils
				.sortValuesByTimeStampAndReverse(result.getTargetValues());

		final List<Value> values = new ArrayList<Value>();
		Date previousTime = start;
		Value previousValue = null;
		for (final Value resultValue : resultValues) {

			// fill-up with values with the specified interval, until the result
			// value is reached.
			// CB 09-02-2012 , bug with NPE on previousValue;
			long nextTime = previousTime.getTime()
					+ result.getTargetIntervalHint() * 60000;
			while (nextTime < resultValue.getTimeStamp().toGregorianCalendar()
					.getTimeInMillis()) {
				final Value newValue = GenericsFactory.eINSTANCE.createValue();
				// If we have a previous, otherwise bail.
				newValue.setValue(previousValue != null ? previousValue
						.getValue() : resultValue.getValue());
				newValue.setTimeStamp(toXMLDate(new Date(nextTime)));
				nextTime += result.getTargetIntervalHint() * 60000;
				values.add(newValue);
			}
			values.add(resultValue);
			previousValue = resultValue;
			previousTime = resultValue.getTimeStamp().toGregorianCalendar()
					.getTime();
		}
		// fill-up values for the rest of the period
		if (previousTime.getTime() < (end.getTime() - result
				.getTargetIntervalHint() * 60000)) {
			long nextTime = previousTime.getTime()
					+ result.getTargetIntervalHint() * 60000;
			while (nextTime < end.getTime()) {
				final Value newValue = GenericsFactory.eINSTANCE.createValue();
				newValue.setValue(previousValue.getValue());
				newValue.setTimeStamp(toXMLDate(new Date(nextTime)));
				nextTime += result.getTargetIntervalHint() * 60000;
				values.add(newValue);
			}
		}

		// System.out.println(" Result filler =" + values.size());
		// for (Value v : resultValues) {
		// System.out.println(" Orignal value =" + v.getTimeStamp());
		// }
		//
		// for (Value v : values) {
		// System.out.println(" Derived values =" + v.getTimeStamp());
		// }
		return values;

	}

	public void addToValueRange(NetXResource foundNetXResource,
			int intervalHint, KindHintType kindHintType, List<Value> newValues,
			Date start, Date end) {
		addToValueRange(foundNetXResource, intervalHint, kindHintType,
				newValues, start, end, INDIFFERENT_VALUES_IN_INTERVAL_MODE);

	}

	/**
	 * Adds values to a metric value range. the Metric Value range is induced
	 * from the interval and kind hints. The period (Between Start and End
	 * timestamps), is optional. when provided, all values in this period will
	 * be first removed.
	 * 
	 * @param foundNetXResource
	 * @param intervalHint
	 * @param kindHintType
	 * @param newValues
	 * @param start
	 * @param end
	 */
	public  void addToValueRange(NetXResource foundNetXResource,
			int intervalHint, KindHintType kindHintType, List<Value> newValues,
			Date start, Date end, int writeMode) {

		// Default equals -1.
		if (intervalHint == -1) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- interval not set. ");
			}
		}

		// CB Experimental, pre-load only 24 indexes, and chunks of 24.
		//
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=394076
		// foundNetXResource
		// .cdoView()
		// .getSession()
		// .options()
		// .setCollectionLoadingPolicy(
		// CDOUtil.createCollectionLoadingPolicy(24, 24));

		final MetricValueRange mvr = StudioUtils
				.valueRangeForIntervalAndKindGetOrCreate(foundNetXResource,
						kindHintType, intervalHint);

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_RESULT_VALUE_OPTION,
					"-- Located/create value range for resource : "
							+ foundNetXResource.getShortName() + "interval="
							+ intervalHint + " range size = "
							+ mvr.getMetricValues().size());
		}

		// Do not remove values if we are not adding anything!
		// if (start != null && end != null) {
		//
		// removeValues(mvr.getMetricValues(), start, end);
		// if (DataActivator.DEBUG) {
		// DataActivator.TRACE.trace(
		// DataActivator.TRACE_RESULT_VALUE_OPTION,
		// "-- Removed values from start="
		// + modelUtils.dateAndTime(start) + " , end="
		// + modelUtils.dateAndTime(end));
		// }
		// }

		addToValues(mvr, newValues, intervalHint, writeMode);

		if (DataActivator.DEBUG) {
			// DataActivator.TRACE.trace(
			// DataActivator.TRACE_RESULT_VALUE_OPTION,
			// "-- range for resource (after add): "
			// + foundNetXResource.getShortName() + "interval="
			// + intervalHint + " range size = "
			// + mvr.getMetricValues().size());

			for (MetricValueRange range : foundNetXResource
					.getMetricValueRanges()) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- range for resource (after add): "
								+ foundNetXResource.getShortName()
								+ "interval=" + range.getIntervalHint()
								+ " range size = "
								+ range.getMetricValues().size());
			}

		}
	}

	/**
	 * Add a collection of values to a metric value range.
	 * 
	 * @param mvr
	 * @param newValues
	 * @param intervalHint
	 */
	public  void addToValues(EList<Value> values, List<Value> newValues,
			int intervalHint) {
		for (final Value newValue : new ArrayList<Value>(newValues)) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- Attempt to add value within interval ("
								+ intervalHint + " min.), "
								+ StudioUtils.value(newValue));
			}

			addToValues(values, newValue, intervalHint);
		}
	}

	/**
	 * Add a collection of values to a metric value range.
	 * 
	 * @param mvr
	 * @param newValues
	 * @param intervalHint
	 */
	public  void addToValues(MetricValueRange mvr, List<Value> newValues,
			int intervalHint, int writeMode) {
		for (final Value newValue : new ArrayList<Value>(newValues)) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- Attempt to add value within interval ("
								+ intervalHint + " min.), "
								+ StudioUtils.value(newValue));
			}

			addToValues(mvr, newValue, intervalHint, writeMode);
		}
	}

	/**
	 * Add to a value range.
	 * 
	 * @param currentValues
	 * @param value
	 * @param intervalHint
	 * @deprecated
	 */
	public  void addToValues(EList<Value> currentValues, Value value,
			int intervalHint) {

		final long timeInMillis = value.getTimeStamp().toGregorianCalendar()
				.getTimeInMillis();

		Value foundValue = null;

		for (final Value lookValue : currentValues) {
			if (NonModelUtils.isSameTime(intervalHint, timeInMillis,
					lookValue.getTimeStamp())) {
				foundValue = lookValue;

				break;
			}
		}

		if (foundValue != null) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- found value within interval ("
								+ intervalHint
								+ " min.), while storing value="
								+ foundValue.getValue()
								+ " , original timestamp="
								+ NonModelUtils.dateAndTime(foundValue
										.getTimeStamp()));
			}
			// Same timestamp, different value!
			foundValue.setValue(value.getValue());
		} else {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- no values within interval  ("
								+ intervalHint
								+ " min.), while storing value="
								+ value.getValue()
								+ " , timestamp="
								+ NonModelUtils.dateAndTime(value
										.getTimeStamp()));
			}
			// New timestamp, new value.
			currentValues.add(value);
		}
	}

	/**
	 * Add to a value range. Has side effect on existing values depending on the
	 * mode. in {@link #INDIFFERENT_VALUES_IN_INTERVAL_MODE} the new value is
	 * matched against similar timestamps in for the {@link MetricValueRange}.
	 * When in {@link #SINGLE_VALUE_IN_INTERVAL_MODE} we query values within the
	 * interval period and remove them. The new value will always be added.
	 * 
	 * @param mvr
	 * @param value
	 * @param intervalHint
	 */
	public  void addToValues(MetricValueRange mvr, Value value,
			int intervalHint, int currentWriteMode) {

		Value foundValue = null;

		List<Value> sortedValues = null;

		// Checks.
		// 1. When state --> NEW. Do not check, we assume unique values in a
		// run.
		// 2. When state --> CLEAN Check with SQL query.
		// 3. When state --> DIRTY Check with SQL query, newly added values are
		// not considered.
		// 4. When state --> TRANSIENT is an illegal state at this point. The
		// MVR should be added to a NetXResource already.
		// 5. When state --> CONFLICT another process has updated this object.
		// The MVR should be refreshed before, we bail out.
		// 6. When state --> PROXY is an illegal state, the MVR should be
		// resolved.
		// 7. When state --> INVALID is an illegal state, the MVR should be
		// valid.
		if (FSMUtil.isConflict(mvr) || FSMUtil.isTransient(mvr)
				|| FSMUtil.isInvalid(mvr)) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- Range is in an illegal state, can't add values"
								+ " ("
								+ intervalHint
								+ " min.), while storing value="
								+ " , original timestamp="
								+ NonModelUtils.dateAndTime(value
										.getTimeStamp()));
			}
			return;
		}

		// Look for existing entries, depending on the write mode.
		if (!FSMUtil.isNew(mvr)) {

			if (currentWriteMode == INDIFFERENT_VALUES_IN_INTERVAL_MODE) {
				sortedValues = queryService.mvrValues(mvr.cdoView(), mvr,
						IQueryService.QUERY_MYSQL, value.getTimeStamp());

				if (sortedValues != null && sortedValues.size() == 1) {
					foundValue = sortedValues.get(0); // we only have one entry.
				} else {
					if (sortedValues.size() > 1) {
						int duplicates = sortedValues.size() - 1;
						if (DataActivator.DEBUG) {
							DataActivator.TRACE.trace(
									DataActivator.TRACE_RESULT_VALUE_OPTION,
									"-- found duplicates values:"
											+ duplicates
											+ " ("
											+ intervalHint
											+ " min.), while storing value="
											+ " , original timestamp="
											+ NonModelUtils.dateAndTime(value
													.getTimeStamp()));
							DataActivator.TRACE.trace(
									DataActivator.TRACE_RESULT_VALUE_OPTION,
									"-- cleaning duplicates");

						}

						// Keep the first one, remove the rest.
						foundValue = sortedValues.get(0);
						ImmutableList<Value> toRemove = ImmutableList
								.copyOf(sortedValues.subList(1,
										sortedValues.size()));
						removeValues(mvr, toRemove);
					}
				}
			} else if (currentWriteMode == SINGLE_VALUE_IN_INTERVAL_MODE) {
				DateTimeRange intervalPeriod = StudioUtils.period(value,
						intervalHint);

				sortedValues = queryService.mvrValues(mvr.cdoView(), mvr,
						IQueryService.QUERY_MYSQL, intervalPeriod);
				ImmutableList<Value> toRemove = ImmutableList
						.copyOf(sortedValues);
				removeValues(mvr, toRemove);
			}
		} else {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- range is in state NEW, assume unique value"
								+ " ("
								+ intervalHint
								+ " min.), while storing value="
								+ " , original timestamp="
								+ NonModelUtils.dateAndTime(value
										.getTimeStamp()));
			}

		}

		if (foundValue != null) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- found value within interval ("
								+ intervalHint
								+ " min.), while storing value="
								+ foundValue.getValue()
								+ " , original timestamp="
								+ NonModelUtils.dateAndTime(foundValue
										.getTimeStamp()));
			}
			// Same timestamp, different value!
			foundValue.setValue(value.getValue());
		} else {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- no values within interval  ("
								+ intervalHint
								+ " min.), while storing value="
								+ value.getValue()
								+ " , timestamp="
								+ NonModelUtils.dateAndTime(value
										.getTimeStamp()));
			}
			// New timestamp, new value.
			mvr.getMetricValues().add(0, value);
		}
	}
}