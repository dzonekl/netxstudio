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
 * A specialized type, for representing an identifier
 * 				in the mapping. The identifier should contain the target object and
 * 				the target attribute of the object.
 * 				The target object and target
 * 				attribute are used to find the Object, in
 * 				which the values will be
 * 				stored.
 * 
 * 				Examples:
 * 				1. If the ObjectName is "Node" and the
 * 				ObjectAttribute is "NodeID",
 * 				the value of the column in the XLS with
 * 				with this
 * 				IdentifierDataType, will be interpreted
 * 				as the Node->NodeID
 * 				identifier.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectKind <em>Object Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectProperty <em>Object Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getIdentifierDataKind()
 * @model extendedMetaData="name='IdentifierDataKind' kind='empty'"
 * @generated
 */
public interface IdentifierDataKind extends DataKind {
	/**
	 * Returns the value of the '<em><b>Object Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.metrics.ObjectKindType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ObjectKind attributes holds the textual name
	 * 							of the target object we are looking for.
	 * 							Note: Most often this
	 * 							will be a "Node", but also a child of a "Node"
	 * 							like an
	 * 							"Equipment", it can also be a "Relationship" on a "Node".
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.ObjectKindType
	 * @see #isSetObjectKind()
	 * @see #unsetObjectKind()
	 * @see #setObjectKind(ObjectKindType)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getIdentifierDataKind_ObjectKind()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ObjectKind'"
	 * @generated
	 */
	ObjectKindType getObjectKind();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectKind <em>Object Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.ObjectKindType
	 * @see #isSetObjectKind()
	 * @see #unsetObjectKind()
	 * @see #getObjectKind()
	 * @generated
	 */
	void setObjectKind(ObjectKindType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectKind <em>Object Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetObjectKind()
	 * @see #getObjectKind()
	 * @see #setObjectKind(ObjectKindType)
	 * @generated
	 */
	void unsetObjectKind();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectKind <em>Object Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Object Kind</em>' attribute is set.
	 * @see #unsetObjectKind()
	 * @see #getObjectKind()
	 * @see #setObjectKind(ObjectKindType)
	 * @generated
	 */
	boolean isSetObjectKind();

	/**
	 * Returns the value of the '<em><b>Object Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ObjectProperty attribute holds the the
	 * 							textual name of the target attribute we are looking for.
	 * 							Note:
	 * 							Most often this will be the "NodeID" but it can also be a
	 * 							"Position" identifier or anything else.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object Property</em>' attribute.
	 * @see #setObjectProperty(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getIdentifierDataKind_ObjectProperty()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ObjectProperty'"
	 * @generated
	 */
	String getObjectProperty();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectProperty <em>Object Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Property</em>' attribute.
	 * @see #getObjectProperty()
	 * @generated
	 */
	void setObjectProperty(String value);

} // IdentifierDataKind
