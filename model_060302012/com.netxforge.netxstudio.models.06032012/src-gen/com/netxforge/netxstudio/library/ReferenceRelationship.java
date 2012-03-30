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
 * A representation of the model object '<em><b>Reference Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a Reference Relationship between two Network Element Types. The
 * 				protocol defines the procedures for this relationship. Note the relation
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceRelationship#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceRelationship#getProtocolRef <em>Protocol Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceRelationship#getRefInterface1Ref <em>Ref Interface1 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceRelationship#getRefInterface2Ref <em>Ref Interface2 Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceRelationship()
 * @model extendedMetaData="name='ReferenceRelationship' kind='empty'"
 * @generated
 */
public interface ReferenceRelationship extends Base {
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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceRelationship_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ReferenceRelationship#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceRelationship_ProtocolRef()
	 * @model extendedMetaData="kind='attribute' name='ProtocolRef'"
	 * @generated
	 */
	Protocol getProtocolRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ReferenceRelationship#getProtocolRef <em>Protocol Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol Ref</em>' reference.
	 * @see #getProtocolRef()
	 * @generated
	 */
	void setProtocolRef(Protocol value);

	/**
	 * Returns the value of the '<em><b>Ref Interface1 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The NodeID1Ref attribute, references a Node
	 * 							type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref Interface1 Ref</em>' reference.
	 * @see #setRefInterface1Ref(NodeType)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceRelationship_RefInterface1Ref()
	 * @model extendedMetaData="kind='attribute' name='RefInterface1Ref'"
	 * @generated
	 */
	NodeType getRefInterface1Ref();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ReferenceRelationship#getRefInterface1Ref <em>Ref Interface1 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Interface1 Ref</em>' reference.
	 * @see #getRefInterface1Ref()
	 * @generated
	 */
	void setRefInterface1Ref(NodeType value);

	/**
	 * Returns the value of the '<em><b>Ref Interface2 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The NodeID2Ref attribute, references a Node
	 * 							type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref Interface2 Ref</em>' reference.
	 * @see #setRefInterface2Ref(NodeType)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceRelationship_RefInterface2Ref()
	 * @model extendedMetaData="kind='attribute' name='RefInterface2Ref'"
	 * @generated
	 */
	NodeType getRefInterface2Ref();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ReferenceRelationship#getRefInterface2Ref <em>Ref Interface2 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Interface2 Ref</em>' reference.
	 * @see #getRefInterface2Ref()
	 * @generated
	 */
	void setRefInterface2Ref(NodeType value);

} // ReferenceRelationship
