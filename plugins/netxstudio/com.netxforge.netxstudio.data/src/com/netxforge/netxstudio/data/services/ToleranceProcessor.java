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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.cdo.common.revision.CDORevision;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.cdo.CDOQueryService;
import com.netxforge.netxstudio.data.cdo.CDOQueryUtil;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.MarkerKind;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind;

/**
 * This class is a supporting class, for processes. It also keeps state for like
 * the ResourceMonitor when processing
 * 
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class ToleranceProcessor {

	private ResourceMonitor resourceMonitor;

	/** The context {@link Tolerance } object */
	private Tolerance tolerance;

	// Options Parameters.

	/**
	 * When enabled, the interpreter will prefer using CDO Queries to get
	 * external data. (Non-Context). Otherwise, external data will be deduced by
	 * iterating over known objects or using the DataProvider.
	 */
	private static final boolean USE_QUERIES = true;

	/**
	 * Create markers for the expression result in the period from start to end.
	 * Instantiates a {@link ToleranceState} to maintain a previews Marker.
	 */

	/**
	 * Create markers for the expression result in the period from start to end.
	 * Instantiates a {@link ToleranceState} to maintain a previews Marker.
	 */
	public void markersForExpressionResult(ExpressionResult expressionResult,
			DateTimeRange dtr) {

		// Verify the configuration fof the processor.
		if (expressionResult.getTargetValues().size() == 0) {
			// markers can not be created.
			return;
		}
		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(DataActivator.TRACE_RESULT_TOL_OPTION,
					"markers before in resource monitor="
							+ resourceMonitor.getMarkers().size());
		}

		ToleranceState state = new ToleranceState(dtr);
		List<Marker> markersResult = state.process(expressionResult);

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(DataActivator.TRACE_RESULT_TOL_OPTION,
					"total markers created size=" + markersResult.size());
		}

		storeNewMarkers(markersResult);

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(DataActivator.TRACE_RESULT_TOL_OPTION,
					"markers now in resource monitor="
							+ resourceMonitor.getMarkers().size());
		}
	}

	/**
	 * Store markers for the given resource monitor.
	 * 
	 * @param newMarkers
	 */
	private void storeNewMarkers(final List<Marker> newMarkers) {
		int index;
		// now compare the newmarkers with what is already there
		for (final Marker newMarker : newMarkers) {

			// TODO Our function should filter null values??
			if (newMarker == null) {
				continue;
			}

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
	}

	/**
	 * 
	 * Get the target {@link NetXResource}, narrow it down by period.
	 * 
	 * @param expressionResult
	 * @param start
	 * @param end
	 * @return
	 */
	private List<Value> valuesForExpressionResult(
			ExpressionResult expressionResult, DateTimeRange period) {

		NetXResource resource = (NetXResource) expressionResult
				.getTargetResource();

		List<Value> usageValues = null;

		MetricValueRange targetMVR = StudioUtils.valueRangeForIntervalAndKind(
				resource, expressionResult.getTargetKindHint(),
				expressionResult.getTargetIntervalHint());
		if (targetMVR != null) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_TOL_OPTION,
						" using expression MVR for processing tolerance...");
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_TOL_OPTION,
						" kind: "
								+ targetMVR.getKindHint().getLiteral()
								+ " interval: "
								+ NonModelUtils.fromMinutes(targetMVR
										.getIntervalHint()));
			}
		} else {
			if (resource.getMetricValueRanges().size() > 0) {

				targetMVR = resource.getMetricValueRanges().get(0); // Default
																	// is the
																	// first
																	// range.

				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_TOL_OPTION,
						" using default MVR for processing tolerance");
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_TOL_OPTION,
						" kind: "
								+ targetMVR.getKindHint().getLiteral()
								+ " interval: "
								+ NonModelUtils.fromMinutes(targetMVR
										.getIntervalHint()));
			}
		}

		if (targetMVR == null) {
			return null;

		} else {
			// Prefetch all Value objects for this range.
			targetMVR.cdoPrefetch(CDORevision.DEPTH_INFINITE);
		}

		if (USE_QUERIES) {
			usageValues = CDOQueryService.mvrValues(targetMVR.cdoView(),
					targetMVR, CDOQueryUtil.QUERY_MYSQL, period);

		} else {
			throw new UnsupportedOperationException(
					"Alternative to use Queries for data retrieval not supported here");

		}
		return usageValues;
	}

	/**
	 * Maintains the state of the tolerance for a given value. It is either over
	 * or under the given value (of type double). </p> The state consists of:
	 * <ul>
	 * <li>stateDouble => The state value to which values to be checked are
	 * compared</li>
	 * <li>isOver => We are over or under the state double value</li>
	 * <li>startMarkerGenerated => A start marker has been generated</li>
	 * </ul>
	 * 
	 * For convenience a
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class ToleranceState {

		// We are over the state value.
		boolean isOver = false;

		// A start marker has been created already (
		// ToleranceMarkerDirectionKind.START)
		boolean startMarkerGenerated = false;

		// The given state value to which we compare.
		private Double stateDouble = new Double(-1);

		// An evaluator for the state.
		private DirectionEvaluator directionEvaluator = new DirectionEvaluator();

		// state for the current tolerance value.
		// private Value currentToleranceValue = null;

		// The start of the period which we should evaluate.
		// private Date start;

		// The end of the period which we should evaluate.
		// private Date end;

		/** The period for which we should evaluate */
		private DateTimeRange period;

		ToleranceState(DateTimeRange period) {
			// this.start = start;
			// this.end = end;
			this.period = period;
		}

		/**
		 * Process an {@link ExpressionResult}, the result is a set of Tolerance
		 * markers.
		 * 
		 * @param checkValues
		 * @return
		 */
		List<Marker> process(ExpressionResult expressionResult) {

			final List<Marker> newMarkers = new ArrayList<Marker>();

			List<Value> usageValues = valuesForExpressionResult(
					expressionResult, period);

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_TOL_OPTION,
						"Metrics values size=" + usageValues.size());
			}

			if (usageValues.isEmpty()) {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE
							.trace(DataActivator.TRACE_RESULT_TOL_OPTION,
									"Aborting tolerance, no metric values to evaluate [1]");
					DataActivator.TRACE
							.trace(DataActivator.TRACE_RESULT_TOL_OPTION,
									"[1] The target MVR is derived from the expression: TOLERANCE [Interval] [Kind] => Becomes MVR with Interval & Kind");

				}
				return newMarkers;
			}

			// Get the tolerance computation.
			final List<Value> toleranceValues = StudioUtils
					.sortValuesByTimeStamp(expressionResult.getTargetValues());

			long toTime = -1;
			long fromTime = -1;

			out: // A label to continue the loop when a non-equal tol state
					// values occurs.
			for (int i = 0; i < toleranceValues.size(); i++) {
				Value v = toleranceValues.get(i);

				// Update the current state as a double value, continue the loop
				// if there are more tolerance values.

				if (fromTime == -1) {
					fromTime = v.getTimeStamp().toGregorianCalendar()
							.getTimeInMillis();
				}

				double newTolValue = v.getValue();
				if (stateDouble == -1) {
					stateDouble = newTolValue;
				}

				if (newTolValue == stateDouble) {
					if (i != toleranceValues.size() - 1) {
						continue out;
					}
				}

				toTime = toleranceValues.get(i).getTimeStamp()
						.toGregorianCalendar().getTimeInMillis();

				// Wrap to end of day.
				Date d = new Date(toTime);
				NonModelUtils.adjustToDayEnd(d);
				toTime = d.getTime();

				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_RESULT_TOL_OPTION, "tolerance="
									+ v.getValue());
					DataActivator.TRACE.trace(
							DataActivator.TRACE_RESULT_TOL_OPTION, "from: "
									+ new Date(fromTime) + " to: "
									+ new Date(toTime));
				}

				// values within period of tolerance hops.
				final List<Value> checkValues = StudioUtils.valuesInsideRange(
						usageValues, fromTime, toTime);

				// If we have values to check, we want to make sure we don't
				// recreate markers for the same period.,
				// so the current tolerance. . The toTime will
				// be updated to the new ToleranceValue in the next iteration.
				if (checkValues.size() > 0) {

					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_RESULT_TOL_OPTION,
								"	checkvalues within tolerance hop="
										+ checkValues.size());

					}

					Iterable<ToleranceMarker> markers = processCheckValues(
							checkValues, expressionResult.getTargetResource()
									.getLongName());

					List<ToleranceMarker> markersForThisPeriod = Lists
							.newArrayList(markers);

					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_RESULT_TOL_OPTION,
								"# markers created ="
										+ markersForThisPeriod.size());
					}

					newMarkers.addAll(markersForThisPeriod);

					// Set the current tolerance value, to the from time.
					// currentToleranceValue = toleranceValue;
					fromTime = toTime;

				} else {
					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_RESULT_TOL_OPTION,
								":-( no values to check for this period ");
					}
				}
			}

			return newMarkers;

		}

		Iterable<ToleranceMarker> processCheckValues(List<Value> checkValues,
				String description) {

			Iterable<ToleranceMarker> transform = Iterables.transform(
					checkValues, new MarkerForDirection(description));

			// Should filter null values...
			transform = Iterables.filter(transform,
					new Predicate<ToleranceMarker>() {
						public boolean apply(ToleranceMarker input) {
							return input != null;
						}

					});

			return transform;
		}

		/**
		 * A given value is processed according to the Tolerance state. The
		 * following rules applies.
		 * <ul>
		 * <li>If checkValue is less than the state and we don't have a start
		 * marker and the tolerance level is YELLOW, the direction will be DOWN.
		 * The state changes to over.</li>
		 * <li>If checkValue is less than the state and we are over , the
		 * direction will be DOWN</li>
		 * <li>If checkValue is more than the state and we are NOT over, the
		 * direction will be UP</li>
		 * </ul>
		 * 
		 * @author Christophe
		 */
		class DirectionEvaluator implements
				Function<Value, ToleranceMarkerDirectionKind> {

			public ToleranceMarkerDirectionKind apply(Value checkValue) {
				ToleranceMarkerDirectionKind direction = null;
				double checkDouble = checkValue.getValue();

				// Generate a start marker only if the the level type is YELLOW,
				// if not specified, this would not be relevant.
				// It means the markers will only be complete, if all tolerance
				// levels are
				// specified.

				if (getTolerance().getLevel() == LevelKind.YELLOW
						&& checkDouble < stateDouble && !startMarkerGenerated) {
					// generate a start marker
					isOver = false;
					direction = ToleranceMarkerDirectionKind.DOWN;
				} else if (checkDouble < stateDouble && isOver) {
					isOver = false;
					direction = ToleranceMarkerDirectionKind.DOWN;
				} else if (checkDouble > stateDouble && !isOver) {
					// generate a marker
					isOver = true;
					direction = ToleranceMarkerDirectionKind.UP;
				}
				return direction;
			}
		}

		/**
		 * For a given value and description, a ToleranceMarker is produced.
		 * 
		 * @param checkValue
		 * @param direction
		 */
		class MarkerForDirection implements Function<Value, ToleranceMarker> {

			// A description for the marker.
			private String description;

			MarkerForDirection(String description) {
				this.description = description;
			}

			public ToleranceMarker apply(Value checkValue) {

				ToleranceMarkerDirectionKind direction = directionEvaluator
						.apply(checkValue);

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

					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_RESULT_TOL_OPTION,
								"adding marker"
										+ checkValue.getValue()
										+ " , "
										+ NonModelUtils.dateAndTime(checkValue
												.getTimeStamp()));
					}
					return marker;
				}

				startMarkerGenerated = true;
				return null;
			}
		}

	}

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

	public boolean ready() {
		return tolerance != null && resourceMonitor != null;
	}

}