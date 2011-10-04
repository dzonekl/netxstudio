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
package com.netxforge.netxstudio.screens.xtext.embedded;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.StringInputStream;


/**
 * Processes an .xls file, and returns as records for a viewer.
 */
public class ExpressionLoadingJob implements IJobChangeListener {
	
	private LoadingJob j =  new LoadingJob("Reading expression ...");
	private EmbeddedXtextResource res;
	private EObject asStringEObject;
	private String asString;
	
	
	public ExpressionLoadingJob() {
		super();
	}

	public void go() {
		j.addJobChangeListener(this);
		j.schedule(1000);
	}
	
	public void addNotifier(IJobChangeListener notifier){
		j.addJobChangeListener(notifier);
	}
	
	
	public void setParameters(EmbeddedXtextResource res, String asString) {
		this.res = res;
		this.asString = asString;
	}
	
	public String getAsString(){
		return this.asString;
	}

	
	public EObject getAsStringObject(){
		return this.asStringEObject;
	}
	
	public EmbeddedXtextResource getXtextResource() {
		return res;
	}
	
	protected class LoadingJob extends Job {

		public LoadingJob(String name) {
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
		try {
			res.load(new StringInputStream(asString),
					Collections.emptyMap());
			if (!res.getContents().isEmpty()) {
				asStringEObject = res.getContents().get(0);
			}
		} catch (IOException e) {
			// ignore, will set the string to the serialization of the given
			// eObject
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
