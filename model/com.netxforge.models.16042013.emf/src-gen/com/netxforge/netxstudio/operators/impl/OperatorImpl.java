/**
 * Copyright (c) 2014 NetXForge
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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
	 * The cached value of the '{@link #getNetworks() <em>Networks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworks()
	 * @generated
	 * @ordered
	 */
	protected EList<Network> networks;

	/**
	 * The cached value of the '{@link #getWarehouses() <em>Warehouses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarehouses()
	 * @generated
	 * @ordered
	 */
	protected EList<Warehouse> warehouses;

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> services;

	/**
	 * The cached value of the '{@link #getServiceUsers() <em>Service Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceUser> serviceUsers;

	/**
	 * The cached value of the '{@link #getResourceExpansions() <em>Resource Expansions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceExpansions()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceExpansion> resourceExpansions;

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
	public EList<Network> getNetworks() {
		if (networks == null) {
			networks = new EObjectContainmentEList<Network>(Network.class, this, OperatorsPackage.OPERATOR__NETWORKS);
		}
		return networks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Warehouse> getWarehouses() {
		if (warehouses == null) {
			warehouses = new EObjectContainmentEList<Warehouse>(Warehouse.class, this, OperatorsPackage.OPERATOR__WAREHOUSES);
		}
		return warehouses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getServices() {
		if (services == null) {
			services = new EObjectContainmentEList<Service>(Service.class, this, OperatorsPackage.OPERATOR__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceUser> getServiceUsers() {
		if (serviceUsers == null) {
			serviceUsers = new EObjectContainmentEList<ServiceUser>(ServiceUser.class, this, OperatorsPackage.OPERATOR__SERVICE_USERS);
		}
		return serviceUsers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceExpansion> getResourceExpansions() {
		if (resourceExpansions == null) {
			resourceExpansions = new EObjectContainmentEList<ResourceExpansion>(ResourceExpansion.class, this, OperatorsPackage.OPERATOR__RESOURCE_EXPANSIONS);
		}
		return resourceExpansions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorsPackage.OPERATOR__NETWORKS:
				return ((InternalEList<?>)getNetworks()).basicRemove(otherEnd, msgs);
			case OperatorsPackage.OPERATOR__WAREHOUSES:
				return ((InternalEList<?>)getWarehouses()).basicRemove(otherEnd, msgs);
			case OperatorsPackage.OPERATOR__SERVICES:
				return ((InternalEList<?>)getServices()).basicRemove(otherEnd, msgs);
			case OperatorsPackage.OPERATOR__SERVICE_USERS:
				return ((InternalEList<?>)getServiceUsers()).basicRemove(otherEnd, msgs);
			case OperatorsPackage.OPERATOR__RESOURCE_EXPANSIONS:
				return ((InternalEList<?>)getResourceExpansions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorsPackage.OPERATOR__NETWORKS:
				return getNetworks();
			case OperatorsPackage.OPERATOR__WAREHOUSES:
				return getWarehouses();
			case OperatorsPackage.OPERATOR__SERVICES:
				return getServices();
			case OperatorsPackage.OPERATOR__SERVICE_USERS:
				return getServiceUsers();
			case OperatorsPackage.OPERATOR__RESOURCE_EXPANSIONS:
				return getResourceExpansions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperatorsPackage.OPERATOR__NETWORKS:
				getNetworks().clear();
				getNetworks().addAll((Collection<? extends Network>)newValue);
				return;
			case OperatorsPackage.OPERATOR__WAREHOUSES:
				getWarehouses().clear();
				getWarehouses().addAll((Collection<? extends Warehouse>)newValue);
				return;
			case OperatorsPackage.OPERATOR__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends Service>)newValue);
				return;
			case OperatorsPackage.OPERATOR__SERVICE_USERS:
				getServiceUsers().clear();
				getServiceUsers().addAll((Collection<? extends ServiceUser>)newValue);
				return;
			case OperatorsPackage.OPERATOR__RESOURCE_EXPANSIONS:
				getResourceExpansions().clear();
				getResourceExpansions().addAll((Collection<? extends ResourceExpansion>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperatorsPackage.OPERATOR__NETWORKS:
				getNetworks().clear();
				return;
			case OperatorsPackage.OPERATOR__WAREHOUSES:
				getWarehouses().clear();
				return;
			case OperatorsPackage.OPERATOR__SERVICES:
				getServices().clear();
				return;
			case OperatorsPackage.OPERATOR__SERVICE_USERS:
				getServiceUsers().clear();
				return;
			case OperatorsPackage.OPERATOR__RESOURCE_EXPANSIONS:
				getResourceExpansions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperatorsPackage.OPERATOR__NETWORKS:
				return networks != null && !networks.isEmpty();
			case OperatorsPackage.OPERATOR__WAREHOUSES:
				return warehouses != null && !warehouses.isEmpty();
			case OperatorsPackage.OPERATOR__SERVICES:
				return services != null && !services.isEmpty();
			case OperatorsPackage.OPERATOR__SERVICE_USERS:
				return serviceUsers != null && !serviceUsers.isEmpty();
			case OperatorsPackage.OPERATOR__RESOURCE_EXPANSIONS:
				return resourceExpansions != null && !resourceExpansions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperatorImpl
