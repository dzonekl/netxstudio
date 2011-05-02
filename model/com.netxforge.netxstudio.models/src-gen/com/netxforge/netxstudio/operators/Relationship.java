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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of a Relationship. This is also often referred to as a Connection or Link. 
 * Both Function and Equipment Relationship extend on this Base type. It holds both ends of the Node.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.Relationship#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Relationship#getNodeID1Ref <em>Node ID1 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Relationship#getNodeID2Ref <em>Node ID2 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Relationship#getProtocolRef <em>Protocol Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getRelationship()
 * @model extendedMetaData="name='Relationship' kind='empty'"
 * @generated
 */
public interface Relationship extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds a name used for presentation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getRelationship_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Relationship#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Node ID1 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The NodeID1Ref attribute, references a Node type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node ID1 Ref</em>' reference.
	 * @see #setNodeID1Ref(Node)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getRelationship_NodeID1Ref()
	 * @model extendedMetaData="kind='attribute' name='NodeID1Ref'"
	 * @generated
	 */
	Node getNodeID1Ref();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Relationship#getNodeID1Ref <em>Node ID1 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node ID1 Ref</em>' reference.
	 * @see #getNodeID1Ref()
	 * @generated
	 */
	void setNodeID1Ref(Node value);

	/**
	 * Returns the value of the '<em><b>Node ID2 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The NodeID1Ref attribute, references a Node type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node ID2 Ref</em>' reference.
	 * @see #setNodeID2Ref(Node)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getRelationship_NodeID2Ref()
	 * @model extendedMetaData="kind='attribute' name='NodeID2Ref'"
	 * @generated
	 */
	Node getNodeID2Ref();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Relationship#getNodeID2Ref <em>Node ID2 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node ID2 Ref</em>' reference.
	 * @see #getNodeID2Ref()
	 * @generated
	 */
	void setNodeID2Ref(Node value);

	/**
	 * Returns the value of the '<em><b>Protocol Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ProtocolRef reference, refers to 0 or 1 Protocol type.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protocol Ref</em>' reference.
	 * @see #setProtocolRef(EObject)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getRelationship_ProtocolRef()
	 * @model extendedMetaData="kind='attribute' name='ProtocolRef'"
	 * @generated
	 */
	EObject getProtocolRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Relationship#getProtocolRef <em>Protocol Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol Ref</em>' reference.
	 * @see #getProtocolRef()
	 * @generated
	 */
	void setProtocolRef(EObject value);

} // Relationship
