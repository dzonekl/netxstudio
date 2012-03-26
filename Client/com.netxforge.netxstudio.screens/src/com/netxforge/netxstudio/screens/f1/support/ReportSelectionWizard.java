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
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.editing.IEditingService;

public class ReportSelectionWizard extends Wizard implements INewWizard {

	@Inject
	private ModelUtils modelUtils;

	@Inject
	private ServerRequest serverActions;

	@Inject
	private IEditingService editingService;

	private Object firstSelectedObject;

	@Inject
	private ReportSelectionPeriodPage reportSelectionPeriod;

	
	private ReportTypeSelectionPage reportSelectionType;

	public ReportSelectionWizard() {
		setWindowTitle("Reporting");
	}

	@Override
	public void addPages() {

		reportSelectionType = new ReportTypeSelectionPage(editingService);
		reportSelectionType.setSelection(firstSelectedObject);

		this.addPage(reportSelectionType);
		this.addPage(reportSelectionPeriod);

	}

	@Override
	public boolean performFinish() {

		CDOObject targetObject = null;
		@SuppressWarnings("unused")
		String identifier = "";

		if (firstSelectedObject instanceof CDOObject) {
			targetObject = (CDOObject) firstSelectedObject;
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
						nodeType, targetObject, fromDate, toDate);
			}
				break;
			case ReportTypeSelectionPage.REPORT_ON_SERVICE: {
				result = serverActions.callServiceReportingAction(targetObject,
						fromDate, toDate);

			}
				break;
			case ReportTypeSelectionPage.REPORT_ON_OPERATOR: {
				result = serverActions.callOperatorReportingAction(
						targetObject, fromDate, toDate);

			}
				break;
			case ReportTypeSelectionPage.REPORT_ON_OPERATOR_NODETYPE: {
				NodeType nodeType = reportSelectionType.getNodeType();
				result = serverActions.callNodeTypeReportingForOperatorAction(
						nodeType, targetObject, fromDate, toDate);

			}
				break;
			case ReportTypeSelectionPage.REPORT_ON_NODE: {
				result = serverActions.callNodeReportingAction(targetObject,
						fromDate, toDate);
			}
				break;

			case ReportTypeSelectionPage.REPORT_ON_COMPONENT: {
				
				// We can only report for the whole node, so resolve it first!
				Node nodeFor = modelUtils.nodeFor(targetObject);
				if (nodeFor != null) {
					result = serverActions.callNodeReportingAction(
							nodeFor, fromDate, toDate);

				}
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
		firstSelectedObject = ((IStructuredSelection) selection)
				.getFirstElement();
	}

}
