package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;

class NodeTypeTreeFactoryImpl implements IObservableFactory {

	EditingDomain domain;
	@SuppressWarnings("unused")
	private ObservablesManager obm;

	private IEMFListProperty nodeTypeObservableProperty = EMFEditProperties
			.multiList(domain,
					LibraryPackage.Literals.NODE_TYPE__FUNCTIONS,
					LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS);

	private IEMFListProperty functionsObservableProperty = EMFEditProperties
			.multiList(domain, LibraryPackage.Literals.FUNCTION__FUNCTIONS,
					LibraryPackage.Literals.COMPONENT__RESOURCE_REFS);

	private IEMFListProperty equipmentsObservableProperty = EMFEditProperties
			.multiList(domain,
					LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS,
					LibraryPackage.Literals.COMPONENT__RESOURCE_REFS);

	NodeTypeTreeFactoryImpl(EditingDomain domain) {
		this.domain = domain;
	}

	public IObservable createObservable(final Object target) {

		IObservable ol = null;

		if (target instanceof IObservableList) {
			ol = (IObservable) target;
		} else if (target instanceof NodeType) {
			ol = nodeTypeObservableProperty.observe(target);
		} else if (target instanceof Function) {
			ol = functionsObservableProperty.observe(target);
		} else if (target instanceof Equipment) {
			ol = equipmentsObservableProperty.observe(target);
		}

		// if (ol != null) {
		// obm.addObservable(ol);
		// }
		return ol;
	}
}