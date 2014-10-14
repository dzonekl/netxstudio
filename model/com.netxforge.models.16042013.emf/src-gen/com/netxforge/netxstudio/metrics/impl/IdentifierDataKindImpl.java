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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;

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
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getObjectKind <em>Object Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getObjectProperty <em>Object Property</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentifierDataKindImpl extends DataKindImpl implements IdentifierDataKind {
	/**
	 * The default value of the '{@link #getObjectKind() <em>Object Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectKind()
	 * @generated
	 * @ordered
	 */
	protected static final ObjectKindType OBJECT_KIND_EDEFAULT = ObjectKindType.NODE;

	/**
	 * The cached value of the '{@link #getObjectKind() <em>Object Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectKind()
	 * @generated
	 * @ordered
	 */
	protected ObjectKindType objectKind = OBJECT_KIND_EDEFAULT;

	/**
	 * This is true if the Object Kind attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean objectKindESet;

	/**
	 * The default value of the '{@link #getObjectProperty() <em>Object Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECT_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectProperty() <em>Object Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectProperty()
	 * @generated
	 * @ordered
	 */
	protected String objectProperty = OBJECT_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected String pattern = PATTERN_EDEFAULT;

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
	public ObjectKindType getObjectKind() {
		return objectKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectKind(ObjectKindType newObjectKind) {
		ObjectKindType oldObjectKind = objectKind;
		objectKind = newObjectKind == null ? OBJECT_KIND_EDEFAULT : newObjectKind;
		boolean oldObjectKindESet = objectKindESet;
		objectKindESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_KIND, oldObjectKind, objectKind, !oldObjectKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetObjectKind() {
		ObjectKindType oldObjectKind = objectKind;
		boolean oldObjectKindESet = objectKindESet;
		objectKind = OBJECT_KIND_EDEFAULT;
		objectKindESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_KIND, oldObjectKind, OBJECT_KIND_EDEFAULT, oldObjectKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetObjectKind() {
		return objectKindESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectProperty() {
		return objectProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectProperty(String newObjectProperty) {
		String oldObjectProperty = objectProperty;
		objectProperty = newObjectProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY, oldObjectProperty, objectProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(String newPattern) {
		String oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.IDENTIFIER_DATA_KIND__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_KIND:
				return getObjectKind();
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY:
				return getObjectProperty();
			case MetricsPackage.IDENTIFIER_DATA_KIND__PATTERN:
				return getPattern();
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
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_KIND:
				setObjectKind((ObjectKindType)newValue);
				return;
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY:
				setObjectProperty((String)newValue);
				return;
			case MetricsPackage.IDENTIFIER_DATA_KIND__PATTERN:
				setPattern((String)newValue);
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
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_KIND:
				unsetObjectKind();
				return;
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY:
				setObjectProperty(OBJECT_PROPERTY_EDEFAULT);
				return;
			case MetricsPackage.IDENTIFIER_DATA_KIND__PATTERN:
				setPattern(PATTERN_EDEFAULT);
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
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_KIND:
				return isSetObjectKind();
			case MetricsPackage.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY:
				return OBJECT_PROPERTY_EDEFAULT == null ? objectProperty != null : !OBJECT_PROPERTY_EDEFAULT.equals(objectProperty);
			case MetricsPackage.IDENTIFIER_DATA_KIND__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
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
		result.append(" (objectKind: ");
		if (objectKindESet) result.append(objectKind); else result.append("<unset>");
		result.append(", objectProperty: ");
		result.append(objectProperty);
		result.append(", pattern: ");
		result.append(pattern);
		result.append(')');
		return result.toString();
	}

} //IdentifierDataKindImpl
