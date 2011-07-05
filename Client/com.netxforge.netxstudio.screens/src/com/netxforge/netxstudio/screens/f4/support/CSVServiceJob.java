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
package com.netxforge.netxstudio.screens.f4.support;

import java.io.FileReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;

/**
 * Processes an .csv file, and returns as records for a viewer.
 */
public class CSVServiceJob implements IJobChangeListener {

//	public static final XLSServiceJob INSTANCE = new XLSServiceJob();
	private IFile res;
	private String[][] records;
	private ScanningJob j =  new ScanningJob("Reading file...");

	public void go() {
		j.addJobChangeListener(this);
		j.schedule(1000);
	}
	
	public void addNotifier(IJobChangeListener notifier){
		j.addJobChangeListener(notifier);
	}
	
	
	public void setResourceToProcess(IFile res) {
		this.res = res;
	}

	protected class ScanningJob extends Job {

		public ScanningJob(String name) {
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

		// Note, this is the current state, any in between update will not be
		// noticed.
		CSVService s = new CSVService();
		FileReader fr;
		try {
			fr = new FileReader(res.getLocation().toFile());
			int result = s.go(monitor, fr);
			if (result != CSVService.OK) {
				// Something went wrong.
			} else {
				setRecords(s.getRecords());
			}

		} catch (Exception e) {
			e.printStackTrace();
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

	public String[][] getRecords() {
		return records;
	}

	public void setRecords(String[][] records) {
		this.records = records;
	}

}
