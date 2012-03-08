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
package com.netxforge.netxstudio.operators.impl;

import com.netxforge.netxstudio.generics.impl.CompanyImpl;

import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceExpansion;
import com.netxforge.netxstudio.operators.Warehouse;

import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.OperatorImpl#getNetworks <em>Networks</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.OperatorImpl#getWarehouses <em>Warehouses</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.OperatorImpl#getServices <em>Services</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.OperatorImpl#getServiceUsers <em>Service Users</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.OperatorImpl#getResourceExpansions <em>Resource Expansions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorImpl extends CompanyImpl implements Operator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Network> getNetworks() {
		return (EList<Network>)eGet(OperatorsPackage.Literals.OPERATOR__NETWORKS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Warehouse> getWarehouses() {
		return (EList<Warehouse>)eGet(OperatorsPackage.Literals.OPERATOR__WAREHOUSES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Service> getServices() {
		return (EList<Service>)eGet(OperatorsPackage.Literals.OPERATOR__SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceUser> getServiceUsers() {
		return (EList<ServiceUser>)eGet(OperatorsPackage.Literals.OPERATOR__SERVICE_USERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ResourceExpansion> getResourceExpansions() {
		return (EList<ResourceExpansion>)eGet(OperatorsPackage.Literals.OPERATOR__RESOURCE_EXPANSIONS, true);
	}

} //OperatorImpl
