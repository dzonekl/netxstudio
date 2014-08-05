/*******************************************************************************
 * Copyright (c) 12 mrt. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.parts;

import java.util.Collection;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;

import com.netxforge.netxstudio.screens.editing.CDOEditingService;
import com.netxforge.netxstudio.screens.editing.actions.handlers.WarningObjectEditingActionHandler;
import com.netxforge.screens.editing.base.AbstractScreenSelector;
import com.netxforge.screens.editing.base.actions.IActionHandler;
import com.netxforge.screens.editing.base.actions.handlers.CreationActionsHandler;
import com.netxforge.screens.editing.base.actions.handlers.UIActionsHandler;

/**
 * 
 * Inheritance for customized {@link IActionHandler action handlers}
 * 
 * @author Christophe Bouhier
 */
public abstract class CDOScreenSelector extends AbstractScreenSelector {

	@Override
	protected IActionHandler[] getActionHandlers() {
		IActionHandler[] handlers = new IActionHandler[3];
		handlers[0] = new WarningObjectEditingActionHandler(getEditingService());
		handlers[1] = new CreationActionsHandler();
		handlers[2] = new UIActionsHandler();
		return handlers;
	}

	@Override
	public void buildSelector() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setStatusLineManager(
			Collection<? extends Object> screenObjects) {
		String message = "";
		switch (screenObjects.size()) {
		case 0: {
			message = "No objects";
			break;
		}
		case 1: {
			Object next = screenObjects.iterator().next();

			if (next instanceof EObject) {
				@SuppressWarnings("unused")
				EObject eo = (EObject) next;
				// Do EObject have a unique ID?
			}
			 CDOID cdoID = ((CDOObject) next).cdoID();
			String text = new AdapterFactoryItemDelegator(
					CDOEditingService.getAdapterFactory()).getText(next);

			message = "Screen object: " + text;
			 message = "Screen object: " + text + " OID:" + cdoID;

			// An object could be in proxy state, append the version if not.
			// (Otherwise the cdo revision will be null;
			// if (next.cdoState() != CDOState.PROXY) {
			// CDORevision cdoRevision = next.cdoRevision();
			// int version = cdoRevision.getVersion();
			// message += " version: " + version;
			// }

			break;
		}
		default: {
			message = "Objects: " + Integer.toString(screenObjects.size());
			break;
		}
		}

		// System.out.println("status message: " + message);
		// for(StackTraceElement se : Thread.currentThread().getStackTrace()){
		// System.out.println("--" + se.toString());
		// }

		super.setStatusLineManager(message);
	}
	
}
