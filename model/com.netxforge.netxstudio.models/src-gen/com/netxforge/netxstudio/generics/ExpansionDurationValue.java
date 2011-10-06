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
package com.netxforge.netxstudio.generics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expansion Duration Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a single expansion duration
 * 				value.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.ExpansionDurationValue#getExpansionDuration <em>Expansion Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.ExpansionDurationValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.generics.GenericsPackage#getExpansionDurationValue()
 * @model extendedMetaData="name='ExpansionDurationValue' kind='empty'"
 * @generated
 */
public interface ExpansionDurationValue extends Base {
	/**
	 * Returns the value of the '<em><b>Expansion Duration</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.generics.ExpansionDuration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expansion Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expansion Duration</em>' attribute.
	 * @see com.netxforge.netxstudio.generics.ExpansionDuration
	 * @see #isSetExpansionDuration()
	 * @see #unsetExpansionDuration()
	 * @see #setExpansionDuration(ExpansionDuration)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getExpansionDurationValue_ExpansionDuration()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ExpansionDuration'"
	 * @generated
	 */
	ExpansionDuration getExpansionDuration();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationValue#getExpansionDuration <em>Expansion Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expansion Duration</em>' attribute.
	 * @see com.netxforge.netxstudio.generics.ExpansionDuration
	 * @see #isSetExpansionDuration()
	 * @see #unsetExpansionDuration()
	 * @see #getExpansionDuration()
	 * @generated
	 */
	void setExpansionDuration(ExpansionDuration value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationValue#getExpansionDuration <em>Expansion Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpansionDuration()
	 * @see #getExpansionDuration()
	 * @see #setExpansionDuration(ExpansionDuration)
	 * @generated
	 */
	void unsetExpansionDuration();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationValue#getExpansionDuration <em>Expansion Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expansion Duration</em>' attribute is set.
	 * @see #unsetExpansionDuration()
	 * @see #getExpansionDuration()
	 * @see #setExpansionDuration(ExpansionDuration)
	 * @generated
	 */
	boolean isSetExpansionDuration();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Value attribute is the number of days an
	 * 							expansion will take before completed and in production.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #isSetValue()
	 * @see #unsetValue()
	 * @see #setValue(int)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getExpansionDurationValue_Value()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='Value'"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #isSetValue()
	 * @see #unsetValue()
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValue()
	 * @see #getValue()
	 * @see #setValue(int)
	 * @generated
	 */
	void unsetValue();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.generics.ExpansionDurationValue#getValue <em>Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value</em>' attribute is set.
	 * @see #unsetValue()
	 * @see #getValue()
	 * @see #setValue(int)
	 * @generated
	 */
	boolean isSetValue();

} // ExpansionDurationValue
