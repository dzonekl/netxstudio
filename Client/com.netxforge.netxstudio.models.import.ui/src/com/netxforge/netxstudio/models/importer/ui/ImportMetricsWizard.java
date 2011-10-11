package com.netxforge.netxstudio.models.importer.ui;

import org.eclipse.emf.ecore.EPackage;

import com.netxforge.netxstudio.metrics.MetricsPackage;

public class ImportMetricsWizard extends AbstractImportWizard {

	EPackage[] getEPackages(){
		return new EPackage[] { MetricsPackage.eINSTANCE };
	}

	@Override
	boolean useIndexed() {
		return true;
	}
}
