package com.netxforge.netxstudio.models.importer.ui;

import org.eclipse.emf.ecore.EPackage;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

public class ImportAllWizard extends AbstractImportWizard {

	/**
	 * Can deal with all packages.
	 */
	EPackage[] getEPackages() {
		return new EPackage[] { MetricsPackage.eINSTANCE, GeoPackage.eINSTANCE,
				LibraryPackage.eINSTANCE, OperatorsPackage.eINSTANCE,
				GenericsPackage.eINSTANCE, ServicesPackage.eINSTANCE,
				SchedulingPackage.eINSTANCE, ProtocolsPackage.eINSTANCE };
	}

	@Override
	boolean useIndexed() {
		return false;
	}
}
