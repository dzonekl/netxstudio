package com.netxforge.netxstudio.models.export.ui.poi;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.models.export.IExportFilter;
import com.netxforge.netxstudio.models.export.StaticExportFilter;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

public class AllStaticXLSPOIWizard extends AbstractExportPOIRevengeWizard {

	@SuppressWarnings("unused")
	private IStructuredSelection selection;

	EPackage[] getEPackages() {
		return new EPackage[] { ServicesPackage.eINSTANCE,
				MetricsPackage.eINSTANCE, LibraryPackage.eINSTANCE,
				OperatorsPackage.eINSTANCE, GenericsPackage.eINSTANCE,
				SchedulingPackage.eINSTANCE, ProtocolsPackage.eINSTANCE };
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("Export All Data (s) to XLS");
		setNeedsProgressMonitor(true);
	}

	@Override
	IExportFilter getExportFilter() {
		return new StaticExportFilter();
	}

	// @Override
	// Object[] getTargetObjects() {
	// Resource metricsourceResource = super.dataProvider
	// .getResource(MetricsPackage.Literals.METRIC_SOURCE);
	// return metricsourceResource.getContents().toArray();
	// }

}
