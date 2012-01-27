/*******************************************************************************
 * Copyright (c) Apr 26, 2011 NetXForge.
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
package com.netxforge.netxstudio.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.netxforge.netxstudio.ui.internal.UIActivator;


public class ShowPropertiesHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			IWorkbenchPage page = HandlerUtil.getActiveEditor(event).getSite().getPage();
			page.showView("org.eclipse.ui.views.PropertySheet");
		}
		catch (PartInitException exception) {
			UIActivator.logError("Error open property", exception);
		}
		return null;
	}
}
