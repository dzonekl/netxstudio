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

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Base;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the profile of a service. The
 * 				Service profile can be generic for the service or location specific.
 * 				The profile contains service parameters which drive the utilization
 * 				of resources on elements tight to this
 * 				service.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceProfile#getProfileResources <em>Profile Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceProfile#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceProfile()
 * @model extendedMetaData="name='ServiceProfile' kind='elementOnly'"
 * @generated
 */
public interface ServiceProfile extends Base {
	/**
	 * Returns the value of the '<em><b>Profile Resources</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.DerivedResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ProfileResource reference, contains 0 or
	 * 								more Resource types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Profile Resources</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceProfile_ProfileResources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ProfileResources'"
	 * @generated
	 */
	EList<DerivedResource> getProfileResources();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the
	 * 							ServiceProfile.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceProfile_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceProfile#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ServiceProfile
