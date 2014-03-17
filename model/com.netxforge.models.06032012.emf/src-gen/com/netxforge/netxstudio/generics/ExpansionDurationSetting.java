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
package com.netxforge.netxstudio.generics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expansion Duration Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the complete settings of an expansion duration. 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.ExpansionDurationSetting#getQuickDuration <em>Quick Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.ExpansionDurationSetting#getShortDuration <em>Short Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.ExpansionDurationSetting#getMediumDuration <em>Medium Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.ExpansionDurationSetting#getLongDuration <em>Long Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.generics.GenericsPackage#getExpansionDurationSetting()
 * @model extendedMetaData="name='ExpansionDurationSetting' kind='elementOnly'"
 * @generated
 */
public interface ExpansionDurationSetting extends Base {
	/**
	 * Returns the value of the '<em><b>Quick Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of the QUICK Duration
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Quick Duration</em>' containment reference.
	 * @see #setQuickDuration(ExpansionDurationValue)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getExpansionDurationSetting_QuickDuration()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='QuickDuration'"
	 * @generated
	 */
	ExpansionDurationValue getQuickDuration();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationSetting#getQuickDuration <em>Quick Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quick Duration</em>' containment reference.
	 * @see #getQuickDuration()
	 * @generated
	 */
	void setQuickDuration(ExpansionDurationValue value);

	/**
	 * Returns the value of the '<em><b>Short Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of the SHORT Duration
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Short Duration</em>' containment reference.
	 * @see #setShortDuration(ExpansionDurationValue)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getExpansionDurationSetting_ShortDuration()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ShortDuration'"
	 * @generated
	 */
	ExpansionDurationValue getShortDuration();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationSetting#getShortDuration <em>Short Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Duration</em>' containment reference.
	 * @see #getShortDuration()
	 * @generated
	 */
	void setShortDuration(ExpansionDurationValue value);

	/**
	 * Returns the value of the '<em><b>Medium Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of the MEDIUM Duration
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Medium Duration</em>' containment reference.
	 * @see #setMediumDuration(ExpansionDurationValue)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getExpansionDurationSetting_MediumDuration()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MediumDuration'"
	 * @generated
	 */
	ExpansionDurationValue getMediumDuration();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationSetting#getMediumDuration <em>Medium Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Medium Duration</em>' containment reference.
	 * @see #getMediumDuration()
	 * @generated
	 */
	void setMediumDuration(ExpansionDurationValue value);

	/**
	 * Returns the value of the '<em><b>Long Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of the LONG Duration
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Long Duration</em>' containment reference.
	 * @see #setLongDuration(ExpansionDurationValue)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getExpansionDurationSetting_LongDuration()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='LongDuration'"
	 * @generated
	 */
	ExpansionDurationValue getLongDuration();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationSetting#getLongDuration <em>Long Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Duration</em>' containment reference.
	 * @see #getLongDuration()
	 * @generated
	 */
	void setLongDuration(ExpansionDurationValue value);

} // ExpansionDurationSetting
