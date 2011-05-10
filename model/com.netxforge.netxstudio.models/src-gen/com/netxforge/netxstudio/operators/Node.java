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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.geo.Room;
import com.netxforge.netxstudio.library.NodeType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of a real telecommunications Node. This is also often referred
 * to as a Network Element.  A Node type is a real instance of a vendor equipment with functions. 
 * 
 * A Node, has a unique ID, it has a lifecycle. It is also placed in a Room.
 * 
 * Examples: 
 * 1. The AMSSGSN, is the ID of the Amsterdam SGSN Node.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.Node#getLifecycle <em>Lifecycle</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Node#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Node#getCreatedByRef <em>Created By Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Node#getNodeID <em>Node ID</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Node#getOriginalNodeTypeRef <em>Original Node Type Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Node#getRoomRef <em>Room Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNode()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='\n\t\t\t\tValidNodeID\n\t\t\t'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ValidNodeID='\n\t\t\t\tnot self.nodeID.oclIsUndefined()\n\t\t\t'"
 *        extendedMetaData="name='Node' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface Node extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Lifecycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Lifecycle reference, contains 0 or 1 Lifecycle types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lifecycle</em>' containment reference.
	 * @see #setLifecycle(Lifecycle)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNode_Lifecycle()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Lifecycle'"
	 * @generated
	 */
	Lifecycle getLifecycle();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Node#getLifecycle <em>Lifecycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lifecycle</em>' containment reference.
	 * @see #getLifecycle()
	 * @generated
	 */
	void setLifecycle(Lifecycle value);

	/**
	 * Returns the value of the '<em><b>Node Type</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The NodeType reference, contains 0 or more NodeType types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Type</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNode_NodeType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='NodeType'"
	 * @generated
	 */
	EList<NodeType> getNodeType();

	/**
	 * Returns the value of the '<em><b>Created By Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CreatedByRef references, refers to the User type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Created By Ref</em>' reference.
	 * @see #setCreatedByRef(Person)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNode_CreatedByRef()
	 * @model extendedMetaData="kind='attribute' name='CreatedByRef'"
	 * @generated
	 */
	Person getCreatedByRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Node#getCreatedByRef <em>Created By Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created By Ref</em>' reference.
	 * @see #getCreatedByRef()
	 * @generated
	 */
	void setCreatedByRef(Person value);

	/**
	 * Returns the value of the '<em><b>Node ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The NodeID attribute holds a unique identifier for the node. 
	 * It is according to guidelines for so-called Configuration Items (CI). 
	 * 
	 * Example:
	 * [Location][Nodetype_abbreviation][Sequencenumber]
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node ID</em>' attribute.
	 * @see #setNodeID(String)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNode_NodeID()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='NodeID'"
	 * @generated
	 */
	String getNodeID();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Node#getNodeID <em>Node ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node ID</em>' attribute.
	 * @see #getNodeID()
	 * @generated
	 */
	void setNodeID(String value);

	/**
	 * Returns the value of the '<em><b>Original Node Type Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The OriginalNodeTypeRef reference, refers to the original NodeType type from the library.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Original Node Type Ref</em>' reference.
	 * @see #setOriginalNodeTypeRef(NodeType)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNode_OriginalNodeTypeRef()
	 * @model extendedMetaData="kind='attribute' name='OriginalNodeTypeRef'"
	 * @generated
	 */
	NodeType getOriginalNodeTypeRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Node#getOriginalNodeTypeRef <em>Original Node Type Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Node Type Ref</em>' reference.
	 * @see #getOriginalNodeTypeRef()
	 * @generated
	 */
	void setOriginalNodeTypeRef(NodeType value);

	/**
	 * Returns the value of the '<em><b>Room Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The RoomRef reference, refers to a Room type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Room Ref</em>' reference.
	 * @see #setRoomRef(Room)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNode_RoomRef()
	 * @model extendedMetaData="kind='attribute' name='RoomRef'"
	 * @generated
	 */
	Room getRoomRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Node#getRoomRef <em>Room Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Room Ref</em>' reference.
	 * @see #getRoomRef()
	 * @generated
	 */
	void setRoomRef(Room value);

} // Node
