package com.netxforge.netxstudio.models.importer.ui;

import org.eclipse.emf.ecore.EPackage;

import com.netxforge.netxstudio.services.ServicesPackage;

public class ImportServicesWizard extends AbstractImportWizard {

	EPackage[] getEPackages(){
		return new EPackage[] { ServicesPackage.eINSTANCE };
	}
}
