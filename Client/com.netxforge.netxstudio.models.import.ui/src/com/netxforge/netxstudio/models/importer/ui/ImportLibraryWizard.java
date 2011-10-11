package com.netxforge.netxstudio.models.importer.ui;

import org.eclipse.emf.ecore.EPackage;

import com.netxforge.netxstudio.library.LibraryPackage;

public class ImportLibraryWizard extends AbstractImportWizard {

	EPackage[] getEPackages(){
		return new EPackage[] { LibraryPackage.eINSTANCE };
	}

	@Override
	boolean useIndexed() {
		return false;
	}
}
