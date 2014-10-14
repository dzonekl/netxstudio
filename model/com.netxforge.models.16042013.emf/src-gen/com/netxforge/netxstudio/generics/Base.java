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
package com.netxforge.netxstudio.generics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.Base#isDeleted <em>Deleted</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.generics.GenericsPackage#getBase()
 * @model annotation="teneo.jpa appinfo='@MappedSuperclass'"
 *        extendedMetaData="name='Base' kind='empty'"
 * @generated
 */
public interface Base extends EObject {
	/**
	 * Returns the value of the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted</em>' attribute.
	 * @see #isSetDeleted()
	 * @see #unsetDeleted()
	 * @see #setDeleted(boolean)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getBase_Deleted()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='Deleted'"
	 * @generated
	 */
	boolean isDeleted();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Base#isDeleted <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted</em>' attribute.
	 * @see #isSetDeleted()
	 * @see #unsetDeleted()
	 * @see #isDeleted()
	 * @generated
	 */
	void setDeleted(boolean value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.generics.Base#isDeleted <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeleted()
	 * @see #isDeleted()
	 * @see #setDeleted(boolean)
	 * @generated
	 */
	void unsetDeleted();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.generics.Base#isDeleted <em>Deleted</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Deleted</em>' attribute is set.
	 * @see #unsetDeleted()
	 * @see #isDeleted()
	 * @see #setDeleted(boolean)
	 * @generated
	 */
	boolean isSetDeleted();

} // Base
