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
package com.netxforge.netxstudio.library.impl;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.EquipmentGroup;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.RedundancyType;
import com.netxforge.netxstudio.library.StateType;

import com.netxforge.netxstudio.operators.EquipmentRelationship;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equipment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipments <em>Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentGroups <em>Equipment Groups</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentRelationshipRefs <em>Equipment Relationship Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getAllEquipments <em>All Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getCount <em>Count</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentCode <em>Equipment Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getRedundancy <em>Redundancy</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquipmentImpl extends ComponentImpl implements Equipment {
	/**
	 * The cached value of the '{@link #getEquipments() <em>Equipments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipments()
	 * @generated
	 * @ordered
	 */
	protected EList<Equipment> equipments;

	/**
	 * The cached value of the '{@link #getEquipmentGroups() <em>Equipment Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<EquipmentGroup> equipmentGroups;

	/**
	 * The cached value of the '{@link #getEquipmentRelationshipRefs() <em>Equipment Relationship Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentRelationshipRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<EquipmentRelationship> equipmentRelationshipRefs;

	/**
	 * The cached setting delegate for the '{@link #getAllEquipments() <em>All Equipments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllEquipments()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ALL_EQUIPMENTS__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.EQUIPMENT__ALL_EQUIPMENTS).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate COUNT__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.EQUIPMENT__COUNT).getSettingDelegate();

	/**
	 * The default value of the '{@link #getEquipmentCode() <em>Equipment Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentCode()
	 * @generated
	 * @ordered
	 */
	protected static final String EQUIPMENT_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEquipmentCode() <em>Equipment Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentCode()
	 * @generated
	 * @ordered
	 */
	protected String equipmentCode = EQUIPMENT_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final String POSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected String position = POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRedundancy() <em>Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedundancy()
	 * @generated
	 * @ordered
	 */
	protected static final RedundancyType REDUNDANCY_EDEFAULT = RedundancyType.N;

	/**
	 * The cached value of the '{@link #getRedundancy() <em>Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedundancy()
	 * @generated
	 * @ordered
	 */
	protected RedundancyType redundancy = REDUNDANCY_EDEFAULT;

	/**
	 * This is true if the Redundancy attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean redundancyESet;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final StateType STATE_EDEFAULT = StateType.ACTIVE;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected StateType state = STATE_EDEFAULT;

	/**
	 * This is true if the State attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean stateESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquipmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.EQUIPMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Equipment> getEquipments() {
		if (equipments == null) {
			equipments = new EObjectContainmentEList<Equipment>(Equipment.class, this, LibraryPackage.EQUIPMENT__EQUIPMENTS);
		}
		return equipments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquipmentGroup> getEquipmentGroups() {
		if (equipmentGroups == null) {
			equipmentGroups = new EObjectContainmentEList<EquipmentGroup>(EquipmentGroup.class, this, LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS);
		}
		return equipmentGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquipmentRelationship> getEquipmentRelationshipRefs() {
		if (equipmentRelationshipRefs == null) {
			equipmentRelationshipRefs = new EObjectResolvingEList<EquipmentRelationship>(EquipmentRelationship.class, this, LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS);
		}
		return equipmentRelationshipRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Equipment> getAllEquipments() {
		return (EList<Equipment>)ALL_EQUIPMENTS__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCount() {
		return (Integer)COUNT__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(int newCount) {
		COUNT__ESETTING_DELEGATE.dynamicSet(this, null, 0, newCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCount() {
		COUNT__ESETTING_DELEGATE.dynamicUnset(this, null, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCount() {
		return COUNT__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEquipmentCode() {
		return equipmentCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentCode(String newEquipmentCode) {
		String oldEquipmentCode = equipmentCode;
		equipmentCode = newEquipmentCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__EQUIPMENT_CODE, oldEquipmentCode, equipmentCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(String newPosition) {
		String oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyType getRedundancy() {
		return redundancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedundancy(RedundancyType newRedundancy) {
		RedundancyType oldRedundancy = redundancy;
		redundancy = newRedundancy == null ? REDUNDANCY_EDEFAULT : newRedundancy;
		boolean oldRedundancyESet = redundancyESet;
		redundancyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__REDUNDANCY, oldRedundancy, redundancy, !oldRedundancyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRedundancy() {
		RedundancyType oldRedundancy = redundancy;
		boolean oldRedundancyESet = redundancyESet;
		redundancy = REDUNDANCY_EDEFAULT;
		redundancyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.EQUIPMENT__REDUNDANCY, oldRedundancy, REDUNDANCY_EDEFAULT, oldRedundancyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRedundancy() {
		return redundancyESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(StateType newState) {
		StateType oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		boolean oldStateESet = stateESet;
		stateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__STATE, oldState, state, !oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetState() {
		StateType oldState = state;
		boolean oldStateESet = stateESet;
		state = STATE_EDEFAULT;
		stateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.EQUIPMENT__STATE, oldState, STATE_EDEFAULT, oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetState() {
		return stateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				return ((InternalEList<?>)getEquipments()).basicRemove(otherEnd, msgs);
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				return ((InternalEList<?>)getEquipmentGroups()).basicRemove(otherEnd, msgs);
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
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				return getEquipments();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				return getEquipmentGroups();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS:
				return getEquipmentRelationshipRefs();
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENTS:
				return getAllEquipments();
			case LibraryPackage.EQUIPMENT__COUNT:
				return getCount();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_CODE:
				return getEquipmentCode();
			case LibraryPackage.EQUIPMENT__POSITION:
				return getPosition();
			case LibraryPackage.EQUIPMENT__REDUNDANCY:
				return getRedundancy();
			case LibraryPackage.EQUIPMENT__STATE:
				return getState();
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
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				getEquipments().clear();
				getEquipments().addAll((Collection<? extends Equipment>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				getEquipmentGroups().clear();
				getEquipmentGroups().addAll((Collection<? extends EquipmentGroup>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS:
				getEquipmentRelationshipRefs().clear();
				getEquipmentRelationshipRefs().addAll((Collection<? extends EquipmentRelationship>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENTS:
				getAllEquipments().clear();
				getAllEquipments().addAll((Collection<? extends Equipment>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__COUNT:
				setCount((Integer)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_CODE:
				setEquipmentCode((String)newValue);
				return;
			case LibraryPackage.EQUIPMENT__POSITION:
				setPosition((String)newValue);
				return;
			case LibraryPackage.EQUIPMENT__REDUNDANCY:
				setRedundancy((RedundancyType)newValue);
				return;
			case LibraryPackage.EQUIPMENT__STATE:
				setState((StateType)newValue);
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
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				getEquipments().clear();
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				getEquipmentGroups().clear();
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS:
				getEquipmentRelationshipRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENTS:
				getAllEquipments().clear();
				return;
			case LibraryPackage.EQUIPMENT__COUNT:
				unsetCount();
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_CODE:
				setEquipmentCode(EQUIPMENT_CODE_EDEFAULT);
				return;
			case LibraryPackage.EQUIPMENT__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case LibraryPackage.EQUIPMENT__REDUNDANCY:
				unsetRedundancy();
				return;
			case LibraryPackage.EQUIPMENT__STATE:
				unsetState();
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
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				return equipments != null && !equipments.isEmpty();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				return equipmentGroups != null && !equipmentGroups.isEmpty();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS:
				return equipmentRelationshipRefs != null && !equipmentRelationshipRefs.isEmpty();
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENTS:
				return ALL_EQUIPMENTS__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case LibraryPackage.EQUIPMENT__COUNT:
				return isSetCount();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_CODE:
				return EQUIPMENT_CODE_EDEFAULT == null ? equipmentCode != null : !EQUIPMENT_CODE_EDEFAULT.equals(equipmentCode);
			case LibraryPackage.EQUIPMENT__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
			case LibraryPackage.EQUIPMENT__REDUNDANCY:
				return isSetRedundancy();
			case LibraryPackage.EQUIPMENT__STATE:
				return isSetState();
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
		result.append(" (equipmentCode: ");
		result.append(equipmentCode);
		result.append(", position: ");
		result.append(position);
		result.append(", redundancy: ");
		if (redundancyESet) result.append(redundancy); else result.append("<unset>");
		result.append(", state: ");
		if (stateESet) result.append(state); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EquipmentImpl
