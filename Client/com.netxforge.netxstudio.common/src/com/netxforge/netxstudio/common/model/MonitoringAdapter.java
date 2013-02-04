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
import org.eclipse.emf.cdo.CDOAdapter;
import org.eclipse.emf.cdo.CDODeltaNotification;
import org.eclipse.emf.cdo.util.CDOLazyContentAdapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.services.RFSService;

/**
 * An adapter for monitoring. It holds the Red Amber Green status for a given
 * period, for the implementor. The status is computed from a given context.
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class MonitoringAdapter extends CDOLazyContentAdapter implements
		CDOAdapter, IMonitoringSummary {

	protected ModelUtils modelUtils;

	protected MonitoringStateModel stateModel;

	/** the RAG status **/
	int[] ragCount = new int[] { 0, 0, 0 };

	/** Our collection of context objects needed for computation **/
	protected final List<Object> context = Lists.newArrayList();

	/** A potential list of children, for a summary to aggregate upon **/
	protected final List<IMonitoringSummary> childMonitors = Lists
			.newArrayList();

	public MonitoringAdapter() {
		// Assert.isNotNull(modelUtils, "binding failed");
		// Assert.isNotNull(stateModel, "binding failed");

	}

	// MODEL

	public void setModelUtils(ModelUtils utils) {
		this.modelUtils = utils;

	}

	public void setStatModel(MonitoringStateModel stateModel) {
		this.stateModel = stateModel;
	}

	// IS THE PERIOD INFO RELEVANT, WE COMPUTE DYNAMICLY.

	/** The period for this summary */
	private DateTimeRange period;

	/** The period formated as String for this summary */
	private String periodFormattedString = "";

	public DateTimeRange getPeriod() {
		return period;
	}

	public void setPeriod(DateTimeRange period) {
		this.period = period;
		periodFormattedString = modelUtils.periodToStringMore(period);
	}

	public String getPeriodFormattedString() {
		return periodFormattedString;
	}

	// COMPUTATION

	public void compute(IProgressMonitor monitor) {
		computeForTarget(monitor);
	}

	protected void computeForTarget() {
		computeForTarget(null);
	}

	protected abstract void computeForTarget(IProgressMonitor monitor);

	public void addContextObject(Object object) {
		// Generic support for context objects.
		if (object != null && !context.contains(object)) {
			context.add(object);
		}
	}

	public boolean isComputed() {
		return this.getPeriod() != null && this.getTarget() != null;
	}

	/**
	 * G Get the {@link RFSService Resource Facing Service } setting from the
	 * computation context.
	 * 
	 * @return the period or <code>null</code> if none specified.
	 */
	protected RFSService rfsServiceInContext() {
		final Iterable<Object> filter = Iterables.filter(context,
				new Predicate<Object>() {
					public boolean apply(Object o) {
						return o instanceof RFSService;
					}
				});
		if (Iterables.size(filter) == 1) {
			return (RFSService) filter.iterator().next();
		}
		return null;

	}

	public void addContextObjects(Object... objects) {
		for (Object o : objects) {
			this.addContextObject(o);
		}
	}

	public Object[] getContextObjects() {
		return this.context.toArray();
	}

	/**
	 * Get the {@link DateTimeRange period} setting from the computation
	 * context.
	 * 
	 * @return the period or <code>null</code> if none specified.
	 */
	protected DateTimeRange periodInContext() {
		final Iterable<Object> filter = Iterables.filter(context,
				new Predicate<Object>() {
					public boolean apply(Object o) {
						return o instanceof DateTimeRange;
					}
				});
		if (Iterables.size(filter) == 1) {
			return (DateTimeRange) filter.iterator().next();
		}
		return null;
	}

	// ADAPTATION.

	// NOTIFICATION FOR AUTO RECOMPUTATION.

	@Override
	public void notifyChanged(Notification msg) {
		// Update ourselves with the notification.
		// super.notifyChanged(msg);
		System.out.println("We are adapted!" + this.toString() + " by: "
				+ msg.getNotifier());

		if (msg instanceof CDODeltaNotification) {
			CDODeltaNotification delta = (CDODeltaNotification) msg;
			System.out.println("delta: " + delta.getRevisionDelta());
		}
	}

	// TEST THIS ADAPTER.
	@Override
	public boolean isAdapterForType(Object type) {
		return type == IMonitoringSummary.class;
	}

	// RAG

	/**
	 * Increment our model Red Amber Green count with with the given RAG count.
	 * 
	 * @param ragForMarkers
	 */
	protected void incrementRag(int[] ragForMarkers) {
		ragCount[RAG.RED.ordinal()] += ragForMarkers[RAG.RED.ordinal()];
		ragCount[RAG.AMBER.ordinal()] += ragForMarkers[RAG.AMBER.ordinal()];
		ragCount[RAG.GREEN.ordinal()] += ragForMarkers[RAG.GREEN.ordinal()];
	}

	/**
	 * get the Red Amber Green count for this summary.
	 */
	public int[] rag() {
		return ragCount;
	}

	public boolean rag(RAG status) {
		int i = ragCount[status.ordinal()];
		return i >= 1;
	}
	
	public boolean getRedStatus() {
		return rag(RAG.RED);
	}

	public boolean getAmberStatus() {
		return rag(RAG.AMBER);
	}

	public boolean getGreenStatus() {
		return rag(RAG.GREEN);
	}

	public int totalRag(RAG status) {
		return ragCount[status.ordinal()];
	}

	/**
	 * Return a potential {@link IMonitoringSummary } for the adapted child of a
	 * target.
	 * 
	 * @param child
	 * @return
	 */
	public IMonitoringSummary getChildAdapter(EObject child) {
		for (Adapter adapter : child.eAdapters()) {
			if (adapter instanceof IMonitoringSummary) {
				return (IMonitoringSummary) adapter;
			}
		}
		return null;
	}

}
