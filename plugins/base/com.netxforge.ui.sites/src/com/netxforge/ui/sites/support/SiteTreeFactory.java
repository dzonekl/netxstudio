package com.netxforge.ui.sites.support;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.GeoPackage;

public class SiteTreeFactory implements IObservableFactory {
	private EditingDomain domain;
	
	private IEMFListProperty singleList = EMFEditProperties
			.list(domain,GeoPackage.Literals.COUNTRY__SITES);

	public SiteTreeFactory(EditingDomain domain) {
		this.domain = domain;
	}

	public IObservable createObservable(final Object target) {
		
		IObservable ol = null;
		if (target instanceof IObservableList) {
			ol = (IObservable) target;
		} 
		else 
			
		if (target instanceof Country) {
			ol = singleList.observe(target);
		}
		return ol;
	}
}