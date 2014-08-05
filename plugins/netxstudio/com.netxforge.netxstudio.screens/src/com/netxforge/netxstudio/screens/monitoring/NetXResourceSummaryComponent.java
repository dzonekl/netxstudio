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

import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.NetxresourceSummary;

public class NetXResourceSummaryComponent extends AbstractSummaryComponent {

	private FormText netXResourceText;

	private FormText markersText;

	private FormText rangesText;

	/**
	 * Assume a {@link GridLayout} with 2 columns.
	 */
	protected void buildSummary() {

		Composite gridContent = formToolkit.createComposite(this.content,
				SWT.NONE);
		gridContent.setLayout(new GridLayout(2, false));
		formToolkit.paintBordersFor(gridContent);

		Label summaryLabel = formToolkit.createLabel(gridContent, "Resource: ",
				SWT.NONE);
		summaryLabel.setAlignment(SWT.RIGHT);

		GridData gd_lblSummary = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblSummary.widthHint = 83;
		summaryLabel.setLayoutData(gd_lblSummary);

		netXResourceText = formToolkit.createFormText(gridContent, false);
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1);
		netXResourceText.setLayoutData(gridData);

		Label markersLabel = formToolkit.createLabel(gridContent, "Markers: ",
				SWT.NONE);
		markersLabel.setAlignment(SWT.RIGHT);

		GridData gd_lblMarkers = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblMarkers.widthHint = 83;
		markersLabel.setLayoutData(gd_lblMarkers);

		markersText = formToolkit.createFormText(gridContent, false);
		GridData gd_txtMarkers = new GridData(SWT.FILL, SWT.TOP, false, false,
				1, 1);
		markersText.setLayoutData(gd_txtMarkers);

		Label rangesLabel = formToolkit.createLabel(gridContent, "Ranges: ",
				SWT.NONE);
		rangesLabel.setAlignment(SWT.RIGHT);

		GridData gd_lblValues = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblValues.widthHint = 83;
		rangesLabel.setLayoutData(gd_lblValues);

		rangesText = formToolkit.createFormText(gridContent, false);
		GridData gd_txtValues = new GridData(SWT.FILL, SWT.TOP, false, false,
				1, 1);
		rangesText.setLayoutData(gd_txtValues);

	}

	public void fillSummary(IMonitoringSummary nonCastedSummary) {
		if (nonCastedSummary instanceof NetxresourceSummary) {

			NetxresourceSummary summary = (NetxresourceSummary) nonCastedSummary;

			netXResourceText.setText("<form><p><b>"
					+ summary.getTarget().getExpressionName()
					+ "</b></p></form>", true, false);

			markersText.setText(
					new Integer(summary.markers().size()).toString(), false,
					false);
			rangesText.setText(new Integer(summary.getTarget()
					.getMetricValueRanges().size()).toString(), false, false);

		}
	}
}
