package com.netxforge.sites.support;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.Site;

public class RoomTreeFactory implements IObservableFactory {
	private EditingDomain domain;
	
	private IEMFListProperty countrySitesListProperty = EMFEditProperties
			.list(domain,GeoPackage.Literals.COUNTRY__SITES);

	private IEMFListProperty siteRoomsListProperty = EMFEditProperties
			.list(domain,GeoPackage.Literals.SITE__ROOMS);

	public RoomTreeFactory(EditingDomain domain) {
		this.domain = domain;
	}

	public IObservable createObservable(final Object target) {
		
		IObservable ol = null;
		if (target instanceof IObservableList) {
			ol = (IObservable) target;
		} 
		else 
			
		if (target instanceof Country) {
			ol = countrySitesListProperty.observe(target);
		}
		
		
		if (target instanceof Site) {
			ol = siteRoomsListProperty.observe(target);
		}
		
		return ol;
	}
}