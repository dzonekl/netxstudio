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
package com.netxforge.netxstudio.scheduling;

import com.netxforge.netxstudio.services.ServiceUser;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service User Failure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Gives information about a failed component
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.ServiceUserFailure#getServiceUserRef <em>Service User Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getServiceUserFailure()
 * @model extendedMetaData="name='ServiceUserFailure' kind='elementOnly'"
 * @generated
 */
public interface ServiceUserFailure extends ExpressionFailure {
	/**
	 * Returns the value of the '<em><b>Service User Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the ServiceUser for which the
	 * 								computation failed.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service User Ref</em>' reference.
	 * @see #setServiceUserRef(ServiceUser)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getServiceUserFailure_ServiceUserRef()
	 * @model extendedMetaData="kind='element' name='ServiceUserRef'"
	 * @generated
	 */
	ServiceUser getServiceUserRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.ServiceUserFailure#getServiceUserRef <em>Service User Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service User Ref</em>' reference.
	 * @see #getServiceUserRef()
	 * @generated
	 */
	void setServiceUserRef(ServiceUser value);

} // ServiceUserFailure
