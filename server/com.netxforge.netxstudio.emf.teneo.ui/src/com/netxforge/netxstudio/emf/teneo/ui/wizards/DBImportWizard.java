package com.netxforge.netxstudio.emf.teneo.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import com.netxforge.netxstudio.emf.teneo.TeneoModel;
import com.netxforge.netxstudio.emf.teneo.TeneoService;
import com.netxforge.netxstudio.emf.teneo.ui.ModelLoadHelper;
import com.netxforge.netxstudio.emf.teneo.ui.internal.Activator;
import com.netxforge.netxstudio.ui.utils.DiagnosticsDialog;
import com.netxforge.netxstudio.ui.utils.ValidationHelper;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class DBImportWizard extends Wizard implements IImportWizard {

	private IStructuredSelection selection;
	private DBImportModelWizardPage dbImportResourcePage;

	public DBImportWizard() {
	}

	@Override
	public boolean performFinish() {
		
		if(!TeneoService.getInstance().initialized()){
			Shell s = this.getShell();
			MessageDialog.openWarning(s, Messages.DBImportWizard_0, Messages.DBImportWizard_1);
			return false;
		}
		
		
		final IPath inFilePath = dbImportResourcePage.getPath();
		IPath inFilePlatformPath = inFilePath
				.makeRelativeTo(WorkspaceUtil.INSTANCE.getRoot().getLocation());
		URI inFileURI = URI.createPlatformResourceURI(
				inFilePlatformPath.toString(), true);
		// Load this.
		ResourceSet set = new ResourceSetImpl();
		ModelLoadHelper helper = new ModelLoadHelper(set, inFileURI);
		final EObject modelRoot = helper.getContentsRoot();

		if (modelRoot == null) {
			// We need to end this wizard, as this model, is not really what we
			// want.
			return false;
		} else {

			// TODO do this is a long running op.
			Diagnostic isModelValid = ValidationHelper
					.validate(modelRoot, true);

			if (!ValidationHelper.isOK(isModelValid)) {
				final String msg = "Invalid model"; //$NON-NLS-1$
				if (DiagnosticsDialog.openProceedCancel(getShell(),
						inFileURI.lastSegment(), msg, isModelValid) == IDialogConstants.CANCEL_ID) {
					return false;
				}
			}
		}

		// TODO, put this in a workspace operation. 
		IPath p = WorkspaceUtil.INSTANCE.getExportsPath();
		String fileName = WorkspaceUtil.INSTANCE.getUniqueFileName(p, "backup", "netxstudio", "DB"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		p = p.append(fileName);
		
		
//		Library lib = null;
//		// Check if we have data, invoke an export (silently) if we do.
//		lib = TeneoModel.firstTeneoLibrary(session);
//		if (lib != null) {
//			// TODO, make a backup.
//			ResourceSetImpl set = new ResourceSetImpl();			
//			monitor.subTask("Create a backup and flush");
//			TeneoModel.flushTeneoLibrary(session, lib);
//		} else {
//			// We have an empty Teneo.
//		}
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				
				
				
				TeneoModel.setTeneoContent(modelRoot, monitor);
				// TODO perhaps perform a check with the copied root object? 
			}
		};
		try {
			Shell activeShell = this.getContainer().getShell();
			// TODO, consider WorkbenchProgress instead of a Dialog.
			ProgressMonitorDialog dialog = new ProgressMonitorDialog(
					activeShell);
			dialog.run(true, false, op);
			int result = dialog.getReturnCode();
			if (result == Window.CANCEL) {
				Activator.logInfo(Messages.DBImportWizard_3);
			}

		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						Messages.DBImportWizard_4, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				Activator.logError(
						"Error importing model", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}

		return true;

	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle(Messages.DBImportWizard_5);
		//		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/wizban/ExportDBWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);

	}

	@Override
	public void addPages() {

		dbImportResourcePage = new DBImportModelWizardPage(Messages.DBImportWizard_6);
		dbImportResourcePage.setTitle(Messages.DBImportWizard_2);
		dbImportResourcePage
				.setDescription(Messages.DBImportWizard_7);
		dbImportResourcePage.init(selection);
		this.addPage(dbImportResourcePage);
	}

}
