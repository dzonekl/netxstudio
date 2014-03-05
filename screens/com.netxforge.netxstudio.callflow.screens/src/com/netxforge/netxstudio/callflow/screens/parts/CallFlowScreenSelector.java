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
package com.netxforge.netxstudio.callflow.screens.parts;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.callflow.screens.CallFlows;
import com.netxforge.netxstudio.callflow.screens.connectivity.Connectivity;
import com.netxforge.netxstudio.callflow.screens.nodetypes.NodeTypes;
import com.netxforge.netxstudio.callflow.screens.protocols.Protocols;
import com.netxforge.netxstudio.callflow.screens.referenceNetwork.RefNetworks;
import com.netxforge.screens.editing.base.AbstractScreenSelector;
import com.netxforge.screens.editing.base.ScreenUtil;

public class CallFlowScreenSelector extends AbstractScreenSelector {

	public static final String ID = "com.netxforge.netxstudio.screens.selector.callflow"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	public CallFlowScreenSelector() {
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
		screenFormService.getSelectorForm().setText("Call Flows");
	}

	public void buildSelector() {
		
		Composite result;

		result = screenFormService.addScreenSelector("Call Flows",
				"icons/full/obj16/Service_H.png", CallFlows.class, 1,
				ScreenUtil.OPERATION_EDIT);
		
		result = screenFormService.addScreenSelector(result, "NE Types",
				"icons/full/obj16/Node_H.png", NodeTypes.class,
				ScreenUtil.OPERATION_EDIT);
		
		result = screenFormService.addScreenSelector(result, "Reference",
				"icons/full/obj16/Network_H.png", RefNetworks.class,
				ScreenUtil.OPERATION_EDIT);
		
		result = screenFormService.addScreenSelector(result, "Connectivity",
				"icons/full/obj16/FunctionRelationship_H.png", Connectivity.class,
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
