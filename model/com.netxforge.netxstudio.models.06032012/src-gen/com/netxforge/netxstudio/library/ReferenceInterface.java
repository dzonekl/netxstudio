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
import com.netxforge.netxstudio.protocols.Protocol;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a Reference Relationship between two Network Element Types. The
 * 				protocol
 * 				defines the procedures for this relationship.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceInterface#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceInterface#getNodeTypeRef <em>Node Type Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceInterface#getProtocolRef <em>Protocol Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceInterface()
 * @model extendedMetaData="name='ReferenceInterface' kind='empty'"
 * @generated
 */
public interface ReferenceInterface extends Base {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds a name used for
	 * 							presentation.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceInterface_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ReferenceInterface#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Node Type Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The NodeID1Ref attribute, references a Node
	 * 							type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Type Ref</em>' reference.
	 * @see #setNodeTypeRef(NodeType)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceInterface_NodeTypeRef()
	 * @model extendedMetaData="kind='attribute' name='NodeTypeRef'"
	 * @generated
	 */
	NodeType getNodeTypeRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ReferenceInterface#getNodeTypeRef <em>Node Type Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Type Ref</em>' reference.
	 * @see #getNodeTypeRef()
	 * @generated
	 */
	void setNodeTypeRef(NodeType value);

	/**
	 * Returns the value of the '<em><b>Protocol Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ProtocolRef reference, refers to 0 or 1
	 * 							Protocol type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protocol Ref</em>' reference.
	 * @see #setProtocolRef(Protocol)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceInterface_ProtocolRef()
	 * @model extendedMetaData="kind='attribute' name='ProtocolRef'"
	 * @generated
	 */
	Protocol getProtocolRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ReferenceInterface#getProtocolRef <em>Protocol Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol Ref</em>' reference.
	 * @see #getProtocolRef()
	 * @generated
	 */
	void setProtocolRef(Protocol value);

} // ReferenceInterface
