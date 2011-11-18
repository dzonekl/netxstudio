package com.netxforge.netxstudio.screens.f3.support;

import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

import com.netxforge.netxstudio.operators.Warehouse;

public class WarehouseTreeStructureAdvisor extends TreeStructureAdvisor {
	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public Boolean hasChildren(Object element) {
		if (element instanceof Warehouse) {
			Warehouse wh = (Warehouse) element;
			if (wh.getEquipments().size() > 0 || wh.getNodes().size() > 0) {
				return Boolean.TRUE;
			}else{
				return null;
			}
		}
		return false;
	}
}