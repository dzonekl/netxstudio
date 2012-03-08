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

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.Person;

import com.netxforge.netxstudio.metrics.MetricSource;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a real telecommunications network or part of a network.
 * 				A Network
 * 				type can have a parent Network. It also can contain nodes
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
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getNetworks <em>Networks</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getFunctionRelationships <em>Function Relationships</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getEquipmentRelationships <em>Equipment Relationships</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getMetricSources <em>Metric Sources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getCreatedByRef <em>Created By Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getCreatedDate <em>Created Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Network#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork()
 * @model extendedMetaData="name='Network' kind='elementOnly'"
 * @generated
 */
public interface Network extends Base {
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
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_Diagrams()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Diagrams'"
	 * @generated
	 */
	EList<DiagramInfo> getDiagrams();

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Nodes reference, contains 0 or more Node
	 * 								types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_Nodes()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Nodes'"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Networks</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Network}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Networks reference, contains 0 or more
	 * 								Network types.
	 * 								These are sub networks.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Networks</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_Networks()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Networks'"
	 * @generated
	 */
	EList<Network> getNetworks();

	/**
	 * Returns the value of the '<em><b>Function Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.FunctionRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FunctionRelationships reference, contains 0
	 * 								or more FunctionRelationship types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Relationships</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_FunctionRelationships()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='FunctionRelationships'"
	 * @generated
	 */
	EList<FunctionRelationship> getFunctionRelationships();

	/**
	 * Returns the value of the '<em><b>Equipment Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.EquipmentRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentRelationships reference, contains
	 * 								0
	 * 								or more EquipmentRelationship types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Relationships</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_EquipmentRelationships()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='EquipmentRelationships'"
	 * @generated
	 */
	EList<EquipmentRelationship> getEquipmentRelationships();

	/**
	 * Returns the value of the '<em><b>Metric Sources</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MetricSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricSources reference, contains 0 or more
	 * 								MetricSource types
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Sources</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_MetricSources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricSources'"
	 * @generated
	 */
	EList<MetricSource> getMetricSources();

	/**
	 * Returns the value of the '<em><b>Created By Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CreatedByRef references, refers to the User
	 * 							type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Created By Ref</em>' reference.
	 * @see #setCreatedByRef(Person)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_CreatedByRef()
	 * @model extendedMetaData="kind='attribute' name='CreatedByRef'"
	 * @generated
	 */
	Person getCreatedByRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Network#getCreatedByRef <em>Created By Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created By Ref</em>' reference.
	 * @see #getCreatedByRef()
	 * @generated
	 */
	void setCreatedByRef(Person value);

	/**
	 * Returns the value of the '<em><b>Created Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CreatedDate attribute is populated with the
	 * 							actual creation date of the Network.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Created Date</em>' attribute.
	 * @see #setCreatedDate(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_CreatedDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='CreatedDate'"
	 * @generated
	 */
	XMLGregorianCalendar getCreatedDate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Network#getCreatedDate <em>Created Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created Date</em>' attribute.
	 * @see #getCreatedDate()
	 * @generated
	 */
	void setCreatedDate(XMLGregorianCalendar value);

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
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Network#getDescription <em>Description</em>}' attribute.
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
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getNetwork_Name()
	 * @model default="name" unsettable="true" dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Network#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link com.netxforge.netxstudio.operators.Network#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.operators.Network#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

} // Network
