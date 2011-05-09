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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Forecast Users</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a ServiceForecastUser. A ServiceForecastUser is a user of a service, which
 * is forecasted over time. It has values and references a ServiceUser.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceForecastUsers#getUserValues <em>User Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceForecastUsers#getServiceUserRef <em>Service User Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceForecastUsers()
 * @model extendedMetaData="name='ServiceForecastUsers' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface ServiceForecastUsers extends CDOObject {
	/**
	 * Returns the value of the '<em><b>User Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UserValues reference, contains expected service user values for a service.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>User Values</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceForecastUsers_UserValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='UserValues'"
	 * @generated
	 */
	EList<Value> getUserValues();

	/**
	 * Returns the value of the '<em><b>Service User Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceUser reference, references 0 or 1 ServiceUser type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service User Ref</em>' reference.
	 * @see #setServiceUserRef(ServiceUser)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceForecastUsers_ServiceUserRef()
	 * @model extendedMetaData="kind='element' name='ServiceUserRef'"
	 * @generated
	 */
	ServiceUser getServiceUserRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceForecastUsers#getServiceUserRef <em>Service User Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service User Ref</em>' reference.
	 * @see #getServiceUserRef()
	 * @generated
	 */
	void setServiceUserRef(ServiceUser value);

} // ServiceForecastUsers
