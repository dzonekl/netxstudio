package com.netxforge.netxstudio.screens.f1.support;

import java.util.Date;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class ReportWizard extends Wizard implements INewWizard {

	private static final String REPORTING_WIZARD = "reporting_period";

	@Inject
	private ServerRequest serverActions;

	private IEditingService editingService;

	private Object firstSelectedObject;

	@Inject
	private PeriodSelectionPage reportSelectionPeriod;

	private ReportTypeSelectionPage reportSelectionType;

	public ReportWizard() {
		setWindowTitle("Reporting");
		IDialogSettings ds = ScreensActivator.getInstance().getDialogSettings();
		IDialogSettings section = ds.getSection(REPORTING_WIZARD);
		if (section == null) {
			ds.addNewSection(REPORTING_WIZARD);
		}
		this.setDialogSettings(section);
	}

	public void setEditingService(IEditingService editingService) {
		this.editingService = editingService;
	}

	@Override
	public void addPages() {

		reportSelectionType = new ReportTypeSelectionPage(editingService);
		reportSelectionType.setSelection(firstSelectedObject);

		this.addPage(reportSelectionType);
		this.addPage(reportSelectionPeriod);

	}

	public void forceReportPeriod(DateTimeRange dtr) {
		// note the page is already created...
		reportSelectionPeriod.setPeriod(dtr);
	}

	@Override
	public boolean performFinish() {

		finishPages();

		CDOObject targetObject = null;
		@SuppressWarnings("unused")
		String identifier = "";

		if (firstSelectedObject instanceof CDOObject) {
			targetObject = (CDOObject) firstSelectedObject;
		}
		try {

			DateTimeRange dtr = this.reportSelectionPeriod.period();

			Date fromDate = StudioUtils.begin(dtr);
			Date toDate = StudioUtils.end(dtr);

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
				Node nodeFor = StudioUtils.nodeFor(targetObject);
				if (nodeFor != null) {
					result = serverActions.callNodeReportingAction(nodeFor,
							fromDate, toDate);

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

	private void finishPages() {
		reportSelectionPeriod.finish();

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		firstSelectedObject = ((IStructuredSelection) selection)
				.getFirstElement();
	}

}
