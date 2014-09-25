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
package com.netxforge.netxstudio.library;

import com.netxforge.netxstudio.generics.Value;

import com.netxforge.netxstudio.metrics.KindHintType;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetIntervalHint <em>Target Interval Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetKindHint <em>Target Kind Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpressionResult()
 * @model extendedMetaData="name='ExpressionResult' kind='elementOnly'"
 * @generated
 */
public interface ExpressionResult extends BaseExpressionResult {
	/**
	 * Returns the value of the '<em><b>Target Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Resource</em>' reference.
	 * @see #setTargetResource(BaseResource)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpressionResult_TargetResource()
	 * @model extendedMetaData="kind='element' name='TargetResource'"
	 * @generated
	 */
	BaseResource getTargetResource();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetResource <em>Target Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Resource</em>' reference.
	 * @see #getTargetResource()
	 * @generated
	 */
	void setTargetResource(BaseResource value);

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

	/**
	 * Returns the value of the '<em><b>Target Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Interval Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Interval Hint</em>' attribute.
	 * @see #isSetTargetIntervalHint()
	 * @see #unsetTargetIntervalHint()
	 * @see #setTargetIntervalHint(int)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpressionResult_TargetIntervalHint()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='TargetIntervalHint'"
	 * @generated
	 */
	int getTargetIntervalHint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetIntervalHint <em>Target Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Interval Hint</em>' attribute.
	 * @see #isSetTargetIntervalHint()
	 * @see #unsetTargetIntervalHint()
	 * @see #getTargetIntervalHint()
	 * @generated
	 */
	void setTargetIntervalHint(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetIntervalHint <em>Target Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTargetIntervalHint()
	 * @see #getTargetIntervalHint()
	 * @see #setTargetIntervalHint(int)
	 * @generated
	 */
	void unsetTargetIntervalHint();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetIntervalHint <em>Target Interval Hint</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Target Interval Hint</em>' attribute is set.
	 * @see #unsetTargetIntervalHint()
	 * @see #getTargetIntervalHint()
	 * @see #setTargetIntervalHint(int)
	 * @generated
	 */
	boolean isSetTargetIntervalHint();

	/**
	 * Returns the value of the '<em><b>Target Kind Hint</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.metrics.KindHintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Kind Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Kind Hint</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @see #isSetTargetKindHint()
	 * @see #unsetTargetKindHint()
	 * @see #setTargetKindHint(KindHintType)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpressionResult_TargetKindHint()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='TargetKindHint'"
	 * @generated
	 */
	KindHintType getTargetKindHint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetKindHint <em>Target Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Kind Hint</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @see #isSetTargetKindHint()
	 * @see #unsetTargetKindHint()
	 * @see #getTargetKindHint()
	 * @generated
	 */
	void setTargetKindHint(KindHintType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetKindHint <em>Target Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTargetKindHint()
	 * @see #getTargetKindHint()
	 * @see #setTargetKindHint(KindHintType)
	 * @generated
	 */
	void unsetTargetKindHint();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetKindHint <em>Target Kind Hint</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Target Kind Hint</em>' attribute is set.
	 * @see #unsetTargetKindHint()
	 * @see #getTargetKindHint()
	 * @see #setTargetKindHint(KindHintType)
	 * @generated
	 */
	boolean isSetTargetKindHint();

} // ExpressionResult
