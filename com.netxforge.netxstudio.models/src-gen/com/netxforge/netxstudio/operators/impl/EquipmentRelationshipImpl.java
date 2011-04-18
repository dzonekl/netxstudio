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

import com.netxforge.netxstudio.library.Equipment;

import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.OperatorsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equipment Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.EquipmentRelationshipImpl#getEquipment1Ref <em>Equipment1 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.EquipmentRelationshipImpl#getEquipment2Ref <em>Equipment2 Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquipmentRelationshipImpl extends RelationshipImpl implements EquipmentRelationship {
	/**
	 * The cached value of the '{@link #getEquipment1Ref() <em>Equipment1 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipment1Ref()
	 * @generated
	 * @ordered
	 */
	protected Equipment equipment1Ref;

	/**
	 * The cached value of the '{@link #getEquipment2Ref() <em>Equipment2 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipment2Ref()
	 * @generated
	 * @ordered
	 */
	protected Equipment equipment2Ref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquipmentRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment getEquipment1Ref() {
		if (equipment1Ref != null && equipment1Ref.eIsProxy()) {
			InternalEObject oldEquipment1Ref = (InternalEObject)equipment1Ref;
			equipment1Ref = (Equipment)eResolveProxy(oldEquipment1Ref);
			if (equipment1Ref != oldEquipment1Ref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF, oldEquipment1Ref, equipment1Ref));
			}
		}
		return equipment1Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment basicGetEquipment1Ref() {
		return equipment1Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipment1Ref(Equipment newEquipment1Ref) {
		Equipment oldEquipment1Ref = equipment1Ref;
		equipment1Ref = newEquipment1Ref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF, oldEquipment1Ref, equipment1Ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment getEquipment2Ref() {
		if (equipment2Ref != null && equipment2Ref.eIsProxy()) {
			InternalEObject oldEquipment2Ref = (InternalEObject)equipment2Ref;
			equipment2Ref = (Equipment)eResolveProxy(oldEquipment2Ref);
			if (equipment2Ref != oldEquipment2Ref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF, oldEquipment2Ref, equipment2Ref));
			}
		}
		return equipment2Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment basicGetEquipment2Ref() {
		return equipment2Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipment2Ref(Equipment newEquipment2Ref) {
		Equipment oldEquipment2Ref = equipment2Ref;
		equipment2Ref = newEquipment2Ref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF, oldEquipment2Ref, equipment2Ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF:
				if (resolve) return getEquipment1Ref();
				return basicGetEquipment1Ref();
			case OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF:
				if (resolve) return getEquipment2Ref();
				return basicGetEquipment2Ref();
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
			case OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF:
				setEquipment1Ref((Equipment)newValue);
				return;
			case OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF:
				setEquipment2Ref((Equipment)newValue);
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
			case OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF:
				setEquipment1Ref((Equipment)null);
				return;
			case OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF:
				setEquipment2Ref((Equipment)null);
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
			case OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF:
				return equipment1Ref != null;
			case OperatorsPackage.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF:
				return equipment2Ref != null;
		}
		return super.eIsSet(featureID);
	}

} //EquipmentRelationshipImpl
