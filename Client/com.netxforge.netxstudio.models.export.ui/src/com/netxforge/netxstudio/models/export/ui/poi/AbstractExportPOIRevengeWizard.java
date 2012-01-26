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
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.models.export.IExportFilter;
import com.netxforge.netxstudio.models.export.MasterDataExporterRevengeJob;
import com.netxforge.netxstudio.models.export.ui.pages.ExportNewFileWizardPage;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public abstract class AbstractExportPOIRevengeWizard extends Wizard implements
		IImportWizard {

	private IStructuredSelection selection;

	public AbstractExportPOIRevengeWizard() {
	}

	@Inject
	protected IDataProvider dataProvider;

	private ExportNewFileWizardPage exportNewFilePage;

	abstract EPackage[] getEPackages();
	
	abstract IExportFilter getExportFilter();
	
	@Override
	public boolean performFinish() {

		final IPath outFilePath = exportNewFilePage.getFilePath();
		
		IFile createFileHandle = WorkspaceUtil.INSTANCE.createFileHandle(outFilePath);
		if(!createFileHandle.exists()){
			try {
				createFileHandle.create(null, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			
		}

		final MasterDataExporterRevengeJob job = new MasterDataExporterRevengeJob(
				dataProvider, getEPackages());
		
//		job.setTargetObjects(this.getTargetObjects());
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

	@Override
	public void addPages() {

		// The extension will be set by other wizard pages depending on the wizard flow. 
		exportNewFilePage = new ExportNewFileWizardPage("Export Object to XLS",
				selection, "*"); //$NON-NLS-1$
		exportNewFilePage.setTitle("Export Object to XLS");
		exportNewFilePage.setDescription("Export Object to XLS");
		exportNewFilePage.setContainerFullPath(WorkspaceUtil.INSTANCE
				.getExportsPath());
		addPage(exportNewFilePage);
		
	}

}
