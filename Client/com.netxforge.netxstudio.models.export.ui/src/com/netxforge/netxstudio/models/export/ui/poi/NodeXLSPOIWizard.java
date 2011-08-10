package com.netxforge.netxstudio.models.export.ui.poi;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;

public class NodeXLSPOIWizard extends AbstractExportPOIWizard {

	private IStructuredSelection selection;

	EPackage[] getEPackages(){
		return new EPackage[] { OperatorsPackage.eINSTANCE, LibraryPackage.eINSTANCE };
	}
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("Export Network Element Instance (s) to XLS");
		setNeedsProgressMonitor(true);
	}

	@SuppressWarnings("unchecked")
	@Override
	Object[] getTargetObjects() {
		if(selection != null){
			return Lists.newArrayList( selection.iterator()).toArray();
		}
		return null;
	}
	
}
