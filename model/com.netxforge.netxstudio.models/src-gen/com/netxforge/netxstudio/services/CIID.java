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
package com.netxforge.netxstudio.services;

import com.netxforge.netxstudio.generics.Base;
import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CIID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a Configuration Item (CI)
 * 				Identifier.
 * 				The CI is used within Configuration Management to
 * 				identify a
 * 				configuration item.
 * 				It can be used as an identifier to
 * 				correlate objects to legacy
 * 				systems.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.CIID#getCommonCIID <em>Common CIID</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.CIID#getLocalCIID <em>Local CIID</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getCIID()
 * @model extendedMetaData="name='CI-ID' kind='empty'"
 * @generated
 */
public interface CIID extends Base {
	/**
	 * Returns the value of the '<em><b>Common CIID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CommonCI_ID attribute holds a Unique number
	 * 							indicator in international CMS
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Common CIID</em>' attribute.
	 * @see #setCommonCIID(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getCIID_CommonCIID()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='CommonCI_ID'"
	 * @generated
	 */
	String getCommonCIID();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.CIID#getCommonCIID <em>Common CIID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Common CIID</em>' attribute.
	 * @see #getCommonCIID()
	 * @generated
	 */
	void setCommonCIID(String value);

	/**
	 * Returns the value of the '<em><b>Local CIID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The LocalCI_ID attribute holds a Unique
	 * 							identifier
	 * 							indicator in a local CMS (CI-ID)
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Local CIID</em>' attribute.
	 * @see #setLocalCIID(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getCIID_LocalCIID()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='localCI_ID'"
	 * @generated
	 */
	String getLocalCIID();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.CIID#getLocalCIID <em>Local CIID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local CIID</em>' attribute.
	 * @see #getLocalCIID()
	 * @generated
	 */
	void setLocalCIID(String value);

} // CIID
