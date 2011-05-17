/*******************************************************************************
 * Copyright (c) May 8, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.screens.parts;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.screens.editing.selector.AbstractScreenSelector_Inj;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f4.MetricSources;
import com.netxforge.netxstudio.screens.f4.Metrics;
import com.netxforge.netxstudio.screens.f4.ResourceMonitor;

public class MonitoringScreenSelector extends AbstractScreenSelector_Inj {

	public static final String ID = "com.netxforge.netxstudio.screens.selector.monitoring"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	public MonitoringScreenSelector() {
		super();
	}

	/**
	 * A dynamic selector screen selector. 
	 * Extends an Editor view part for dirtyness, editing domain, command stack etc...
	 * 
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		screenFormService.getSelectorForm().setText("Monitoring");
	}

	public void buildSelector(){
		
		Composite result;
		result = screenFormService.addScreenSelector("Metrics","icons/full/obj16/Metric_H.png", Metrics.class, 1, Screens.OPERATION_VIEWER);
		result = screenFormService.addScreenSelector(result, "Metric Sources", "icons/full/obj16/MetricSource_H.png",  MetricSources.class, Screens.OPERATION_VIEWER);
		screenFormService.addScreenSelector(result, "Resource Monitor", "icons/full/obj16/Monitor_graph_H.png",  ResourceMonitor.class, Screens.OPERATION_VIEWER);
		
	}
	
	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.AbstractEditorViewPart#initBindings()
	 */
	
	@Override
	protected void initBindings() {
		// TODO Auto-generated method stub
		// Static initialization of bindings. We need a dynamic form for this. 
		// 
		
	}
}
