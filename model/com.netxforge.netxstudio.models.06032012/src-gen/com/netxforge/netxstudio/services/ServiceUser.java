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
import com.netxforge.netxstudio.library.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a ServiceUser. A ServiceUser is
 * 				a user of a service, which impacts the consumption of
 * 				resources when
 * 				using a service. A ServiceUser has a profile, and a name.
 * 
 * 				Examples:
 * 				1. A Service user postpaid subscriber is defined. It's profile is a
 * 				postpaid subscriber profile with several
 * 				values for.
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceUser#getServiceProfile <em>Service Profile</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceUser#getExpressionRef <em>Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceUser#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceUser#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceUser()
 * @model extendedMetaData="name='ServiceUser' kind='elementOnly'"
 * @generated
 */
public interface ServiceUser extends Base {
	/**
	 * Returns the value of the '<em><b>Service Profile</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceProfile reference, contains 0 or 1
	 * 								ServiceProfile type.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Profile</em>' containment reference.
	 * @see #setServiceProfile(ServiceProfile)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceUser_ServiceProfile()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ServiceProfile'"
	 * @generated
	 */
	ServiceProfile getServiceProfile();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceUser#getServiceProfile <em>Service Profile</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Profile</em>' containment reference.
	 * @see #getServiceProfile()
	 * @generated
	 */
	void setServiceProfile(ServiceProfile value);

	/**
	 * Returns the value of the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ExpressionRef reference, refers to 0 or
	 * 								1
	 * 								Expression types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression Ref</em>' reference.
	 * @see #setExpressionRef(Expression)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceUser_ExpressionRef()
	 * @model extendedMetaData="kind='element' name='ExpressionRef'"
	 * @generated
	 */
	Expression getExpressionRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceUser#getExpressionRef <em>Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Ref</em>' reference.
	 * @see #getExpressionRef()
	 * @generated
	 */
	void setExpressionRef(Expression value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute, holds the
	 * 							Description
	 * 							of the service User.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceUser_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceUser#getDescription <em>Description</em>}' attribute.
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
	 * 							ServiceUser.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceUser_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceUser#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ServiceUser
