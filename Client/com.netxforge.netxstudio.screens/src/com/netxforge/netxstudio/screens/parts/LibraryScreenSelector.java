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

import com.netxforge.netxstudio.screens.ch9.Expressions;
import com.netxforge.netxstudio.screens.editing.selector.AbstractScreenSelector;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f2.NodeTypeResources;
import com.netxforge.netxstudio.screens.f2.NodeTypes;
import com.netxforge.netxstudio.screens.f2.Parameters;
import com.netxforge.netxstudio.screens.f2.Protocols;
import com.netxforge.netxstudio.screens.f2.Units;
import com.netxforge.netxstudio.screens.f2.smarts.SmartLazyTolerances;
import com.netxforge.netxstudio.screens.f4.Metrics;

public class LibraryScreenSelector extends AbstractScreenSelector {

	public static final String ID = "com.netxforge.netxstudio.screens.selector.library"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	public LibraryScreenSelector() {
		super();
	}

	/**
	 * A dynamic selector screen selector. Extends an Editor view part for
	 * dirtyness, editing domain, command stack etc...
	 * 
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		screenFormService.getSelectorForm().setText("Library");
	}

	public void buildSelector() {
		Composite result;

		result = screenFormService.addScreenSelector("NE Types",
				"icons/full/obj16/Node_H.png", NodeTypes.class, 1,
				ScreenUtil.OPERATION_EDIT);

		result = screenFormService.addScreenSelector(result, "Metrics",
				"icons/full/obj16/Metric_H.png", Metrics.class,
				ScreenUtil.OPERATION_EDIT);

		result = screenFormService.addScreenSelector(result,
				"Resource Definitions", "icons/full/obj16/Resource_H.gif",
				NodeTypeResources.class, ScreenUtil.OPERATION_EDIT);

//		result = screenFormService.addScreenSelector(result, "Tolerances",
//				"icons/full/obj16/Tolerance_H.png", Tolerances.class,
//				ScreenUtil.OPERATION_EDIT);
//		
//		result = screenFormService.addScreenSelector(result, "L Tolerances",
//				"icons/full/obj16/Tolerance_H.png", LazyTolerances.class,
//				ScreenUtil.OPERATION_EDIT);
		
		result = screenFormService.addScreenSelector(result, "Tolerances",
				"icons/full/obj16/Tolerance_H.png", SmartLazyTolerances.class,
				ScreenUtil.OPERATION_EDIT);
		
		
		result = screenFormService.addScreenSelector(result, "Expressions",
				"icons/full/obj16/Expression_H.png", Expressions.class,
				ScreenUtil.OPERATION_EDIT);
		
		result = screenFormService.addScreenSelector(result, "Parameters",
				"icons/full/obj16/Parameter_H.png", Parameters.class,
				ScreenUtil.OPERATION_EDIT);
		
// FIXME, The model doesn't allow to set the vendor on a component or equipment. 
//		result = screenFormService.addScreenSelector(result, "Vendors",
//				"icons/full/obj16/Company_H.gif", Vendors.class,
//				Screens.OPERATION_EDIT);

		result = screenFormService.addScreenSelector(result, "Units",
				"icons/full/obj16/Unit_H.png", Units.class,
				ScreenUtil.OPERATION_EDIT);

		result = screenFormService.addScreenSelector(result, "Protocols",
				"icons/full/obj16/Protocol_H.png", Protocols.class,
				ScreenUtil.OPERATION_EDIT);

	}

	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.AbstractEditorViewPart#initBindings
	 * ()
	 */

	@Override
	protected void initBindings() {
		// Static initialization of bindings. We need a dynamic form for this.
		//

	}
}
