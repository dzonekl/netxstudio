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
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.services.RFSService;

/**
 * An adapted NetXResource, adds computed information to the resource.
 * 
 * @author Christophe Bouhier
 */
public class NetxresourceSummary extends MonitoringAdapter {

	public NetxresourceSummary() {
	}

	/** Our tolerance markers **/
	private List<Marker> toleranceMarkers = Lists.newArrayList();

	/** count for our {@link NetXResource#getMetricValueRanges()} **/
	private int mvrs;

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
		final NetXResource target = getTarget();

		// The count of computed MVR's. (Typically one Tolerance expression will
		// compute one MVR).
		int computedMVRs = 0;

		if (!target.getMetricValueRanges().isEmpty()) {

			final SubMonitor childMonitor = SubMonitor.convert(monitor, target
					.getMetricValueRanges().size());

			childMonitor.setTaskName("Computing summary for "
					+ StudioUtils.printModelObject(target));

			for (MetricValueRange mvr : target.getMetricValueRanges()) {

				mvrs++;

				if (monitor != null && monitor.isCanceled()) {
					System.out.println("Computation cancelled...");
					break;
				}
				IMonitoringSummary childAdapter = adaptAndCompute(childMonitor,
						mvr, this.getContextObjects());
				// Guard for potentially non-adapted children.
				if (childAdapter != null) {
					if (childAdapter.isComputed()) {
						computedMVRs++;
						// Base our RAG status, on the child's status
						this.incrementRag(childAdapter.rag());
					}
				} else {
					System.out.println("SHOULD NOT OCCUR: child not adapted! "
							+ StudioUtils.printModelObject(mvr));
				}
				childMonitor.worked(1);
			}
		}

		if (computedMVRs == target.getMetricValueRanges().size()) {
			computationState = ComputationState.COMPUTED;
		}

	}

	public NetXResource getTarget() {
		return (NetXResource) super.getTarget();
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

/**
	 * Get the count for {@link NetXResource#getMetricValueRanges() 
	 * 
	 * @return
	 */
	public int getMvrs() {
		return mvrs;
	}

}
