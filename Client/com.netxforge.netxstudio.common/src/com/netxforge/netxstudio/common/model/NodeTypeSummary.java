/*******************************************************************************
 * Copyright (c) 31 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.common.model;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;

/**
 * 
 * @author Christophe Bouhier
 */
public class NodeTypeSummary {

	public NodeTypeSummary(NodeType nt) {

		final TreeIterator<EObject> iterator = nt.eAllContents();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof Function) {
				functions += 1;
			}
			if (next instanceof Equipment) {
				equipments += 1;
			}
			if (next instanceof Component) {
				resources += ((Component) next).getResourceRefs().size();
			}
		}
	}

	int functions = 0;
	int equipments = 0;
	int resources = 0;

	public String getFunctionCountAsString() {
		return new Integer(functions).toString();
	}

	public String getEquipmentCountAsString() {
		return new Integer(equipments).toString();
	}

	public String getResourCountAsString() {
		return new Integer(resources).toString();
	}

	public int totalFunctions() {
		return functions;
	}

	public int totalEquipments() {
		return equipments;
	}

	public int totalResources() {
		return resources;
	}

}