package com.netxforge.netxstudio.models.export.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtend.expression.Variable;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.models.export.XpandTemplate;
import com.netxforge.netxstudio.models.export.impl.XpandCallerService;
import com.netxforge.netxstudio.models.export.ui.internal.Activator;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class XPandExportImportWizard extends Wizard implements IExportWizard {

	private IStructuredSelection selection;

	private XPandExportWizardPage xpandExportFilePage;
	private XPandSelectWizardPage xpandSelectPage;
	
	public XPandExportWizardPage getXpandExportFilePage() {
		return xpandExportFilePage;
	}

	public XPandSelectWizardPage getXpandSelectPage() {
		return xpandSelectPage;
	}
	
//
//	public XPandModelSourceWizardPage getXpandModelSourcePage() {
//		return xpandModelSourcePage;
//	}

	public XPandExportImportWizard() {
	}
	
	@Override
	public boolean performFinish() {
		
		final XpandTemplate currentTemplate = this.getXpandSelectPage().getSelectedTemplate();
		currentTemplate.setTargetObject(LibraryPackage.eINSTANCE);
		
		// Set template variables. (Generalize this). 
		final IPath exportPath = xpandExportFilePage.getFilePath();
		Map<String, Variable> map = new HashMap<String, Variable>();
		map.put(XpandCallerService.FILE_NAME, new Variable(
				XpandCallerService.FILE_NAME, exportPath.lastSegment()));
		currentTemplate.setGlobalVarsMap(map);
		IPath containerPath = xpandExportFilePage.getContainerFullPath();
		final IContainer container = ResourcesPlugin.getWorkspace().getRoot()
				.getFolder(containerPath);

		// Implement the export.
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				monitor.beginTask(Messages.XPandExportWizard_0 + currentTemplate.getTemplateDescription(), 100);
				currentTemplate.xpand(container);
				monitor.worked(50);
				container.refreshLocal(IResource.DEPTH_ONE, null);
				monitor.setTaskName(Messages.XPandExportWizard_1 + container.getName());
				monitor.done();
			}
		};

		try {
			Shell activeShell = this.getContainer().getShell();
			new ProgressMonitorDialog(activeShell).run(false, true, op);
			
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						Messages.XPandExportWizard_2, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				Activator.logError(
						"Error exporting model", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}

		return true;

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle(Messages.XPandExportWizard_3);
		setNeedsProgressMonitor(true);

	}

	@Override
	public void addPages() {

		xpandSelectPage = new XPandSelectWizardPage(Messages.XPandExportWizard_4);
		xpandSelectPage.setTitle(Messages.XPandExportWizard_5);
		xpandSelectPage.setDescription(Messages.XPandExportWizard_6);
		// xpandSelectPage.setImageDescriptor(Activator.getImageDescriptor("icons/full/wizban/export_wiz.png"));
		addPage(xpandSelectPage);

//		xpandModelSourcePage = new XPandModelSourceWizardPage(
//				Messages.XPandExportWizard_7);
//		xpandModelSourcePage.setTitle("Select Source");
//		xpandModelSourcePage.setDescription(Messages.XPandExportWizard_8);
//		xpandModelSourcePage.init(selection);
//		this.addPage(xpandModelSourcePage);

		// The extension will be set by other wizard pages depending on the wizard flow. 
		xpandExportFilePage = new XPandExportWizardPage(Messages.XPandExportWizard_9,
				selection, "*"); //$NON-NLS-1$
		xpandExportFilePage.setTitle(Messages.XPandExportWizard_11);
		xpandExportFilePage.setDescription(Messages.XPandExportWizard_12);
		xpandExportFilePage.setContainerFullPath(WorkspaceUtil.INSTANCE
				.getExportsPath());
		addPage(xpandExportFilePage);
	}

}
