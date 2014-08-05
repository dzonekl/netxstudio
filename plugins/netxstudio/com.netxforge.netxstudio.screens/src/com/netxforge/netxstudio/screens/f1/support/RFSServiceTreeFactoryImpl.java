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