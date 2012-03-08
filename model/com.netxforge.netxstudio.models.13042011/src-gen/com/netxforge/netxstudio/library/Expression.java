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

import com.netxforge.netxstudio.generics.Base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a NetXScript expression.
 * 				NetXScript is an expression grammar, which is capable
 * 				to process
 * 				objects in the NetXStudio data model. Expressions belong to
 * 				various
 * 				types, like Equipment,
 * 				EquipmentGroup and Function. The NetXStudio
 * 				application defines, when the
 * 				expression is evaluated.
 * 
 * 				See: The
 * 				NetXScript specification.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.Expression#getExpressionLines <em>Expression Lines</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Expression#getEvaluationObject <em>Evaluation Object</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Expression#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpression()
 * @model extendedMetaData="name='Expression' kind='elementOnly'"
 * @generated
 */
public interface Expression extends Base {
	/**
	 * Returns the value of the '<em><b>Expression Lines</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ExpressionLines reference, contains 0 or
	 * 								more
	 * 								ExpressionLine types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression Lines</em>' attribute list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpression_ExpressionLines()
	 * @model unique="false" dataType="com.netxforge.netxstudio.generics.ExpressionLine"
	 *        extendedMetaData="kind='element' name='ExpressionLines'"
	 * @generated
	 */
	EList<String> getExpressionLines();

	/**
	 * Returns the value of the '<em><b>Evaluation Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EvaluationObject reference holds 0 or 1
	 * 								EObject type
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Evaluation Object</em>' reference.
	 * @see #setEvaluationObject(EObject)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpression_EvaluationObject()
	 * @model extendedMetaData="kind='element' name='EvaluationObject'"
	 * @generated
	 */
	EObject getEvaluationObject();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Expression#getEvaluationObject <em>Evaluation Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation Object</em>' reference.
	 * @see #getEvaluationObject()
	 * @generated
	 */
	void setEvaluationObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the
	 * 							expression.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getExpression_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Expression#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Expression
