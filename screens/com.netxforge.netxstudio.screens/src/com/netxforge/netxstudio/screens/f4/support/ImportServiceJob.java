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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;

import com.netxforge.netxstudio.data.importer.AbstractMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.CSVMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.DefaultImporterHelper;
import com.netxforge.netxstudio.data.importer.RDBMSMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.XLSMetricValuesImporter;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Executes the import. 
 */
public class ImportServiceJob implements IJobChangeListener {

	private ScanningJob j =  new ScanningJob("Importing...");
	private MetricSource ms;

	public void go() {
		j.addJobChangeListener(this);
		j.schedule(1000);
	}
	
	public void addNotifier(IJobChangeListener notifier){
		j.addJobChangeListener(notifier);
	}
	
	
	public void setDetailsToProcess(MetricSource ms) {
		this.setMetricSource(ms);
	}

	protected class ScanningJob extends Job {

		public ScanningJob(String name) {
			super(name);
			super.setUser(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			return processReadingInternal(monitor);
		}
	}

	protected IStatus processReadingInternal(final IProgressMonitor monitor) {

		// Note, this is the current state, any in between update will not be
		// noticed.
		try {
			
			// read a new metricsource so that it is part of this
			// transaction/session
			final MetricSource metricSource = getMetricSource();
			final AbstractMetricValuesImporter metricsImporter;
			if (metricSource.getMetricMapping() instanceof MappingXLS) {
				metricsImporter = ScreensActivator.getInstance().getInjector().getInstance(XLSMetricValuesImporter.class);
			} else if (metricSource.getMetricMapping() instanceof MappingCSV) {
				metricsImporter =  ScreensActivator.getInstance().getInjector().getInstance(CSVMetricValuesImporter.class);
			} else if (metricSource.getMetricMapping() instanceof MappingRDBMS) {
				metricsImporter =  ScreensActivator.getInstance().getInjector().getInstance(RDBMSMetricValuesImporter.class);
			} else {
				throw new IllegalArgumentException("Mapping type not supported: " + metricSource.getMetricMapping());
			}
			
			DefaultImporterHelper importerHelper = new DefaultImporterHelper();
			importerHelper.setImporter(metricsImporter);
			metricsImporter.setImportHelper(importerHelper);
			metricsImporter.setMetricSourceWithId(metricSource.cdoID());
			
			
			// TODO, A Server side monitor stores state, log and progress in an object. 
			// For server side, we can simply update a Platform Monitor. 
			
			metricsImporter.setJobMonitor(getRunMonitor());
			metricsImporter.process();
			
			return Status.OK_STATUS;
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(IStatus.ERROR, ScreensActivator.PLUGIN_ID, e.getMessage(), e);
		}

	}

	private IRunMonitor getRunMonitor() {
		// TODO Auto-generated method stub
		return null;
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

	public MetricSource getMetricSource() {
		return ms;
	}

	public void setMetricSource(MetricSource ms) {
		this.ms = ms;
	}
}
