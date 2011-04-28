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
package com.netxforge.netxstudio.metrics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier Data Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A specialized type, for representing an identifier in the mapping. The identifier should contain the target object and the target attribute of the object. 
 * The target object and target attribute are used to find the Object, in which the values will be stored. 
 * 
 * Examples: 
 * 1. If the ObjectName is "Node" and the ObjectAttribute is "NodeID", the value of the column in the XLS with with this IdentifierDataType, will be interpreted
 * as the Node->NodeID identifier.	
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectAttribute <em>Object Attribute</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectName <em>Object Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getIdentifierDataKind()
 * @model extendedMetaData="name='IdentifierDataKind' kind='empty'"
 * @generated
 */
public interface IdentifierDataKind extends DataKind {
	/**
	 * Returns the value of the '<em><b>Object Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ObjectAttribute attribute holds the the textual name of the target attribute we are looking for.
	 * Note: Most often this will be the "NodeID" but it can also be a "Position" identifier or anything else. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object Attribute</em>' attribute.
	 * @see #setObjectAttribute(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getIdentifierDataKind_ObjectAttribute()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ObjectAttribute'"
	 * @generated
	 */
	String getObjectAttribute();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectAttribute <em>Object Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Attribute</em>' attribute.
	 * @see #getObjectAttribute()
	 * @generated
	 */
	void setObjectAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Object Name</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.metrics.ObjectNameType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ObjectName attributes holds the textual name of the target object we are looking for. 
	 * Note: Most often this will be a "Node"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object Name</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.ObjectNameType
	 * @see #isSetObjectName()
	 * @see #unsetObjectName()
	 * @see #setObjectName(ObjectNameType)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getIdentifierDataKind_ObjectName()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ObjectName'"
	 * @generated
	 */
	ObjectNameType getObjectName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectName <em>Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Name</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.ObjectNameType
	 * @see #isSetObjectName()
	 * @see #unsetObjectName()
	 * @see #getObjectName()
	 * @generated
	 */
	void setObjectName(ObjectNameType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectName <em>Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetObjectName()
	 * @see #getObjectName()
	 * @see #setObjectName(ObjectNameType)
	 * @generated
	 */
	void unsetObjectName();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectName <em>Object Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Object Name</em>' attribute is set.
	 * @see #unsetObjectName()
	 * @see #getObjectName()
	 * @see #setObjectName(ObjectNameType)
	 * @generated
	 */
	boolean isSetObjectName();

} // IdentifierDataKind
