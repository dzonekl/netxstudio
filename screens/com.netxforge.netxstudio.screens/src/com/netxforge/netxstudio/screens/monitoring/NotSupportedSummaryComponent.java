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
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormText;

import com.netxforge.netxstudio.common.model.IMonitoringSummary;

public class NotSupportedSummaryComponent extends AbstractSummaryComponent {


	private FormText todoText;

	/**
	 * Assume a {@link GridLayout} with 2 columns.
	 */
	protected void buildSummary() {

		final Label lblMonitoredNodes = formToolkit.createLabel(content,
				"NOT SUPPORTED: ", SWT.NONE);
		lblMonitoredNodes.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		todoText = formToolkit.createFormText(content, false);
		todoText.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 3, 1));
		formToolkit.paintBordersFor(todoText);
		todoText.setText("", false, false);
	}

	public void fillSummary(IMonitoringSummary nonCastedSummary) {
		todoText.setText(nonCastedSummary.toString(), false,false);
	}
}
