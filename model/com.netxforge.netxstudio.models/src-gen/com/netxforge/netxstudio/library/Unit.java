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

import org.eclipse.emf.cdo.CDOObject;

import com.netxforge.netxstudio.generics.MultiImage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a real world unit like Erlang, Subs or any other metric defined. It is used for metrics and
 * resources It has a Name, a description and a Code (two characters)
 * 
 * Examples: 
 * 1. The Unit Erlang is defined with code EL 
 * 2. The Unit Subscribers is defined with code SU
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.Unit#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Unit#getCode <em>Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Unit#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Unit#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getUnit()
 * @model extendedMetaData="name='Unit' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface Unit extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Images reference, contains 0 or one MultiImage type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Icons</em>' containment reference.
	 * @see #setIcons(MultiImage)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getUnit_Icons()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Icons'"
	 * @generated
	 */
	MultiImage getIcons();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Unit#getIcons <em>Icons</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icons</em>' containment reference.
	 * @see #getIcons()
	 * @generated
	 */
	void setIcons(MultiImage value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Code attribute holds the code of the unit.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getUnit_Code()
	 * @model dataType="com.netxforge.netxstudio.generics.Unit"
	 *        extendedMetaData="kind='attribute' name='Code'"
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Unit#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description of the equipment
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getUnit_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Unit#getDescription <em>Description</em>}' attribute.
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
	 * The Name attribute holds a name used for presentation.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getUnit_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Unit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Unit
