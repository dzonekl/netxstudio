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

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Marker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A type representing a resource marker. The marker
 * 				references a value and an Equipment or Function.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.Marker#getValueRef <em>Value Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Marker#getMarkerResourceRef <em>Marker Resource Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Marker#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Marker#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getMarker()
 * @model extendedMetaData="name='Marker' kind='elementOnly'"
 * @generated
 */
public interface Marker extends Base {
	/**
	 * Returns the value of the '<em><b>Value Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ValueRef reference, references 0 or 1
	 * 								Values.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Ref</em>' reference.
	 * @see #setValueRef(Value)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getMarker_ValueRef()
	 * @model extendedMetaData="kind='element' name='ValueRef'"
	 * @generated
	 */
	Value getValueRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Marker#getValueRef <em>Value Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Ref</em>' reference.
	 * @see #getValueRef()
	 * @generated
	 */
	void setValueRef(Value value);

	/**
	 * Returns the value of the '<em><b>Marker Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MarkerResource reference, references 0 or 1
	 * 								Resource type
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Marker Resource Ref</em>' reference.
	 * @see #setMarkerResourceRef(NetXResource)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getMarker_MarkerResourceRef()
	 * @model extendedMetaData="kind='element' name='MarkerResourceRef'"
	 * @generated
	 */
	NetXResource getMarkerResourceRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Marker#getMarkerResourceRef <em>Marker Resource Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marker Resource Ref</em>' reference.
	 * @see #getMarkerResourceRef()
	 * @generated
	 */
	void setMarkerResourceRef(NetXResource value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description
	 * 							for this marker.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getMarker_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Marker#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.operators.MarkerKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Kind attribute holds the kind of Marker this
	 * 							Marker is. (See MarkerKind).
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.operators.MarkerKind
	 * @see #isSetKind()
	 * @see #unsetKind()
	 * @see #setKind(MarkerKind)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getMarker_Kind()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Kind'"
	 * @generated
	 */
	MarkerKind getKind();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Marker#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.operators.MarkerKind
	 * @see #isSetKind()
	 * @see #unsetKind()
	 * @see #getKind()
	 * @generated
	 */
	void setKind(MarkerKind value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.operators.Marker#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKind()
	 * @see #getKind()
	 * @see #setKind(MarkerKind)
	 * @generated
	 */
	void unsetKind();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.operators.Marker#getKind <em>Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Kind</em>' attribute is set.
	 * @see #unsetKind()
	 * @see #getKind()
	 * @see #setKind(MarkerKind)
	 * @generated
	 */
	boolean isSetKind();

} // Marker
