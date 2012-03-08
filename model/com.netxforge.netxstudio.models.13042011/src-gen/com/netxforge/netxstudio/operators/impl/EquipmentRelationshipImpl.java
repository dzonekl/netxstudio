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

import org.eclipse.emf.ecore.EClass;

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
		return (Equipment)eGet(OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipment1Ref(Equipment newEquipment1Ref) {
		eSet(OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF, newEquipment1Ref);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment getEquipment2Ref() {
		return (Equipment)eGet(OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipment2Ref(Equipment newEquipment2Ref) {
		eSet(OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF, newEquipment2Ref);
	}

} //EquipmentRelationshipImpl
