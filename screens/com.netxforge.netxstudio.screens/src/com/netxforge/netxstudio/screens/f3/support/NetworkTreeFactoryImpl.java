/*******************************************************************************
 * Copyright (c) 24 nov. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.f3.support;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;

public class NetworkTreeFactoryImpl implements IObservableFactory {

	protected EditingDomain domain;

	private IEMFListProperty operatorObservableProperty = EMFEditProperties
			.list(domain, OperatorsPackage.Literals.OPERATOR__NETWORKS);

	private IEMFListProperty networkObservableProperty = EMFEditProperties
			.multiList(
					domain,
					OperatorsPackage.Literals.NETWORK__NODES,
					OperatorsPackage.Literals.NETWORK__NETWORKS,
					OperatorsPackage.Literals.NETWORK__EQUIPMENT_RELATIONSHIPS,
					OperatorsPackage.Literals.NETWORK__FUNCTION_RELATIONSHIPS);

	private IEMFListProperty nodeObservableProperty = EMFEditProperties
			.multiList(domain, FeaturePath.fromList(
					OperatorsPackage.Literals.NODE__NODE_TYPE,
					LibraryPackage.Literals.NODE_TYPE__FUNCTIONS),
					FeaturePath.fromList(
							OperatorsPackage.Literals.NODE__NODE_TYPE,
							LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS));

	private IEMFListProperty functionsObservableProperty = EMFEditProperties
			.list(domain, LibraryPackage.Literals.FUNCTION__FUNCTIONS);

	private IEMFListProperty equipmentsObservableProperty = EMFEditProperties
			.list(domain, LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS);

	public NetworkTreeFactoryImpl(EditingDomain domain) {
		this.domain = domain;
	}

	public IObservable createObservable(final Object target) {

		IObservable ol = null;

		if (target instanceof IObservableList) {
			ol = (IObservable) target;
		} else if (target instanceof Operator) {
			ol = operatorObservableProperty.observe(target);
		} else if (target instanceof Network) {
			ol = networkObservableProperty.observe(target);
		} else if (target instanceof Node) {
			ol = nodeObservableProperty.observe(target);
		}

		// else if (target instanceof NodeType) {
		// ol = nodeTypeObservableProperty.observe(target);
		// }

		else if (target instanceof Function) {
			ol = functionsObservableProperty.observe(target);
		} else if (target instanceof Equipment) {
			ol = equipmentsObservableProperty.observe(target);
		}
		return ol;
	}
}