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

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.RangeKind;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.MarkerKind;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind;
import com.netxforge.netxstudio.services.DerivedResource;

/**
 * Implements the processing of an expression result.
 * 
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class ResultProcessor {

	@Inject
	private ModelUtils modelUtils;

	private ResourceMonitor resourceMonitor;
	private Tolerance tolerance;

	public void processServiceProfileResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, Date start, Date end) {
		for (final BaseExpressionResult baseExpressionResult : expressionResults) {

			if (baseExpressionResult instanceof ExpressionResult) {
				ExpressionResult expressionResult = (ExpressionResult) baseExpressionResult;

				if (DataActivator.DEBUG) {

					System.out.println("--Writing expression result: resource="
							+ expressionResult.getTargetResource()
									.getShortName() + " target="
							+ expressionResult.getTargetRange().getName()
							+ " values="
							+ expressionResult.getTargetValues().size());
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
			System.out.println("--Writing expression result: resource="
					+ expressionResult.getTargetResource().getShortName()
					+ " target=" + expressionResult.getTargetRange().getName()
					+ " values=" + expressionResult.getTargetValues().size());
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
					System.out.println("--Writing to resource in Node: "
							+ n.getNodeID());
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
			case RangeKind.TOLERANCE_VALUE:
				createMarkers(expressionResult, start, end);
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
			System.out.println("--Done processing monitoring result");
		}
	}

	/**
	 * Creates markers for a given period.
	 * 
	 * @param expressionResult
	 * @param start
	 * @param end
	 */
	private void createMarkers(ExpressionResult expressionResult, Date start,
			Date end) {

		System.out
				.println("- CreateMarkers markers before in resource monitor="
						+ resourceMonitor.getMarkers().size());

		if (expressionResult.getTargetValues().size() == 0) {
			// markers can not be created.
			return;
		}

		NetXResource resource = (NetXResource) expressionResult
				.getTargetResource();

		List<Value> usageValues = new ArrayList<Value>();

		for (final MetricValueRange mvr : resource.getMetricValueRanges()) {
			usageValues.addAll(mvr.getMetricValues());
		}

		final List<Value> toRemoveUsageValues = new ArrayList<Value>();
		for (final Value usageValue : usageValues) {
			final long timeMillis = usageValue.getTimeStamp()
					.toGregorianCalendar().getTimeInMillis();
			if (timeMillis < start.getTime() || timeMillis > end.getTime()) {
				toRemoveUsageValues.add(usageValue);
			}
		}

		usageValues.removeAll(toRemoveUsageValues);

		usageValues = modelUtils.sortValuesByTimeStamp(usageValues);

		System.out.println("CreateMarkers use values size="
				+ usageValues.size());

		// now get the tolerance computation
		final List<Value> toleranceValues = modelUtils
				.sortValuesByTimeStamp(expressionResult.getTargetValues());

		// now walk through the lists and find the occurences of overrides
		Value currentToleranceValue = null;
		int index = 0;
		boolean isOver = false;
		boolean startMarkerGenerated = false;

		final List<Marker> newMarkers = new ArrayList<Marker>();
		for (final Value toleranceValue : toleranceValues) {

			// check all values between the current tolerance and the previous,
			// skip in between values.
			long toTime = end.getTime();
			long fromTime = start.getTime();
			if (index < (toleranceValues.size() - 1)) {
				toTime = toleranceValues.get(index + 1).getTimeStamp()
						.toGregorianCalendar().getTimeInMillis();
			}
			if (currentToleranceValue == null) {
				currentToleranceValue = toleranceValue;
			} else {
				fromTime = currentToleranceValue.getTimeStamp()
						.toGregorianCalendar().getTimeInMillis();
			}

			System.out.println("- CreateMarkers tolerance="
					+ toleranceValue.getValue() + " ,"
					+ modelUtils.dateAndTime(toleranceValue.getTimeStamp()));
			System.out.println("- CreateMarkers from time="
					+ new Date(fromTime));
			System.out.println("- CreateMarkers to time=" + new Date(toTime));

			// values within period of tolerance hops.
			final List<Value> checkValues = Lists.newArrayList();
			for (final Value usageValue : usageValues) {
				final long time = usageValue.getTimeStamp()
						.toGregorianCalendar().getTimeInMillis();
				if (time >= fromTime && time <= toTime) {
					checkValues.add(usageValue);
				}
			}

			System.out
					.println("- CreateMarkers checkvalues within tolerance hop="
							+ checkValues.size());
			double tDouble = currentToleranceValue.getValue();

			// check if they are over or under
			for (final Value checkValue : checkValues) {

				double cDouble = checkValue.getValue();

				ToleranceMarkerDirectionKind direction = null;

				// Generate a start marker only if the the level type is YELLOW,
				// if not specified, this would not be relevant.
				// It means the markers will only be complete, if all tolerance
				// levels are
				// specified.

				if (getTolerance().getLevel() == LevelKind.YELLOW
						&& cDouble < tDouble && !startMarkerGenerated) {
					// generate a start marker
					isOver = false;
					direction = ToleranceMarkerDirectionKind.DOWN;
				} else if (cDouble < tDouble && isOver) {
					isOver = false;
					direction = ToleranceMarkerDirectionKind.DOWN;
				} else if (cDouble > tDouble && !isOver) {
					// generate a marker
					isOver = true;
					direction = ToleranceMarkerDirectionKind.UP;
				}
				if (direction != null) {

					// Create a marker as we have crossed a tolerance.

					final ToleranceMarker marker = OperatorsFactory.eINSTANCE
							.createToleranceMarker();
					marker.setValueRef(checkValue);
					marker.setKind(MarkerKind.TOLERANCECROSSED);
					marker.setLevel(getTolerance().getLevel());
					if (startMarkerGenerated) {
						marker.setDirection(direction);
					} else {
						marker.setDirection(ToleranceMarkerDirectionKind.START);
					}
					marker.setDescription(expressionResult.getTargetResource()
							.getLongName());
					System.out
							.println("- CreateMarkers adding marker"
									+ checkValue.getValue()
									+ " , "
									+ modelUtils.dateAndTime(checkValue
											.getTimeStamp()));
					newMarkers.add(marker);
				}
				startMarkerGenerated = true;
			}
			index++;
		}

		System.out.println("- CreateMarkers total markers created size="
				+ newMarkers.size());

		// now compare the newmarkers with what is already there
		for (final Marker newMarker : newMarkers) {
			index = 0;
			boolean found = false;
			for (final Marker existingMarker : new ArrayList<Marker>(
					resourceMonitor.getMarkers())) {
				if (existingMarker.getValueRef().getTimeStamp()
						.equals(newMarker)) {
					// red is more heavy than amber, replace the entry
					if (((ToleranceMarker) newMarker).getLevel() == LevelKind.RED
							&& ((ToleranceMarker) existingMarker).getLevel() == LevelKind.AMBER) {
						resourceMonitor.getMarkers().set(index, newMarker);
						found = true;
						break;
					}
				}
				index++;
			}
			if (!found) {
				resourceMonitor.getMarkers().add(newMarker);
			}
		}

		System.out.println("- CreateMarkers markers now in resource monitor="
				+ resourceMonitor.getMarkers().size());
	}

	/**
	 * Maintaince the state of the tolerance for a current set of values. It is
	 * either over or under.
	 * 
	 * @author Christophe
	 * 
	 */
	class ToleranceState {
		boolean isOver = false;
		boolean startMarkerGenerated = false;
		private Double tDouble;

		ToleranceState(Double tDouble) {
			this.tDouble = tDouble;
		}

		/**
		 * @param checkValue
		 * @param direction
		 */
		class MarkerForDirection implements
				Function<ToleranceMarkerDirectionKind, ToleranceMarker> {

			private Value checkValue;
			private String description;

			MarkerForDirection(Value checkValue, String description) {
				this.checkValue = checkValue;
				this.description = description;
			}

			public ToleranceMarker apply(ToleranceMarkerDirectionKind direction) {

				new Direction();

				if (direction != null) {

					// Create a marker as we have crossed a tolerance.

					final ToleranceMarker marker = OperatorsFactory.eINSTANCE
							.createToleranceMarker();
					marker.setValueRef(checkValue);
					marker.setKind(MarkerKind.TOLERANCECROSSED);
					marker.setLevel(getTolerance().getLevel());
					if (startMarkerGenerated) {
						marker.setDirection(direction);
					} else {
						marker.setDirection(ToleranceMarkerDirectionKind.START);
					}
					// marker.setDescription(expressionResult.getTargetResource()
					// .getLongName());
					marker.setDescription(description);

					System.out
							.println("- CreateMarkers adding marker"
									+ checkValue.getValue()
									+ " , "
									+ modelUtils.dateAndTime(checkValue
											.getTimeStamp()));
					return marker;
				}

				startMarkerGenerated = true;
				return null;
			}
		}

		class Direction implements
				Function<Value, ToleranceMarkerDirectionKind> {

			public ToleranceMarkerDirectionKind apply(Value checkValue) {
				ToleranceMarkerDirectionKind direction = null;
				double cDouble = checkValue.getValue();

				// Generate a start marker only if the the level type is YELLOW,
				// if not specified, this would not be relevant.
				// It means the markers will only be complete, if all tolerance
				// levels are
				// specified.

				if (getTolerance().getLevel() == LevelKind.YELLOW
						&& cDouble < tDouble && !startMarkerGenerated) {
					// generate a start marker
					isOver = false;
					direction = ToleranceMarkerDirectionKind.DOWN;
				} else if (cDouble < tDouble && isOver) {
					isOver = false;
					direction = ToleranceMarkerDirectionKind.DOWN;
				} else if (cDouble > tDouble && !isOver) {
					// generate a marker
					isOver = true;
					direction = ToleranceMarkerDirectionKind.UP;
				}
				return direction;
			}
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

		System.out.println(" Result filler =" + values.size());
		for (Value v : resultValues) {
			System.out.println(" Orignal value =" + v.getTimeStamp());
		}

		for (Value v : values) {
			System.out.println(" Derived values =" + v.getTimeStamp());
		}
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
	 * always matched with an existing one first.
	 * 
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

		}

		final MetricValueRange mvr = modelUtils
				.valueRangeForIntervalAndKindGetOrCreate(foundNetXResource,
						kindHintType, intervalHint);

		if (DataActivator.DEBUG) {
			System.out
					.println("SERVER: Located/create value range for resource : "
							+ foundNetXResource.getShortName()
							+ " range size = " + mvr.getMetricValues().size());
		}

		if (start != null && end != null) {
			if (DataActivator.DEBUG) {
				System.out.println("SERVER: removing values from start="
						+ modelUtils.dateAndTime(start) + " , end="
						+ modelUtils.dateAndTime(end));
			}
			removeValues(mvr.getMetricValues(), start, end);
		}

		// TODO Should filter for period, as we will other try to match the time
		// against the whole range.
		addToValues(mvr.getMetricValues(), newValues, intervalHint);
	}

	public void addToValues(EList<Value> values, List<Value> newValues,
			int intervalHint) {
		for (final Value newValue : new ArrayList<Value>(newValues)) {
			addToValues(values, newValue, intervalHint);
		}
	}

	/*
	 * If this method is used to
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
				System.out.println("SERVER: found value within interval ("
						+ intervalHint + " min.), while storing value="
						+ foundValue.getValue() + " , timestamp="
						+ modelUtils.dateAndTime(foundValue.getTimeStamp())
						+ " original timestamp=" + value.getTimeStamp());
			}
			foundValue.setValue(value.getValue());
		} else {
			if (DataActivator.DEBUG) {
				System.out.println("SERVER: NO values withing interval  ("
						+ intervalHint + " min.), while storing value="
						+ value.getValue() + " , timestamp="
						+ modelUtils.dateAndTime(value.getTimeStamp()));
			}
			currentValues.add(value);
		}
	}

	/**
	 * The IntervalHint is required if to compare the difference is less than
	 * the interval.
	 * 
	 * @param intervalHint
	 * @param time1
	 * @param time2
	 * @return
	 */
	private boolean isSameTime(int intervalHint, long time1,
			XMLGregorianCalendar time2) {
		long diff = time1 - time2.toGregorianCalendar().getTimeInMillis();
		if (diff < 0) {
			diff = diff * -1;
		}
		// Substract one second, to make sure we really do not skip closely
		// related entries.
		return diff < ((intervalHint * 60 * 1000) - 1000);
	}

	// from ModelUtils.
	// private class ValueTimeComparator implements Comparator<Value> {
	//
	// public int compare(Value arg0, Value arg1) {
	// return arg0.getTimeStamp().compare(arg1.getTimeStamp());
	// }
	// }

	public ResourceMonitor getResourceMonitor() {
		return resourceMonitor;
	}

	public void setResourceMonitor(ResourceMonitor resourceMonitor) {
		this.resourceMonitor = resourceMonitor;
	}

	public Tolerance getTolerance() {
		return tolerance;
	}

	public void setTolerance(Tolerance tolerance) {
		this.tolerance = tolerance;
	}

}