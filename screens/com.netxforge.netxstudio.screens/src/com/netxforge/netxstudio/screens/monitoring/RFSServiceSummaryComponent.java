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
import com.netxforge.netxstudio.common.model.RFSServiceSummary;

public class RFSServiceSummaryComponent extends AbstractSummaryComponent {

	private FormText formTextNumberOfNodes;

	private FormText formTextNumberOfResources;

	/**
	 * Assume a {@link GridLayout} with 2 columns.
	 */
	protected void buildSummary() {

		Composite gridContent = formToolkit.createComposite(this.content,
				SWT.NONE);
		gridContent.setLayout(new GridLayout(2, false));
		formToolkit.paintBordersFor(gridContent);
		
		final Label lblMonitoredNodes = formToolkit.createLabel(gridContent,
				"# Monitored NE's:", SWT.NONE);
		GridData gd_lblNodes = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_lblNodes.widthHint = 83;
		lblMonitoredNodes.setLayoutData(gd_lblNodes);

		formTextNumberOfNodes = formToolkit.createFormText(gridContent, false);
		formTextNumberOfNodes.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1));
		formToolkit.paintBordersFor(formTextNumberOfNodes);
		formTextNumberOfNodes.setText("", false, false);

		final Label lblMonitoredRess = new Label(gridContent, SWT.NONE);
		lblMonitoredRess.setLayoutData(gd_lblNodes);
		formToolkit.adapt(lblMonitoredRess, true, true);
		lblMonitoredRess.setText("# Monitored RES's:");

		formTextNumberOfResources = formToolkit.createFormText(gridContent, false);
		formTextNumberOfResources.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1));
		formToolkit.paintBordersFor(formTextNumberOfResources);
		formTextNumberOfResources.setText("", false, false);
	}

	public void fillSummary(IMonitoringSummary nonCastedSummary) {

		if (nonCastedSummary instanceof RFSServiceSummary) {
			RFSServiceSummary summary = (RFSServiceSummary) nonCastedSummary;
			formTextNumberOfNodes.setText(
					new Integer(summary.totalNodes()).toString(), false, false);
			formTextNumberOfResources.setText(
					new Integer(summary.totalResources()).toString(), false,
					false);
		}
	}
}
