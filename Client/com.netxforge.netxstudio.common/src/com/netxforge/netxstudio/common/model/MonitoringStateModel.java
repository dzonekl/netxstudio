/*******************************************************************************
 * Copyright (c) 29 jan. 2013 NetXForge.
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceMonitor;

/**
 * Maintains a monitoring state and can be queried for state information. The
 * following state information can be retrieved; </p>
 * 
 * <ul>
 * <li>Tolerance breach markers</li>
 * <li>Red Amber Green state (RAG)</li>
 * <li>Artifact count which are monitored</li>
 * </ul>
 * 
 * depending on a context. The context can be broad, encompassing several
 * monitoring layers. </p> the following "layers" are defined: </p>
 * <ul>
 * <li>{@link Operator operator monitoring}</li>
 * <li>{@link RFSService service monitoring}</li>
 * <li>{@link Node node monitoring}</li>
 * <li>{@link Component Funtion or Equipment monitoring}</li>
 * <li>{@link NetXResource resource monitoring}</li>
 * </ul>
 * Ultimately, the state on all layers is computed from the markers on a
 * {@link NetXResorce resource}. Currently, the {@link ToleranceMarker tolerance
 * markers} are the base to determine the state of a resource. The state is also
 * computed for a period. The markers which occur within the period are
 * considered for the state.
 * 
 * 
 * Note: Various functions in {@link ModelUtils} exist to aggregate
 * 
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class MonitoringStateModel {

	/**
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public interface MonitoringStateStateCallBack {
		public void callBackEvent(MonitoringStateEvent event);
	}

	@Inject
	private ModelUtils modelUtils;

	private MonitoringStateJob job = null;

	private JobCallBack callBackHandler;

	public void summaryFor(Object context, MonitoringStateStateCallBack callBack) {
		prepSummary(context, callBack);
	}

	class JobCallBack extends JobChangeAdapter {

		private MonitoringStateStateCallBack callBack;

		public void setCallBack(MonitoringStateStateCallBack callBack) {
			this.callBack = callBack;
		}

		@Override
		public void done(IJobChangeEvent event) {
			if (callBack != null) {
				System.out.println("Invoking Callback hashcode: "
						+ callBack.hashCode());
				final MonitoringStateEvent monitoringStateEvent = new MonitoringStateEvent();
				monitoringStateEvent.setResult(job.getMonitoringSummary());
				callBack.callBackEvent(monitoringStateEvent);
			}
		}

	}

	/**
	 * prepares the monitoring state.
	 */
	private void prepSummary(Object context,
			final MonitoringStateStateCallBack callBack) {

		if (job == null) {
			job = new MonitoringStateJob(modelUtils, this);
			callBackHandler = new JobCallBack();
			job.addNotifier(callBackHandler);
		}
		// Make sure we set the correct callback, Don't use final arguments for
		// callback!!!!! It will cost you 2 more hours to debug :-)
		callBackHandler.setCallBack(callBack);

		// Force a restart, if we are operational.
		if (job.isRunning()) {
			// This will abrupt the job but on demand, so we can't really start
			// a new job here.
			job.cancelMonitor();
		}

		job.setContextToSummarize(context);
		job.go(); // Should spawn a job processing the xls.

	}

	// PROCESSING STATE:

	/**
	 * Is any of the background processing jobs running?
	 * 
	 * @return
	 */
	public boolean isRunning() {
		return job.isRunning();
	}

	/**
	 * Abort background processing jobs.
	 */
	public void abort() {
		if (job.isRunning()) {
			job.cancelMonitor();
		}
	}

	public RFSServiceSummary serviceSummaryForService(Service service,
			DateTimeRange dtr, IProgressMonitor monitor) {

		final RFSServiceSummary serviceSummary = new RFSServiceSummary(
				(RFSService) service);

		// Sort and reverse the Service Monitors.
		final List<ServiceMonitor> serviceMonitors = Ordering
				.from(modelUtils.serviceMonitorCompare()).reverse()
				.sortedCopy(service.getServiceMonitors());

		if (service instanceof RFSService) {
			int[] ragTotalResources = new int[] { 0, 0, 0 };
			int[] ragTotalNodes = new int[] { 0, 0, 0 };
			for (Node n : ((RFSService) service).getNodes()) {
				if (monitor != null && monitor.isCanceled()) {
					return serviceSummary;
				}

				final Map<NetXResource, List<Marker>> markersPerResource = toleranceMarkerMapPerResourceForServiceMonitorsAndNode(
						serviceMonitors, n, monitor);

				// Filter the markers within the period.

				int[] ragResources = ragCountResourcesForNode(
						markersPerResource, monitor);
				for (int i = 0; i < ragTotalResources.length; i++) {
					ragTotalResources[i] += ragResources[i];
				}
				// Any of the levels > 0, we increase the total node count.
				ragTotalNodes[0] += ragResources[0] > 0 ? 1 : 0;
				ragTotalNodes[1] += ragResources[1] > 0 ? 1 : 0;
				ragTotalNodes[2] += ragResources[2] > 0 ? 1 : 0;
			}
			serviceSummary.setRagCountResources(ragTotalResources);
			serviceSummary.setRagCountNodes(ragTotalNodes);
		}

		serviceSummary.setPeriod(dtr);
		serviceSummary.setPeriodFormattedString(modelUtils
				.periodToStringMore(dtr));

		return serviceSummary;
	}

	/**
	 * A two pass rag analyzer. First find all {@link ServiceMonitor}'s inside
	 * the specified period. For all contained {@link ResourceMonitor }'s in the
	 * Service Monitors, bundle the markers per NetXResource. Then count the RAG
	 * per NetXResource's markers. Note: Resources which are not referenced by a
	 * Resource Monitor from the specified node, are ignored.
	 * 
	 * @param markersPerResource
	 * 
	 * @param sm
	 * @param n
	 * @return
	 */
	public int[] ragCountResourcesForNode(
			Map<NetXResource, List<Marker>> markersPerResource,
			IProgressMonitor monitor) {

		int red = 0, amber = 0, green = 0;

		// Filter ServiceMonitors on the time range.
		// DO NOT FILTER here, filter the period later on the returned markers.

		// List<ServiceMonitor> filtered = this.filterSerciceMonitorInRange(
		// sortedCopy, dtr);

		for (NetXResource res : markersPerResource.keySet()) {

			if (monitor != null && monitor.isCanceled()) {
				return new int[] { red, amber, green };
			}
			List<Marker> markers = markersPerResource.get(res);
			int[] rag = ragForMarkers(markers);
			red += rag[0];
			amber += rag[1];
			green += rag[2];

		}

		return new int[] { red, amber, green };
	}

	public Map<NetXResource, List<Marker>> toleranceMarkerMapPerResourceForServiceMonitorAndNodeAndPeriod(
			ServiceMonitor serviceMonitor, Node n, DateTimeRange dtr,
			IProgressMonitor monitor) {

		// Filter ServiceMonitors on the time range.
		// List<ServiceMonitor> filtered = this.filterSerciceMonitorInRange(
		// sortedCopy, dtr);

		Map<NetXResource, List<Marker>> markersPerResource = toleranceMarkerMapPerResourceForServiceMonitorsAndNode(
				Arrays.asList(new ServiceMonitor[] { serviceMonitor }), n,
				monitor);
		return markersPerResource;
	}

	/**
	 * returns a Map of markers for each of the NetXResources in the specified
	 * node.
	 * 
	 * @param service
	 * @param n
	 * @param dtr
	 * @return
	 */
	public Map<NetXResource, List<Marker>> toleranceMarkerMapPerResourceForServiceAndNodeAndPeriod(
			Service service, Node n, DateTimeRange dtr, IProgressMonitor monitor) {

		// Sort by begin date and reverse the Service Monitors.
		List<ServiceMonitor> sortedCopy = Ordering
				.from(modelUtils.serviceMonitorCompare()).reverse()
				.sortedCopy(service.getServiceMonitors());

		// Filter ServiceMonitors on the time range.
		// List<ServiceMonitor> filtered = this.filterSerciceMonitorInRange(
		// sortedCopy, dtr);

		Map<NetXResource, List<Marker>> markersPerResource = toleranceMarkerMapPerResourceForServiceMonitorsAndNode(
				sortedCopy, n, monitor);
		return markersPerResource;

	}

	/**
	 * Provides a total list of markers for the Service Monitor, Node and Date
	 * Time Range. ,indiscreet of the NetXResource.
	 * 
	 * @param sm
	 * @param n
	 * @param dtr
	 * @return
	 */
	public List<Marker> toleranceMarkersForServiceMonitor(ServiceMonitor sm,
			Node n) {
		// Process a ServiceMonitor for which the period is somehow within the
		// range.
		List<Marker> filtered = Lists.newArrayList();

		// Each RM represents a Resource.
		for (ResourceMonitor rm : sm.getResourceMonitors()) {
			if (rm.getNodeRef().getNodeID().equals(n.getNodeID())) {
				List<Marker> toleranceMarkers = toleranceMarkersForResourceMonitor(rm);
				filtered.addAll(toleranceMarkers);
			}
		}

		return filtered;
	}

	// public int[] ragCount(ServiceMonitor sm, Node n,
	// DateTimeRange dtr) {
	//
	// int red = 0, amber = 0, green = 0;
	// //Each RM represents a Resource.
	// for (ResourceMonitor rm : sm.getResourceMonitors()) {
	// if (rm.getNodeRef().getNodeID().equals(n.getNodeID())) {
	// Marker[] markerArray = new Marker[rm.getMarkers().size()];
	// rm.getMarkers().toArray(markerArray);
	// List<Marker> markersForNodeList = this
	// .toleranceMarkers(markerArray);
	// int[] rag = this.ragForMarkers(markersForNodeList);
	// red += rag[0];
	// amber += rag[1];
	// green += rag[2];
	// }
	//
	// }
	//
	// return new int[]{red, amber, green};
	// }

	/**
	 * @param serviceMonitors
	 * @param n
	 * @return
	 */
	public Map<NetXResource, List<Marker>> toleranceMarkerMapPerResourceForServiceMonitorsAndNode(
			List<ServiceMonitor> serviceMonitors, Node n,
			IProgressMonitor monitor) {
		Map<NetXResource, List<Marker>> markersPerResource = Maps.newHashMap();

		for (ServiceMonitor sm : serviceMonitors) {
			for (ResourceMonitor rm : sm.getResourceMonitors()) {

				// Abort the task if we are cancelled.
				if (monitor != null && monitor.isCanceled()) {
					return markersPerResource;
				}

				if (rm.getNodeRef().getNodeID().equals(n.getNodeID())) {

					// Analyze per resource, why would a resource monitor
					// contain markers for a nother resource?
					List<Marker> markers;
					NetXResource res = rm.getResourceRef();
					if (!markersPerResource.containsKey(res)) {
						markers = Lists.newArrayList();
						markersPerResource.put(res, markers);
					} else {
						markers = markersPerResource.get(res);
					}
					List<Marker> toleranceMarkers = toleranceMarkersForResourceMonitor(rm);
					markers.addAll(toleranceMarkers);
				}
			}

		}
		return markersPerResource;
	}

	public List<Marker> toleranceMarkersForResourceMonitor(ResourceMonitor rm) {
		final List<Marker> toleranceMarkers = Lists.newArrayList(Iterables
				.filter(rm.getMarkers(), modelUtils.toleranceMarkers()));
		return toleranceMarkers;
	}

	/**
	 * For a collection of marker determine the rag status. Higher levels take
	 * precedence over lower levels. Lower levels are in case preceded by a
	 * Higher level, cleared.
	 * 
	 * @param markersForNodeList
	 * @return
	 */
	public int[] ragForMarkers(List<Marker> markersForNodeList) {

		int red = 0, amber = 0, green = 0;
		Marker[] markerForNodeArray = new Marker[markersForNodeList.size()];
		markersForNodeList.toArray(markerForNodeArray);
		// Iterate markers per level.
		for (LevelKind lk : LevelKind.VALUES) {

			ToleranceMarker tm = lastToleranceMarker(lk, markerForNodeArray);
			if (tm != null) {
				switch (tm.getLevel().getValue()) {
				case LevelKind.RED_VALUE: {
					if (isStartOrUp(tm)) {
						red++;
					}
				}
					break;
				case LevelKind.AMBER_VALUE: {
					if (isStartOrUp(tm)) {
						amber++;
					}
				}
					break;
				case LevelKind.GREEN_VALUE: {
					if (isStartOrUp(tm)) {
						green++;
					}
				}
				case LevelKind.YELLOW_VALUE: {
					// what to do with yellow??
				}
					break;
				}
			}
			// else {
			// green++;
			// }
		}

		// Clear the lower levels.
		if (red > 0) {
			amber = 0;
			green = 0;
		}
		if (amber > 0) {
			green = 0;
		}

		return new int[] { red, amber, green };
	}

	/**
	 * Return the last marker which is either START or UP. The lists is sorted
	 * and analyzed from the tail. (Newest first). Return null, if we can't find
	 * a marker matching the Level Kind.
	 * 
	 * @param lk
	 * @param markers
	 * @return
	 */
	public ToleranceMarker lastToleranceMarker(LevelKind lk, Marker... markers) {
		ToleranceMarker tm = null;
		List<Marker> markerList = Lists.newArrayList(markers);
		markerList = modelUtils.sortMarkersByTimeStamp(markerList);
		Collections.reverse(markerList);
		for (Marker m : markerList) {
			if (m instanceof ToleranceMarker
					&& ((ToleranceMarker) m).getLevel() == lk) {
				tm = (ToleranceMarker) m;
				break;
			}
		}
		return tm;
	}

	public boolean isStartOrUp(ToleranceMarker tm) {
		return tm.getDirection() == ToleranceMarkerDirectionKind.UP
				|| tm.getDirection() == ToleranceMarkerDirectionKind.START;
	}

	/**
	 * Overall RAG Status.
	 * 
	 * @param sm
	 * @return
	 * @deprecated DO NOT USE, no distinction per NetXResource.
	 */
	public int[] ragCountResources(ServiceMonitor sm) {

		int red = 0, amber = 0, green = 0;

		for (ResourceMonitor rm : sm.getResourceMonitors()) {
			int[] rag = ragForMarkers(rm.getMarkers());
			red += rag[0];
			amber += rag[1];
			green += rag[2];
		}
		return new int[] { red, amber, green };

	}

	public boolean ragShouldReport(int[] ragStatus) {
		if (ragStatus.length != 3) {
			return false;
		}

		if (ragStatus[0] > 0) {
			return true;
		}

		if (ragStatus[1] > 0) {
			return true;
		}

		return false;
	}
}
