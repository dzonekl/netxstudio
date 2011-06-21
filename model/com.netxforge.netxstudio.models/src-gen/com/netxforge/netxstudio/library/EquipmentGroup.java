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

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.generics.DiagramInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equipment Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a group of equipment which have
 * 				a relationship.
 * 				An EquipmentGroup is used to group equipments and
 * 				evaluate expressions
 * 				on resources of the group.
 * 
 * 				Examples:
 * 				1. The
 * 				EquipmentGroup type can have resources which hold the
 * 				distribution of
 * 				traffic amongst the
 * 				equipment in the group. An Expression is used to
 * 				derive the distribution.
 * 				2. The EquipmentGroup type can have
 * 				resources which hold the redudancy
 * 				schema of a
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getEquipmentGroupResources <em>Equipment Group Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getExpressionRefs <em>Expression Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getEquipmentRefs <em>Equipment Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getAllEquipmentResources <em>All Equipment Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getAllEquipments <em>All Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getCount <em>Count</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.EquipmentGroup#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup()
 * @model extendedMetaData="name='EquipmentGroup' kind='elementOnly'"
 * @generated
 */
public interface EquipmentGroup extends Base {
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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_Diagrams()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Diagrams'"
	 * @generated
	 */
	EList<DiagramInfo> getDiagrams();

	/**
	 * Returns the value of the '<em><b>Equipment Group Resources</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NetXResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentGroupResources reference, contains
	 * 								0
	 * 								or more Resource types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Group Resources</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_EquipmentGroupResources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='EquipmentGroupResources'"
	 * @generated
	 */
	EList<NetXResource> getEquipmentGroupResources();

	/**
	 * Returns the value of the '<em><b>Expression Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Expression}.
	 * It is bidirectional and its opposite is '{@link com.netxforge.netxstudio.library.Expression#getEquipmentGroupRefs <em>Equipment Group Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ExpressionRefs reference, refers to 0 or
	 * 								more
	 * 								Expression types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_ExpressionRefs()
	 * @see com.netxforge.netxstudio.library.Expression#getEquipmentGroupRefs
	 * @model opposite="equipmentGroupRefs"
	 *        extendedMetaData="kind='element' name='ExpressionRefs'"
	 * @generated
	 */
	EList<Expression> getExpressionRefs();

	/**
	 * Returns the value of the '<em><b>Equipment Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Equipment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Equipments reference, references 0 or more
	 * 								Equipment types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_EquipmentRefs()
	 * @model extendedMetaData="kind='element' name='EquipmentRefs'"
	 * @generated
	 */
	EList<Equipment> getEquipmentRefs();

	/**
	 * Returns the value of the '<em><b>Parameter Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ParameterRefs reference, refers to 0 or
	 * 								more
	 * 								Parameter types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_ParameterRefs()
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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_AllEquipmentResources()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self->closure(equipmentRefs).equipmentResources->asOrderedSet()\n\t\t\t\t\t\t\t'"
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
	 * OCL derived feature: Retrieve all elements with
	 * 								a
	 * 								non-empty product code.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>All Equipments</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_AllEquipments()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='\n\t\t\t\t\t\t\t\tself->closure(equipmentRefs)->asOrderedSet()\n\t\t\t\t\t\t\t'"
	 *        extendedMetaData="kind='element' name='AllEquipments'"
	 * @generated
	 */
	EList<Equipment> getAllEquipments();

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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_Count()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self.equipments->size()\n\t\t\t\t\t\t'"
	 *        extendedMetaData="kind='attribute' name='Count'"
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.EquipmentGroup#getCount <em>Count</em>}' attribute.
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
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.EquipmentGroup#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCount()
	 * @see #getCount()
	 * @see #setCount(int)
	 * @generated
	 */
	void unsetCount();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.EquipmentGroup#getCount <em>Count</em>}' attribute is set.
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
	 * The Description attribute holds the description
	 * 							of
	 * 							the equipment group.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.EquipmentGroup#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the
	 * 							equipment
	 * 							group.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getEquipmentGroup_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.EquipmentGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // EquipmentGroup
