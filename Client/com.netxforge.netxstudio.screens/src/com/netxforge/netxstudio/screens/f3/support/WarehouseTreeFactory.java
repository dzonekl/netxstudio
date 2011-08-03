package com.netxforge.netxstudio.screens.f3.support;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Warehouse;

public class WarehouseTreeFactory implements IObservableFactory {
	private EditingDomain domain;

	private IEMFListProperty warehouseListProperty = EMFEditProperties.multiList(domain,
			OperatorsPackage.Literals.WAREHOUSE__EQUIPMENTS,
			OperatorsPackage.Literals.WAREHOUSE__NODES);

	public WarehouseTreeFactory(EditingDomain domain) {
		this.domain = domain;
	}

	public IObservable createObservable(final Object target) {

		IObservable ol = null;
		if (target instanceof IObservableList) {
			ol = (IObservable) target;
		} else

		if (target instanceof Warehouse) {
			ol = warehouseListProperty.observe(target);
		}
		return ol;
	}
}