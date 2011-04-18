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
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.MultiImage;

import com.netxforge.netxstudio.metrics.Metric;

import com.netxforge.netxstudio.operators.EquipmentRelationship;

import com.netxforge.netxstudio.protocols.Protocol;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equipment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of a real telecommunications equipment part.
 * Specifically it represents the Hardware portion. (The Software or logic is represented by the Function type). 
 * Equipment types can be nested to form a hiarchical structure in similar fashion to a real HW equipment.
 * 
 * The Equipment type (and/or it's children) is first part of the Library type, and then copied into a Node type when 
 * created.
 * 
 * Examples:
 * 1. The Equipment type typical structure is: Cabinets -> Rack -> Slots -> Boards -> Ports -> Cabling
 * 2. The Equipment type can be constructed with a specif UI widget like a Node Editor.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getLifecycle <em>Lifecycle</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getEquipments <em>Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getEquipmentGroups <em>Equipment Groups</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getEquipmentResources <em>Equipment Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getEquipmentMetricRefs <em>Equipment Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getEquipmentRelationshipRefs <em>Equipment Relationship Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getEquipmentExpressionRefs <em>Equipment Expression Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getProtocolRefs <em>Protocol Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getAllEquipmentResources <em>All Equipment Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getAllEquipments <em>All Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getCount <em>Count</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getEquipmentCode <em>Equipment Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getEquipmentName <em>Equipment Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getPosition <em>Position</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getRedundancy <em>Redundancy</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Equipment#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment()
 * @model extendedMetaData="name='Equipment' kind='elementOnly'"
 * @generated
 */
public interface Equipment extends EObject {
	/**
	 * Returns the value of the '<em><b>Lifecycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Lifecycle reference, contains 0 or 1 Lifecycle types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lifecycle</em>' containment reference.
	 * @see #setLifecycle(Lifecycle)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_Lifecycle()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Lifecycle'"
	 * @generated
	 */
	Lifecycle getLifecycle();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getLifecycle <em>Lifecycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lifecycle</em>' containment reference.
	 * @see #getLifecycle()
	 * @generated
	 */
	void setLifecycle(Lifecycle value);

	/**
	 * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.DiagramInfo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Diagrams reference, contains 0 or more DiagramInfo types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Diagrams</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_Diagrams()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Diagrams'"
	 * @generated
	 */
	EList<DiagramInfo> getDiagrams();

	/**
	 * Returns the value of the '<em><b>Equipments</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Equipment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Equipments reference, contains 0 or more Equipment types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipments</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_Equipments()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Equipments'"
	 * @generated
	 */
	EList<Equipment> getEquipments();

	/**
	 * Returns the value of the '<em><b>Equipment Groups</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.EquipmentGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentGroups reference, contains 0 or more EquipmentGroup types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Groups</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_EquipmentGroups()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='EquipmentGroups'"
	 * @generated
	 */
	EList<EquipmentGroup> getEquipmentGroups();

	/**
	 * Returns the value of the '<em><b>Equipment Resources</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NetXResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentResources reference, contains 0 or more EquipmentResource types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Resources</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_EquipmentResources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='EquipmentResources'"
	 * @generated
	 */
	EList<NetXResource> getEquipmentResources();

	/**
	 * Returns the value of the '<em><b>Equipment Metric Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentMetricRefs reference, refers to 0 or more Metric types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Metric Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_EquipmentMetricRefs()
	 * @model extendedMetaData="kind='element' name='EquipmentMetricRefs'"
	 * @generated
	 */
	EList<Metric> getEquipmentMetricRefs();

	/**
	 * Returns the value of the '<em><b>Equipment Relationship Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.EquipmentRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentRelationshipRefs reference, refers to 0 or more EquipmentRelationship types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Relationship Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_EquipmentRelationshipRefs()
	 * @model extendedMetaData="kind='element' name='EquipmentRelationshipRefs'"
	 * @generated
	 */
	EList<EquipmentRelationship> getEquipmentRelationshipRefs();

	/**
	 * Returns the value of the '<em><b>Equipment Expression Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Expression}.
	 * It is bidirectional and its opposite is '{@link com.netxforge.netxstudio.library.Expression#getEquipmentRefs <em>Equipment Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentExpressionRefs reference, refers to 0 or more Expression types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Expression Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_EquipmentExpressionRefs()
	 * @see com.netxforge.netxstudio.library.Expression#getEquipmentRefs
	 * @model opposite="equipmentRefs"
	 *        extendedMetaData="kind='element' name='EquipmentExpressionRefs'"
	 * @generated
	 */
	EList<Expression> getEquipmentExpressionRefs();

	/**
	 * Returns the value of the '<em><b>Tolerance Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Tolerance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ToleranceRefs reference, refers to 0 or more Tolerance types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tolerance Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_ToleranceRefs()
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
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protocol Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_ProtocolRefs()
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
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_ParameterRefs()
	 * @model extendedMetaData="kind='element' name='ParameterRefs'"
	 * @generated
	 */
	EList<Parameter> getParameterRefs();

	/**
	 * Returns the value of the '<em><b>All Equipment Resources</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NetXResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OCL derived feature: Retrieves all resources
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>All Equipment Resources</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_AllEquipmentResources()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='\n\t\t\t\t\t\tself->closure(equipments).equipmentResources->asOrderedSet()\n\t\t\t\t\t'"
	 *        extendedMetaData="kind='element' name='AllEquipmentResources'"
	 * @generated
	 */
	EList<NetXResource> getAllEquipmentResources();

	/**
	 * Returns the value of the '<em><b>All Equipments</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Equipment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OCL derived feature: Retrieve all elements with a non-empty product code. These are
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>All Equipments</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_AllEquipments()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='\n\t\t\t\t\t\tself->closure(equipments)->asOrderedSet()\n\t\t\t\t\t'"
	 *        extendedMetaData="kind='element' name='AllEquipments'"
	 * @generated
	 */
	EList<Equipment> getAllEquipments();

	/**
	 * Returns the value of the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Images reference, contains 0 or one MultiImage type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Icons</em>' containment reference.
	 * @see #setIcons(MultiImage)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_Icons()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Icons'"
	 * @generated
	 */
	MultiImage getIcons();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getIcons <em>Icons</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icons</em>' containment reference.
	 * @see #getIcons()
	 * @generated
	 */
	void setIcons(MultiImage value);

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OCL derived feature: Count all equipments.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #isSetCount()
	 * @see #unsetCount()
	 * @see #setCount(int)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_Count()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self.equipments->size()\n\t\t\t\t\t\t\t'"
	 *        extendedMetaData="kind='attribute' name='Count'"
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #isSetCount()
	 * @see #unsetCount()
	 * @see #getCount()
	 * @generated
	 */
	void setCount(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCount()
	 * @see #getCount()
	 * @see #setCount(int)
	 * @generated
	 */
	void unsetCount();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.Equipment#getCount <em>Count</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Count</em>' attribute is set.
	 * @see #unsetCount()
	 * @see #getCount()
	 * @see #setCount(int)
	 * @generated
	 */
	boolean isSetCount();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description of the equipment
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Equipment Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentCode attribute holds a unique identifier typically used for telecommunications equipment. 
	 * 
	 * Examples: 
	 * 1. The EquipmentCode could be a "Cabinet"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Code</em>' attribute.
	 * @see #setEquipmentCode(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_EquipmentCode()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='EquipmentCode'"
	 * @generated
	 */
	String getEquipmentCode();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getEquipmentCode <em>Equipment Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equipment Code</em>' attribute.
	 * @see #getEquipmentCode()
	 * @generated
	 */
	void setEquipmentCode(String value);

	/**
	 * Returns the value of the '<em><b>Equipment Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentName attribute holds the name of the equipment when the equipment is configured in a Node type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Name</em>' attribute.
	 * @see #setEquipmentName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_EquipmentName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='EquipmentName'"
	 * @generated
	 */
	String getEquipmentName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getEquipmentName <em>Equipment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equipment Name</em>' attribute.
	 * @see #getEquipmentName()
	 * @generated
	 */
	void setEquipmentName(String value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Position attribute holds information about the position of an equipment relative to it's parent. 
	 * 
	 * Examples: 
	 * 1. The Position of an Equipment with Code "Slot" could be "0" while it's parent is a "Rack", this would mean
	 * slot 0 in the rack.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_Position()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Position'"
	 * @generated
	 */
	String getPosition();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(String value);

	/**
	 * Returns the value of the '<em><b>Redundancy</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.library.RedundancyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Redundancy attribute holds the expected redundancy schema of an equipment.
	 * An equipment is Active, Stand-by, Idle or Defect.
	 * 
	 * The following options are possible:
	 * 
	 * n => The equipment is not operating in any redundancy schema
	 * n+1 => The equipment is part of an n+1 schema. (1 stand-by for n number of active equipment). 
	 * 1+1 => The equipment is paired with another equipment.  
	 * 
	 * It should be considered, that the permitted load and consequently the Tolerance will depend on the 
	 * redundancy schema. Closely related to the Redundancy schema is the Load Distribution.
	 * 
	 * Examples
	 * 1. A schema of n, means a failure of this equipment will not be covered by another equipment.
	 * 2. A Schema of n+1, means a failure of the equipment will be covered by another equipment, unless the stand-by equipment, is already 
	 * active. 
	 * 3. A schema of 1+1, means the load on this equipment will be covered by another equipment.  
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Redundancy</em>' attribute.
	 * @see com.netxforge.netxstudio.library.RedundancyType
	 * @see #isSetRedundancy()
	 * @see #unsetRedundancy()
	 * @see #setRedundancy(RedundancyType)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_Redundancy()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Redundancy'"
	 * @generated
	 */
	RedundancyType getRedundancy();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getRedundancy <em>Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redundancy</em>' attribute.
	 * @see com.netxforge.netxstudio.library.RedundancyType
	 * @see #isSetRedundancy()
	 * @see #unsetRedundancy()
	 * @see #getRedundancy()
	 * @generated
	 */
	void setRedundancy(RedundancyType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getRedundancy <em>Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRedundancy()
	 * @see #getRedundancy()
	 * @see #setRedundancy(RedundancyType)
	 * @generated
	 */
	void unsetRedundancy();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.Equipment#getRedundancy <em>Redundancy</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Redundancy</em>' attribute is set.
	 * @see #unsetRedundancy()
	 * @see #getRedundancy()
	 * @see #setRedundancy(RedundancyType)
	 * @generated
	 */
	boolean isSetRedundancy();

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.library.StateType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The State attribute holds the life status of an equipment. 
	 * 
	 * The following options are possible:
	 * 
	 * Active => The equipment is operating. 
	 * Stand-by => The equipment is Stand-by.  
	 * Idle => The equipment is not configured and does not participate in Active nor Stand-by and there for in the redudancy schema.  An Idle e
	 * Equipment can however be reserved. 
	 * Defect => The equipment is defect and does not participate in Active nor Stand-by and there for in the redudancy schema.  
	 * Reserved => The equipment is reserved for future use. 
	 * 
	 * Examples
	 * 1. The state of the equipment could be considered to corelate with a Metric of the Equipment. A Stand-by 
	 * equipment should not be considered when calculating the average load for a group of equipments. It will however depend 
	 * on the Equipment Manufacturer if measurements are reported for non-Active equipments. 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see com.netxforge.netxstudio.library.StateType
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #setState(StateType)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipment_State()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='State'"
	 * @generated
	 */
	StateType getState();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see com.netxforge.netxstudio.library.StateType
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #getState()
	 * @generated
	 */
	void setState(StateType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.Equipment#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetState()
	 * @see #getState()
	 * @see #setState(StateType)
	 * @generated
	 */
	void unsetState();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.Equipment#getState <em>State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>State</em>' attribute is set.
	 * @see #unsetState()
	 * @see #getState()
	 * @see #setState(StateType)
	 * @generated
	 */
	boolean isSetState();

} // Equipment
