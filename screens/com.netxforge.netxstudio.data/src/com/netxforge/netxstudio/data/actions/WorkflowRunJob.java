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
package com.netxforge.netxstudio.data.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;

import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;

public class WorkflowRunJob implements IJobChangeListener {

	private WorkflowJob j = new WorkflowJob("Server job...");
	private WorkFlowRun wfr;

	public void go() {
		j.addJobChangeListener(this);
		j.schedule();
	}

	public void addNotifier(IJobChangeListener notifier) {
		j.addJobChangeListener(notifier);
	}

	public void setWorkFlowRun(WorkFlowRun wfr) {
		this.wfr = wfr;
	}

	protected class WorkflowJob extends Job {

		public WorkflowJob(String name) {
			super(name);
			super.setUser(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {

			String lastTask = null;
			// Unfortunately the total work is not stored in the wfr.
			monitor.beginTask("Workflow job", 100);
			while (wfr.getState() == JobRunState.RUNNING) {
				if(monitor.isCanceled()){
					return Status.CANCEL_STATUS;
				}
				
				// count stuff for sometime.
//				int i = 0;
//				while (i < 200) {
//					i++;
//				}

				int progress = wfr.getProgress();
				monitor.worked(progress);
				lastTask = wfr.getProgressTask();
				if(lastTask != null){
					monitor.subTask(lastTask + ":" + wfr.getProgressMessage());
				}
			}
			monitor.done();
			
			// Stop the job, when not running.
			return Status.OK_STATUS;
		}
	}

	public void aboutToRun(IJobChangeEvent event) {
		System.out
				.println("Job about to get busy: " + event.getJob().getName()); //$NON-NLS-1$
	}

	public void awake(IJobChangeEvent event) {
	}

	public void done(IJobChangeEvent event) {
		System.out.println("Job done: " + event.getJob().getName()); //$NON-NLS-1$
	}

	public void running(IJobChangeEvent event) {
		System.out.println("Job running: " + event.getJob().getName()); //$NON-NLS-1$
	}

	public void scheduled(IJobChangeEvent event) {
		System.out.println("Job scheduled: " + event.getJob().getName()); //$NON-NLS-1$
	}

	public void sleeping(IJobChangeEvent event) {
		System.out.println("Job zzzzzz: " + event.getJob().getName()); //$NON-NLS-1$
	}
}
