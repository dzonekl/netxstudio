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
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.common.internal.CommonActivator;

/**
 * Populate a summary based on a context.
 */
public class MonitoringStateJob extends JobChangeAdapter {

	private StatusJob j = new StatusJob("Creating Summary...");

	/** Our context which will determine which Summary is returned. */
	private Object target;

	/** the produced summary for this job. */
	private IMonitoringSummary summary;

	private ModelUtils modelUtils;

	private boolean running = false;

	private MonitoringStateModel model;

	private Object[] contextObjects;

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

	protected class StatusJob extends Job {

		public StatusJob(String name) {
			super(name);
			super.setUser(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {

			processReadingInternal(monitor);
			return Status.OK_STATUS;
		}
	}

	protected void processReadingInternal(final IProgressMonitor monitor) {
		if (CommonActivator.DEBUG) {
			CommonActivator.TRACE.trace(
					CommonActivator.TRACE_COMMON_MONITORING_OPTION,
					" creating summary for:"
							+ modelUtils.printModelObject((EObject) target));
		}
		summary = model.summary(monitor, target, contextObjects);
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

	public void setContextObjects(Object... contextObjects) {
		this.contextObjects = contextObjects;
	}

	public void setTarget(Object context) {
		this.target = context;
	}

}
