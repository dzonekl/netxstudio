/*******************************************************************************
 * Copyright (c) 4 mrt. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.app;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;

import com.netxforge.netxstudio.screens.editing.AbstractScreensViewPart;
import com.netxforge.netxstudio.screens.editing.CDOEditingService;
import com.netxforge.netxstudio.screens.editing.IEditingService;

/**
 * A do nothing implementation
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class AbstractWorkbenchWindowLifecycle implements
		IWorkbenchWindowLifecycle {

	public void preWindowOpen(IWorkbenchWindowConfigurer configurer) {

	}

	public void postWindowRestore() {

	}

	public void postWindowCreate() {

	}

	public void openIntro() {

	}

	public void postWindowOpen(
			IWorkbenchWindowConfigurer iWorkbenchWindowConfigurer) {

	}

	public boolean preWindowShellClose() {
		return true;
	}

	public void postWindowClose(
			IWorkbenchWindowConfigurer iWorkbenchWindowConfigurer) {
	}

	/**
	 * Each workbench page is associated with an {@link AbstractScreensViewPart}
	 * , each part has one {@link IEditingService}. The editing service provides
	 * access to the
	 * 
	 * 
	 * @param page
	 */
	protected void printPage(IWorkbenchPage page) {
		IWorkbenchPart activePart = page.getActivePart();

		StringBuilder sb = new StringBuilder();
		if (activePart instanceof AbstractScreensViewPart) {
			AbstractScreensViewPart screensViewPart = (AbstractScreensViewPart) activePart;
			IEditingService editingService = screensViewPart
					.getEditingService();
			if (editingService instanceof CDOEditingService) {
				String printDataStatus = ((CDOEditingService) editingService).printDataStatus();
				sb.append(printDataStatus);
			}
		}

	}

}
