/*******************************************************************************
 * Copyright (c) 18 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.models.export.ui.poi;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.data.cdo.IClientDataProvider;
import com.netxforge.netxstudio.models.export.IExportFilter;
import com.netxforge.netxstudio.models.export.MasterDataExporterRevengeJob;
import com.netxforge.netxstudio.models.export.ui.pages.ExportNewFileWizardPage;
import com.netxforge.netxstudio.screens.ide.WorkspaceUtil;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class AbstractExportPOIRevengeWizard extends Wizard implements
		IImportWizard {

	private IStructuredSelection selection;

	@Inject
	protected IClientDataProvider dataProvider;

	private ExportNewFileWizardPage exportNewFilePage;

	/** Our base file name for the export */
	private String baseFileName = null;

	abstract EPackage[] getEPackages();

	abstract IExportFilter getExportFilter();

	@Override
	public boolean performFinish() {

		final IPath outFilePath = exportNewFilePage.getFilePath();

		IFile createFileHandle = WorkspaceUtil.INSTANCE
				.createFileHandle(outFilePath);
		if (!createFileHandle.exists()) {
			try {
				createFileHandle.create(null, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}

		}

		final MasterDataExporterRevengeJob job = new MasterDataExporterRevengeJob(
				dataProvider.get(), getEPackages());

		job.setExportFilter(this.getExportFilter());
		job.addNotifier(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				super.done(event);
			}
		});
		job.setIPathToProcess(createFileHandle.getLocation());
		job.go(); // Should spawn a job processing the import file.
		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("Export");
		//		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/wizban/ExportDBWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	public void setBaseFileName(String baseFileName) {
		this.baseFileName = baseFileName;

	}

	@Override
	public void addPages() {

		// The extension will be set by other wizard pages depending on the
		// wizard flow.
		exportNewFilePage = new ExportNewFileWizardPage("Export Object to XLS",
				selection, "*"); //$NON-NLS-1$
		exportNewFilePage.setTitle("Export Object to XLS");
		exportNewFilePage.setDescription("Export Object to XLS");
		//

		if (this.baseFileName != null) {
			exportNewFilePage.setFileName(baseFileName
					+ NonModelUtils.folderDateAndTime(NonModelUtils
							.todayAndNow()) + ".xlsx");
		}
		exportNewFilePage.setContainerFullPath(WorkspaceUtil.INSTANCE
				.getExportsPath());
		addPage(exportNewFilePage);

	}

}
