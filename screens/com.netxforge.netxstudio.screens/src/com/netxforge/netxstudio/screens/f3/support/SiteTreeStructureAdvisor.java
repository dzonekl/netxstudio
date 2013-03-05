package com.netxforge.netxstudio.screens.f3.support;

import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

import com.netxforge.netxstudio.geo.Country;

public class SiteTreeStructureAdvisor extends TreeStructureAdvisor {
	@Override
	public Object getParent(Object element) {
//		if (element instanceof Metric) {
//			// return ((Metric) element).ggetParent();
//			// Parent?
//			EObject container = ((Metric) element).eContainer();
//			if (container != null && container instanceof Metric) {
//				return container;
//			}
//		}
		return null;
	}

	@Override
	public Boolean hasChildren(Object element) {
		if(element instanceof Country){
			return ((Country) element).getSites().size() > 0 ? Boolean.TRUE : Boolean.FALSE; 
		}
		return false;
	}
}