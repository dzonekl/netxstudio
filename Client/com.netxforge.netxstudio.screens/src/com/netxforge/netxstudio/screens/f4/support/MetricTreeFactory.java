package com.netxforge.netxstudio.screens.f4.support;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;

public class MetricTreeFactory implements IObservableFactory {

	private EditingDomain domain;
	
	private IEMFListProperty singleList = EMFEditProperties
			.list(domain,MetricsPackage.Literals.METRIC__METRICS);

	
	public MetricTreeFactory(EditingDomain domain) {
		this.domain = domain;
	}

	public IObservable createObservable(final Object target) {
		
		IObservable ol = null;
		if (target instanceof IObservableList) {
			ol = (IObservable) target;
		} 
		else 
			
		if (target instanceof Metric) {
			ol = singleList.observe(target);
		}
		
		return ol;
	}
}