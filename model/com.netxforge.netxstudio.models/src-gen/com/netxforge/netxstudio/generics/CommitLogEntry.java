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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Commit Log Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Represents the changes done by a user for a certain object/user.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.CommitLogEntry#getAction <em>Action</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.CommitLogEntry#getChange <em>Change</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.CommitLogEntry#getObjectId <em>Object Id</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.CommitLogEntry#getTimeStamp <em>Time Stamp</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.CommitLogEntry#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCommitLogEntry()
 * @model extendedMetaData="name='CommitLogEntry' kind='empty'"
 * @extends CDOObject
 * @generated
 */
public interface CommitLogEntry extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.generics.ActionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Action type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see com.netxforge.netxstudio.generics.ActionType
	 * @see #isSetAction()
	 * @see #unsetAction()
	 * @see #setAction(ActionType)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCommitLogEntry_Action()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Action'"
	 * @generated
	 */
	ActionType getAction();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.CommitLogEntry#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see com.netxforge.netxstudio.generics.ActionType
	 * @see #isSetAction()
	 * @see #unsetAction()
	 * @see #getAction()
	 * @generated
	 */
	void setAction(ActionType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.generics.CommitLogEntry#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAction()
	 * @see #getAction()
	 * @see #setAction(ActionType)
	 * @generated
	 */
	void unsetAction();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.generics.CommitLogEntry#getAction <em>Action</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Action</em>' attribute is set.
	 * @see #unsetAction()
	 * @see #getAction()
	 * @see #setAction(ActionType)
	 * @generated
	 */
	boolean isSetAction();

	/**
	 * Returns the value of the '<em><b>Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The type uri of the object being changed
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Change</em>' attribute.
	 * @see #setChange(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCommitLogEntry_Change()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Change'"
	 * @generated
	 */
	String getChange();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.CommitLogEntry#getChange <em>Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change</em>' attribute.
	 * @see #getChange()
	 * @generated
	 */
	void setChange(String value);

	/**
	 * Returns the value of the '<em><b>Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The id/uri of the object being changed
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object Id</em>' attribute.
	 * @see #setObjectId(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCommitLogEntry_ObjectId()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='ObjectId'"
	 * @generated
	 */
	String getObjectId();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.CommitLogEntry#getObjectId <em>Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Id</em>' attribute.
	 * @see #getObjectId()
	 * @generated
	 */
	void setObjectId(String value);

	/**
	 * Returns the value of the '<em><b>Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TimeStamp attribute holds the time of the commit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Time Stamp</em>' attribute.
	 * @see #setTimeStamp(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCommitLogEntry_TimeStamp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='TimeStamp'"
	 * @generated
	 */
	XMLGregorianCalendar getTimeStamp();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.CommitLogEntry#getTimeStamp <em>Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Stamp</em>' attribute.
	 * @see #getTimeStamp()
	 * @generated
	 */
	void setTimeStamp(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					The user name
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>User</em>' attribute.
	 * @see #setUser(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCommitLogEntry_User()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='User'"
	 * @generated
	 */
	String getUser();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.CommitLogEntry#getUser <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' attribute.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(String value);

} // CommitLogEntry
