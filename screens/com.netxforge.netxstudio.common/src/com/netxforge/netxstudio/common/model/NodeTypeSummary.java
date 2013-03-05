package com.netxforge.netxstudio.common.model;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;

public class NodeTypeSummary {

	public String getFunctionCountAsString() {
		return new Integer(functions).toString();
	}

	public String getEquipmentCountAsString() {
		return new Integer(equipments).toString();
	}

	public String getResourCountAsString() {
		return new Integer(resources).toString();
	}

	public int getFunctionCount() {
		return functions;
	}

	public int getEquipmentCount() {
		return equipments;
	}

	public int getResourCount() {
		return resources;
	}
	
	int functions = 0;
	int equipments = 0;
	int resources = 0;

	public NodeTypeSummary(NodeType nt) {
		TreeIterator<EObject> iterator = nt.eAllContents();
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
}