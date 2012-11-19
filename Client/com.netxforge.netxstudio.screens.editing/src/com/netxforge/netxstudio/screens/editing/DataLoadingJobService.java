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
package com.netxforge.netxstudio.screens.editing;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;

import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;

/**
 * A service for loading data in a job. 
 * Should it be a factory? Is it a one of throw-away service? 
 * 
 * 
 * @author Christophe
 *
 */
public class DataLoadingJobService  {

	private DataLoadingJob j = new DataLoadingJob("Loading...");
	
	private IScreen screenToLoad;
	

	public IScreen getScreenToLoad() {
		return screenToLoad;
	}

	public void setScreenToLoad(IScreen screenToLoad) {
		this.screenToLoad = screenToLoad;
	}

	public void go() {
//		j.addJobChangeListener(this);
		j.schedule();
	}

	public void addNotifier(IJobChangeListener notifier) {
		j.addJobChangeListener(notifier);
	}

	protected class DataLoadingJob extends Job {

		public DataLoadingJob(String name) {
			super(name);
			super.setUser(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			
			
			// Total time, could depend on the number of objects. 
			// Getting the size of the objects to fetch
			monitor.beginTask("Loading data ", 100);
			
			// Need additional support for 
			if(screenToLoad instanceof IDataServiceInjection){
				((IDataServiceInjection) screenToLoad).injectData();
			}
			
			monitor.done();
			
			// Stop the job, when not running.
			return Status.OK_STATUS;
		}
	}

//	public void aboutToRun(IJobChangeEvent event) {
//		System.out
//				.println("Job about to get busy: " + event.getJob().getName()); //$NON-NLS-1$
//	}
//
//	public void awake(IJobChangeEvent event) {
//	}
//
//	public void done(IJobChangeEvent event) {
//		System.out.println("Job done: " + event.getJob().getName()); //$NON-NLS-1$
//	}
//
//	public void running(IJobChangeEvent event) {
//		System.out.println("Job running: " + event.getJob().getName()); //$NON-NLS-1$
//	}
//
//	public void scheduled(IJobChangeEvent event) {
//		System.out.println("Job scheduled: " + event.getJob().getName()); //$NON-NLS-1$
//	}
//
//	public void sleeping(IJobChangeEvent event) {
//		System.out.println("Job zzzzzz: " + event.getJob().getName()); //$NON-NLS-1$
//	}
}
