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
package com.netxforge.netxstudio.data.importer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.data.tolerance.ToleranceProcessor;
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
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.services.DerivedResource;

/**
 * This class is a supporting class for processing results from Expression
 * Evaluations {@link ExpressionResult } and also directly processing Value
 * results from imports. When an Expression Result involves a {@link Tolerance
 * range}, the {@link ToleranceProcessor} is invoked. It needs to be configured
 * with a {@link ResourceMonitor} and a {@link Tolerance}
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class ResultProcessor {

	@Inject
	private ModelUtils modelUtils;

	@Inject
	private ToleranceProcessor tolProcessor;

	@Inject
	private IQueryService queryService;

	/**
	 * Process a Service Profile calculation result.
	 * 
	 * @param currentContext
	 * @param expressionResults
	 * @param start
	 * @param end
	 */
	public void processServiceProfileResult(List<Object> currentContext,
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

	public void processMonitoringResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, Date start, Date end) {
		for (final BaseExpressionResult baseExpressionResult : expressionResults) {
			if (baseExpressionResult instanceof ExpressionResult) {
				ExpressionResult expressionResult = (ExpressionResult) baseExpressionResult;
				processMonitoringExpressionResult(start, end, expressionResult);
			}
		}
	}

	private void processMonitoringExpressionResult(Date start, Date end,
			final ExpressionResult expressionResult) {

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_RESULT_EXPRESSION_OPTION,
					"writing expression result: resource="
							+ expressionResult.getTargetResource()
									.getShortName() + " target="
							+ expressionResult.getTargetRange().getName()
							+ " interval="
							+ expressionResult.getTargetIntervalHint()
							+ " kind = "
							+ expressionResult.getTargetKindHint().getName()
							+ " values="
							+ expressionResult.getTargetValues().size());
		}

		// FIXME: We could want to write to a resource, where the node
		// doesn't match the context. The original context Node is not known
		// here.
		final BaseResource baseResource = expressionResult.getTargetResource();

		// Process a NetXResource
		if (baseResource instanceof NetXResource) {
			NetXResource resource = (NetXResource) baseResource;
			final Node n = modelUtils.nodeFor(resource.getComponentRef());

			if (DataActivator.DEBUG) {
				if (n != null) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_RESULT_EXPRESSION_OPTION,
							"writing to resource in Node: " + n.getNodeID());
				}
			}

			switch (expressionResult.getTargetRange().getValue()) {
			case RangeKind.CAP_VALUE:
				// Remove previous values within the range.
				removeValues(resource.getCapacityValues(), start, end);
				addToValues(resource.getCapacityValues(),
						expressionResult.getTargetValues(),
						expressionResult.getTargetIntervalHint());
				break;
			case RangeKind.METRIC_VALUE:

				// TODO, Apply a value filler as the interpreter will only
				// return two values
				// with Timestamps matching start and end of the period.

				// Disable the filler values.
				// @SuppressWarnings("unused")
				// List<Value> createValues = getCreateValues(expressionResult,
				// start, end);

				addToValueRange(resource,
						expressionResult.getTargetIntervalHint(),
						expressionResult.getTargetKindHint(),
						expressionResult.getTargetValues(), start, end);

				break;
			case RangeKind.TOLERANCE_VALUE: {
				if (tolProcessor != null && tolProcessor.ready()) {
					tolProcessor.markersForExpressionResult(expressionResult,
							start, end);
				}
			}
				break;
			case RangeKind.UTILIZATION_VALUE:
				removeValues(resource.getUtilizationValues(), start, end);
				addToValues(resource.getUtilizationValues(),
						expressionResult.getTargetValues(),
						expressionResult.getTargetIntervalHint());
				break;
			case RangeKind.METRICREMOVE_VALUE:
				final MetricValueRange mvr = modelUtils
						.valueRangeForIntervalAndKindGetOrCreate(resource,
								expressionResult.getTargetKindHint(),
								expressionResult.getTargetIntervalHint());
				if (start != null) {
					removeValues(mvr.getMetricValues(), start, end);
				}
				break;
			default:
				throw new IllegalStateException("Range kind "
						+ expressionResult.getTargetRange() + " not supported");
			}
		}

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_RESULT_EXPRESSION_OPTION,
					"done processing monitoring result");
		}
	}

	private void removeValues(EList<Value> values, Date start, Date end) {
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

		// Note, how to deal with references to the values? (ResourceMonitor
		// etc..).
		values.removeAll(toRemove);
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

		List<Value> resultValues = modelUtils
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
				newValue.setTimeStamp(modelUtils.toXMLDate(new Date(nextTime)));
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
				newValue.setTimeStamp(modelUtils.toXMLDate(new Date(nextTime)));
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

	/**
	 * Adds values to a metric value range. the Metric Value range is induced
	 * from the interval and kind hints. The period (Between Start and End
	 * timestamps), is optional. when provided, all values in this period will
	 * be first removed.
	 * 
	 * FIXME CB: Values are removed if Period is specified and then matched on
	 * timestamp, which would only exist, if not removed. If Period is not
	 * provided (i.e. Metric Source Importer does that). than the value is
	 * always matched with an existing one first
	 * 
	 * 
	 * @param foundNetXResource
	 * @param intervalHint
	 * @param kindHintType
	 * @param newValues
	 * @param start
	 * @param end
	 */
	public void addToValueRange(NetXResource foundNetXResource,
			int intervalHint, KindHintType kindHintType, List<Value> newValues,
			Date start, Date end) {

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
//		foundNetXResource
//				.cdoView()
//				.getSession()
//				.options()
//				.setCollectionLoadingPolicy(
//						CDOUtil.createCollectionLoadingPolicy(24, 24));

		final MetricValueRange mvr = modelUtils
				.valueRangeForIntervalAndKindGetOrCreate(foundNetXResource,
						kindHintType, intervalHint);

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(DataActivator.TRACE_RESULT_VALUE_OPTION,
					"-- Located/create value range for resource : "
							+ foundNetXResource.getShortName() + "interval="
							+ intervalHint + " range size = "
							+ mvr.getMetricValues().size());
		}

		if (start != null && end != null) {
			removeValues(mvr.getMetricValues(), start, end);
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- Removed values from start="
								+ modelUtils.dateAndTime(start) + " , end="
								+ modelUtils.dateAndTime(end));
			}
		}

		// TODO Should filter for period, as we will other try to match the time
		// against the whole range.
		// addToValues(mvr.getMetricValues(), newValues, intervalHint);
		addToValues(mvr, newValues, intervalHint);

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_RESULT_VALUE_OPTION,
					"-- range for resource (after add): "
							+ foundNetXResource.getShortName() + "interval="
							+ intervalHint + " range size = "
							+ mvr.getMetricValues().size());
		}
	}

	/**
	 * Add a collection of values to a metric value range.
	 * 
	 * @param mvr
	 * @param newValues
	 * @param intervalHint
	 */
	public void addToValues(EList<Value> values, List<Value> newValues,
			int intervalHint) {
		for (final Value newValue : new ArrayList<Value>(newValues)) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- Attempt to add value within interval ("
								+ intervalHint + " min.), "
								+ modelUtils.value(newValue));
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
	public void addToValues(MetricValueRange mvr, List<Value> newValues,
			int intervalHint) {
		for (final Value newValue : new ArrayList<Value>(newValues)) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- Attempt to add value within interval ("
								+ intervalHint + " min.), "
								+ modelUtils.value(newValue));
			}

			addToValues(mvr, newValue, intervalHint);
		}
	}

	/**
	 * Add to a value range.
	 * 
	 * @param currentValues
	 * @param value
	 * @param intervalHint
	 */
	public void addToValues(EList<Value> currentValues, Value value,
			int intervalHint) {

		final long timeInMillis = value.getTimeStamp().toGregorianCalendar()
				.getTimeInMillis();

		Value foundValue = null;
		
		
		for (final Value lookValue : currentValues) {
			if (isSameTime(intervalHint, timeInMillis, lookValue.getTimeStamp())) {
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
								+ modelUtils.dateAndTime(foundValue
										.getTimeStamp()));
			}
			// Same timestamp, different value!
			foundValue.setValue(value.getValue());
		} else {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- no values within interval  (" + intervalHint
								+ " min.), while storing value="
								+ value.getValue() + " , timestamp="
								+ modelUtils.dateAndTime(value.getTimeStamp()));
			}
			// New timestamp, new value.
			currentValues.add(value);
		}
	}

	/**
	 * Add to a value range, first trying to match the timestamp. If the
	 * timestamp matches, overwrite the value.
	 * 
	 * @param mvr
	 * @param value
	 * @param intervalHint
	 */
	public void addToValues(MetricValueRange mvr, Value value, int intervalHint) {

		Value foundValue = null;

		List<Value> sortedValues = null; 
		
		sortedValues = this.queryService.getSortedValues(
				mvr.cdoView(), mvr, IQueryService.QUERY_MYSQL,
				value.getTimeStamp());
	
		if (sortedValues != null && sortedValues.size() == 1) {
			foundValue = sortedValues.get(0); // we only have one entry.
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
								+ modelUtils.dateAndTime(foundValue
										.getTimeStamp()));
			}
			// Same timestamp, different value!
			foundValue.setValue(value.getValue());
		} else {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_VALUE_OPTION,
						"-- no values within interval  (" + intervalHint
								+ " min.), while storing value="
								+ value.getValue() + " , timestamp="
								+ modelUtils.dateAndTime(value.getTimeStamp()));
			}
			// New timestamp, new value.
			mvr.getMetricValues().add(0, value);
		}
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
	private boolean isSameTime(int intervalHint, long time1,
			XMLGregorianCalendar time2) {

		long diff = time1 - time2.toGregorianCalendar().getTimeInMillis();

		// make the diff value absolute.
		if (diff < 0) {
			diff = diff * -1;
		}

		if (intervalHint == ModelUtils.MINUTES_IN_AN_HOUR) {
			// Substract one second, to make sure we really do not skip closely
			// related entries.
			boolean isDiff = diff < ((intervalHint * 60 * 1000) - 1000);
			return isDiff;
		} else {
			return diff == 0; // exact equal timestamp.
		}

	}

	public ToleranceProcessor getToleranceProcessor() {
		return tolProcessor;
	}

}