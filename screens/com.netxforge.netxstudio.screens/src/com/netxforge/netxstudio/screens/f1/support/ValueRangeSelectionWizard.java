/*******************************************************************************
 * Copyright (c) 24 jun. 2013 NetXForge.
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

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Inject;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class ValueRangeSelectionWizard extends Wizard implements INewWizard {

	private static final String REPORTING_WIZARD = "reporting_period";

	private Object firstSelectedObject;

	@Inject
	private ValueRangeSelectionPage valueRangeSelectionPage;

	private NetXResource netXRes;

	public NetXResource getNetXResource() {
		return netXRes;
	}

	public ValueRangeSelectionWizard() {
		setWindowTitle("Select a range");
		IDialogSettings ds = ScreensActivator.getInstance().getDialogSettings();
		IDialogSettings section = ds.getSection(REPORTING_WIZARD);
		if (section == null) {
			ds.addNewSection(REPORTING_WIZARD);
		}
		this.setDialogSettings(section);
	}

	@Override
	public void addPages() {
		this.addPage(valueRangeSelectionPage);
	}

	@Override
	public boolean performFinish() {
		finishPages();
		return true;
	}

	private void finishPages() {
		valueRangeSelectionPage.finish();

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		firstSelectedObject = ((IStructuredSelection) selection)
				.getFirstElement();
		if (firstSelectedObject instanceof NetXResource) {
			netXRes = (NetXResource) firstSelectedObject;
		}
	}

	public MetricValueRange getValueRange() {
		return valueRangeSelectionPage.getRange();
	}

}
