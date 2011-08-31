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
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.RangeKind;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.MarkerKind;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind;

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

	public void processResult(List<Object> currentContext,
			List<ExpressionResult> expressionResults, Date start, Date end) {

		for (final ExpressionResult expressionResult : expressionResults) {
			System.out.println("--Writing expression result: resource="
					+ expressionResult.getTargetResource().getShortName()
					+ " target=" + expressionResult.getTargetRange().getName()
					+ " values=" + expressionResult.getTargetValues().size());

			// FIXME: We could want to write to a resource, where the node
			// doesn't match the context.
			final NetXResource resource = expressionResult.getTargetResource();
			final Node n = this.getNode(resource);
			if (n != null) {
				System.out.println("--Writing to resource in Node: "
						+ n.getNodeID());
				for (final Object context : currentContext) {
					// IInterpreterContext c = (IInterpreterContext)context;
				}
				System.out.println("--Current context =: ");
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
				final MetricValueRange mvr = getValueRange(resource,
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
	}

	private void createMarkers(ExpressionResult expressionResult, Date start,
			Date end) {

		// now compute the capacity in order
		final List<Value> usageValues = new ArrayList<Value>();
		for (final MetricValueRange mvr : expressionResult.getTargetResource()
				.getMetricValueRanges()) {
			usageValues.addAll(mvr.getMetricValues());
		}
		// get rid of everything before and after start time
		final List<Value> toRemoveUsageValues = new ArrayList<Value>();
		for (final Value usageValue : usageValues) {
			System.err.println(usageValue.getTimeStamp());
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
					marker.setComponentRef((Component) expressionResult
							.getTargetResource().eContainer());
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

	public void addToValueRange(NetXResource foundNetXResource, int periodHint,
			KindHintType kindHintType, List<Value> newValues, Date start,
			Date end) {
		final MetricValueRange mvr = getValueRange(foundNetXResource,
				kindHintType, periodHint);
		if (start != null) {
			removeValues(mvr.getMetricValues(), start, end);
		}
		addToValues(mvr.getMetricValues(), newValues, periodHint);
	}

	public void addToValues(EList<Value> values, List<Value> newValues,
			int periodHint) {
		for (final Value newValue : new ArrayList<Value>(newValues)) {
			addToValues(values, newValue, periodHint);
		}
	}

	private MetricValueRange getValueRange(NetXResource foundNetXResource,
			KindHintType kindHintType, int periodHint) {
		MetricValueRange foundMvr = null;
		for (final MetricValueRange mvr : foundNetXResource
				.getMetricValueRanges()) {
			if (mvr.getKindHint() == kindHintType
					&& mvr.getIntervalHint() == periodHint) {
				foundMvr = mvr;
				break;
			}
		}
		if (foundMvr == null) {
			foundMvr = MetricsFactory.eINSTANCE.createMetricValueRange();
			foundMvr.setKindHint(kindHintType);
			foundMvr.setIntervalHint(periodHint);
			foundNetXResource.getMetricValueRanges().add(foundMvr);
		}
		return foundMvr;
	}

	public void addToValues(EList<Value> values, Value value, int periodHint) {

		final long timeInMillis = value.getTimeStamp().toGregorianCalendar()
				.getTimeInMillis();
		Value foundValue = null;
		for (final Value lookValue : values) {
			if (isSameTime(periodHint, timeInMillis, lookValue.getTimeStamp())) {
				foundValue = lookValue;
				break;
			}
		}
		if (foundValue != null) {
			foundValue.setValue(value.getValue());
		} else {
			values.add(value);
		}
	}

	private boolean isSameTime(int period, long time1,
			XMLGregorianCalendar time2) {
		long diff = time1 - time2.toGregorianCalendar().getTimeInMillis();
		if (diff < 0) {
			diff = diff * -1;
		}
		return diff < (period * 60 * 1000 - 1);
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