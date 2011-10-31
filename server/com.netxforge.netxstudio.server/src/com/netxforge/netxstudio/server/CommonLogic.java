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
package com.netxforge.netxstudio.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
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
 * Implements common logic used by several other plugins.
 * 
 * @author Martin Taal
 */
public class CommonLogic {

	@Inject
	private ModelUtils modelUtils;

	// on purpose not injected
	private IDataProvider dataProvider;

	private ResourceMonitor resourceMonitor;
	private Tolerance tolerance;
	private Date start;
	private Date end;

	public void processServiceProfileResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, Date start, Date end) {
		for (final BaseExpressionResult baseExpressionResult : expressionResults) {

			if (baseExpressionResult instanceof ExpressionResult) {
				ExpressionResult expressionResult = (ExpressionResult) baseExpressionResult;

				System.out.println("--Writing expression result: resource="
						+ expressionResult.getTargetResource().getShortName()
						+ " target="
						+ expressionResult.getTargetRange().getName()
						+ " values="
						+ expressionResult.getTargetValues().size());

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

		System.out.println("--Writing expression result: resource="
				+ expressionResult.getTargetResource().getShortName()
				+ " target=" + expressionResult.getTargetRange().getName()
				+ " values=" + expressionResult.getTargetValues().size());

		// FIXME: We could want to write to a resource, where the node
		// doesn't match the context.
		final BaseResource baseResource = expressionResult.getTargetResource();

		// Process a NetXResource
		if (baseResource instanceof NetXResource) {
			NetXResource resource = (NetXResource) baseResource;
			final Node n = this.getNode(resource.getComponentRef());
			if (n != null) {
				System.out.println("--Writing to resource in Node: "
						+ n.getNodeID());
				// for (final Object context : currentContext) {
				// IInterpreterContext c = (IInterpreterContext)context;
				// }
				// System.out.println("--Current context =: ");
			}

			switch (expressionResult.getTargetRange().getValue()) {
			case RangeKind.CAP_VALUE:
				removeValues(resource.getCapacityValues(), start, end);
				addToValues(resource.getCapacityValues(),
						expressionResult.getTargetValues(),
						expressionResult.getTargetIntervalHint());
				break;
			case RangeKind.METRIC_VALUE:
				addToValueRange(resource,
						expressionResult.getTargetIntervalHint(),
						expressionResult.getTargetKindHint(),
						getCreateValues(expressionResult, start, end), start,
						end);
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
						.valueRangeForIntervalAndKind(resource,
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
		System.out.println("--Done processing monitoring result");
	}

	private void createMarkers(ExpressionResult expressionResult, Date start,
			Date end) {

		NetXResource resource = (NetXResource) expressionResult
				.getTargetResource();

		// now compute the capacity in order
		final List<Value> usageValues = new ArrayList<Value>();

		for (final MetricValueRange mvr : resource.getMetricValueRanges()) {
			usageValues.addAll(mvr.getMetricValues());
		}

		// TODO, replace with ModelUtils function
		// modelUtils.filterValueInRange(unfiltered, this.ge)

		// get rid of everything before and after start time
		final List<Value> toRemoveUsageValues = new ArrayList<Value>();
		for (final Value usageValue : usageValues) {
			// System.err.println("CommonLogic" + usageValue.getTimeStamp());
			final long timeMillis = usageValue.getTimeStamp()
					.toGregorianCalendar().getTimeInMillis();
			if (timeMillis < start.getTime() || timeMillis > end.getTime()) {
				toRemoveUsageValues.add(usageValue);
			}
		}
		usageValues.removeAll(toRemoveUsageValues);
		Collections.sort(usageValues, new ValueTimeComparator());

		// now get the tolerance computation
		final List<Value> toleranceValues = expressionResult.getTargetValues();

		// Potential duplicates error.
		// java.lang.IllegalArgumentException: The 'no duplicates' constraint is
		// violated
		Collections.sort(toleranceValues, new ValueTimeComparator());

		// now walk through the lists and find the occurences of overrides
		Value currentTolerance = null;
		int index = 0;
		boolean isOver = false;
		boolean startMarkerGenerated = false;

		final List<Marker> newMarkers = new ArrayList<Marker>();
		for (final Value toleranceValue : toleranceValues) {
			long toTime = end.getTime();
			long fromTime = start.getTime();
			if (index < (toleranceValues.size() - 1)) {
				toTime = toleranceValues.get(index + 1).getTimeStamp()
						.toGregorianCalendar().getTimeInMillis();
			}
			if (currentTolerance == null) {
				currentTolerance = toleranceValue;
			} else {
				fromTime = currentTolerance.getTimeStamp()
						.toGregorianCalendar().getTimeInMillis();
			}
			final List<Value> checkValues = new ArrayList<Value>();
			for (final Value usageValue : usageValues) {
				final long time = usageValue.getTimeStamp()
						.toGregorianCalendar().getTimeInMillis();
				if (time >= fromTime && time <= toTime) {
					checkValues.add(usageValue);
				}
			}
			// check if they are over or under
			for (final Value checkValue : checkValues) {
				ToleranceMarkerDirectionKind direction = null;
				if (getTolerance().getLevel() == LevelKind.YELLOW
						&& checkValue.getValue() < currentTolerance.getValue()
						&& !startMarkerGenerated) {
					// generate a start marker
					isOver = false;
					direction = ToleranceMarkerDirectionKind.DOWN;
				} else if (checkValue.getValue() < currentTolerance.getValue()
						&& isOver) {
					isOver = false;
					direction = ToleranceMarkerDirectionKind.DOWN;
				} else if (checkValue.getValue() > currentTolerance.getValue()
						&& !isOver) {
					// generate a marker
					isOver = true;
					direction = ToleranceMarkerDirectionKind.UP;
				}
				if (direction != null) {
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
					newMarkers.add(marker);
				}
				startMarkerGenerated = true;
			}
			index++;
		}
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

	private List<Value> getCreateValues(ExpressionResult result, Date start,
			Date end) {
		final List<Value> values = new ArrayList<Value>();
		Date previousTime = start;
		Value previousValue = null;
		for (final Value resultValue : result.getTargetValues()) {
			long nextTime = previousTime.getTime()
					+ result.getTargetIntervalHint() * 60000;
			while (nextTime < resultValue.getTimeStamp().toGregorianCalendar()
					.getTimeInMillis()) {
				final Value newValue = GenericsFactory.eINSTANCE.createValue();
				newValue.setValue(previousValue.getValue());
				newValue.setTimeStamp(modelUtils.toXMLDate(new Date(nextTime)));
				nextTime += result.getTargetIntervalHint() * 60000;
				values.add(newValue);
			}
			values.add(resultValue);
			previousValue = resultValue;
			previousTime = resultValue.getTimeStamp().toGregorianCalendar()
					.getTime();
		}
		// generate values for the rest of the period
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
		return values;
	}

	public void addToValueRange(NetXResource foundNetXResource,
			int intervalHint, KindHintType kindHintType, List<Value> newValues,
			Date start, Date end) {

		// Default equals -1.
		if (intervalHint == -1) {

		}

		final MetricValueRange mvr = modelUtils.valueRangeForIntervalAndKind(
				foundNetXResource, kindHintType, intervalHint);

		if (DataActivator.DEBUG) {
			System.out
					.println("IMPORTER: Located/create value range for resource : "
							+ foundNetXResource.getShortName()
							+ " range size = " + mvr.getMetricValues().size());
		}

		if (start != null) {
			if (DataActivator.DEBUG) {
				System.out.println("IMPORTER: removing values from start="
						+ modelUtils.dateAndTime(start) + " , end="
						+ modelUtils.dateAndTime(end));
			}
			removeValues(mvr.getMetricValues(), start, end);
		}
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
				System.out
						.println("IMPORTER: found similar value while storing value="
								+ foundValue.getValue()
								+ " , timestamp="
								+ modelUtils.dateAndTime(foundValue
										.getTimeStamp()) );
			}
			foundValue.setValue(value.getValue());
		} else {
			if (DataActivator.DEBUG) {
				System.out
						.println("IMPORTER:no similar value, store now value="
								+ value.getValue()
								+ " , timestamp="
								+ modelUtils.dateAndTime(value
										.getTimeStamp()) );
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
		return diff < (intervalHint * 60 * 1000 - 1);
	}

	public Node getNode(EObject eObject) {
		if (eObject == null) {
			throw new IllegalStateException("No node found");
		}
		if (eObject.eContainer() instanceof Node) {
			return (Node) eObject.eContainer();
		}
		return getNode(eObject.eContainer());
	}

	private class ValueTimeComparator implements Comparator<Value> {

		public int compare(Value arg0, Value arg1) {
			return arg0.getTimeStamp().compare(arg1.getTimeStamp());
		}
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
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

}