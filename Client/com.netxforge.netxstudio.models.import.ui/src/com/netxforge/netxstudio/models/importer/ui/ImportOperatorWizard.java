package com.netxforge.netxstudio.models.importer.ui;

import org.eclipse.emf.ecore.EPackage;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;

public class ImportOperatorWizard extends AbstractImportWizard {
	
	
	/**
	 * Capable to import both Operator and Library. 
	 * These will be instances of NodeType. 
	 * The Importer should create a copy of the NodeType from the 
	 * repository.  
	 * 
	 */
	EPackage[] getEPackages(){
		return new EPackage[] { OperatorsPackage.eINSTANCE, LibraryPackage.eINSTANCE };
	}

	@Override
	boolean useIndexed() {
		return false;
	}
}
