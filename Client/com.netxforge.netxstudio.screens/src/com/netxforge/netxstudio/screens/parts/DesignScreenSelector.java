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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.screens.editing.selector.AbstractScreenSelector;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f2.NodeResources;
import com.netxforge.netxstudio.screens.f2.NodeResourcesAdvanced;
import com.netxforge.netxstudio.screens.f3.Countries;
import com.netxforge.netxstudio.screens.f3.Networks;
import com.netxforge.netxstudio.screens.f3.Operators;
import com.netxforge.netxstudio.screens.f3.RoomsTree;
import com.netxforge.netxstudio.screens.f3.SitesTree;
import com.netxforge.netxstudio.screens.f3.WarehouseTree;

public class DesignScreenSelector extends AbstractScreenSelector {

	public static final String ID = "com.netxforge.netxstudio.screens.selector.design"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
//	private NodeActionHandler nah;

	public DesignScreenSelector() {
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
		screenFormService.getSelectorForm().setText("Network Design");
	}

	public void buildSelector(){
		
		Composite result;

		result = screenFormService.addScreenSelector("Operators",
				"icons/full/obj16/Company_H.gif", Operators.class, 1,
				ScreenUtil.OPERATION_EDIT);
		result = screenFormService.addScreenSelector(result, "Networks",
				"icons/full/obj16/Network_H.png", Networks.class, 1,
				ScreenUtil.OPERATION_EDIT);

		result = screenFormService.addScreenSelector(result, "Resources",
				"icons/full/obj16/Resource_H.gif", NodeResources.class,
				ScreenUtil.OPERATION_EDIT);

		result = screenFormService.addScreenSelector(result, "Resources (New*)",
				"icons/full/obj16/Resource_H.gif", NodeResourcesAdvanced.class,
				ScreenUtil.OPERATION_EDIT);

//		result = screenFormService.addScreenSelector(result, "Resources+",
//				"icons/full/obj16/Resource_H.gif", AllResources.class,
//				Screens.OPERATION_EDIT);
		
		result = screenFormService.addScreenSelector(result, "Warehouses",
				"icons/full/obj16/Warehouse_H.png", WarehouseTree.class, 1,
				ScreenUtil.OPERATION_EDIT);
		result = screenFormService.addScreenSelector(result, "Countries",
				"icons/full/obj16/Country_H.png", Countries.class, 1,
				ScreenUtil.OPERATION_EDIT);
		result = screenFormService.addScreenSelector(result, "Sites",
				"icons/full/obj16/Site_H.png", SitesTree.class, 1,
				ScreenUtil.OPERATION_EDIT);
		result = screenFormService.addScreenSelector(result, "Rooms",
				"icons/full/obj16/Room_H.png", RoomsTree.class, 1,
				ScreenUtil.OPERATION_EDIT);
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
	
	@Override
	public void screenChanged(IScreen screen) {
		super.screenChanged(screen);
		
//		 Make sure we have an action handler for our specific screens and remove them 
//		 otherwise. 
//		if(screen instanceof Networks){
//			nah = new NodeActionHandler();
//			nah.setActivePart(this);
//			this.getActionHandlerDescriptor().addHandler(nah);
//		}else{
//			if( nah != null && this.getActionHandlerDescriptor().hasHandler(nah)){
//				this.getActionHandlerDescriptor().removeHandler(nah);
//			}
//		}
	}

	@Override
	public void contributeMenuAboutToShow(IMenuManager menuManager) {
		super.contributeMenuAboutToShow(menuManager);
	}
	
	
}
