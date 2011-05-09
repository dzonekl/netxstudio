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
package com.netxforge.netxstudio.operators;

import org.eclipse.emf.cdo.CDOObject;

import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.library.Equipment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expansion Experience</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the gained experience on expending an equipment.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.ExpansionExperience#getEquipmentRef <em>Equipment Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.ExpansionExperience#getDuration <em>Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getExpansionExperience()
 * @model extendedMetaData="name='ExpansionExperience' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface ExpansionExperience extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Equipment Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentRef reference, references the 0 or 1 Equipment type, for which this duration applies.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Ref</em>' reference.
	 * @see #setEquipmentRef(Equipment)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getExpansionExperience_EquipmentRef()
	 * @model extendedMetaData="kind='element' name='EquipmentRef'"
	 * @generated
	 */
	Equipment getEquipmentRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.ExpansionExperience#getEquipmentRef <em>Equipment Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equipment Ref</em>' reference.
	 * @see #getEquipmentRef()
	 * @generated
	 */
	void setEquipmentRef(Equipment value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.generics.ExpansionDuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Duration attribute, holds the typical duration for the expansion of an Equipment. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see com.netxforge.netxstudio.generics.ExpansionDuration
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #setDuration(ExpansionDuration)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getExpansionExperience_Duration()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Duration'"
	 * @generated
	 */
	ExpansionDuration getDuration();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.ExpansionExperience#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see com.netxforge.netxstudio.generics.ExpansionDuration
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(ExpansionDuration value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.operators.ExpansionExperience#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuration()
	 * @see #getDuration()
	 * @see #setDuration(ExpansionDuration)
	 * @generated
	 */
	void unsetDuration();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.operators.ExpansionExperience#getDuration <em>Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duration</em>' attribute is set.
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @see #setDuration(ExpansionDuration)
	 * @generated
	 */
	boolean isSetDuration();

} // ExpansionExperience
