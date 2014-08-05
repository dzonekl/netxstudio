/*******************************************************************************
 * Copyright (c) 24 nov. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.f1.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.services.RFSService;

public class RFSServiceTreeStructureAdvisorImpl extends TreeStructureAdvisor {

	@Override
	public Object getParent(Object element) {

		if (element instanceof EObject) {
			return ((EObject) element).eContainer();
		}
		return null;
	}

	@Override
	public Boolean hasChildren(Object element) {
		if (element instanceof Operator
				&& (((Operator) element).getServices().size() > 0)) {
			return Boolean.TRUE;
		}
		if (element instanceof RFSService
				&& (((RFSService) element).getServices().size() > 0)) {
			return Boolean.TRUE;
		}

		return super.hasChildren(element);
	}
}