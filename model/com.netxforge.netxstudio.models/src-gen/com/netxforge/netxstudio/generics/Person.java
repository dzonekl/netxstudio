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
package com.netxforge.netxstudio.generics;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A type representing the basic information points of a
 * 				User in the context of using the application. The Email
 * 				attribute is also the login identifier.
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.Person#isActive <em>Active</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Person#getCompanyRef <em>Company Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Person#getEmail <em>Email</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Person#getFirstName <em>First Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Person#getLastName <em>Last Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Person#getLogin <em>Login</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Person#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.generics.GenericsPackage#getPerson()
 * @model extendedMetaData="name='Person' kind='empty'"
 * @extends CDOObject
 * @generated
 */
public interface Person extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #isSetActive()
	 * @see #unsetActive()
	 * @see #setActive(boolean)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getPerson_Active()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='Active'"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Person#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isSetActive()
	 * @see #unsetActive()
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.generics.Person#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActive()
	 * @see #isActive()
	 * @see #setActive(boolean)
	 * @generated
	 */
	void unsetActive();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.generics.Person#isActive <em>Active</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Active</em>' attribute is set.
	 * @see #unsetActive()
	 * @see #isActive()
	 * @see #setActive(boolean)
	 * @generated
	 */
	boolean isSetActive();

	/**
	 * Returns the value of the '<em><b>Company Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The CompanyRef reference, refers to 0 or 1 Company
	 * 					type.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Company Ref</em>' reference.
	 * @see #setCompanyRef(Company)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getPerson_CompanyRef()
	 * @model extendedMetaData="kind='attribute' name='CompanyRef'"
	 * @generated
	 */
	Company getCompanyRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Person#getCompanyRef <em>Company Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company Ref</em>' reference.
	 * @see #getCompanyRef()
	 * @generated
	 */
	void setCompanyRef(Company value);

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The Email attribute hols the email address of the
	 * 					user. It is according to regex:
	 * 					^[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getPerson_Email()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Email'"
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Person#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The FirstName attribute holds the first name of the
	 * 					person.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getPerson_FirstName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='FirstName'"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Person#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The LastName attribute holds the last name of the
	 * 					person.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getPerson_LastName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='LastName'"
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Person#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The Login attribute holds the login ID of the
	 * 					person.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Login</em>' attribute.
	 * @see #setLogin(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getPerson_Login()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Login'"
	 * @generated
	 */
	String getLogin();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Person#getLogin <em>Login</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login</em>' attribute.
	 * @see #getLogin()
	 * @generated
	 */
	void setLogin(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The Password attribute holds the password of the
	 * 					user.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getPerson_Password()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Password'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Person#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

} // Person
