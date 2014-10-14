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
package com.netxforge.netxstudio.operators;

import com.netxforge.netxstudio.library.Equipment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equipment Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				an equipment relationship. (Also known as a Physical Connection).
 * 				The EquipmentRelationship type extends the Relationship type and
 * 				contains references to a first and second equipment.
 * 
 * 				Examples:
 * 				1. A
 * 				Relationship between two Equipment representing a connection.
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.EquipmentRelationship#getEquipment1Ref <em>Equipment1 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.EquipmentRelationship#getEquipment2Ref <em>Equipment2 Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getEquipmentRelationship()
 * @model extendedMetaData="name='EquipmentRelationship' kind='empty'"
 * @generated
 */
public interface EquipmentRelationship extends Relationship {
	/**
	 * Returns the value of the '<em><b>Equipment1 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Equipment1Ref reference, references 1
	 * 							Equipment type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment1 Ref</em>' reference.
	 * @see #setEquipment1Ref(Equipment)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getEquipmentRelationship_Equipment1Ref()
	 * @model extendedMetaData="kind='attribute' name='Equipment1Ref'"
	 * @generated
	 */
	Equipment getEquipment1Ref();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.EquipmentRelationship#getEquipment1Ref <em>Equipment1 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equipment1 Ref</em>' reference.
	 * @see #getEquipment1Ref()
	 * @generated
	 */
	void setEquipment1Ref(Equipment value);

	/**
	 * Returns the value of the '<em><b>Equipment2 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Equipment2Ref reference, references 1
	 * 							Equipment type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment2 Ref</em>' reference.
	 * @see #setEquipment2Ref(Equipment)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getEquipmentRelationship_Equipment2Ref()
	 * @model extendedMetaData="kind='attribute' name='Equipment2Ref'"
	 * @generated
	 */
	Equipment getEquipment2Ref();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.EquipmentRelationship#getEquipment2Ref <em>Equipment2 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equipment2 Ref</em>' reference.
	 * @see #getEquipment2Ref()
	 * @generated
	 */
	void setEquipment2Ref(Equipment value);

} // EquipmentRelationship
