/*******************************************************************************
 * Copyright (c) Jul 1, 2012 NetXForge.
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
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.screens.common.util.MementoUtil;
import com.netxforge.netxstudio.screens.f2.ValueRangeSelectionComponent;

public class ValueRangeSelectionPage extends WizardPage {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

//	private static final String REPORTING_PERIOD_START = "reporting_period_start";
//	private static final String REPORTING_PERIOD_END = "reporting_period_end";

	@Inject
	private ValueRangeSelectionComponent valueRangeComponent;

	@Inject
	private MementoUtil mementoUtil;

	@Inject
	private ModelUtils modelUtils;
	
	/**
	 * Create the wizard.
	 */
	public ValueRangeSelectionPage() {
		super("wizardPage");

		setTitle("Value Range selection");
		setDescription("Select a range");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite placeHolder = formToolkit.createComposite(parent, SWT.NONE);
		formToolkit.paintBordersFor(placeHolder);
		placeHolder.setLayout(new GridLayout(2, false));

		valueRangeComponent.setShowBorder(false);
		valueRangeComponent.buildUI(placeHolder, new GridData(SWT.FILL, SWT.CENTER,
				true, false));
		setControl(placeHolder);
		restoreDialogSettings();
		this.initiBinding();
	}

	private void restoreDialogSettings() {
		IDialogSettings ds = getDialogSettings();
		if (ds != null) {
			
		}
		initiBinding();
	}

	private void initiBinding() {
		ValueRangeSelectionWizard wiz = (ValueRangeSelectionWizard) this.getWizard();
		this.setNetXResource(wiz.getNetXResource());
	}

	public void setNetXResource(NetXResource resource) {
		this.valueRangeComponent.setNetXResource(resource);
	}

	public void finish() {
		
		// TODO Remember something about this dialog. 
//		mementoUtil.rememberDate(this.getDialogSettings(), fromDate,
//				REPORTING_PERIOD_START);
//		mementoUtil.rememberDate(this.getDialogSettings(), toDate,
//				REPORTING_PERIOD_END);

	}

	public MetricValueRange getRange() {
		return valueRangeComponent.getValueRange();
	}

}
