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
package com.netxforge.netxstudio.scheduling.impl;

import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.ServiceUserFailure;

import com.netxforge.netxstudio.services.ServiceUser;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service User Failure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.ServiceUserFailureImpl#getServiceUserRef <em>Service User Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceUserFailureImpl extends ExpressionFailureImpl implements ServiceUserFailure {
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
	protected ServiceUserFailureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.SERVICE_USER_FAILURE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.SERVICE_USER_FAILURE__SERVICE_USER_REF, oldServiceUserRef, serviceUserRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.SERVICE_USER_FAILURE__SERVICE_USER_REF, oldServiceUserRef, serviceUserRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.SERVICE_USER_FAILURE__SERVICE_USER_REF:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulingPackage.SERVICE_USER_FAILURE__SERVICE_USER_REF:
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
			case SchedulingPackage.SERVICE_USER_FAILURE__SERVICE_USER_REF:
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
			case SchedulingPackage.SERVICE_USER_FAILURE__SERVICE_USER_REF:
				return serviceUserRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ServiceUserFailureImpl
