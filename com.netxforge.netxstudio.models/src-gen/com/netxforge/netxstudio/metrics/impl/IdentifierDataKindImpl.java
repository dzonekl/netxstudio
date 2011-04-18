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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectNameType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier Data Kind</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getObjectAttribute <em>Object Attribute</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getObjectName <em>Object Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentifierDataKindImpl extends DataKindImpl implements IdentifierDataKind {
	/**
	 * The default value of the '{@link #getObjectAttribute() <em>Object Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECT_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectAttribute() <em>Object Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectAttribute()
	 * @generated
	 * @ordered
	 */
	protected String objectAttribute = OBJECT_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getObjectName() <em>Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectName()
	 * @generated
	 * @ordered
	 */
	protected static final ObjectNameType OBJECT_NAME_EDEFAULT = ObjectNameType.NODE;

	/**
	 * The cached value of the '{@link #getObjectName() <em>Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectName()
	 * @generated
	 * @ordered
	 */
	protected ObjectNameType objectName = OBJECT_NAME_EDEFAULT;

	/**
	 * This is true if the Object Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean objectNameESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierDataKindImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.IDENTIFIER_DATA_KIND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectAttribute() {
		return objectAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectAttribute(String newObjectAttribute) {
		String oldObjectAttribute = objectAttribute;
		objectAttribute = newObjectAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_ATTRIBUTE, oldObjectAttribute, objectAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectNameType getObjectName() {
		return objectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectName(ObjectNameType newObjectName) {
		ObjectNameType oldObjectName = objectName;
		objectName = newObjectName == null ? OBJECT_NAME_EDEFAULT : newObjectName;
		boolean oldObjectNameESet = objectNameESet;
		objectNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_NAME, oldObjectName, objectName, !oldObjectNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetObjectName() {
		ObjectNameType oldObjectName = objectName;
		boolean oldObjectNameESet = objectNameESet;
		objectName = OBJECT_NAME_EDEFAULT;
		objectNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_NAME, oldObjectName, OBJECT_NAME_EDEFAULT, oldObjectNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetObjectName() {
		return objectNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_ATTRIBUTE:
				return getObjectAttribute();
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_NAME:
				return getObjectName();
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
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_ATTRIBUTE:
				setObjectAttribute((String)newValue);
				return;
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_NAME:
				setObjectName((ObjectNameType)newValue);
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
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_ATTRIBUTE:
				setObjectAttribute(OBJECT_ATTRIBUTE_EDEFAULT);
				return;
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_NAME:
				unsetObjectName();
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
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_ATTRIBUTE:
				return OBJECT_ATTRIBUTE_EDEFAULT == null ? objectAttribute != null : !OBJECT_ATTRIBUTE_EDEFAULT.equals(objectAttribute);
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_NAME:
				return isSetObjectName();
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
		result.append(" (objectAttribute: ");
		result.append(objectAttribute);
		result.append(", objectName: ");
		if (objectNameESet) result.append(objectName); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //IdentifierDataKindImpl
