/**
 * Copyright (c) 2011 NetXForge
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * Christophe Bouhier - initial API and implementation and/or initial documentation
 */
package com.netxforge.netxstudio.services.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.impl.BaseResourceImpl;
import com.netxforge.netxstudio.services.ServiceProfileResource;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Profile Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceProfileResourceImpl#getProfileValues <em>Profile Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceProfileResourceImpl#getForecastValues <em>Forecast Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceProfileResourceImpl#getTrendedValues <em>Trended Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceProfileResourceImpl extends BaseResourceImpl implements ServiceProfileResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceProfileResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.SERVICE_PROFILE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getProfileValues() {
		return (EList<Value>)eGet(ServicesPackage.Literals.SERVICE_PROFILE_RESOURCE__PROFILE_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getForecastValues() {
		return (EList<Value>)eGet(ServicesPackage.Literals.SERVICE_PROFILE_RESOURCE__FORECAST_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getTrendedValues() {
		return (EList<Value>)eGet(ServicesPackage.Literals.SERVICE_PROFILE_RESOURCE__TRENDED_VALUES, true);
	}

} //ServiceProfileResourceImpl
