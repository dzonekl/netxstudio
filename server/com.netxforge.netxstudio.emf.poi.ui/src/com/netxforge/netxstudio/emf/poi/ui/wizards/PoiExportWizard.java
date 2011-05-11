package com.netxforge.netxstudio.emf.poi.ui.wizards;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

import com.netxforge.netxstudio.emf.poi.PoiEmmitter;
import com.netxforge.netxstudio.emf.teneo.ModelUtil;
import com.netxforge.netxstudio.emf.teneo.TeneoService;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class PoiExportWizard extends Wizard implements IExportWizard {

	private IStructuredSelection selection;

	private PoiExportWizardPage poiExportFilePage;
	private PoiSelectWizardPage poiTemplateSelectPage;

	public PoiExportWizardPage getPoiExportFilePage() {
		return poiExportFilePage;
	}

	public PoiSelectWizardPage getPoiTemplateSelectPage() {
		return poiTemplateSelectPage;
	}

	public PoiExportWizard() {
	}

	@Override
	public boolean performFinish() {

		if(!TeneoService.getInstance().initialized()){
			Shell s = this.getShell();
			MessageDialog.openWarning(s, Messages.PoiExportWizard_0, Messages.PoiExportWizard_1);
			return false;
		}
		
		IPath resPath = poiExportFilePage.getFilePath();
		IFile resFile = WorkspaceUtil.INSTANCE.createFileHandle(resPath);

		System.out.println("Wizard settings:"); //$NON-NLS-1$
		System.out.println("--Template: " //$NON-NLS-1$
				+ poiTemplateSelectPage.getPoiTemplateSelection());
		System.out.println("--File: " + resFile.getLocation()); //$NON-NLS-1$

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(resFile.getLocation().toFile());
			PoiEmmitter poiEmmitter = new PoiEmmitter(fos);
			ResourceSet set = new ResourceSetImpl();
			set.getResource(TeneoService.DATABASE_LIBRARY_URI, true);
			Library lib = ModelUtil.getFirstLibrary(set);
			Operator op = ModelUtil.getFirstOperator(set);
			poiEmmitter.go(lib, op);
			poiEmmitter.save();
			try {
				resFile.refreshLocal(IFile.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				System.out.println("Error refreshing: " + resFile.getName()); //$NON-NLS-1$
				e.printStackTrace();
			}
			// We should not have a modified resource in this operation. 
			for (Resource res : set.getResources()) {
				if (res.isLoaded()) {
					res.unload();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle(Messages.XPandExportWizard_3);
		setNeedsProgressMonitor(true);

	}

	@Override
	public void addPages() {

		poiTemplateSelectPage = new PoiSelectWizardPage(
				Messages.XPandExportWizard_4);
		poiTemplateSelectPage.setTitle(Messages.XPandExportWizard_5);
		poiTemplateSelectPage.setDescription(Messages.XPandExportWizard_6);
		// xpandSelectPage.setImageDescriptor(Activator.getImageDescriptor("icons/full/wizban/export_wiz.png"));
		addPage(poiTemplateSelectPage);

		poiExportFilePage = new PoiExportWizardPage(
				Messages.XPandExportWizard_9, selection, "xls"); //$NON-NLS-1$
		poiExportFilePage.setTitle(Messages.XPandExportWizard_11);
		poiExportFilePage.setDescription(Messages.XPandExportWizard_12);
		poiExportFilePage.setContainerFullPath(WorkspaceUtil.INSTANCE
				.getExportsPath());
		addPage(poiExportFilePage);
	}

}
