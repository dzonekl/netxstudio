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
package com.netxforge.netxstudio.models.export.ui.pages;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import com.netxforge.netxstudio.models.export.ui.Messages;


/**
 * Simple exporter wizard page. 
 * 
 */
public class ExportNewFileWizardPage extends WizardNewFileCreationPage {

	/**
	 */
//	private String fileExtension;

	/**
	 */
	public ExportNewFileWizardPage(String pageName,
			IStructuredSelection selection, String fileExtension) {
		super(pageName, selection);
//		this.fileExtension = fileExtension;
	}

	/**
	 */
//	public void setExtension(String extension) {
//		fileExtension = extension;
//	}
	
	
	
	/**
	 */
//	protected String getExtension() {
//		return fileExtension;
//	}


	/**
	 */
	public IPath getFilePath() {
		IPath path = getContainerFullPath();
		if (path == null) {
			path = new Path(""); //$NON-NLS-1$
		}
		String fileName = getFileName();
		if (fileName != null) {
			path = path.append(fileName);
		}
		return path;
	}

	/**
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
//		IWizardPage prev = this.getPreviousPage();
		IPath wsRoot = ResourcesPlugin.getWorkspace().getRoot().getLocation();
		setContainerFullPath(wsRoot);
		setPageComplete(validatePage());
	}

	/**
	 */
	protected boolean validatePage() {
		
		if (!super.validatePage()) {
			return false;
		}
		String extension = super.getFileExtension();
		if("*".equals(extension)) return true; //$NON-NLS-1$
		if (extension != null
				&& !getFilePath().toString().endsWith("." + extension)) { //$NON-NLS-1$
			setErrorMessage(Messages.XPandExportWizardPage_2 + extension);
			return false;
		}
		return true;
	}
}
