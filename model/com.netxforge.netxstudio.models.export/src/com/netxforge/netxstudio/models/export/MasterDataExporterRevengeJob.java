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
package com.netxforge.netxstudio.models.export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.IProgressConstants;

import com.netxforge.base.cdo.ICDOData;

/**
 * Background exporter.
 * 
 * @author Christophe Bouhier
 * 
 */
public class MasterDataExporterRevengeJob extends JobChangeAdapter {
	private IPath res;
	private ExportJob j = new ExportJob("Exporting Data");

	private ICDOData dataProvider;
	private EPackage[] ePackages;

	public MasterDataExporterRevengeJob(ICDOData dataProvider,
			EPackage[] ePackages) {
		this.dataProvider = dataProvider;
		this.ePackages = ePackages;
	}

	private List<EObject> results;
	private IExportFilter exportFilter;

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

	public void setIPathToProcess(IPath resourcePath) {
		this.res = resourcePath;
	}

	protected class ExportJob extends Job {

		public ExportJob(String name) {
			super(name);
			super.setUser(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {

			processReadingInternal(monitor);
			// setProperty(IProgressConstants.ICON_PROPERTY, getImage());
			if (isModal(this)) {
				// The progress dialog is still open so
				// just open the message
				showResults();
			} else {
				setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
				setProperty(IProgressConstants.ACTION_PROPERTY,
						getExportCompletedAction());
			}
			return Status.OK_STATUS;
		}

		private Object getExportCompletedAction() {
			return null;
		}

		public boolean isModal(Job job) {
			Boolean isModal = (Boolean) job
					.getProperty(IProgressConstants.PROPERTY_IN_DIALOG);
			if (isModal == null)
				return false;
			return isModal.booleanValue();
		}

	}

	protected void showResults() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getExportCompletedAction().run();
			}
		});
	}

	protected Action getExportCompletedAction() {
		return new Action("Export completed") {
			public void run() {
				MessageDialog.openInformation(Display.getDefault()
						.getActiveShell(), "Export completed",
						"The export of data completed.");
			}
		};
	}

	protected void processReadingInternal(final IProgressMonitor monitor) {

		// The monitor totalwork is actually the number of objects to output.
		// The number of objects is determined when building the cache.

		if (dataProvider == null || this.ePackages == null) {
			throw new java.lang.IllegalStateException(
					"Missing settings for Data import");
		}

		try {
			final URI uri = URI.createFileURI(res.toString());
			final FileOutputStream fileOut = new FileOutputStream(
					uri.toFileString());
			final MasterDataExporterRevenge_sxssf masterDataExporter = new MasterDataExporterRevenge_sxssf();
			masterDataExporter.setDataProvider(dataProvider);
			masterDataExporter.setPackagesToExport(ePackages);
			masterDataExporter.setExportFilter(exportFilter);
			masterDataExporter.process(fileOut, monitor);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void setExportFilter(IExportFilter exportFilter) {
		this.exportFilter = exportFilter;
	}

}
