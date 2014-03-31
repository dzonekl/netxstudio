/*******************************************************************************
 * Copyright (c) 31 jan. 2013 NetXForge.
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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Lists;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind;
import com.netxforge.netxstudio.services.RFSService;

/**
 * An adapted NetXResource, adds computed information to the resource.
 * 
 * @author Christophe Bouhier
 */
public class MVRSummary extends MonitoringAdapter {

	public MVRSummary() {
	}

	/** Our tolerance markers **/
	private List<Marker> toleranceMarkers = Lists.newArrayList();

	@Override
	protected synchronized void computeForTarget(IProgressMonitor monitor) {

		clearComputation();

		// Set the context objects.
		final RFSService rfsServiceInContext = getRFSService();
		if (rfsServiceInContext == null) {
			// COMPUTATION STATE => NOT-COMPUTED
			return;
		}

		final DateTimeRange periodInContext = getPeriod();
		if (periodInContext == null) {
			// COMPUTATION STATE => NOT-COMPUTED
			return;
		}

		// Safely case, checked by our factory.
		final MetricValueRange target = getTarget();

		// We retrieve markers for a resource instead of a range.
		// this is wrong, the model should point to a range, not a resource.
		// All markers will be returned here.
		EObject eContainer = target.eContainer();
		if (eContainer instanceof NetXResource) {

			NetXResource resource = (NetXResource) eContainer;

			final List<Marker> unfilteredToleranceMarkers = MonitoringStateModel
					.toleranceMarkersForServiceMonitorsAndResource(
							rfsServiceInContext.getServiceMonitors(), resource,
							monitor);

			// Filter the markers, always go back to the start marker.
			toleranceMarkers.clear();
			toleranceMarkers.addAll(StudioUtils.markersInsidePeriod(
					unfilteredToleranceMarkers, periodInContext));

			// As the period is adjusted to the start of the month, we should
			// have a
			// start marker for monitored
			// resources.
			if (!toleranceMarkers.isEmpty()) {
				Marker marker = toleranceMarkers.get(0);
				if (marker instanceof ToleranceMarker) {
					ToleranceMarkerDirectionKind direction = ((ToleranceMarker) marker)
							.getDirection();
					if (direction == ToleranceMarkerDirectionKind.START) {
						System.out
								.println("GOOD: start marker found when evaluating resource: "
										+ StudioUtils.printModelObject(this
												.getTarget()));
						// this is our desired situation.
					} else {
						System.out
								.println("ERROR: The first marker when evaluating resource: "
										+ StudioUtils.printModelObject(this
												.getTarget())
										+ " should be a start marker (Which it's not)");
						System.out
								.println("ERROR: The corresponding timestamp for the fist marker is: "
										+ NonModelUtils.date(NonModelUtils
												.fromXMLDate(marker
														.getValueRef()
														.getTimeStamp())));
					}
				}

				// Monitoring is not on or yields no markers when no markers are
				// returned.
				// We can't really determine the computation state, so we assume
				// the
				// computation is valid.

				// Base RAG computation on the tolerance markers.
				this.setRag(MonitoringStateModel
						.ragForMarkers(toleranceMarkers));
			}

			// COMPUTATION STATE => COMPUTED
			computationState = ComputationState.COMPUTED;

		}
		monitor.worked(1);
	}

	public MetricValueRange getTarget() {
		return (MetricValueRange) super.getTarget();
	}

	@Override
	protected boolean isSameAdapterFor(EObject object) {
		// We need notifications for MVR'.
		return object.eClass() == MetricsPackage.Literals.METRIC_VALUE_RANGE;
	}

	@Override
	protected boolean isNotFiltered(EObject object) {
		// Only for MVR child objects.
		return object.eClass() == MetricsPackage.Literals.METRIC_VALUE_RANGE;
	}

	/**
	 * Return the markers for this resource, in the last computation from a
	 * context {@link RFSService}.
	 * 
	 * @param perio
	 * @return
	 */
	public List<Marker> markers() {
		return toleranceMarkers;
	}

}
