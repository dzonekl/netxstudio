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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.common.model.IMonitoringSummary;

public abstract class AbstractSummaryComponent implements ISummaryComponent {

	protected final FormToolkit formToolkit = new FormToolkit(
			Display.getCurrent());

	/**
	 * The {@link Composite} holding the UI widgets to present the specifics of
	 * a @link {@link IMonitoringSummary}.
	 */
	protected Composite content;

	public AbstractSummaryComponent() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.monitoring.ISummaryComponent#buildUI
	 * (org.eclipse.swt.widgets.Composite, java.lang.Object)
	 */
	public void buildUI(Composite parent, Object layoutData) {
		this.content = parent;
		buildSummary();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.monitoring.ISummaryComponent#dispose()
	 */
	public void dispose() {
		if (!content.isDisposed()) {
			for (Control child : content.getChildren()) {
				child.dispose();
			}
		}
	}

	/**
	 * Build the UI for the summary.
	 */
	protected abstract void buildSummary();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.monitoring.ISummaryComponent#fillSummary
	 * (com.netxforge.netxstudio.common.model.IMonitoringSummary)
	 */
	public abstract void fillSummary(IMonitoringSummary nonCastedSummary);

}