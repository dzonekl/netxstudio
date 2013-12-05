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
package com.netxforge.netxstudio.screens.f3.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;

public class NetworkTreeStructureAdvisorImpl extends TreeStructureAdvisor {

	private ModelUtils modelUtils;

	public NetworkTreeStructureAdvisorImpl(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}

	/**
	 * This is important and should return the correct parent as it is used to
	 * set the selection!
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof EObject) {
			EObject eo = (EObject) element;
			EObject eContainer = eo.eContainer();
			if (eContainer != null) {
				if (element instanceof Component
						&& eContainer instanceof NodeType) {
					return modelUtils.nodeFor((EObject) element);
				}
				return eContainer;
			}
		}

		return null;
	}

	@Override
	public Boolean hasChildren(Object element) {

		if (element instanceof Operator) {
			return ((Operator) element).getNetworks().size() > 0 ? Boolean.TRUE
					: null;
		} else if (element instanceof Network) {
			Network net = (Network) element;
			if (net.getNetworks().size() > 0 || net.getNodes().size() > 0
					|| net.getEquipmentRelationships().size() > 0
					|| net.getFunctionRelationships().size() > 0) {
				return Boolean.TRUE;
			} else {
				return null;
			}
		} else if (element instanceof Node) {
			Node n = (Node) element;
			if (n.getNodeType() != null) {
				return Boolean.TRUE;
			} else {
				return null;
			}
		} else if (element instanceof NodeType) {
			if (((NodeType) element).getFunctions().size() > 0
					|| ((NodeType) element).getEquipments().size() > 0) {
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		} else if (element instanceof Function) {
			if (((Function) element).getFunctions().size() > 0) {
				return Boolean.TRUE;
			} else {
				return null;
			}
		} else if (element instanceof Equipment) {
			if (((Equipment) element).getEquipments().size() > 0) {
				return Boolean.TRUE;
			} else {
				return null;
			}
		}
		return super.hasChildren(element);
	}
}