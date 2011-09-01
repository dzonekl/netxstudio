/*******************************************************************************
 * Copyright (c) Aug 2, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.operators.OperatorsPackage;

/**
 * An action handler which accepts non-predefined actions.
 * 
 * CURRENTLY NOT USED
 * 
 * 
 */
public class NodeActionHandler extends AbstractActionHandler {

	@SuppressWarnings("unused")
	private IStructuredSelection selection;

	@Inject
	IDataService dataservice;
	
	Collection<EObject> warehouses;
	
	public void initActions(IActionBars actionBars) {
		Resource res = dataservice.getProvider().getResource(OperatorsPackage.Literals.WAREHOUSE);
		warehouses = res.getContents();
	}

	public void showMenu(ActionHandlerDescriptor descriptor) {
		IMenuManager menuManager = descriptor.getMenuManager();
		this.addActions(menuManager);
		
	}

	private void addActions(IMenuManager menuManager) {
//		MoveToWarehouseAction mtwa = new MoveToWarehouseAction(warehouses, this.domain);
	}

	@Override
	public void handleSelection(IStructuredSelection ss) {
		this.selection = ss;
		
	}


}
