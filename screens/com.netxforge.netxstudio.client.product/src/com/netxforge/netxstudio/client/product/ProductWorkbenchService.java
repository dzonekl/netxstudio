/*******************************************************************************
 * Copyright (c) 5 mrt. 2013 NetXForge.
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
package com.netxforge.netxstudio.client.product;

import org.eclipse.ui.application.WorkbenchAdvisor;

import com.netxforge.netxstudio.screens.app.IWorkbenchService;
import com.netxforge.netxstudio.screens.app.IWorkbenchWindowLifecycle;

/**
 * A service which returns implementation of {@link WorkbenchAdvisor} and
 * {@link IWorkbenchWindowLifecycle}
 * 
 * @author Christophe Bouhier
 */
public class ProductWorkbenchService implements IWorkbenchService {

	private static final IWorkbenchService self = new ProductWorkbenchService();

	public WorkbenchAdvisor getWorkbenchAdvisor() {
		return ProductWorkbenchAdvisor.getINSTANCE();
	}

	public IWorkbenchWindowLifecycle getWorkbenchWindowLifecycle() {
		return ProductWorkbenchWindowAdvisor.getINSTANCE();
	}

	public static IWorkbenchService getINSTANCE() {
		return self;
	}

}
