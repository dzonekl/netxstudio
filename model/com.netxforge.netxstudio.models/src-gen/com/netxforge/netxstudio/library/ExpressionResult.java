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
package com.netxforge.netxstudio.library;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the results of an expression
 * 				run.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetResource <em>Target Resource</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetRange <em>Target Range</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetValues <em>Target Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpressionResult()
 * @model annotation="teneo.jpa appinfo='@Transient'"
 *        extendedMetaData="name='ExpressionResult' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface ExpressionResult extends CDOObject {

	/**
	 * Returns the value of the '<em><b>Target Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Resource</em>' reference.
	 * @see #setTargetResource(NetXResource)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpressionResult_TargetResource()
	 * @model extendedMetaData="kind='element' name='TargetResource'"
	 * @generated
	 */
	NetXResource getTargetResource();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetResource <em>Target Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Resource</em>' reference.
	 * @see #getTargetResource()
	 * @generated
	 */
	void setTargetResource(NetXResource value);

	/**
	 * Returns the value of the '<em><b>Target Range</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.library.RangeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Range</em>' attribute.
	 * @see com.netxforge.netxstudio.library.RangeKind
	 * @see #isSetTargetRange()
	 * @see #unsetTargetRange()
	 * @see #setTargetRange(RangeKind)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpressionResult_TargetRange()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='element' name='TargetRange'"
	 * @generated
	 */
	RangeKind getTargetRange();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetRange <em>Target Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Range</em>' attribute.
	 * @see com.netxforge.netxstudio.library.RangeKind
	 * @see #isSetTargetRange()
	 * @see #unsetTargetRange()
	 * @see #getTargetRange()
	 * @generated
	 */
	void setTargetRange(RangeKind value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetRange <em>Target Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTargetRange()
	 * @see #getTargetRange()
	 * @see #setTargetRange(RangeKind)
	 * @generated
	 */
	void unsetTargetRange();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetRange <em>Target Range</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Target Range</em>' attribute is set.
	 * @see #unsetTargetRange()
	 * @see #getTargetRange()
	 * @see #setTargetRange(RangeKind)
	 * @generated
	 */
	boolean isSetTargetRange();

	/**
	 * Returns the value of the '<em><b>Target Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Value}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Values</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpressionResult_TargetValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='TargetValues'"
	 * @generated
	 */
	EList<Value> getTargetValues();
} // ExpressionResult
