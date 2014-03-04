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
package com.netxforge.netxstudio.models.importer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import com.netxforge.base.cdo.ICDOData;

/**
 * Processes an .csv file, and returns as records for a viewer.
 */
public class MasterDataImporterJob implements IJobChangeListener {
	private IPath res;
	private ScanningJob j = new ScanningJob("Reading file...");

	private ICDOData dataProvider;
	private EPackage[] ePackages;
	
	public MasterDataImporterJob(ICDOData dataProvider, EPackage[] ePackages) {
		this.dataProvider = dataProvider;
		this.ePackages = ePackages;
	}
	
	
	private List<EObject> results;
	
	
	private boolean indexed;
	
	
	/** The index producted for this import */
	private Map<String, EObject> runIndex;
	
	
	public Map<String, EObject> getRunIndex() {
		return runIndex;
	}

	public List<EObject> getResults() {
		return results;
	}

	public void setResults(List<EObject> results) {
		this.results = results;
	}

	public void go() {
		j.addJobChangeListener(this);
		j.schedule(1000);
	}

	public void addNotifier(IJobChangeListener notifier) {
		j.addJobChangeListener(notifier);
	}

	public void setIPathToProcess(IPath res) {
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
		
		if(dataProvider == null || this.ePackages == null){
			throw new java.lang.IllegalStateException("Missing settings for Data import");
		}
		
		InputStream is;
		try {
			URI uri = URI.createFileURI(res.toString());
			is = new FileInputStream(uri.toFileString());
			final MasterDataImporter_xssf masterDataImporter = new MasterDataImporter_xssf();
			masterDataImporter.setDataProvider(dataProvider);
			masterDataImporter
					.setEPackagesToImport(this.ePackages);
			masterDataImporter.setIndexSupport(indexed);
			masterDataImporter.process(is);
			setResults(masterDataImporter.getResolvedObjects());
			setRunIndex(masterDataImporter.getRunIndex());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void setRunIndex(Map<String, EObject> runIndex) {
		this.runIndex = runIndex;
		
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

	public void setIndexed(boolean useIndexed) {
		this.indexed = useIndexed;
	}

}
