/*******************************************************************************
 * Copyright (c) 7 mrt. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
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
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.screens.editing.base.IEditingService;

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

			if (editingService instanceof ICDODataService) {
				serverActions.setCDOServer(((ICDODataService) editingService).getServer());
			}

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
