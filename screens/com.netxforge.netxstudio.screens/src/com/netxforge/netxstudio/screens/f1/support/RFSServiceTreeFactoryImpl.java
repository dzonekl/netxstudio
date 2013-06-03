package com.netxforge.netxstudio.screens.f1.support;

import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServicesPackage;

public class RFSServiceTreeFactoryImpl implements IObservableFactory {

	EditingDomain domain;
	@SuppressWarnings("unused")
	private ObservablesManager obm;

	private IEMFListProperty operatorObservableProperty = EMFEditProperties
			.list(domain, OperatorsPackage.Literals.OPERATOR__SERVICES);

	private IEMFListProperty rfsServiceObservableProperty = EMFEditProperties
			.list(domain, ServicesPackage.Literals.SERVICE__SERVICES);

	public RFSServiceTreeFactoryImpl(EditingDomain domain) {
		this.domain = domain;
	}

	public IObservable createObservable(final Object target) {

		IObservable ol = null;

		if (target instanceof IObservableList) {
			ol = (IObservable) target;
		} else if (target instanceof Operator) {
			ol = operatorObservableProperty.observe(target);
		} else if (target instanceof Service) {
			ol = rfsServiceObservableProperty.observe(target);
		}
		return ol;
	}
}