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

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.services.CIID;
import com.netxforge.netxstudio.services.ServicesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CIID</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.CIIDImpl#getCommonCIID <em>Common CIID</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.CIIDImpl#getLocalCIID <em>Local CIID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CIIDImpl extends BaseImpl implements CIID {
	/**
	 * The default value of the '{@link #getCommonCIID() <em>Common CIID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommonCIID()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMON_CIID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommonCIID() <em>Common CIID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommonCIID()
	 * @generated
	 * @ordered
	 */
	protected String commonCIID = COMMON_CIID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocalCIID() <em>Local CIID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalCIID()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_CIID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalCIID() <em>Local CIID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalCIID()
	 * @generated
	 * @ordered
	 */
	protected String localCIID = LOCAL_CIID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CIIDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.CIID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommonCIID() {
		return commonCIID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommonCIID(String newCommonCIID) {
		String oldCommonCIID = commonCIID;
		commonCIID = newCommonCIID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.CIID__COMMON_CIID, oldCommonCIID, commonCIID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocalCIID() {
		return localCIID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalCIID(String newLocalCIID) {
		String oldLocalCIID = localCIID;
		localCIID = newLocalCIID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.CIID__LOCAL_CIID, oldLocalCIID, localCIID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicesPackage.CIID__COMMON_CIID:
				return getCommonCIID();
			case ServicesPackage.CIID__LOCAL_CIID:
				return getLocalCIID();
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
			case ServicesPackage.CIID__COMMON_CIID:
				setCommonCIID((String)newValue);
				return;
			case ServicesPackage.CIID__LOCAL_CIID:
				setLocalCIID((String)newValue);
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
			case ServicesPackage.CIID__COMMON_CIID:
				setCommonCIID(COMMON_CIID_EDEFAULT);
				return;
			case ServicesPackage.CIID__LOCAL_CIID:
				setLocalCIID(LOCAL_CIID_EDEFAULT);
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
			case ServicesPackage.CIID__COMMON_CIID:
				return COMMON_CIID_EDEFAULT == null ? commonCIID != null : !COMMON_CIID_EDEFAULT.equals(commonCIID);
			case ServicesPackage.CIID__LOCAL_CIID:
				return LOCAL_CIID_EDEFAULT == null ? localCIID != null : !LOCAL_CIID_EDEFAULT.equals(localCIID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (commonCIID: ");
		result.append(commonCIID);
		result.append(", localCIID: ");
		result.append(localCIID);
		result.append(')');
		return result.toString();
	}

} //CIIDImpl
