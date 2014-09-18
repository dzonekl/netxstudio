package com.netxforge.sites.support;

import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.Site;

public class RoomTreeStructureAdvisor extends TreeStructureAdvisor {
	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public Boolean hasChildren(Object element) {
		if(element instanceof Country){
			return ((Country) element).getSites().size() > 0 ? Boolean.TRUE : Boolean.FALSE; 
		}
		if(element instanceof Site){
			return ((Site) element).getRooms().size() > 0 ? Boolean.TRUE : Boolean.FALSE; 
		}
		return false;
	}
}