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
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.CDOAdapter;
import org.eclipse.emf.cdo.CDODeltaNotification;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.base.NonModelUtils;
import com.netxforge.base.context.IComputationContext;
import com.netxforge.netxstudio.common.internal.CommonActivator;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * An adapter for monitoring. It holds the Red Amber Green status for a given
 * period, for the implementor. The status is computed from a given context.
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class MonitoringAdapter extends AdapterImpl implements
		CDOAdapter, IMonitoringSummary {

	protected MonitoringStateModel stateModel;

	private ComputationContextProvider contextProvider = new ComputationContextProvider();

	/**
	 * Parameter to control if a a global period should be used for monitoring,
	 * when the context period is not set.
	 */
	private static final boolean PARAMETER_USE_GLOBAL_PERIOD = true;

	private static DateTimeRange PARAMETER_GLOBAL_PERIOD = GenericsFactory.eINSTANCE
			.createDateTimeRange();

	static {
		// We need {@link ModelUtils} before we can set the global period.

		Date beginTime = NonModelUtils.threeMonthsAgo();
		beginTime = NonModelUtils.adjustToDayStart(beginTime);
		PARAMETER_GLOBAL_PERIOD.setBegin(NonModelUtils.toXMLDate(beginTime));

		Date endTime = NonModelUtils.todayAtDayEnd();
		PARAMETER_GLOBAL_PERIOD.setEnd(NonModelUtils.toXMLDate(endTime));
	}

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

		/**
		 * Increment our model Red Amber Green count with with the given
		 * {@link Rag}.
		 * 
		 * @param ragForMarkers
		 */
		protected void incrementRag(Rag anotherRag) {
			incrementRag(anotherRag.rag());
		}
	}

	/**
	 * The computation state model.
	 */
	protected enum ComputationState {
		COMPUTED, NOT_COMPUTED
	};

	/**
	 * The default state is {@link ComputationState}
	 */
	protected ComputationState computationState = ComputationState.NOT_COMPUTED;

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

	public void clearComputation() {
		computationState = ComputationState.NOT_COMPUTED;
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

	// MODEL for CDOLazyContentProvider

	// These methods were previously required for self-adaptation,
	// the lazy content provider attaches itself as an object listener and
	// ataches itself. This proved complex, with a deep level of self-calling
	// resulting
	// in stack overflows. For example the 'related' check would sometime check
	// the containment
	// hierarchy , implicitly loading objects, triggering the self-adaptation
	// again and again.
	// We keep the methods here, as the clients of this class
	protected boolean isRelated(CDOObject object) {
		return false;
	}

	protected boolean isSameAdapterFor(EObject object) {
		return false;
	}

	protected boolean isNotFiltered(EObject object) {
		return false;
	}

	protected boolean isContained(EObject object) {
		return false;
	}

	public void setStatModel(MonitoringStateModel stateModel) {
		this.stateModel = stateModel;
	}

	// public void setComputationContextProvider(
	// MonitoringComputationContext contextProvider) {
	// this.contextProvider = contextProvider;
	// }

	public String getPeriodFormattedString() {

		return getPeriod() != null ? StudioUtils.periodToStringMore(this
				.getPeriod()) + isComputedText() : "Not set";
	}

	// COMPUTATION

	private String isComputedText() {
		return isComputed() ? " (C)" : " (NC)";
	}

	public void compute(IProgressMonitor monitor) {
		computeForTarget(monitor);
	}

	protected void computeForTarget() {
		computeForTarget(null);
	}

	protected abstract void computeForTarget(IProgressMonitor monitor);

	public boolean isComputed() {
		return computationState == ComputationState.COMPUTED;
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
		if ((periodInContext == null || StudioUtils
				.periodUnset(periodInContext)) && PARAMETER_USE_GLOBAL_PERIOD) {
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

	/**
	 * Return a potential {@link IMonitoringSummary } for the adapted child of a
	 * target.
	 * 
	 * @param child
	 * @return
	 */
	public static IMonitoringSummary getAdapter(EObject child) {
		for (Adapter adapter : child.eAdapters()) {
			if (adapter instanceof IMonitoringSummary) {
				return (IMonitoringSummary) adapter;
			}
		}
		return null;
	}

	public static IMonitoringSummary adaptAndCompute(IProgressMonitor monitor,
			EObject eo, IComputationContext... contextObjects) {

		if (!MonitoringStateModel.isAdapted(eo)) {
			MonitoringStateModel.adapt(eo, IMonitoringSummary.class);
		}

		// Check our own adaptation state.
		IMonitoringSummary monitoringSummary = getAdapter(eo);
		if (monitoringSummary != null) {
			monitoringSummary.clearContextObjects();
			monitoringSummary.addContextObjects(contextObjects);
			if (monitor instanceof SubMonitor) {
				SubMonitor newChild = ((SubMonitor) monitor).newChild(1);
				monitoringSummary.compute(newChild);
				return monitoringSummary;
			} else {
				System.out.println(" error with monitor: ");
				Thread.dumpStack();
			}

		}
		return null;
	}

	@Override
	public String toString() {

		final StringBuffer sb = new StringBuffer();

		sb.append("Target: "
				+ StudioUtils.printModelObject((EObject) getTarget()) + "\n");
		sb.append("Period: "
				+ (contextProvider.periodInContext() != null ? getPeriodFormattedString()
						: " Not set\n"));
		sb.append("Service: "
				+ (contextProvider.rfsServiceInContext() != null ? StudioUtils
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

	public void clearContextObjects() {
		contextProvider.clearContextObjects();
	}

	public IComputationContext[] getContextObjects() {
		return contextProvider.getContextObjects();
	}

	public List<IComputationContext> getContextObjectsAsList() {
		return contextProvider.getContextObjectsAsList();
	}

	/**
	 * @param s
	 */
	protected void replaceContextEntry(Service s) {
		contextProvider.replaceContextObject(s);
	}

}
