/*******************************************************************************
 * Copyright (c) 16 jan. 2013 NetXForge.
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

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.netxforge.netxstudio.screens.editing.AbstractScreenViewer;
import com.netxforge.netxstudio.screens.editing.IScreen;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;

/**
 * A Standalone viewer which shows a Dashboard.
 * 
 * @author Christophe Bouhier
 * 
 */
public class DashboardViewer extends AbstractScreenViewer {

	private DashboardScreen dashboardScreen;

	public IScreen getScreen() {
		return dashboardScreen;
	}

	public void initScreen(Composite parent) {
		dashboardScreen = new DashboardScreen(parent, SWT.NONE);
		dashboardScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
		dashboardScreen.setEditingService(getEditingService());
		dashboardScreen.buildUI();
	}

	protected void processSelection(ISelection selection) {
		if (selection != null && !selection.isEmpty()
				&& selection instanceof StructuredSelection) {
			IStructuredSelection ss = (StructuredSelection) selection;
			dashboardScreen.injectData(new Object[]{ss.getFirstElement()});
			
		}
	}
}
