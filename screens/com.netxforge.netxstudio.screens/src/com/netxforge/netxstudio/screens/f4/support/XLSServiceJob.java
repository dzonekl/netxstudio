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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;

import com.netxforge.base.Tuple;

/**
 * Processes an .xls file, and returns as records for a viewer.
 */
public class XLSServiceJob extends JobChangeAdapter {

//	public static final XLSServiceJob INSTANCE = new XLSServiceJob();
	private IFile res;
	private List<List<Map<Integer, Tuple>>> records;
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
		XLSService s = new XLSService();
		FileInputStream fis;
		try {
			fis = new FileInputStream(res.getLocation().toFile());
			int result = s.go(monitor, fis);
			if (result != XLSService.OK) {
				// Something went wrong.
			} else {
				setRecords(s.getRecords());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

	public List<List<Map<Integer, Tuple>>> getRecords() {
		return records;
	}

	public void setRecords(List<List<Map<Integer, Tuple>>> records) {
		this.records = records;
	}

}
