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

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.operators.FunctionRelationship;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a function in an a telecom
 * 				equipment. This is often also referred to as a Application,
 * 				or a
 * 				Logical Function
 * 				Specifically it represents the Software portion.
 * 				(The Hardware is represented by
 * 				the Equipment type).
 * 				Function types
 * 				can be nested to form a hiarchical structure in similar
 * 				fashion to a
 * 				real Software anatomy.
 * 
 * 				The Function type (and/or it's children) is
 * 				first part of the Library
 * 				type, and then copied into a Node type when
 * 				created.
 * 
 * 				Examples:
 * 				1. The Function type typical structure is: System
 * 				-> Subsystem ->
 * 				Module etc..
 * 				2. The Function type can be "Mobility
 * 				Management".
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getFunctionRelationshipRefs <em>Function Relationship Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getAllFunctions <em>All Functions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='\n\t\t\t\tValidFunctionName\n\t\t\t'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ValidFunctionName='\n\t\t\t\tnot self.functionName.oclIsUndefined()\n\t\t\t'"
 *        extendedMetaData="name='Function' kind='elementOnly'"
 * @generated
 */
public interface Function extends Component {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Functions reference, contains 0 or more
	 * 								Function types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_Functions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Functions'"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Function Relationship Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.FunctionRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FunctionRelationshipRefs reference, refers
	 * 								to 0 or more FunctionRelationship types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Relationship Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_FunctionRelationshipRefs()
	 * @model extendedMetaData="kind='element' name='FunctionRelationshipRefs'"
	 * @generated
	 */
	EList<FunctionRelationship> getFunctionRelationshipRefs();

	/**
	 * Returns the value of the '<em><b>All Functions</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OCL derived feature: Retrieve all functions
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>All Functions</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_AllFunctions()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self->closure(functions)->asOrderedSet()\n\t\t\t\t\t\t\t'"
	 *        extendedMetaData="kind='element' name='AllFunctions'"
	 * @generated
	 */
	EList<Function> getAllFunctions();

} // Function
