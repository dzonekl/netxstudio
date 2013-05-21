/*******************************************************************************
 * Copyright (c) Sep 22, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f2;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.screens.f3.ValueRangeSelectionComponent;

/**
 * Shows a value range selection component.
 * 
 * @author Christophe Bouhier
 */
public class AdjustRangeDialog extends TitleAreaDialog {

	@Inject
	private ValueRangeSelectionComponent valueRangeComponent;

	/**
	 * 
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */

	public AdjustRangeDialog(Shell parentShell, ModelUtils modelUtils) {
		super(parentShell);
		this.valueRangeComponent = new ValueRangeSelectionComponent(modelUtils);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		Composite container = (Composite) super.createDialogArea(parent);
		valueRangeComponent.setShowBorder(false);
		valueRangeComponent.buildUI(container, new GridData(SWT.FILL,
				SWT.CENTER, true, false));

		return container;
	}

	public void injectData(NetXResource resource) {
		valueRangeComponent.setNetXResource(resource);
	}

	public MetricValueRange getValueRange() {
		return valueRangeComponent.getValueRange();
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 200);
	}

	@Override
	protected void configureShell(Shell newShell) {
		newShell.setText("Value range selector");
		super.configureShell(newShell);
	}
}
