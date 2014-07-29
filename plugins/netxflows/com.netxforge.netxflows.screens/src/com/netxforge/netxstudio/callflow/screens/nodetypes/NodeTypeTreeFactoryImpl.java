/*******************************************************************************
 * Copyright (c) 20 mrt. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.callflow.screens.nodetypes;

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
import com.netxforge.netxstudio.library.ReferenceNetwork;

/**
 * {@link IObservable} factory for our {@link ReferenceNetwork} and descendants.
 * 
 * @author Christophe Bouhier
 * 
 */
public class NodeTypeTreeFactoryImpl implements IObservableFactory {

	EditingDomain domain;

	private IEMFListProperty nodeTypeObservableProperty = EMFEditProperties
			.multiList(domain, LibraryPackage.Literals.NODE_TYPE__FUNCTIONS,
					LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS);

	// TMNL 04082011, remove resources from tree view.
	private IEMFListProperty functionsObservableProperty = EMFEditProperties
			.list(domain, LibraryPackage.Literals.FUNCTION__FUNCTIONS);

	private IEMFListProperty equipmentsObservableProperty = EMFEditProperties
			.list(domain, LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS);

	private IEMFListProperty referenceNetworkObservableProperty = EMFEditProperties
			.list(domain, LibraryPackage.Literals.REFERENCE_NETWORK__NODE_TYPES);

	public NodeTypeTreeFactoryImpl(EditingDomain domain) {
		this.domain = domain;
	}

	public IObservable createObservable(final Object target) {

		IObservable ol = null;

		if (target instanceof IObservableList) {
			ol = (IObservable) target;
		} else if (target instanceof ReferenceNetwork) {
			ol = referenceNetworkObservableProperty.observe(target);
		} else if (target instanceof NodeType) {
			ol = nodeTypeObservableProperty.observe(target);
		} else if (target instanceof Function) {
			ol = functionsObservableProperty.observe(target);
		} else if (target instanceof Equipment) {
			ol = equipmentsObservableProperty.observe(target);
		}

		return ol;
	}
}