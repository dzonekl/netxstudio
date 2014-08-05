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
import org.eclipse.swt.widgets.Text;

import com.netxforge.netxstudio.common.model.IMonitoringSummary;

public class TODOSummaryComponent extends AbstractSummaryComponent {

	private Text todoText;

	/**
	 * Assume a {@link GridLayout} with 2 columns.
	 */
	protected void buildSummary() {

		Composite gridContent = formToolkit.createComposite(this.content,
				SWT.NONE);
		gridContent.setLayout(new GridLayout(2, false));
		formToolkit.paintBordersFor(gridContent);

		Label summaryLabel = formToolkit.createLabel(gridContent, "Summary: ",
				SWT.NONE);
		summaryLabel.setAlignment(SWT.RIGHT);

		GridData gd_lblSummary = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblSummary.widthHint = 83;
		summaryLabel.setLayoutData(gd_lblSummary);

		todoText = formToolkit.createText(gridContent, "", SWT.MULTI);
		GridData gridData = new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1);
		gridData.heightHint = 60;
		todoText.setLayoutData(gridData);
	}

	public void fillSummary(IMonitoringSummary nonCastedSummary) {
		todoText.setText(nonCastedSummary.toString());
	}
}
