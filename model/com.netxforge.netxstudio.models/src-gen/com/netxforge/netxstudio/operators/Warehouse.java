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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Warehouse</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of  a wharehouse .
 * A Warehouse can have nodes and loose pieces of equipment in storage. When a piece of equipment is taken out
 * of service (See Lifecycle) it can be stored in the wharehouse.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.Warehouse#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Warehouse#getEquipments <em>Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Warehouse#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Warehouse#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getWarehouse()
 * @model extendedMetaData="name='Warehouse' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface Warehouse extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Nodes reference, contains 0 or more Node types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getWarehouse_Nodes()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Nodes'"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Equipments</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Equipments reference, contains 0 or more Equipment types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipments</em>' attribute list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getWarehouse_Equipments()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='Equipments'"
	 * @generated
	 */
	EList<String> getEquipments();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description of the network.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getWarehouse_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Warehouse#getDescription <em>Description</em>}' attribute.
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
	 * The Name attribute holds the name of the network.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getWarehouse_Name()
	 * @model default="name" unsettable="true" dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.Warehouse#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link com.netxforge.netxstudio.operators.Warehouse#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.operators.Warehouse#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

} // Warehouse
