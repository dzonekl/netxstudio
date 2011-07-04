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
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.RangeKind;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;

/**
 * Implements common logic used by several other plugins.
 * 
 * @author Martin Taal
 */
public class CommonLogic {

	@Inject
	private ModelUtils modelUtils;
	
	@Inject
	private IDataProvider dataProvider;
	
	public void processResult(List<ExpressionResult> expressionResults, Date start, Date end) {
		for (final ExpressionResult expressionResult : expressionResults) {
			final NetXResource resource = expressionResult.getTargetResource();
			switch (expressionResult.getTargetRange().getValue()) {
			case RangeKind.CAP_VALUE:
				addToValues(resource.getCapacityValues(), getCreateValues(expressionResult, start, end), expressionResult.getTargetIntervalHint());
				break;
			case RangeKind.METRIC_VALUE:
				addToValueRange(resource, expressionResult.getTargetIntervalHint(), null, getCreateValues(expressionResult, start, end));
				break;
			case RangeKind.TOLERANCE_VALUE:
				createMarkers(expressionResult, start, end);
				break;
			case RangeKind.UTILIZATION_VALUE:
				addToValues(resource.getUtilizationValues(), getCreateValues(expressionResult, start, end), expressionResult.getTargetIntervalHint());
				break;
			default:
				throw new IllegalStateException("Range kind " + expressionResult.getTargetRange() + " not supported");
			}
		}
	}

	private void createMarkers(ExpressionResult expressionResult, Date start, Date end) {
		final Node node = getNode(expressionResult.getTargetResource());
		final Resource emfResource = dataProvider.getResource(OperatorsPackage.eINSTANCE.getResourceMonitor());
		ResourceMonitor foundMonitor = null;
		for (final EObject monitorObject : emfResource.getContents()) {
			final ResourceMonitor monitor = (ResourceMonitor)monitorObject;
			if (monitor.getNodeRef() == node && monitor.getResourceRef() == expressionResult.getTargetResource()) {
				foundMonitor = monitor;
				break;
			}
		}
		if (foundMonitor == null) {
			foundMonitor = OperatorsFactory.eINSTANCE.createResourceMonitor();
			foundMonitor.setNodeRef(node);
			foundMonitor.setResourceRef(expressionResult.getTargetResource());
			emfResource.getContents().add(foundMonitor);
		}

		// remove the current markers
		final long startMillis = start.getTime();
		final long endMillis = end.getTime();
		final List<Marker> toRemove = new ArrayList<Marker>();
		for (final Marker marker : foundMonitor.getMarkers()) {
			final long markerMillis = marker.getValueRef().getTimeStamp().toGregorianCalendar().getTimeInMillis();
			if (markerMillis >= startMillis && markerMillis <= endMillis) {
				toRemove.add(marker);
			}
		}
		foundMonitor.getMarkers().removeAll(toRemove);
	}
	
	private List<Value> getCreateValues(ExpressionResult result, Date start, Date end) {
		final List<Value> values = new ArrayList<Value>();
		Date previousTime = start;
		Value previousValue = null;
		for (final Value resultValue : result.getTargetValues()) {
			long nextTime = previousTime.getTime() + result.getTargetIntervalHint() * 60000; 
			while (nextTime < resultValue.getTimeStamp().toGregorianCalendar().getTimeInMillis()) {
				final Value newValue = GenericsFactory.eINSTANCE.createValue();
				newValue.setValue(previousValue.getValue());
				newValue.setTimeStamp(modelUtils.toXMLDate(new Date(nextTime)));
				nextTime += result.getTargetIntervalHint() * 60000;
				values.add(newValue);
			}
			values.add(resultValue);
			previousValue = resultValue;
			previousTime = resultValue.getTimeStamp().toGregorianCalendar().getTime();
		}
		// generate values for the rest of the period
		if (previousTime.getTime() < (end.getTime() -  result.getTargetIntervalHint() * 60000)) {
			long nextTime = previousTime.getTime() + result.getTargetIntervalHint() * 60000; 
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
			int periodHint, KindHintType kindHintType, List<Value> newValues) {
		for (final Value newValue : newValues) {
			addToValueRange(foundNetXResource, periodHint, kindHintType, newValue);
		}
	}

	public void addToValueRange(NetXResource foundNetXResource,
			int periodHint, KindHintType kindHintType, Value value) {
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
		addToValues(foundMvr.getMetricValues(), value, periodHint);
	}

	public void addToValues(EList<Value> values, List<Value> newValues, int periodHint) {
		for (final Value newValue : newValues) {
			addToValues(values, newValue, periodHint);
		}
	}
	
	public void addToValues(EList<Value> values, Value value, int periodHint) {

		final long timeInMillis = value.getTimeStamp().toGregorianCalendar().getTimeInMillis();
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

}