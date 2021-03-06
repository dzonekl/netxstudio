/*******************************************************************************
 * Copyright (c) 5 mrt. 2013 NetXForge.
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

import com.netxforge.netxstudio.models.export.XpandTemplate;
import com.netxforge.netxstudio.models.export.impl.XpandCallerService;
import com.netxforge.netxstudio.models.export.ui.pages.ExportNewFileWizardPage;
import com.netxforge.netxstudio.screens.ide.WorkspaceUtil;

public abstract class AbstractModelExportWizard extends Wizard implements IExportWizard {

	protected IStructuredSelection selection;

	private ExportNewFileWizardPage xpandExportFilePage;

	public ExportNewFileWizardPage getXpandExportFilePage() {
		return xpandExportFilePage;
	}

	/**
	 * Clients should implement to return the target object. 
	 * @return
	 */
	public abstract XpandTemplate getTargetTemplate();
	
	public AbstractModelExportWizard() {
	}
	
	@Override
	public boolean performFinish() {

		// Set template variables from the template extension and the export path.  
		final IPath exportPath = xpandExportFilePage.getFilePath();
		
		Map<String, Variable> map = new HashMap<String, Variable>();
		map.put(XpandCallerService.FILE_NAME, new Variable(
				XpandCallerService.FILE_NAME, exportPath.lastSegment()));
		
		final XpandTemplate currentTemplate = this.getTargetTemplate();
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

//		xpandSelectPage = new SelectExportWizardPage(Messages.XPandExportWizard_4);
//		xpandSelectPage.setTitle(Messages.XPandExportWizard_5);
//		xpandSelectPage.setDescription(Messages.XPandExportWizard_6);
		// xpandSelectPage.setImageDescriptor(Activator.getImageDescriptor("icons/full/wizban/export_wiz.png"));
//		addPage(xpandSelectPage);

//		xpandModelSourcePage = new XPandModelSourceWizardPage(
//				Messages.XPandExportWizard_7);
//		xpandModelSourcePage.setTitle("Select Source");
//		xpandModelSourcePage.setDescription(Messages.XPandExportWizard_8);
//		xpandModelSourcePage.init(selection);
//		this.addPage(xpandModelSourcePage);

		// The extension will be set by other wizard pages depending on the wizard flow. 
		xpandExportFilePage = new ExportNewFileWizardPage(Messages.XPandExportWizard_9,
				selection, this.getTargetTemplate().getExtension()); //$NON-NLS-1$
		xpandExportFilePage.setTitle(Messages.XPandExportWizard_11);
		xpandExportFilePage.setDescription(Messages.XPandExportWizard_12);
		xpandExportFilePage.setContainerFullPath(WorkspaceUtil.INSTANCE
				.getExportsPath());
		
		addPage(xpandExportFilePage);
	}

}
