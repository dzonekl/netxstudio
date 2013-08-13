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

import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.CDOAdapter;
import org.eclipse.emf.cdo.CDODeltaNotification;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.common.context.IComputationContext;
import com.netxforge.netxstudio.common.internal.CommonActivator;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.services.RFSService;

/**
 * An adapter for monitoring. It holds the Red Amber Green status for a given
 * period, for the implementor. The status is computed from a given context.
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class MonitoringAdapter extends CDOLazyMonitoringAdapter
		implements CDOAdapter, IMonitoringSummary {

	protected ModelUtils modelUtils;

	protected MonitoringStateModel stateModel;

	private AdapterFactory adapterFactory;

	private ComputationContextProvider contextProvider = new ComputationContextProvider();

	/**
	 * Parameter to control if a a global period should be used for monitoring,
	 * when the context period is not set.
	 */
	private static final boolean PARAMETER_USE_GLOBAL_PERIOD = true;

	private static final DateTimeRange PARAMETER_GLOBAL_PERIOD = GenericsFactory.eINSTANCE
			.createDateTimeRange();

	/**
	 * The RAG for this summary. Extending classes can create their own instance
	 * of aggregation of RAG in a hierarchy.
	 */
	Rag summaryRag = new Rag();

	protected class Rag {
		/** the RAG status **/
		int[] ragCount = new int[] { 0, 0, 0 };

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

		// RAG
		/**
		 * When recomputing the RAG, it's a good idea to call this.
		 */
		protected void cleanRag() {
			setRag(new int[] { 0, 0, 0 });
		}

		protected void setRag(int[] newRag) {
			ragCount = newRag;
		}

		protected void setRag(RAG rag, int ragValue) {
			ragCount[rag.ordinal()] = ragValue;
		}

		/**
		 * Increment our model Red Amber Green count with with the given RAG
		 * count.
		 * 
		 * @param ragForMarkers
		 */
		protected void incrementRag(int[] ragForMarkers) {
			ragCount[RAG.RED.ordinal()] += ragForMarkers[RAG.RED.ordinal()];
			ragCount[RAG.AMBER.ordinal()] += ragForMarkers[RAG.AMBER.ordinal()];
			ragCount[RAG.GREEN.ordinal()] += ragForMarkers[RAG.GREEN.ordinal()];
		}

	}

	public boolean getRedStatus() {
		return summaryRag.rag(RAG.RED);
	}

	public boolean getAmberStatus() {
		return summaryRag.rag(RAG.AMBER);
	}

	public boolean getGreenStatus() {
		return summaryRag.rag(RAG.GREEN);
	}

	protected void incrementRag(int[] ragForMarkers) {
		summaryRag.incrementRag(ragForMarkers);
	}

	protected void cleanRag() {
		summaryRag.cleanRag();
	}

	protected void setRag(int[] newRag) {
		summaryRag.setRag(newRag);
	}

	protected void setRag(RAG rag, int ragValue) {
		summaryRag.setRag(rag, ragValue);
	}

	public int totalRag(RAG status) {
		return summaryRag.ragCount[status.ordinal()];
	}

	public int[] rag() {
		return summaryRag.rag();
	}

	public MonitoringAdapter() {
		// Assert.isNotNull(modelUtils, "binding failed");
		// Assert.isNotNull(stateModel, "binding failed");

	}

	// MODEL

	@Override
	protected boolean isRelated(CDOObject object) {
		return isContained(object);
	}

	@Override
	protected boolean isSameAdapterFor(EObject object) {
		return false;
	}

	public void setModelUtils(ModelUtils utils) {
		this.modelUtils = utils;

		// We need {@link ModelUtils} before we can set the global period.

		Date beginTime = modelUtils.threeMonthsAgo();
		beginTime = modelUtils.adjustToDayStart(beginTime);
		PARAMETER_GLOBAL_PERIOD.setBegin(modelUtils.toXMLDate(beginTime));

		Date endTime = modelUtils.todayAtDayEnd();
		PARAMETER_GLOBAL_PERIOD.setEnd(modelUtils.toXMLDate(endTime));
	}

	public void setStatModel(MonitoringStateModel stateModel) {
		this.stateModel = stateModel;
	}

	// public void setComputationContextProvider(
	// MonitoringComputationContext contextProvider) {
	// this.contextProvider = contextProvider;
	// }

	public String getPeriodFormattedString() {

		return getPeriod() != null ? modelUtils.periodToStringMore(this
				.getPeriod()) : "Not set";
	}

	// COMPUTATION

	public void compute(IProgressMonitor monitor) {
		computeForTarget(monitor);
	}

	protected void computeForTarget() {
		computeForTarget(null);
	}

	protected abstract void computeForTarget(IProgressMonitor monitor);

	public boolean isComputed() {
		return contextProvider.periodInContext() != null
				&& this.getTarget() != null;
	}

	// ADAPTATION.

	// NOTIFICATION FOR AUTO RECOMPUTATION.

	/**
	 * Get the monitoring period context. </p> When the
	 * {@link #PARAMETER_USE_GLOBAL_PERIOD} is <code>true</code> (Default) we
	 * return the default period as specified in
	 * {@link #PARAMETER_GLOBAL_PERIOD} (Default 3 months from today). </p>
	 */
	public DateTimeRange getPeriod() {
		DateTimeRange periodInContext = contextProvider.periodInContext();
		if ((periodInContext == null || modelUtils.periodUnset(periodInContext))
				&& PARAMETER_USE_GLOBAL_PERIOD) {
			periodInContext = PARAMETER_GLOBAL_PERIOD;
		}
		return periodInContext;
	}

	public RFSService getRFSService() {
		return contextProvider.rfsServiceInContext();
	}

	@Override
	public void notifyChanged(Notification msg) {
		// Update ourselves with the notification.
		super.notifyChanged(msg);
		if (CommonActivator.DEBUG) {
			CommonActivator.TRACE.trace(
					CommonActivator.TRACE_COMMON_MONITORING_OPTION,
					"Notified by: " + msg.getNotifier());
			if (msg instanceof CDODeltaNotification) {
				CDODeltaNotification delta = (CDODeltaNotification) msg;

				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_MONITORING_OPTION,
						"delta: " + delta.getRevisionDelta());
			}
		}
	}

	// TEST THIS ADAPTER.
	@Override
	public boolean isAdapterForType(Object type) {
		return type == IMonitoringSummary.class;
	}

	@Override
	protected AdapterFactory getAdapterFactory() {
		return adapterFactory;
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

	public void setSelfAdaptFactory(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	@Override
	public String toString() {

		final StringBuffer sb = new StringBuffer();

		sb.append("Target: "
				+ modelUtils.printModelObject((EObject) getTarget()) + "\n");
		sb.append("Period: "
				+ (contextProvider.periodInContext() != null ? getPeriodFormattedString()
						: " Not set\n"));
		sb.append("Service: "
				+ (contextProvider.rfsServiceInContext() != null ? modelUtils
						.printModelObject(contextProvider.rfsServiceInContext())
						: " Not set\n"));
		sb.append("RAG: (" + totalRag(RAG.RED) + "," + totalRag(RAG.AMBER)
				+ "," + totalRag(RAG.GREEN) + ")");
		return sb.toString();
	}

	// Delegators

	public void addContextObject(IComputationContext object) {
		contextProvider.addContextObject(object);
	}

	public void addContextObjects(IComputationContext... objects) {
		contextProvider.addContextObjects(objects);
	}

	public void clearContextObject() {
		contextProvider.clearContextObject();
	}

	public IComputationContext[] getContextObjects() {
		return contextProvider.getContextObjects();
	}

	public List<IComputationContext> getContextObjectsAsList() {
		return contextProvider.getContextObjectsAsList();
	}

}
