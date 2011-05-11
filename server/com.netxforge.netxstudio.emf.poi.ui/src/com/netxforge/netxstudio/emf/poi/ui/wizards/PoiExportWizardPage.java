package com.netxforge.netxstudio.emf.poi.ui.wizards;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;


/**
 * Simple exporter wizard page. 
 * 
 */
public class PoiExportWizardPage extends WizardNewFileCreationPage {

	/**
	 */
	private final String fileExtension;

	/**
	 */
	public PoiExportWizardPage(String pageName,
			IStructuredSelection selection, String fileExtension) {
		super(pageName, selection);
		this.fileExtension = fileExtension;
	}

	/**
	 * Override to create files with this extension.
	 */
	protected String getExtension() {
		return fileExtension;
	}


	/**
	 */
	protected IPath getFilePath() {
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
		// FIXME how to validate the export
		if (!super.validatePage()) {
			return false;
		}
		String extension = getExtension();
		if("*".equals(extension)) return true; //$NON-NLS-1$
		if (extension != null
				&& !getFilePath().toString().endsWith("." + extension)) { //$NON-NLS-1$
			setErrorMessage(Messages.PoiExportWizardPage_2 + extension);
			return false;
		}
		return true;
	}
	
//	@Override
//	public boolean isPageComplete() {
//		this.setErrorMessage(null);
//		return true;
//	}	
	
}
