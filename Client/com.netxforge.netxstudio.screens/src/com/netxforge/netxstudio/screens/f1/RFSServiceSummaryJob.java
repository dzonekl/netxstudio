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
package com.netxforge.netxstudio.screens.f1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.RFSServiceSummary;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServiceMonitor;

/**
 * Create a service summary, which is a long running thingy
 */
public class RFSServiceSummaryJob implements IJobChangeListener {

	private StatusJob j = new StatusJob("Creating Summary...");
	private RFSService service;
	private RFSServiceSummary summary;
	private ModelUtils modelUtils;
	private boolean running = false;

	private IProgressMonitor monitor;

	public RFSServiceSummaryJob(ModelUtils modelUtils) {
		super();
		this.modelUtils = modelUtils;
	}

	public void go() {
		j.addJobChangeListener(this);
		j.schedule(100);
	}

	public void addNotifier(IJobChangeListener notifier) {
		j.addJobChangeListener(notifier);
	}

	public void setRFSServiceToProcess(RFSService service) {
		this.service = service;
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
		this.monitor = monitor;
		ServiceMonitor sm = modelUtils.lastServiceMonitor(service);
		if (sm != null) {
			summary = modelUtils.serviceSummaryForService(
					service, sm.getPeriod(), monitor);
		}
	}

	public void cancelMonitor() {
		this.monitor.setCanceled(true);
	}

	public void aboutToRun(IJobChangeEvent event) {
	}

	public void awake(IJobChangeEvent event) {

	}

	public void done(IJobChangeEvent event) {
		running = false;
	}

	public void running(IJobChangeEvent event) {
		this.running = true;
	}

	public void scheduled(IJobChangeEvent event) {
	}

	public void sleeping(IJobChangeEvent event) {
	}

	/**
	 * @return the summary
	 */
	public RFSServiceSummary getSummary() {
		return summary;
	}

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @param running
	 *            the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
}
