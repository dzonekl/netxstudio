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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getJobExecution <em>Job Execution</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getJobKind <em>Job Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getStart <em>Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob()
 * @model extendedMetaData="name='Job' kind='elementOnly'"
 * @generated
 */
public interface Job extends EObject {
	/**
	 * Returns the value of the '<em><b>Job Execution</b></em>' attribute list.
	 * The list contents are of type {@link javax.xml.datatype.XMLGregorianCalendar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Execution</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Execution</em>' attribute list.
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_JobExecution()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='element' name='JobExecution'"
	 * @generated
	 */
	EList<XMLGregorianCalendar> getJobExecution();

	/**
	 * Returns the value of the '<em><b>Job Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.scheduling.JobKinds}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.scheduling.JobKinds
	 * @see #isSetJobKind()
	 * @see #unsetJobKind()
	 * @see #setJobKind(JobKinds)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_JobKind()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='element' name='JobKind'"
	 * @generated
	 */
	JobKinds getJobKind();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getJobKind <em>Job Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.scheduling.JobKinds
	 * @see #isSetJobKind()
	 * @see #unsetJobKind()
	 * @see #getJobKind()
	 * @generated
	 */
	void setJobKind(JobKinds value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getJobKind <em>Job Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetJobKind()
	 * @see #getJobKind()
	 * @see #setJobKind(JobKinds)
	 * @generated
	 */
	void unsetJobKind();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getJobKind <em>Job Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Job Kind</em>' attribute is set.
	 * @see #unsetJobKind()
	 * @see #getJobKind()
	 * @see #setJobKind(JobKinds)
	 * @generated
	 */
	boolean isSetJobKind();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_Start()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Date"
	 *        extendedMetaData="kind='attribute' name='Start'"
	 * @generated
	 */
	XMLGregorianCalendar getStart();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(XMLGregorianCalendar value);

} // Job
