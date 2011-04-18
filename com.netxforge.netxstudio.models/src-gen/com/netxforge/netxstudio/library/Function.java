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

import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.MultiImage;

import com.netxforge.netxstudio.metrics.Metric;

import com.netxforge.netxstudio.operators.FunctionRelationship;

import com.netxforge.netxstudio.protocols.Protocol;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a function in an a telecom equipment. This is often also referred to as a Application, 
 * or a Logical Function
 * Specifically it represents the Software portion. (The Hardware is represented by the Equipment type). 
 * Function types can be nested to form a hiarchical structure in similar fashion to a real Software anatomy.
 * 
 * The Function type (and/or it's children) is first part of the Library type, and then copied into a Node type when 
 * created.
 * 
 * Examples:
 * 1. The Function type typical structure is: System -> Subsystem -> Module etc..
 * 2. The Function type can be "Mobility Management".			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getFunctionResources <em>Function Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getFunctionMetricRefs <em>Function Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getFunctionRelationshipRefs <em>Function Relationship Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getFunctionExpressionRefs <em>Function Expression Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getProtocolRefs <em>Protocol Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getAllFunctionResources <em>All Function Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getAllFunctions <em>All Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Function#getFunctionName <em>Function Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='\n\t\t\t\tValidFunctionName\n\t\t\t'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ValidFunctionName='\n\t\t\t\tnot self.functionName.oclIsUndefined()\n\t\t\t'"
 *        extendedMetaData="name='Function' kind='elementOnly'"
 * @generated
 */
public interface Function extends EObject {
	/**
	 * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.DiagramInfo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Diagrams reference, contains 0 or more DiagramInfo types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Diagrams</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_Diagrams()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Diagrams'"
	 * @generated
	 */
	EList<DiagramInfo> getDiagrams();

	/**
	 * Returns the value of the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Images reference, contains 0 or one MultiImage type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Icons</em>' containment reference.
	 * @see #setIcons(MultiImage)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_Icons()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Icons'"
	 * @generated
	 */
	MultiImage getIcons();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Function#getIcons <em>Icons</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icons</em>' containment reference.
	 * @see #getIcons()
	 * @generated
	 */
	void setIcons(MultiImage value);

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Functions reference, contains 0 or more Function types.	
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_Functions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Functions'"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Function Resources</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NetXResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FunctionResources reference, contains 0 or more Resource types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Resources</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_FunctionResources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='FunctionResources'"
	 * @generated
	 */
	EList<NetXResource> getFunctionResources();

	/**
	 * Returns the value of the '<em><b>Function Metric Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FunctionMetricRefs reference, refers to 0 or more Metric types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Metric Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_FunctionMetricRefs()
	 * @model extendedMetaData="kind='element' name='FunctionMetricRefs'"
	 * @generated
	 */
	EList<Metric> getFunctionMetricRefs();

	/**
	 * Returns the value of the '<em><b>Function Relationship Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.FunctionRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FunctionRelationshipRefs reference, refers to 0 or more FunctionRelationship types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Relationship Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_FunctionRelationshipRefs()
	 * @model extendedMetaData="kind='element' name='FunctionRelationshipRefs'"
	 * @generated
	 */
	EList<FunctionRelationship> getFunctionRelationshipRefs();

	/**
	 * Returns the value of the '<em><b>Function Expression Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Expression}.
	 * It is bidirectional and its opposite is '{@link com.netxforge.netxstudio.library.Expression#getFunctionRefs <em>Function Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FunctionExpressionRefs reference, refers to 0 or more Expression types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Expression Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_FunctionExpressionRefs()
	 * @see com.netxforge.netxstudio.library.Expression#getFunctionRefs
	 * @model opposite="functionRefs"
	 *        extendedMetaData="kind='element' name='FunctionExpressionRefs'"
	 * @generated
	 */
	EList<Expression> getFunctionExpressionRefs();

	/**
	 * Returns the value of the '<em><b>Tolerance Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Tolerance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ToleranceRefs reference, refers to 0 or more Tolerance types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tolerance Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_ToleranceRefs()
	 * @model extendedMetaData="kind='element' name='ToleranceRefs'"
	 * @generated
	 */
	EList<Tolerance> getToleranceRefs();

	/**
	 * Returns the value of the '<em><b>Protocol Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.protocols.Protocol}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ProtocolRefs reference, refers to 0 or more Protocol types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protocol Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_ProtocolRefs()
	 * @model extendedMetaData="kind='element' name='ProtocolRefs'"
	 * @generated
	 */
	EList<Protocol> getProtocolRefs();

	/**
	 * Returns the value of the '<em><b>Parameter Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ParameterRefs reference, refers to 0 or more Parameter types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_ParameterRefs()
	 * @model extendedMetaData="kind='element' name='ParameterRefs'"
	 * @generated
	 */
	EList<Parameter> getParameterRefs();

	/**
	 * Returns the value of the '<em><b>All Function Resources</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NetXResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OCL derived feature: Retrieves all resources
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>All Function Resources</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_AllFunctionResources()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self->closure(functions).functionResources->asOrderedSet()\n\t\t\t\t\t'"
	 *        extendedMetaData="kind='element' name='AllFunctionResources'"
	 * @generated
	 */
	EList<NetXResource> getAllFunctionResources();

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

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description of the function.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Function#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FunctionName attribute holds the name of the function.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Name</em>' attribute.
	 * @see #setFunctionName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getFunction_FunctionName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='FunctionName'"
	 * @generated
	 */
	String getFunctionName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Function#getFunctionName <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Name</em>' attribute.
	 * @see #getFunctionName()
	 * @generated
	 */
	void setFunctionName(String value);

} // Function
