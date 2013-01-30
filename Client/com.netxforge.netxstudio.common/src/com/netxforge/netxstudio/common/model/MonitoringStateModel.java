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

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;

import com.google.inject.Inject;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.services.RFSService;

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
 * computed for a period. The markers which occure within the period a
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
			job = new MonitoringStateJob(modelUtils);
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

}
