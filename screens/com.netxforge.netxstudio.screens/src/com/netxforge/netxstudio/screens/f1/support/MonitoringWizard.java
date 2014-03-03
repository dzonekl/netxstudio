/*******************************************************************************
 * Copyright (c) 1 mrt. 2014 NetXForge.
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
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class MonitoringWizard extends Wizard implements INewWizard {

	private static final String REPORTING_WIZARD = "monitoring_period";

	@Inject
	private ServerRequest serverActions;

	@Inject
	private IEditingService editingService;

	private Object firstSelectedObject;

	@Inject
	private PeriodSelectionPage reportSelectionPeriod;

	public MonitoringWizard() {
		setWindowTitle("Monitoring");
		IDialogSettings ds = ScreensActivator.getInstance().getDialogSettings();
		IDialogSettings section = ds.getSection(REPORTING_WIZARD);
		if (section == null) {
			ds.addNewSection(REPORTING_WIZARD);
		}
		this.setDialogSettings(section);

	}

	@Override
	public void addPages() {
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
			serverActions.setCDOServer(editingService.getDataService()
					.getProvider().getServer());

			result = serverActions.callMonitorAction(targetObject, fromDate,
					toDate);

		} catch (Exception e1) {
			e1.printStackTrace();

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
