/*******************************************************************************
 * Copyright (c) 10 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.monitoring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormText;

import com.netxforge.netxstudio.common.model.ComponentSummary;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;

public class ComponentSummaryComponent extends AbstractSummaryComponent {

	private FormText componentText;

	private FormText resourcesText;

	//
	// private FormText rangesText;

	/**
	 * Assume a {@link GridLayout} with 2 columns.
	 */
	protected void buildSummary() {

		Composite gridContent = formToolkit.createComposite(this.content,
				SWT.NONE);
		gridContent.setLayout(new GridLayout(2, false));
		formToolkit.paintBordersFor(gridContent);

		Label summaryLabel = formToolkit.createLabel(gridContent, "Component: ",
				SWT.NONE);
		summaryLabel.setAlignment(SWT.RIGHT);

		GridData gd_lblSummary = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblSummary.widthHint = 83;
		summaryLabel.setLayoutData(gd_lblSummary);

		componentText = formToolkit.createFormText(gridContent, false);
		GridData gridData = new GridData(SWT.RIGHT, SWT.TOP, true, false, 1, 1);
		componentText.setLayoutData(gridData);

		Label resourcesLabel = formToolkit.createLabel(gridContent,
				"Resources: ", SWT.NONE);
		resourcesLabel.setAlignment(SWT.RIGHT);

		GridData gd_lblResources = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblResources.widthHint = 83;
		resourcesLabel.setLayoutData(gd_lblResources);

		resourcesText = formToolkit.createFormText(gridContent, false);
		GridData gd_txtResources = new GridData(SWT.RIGHT, SWT.TOP, false, false,
				1, 1);
		resourcesText.setLayoutData(gd_txtResources);

		// Label rangesLabel = formToolkit.createLabel(gridContent, "Ranges: ",
		// SWT.NONE);
		// rangesLabel.setAlignment(SWT.RIGHT);
		//
		// GridData gd_lblValues = new GridData(SWT.RIGHT, SWT.CENTER, false,
		// false, 1, 1);
		// gd_lblValues.widthHint = 83;
		// rangesLabel.setLayoutData(gd_lblValues);
		//
		// rangesText = formToolkit.createFormText(gridContent, false);
		// GridData gd_txtValues = new GridData(SWT.RIGHT, SWT.TOP, false,
		// false,
		// 1, 1);
		// rangesText.setLayoutData(gd_txtValues);

	}

	public void fillSummary(IMonitoringSummary nonCastedSummary) {
		if (nonCastedSummary instanceof ComponentSummary) {

			ComponentSummary summary = (ComponentSummary) nonCastedSummary;

			// TODO, something with
			componentText.setText(summary.getComponentName(), false, false);
			resourcesText.setText(
					new Integer(summary.totalResources()).toString(), false,
					false);
			// rangesText.setText(new Integer(summary.getTarget()
			// .getMetricValueRanges().size()).toString(), false, false);

		}
	}
}
