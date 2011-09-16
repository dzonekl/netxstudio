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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Last Evaluation Expression Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the result of th of an expression
 * 				run.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.LastEvaluationExpressionResult#getLastEvalResult <em>Last Eval Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getLastEvaluationExpressionResult()
 * @model extendedMetaData="name='LastEvaluationExpressionResult' kind='elementOnly'"
 * @generated
 */
public interface LastEvaluationExpressionResult extends BaseExpressionResult {
	/**
	 * Returns the value of the '<em><b>Last Eval Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Eval Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Eval Result</em>' attribute.
	 * @see #setLastEvalResult(Object)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLastEvaluationExpressionResult_LastEvalResult()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='element' name='LastEvalResult'"
	 * @generated
	 */
	Object getLastEvalResult();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.LastEvaluationExpressionResult#getLastEvalResult <em>Last Eval Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Eval Result</em>' attribute.
	 * @see #getLastEvalResult()
	 * @generated
	 */
	void setLastEvalResult(Object value);

} // LastEvaluationExpressionResult
