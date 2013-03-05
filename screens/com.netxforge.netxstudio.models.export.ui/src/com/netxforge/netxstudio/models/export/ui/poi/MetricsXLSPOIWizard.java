package com.netxforge.netxstudio.models.export.ui.poi;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

import com.netxforge.netxstudio.metrics.MetricsPackage;

public class MetricsXLSPOIWizard extends AbstractExportPOIWizard {

	@SuppressWarnings("unused")
	private IStructuredSelection selection;

	EPackage[] getEPackages() {
		return new EPackage[] { MetricsPackage.eINSTANCE };
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("Export All Data (s) to XLS");
		setNeedsProgressMonitor(true);
	}

	@Override
	Object[] getTargetObjects() {
		Resource metricsourceResource = super.dataProvider
				.getResource(MetricsPackage.Literals.METRIC_SOURCE);
		return metricsourceResource.getContents().toArray();
	}

}
