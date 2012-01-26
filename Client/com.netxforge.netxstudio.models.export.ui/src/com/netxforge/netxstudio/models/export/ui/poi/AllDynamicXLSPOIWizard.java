package com.netxforge.netxstudio.models.export.ui.poi;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.models.export.DynamicExportFilter;
import com.netxforge.netxstudio.models.export.IExportFilter;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

public class AllDynamicXLSPOIWizard extends AbstractExportPOIRevengeWizard {

	@SuppressWarnings("unused")
	private IStructuredSelection selection;

	EPackage[] getEPackages() {
		return new EPackage[] { ServicesPackage.eINSTANCE,
				MetricsPackage.eINSTANCE, LibraryPackage.eINSTANCE,
				OperatorsPackage.eINSTANCE, GenericsPackage.eINSTANCE,
				SchedulingPackage.eINSTANCE, GeoPackage.eINSTANCE, NetxstudioPackage.eINSTANCE};
	}


	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("Export All Data (s) to XLS");
		setNeedsProgressMonitor(true);
	}

	@Override
	IExportFilter getExportFilter() {
		return new DynamicExportFilter();
	}
}
