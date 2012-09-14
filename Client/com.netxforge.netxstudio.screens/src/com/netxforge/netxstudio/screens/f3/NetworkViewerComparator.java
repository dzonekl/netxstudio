/*******************************************************************************
 * Copyright (c) Sep 14, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f3;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;

/**
 * A Viewer comparator which can deal with model object features. 
 * http://work.netxforge.com/issues/290
 * 
 * @author Christophe
 *
 */
public class NetworkViewerComparator extends ViewerComparator {
	@Override
	public int category(Object element) {
		if (element instanceof Operator)
			return 1;
		if (element instanceof Network)
			return 2;
		if (element instanceof Relationship)
			return 3;
		if (element instanceof Node)
			return 4;
		if (element instanceof NodeType)
			return 5;
		if (element instanceof Function)
			return 6;
		if (element instanceof Equipment)
			return 7;

		return super.category(element);
	}

	// We can't delegate to the ILabelProvider, as we use a
	// StyledCellLabelProvider.
	@Override
	public int compare(Viewer viewer, Object o1, Object o2) {
		int cat1 = category(o1);
		int cat2 = category(o2);

		if (cat1 != cat2) {
			return cat1 - cat2;
		}

		if (o1 instanceof Equipment && o2 instanceof Equipment) {
			Equipment eq1 = (Equipment) o1;
			Equipment eq2 = (Equipment) o2;

			if (eq1.getEquipmentCode() != null
					&& eq2.getEquipmentCode() != null) {
				return eq1.getEquipmentCode().compareTo(
						eq2.getEquipmentCode());
			}
		} else if (o1 instanceof Function && o2 instanceof Function) {
			Function f1 = (Function) o1;
			Function f2 = (Function) o2;

			if (f1.getName() != null
					&& f2.getName() != null) {
				return f1.getName().compareTo(
						f2.getName());
			}
		} else if (o1 instanceof NodeType && o2 instanceof NodeType) {
			NodeType n1 = (NodeType) o1;
			NodeType n2 = (NodeType) o2;

			if (n1.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)
					&& n2.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)) {
				return n1.getName().compareTo(n2.getName());
			}
			
		} else if (o1 instanceof Node && o2 instanceof Node) {
			Node n1 = (Node) o1;
			Node n2 = (Node) o2;

			if (n1.eIsSet(OperatorsPackage.Literals.NODE__NODE_ID)
					&& n2.eIsSet(OperatorsPackage.Literals.NODE__NODE_ID)) {
				return n1.getNodeID().compareTo(n2.getNodeID());
			}
			
		} else if (o1 instanceof Network && o2 instanceof Network) {
			Network n1 = (Network) o1;
			Network n2 = (Network) o2;
			
			if (n1.eIsSet(OperatorsPackage.Literals.NETWORK__NAME)
					&& n2.eIsSet(OperatorsPackage.Literals.NETWORK__NAME)) {
				return n1.getName().compareTo(n2.getName());
			}
		}
		return super.compare(viewer, o1, o2);
	}
}