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

import com.netxforge.netxstudio.generics.Value;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;

import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.MarkerKind;
import com.netxforge.netxstudio.operators.OperatorsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Marker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getEquipmentRef <em>Equipment Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getFunctionRef <em>Function Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getMarkerValueRef <em>Marker Value Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MarkerImpl extends EObjectImpl implements Marker {
	/**
	 * The cached value of the '{@link #getEquipmentRef() <em>Equipment Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentRef()
	 * @generated
	 * @ordered
	 */
	protected Equipment equipmentRef;

	/**
	 * The cached value of the '{@link #getFunctionRef() <em>Function Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionRef()
	 * @generated
	 * @ordered
	 */
	protected Function functionRef;

	/**
	 * The cached value of the '{@link #getMarkerValueRef() <em>Marker Value Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkerValueRef()
	 * @generated
	 * @ordered
	 */
	protected Value markerValueRef;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final MarkerKind KIND_EDEFAULT = MarkerKind.VALUE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected MarkerKind kind = KIND_EDEFAULT;

	/**
	 * This is true if the Kind attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean kindESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.MARKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment getEquipmentRef() {
		if (equipmentRef != null && equipmentRef.eIsProxy()) {
			InternalEObject oldEquipmentRef = (InternalEObject)equipmentRef;
			equipmentRef = (Equipment)eResolveProxy(oldEquipmentRef);
			if (equipmentRef != oldEquipmentRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.MARKER__EQUIPMENT_REF, oldEquipmentRef, equipmentRef));
			}
		}
		return equipmentRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment basicGetEquipmentRef() {
		return equipmentRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentRef(Equipment newEquipmentRef) {
		Equipment oldEquipmentRef = equipmentRef;
		equipmentRef = newEquipmentRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.MARKER__EQUIPMENT_REF, oldEquipmentRef, equipmentRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunctionRef() {
		if (functionRef != null && functionRef.eIsProxy()) {
			InternalEObject oldFunctionRef = (InternalEObject)functionRef;
			functionRef = (Function)eResolveProxy(oldFunctionRef);
			if (functionRef != oldFunctionRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.MARKER__FUNCTION_REF, oldFunctionRef, functionRef));
			}
		}
		return functionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetFunctionRef() {
		return functionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionRef(Function newFunctionRef) {
		Function oldFunctionRef = functionRef;
		functionRef = newFunctionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.MARKER__FUNCTION_REF, oldFunctionRef, functionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value getMarkerValueRef() {
		if (markerValueRef != null && markerValueRef.eIsProxy()) {
			InternalEObject oldMarkerValueRef = (InternalEObject)markerValueRef;
			markerValueRef = (Value)eResolveProxy(oldMarkerValueRef);
			if (markerValueRef != oldMarkerValueRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.MARKER__MARKER_VALUE_REF, oldMarkerValueRef, markerValueRef));
			}
		}
		return markerValueRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value basicGetMarkerValueRef() {
		return markerValueRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarkerValueRef(Value newMarkerValueRef) {
		Value oldMarkerValueRef = markerValueRef;
		markerValueRef = newMarkerValueRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.MARKER__MARKER_VALUE_REF, oldMarkerValueRef, markerValueRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.MARKER__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkerKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(MarkerKind newKind) {
		MarkerKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		boolean oldKindESet = kindESet;
		kindESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.MARKER__KIND, oldKind, kind, !oldKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetKind() {
		MarkerKind oldKind = kind;
		boolean oldKindESet = kindESet;
		kind = KIND_EDEFAULT;
		kindESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OperatorsPackage.MARKER__KIND, oldKind, KIND_EDEFAULT, oldKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKind() {
		return kindESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorsPackage.MARKER__EQUIPMENT_REF:
				if (resolve) return getEquipmentRef();
				return basicGetEquipmentRef();
			case OperatorsPackage.MARKER__FUNCTION_REF:
				if (resolve) return getFunctionRef();
				return basicGetFunctionRef();
			case OperatorsPackage.MARKER__MARKER_VALUE_REF:
				if (resolve) return getMarkerValueRef();
				return basicGetMarkerValueRef();
			case OperatorsPackage.MARKER__DESCRIPTION:
				return getDescription();
			case OperatorsPackage.MARKER__KIND:
				return getKind();
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
			case OperatorsPackage.MARKER__EQUIPMENT_REF:
				setEquipmentRef((Equipment)newValue);
				return;
			case OperatorsPackage.MARKER__FUNCTION_REF:
				setFunctionRef((Function)newValue);
				return;
			case OperatorsPackage.MARKER__MARKER_VALUE_REF:
				setMarkerValueRef((Value)newValue);
				return;
			case OperatorsPackage.MARKER__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case OperatorsPackage.MARKER__KIND:
				setKind((MarkerKind)newValue);
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
			case OperatorsPackage.MARKER__EQUIPMENT_REF:
				setEquipmentRef((Equipment)null);
				return;
			case OperatorsPackage.MARKER__FUNCTION_REF:
				setFunctionRef((Function)null);
				return;
			case OperatorsPackage.MARKER__MARKER_VALUE_REF:
				setMarkerValueRef((Value)null);
				return;
			case OperatorsPackage.MARKER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case OperatorsPackage.MARKER__KIND:
				unsetKind();
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
			case OperatorsPackage.MARKER__EQUIPMENT_REF:
				return equipmentRef != null;
			case OperatorsPackage.MARKER__FUNCTION_REF:
				return functionRef != null;
			case OperatorsPackage.MARKER__MARKER_VALUE_REF:
				return markerValueRef != null;
			case OperatorsPackage.MARKER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case OperatorsPackage.MARKER__KIND:
				return isSetKind();
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
		result.append(" (description: ");
		result.append(description);
		result.append(", kind: ");
		if (kindESet) result.append(kind); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MarkerImpl
