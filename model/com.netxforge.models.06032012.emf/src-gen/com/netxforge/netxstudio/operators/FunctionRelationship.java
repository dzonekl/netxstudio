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

import com.netxforge.netxstudio.library.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a function relationship. (Also known as a Logical Connection).
 * 				The
 * 				FunctionRelationship type extends the Relationship type and
 * 				contains
 * 				references to a first and second function.
 * 
 * 				Examples:
 * 				1. A Relationship
 * 				between two functions representing a logical
 * 				connection.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.FunctionRelationship#getFunction1Ref <em>Function1 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.FunctionRelationship#getFunction2Ref <em>Function2 Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getFunctionRelationship()
 * @model extendedMetaData="name='FunctionRelationship' kind='empty'"
 * @generated
 */
public interface FunctionRelationship extends Relationship {
	/**
	 * Returns the value of the '<em><b>Function1 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Function1Ref reference, references 1
	 * 							function type.
	 * 
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function1 Ref</em>' reference.
	 * @see #setFunction1Ref(Function)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getFunctionRelationship_Function1Ref()
	 * @model extendedMetaData="kind='attribute' name='Function1Ref'"
	 * @generated
	 */
	Function getFunction1Ref();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.FunctionRelationship#getFunction1Ref <em>Function1 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function1 Ref</em>' reference.
	 * @see #getFunction1Ref()
	 * @generated
	 */
	void setFunction1Ref(Function value);

	/**
	 * Returns the value of the '<em><b>Function2 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Function2Ref reference, references 1
	 * 							function type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function2 Ref</em>' reference.
	 * @see #setFunction2Ref(Function)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getFunctionRelationship_Function2Ref()
	 * @model extendedMetaData="kind='attribute' name='Function2Ref'"
	 * @generated
	 */
	Function getFunction2Ref();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.FunctionRelationship#getFunction2Ref <em>Function2 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function2 Ref</em>' reference.
	 * @see #getFunction2Ref()
	 * @generated
	 */
	void setFunction2Ref(Function value);

} // FunctionRelationship
