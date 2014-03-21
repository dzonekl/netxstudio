/*******************************************************************************
 * Copyright (c) Jun 16, 2011 NetXForge.
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
package com.netxforge.netxstudio.callflow.screens;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;

import com.netxforge.netxstudio.callflow.screens.internal.CallFlowsActivator;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.ReferenceNetwork;
import com.netxforge.screens.editing.base.AbstractScreenImpl;

/**
 * Base for screens in this plugins, which require injection of modules
 * from this OSGI plugin. (See the Activator class for which modules are bound). 
 * 
 * @author Christophe Bouhier
 */
public abstract class AbstractScreen extends AbstractScreenImpl {
	
	public AbstractScreen(Composite parent, int style) {
		super(parent, style);
		injectMembers(CallFlowsActivator.getDefault().getInjector());
	}
	
	/**
	 * 
	 */
	public ReferenceNetwork initReferenceNetwork() {
		Resource networksResources = editingService
				.getData(LibraryPackage.Literals.REFERENCE_NETWORK);
		
		boolean showCreationOfNetwork = false;
		ReferenceNetwork refNet = null;
		
		// For now hard code to a single entry.
		if (networksResources.getContents().size() == 1) {
			refNet = (ReferenceNetwork) networksResources
					.getContents().get(0);
		} else {
			refNet = LibraryFactory.eINSTANCE.createReferenceNetwork();
			refNet.setName("Architecture1");
			refNet.setDescription("My first reference architecture");
			
			AddCommand add = new AddCommand(editingService.getEditingDomain(),
					networksResources.getContents(), refNet);
			editingService.getEditingDomain().getCommandStack().execute(add);
			showCreationOfNetwork = true;
		}
		
		if (showCreationOfNetwork) {
			MessageDialog
					.openInformation(this.getShell(), "Model initialized",
							"A new reference network has been created, see NE Types for information on: ");
		}
		return refNet;
	}
}
