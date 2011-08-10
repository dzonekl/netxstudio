package com.netxforge.netxstudio.screens.f2.support;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;

public class Totals {

	public String getFunctions() {
		return new Integer(functions).toString();
	}

	public String getEquipments() {
		return new Integer(equipments).toString();
	}

	public String getResources() {
		return new Integer(resources).toString();
	}

	int functions = 0;
	int equipments = 0;
	int resources = 0;

	public Totals(NodeType nt) {
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