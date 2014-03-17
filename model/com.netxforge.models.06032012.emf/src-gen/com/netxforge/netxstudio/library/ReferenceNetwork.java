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

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.generics.DiagramInfo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a reference telecommunications network or part of a network.
 * 				A Network
 * 				type can have a parent Network. It also can contain Network Element types.
 * 				and
 * 				relationships. A Network can have different phases
 * 				which represents
 * 				how the network evolves over time. The start and end
 * 				date of the
 * 				network provide reference on the period for which a
 * 				phase applies.
 * 				applies. Network phases are also linked together.
 * 
 * 				Examples:
 * 				1. A "Core
 * 				Network" is defined which holds Nodes belonging to the
 * 				"Core
 * 				Network". Relationships are also stored
 * 				in this network.
 * 				1. A "Core
 * 				Network" has 2 phases, each covering 1 calendar year.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceNetwork#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceNetwork#getNodeTypes <em>Node Types</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceNetwork#getReferenceNetworks <em>Reference Networks</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceNetwork#getRefRelationships <em>Ref Relationships</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceNetwork#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ReferenceNetwork#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceNetwork()
 * @model extendedMetaData="name='ReferenceNetwork' kind='elementOnly'"
 * @generated
 */
public interface ReferenceNetwork extends Base {
	/**
	 * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.DiagramInfo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Diagrams reference, contains 0 or more
	 * 								DiagramInfo types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Diagrams</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceNetwork_Diagrams()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Diagrams'"
	 * @generated
	 */
	EList<DiagramInfo> getDiagrams();

	/**
	 * Returns the value of the '<em><b>Node Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Nodes reference, contains 0 or more Node
	 * 								types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Types</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceNetwork_NodeTypes()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='NodeTypes'"
	 * @generated
	 */
	EList<NodeType> getNodeTypes();

	/**
	 * Returns the value of the '<em><b>Reference Networks</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.ReferenceNetwork}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Networks reference, contains 0 or more
	 * 								Network types.
	 * 								These are sub networks.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference Networks</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceNetwork_ReferenceNetworks()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ReferenceNetworks'"
	 * @generated
	 */
	EList<ReferenceNetwork> getReferenceNetworks();

	/**
	 * Returns the value of the '<em><b>Ref Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.ReferenceRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Reference Relations reference, contains 0
	 * 								or more Reference Relationships.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref Relationships</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceNetwork_RefRelationships()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RefRelationships'"
	 * @generated
	 */
	EList<ReferenceRelationship> getRefRelationships();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description
	 * 							of
	 * 							the network.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceNetwork_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ReferenceNetwork#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"name"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the
	 * 							network.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getReferenceNetwork_Name()
	 * @model default="name" unsettable="true" dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ReferenceNetwork#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.ReferenceNetwork#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.ReferenceNetwork#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

} // ReferenceNetwork
