package com.netxforge.netxstudio.models.importer.ui;

import org.eclipse.emf.ecore.EPackage;

import com.netxforge.netxstudio.geo.GeoPackage;

public class ImportGeoWizard extends AbstractImportWizard {

	EPackage[] getEPackages(){
		return new EPackage[] { GeoPackage.eINSTANCE };
	}

	@Override
	boolean useIndexed() {
		return false;
	}
}
