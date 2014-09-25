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
package com.netxforge.netxstudio.services.impl;

import com.netxforge.netxstudio.generics.Value;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.services.ServiceForecastUsers;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Forecast Users</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceForecastUsersImpl#getUserValues <em>User Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceForecastUsersImpl#getServiceUserRef <em>Service User Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceForecastUsersImpl extends BaseImpl implements ServiceForecastUsers {
	/**
	 * The cached value of the '{@link #getUserValues() <em>User Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> userValues;

	/**
	 * The cached value of the '{@link #getServiceUserRef() <em>Service User Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceUserRef()
	 * @generated
	 * @ordered
	 */
	protected ServiceUser serviceUserRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceForecastUsersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.SERVICE_FORECAST_USERS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getUserValues() {
		if (userValues == null) {
			userValues = new EObjectContainmentEList<Value>(Value.class, this, ServicesPackage.SERVICE_FORECAST_USERS__USER_VALUES);
		}
		return userValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceUser getServiceUserRef() {
		if (serviceUserRef != null && serviceUserRef.eIsProxy()) {
			InternalEObject oldServiceUserRef = (InternalEObject)serviceUserRef;
			serviceUserRef = (ServiceUser)eResolveProxy(oldServiceUserRef);
			if (serviceUserRef != oldServiceUserRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicesPackage.SERVICE_FORECAST_USERS__SERVICE_USER_REF, oldServiceUserRef, serviceUserRef));
			}
		}
		return serviceUserRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceUser basicGetServiceUserRef() {
		return serviceUserRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceUserRef(ServiceUser newServiceUserRef) {
		ServiceUser oldServiceUserRef = serviceUserRef;
		serviceUserRef = newServiceUserRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FORECAST_USERS__SERVICE_USER_REF, oldServiceUserRef, serviceUserRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicesPackage.SERVICE_FORECAST_USERS__USER_VALUES:
				return ((InternalEList<?>)getUserValues()).basicRemove(otherEnd, msgs);
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
			case ServicesPackage.SERVICE_FORECAST_USERS__USER_VALUES:
				return getUserValues();
			case ServicesPackage.SERVICE_FORECAST_USERS__SERVICE_USER_REF:
				if (resolve) return getServiceUserRef();
				return basicGetServiceUserRef();
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
			case ServicesPackage.SERVICE_FORECAST_USERS__USER_VALUES:
				getUserValues().clear();
				getUserValues().addAll((Collection<? extends Value>)newValue);
				return;
			case ServicesPackage.SERVICE_FORECAST_USERS__SERVICE_USER_REF:
				setServiceUserRef((ServiceUser)newValue);
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
			case ServicesPackage.SERVICE_FORECAST_USERS__USER_VALUES:
				getUserValues().clear();
				return;
			case ServicesPackage.SERVICE_FORECAST_USERS__SERVICE_USER_REF:
				setServiceUserRef((ServiceUser)null);
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
			case ServicesPackage.SERVICE_FORECAST_USERS__USER_VALUES:
				return userValues != null && !userValues.isEmpty();
			case ServicesPackage.SERVICE_FORECAST_USERS__SERVICE_USER_REF:
				return serviceUserRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ServiceForecastUsersImpl
