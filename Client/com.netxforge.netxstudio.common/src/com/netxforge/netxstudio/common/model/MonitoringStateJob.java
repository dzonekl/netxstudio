/*******************************************************************************
 * Copyright (c) Jun 26, 2011 NetXForge.
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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceMonitor;

/**
 * Populate a summary based on a context.
 */
public class MonitoringStateJob extends JobChangeAdapter {

	private StatusJob j = new StatusJob("Creating Summary...");

	/** Our context which will determine which Summary is returned. */
	private Object context;

	/** the produced summary for this job. */
	private IMonitoringSummary summary;

	/** The period determining the summary extend */
	private DateTimeRange period;

	private ModelUtils modelUtils;

	private boolean running = false;

	private IProgressMonitor monitor;

	private MonitoringStateModel model;

	public DateTimeRange getPeriod() {
		return period;
	}

	public void setPeriod(DateTimeRange period) {
		this.period = period;
	}

	public MonitoringStateJob(ModelUtils modelUtils, MonitoringStateModel model) {
		super();
		this.modelUtils = modelUtils;
		this.model = model;
	}

	public void go() {
		j.addJobChangeListener(this);
		j.schedule(100);
	}

	public void cancel() {
		j.cancel();
	}

	public void addNotifier(IJobChangeListener notifier) {
		j.addJobChangeListener(notifier);
	}

	public void setContextToSummarize(Object context) {
		this.context = context;
	}

	protected class StatusJob extends Job {

		public StatusJob(String name) {
			super(name);
			super.setUser(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {

			// Do we have a period.
			if (period != null) {
				// Check the period validity?
				// Begin < End.
			} else {
				// We need a period for the state to work.
				return Status.CANCEL_STATUS;
			}
			processReadingInternal(monitor);
			return Status.OK_STATUS;
		}
	}

	protected void processReadingInternal(final IProgressMonitor monitor) {
		this.monitor = monitor;

		// Dispatch on the context type.
		if (context instanceof Operator) {
			// TODO Create an Operator Summary.
		} else if (context instanceof RFSService) {
			summary = null;

			ServiceMonitor sm = modelUtils
					.lastServiceMonitor((Service) context);
			if (sm != null) {
				summary = model.summaryForService((Service) context,
						period, monitor);
			}
		} else if (context instanceof Node) {
			// TODO Create a Node summary.
		} else if (context instanceof Component) {
			// TODO Create a Component summary.
		} else if (context instanceof NetXResource) {
			// TODO Create a resource summary.
		}

	}

	public void cancelMonitor() {
		this.monitor.setCanceled(true);
	}

	public void done(IJobChangeEvent event) {
		running = false;
	}

	public void running(IJobChangeEvent event) {
		this.running = true;
	}

	/**
	 * @return the summary
	 */
	public IMonitoringSummary getMonitoringSummary() {
		return summary;
	}

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}
	
}
