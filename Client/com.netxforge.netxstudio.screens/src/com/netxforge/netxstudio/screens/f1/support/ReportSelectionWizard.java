package com.netxforge.netxstudio.screens.f1.support;

import java.util.Date;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.editing.IEditingService;

public class ReportSelectionWizard extends Wizard implements INewWizard {

	@Inject
	ModelUtils modelUtils;

	@Inject
	ServerRequest serverActions;

	@Inject
	IEditingService editingService;

	private Object o;

	private ReportSelectionPeriodPage reportSelectionPeriod;

	private ReportTypeSelectionPage reportSelectionType;

	public ReportSelectionWizard() {
		setWindowTitle("Reporting");
	}

	@Override
	public void addPages() {

		reportSelectionType = new ReportTypeSelectionPage(editingService);
		reportSelectionType.setSelection(o);
		this.addPage(reportSelectionType);

		reportSelectionPeriod = new ReportSelectionPeriodPage(modelUtils);
		this.addPage(reportSelectionPeriod);

	}

	@Override
	public boolean performFinish() {

		CDOObject target = null;
		@SuppressWarnings("unused")
		String identifier = "";

		if (o instanceof CDOObject) {
			target = (CDOObject) o;
		}
		try {

			DateTimeRange dtr = this.reportSelectionPeriod.period();

			Date fromDate = modelUtils.begin(dtr);
			Date toDate = modelUtils.end(dtr);
			@SuppressWarnings("unused")
			String result = null;

			int reportSelection = reportSelectionType.getReportSelection();
			serverActions.setCDOServer(editingService.getDataService()
					.getProvider().getServer());
			
			switch (reportSelection) {
			case ReportTypeSelectionPage.REPORT_ON_SERVICE_NODETYPE: {
				NodeType nodeType = reportSelectionType.getNodeType();
				result = serverActions.callNodeTypeReportingForServiceAction(
						nodeType, target, fromDate, toDate);
			}
				break;
			case ReportTypeSelectionPage.REPORT_ON_SERVICE: {
				result = serverActions.callServiceReportingAction(target,
						fromDate, toDate);

			}
				break;
			case ReportTypeSelectionPage.REPORT_ON_OPERATOR: {
				result = serverActions.callOperatorReportingAction(target,
						fromDate, toDate);

			}
				break;
			case ReportTypeSelectionPage.REPORT_ON_OPERATOR_NODETYPE: {
				NodeType nodeType = reportSelectionType.getNodeType();
				result = serverActions.callNodeTypeReportingForOperatorAction(
						nodeType, target, fromDate, toDate);

			}
				break;
			case ReportTypeSelectionPage.REPORT_ON_NODE: {
				result = serverActions.callNodeReportingAction(target,
						fromDate, toDate);
			}

			}

			// Set the period to the last service monitor,
			// if we don't have a manually entered period.
			// if (fromDate == null && toDate == null) {
			// ServiceMonitor sm = modelUtils
			// .lastServiceMonitor((Service) target);
			// if (sm != null) {
			// DateTimeRange period = sm.getPeriod();
			// fromDate = modelUtils.start(period);
			// toDate = modelUtils.end(period);
			// }
			// }

			// identifier = ((Service) target).getServiceName();

			// MessageDialog
			// .openInformation(
			// ServicesTree.this.getShell(),
			// "Reporting now succeeded:",
			// "Reporting for: "
			// + identifier
			// + "\n has been initiated on the server.");

		} catch (Exception e1) {
			e1.printStackTrace();

			// MessageDialog
			// .openError(
			// ServicesTree.this.getShell(),
			// "Reporting now failed:",
			// "Reporting for : "
			// + identifier
			// +
			// "\n failed. Consult the log for information on the failure");

		}

		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		o = ((IStructuredSelection) selection).getFirstElement();
	}

}
