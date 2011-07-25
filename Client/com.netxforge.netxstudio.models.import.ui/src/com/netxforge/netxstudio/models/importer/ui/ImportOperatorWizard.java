package com.netxforge.netxstudio.models.importer.ui;

import org.eclipse.emf.ecore.EPackage;

import com.netxforge.netxstudio.operators.OperatorsPackage;

public class ImportOperatorWizard extends AbstractImportWizard {

	EPackage[] getEPackages(){
		return new EPackage[] { OperatorsPackage.eINSTANCE };
	}
}
