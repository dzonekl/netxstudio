package com.netxforge.netxstudio.emf.teneo.ui.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.netxforge.netxstudio.emf.teneo.TeneoService;
import com.netxforge.netxstudio.emf.teneo.ui.internal.Activator;
import com.netxforge.netxstudio.library.Library;

public class DBExportWizard extends Wizard implements IExportWizard {
	
	private IStructuredSelection selection;
	private DBCreationWizardPage dbExportFilePage;
	
	
	public DBExportWizard() {
	}

	@Override
	public boolean performFinish() {
		
		if(!TeneoService.getInstance().initialized()){
			Shell s = this.getShell();
			MessageDialog.openWarning(s, Messages.DBExportWizard_5, Messages.DBExportWizard_6);
			return false;
		}
		
		// Implement the export. 
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				URI exportURI = dbExportFilePage.getURI();
				// Create a platform URI. 
				Activator.logInfo(Messages.DBExportWizard_0 + exportURI.toString());
				
				ResourceSet set = new ResourceSetImpl();
				Resource resource = set.createResource(exportURI);
				
				// Get a copy of our library, don't use the already loaded version as we don't
				// know if we have an editor open. 
				
				Resource source = set.getResource(TeneoService.DATABASE_LIBRARY_URI, true);
				Library copy = (Library) EcoreUtil.copy(source.getContents().get(0));
				
				// Check the resource type. 
				resource.getContents().add(copy);
				try {
					resource.save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		};

		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						Messages.DBExportWizard_1, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				Activator.logError(
						"Error exporting model", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		
		return true;
		
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle(Messages.DBExportWizard_2);
//		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/wizban/ExportDBWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		
		dbExportFilePage = new DBCreationWizardPage(
				"DiagramModelFile", selection, "netxstudio"); //$NON-NLS-1$ //$NON-NLS-2$
		dbExportFilePage
				.setTitle(Messages.DBExportWizard_3);
		dbExportFilePage
				.setDescription(Messages.DBExportWizard_4);
		addPage(dbExportFilePage);		
	}
	
}
